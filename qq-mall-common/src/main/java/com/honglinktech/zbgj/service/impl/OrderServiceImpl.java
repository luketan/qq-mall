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
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

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
		List<ShoppingCartBean> shoppingCartBeanList;
		if(map.containsKey("goodsId") && map.containsKey("num")){
			//TODO 直接购买
			int goodsId = Integer.valueOf(map.get("goodsId").toString());
			Goods goods = goodsDao.findById(goodsId);
			
			ShoppingCartBean scb = new ShoppingCartBean();
			scb.setNum(Integer.valueOf(map.get("num").toString()));
			scb.setGoodsId(goods.getId());
			scb.setGoodsName(goods.getName());
			scb.setImageUrl(goods.getImgUrl());
			scb.setMarkPrice(goods.getMarkPrice());
			scb.setPrice(goods.getPrice());
			scb.setGoodsTypeId(goods.getTypeId());
			//规格
			if(map.containsKey("formatSubIds")){
				List<Integer> formatSubIds = (List<Integer>)map.get("formatSubIds");
				if(formatSubIds!=null && formatSubIds.size()>0){
					List<FormatSubBean> formatSubBeans = formatSubDao.findFormatSubByIds(formatSubIds);
					scb.setFormatSubBeanList(formatSubBeans);
					//规格价格处理
					if(formatSubBeans != null){
						for(FormatSubBean fsb:formatSubBeans){
							if(fsb.getNeedPrice()){
								scb.setPrice(fsb.getPrice());
							}
						}
					}
				}
			}
			
			shoppingCartBeanList = new ArrayList<ShoppingCartBean>();
			shoppingCartBeanList.add(scb);
			
		}else{
			//商品信息 - 购物车提取
			Map scWhereMap = new HashMap();
			scWhereMap.put("userId", userId);
			scWhereMap.put("checkbox", 1);
			Response<List<ShoppingCartBean>> scResponse = shoppingCartService.findShoppingBeansByMap(scWhereMap);
			shoppingCartBeanList = scResponse.getResult();
		}
		restultMap.put("shoppingCarts", shoppingCartBeanList);
		
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
		
		//type(1打折,2包邮,3赠送,4满减)
		//优惠金额
		BigDecimal lostMoney = new BigDecimal(0);
		BigDecimal lostPostMoney = new BigDecimal(0);
		List<ActivityBean> activityBeans = new ArrayList<ActivityBean>();
		if(shoppingCartBeanList!=null){
			List<Integer> goodsIds = new ArrayList<Integer>();
			for(ShoppingCartBean scb:shoppingCartBeanList){
				goodsIds.add(scb.getGoodsId());
			}
			List<ActivityBean> activityBeanList = activityDao.findActivityByGoodsIds(goodsIds);
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
		}
		restultMap.put("activityList", activityBeans);
		//活动结束
		
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
	 * 生成订单
	 * @param userId
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<Map<String, Object>> saveSubmitOrder(Integer userId, Map<String, Object> map) throws BaseException {
		List<ShoppingCartBean> shoppingCartBeanList;
		boolean isByShoppingCart = false;
		if(map.containsKey("goodsId") && map.containsKey("num")){
			//直接购买
			int goodsId = Integer.valueOf(map.get("goodsId").toString());
			Goods goods = goodsDao.findById(goodsId);
			
			ShoppingCartBean scb = new ShoppingCartBean();
			scb.setNum(Integer.valueOf(map.get("num").toString()));
			scb.setGoodsId(goods.getId());
			scb.setGoodsName(goods.getName());
			scb.setImageUrl(goods.getImgUrl());
			scb.setMarkPrice(goods.getMarkPrice());
			scb.setPrice(goods.getPrice());
			scb.setGoodsTypeId(goods.getTypeId());
			//规格
			if(map.containsKey("formatSubIds")){
				List<Integer> formatSubIds = (List<Integer>)map.get("formatSubIds");
				if(formatSubIds!=null && formatSubIds.size()>0){
					List<FormatSubBean> formatSubBeans = formatSubDao.findFormatSubByIds(formatSubIds);
					scb.setFormatSubBeanList(formatSubDao.findFormatSubByIds(formatSubIds));
					//规格价格处理
					if(formatSubBeans != null){
						for(FormatSubBean fsb:formatSubBeans){
							if(fsb.getNeedPrice()){
								scb.setPrice(fsb.getPrice());
							}
						}
					}
				}
			}
			
			shoppingCartBeanList = new ArrayList<ShoppingCartBean>();
			shoppingCartBeanList.add(scb);
			
		}else{
			isByShoppingCart = true;
			//商品信息 - 购物车提取
			Map<String,Object> scWhereMap = new HashMap<String, Object>();
			scWhereMap.put("userId", userId);
			scWhereMap.put("checkbox", 1);
			Response<List<ShoppingCartBean>> scResponse = shoppingCartService.findShoppingBeansByMap(scWhereMap);
			shoppingCartBeanList = scResponse.getResult();
			
		}
		
		Order order = new Order();
		order.setUserId(userId);
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
//		List<OrderItemFormat> torderItemFormats = new ArrayList<OrderItemFormat>();
//		List<OrderActivity> torderActivitys = new ArrayList<OrderActivity>();
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
				//格式化单品的规格，用与订单
				String formats="";
				List<FormatSubBean> formatSubBeanList = scb.getFormatSubBeanList();
				if(formatSubBeanList != null && formatSubBeanList.size() > 0){
					formats="规格：";
					for(FormatSubBean formatSubBean:formatSubBeanList){
						formats+=formatSubBean.getName()+"/";
					}
					formats = formats.substring(0,formats.length()-1);
				}
				OrderItem torderItem = new OrderItem();
				torderItem.setGoodsId(scb.getGoodsId());
				torderItem.setGoodsImg(scb.getImageUrl());
				torderItem.setGoodsName(scb.getGoodsName());
				torderItem.setNum(scb.getNum());
				torderItem.setPrice(scb.getPrice());
				torderItem.setMarketPrice(scb.getMarkPrice());
				torderItem.setFormats(formats);
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
			List<ActivityBean> activityBeanList = activityDao.findActivityByGoodsIds(goodsIds);
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
		order.setLostMoney(lostMoney);
		order.setPostMoney(Constants.POST_MONEY);
		BigDecimal totalMoney = goodsTotalPrice.add(Constants.POST_MONEY).subtract(lostPostMoney).subtract(couponMoney).subtract(lostMoney);
		order.setTotalMoney(totalMoney);
		order.setMoney(goodsTotalPrice);
		//ordercode
		String header = "";
        String format = sdf.format(new Date());
        String random = RandomUtil.genRandomSmscode(4);
        String orderCode = String.format("%s%s%s", header, format, random);
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
		if(isByShoppingCart){
			ShoppingCart sc = new ShoppingCart();
			sc.setCheckbox(1);
			sc.setUserId(userId);
			shoppingCartDao.deleteByUserIdAndCheck(userId);
		}
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
	 * @param index
	 * @param size
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<List<OrderVO>> findOrderVOList(Integer userId, Integer index, Integer size) throws BaseException{

		Map whereMap = new HashMap();
		whereMap.put("userId", new String[]{String.valueOf(userId)});
		whereMap.put("deleteFlag", 0);
		whereMap.put("orderBy", "status");
		whereMap.put("asc", "asc");
		whereMap.put("start", (index-1)*size);
		whereMap.put("rows", size);

		List<Order> orderBeans = orderDao.findOrderByWhere(whereMap);
		List<OrderVO> orderVOs = new ArrayList<>();
		if(orderBeans!=null){
			for(Order order:orderBeans){
				OrderVO orderVO = order.toVO();
				List<OrderItem> orderItems = orderItemDao.findByOrderId(orderVO.getId());
				List<OrderItemBean> orderItemBeanList = new ArrayList<>();
				if(orderItems != null){
					for(OrderItem orderItem:orderItems){
						orderItemBeanList.add(orderItem.toBean());
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
		List<OrderItemBean> orderItemBeanList = new ArrayList<>();
		if(orderItems != null){
			for(OrderItem orderItem:orderItems){
				orderItemBeanList.add(orderItem.toBean());
			}
		}
		orderVO.setOrderItems(orderItemBeanList);

		
		//TODO 活动，购物券，红包处理
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
	 * @param order
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
	 * consle
	 * @param order
	 * @return
	 */
	@Override
	public Response<Integer> updateOrder(Order order) {
		if (order == null || order.getId() == null || order.getId() <= 0) {
			return Result.fail(ExceptionEnum.ORDER_UPDATE_STATUS_ERROR,JSON.toJSONString(order));
		}
		int result = orderDao.update(order);
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
				orderItemBeanList.add(orderItem.toBean());
			}
			orderBean.setOrderItemBeanList(orderItemBeanList);
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
	public Page<OrderSimpleBean> findOrderPage(Integer index, Integer size, Map whereMap, String url) {
		if(whereMap == null){
			whereMap = new HashMap();
		}
		int start = index!=null && index>=0?(index-1)*size:size;
		whereMap.put("start", (index-1)*size);
		whereMap.put("rows", size);

		List<OrderSimpleBean> orders = orderDao.findByWhere(whereMap);

		int count = orderDao.findCount(whereMap);
		return new Page<>(start, size, count, url,orders);
	}

	@Override
	public byte[] exportOrder(Map whereMap) {

		return new byte[0];
	}

}
