package com.honglinktech.zbgj.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.*;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.*;
import com.honglinktech.zbgj.entity.*;
import com.honglinktech.zbgj.enums.OrderStatusEnum;
import com.honglinktech.zbgj.service.*;
import com.honglinktech.zbgj.utils.RandomUtil;
import com.honglinktech.zbgj.vo.ActivityVO;
import com.honglinktech.zbgj.vo.CouponUserVO;
import com.honglinktech.zbgj.vo.OrderItemVO;
import com.honglinktech.zbgj.vo.OrderVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class OrderServiceImpl implements OrderService{

	protected final Logger logger = LogManager.getLogger(getClass());

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private PostDetailDao postDetailDao;
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private ShoppingCartDao shoppingCartDao;
	@Autowired
	private UserAddressService userAddressService;
	@Autowired
	private UserAddressDao userAddressDao;
	@Autowired
	private GoodsActivityDao activityDao;
	@Resource
	private CouponDao couponDao;
	@Resource
	private CouponService couponService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private GoodsDao goodsDao;
	@Resource
	private FormatSubDao formatSubDao;
	@Resource
	private PaymentUserDao paymentUserDao;
	@Resource
	private PaymentDao paymentDao;
	@Resource
	private CouponUserDao couponUserDao;
	@Resource
	private PostDetailService postDetailService;
	@Resource
	private PostCompanyDao postCompanyDao;
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 准备直接购买订单
	 * @param userId
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<Map<String, Object>> findZhiJieOrderView(Integer userId, Map map) throws BaseException {
		if(!map.containsKey("goodsId")){
			return Result.fail("商品ID不能为空！");
		}
		if(!map.containsKey("num")){
			return Result.fail("商品数量不能为空！");
		}
		Map<String, Object> restultMap = new HashMap<String, Object>();
		List<ShoppingCartBean> shoppingCartBeanList = null;

		int goodsId = Integer.valueOf(map.get("goodsId").toString());
		Goods goods = goodsDao.findById(goodsId);

		ShoppingCartBean newScb = new ShoppingCartBean();
		newScb.setNum(Integer.valueOf(map.get("num").toString()));
		newScb.setGoodsId(goods.getId());
		newScb.setGoodsName(goods.getName());
		newScb.setImageUrl(goods.getImgUrl());
		newScb.setMarkPrice(goods.getMarkPrice());
		newScb.setPrice(goods.getPrice());
		newScb.setGoodsTypeId(goods.getTypeId());
		//规格
		if(map.containsKey("formatSubIds")){
			List<Integer> formatSubIds = (List<Integer>)map.get("formatSubIds");
			if(formatSubIds!=null && formatSubIds.size()>0){
				List<FormatSubBean> formatSubBeans = formatSubDao.findFormatSubByIds(formatSubIds);
				newScb.setFormatSubBeanList(formatSubBeans);
				//规格价格处理
				if(formatSubBeans != null){
					for(FormatSubBean fsb:formatSubBeans){
						if(fsb.getNeedPrice()){
							newScb.setPrice(fsb.getPrice());
						}
					}
				}
			}
		}

		List<ActivityBean> activityBeanList = activityDao.findActivityByGoodsId(goods.getId());
		//type(1打折,2包邮,3赠送,4满减)
		//优惠金额
		BigDecimal lostMoney = new BigDecimal(0);
		//快递金额
		BigDecimal lostPostMoney = new BigDecimal(0);
		//商品总价格
		BigDecimal goodsTotalPrice = new BigDecimal(0);
		List<ActivityBean> activityBeans = new ArrayList<ActivityBean>();

		if(activityBeanList != null){
			for(ActivityBean activityBean:activityBeanList){
				if(activityBean.getMax() == 0 || goodsTotalPrice.doubleValue() > activityBean.getMax()){
					if(activityBean.getType() == 1){//1打折,2包邮,3赠送
						BigDecimal zekou = goodsTotalPrice.
								subtract(goodsTotalPrice.
										multiply(new BigDecimal(activityBean.getValue())).
										divide(new BigDecimal(10),2,BigDecimal.ROUND_HALF_UP));
						if(lostMoney.doubleValue()<zekou.doubleValue()){
							lostMoney = zekou;
						}
					}else if(activityBean.getType() == 2){//1打折,2包邮,3赠送
						lostPostMoney = Constants.POST_MONEY;
					}else if(activityBean.getType() == 4){//1打折,2包邮,3赠送
						if(lostMoney.doubleValue() < activityBean.getValue()){
							lostMoney = new BigDecimal( activityBean.getValue());
						}
					}
					activityBeans.add(activityBean);
				}
			}
		}
		newScb.setActivityBeanList(activityBeans);
		//活动结束


		shoppingCartBeanList = new ArrayList<ShoppingCartBean>();
		shoppingCartBeanList.add(newScb);

		restultMap.put("shoppingCarts", shoppingCartBeanList);

		//优惠券-筛选可用的购物券
		//每种类型的商品总价格
		Map<String,BigDecimal> goodsTypeValueMap = new HashMap<String, BigDecimal>();

		if(shoppingCartBeanList!=null){//统计每种类型的商品的总价格，用于优惠券选择
			for(ShoppingCartBean scb:shoppingCartBeanList){
				goodsTotalPrice = goodsTotalPrice.add(scb.getPrice().multiply(new BigDecimal(scb.getNum())));
				if(!goodsTypeValueMap.containsKey(scb.getGoodsTypeId()+"")){
					goodsTypeValueMap.put(scb.getGoodsTypeId()+"", scb.getPrice().multiply(new BigDecimal(scb.getNum())));
				}else{
					BigDecimal goodsTypeValue = goodsTypeValueMap.get(scb.getGoodsTypeId()+"");
					BigDecimal value = goodsTypeValue.add(scb.getPrice().multiply(new BigDecimal(scb.getNum())));
					goodsTypeValueMap.put(scb.getGoodsTypeId()+"", value);
				}
			}
		}
		Response<List<Coupon>> respCoupon = couponService.findCoupons(userId, null, null, 1);
		List<Coupon> couponList = respCoupon.getResult();
		List<CouponBean> couponBeanList = new ArrayList<CouponBean>();
		if(couponList!=null){
			for(Coupon coupon:couponList){
				CouponBean couponBean = new CouponBean(coupon);
				if(coupon.getGoodsType()==0){
					if(coupon.getMax()==0 || goodsTotalPrice.doubleValue() >= goodsTotalPrice.doubleValue()){
						couponBean.setSelect(true);
					}
				}else if(goodsTypeValueMap.containsKey(coupon.getGoodsType()+"")){
					double value = goodsTypeValueMap.get(coupon.getGoodsType()+"").doubleValue();
					if(value>=coupon.getMax() || coupon.getMax()==0){
						couponBean.setSelect(true);
					}
				}
				couponBeanList.add(couponBean);
			}
		}
		restultMap.put("couponList", couponBeanList);
		//筛选可用的购物券


		//支付方式
		Map paymentMap = new HashMap();
		paymentMap.put("userId", userId);
		List<PaymentBean> paymentBeans = paymentDao.findBeanByWhere(paymentMap);
		restultMap.put("payments", paymentBeans);
		//运费
		restultMap.put("postMoney", Constants.POST_MONEY);
		//免运费
		restultMap.put("lostPostMoney", lostPostMoney);
		//优惠减免
		restultMap.put("lostMoney", lostMoney);
		//总价
		restultMap.put("goodsTotalPrice", goodsTotalPrice);

		//地址
		Map addressWhereMap = new HashMap();
		addressWhereMap.put("userId", userId);
		addressWhereMap.put("status", 1);
		List<UserAddress> userAddressList = userAddressDao.findByWhere(addressWhereMap);

		restultMap.put("userAddressList", userAddressList);

		return Result.resultSet(restultMap);
	}
	/**
	 * 准备订单
	 * @param userId
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<Map<String, Object>> findOrderView(Integer userId, Map map) throws BaseException {
		Map<String, Object> restultMap = new HashMap<String, Object>();

		//商品信息 - 购物车提取
		Map scWhereMap = new HashMap();
		scWhereMap.put("userId", userId);
		scWhereMap.put("checkbox", 1);
		Response<List<ShoppingCartBean>> scResponse = shoppingCartService.findShoppingBeansByMap(scWhereMap);
		List<ShoppingCartBean> shoppingCartBeanList = scResponse.getResult();
		if(shoppingCartBeanList == null || shoppingCartBeanList.size() <= 0){
			return Result.fail("没找到购物车商品");
		}

		//type(1打折,2包邮,3赠送,4满减)
		//优惠金额
		BigDecimal lostMoney = new BigDecimal(0);
		BigDecimal lostPostMoney = new BigDecimal(0);
		//商品总价格
		BigDecimal goodsTotalPrice = new BigDecimal(0);

		for (ShoppingCartBean scb : shoppingCartBeanList) {
			List<ActivityBean> activityBeanList = activityDao.findActivityByGoodsId(scb.getGoodsId());
			if(activityBeanList != null){
				for(ActivityBean activityBean:activityBeanList){
					if(activityBean.getMax() == 0 || goodsTotalPrice.doubleValue() > activityBean.getMax()){
						if(activityBean.getType() == 1){//1打折,2包邮,3赠送
							BigDecimal zekou = goodsTotalPrice.
									subtract(goodsTotalPrice.
											multiply(new BigDecimal(activityBean.getValue())).
											divide(new BigDecimal(10),2,BigDecimal.ROUND_HALF_UP));
							if(lostMoney.doubleValue()<zekou.doubleValue()){
								lostMoney = zekou;
							}
						}else if(activityBean.getType() == 2){//1打折,2包邮,3赠送
							lostPostMoney = Constants.POST_MONEY;
						}else if(activityBean.getType() == 4){//1打折,2包邮,3赠送
							if(lostMoney.doubleValue() < activityBean.getValue()){
								lostMoney = new BigDecimal( activityBean.getValue());
							}
						}
					}
				}
				scb.setActivityBeanList(activityBeanList);
			}
		}
		//活动结束

		restultMap.put("shoppingCarts", shoppingCartBeanList);
		
		//优惠券-筛选可用的购物券
		//每种类型的商品总价格
		Map<String,BigDecimal> goodsTypeValueMap = new HashMap<String, BigDecimal>();
		if(shoppingCartBeanList!=null){//统计每种类型的商品的总价格，用于优惠券选择
			for(ShoppingCartBean scb:shoppingCartBeanList){
				goodsTotalPrice = goodsTotalPrice.add(scb.getPrice().multiply(new BigDecimal(scb.getNum())));
				if(!goodsTypeValueMap.containsKey(scb.getGoodsTypeId()+"")){
					goodsTypeValueMap.put(scb.getGoodsTypeId()+"", scb.getPrice().multiply(new BigDecimal(scb.getNum())));
				}else{
					BigDecimal goodsTypeValue = goodsTypeValueMap.get(scb.getGoodsTypeId()+"");
					BigDecimal value = goodsTypeValue.add(scb.getPrice().multiply(new BigDecimal(scb.getNum())));
					goodsTypeValueMap.put(scb.getGoodsTypeId()+"", value);
				}
			}
		}
		Response<List<Coupon>> respCoupon = couponService.findCoupons(userId, null, null, 1);
		List<Coupon> couponList = respCoupon.getResult();
		List<CouponBean> couponBeanList = new ArrayList<CouponBean>();
		if(couponList!=null){
			for(Coupon coupon:couponList){
				CouponBean couponBean = new CouponBean(coupon);
				if(coupon.getGoodsType()==0){
					if(coupon.getMax()==0 || goodsTotalPrice.doubleValue() >= goodsTotalPrice.doubleValue()){
						couponBean.setSelect(true);
					}
				}else if(goodsTypeValueMap.containsKey(coupon.getGoodsType()+"")){
					double value = goodsTypeValueMap.get(coupon.getGoodsType()+"").doubleValue();
					if(value>=coupon.getMax() || coupon.getMax()==0){
						couponBean.setSelect(true);
					}
				}
				couponBeanList.add(couponBean);
			}
		}
		restultMap.put("couponList", couponBeanList);
		//筛选可用的购物券
		
		//支付方式
		Map paymentMap = new HashMap();
		paymentMap.put("userId", userId);
		List<PaymentBean> paymentBeans = paymentDao.findBeanByWhere(paymentMap);
		restultMap.put("payments", paymentBeans);
		//运费
		restultMap.put("postMoney", Constants.POST_MONEY);
		//免运费
		restultMap.put("lostPostMoney", lostPostMoney);
		//优惠减免
		restultMap.put("lostMoney", lostMoney);
		//总价
		restultMap.put("goodsTotalPrice", goodsTotalPrice);
		
		//地址
		Map addressWhereMap = new HashMap();
		addressWhereMap.put("userId", userId);
		addressWhereMap.put("status", 1);
		List<UserAddress> userAddressList = userAddressDao.findByWhere(addressWhereMap);
		restultMap.put("userAddressList", userAddressList);
		
		return Result.resultSet(restultMap);
	}
	/**
	 * 直接购买
	 */
	@Override
	public Response<Map<String, Object>> saveZhiJieSubmitOrder(Integer userId, Map<String, Object> map) throws BaseException {
		boolean isByShoppingCart = false;
		if(map.containsKey("goodsId") && map.containsKey("num")){
			return Result.fail("提交错误！");
		}
		int num = Integer.valueOf(map.get("num").toString());
		int goodsId = Integer.valueOf(map.get("goodsId").toString());
		Goods goods = goodsDao.findById(goodsId);
		if(goods == null){
			return Result.fail("没找到商品");
		}
		//规格
		List<FormatSubBean> formatSubBeans = null;
		if(map.containsKey("formatSubIds")){
			List<Integer> formatSubIds = (List<Integer>)map.get("formatSubIds");
			if(formatSubIds!=null && formatSubIds.size()>0){
				formatSubBeans = formatSubDao.findFormatSubByIds(formatSubIds);
				//规格价格处理
				if(formatSubBeans != null){
					for(FormatSubBean fsb:formatSubBeans){
						if(fsb.getNeedPrice()){
							goods.setPrice(fsb.getPrice());
						}
					}
				}
			}
		}
		//活动
		List<ActivityBean> activityBeanList = activityDao.findActivityByGoodsId(goodsId);

		Order order = new Order();
		order.setUserId(userId);
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		//优惠券-筛选可用的购物券
		//每种类型的商品总价格
		Map<String,BigDecimal> goodsTypeValueMap = new HashMap<String, BigDecimal>();
		//商品总价格
		BigDecimal goodsTotalPrice = new BigDecimal(0);
		goodsTotalPrice = goodsTotalPrice.add(goods.getPrice().multiply(new BigDecimal(num)));
		if(!goodsTypeValueMap.containsKey(goods.getTypeId()+"")){
			goodsTypeValueMap.put(goods.getTypeId()+"", goods.getPrice().multiply(new BigDecimal(num)));
		}else{
			BigDecimal goodsTypeValue = goodsTypeValueMap.get(goods.getTypeId()+"");
			BigDecimal value = goodsTypeValue.add(goods.getPrice().multiply(new BigDecimal(num)));
			goodsTypeValueMap.put(goods.getTypeId()+"", value);
		}

		OrderItem torderItem = new OrderItem();
		torderItem.setGoodsId(goods.getId());
		torderItem.setGoodsImg(goods.getImgUrl());
		torderItem.setGoodsName(goods.getName());
		torderItem.setNum(num);
		torderItem.setPrice(goods.getPrice());
		torderItem.setMarketPrice(goods.getMarkPrice());
		torderItem.setFormats(JSON.toJSONString(formatSubBeans));
		torderItem.setActivitys(JSON.toJSONString(activityBeanList));
		orderItems.add(torderItem);

		BigDecimal couponMoney = new BigDecimal(0);
		int couponId = 0;//优惠券ID用于修改已经使用
		if(!StringUtils.isEmpty(map.get("couponId"))){
			Coupon coupon = couponService.findUserCoupon(userId, Integer.valueOf(map.get("couponId").toString()));
			if(coupon!=null){
				if(coupon.getGoodsType()==0){//全场适用
					if(coupon.getMax()==0 || goodsTotalPrice.doubleValue() >= goodsTotalPrice.doubleValue()){
						couponMoney = couponMoney.add(new BigDecimal(coupon.getValue()));
						order.setCouponId(coupon.getId());
//						order.setCoupon(coupon.getName()+"["+coupon.getCondition()+"]");
						couponId = coupon.getId();
					}
				}else if(goodsTypeValueMap.containsKey(coupon.getGoodsType()+"")){//指定商品类型使用
					double value = goodsTypeValueMap.get(coupon.getGoodsType()+"").doubleValue();
					if(value>=coupon.getMax() || coupon.getMax()==0){
						couponMoney = couponMoney.add(new BigDecimal(coupon.getValue()));
						order.setCouponId(coupon.getId());
//						order.setCoupon(coupon.getName()+"["+coupon.getCondition()+"]");
						couponId = coupon.getId();
					}
				}
			}
		}
		//筛选可用的购物券

		//type(1打折,2包邮,3赠送,4满减)
		//优惠金额
		BigDecimal lostMoney = new BigDecimal(0);
		BigDecimal lostPostMoney = new BigDecimal(0);

		if(activityBeanList != null){
			for(ActivityBean activityBean:activityBeanList){
				if(activityBean.getMax() == 0 || goodsTotalPrice.doubleValue() > activityBean.getMax()){
					if(activityBean.getType() == 1){//打折
						BigDecimal zekou = goodsTotalPrice.
								subtract(goodsTotalPrice.
										multiply(new BigDecimal(activityBean.getValue())).
										divide(new BigDecimal(10),2,BigDecimal.ROUND_HALF_UP));
						if(lostMoney.doubleValue()<zekou.doubleValue()){
							lostMoney = zekou;
						}
					}else if(activityBean.getType() == 2){//包邮
						lostPostMoney = Constants.POST_MONEY;
					}else if(activityBean.getType() == 4){//满减
						if(lostMoney.doubleValue() < activityBean.getValue()){
							lostMoney = new BigDecimal( activityBean.getValue());
						}
					}
				}
			}
		}
		//活动结束end


		Object addressId = map.get("addressId");
		Object paymentId = map.get("paymentId");
		//地址
		UserAddress address = userAddressDao.selectByPrimaryKey(Integer.valueOf(addressId.toString()));
		if(address == null){
			return Result.fail(ExceptionEnum.GOODS_ORDER_ADDRESS_NOT_FIND, addressId.toString());
		}
		order.setAddressId(address.getId());
		order.setAddress(address.getProvinceName()+address.getCityName()+address.getRegionName()+" "+address.getRoad());
		order.setUserPhone(address.getPhone());
		order.setUserName(address.getUserName());
		order.setLostMoney(lostMoney);
		order.setPostMoney(Constants.POST_MONEY);
		BigDecimal totalMoney = goodsTotalPrice.add(Constants.POST_MONEY).subtract(lostPostMoney).subtract(couponMoney).subtract(lostMoney);
		order.setTotalMoney(totalMoney);
		order.setMoney(goodsTotalPrice);
		//ordercode
		String header = "";
		String orderCode = String.format("%s%s%s", header, sdf.format(new Date()), RandomUtil.genRandomSmscode(4));
		order.setOrderCode(orderCode);
		order.setPayStatus(0);
		order.setRemark(String.valueOf(map.get("remark")));
		order.setStatus(OrderStatusEnum.waitPayment.getCode());
		order.setTotalMoney(totalMoney);
		//支付方式
		Map payMentMap = new HashMap();
		payMentMap.put("id", Integer.valueOf(paymentId.toString()));
		List<PaymentBean> payments = paymentDao.findBeanByWhere(payMentMap);
		if(payments == null || payments.size() == 0){
			return Result.fail(ExceptionEnum.GOODS_ORDER_PAYMENT_NOT_FIND, paymentId.toString());
		}
		PaymentBean payment = payments.get(0);
		order.setPaymentId(payment.getId());
		order.setPaymentName(payment.getName());
		int orderId = orderDao.insert(order);
		if(orderItems!=null){
			for(OrderItem orderItem:orderItems){
				orderItem.setOrderId(orderId);
			}
			orderItemDao.saveBatch(orderItems);
		}

		//使用优惠券
		if(couponId > 0){
			couponService.useCoupon(userId, couponId);
		}
		return Result.success();
	}
	/**
	 * 生成订单
	 * @param userId
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<Map<String, Object>> saveSubmitOrder(Integer userId, Map<String, Object> map) throws BaseException {
		List<ShoppingCartBean> shoppingCartBeanList;
		//商品信息 - 购物车提取
		Map<String,Object> scWhereMap = new HashMap<String, Object>();
		scWhereMap.put("userId", userId);
		scWhereMap.put("checkbox", 1);
		//购物车已经包含活动
		Response<List<ShoppingCartBean>> scResponse = shoppingCartService.findShoppingBeansByMap(scWhereMap);
		shoppingCartBeanList = scResponse.getResult();
		if(shoppingCartBeanList == null || shoppingCartBeanList.size() == 0){
			return Result.fail("购物车没找到商品！");
		}
		
		Order order = new Order();
		order.setUserId(userId);

		List<ActivityBean> totalActivityBeanList = new ArrayList<>();
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		//优惠券-筛选可用的购物券
		//每种类型的商品总价格
		Map<String,BigDecimal> goodsTypeValueMap = new HashMap<String, BigDecimal>();
		//商品总价格
		BigDecimal goodsTotalPrice = new BigDecimal(0);
		if(shoppingCartBeanList!=null){//统计每种类型的商品的总价格，用于优惠券选择
			for(ShoppingCartBean scb:shoppingCartBeanList){
				goodsTotalPrice = goodsTotalPrice.add(scb.getPrice().multiply(new BigDecimal(scb.getNum())));
				if(!goodsTypeValueMap.containsKey(scb.getGoodsTypeId()+"")){
					goodsTypeValueMap.put(scb.getGoodsTypeId()+"", scb.getPrice().multiply(new BigDecimal(scb.getNum())));
				}else{
					BigDecimal goodsTypeValue = goodsTypeValueMap.get(scb.getGoodsTypeId()+"");
					BigDecimal value = goodsTypeValue.add(scb.getPrice().multiply(new BigDecimal(scb.getNum())));
					goodsTypeValueMap.put(scb.getGoodsTypeId()+"", value);
				}

				//活动
				List<ActivityBean> activityBeanList = activityDao.findActivityByGoodsId(scb.getGoodsId());
				totalActivityBeanList.addAll(activityBeanList);

				OrderItem torderItem = new OrderItem();
				torderItem.setGoodsId(scb.getGoodsId());
				torderItem.setGoodsImg(scb.getImageUrl());
				torderItem.setGoodsName(scb.getGoodsName());
				torderItem.setNum(scb.getNum());
				torderItem.setPrice(scb.getPrice());
				torderItem.setMarketPrice(scb.getMarkPrice());
				torderItem.setFormats(JSON.toJSONString(scb.getFormatSubBeanList()));
				torderItem.setActivitys(JSON.toJSONString(activityBeanList));
				orderItems.add(torderItem);
			}
		}
		BigDecimal couponMoney = new BigDecimal(0);
		int couponId = 0;//优惠券ID用于修改已经使用
		if(!StringUtils.isEmpty(map.get("couponId"))){
			Coupon coupon = couponService.findUserCoupon(userId, Integer.valueOf(map.get("couponId").toString()));
			if(coupon!=null){
				if(coupon.getGoodsType()==0){//全场适用
					if(coupon.getMax()==0 || goodsTotalPrice.doubleValue() >= goodsTotalPrice.doubleValue()){
						couponMoney = couponMoney.add(new BigDecimal(coupon.getValue()));
						order.setCouponId(coupon.getId());
//						order.setCoupon(coupon.getName()+"["+coupon.getCondition()+"]");
						couponId = coupon.getId();
					}
				}else if(goodsTypeValueMap.containsKey(coupon.getGoodsType()+"")){//指定商品类型使用
					double value = goodsTypeValueMap.get(coupon.getGoodsType()+"").doubleValue();
					if(value>=coupon.getMax() || coupon.getMax()==0){
						couponMoney = couponMoney.add(new BigDecimal(coupon.getValue()));
						order.setCouponId(coupon.getId());
//						order.setCoupon(coupon.getName()+"["+coupon.getCondition()+"]");
						couponId = coupon.getId();
					}
				}
			}
		}
		//筛选可用的购物券
		
		//type(1打折,2包邮,3赠送,4满减)
		//优惠金额
		BigDecimal lostMoney = new BigDecimal(0);
		BigDecimal lostPostMoney = new BigDecimal(0);
		if(shoppingCartBeanList!=null){
			List<Integer> goodsIds = new ArrayList<Integer>();
			for(ShoppingCartBean scb:shoppingCartBeanList){
				goodsIds.add(scb.getGoodsId());
			}

			if(totalActivityBeanList != null){
				for(ActivityBean activityBean:totalActivityBeanList){
					if(activityBean.getMax() == 0 || goodsTotalPrice.doubleValue() > activityBean.getMax()){
						if(activityBean.getType() == 1){//打折
							BigDecimal zekou = goodsTotalPrice.
											subtract(goodsTotalPrice.
													multiply(new BigDecimal(activityBean.getValue())).
													divide(new BigDecimal(10),2,BigDecimal.ROUND_HALF_UP));
							if(lostMoney.doubleValue()<zekou.doubleValue()){
								lostMoney = zekou;
							}
						}else if(activityBean.getType() == 2){//包邮
							lostPostMoney = Constants.POST_MONEY;
						}else if(activityBean.getType() == 4){//满减
							if(lostMoney.doubleValue() < activityBean.getValue()){
								lostMoney = new BigDecimal( activityBean.getValue());
							}
						}
					}
				}
			}
		}
		//活动结束end
		
		Object addressId = map.get("addressId");
		Object paymentId = map.get("paymentId");
		//地址
		UserAddress address = userAddressDao.selectByPrimaryKey(Integer.valueOf(addressId.toString()));
		if(address == null){
			return Result.fail(ExceptionEnum.GOODS_ORDER_ADDRESS_NOT_FIND, addressId.toString());
		}
		order.setAddressId(address.getId());
		order.setAddress(address.getProvinceName()+address.getCityName()+address.getRegionName()+" "+address.getRoad());
		order.setUserName(address.getUserName());
		order.setUserPhone(address.getPhone());
		order.setLostMoney(lostMoney);
		order.setPostMoney(Constants.POST_MONEY);
		BigDecimal totalMoney = goodsTotalPrice.add(Constants.POST_MONEY).subtract(lostPostMoney).subtract(couponMoney).subtract(lostMoney);
		order.setTotalMoney(totalMoney);
		order.setMoney(goodsTotalPrice);
		//ordercode
		String header = "";
        String orderCode = String.format("%s%s%s", header, sdf.format(new Date()), RandomUtil.genRandomSmscode(4));
		order.setOrderCode(orderCode);
		order.setPayStatus(0);
		order.setRemark(String.valueOf(map.get("remark")));
		order.setStatus(OrderStatusEnum.waitPayment.getCode());
		order.setTotalMoney(totalMoney);
		//支付方式
		Map payMentMap = new HashMap();
		payMentMap.put("id", Integer.valueOf(paymentId.toString()));
		List<PaymentBean> payments = paymentDao.findBeanByWhere(payMentMap);
		if(payments == null || payments.size() == 0){
			return Result.fail(ExceptionEnum.GOODS_ORDER_PAYMENT_NOT_FIND, paymentId.toString());
		}
		PaymentBean payment = payments.get(0);
		order.setPaymentId(payment.getId());
		order.setPaymentName(payment.getName());
		int orderId = orderDao.insert(order);
		if(orderItems!=null){
			for(OrderItem orderItem:orderItems){
				orderItem.setOrderId(orderId);
			}
			orderItemDao.saveBatch(orderItems);
		}

		//修改优惠券已经使用了,清空已经购买了的购物车
		ShoppingCart sc = new ShoppingCart();
		sc.setCheckbox(1);
		sc.setUserId(userId);
		shoppingCartDao.deleteByUserIdAndCheck(userId);
		if(couponId > 0){
			couponService.useCoupon(userId, couponId);
		}
		return Result.success();
	}
	
	/**
	 * 选择支付方式
	 * @param userId
	 * @param paymentId
	 * @return
	 */
	@Override
	public Response<String> findCheckedPayment(Integer userId, Integer paymentId) {

		paymentUserDao.deleteByUsreId(userId);
		PaymentUser paymentUser = new PaymentUser();
		paymentUser.setPaymentId(paymentId);
		paymentUser.setUserId(userId);
		paymentUser.setChecked(1);
		int count = paymentUserDao.insertSelective(paymentUser);

		return Result.success();
	}

	/**
	 * APP获取订单列表
	 * @param userId
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<List<OrderVO>> findOrderVOList(Integer userId, Integer start, Integer rows) throws BaseException{

		Map whereMap = new HashMap();
		whereMap.put("userId", new String[]{String.valueOf(userId)});
		whereMap.put("deleteFlag", 0);
		whereMap.put("orderBy", "status");
		whereMap.put("asc", "asc");
		whereMap.put("start", start);
		whereMap.put("rows", rows);

		List<Order> orderBeans = orderDao.findOrderByWhere(whereMap);
		List<OrderVO> orderVOs = new ArrayList<>();
		if(orderBeans!=null){
			for(Order order:orderBeans){
				OrderVO orderVO = order.toVO();
				List<OrderItem> orderItems = orderItemDao.findByOrderId(orderVO.getId());
				List<OrderItemVO> orderItemBeanList = new ArrayList<>();
				if(orderItems != null){
					for(OrderItem orderItem:orderItems){
						orderItemBeanList.add(orderItem.toVO());
					}
				}
				orderVO.setOrderItems(orderItemBeanList);
				orderVOs.add(orderVO);
			}
		}
		
		return Result.resultSet(orderVOs);
	}

	/**
	 * APP获取订单的详情
	 * @param userId
	 * @param id
	 * @return
	 */
	@Override
	public Response<OrderVO> findOrderVOById(Integer userId, Integer id) {
		if(userId == null || userId<=0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR, "错误的请求！","userId",String.valueOf(userId));
		}
		if(id == null || id<=0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR, "错误的请求！","orderId",String.valueOf(id));
		}

		Order order = orderDao.findById(id);
		if(order == null){
			return Result.fail(ExceptionEnum.ORDER_NOT_EXIST_ERROR);
		}
		if(userId != null && order.getUserId().intValue() != userId.intValue()){
			return Result.fail(ExceptionEnum.COMMON_ERROE, "错误的请求！",order.getUserId()+"!="+userId);
		}

		
		OrderVO orderVO = order.toVO();
		List<OrderItem> orderItems = orderItemDao.findByOrderId(orderVO.getId());
		List<OrderItemVO> orderItemVOList = new ArrayList<>();
		if(orderItems != null){
			for(OrderItem orderItem:orderItems){
				OrderItemVO orderItemVO = orderItem.toVO();
				//活动处理
				if(orderItemVO.getActivitys() != null && orderItemVO.getActivitys().size() > 0){
					for(ActivityVO activityVO:orderItemVO.getActivitys()){
						if(activityVO.getType() != null) {
							activityVO.setTypeName(Constants.goodsActivityTypeName(activityVO.getType()));
						}
					}
				}
				orderItemVOList.add(orderItemVO);
			}
		}
		orderVO.setOrderItems(orderItemVOList);

		//优惠券
		if(orderVO.getCouponId() != null && orderVO.getCouponId() > 0){
			CouponUserVO couponUserVO =  couponUserDao.findUserCouponVOById(orderVO.getCouponId());
			orderVO.setCouponUserVO(couponUserVO);
		}

		
		//TODO 红包处理
		return Result.resultSet(orderVO);
	}

	/**
	 * APP获取快递信息
	 * @param postCode
	 * @return
	 */
	@Override
	public Response<List<PostDetail>> findPostDetail(String postCode) {
		Map whereMap = new HashMap();
		whereMap.put("postCode", postCode);
		whereMap.put("deleteFlag", "N");
		List<PostDetail> postDetailList = postDetailDao.findByWhere(whereMap);
		return Result.resultSet(postDetailList);
	}

	/***************************************************************************************/

	/**
	 * consle
	 * @return
	 */
	@Override
	public Response<Integer> deleteOrder(int orderId) {
		if (orderId <= 0) {
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR,"orderId", orderId+"");
		}
		int result = orderDao.deleteById(orderId);
		return Result.resultSet(result);
	}

	/**
	 * consle 取消订单
	 * @param order
	 * @return
	 */
	@Override
	public Response<Integer> updateCancleOrder(Order order) {
		if (order == null || order.getId() == null || order.getId() <= 0) {
			return Result.fail(ExceptionEnum.ORDER_UPDATE_STATUS_ERROR,JSON.toJSONString(order));
		}
		order.setStatus(OrderStatusEnum.Cancel.getCode());
		int result = orderDao.updateOrder(order);
		return Result.resultSet(result);
	}

	/**
	 * 修改发货状态
	 * @param order
	 * @return
     */
	@Override
	public Response<Integer> updateShipOrder(Order order) {
		if(order.getPostId() == null || order.getPostId()<0){
			return Result.fail("快递公司ID不能为空");
		}
		if(StringUtils.isEmpty(order.getPostCode())){
			return Result.fail("快递单号不能为空");
		}
		//订阅
		PostCompany postCompany = postCompanyDao.findById(order.getPostId());
		Response<String> response = postDetailService.subscribeService(postCompany.getCode(), order.getPostCode(), "", "");
		if(response.getCode() != 0){
			return Result.fail("快递100订阅失败！"+response.getMsg());
		}

		order.setStatus(OrderStatusEnum.Send.getCode());
		int result = orderDao.updateOrder(order);

		return Result.resultSet(result);
	}

	/**
	 * 修改完成订单
	 * @param order
	 * @return
     */
	@Override
	public Response<Integer> updateCompleteOrder(Order order) {
		order.setStatus(OrderStatusEnum.Complete.getCode());
		int result = orderDao.updateOrder(order);
		return Result.resultSet(result);
	}

	/**
	 * 修改基础信息
	 * consle
	 * @param order
	 * @return
	 */
	@Override
	public Response<Integer> updateOrder(Order order) {
		if (order == null || order.getId() == null || order.getId() <= 0) {
			return Result.fail(ExceptionEnum.ORDER_UPDATE_STATUS_ERROR,JSON.toJSONString(order));
		}
		int result = orderDao.updateOrder(order);
		return Result.resultSet(result);
	}

	/**
	 * consle
	 * @param id
	 * @return
	 */
	@Override
	public Response<OrderBean> findOrderBeanById(int id) {

		Order order = orderDao.findById(id);
		if(order == null){
			return Result.fail("订单不存在！");
		}
		OrderBean orderBean = order.toBean();
		List<OrderItem> orderItems = orderItemDao.findByOrderId(orderBean.getId());
		List<OrderItemBean> orderItemBeanList = new ArrayList<>();
		if(orderItems != null && orderItems.size() > 0){
			for(OrderItem orderItem:orderItems){
				OrderItemBean orderbItemBean = orderItem.toBean();
				if(orderbItemBean.getActivitys() != null && orderbItemBean.getActivitys().size() > 0){
					for(ActivityBean activityBean:orderbItemBean.getActivitys()){
						if(activityBean.getType() != null) {
							activityBean.setTypeName(Constants.goodsActivityTypeName(activityBean.getType()));
						}
					}
				}
				orderItemBeanList.add(orderbItemBean);
			}
			orderBean.setOrderItemBeanList(orderItemBeanList);
		}
		//优惠券
		if(orderBean.getCouponId() != null && orderBean.getCouponId() > 0){
			CouponUserBean couponUserBean =  couponUserDao.findUserCouponBeanById(orderBean.getCouponId());
			orderBean.setCouponUserBean(couponUserBean);
		}

		return Result.resultSet(orderBean);
	}

	/**
	 * consle
	 * @return
	 */
	@Override
	public int countNewOrder() {
		Map whereMap =  new HashMap();
		whereMap.put("status", OrderStatusEnum.WaitShip.getCode());
		int count = orderDao.findCount(whereMap);
		return count;
	}

	/**
	 * console
	 * @param whereMap
	 * @param url
	 * @return
	 */
	@Override
	public Page<OrderSimpleBean> findOrderPage(Integer start, Integer rows, Map whereMap, String url) {
		if(whereMap == null){
			whereMap = new HashMap();
		}

		whereMap.put("start", start);
		whereMap.put("rows", rows);

		List<OrderSimpleBean> orders = orderDao.findByWhere(whereMap);

		int count = orderDao.findCount(whereMap);
		return new Page<>(start, rows, count, url,orders);
	}

	@Override
	public byte[] exportOrder(Map whereMap) {

		return new byte[0];
	}

	public static void main(String[] str){
		FormatSubBean formatSubBean = new FormatSubBean();
		formatSubBean.setName("移动4G/联通4G/电信4G");
		formatSubBean.setId(67);
		formatSubBean.setFormatId(44);
		formatSubBean.setFormatName("网络");
		formatSubBean.setNeedPrice(false);
		formatSubBean.setSelect(1);

		FormatSubBean formatSubBean2 = new FormatSubBean();
		formatSubBean2.setName("国行");
		formatSubBean2.setId(68);
		formatSubBean2.setFormatId(45);
		formatSubBean2.setFormatName("版本");
		formatSubBean2.setNeedPrice(false);
		formatSubBean2.setSelect(1);

		FormatSubBean formatSubBean3 = new FormatSubBean();
		formatSubBean3.setName("整机清洁 ￥0.00");
		formatSubBean3.setId(68);
		formatSubBean3.setFormatId(46);
		formatSubBean3.setFormatName("服务");
		formatSubBean3.setNeedPrice(false);
		formatSubBean3.setSelect(1);


		FormatSubBean formatSubBean4 = new FormatSubBean();
		formatSubBean4.setName("贴膜服务 ￥9.90");
		formatSubBean4.setId(70);
		formatSubBean4.setFormatId(46);
		formatSubBean4.setFormatName("服务");
		formatSubBean4.setNeedPrice(false);
		formatSubBean4.setSelect(1);

		List<FormatSubBean> formatSubBeanList = new ArrayList<>();
		formatSubBeanList.add(formatSubBean);
		formatSubBeanList.add(formatSubBean2);
		formatSubBeanList.add(formatSubBean3);
		formatSubBeanList.add(formatSubBean4);

		System.out.println(JSON.toJSONString(formatSubBeanList));
	}
}
