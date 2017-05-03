package com.honglinktech.zbgj.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.bean.CouponBean;
import com.honglinktech.zbgj.bean.FormatSubBean;
import com.honglinktech.zbgj.bean.OrderBean;
import com.honglinktech.zbgj.bean.PaymentBean;
import com.honglinktech.zbgj.bean.ShoppingCartBean;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.CouponDao;
import com.honglinktech.zbgj.dao.FormatSubDao;
import com.honglinktech.zbgj.dao.OrderDao;
import com.honglinktech.zbgj.dao.OrderItemDao;
import com.honglinktech.zbgj.dao.PaymentDao;
import com.honglinktech.zbgj.dao.PaymentUserDao;
import com.honglinktech.zbgj.dao.PostDetailDao;
import com.honglinktech.zbgj.dao.UserAddressDao;
import com.honglinktech.zbgj.entity.Order;
import com.honglinktech.zbgj.entity.OrderItem;
import com.honglinktech.zbgj.entity.PostDetail;
import com.honglinktech.zbgj.enums.OrderStatusEnum;
import com.honglinktech.zbgj.utils.RandomUtil;

@Component
public class OrderService{

	@Autowired
	private OrderDao torderDao;
	@Autowired
	private OrderItemDao torderItemDao;
	@Autowired
	private UserAddressDao tuserAddressDao;
	@Autowired
	private PostDetailDao tpostDetailDao;
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private UserAddressService userAddressService;
	@Autowired
	private ActivityDao activityDao;
	@Resource
	private CouponDao couponDao;
	@Resource
	private CouponService couponService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private FormatSubDao formatSubDao;
	@Resource
	private PaymentUserDao tpaymentUserDao;
	@Resource
	private PaymentDao paymentDao;
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	/**
	 * 准备订单
	 * @param valueOf
	 * @return
	 * @throws BaseException 
	 */
	public Response<Map<String, Object>> AppReadyOrder(Integer userId,Map map) throws BaseException {
		Map<String, Object> restultMap = new HashMap<String, Object>();
		List<ShoppingCartBean> shoppingCartBeanList;
		if(map.containsKey("goodsId") && map.containsKey("num")){
			//TODO 直接购买
			int goodsId = Integer.valueOf(map.get("goodsId").toString());
			TGoods goods = goodsService.findById(goodsId);
			
			ShoppingCartBean scb = new ShoppingCartBean();
			scb.setNum(Integer.valueOf(map.get("num").toString()));
			scb.setGoodsId(goods.getId());
			scb.setGoodsName(goods.getName());
			scb.setImageUrl(goods.getImgUrl());
			scb.setMarkPrice(goods.getMarkPrice());
			scb.setPrice(goods.getPrice());
			scb.setGoodsTypeId(goods.getTypeId());
			scb.setGoodsTypeName(goods.getTypeName());
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
			//商品信息 - 购物车提取
			Map<String,Object> scWhereMap = new HashMap<String, Object>();
			scWhereMap.put(TShoppingCart.DBMaping.userId.name(),userId);
			scWhereMap.put(TShoppingCart.DBMaping.checkbox.name(),1);
			Response<List<ShoppingCartBean>> scResponse = shoppingCartService.findShoppingBeansGoodsInfoByMap(scWhereMap);
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
		Response<List<TCoupon>> respCoupon = couponService.findCoupons(userId, null, null, 1);
		List<TCoupon> couponList = respCoupon.getResult();
		List<CouponBean> couponBeanList = new ArrayList<CouponBean>();
		if(couponList!=null){
			for(TCoupon tcoupon:couponList){
				CouponBean couponBean = new CouponBean(tcoupon);
				if(tcoupon.getType()==0){
					if(tcoupon.getMax()==0 || goodsTotalPrice.doubleValue() >= goodsTotalPrice.doubleValue()){
						couponBean.setSelect(true);
					}
				}else if(goodsTypeValueMap.containsKey(tcoupon.getType()+"")){
					double value = goodsTypeValueMap.get(tcoupon.getType()+"").doubleValue();
					if(value>=tcoupon.getMax() || tcoupon.getMax()==0){
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
			List<ActivityBean> activityBeanList = activityDao.findActivityByGoodsId(goodsIds);
			if(activityBeanList != null){
				for(ActivityBean activityBean:activityBeanList){
					if(activityBean.getMax() == 0 || goodsTotalPrice.doubleValue() > activityBean.getMax()){
						if(activityBean.getType() == 1){
							BigDecimal zekou = goodsTotalPrice.
											subtract(goodsTotalPrice.
													multiply(new BigDecimal(activityBean.getValue())).
													divide(new BigDecimal(10),2,BigDecimal.ROUND_HALF_UP));
							if(lostMoney.doubleValue()<zekou.doubleValue()){
								lostMoney = zekou;
							}
						}else if(activityBean.getType() == 2){
							lostPostMoney = Constants.POST_MONEY;
						}else if(activityBean.getType() == 4){
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
		List<PaymentBean> paymentBeans = paymentDao.findBeanList(userId);
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
		Map<String,String[]> addressWhereMap = new HashMap<String, String[]>();
		addressWhereMap.put(TUserAddress.DBMaping.userId.name(), new String[]{userId+""});
		addressWhereMap.put(TUserAddress.DBMaping.status.name(), new String[]{"1"});
		List<TUserAddress> userAddressList = userAddressService.findByWhere(addressWhereMap);
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
	public Response<Map<String, Object>> submitOrder(Integer userId, Map<String, Object> map) throws BaseException {
		List<ShoppingCartBean> shoppingCartBeanList;
		boolean isByShoppingCart = false;
		if(map.containsKey("goodsId") && map.containsKey("num")){
			//直接购买
			int goodsId = Integer.valueOf(map.get("goodsId").toString());
			TGoods goods = goodsService.findById(goodsId);
			
			ShoppingCartBean scb = new ShoppingCartBean();
			scb.setNum(Integer.valueOf(map.get("num").toString()));
			scb.setGoodsId(goods.getId());
			scb.setGoodsName(goods.getName());
			scb.setImageUrl(goods.getImgUrl());
			scb.setMarkPrice(goods.getMarkPrice());
			scb.setPrice(goods.getPrice());
			scb.setGoodsTypeId(goods.getTypeId());
			scb.setGoodsTypeName(goods.getTypeName());
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
			scWhereMap.put(TShoppingCart.DBMaping.userId.name(),userId);
			scWhereMap.put(TShoppingCart.DBMaping.checkbox.name(),1);
			Response<List<ShoppingCartBean>> scResponse = shoppingCartService.findShoppingBeansGoodsInfoByMap(scWhereMap);
			shoppingCartBeanList = scResponse.getResult();
			
		}
		
		Order torder = new Order();
		torder.setUserId(userId);
		List<OrderItem> torderItems = new ArrayList<OrderItem>();
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
				torderItems.add(torderItem);
			}
		}
		BigDecimal couponMoney = new BigDecimal(0);
		int couponId = 0;//优惠券ID用于修改已经使用
		if(!StringUtils.isEmpty(map.get("couponId"))){
			TCoupon tcoupon = couponService.findUserCoupon(userId, Integer.valueOf(map.get("couponId").toString()));
			if(tcoupon!=null){
				if(tcoupon.getType()==0){//全场适用
					if(tcoupon.getMax()==0 || goodsTotalPrice.doubleValue() >= goodsTotalPrice.doubleValue()){
						couponMoney = couponMoney.add(new BigDecimal(tcoupon.getValue()));
						torder.setCouponId(tcoupon.getId());
						torder.setCoupon(tcoupon.getName()+"["+tcoupon.getCondition()+"]");
						couponId = tcoupon.getId();
					}
				}else if(goodsTypeValueMap.containsKey(tcoupon.getType()+"")){//指定商品类型使用
					double value = goodsTypeValueMap.get(tcoupon.getType()+"").doubleValue();
					if(value>=tcoupon.getMax() || tcoupon.getMax()==0){
						couponMoney = couponMoney.add(new BigDecimal(tcoupon.getValue()));
						torder.setCouponId(tcoupon.getId());
						torder.setCoupon(tcoupon.getName()+"["+tcoupon.getCondition()+"]");
						couponId = tcoupon.getId();
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
			List<ActivityBean> activityBeanList = activityDao.findActivityByGoodsId(goodsIds);
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
				Gson gson = new Gson();
				torder.setActivitys(gson.toJson(activityBeanList));
			}
		}
		//活动结束end
		
		Object addressId = map.get("addressId");
		Object paymentId = map.get("paymentId");
		//地址
		TUserAddress address = userAddressService.findById(Integer.valueOf(addressId.toString()));
		if(address == null){
			return Result.fail(ExceptionEnum.GOODS_ORDER_ADDRESS_NOT_FIND, addressId.toString());
		}
		torder.setAddressId(address.getId());
		torder.setAddress(address.getProvinceName()+address.getCityName()+address.getRegionName()+" "+address.getRoad());
		torder.setLostMoney(lostMoney);
		torder.setLostPostMoney(lostPostMoney);
		torder.setPostMoney(Constants.POST_MONEY);
		BigDecimal totalMoney = goodsTotalPrice.add(Constants.POST_MONEY).subtract(lostPostMoney).subtract(couponMoney).subtract(lostMoney);
		torder.setTotalMoney(totalMoney);
		torder.setMoney(goodsTotalPrice);
		//ordercode
		String header = "";
        String format = sdf.format(new Date());
        String random = RandomUtil.genRandomSmscode(4);
        String orderCode = String.format("%s%s%s", header, format, random);
		torder.setOrderCode(orderCode);
		torder.setPayStatus(0);
		torder.setRemark(String.valueOf(map.get("remark")));
		torder.setStatus(OrderStatusEnum.waitPayment.getCode());
		torder.setTotalMoney(totalMoney);
		//支付方式
		PaymentBean payment = paymentDao.findBeanById(Integer.valueOf(paymentId.toString()));
		if(payment == null){
			return Result.fail(ExceptionEnum.GOODS_ORDER_PAYMENT_NOT_FIND, paymentId.toString());
		}
		torder.setPaymentId(payment.getId());
		torder.setPaymentName(payment.getName());
		int orderId = torderDao.save(torder);
		if(torderItems!=null){
			for(OrderItem torderItem:torderItems){
				torderItem.setOrderId(orderId);
			}
			torderItemDao.saveBatch(torderItems);
		}
		//修改优惠券已经使用了,清空已经购买了的购物车
		if(isByShoppingCart){
			TShoppingCart sc = new TShoppingCart();
			sc.setCheckbox(1);
			sc.setUserId(userId);
			shoppingCartService.delete(sc);
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
	public Response<String> orderCheckedPayment(Integer userId, Integer paymentId) {
		
		try {
			
			TPaymentUser tpaymentUser = new TPaymentUser();
			tpaymentUser.setUserId(userId);
			tpaymentUserDao.delete(tpaymentUser);
			tpaymentUser.setPaymentId(paymentId);
			tpaymentUser.setChecked(1);
			tpaymentUserDao.save(tpaymentUser);
			
		} catch (BaseException e) {
			e.printStackTrace();
			Result.fail(ExceptionEnum.COMMON_DATEBASE_REFLEX_ERROE);
		}
		return Result.success();
	}

	
	public Response<List<OrderBean>> appFindOrderBeanList(Integer userId, Integer index, Integer size) throws BaseException{

		Map<String, String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(Order.DBMaping.userId.name(), new String[]{String.valueOf(userId)});
		whereMap.put(Order.DBMaping.deleteFlag.name(), new String[]{String.valueOf("0")});
		QueryHelper<Order> qh = new QueryHelper<Order>(whereMap);
		qh.setIndex(index);
		qh.setSize(size);
		Map<String, String> orderByMap = new HashMap<String, String>();
		orderByMap.put(Order.DBMaping.status.getDbName(),"asc");
		qh.setOrderBy(orderByMap);
		QueryHelper<Order> restQh = torderDao.findByQueryHelper(qh);
		
		List<OrderBean> orderBeanList = new ArrayList<OrderBean>();
		if(restQh.getResultList()!=null){
			for(Order torder:restQh.getResultList()){
				OrderBean orderBean = new OrderBean(torder);
				Map<String, String[]> orderItemWhere = new HashMap<String, String[]>();
				orderItemWhere.put(OrderItem.DBMaping.orderId.name(), new String[]{String.valueOf(orderBean.getId())});
				List<OrderItem> torderItems = torderItemDao.findByWhere(orderItemWhere);
				orderBean.setOrderItemList(torderItems);
				orderBeanList.add(orderBean);
			}
		}
		
		return Result.resultSet(orderBeanList);
	}

	public Response<OrderBean> appFindOrderBeanById(Integer userId,Integer id) {
		if(userId == null || userId.intValue()<=0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR, "错误的请求！","userId",String.valueOf(userId));
		}
		if(id == null || id.intValue()<=0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR, "错误的请求！","orderId",String.valueOf(id));
		}
		Map<String, String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(Order.DBMaping.userId.name(), new String[]{String.valueOf(userId)});
		whereMap.put(Order.DBMaping.id.name(), new String[]{String.valueOf(id)});

		Order torder = torderDao.findById(id);
		if(torder.getUserId().intValue() != userId.intValue()){
			return Result.fail(ExceptionEnum.COMMON_ERROE, "错误的请求！",torder.getUserId()+"!="+userId);
		}
		
		OrderBean orderBean = new OrderBean(torder);
		Map<String, String[]> orderItemWhere = new HashMap<String, String[]>();
		orderItemWhere.put(OrderItem.DBMaping.orderId.name(), new String[]{String.valueOf(orderBean.getId())});
		List<OrderItem> torderItems = torderItemDao.findByWhere(orderItemWhere);
		orderBean.setOrderItemList(torderItems);
		
		TUserAddress tuserAddress = tuserAddressDao.findById(orderBean.getAddressId());
		orderBean.setTuserAddress(tuserAddress);
		
		//TODO 活动，购物券，红包处理
		return Result.resultSet(orderBean);
	}

	public Response<List<PostDetail>> appFindPostDetail(String postCode) {
		Map<String, String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(PostDetail.DBMaping.postCode.name(), new String[]{postCode});
		whereMap.put(PostDetail.DBMaping.deleteFlag.name(), new String[]{"N"});
		List<PostDetail> postDetailList = tpostDetailDao.findByWhere(whereMap);
		return Result.resultSet(postDetailList);
	}

}
