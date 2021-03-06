package com.honglinktech.zbgj.service.impl;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.*;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.*;
import com.honglinktech.zbgj.entity.*;
import com.honglinktech.zbgj.enums.OrderPayStatusEnum;
import com.honglinktech.zbgj.enums.OrderStatusEnum;
import com.honglinktech.zbgj.service.*;
import com.honglinktech.zbgj.utils.RandomUtil;
import com.honglinktech.zbgj.vo.*;
import com.honglinktech.zbgj.vo.request.OrderReq;
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

	@Autowired
	private WxPayService wxPayService;
	@Autowired
	private UserSessionDao userSessionDao;
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 准备订单
	 * @param userId
	 * orderPayType: 1立即下单,0购物车下单
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<Map<String, Object>> findReadyOrder(Integer userId, OrderReq orderReq) throws Exception {
		Map<String, Object> restultMap = new HashMap<String, Object>();


		//type(1打折,2包邮,3赠送,4满减)
		//优惠金额
		BigDecimal lostMoney = new BigDecimal(0);
		//免邮费
		BigDecimal lostPostMoney = new BigDecimal(0);
		//商品总价格
		BigDecimal goodsTotalPrice = new BigDecimal(0);

		Map<String,BigDecimal> goodsTypeValueMap = new HashMap<String, BigDecimal>();

		//orderPayType: 1立即下单,0购物车下单
		if(orderReq.getOrderPayType() == 0){ //购物车下单

			//商品信息 - 购物车提取
			List<ShoppingCartVO> shoppingCartVOList = shoppingCartService.findShoppingsByIds(userId, orderReq.getShoppingCartIds());
			if(shoppingCartVOList == null || shoppingCartVOList.size() <= 0){
				return Result.fail("没找到购物车商品");
			}
			//优惠券-筛选可用的购物券
			//每种类型的商品总价格
			if(shoppingCartVOList !=null){//统计每种类型的商品的总价格，用于优惠券选择
				for(ShoppingCartVO scb: shoppingCartVOList){
					//加上规格的价格
					if(scb.getFormatSubList() != null){
						for(FormatSubBean formatSubBean : scb.getFormatSubList()){
							if(formatSubBean.getNeedPrice()){
								scb.setPrice(scb.getPrice().add(formatSubBean.getPrice()));
							}
						}
					}
					goodsTotalPrice = goodsTotalPrice.add(scb.getPrice().multiply(new BigDecimal(scb.getNum())));
					if(!goodsTypeValueMap.containsKey(scb.getGoodsTypeId()+"")){
						//规格价格
						goodsTypeValueMap.put(scb.getGoodsTypeId()+"", goodsTotalPrice);
					}else{
						//规格价格
						BigDecimal goodsTypeValue = goodsTypeValueMap.get(scb.getGoodsTypeId()+"");
						BigDecimal value = goodsTypeValue.add(goodsTotalPrice);
						goodsTypeValueMap.put(scb.getGoodsTypeId()+"", value);
					}
				}
			}
			//优惠券end

			//活动开始
			for (ShoppingCartVO scb : shoppingCartVOList) {
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
					scb.setActivityList(activityBeanList);
				}
			}
			//活动结束

			restultMap.put("shoppingCarts", shoppingCartVOList);
		}else{ //直接购买

			GoodsVO goodsVO = goodsService.findSimpleGoodsVOById(orderReq.getGoodsId());
			if(orderReq.getFormatSubIdList() != null && orderReq.getFormatSubIdList().size() > 0){
				List<FormatSubBean> formatSubs = formatSubDao.findFormatSubByIds(orderReq.getFormatSubIdList());
				if(formatSubs!= null && formatSubs.size() > 0){
					for(FormatSubBean formatSubBean : formatSubs){
						if(formatSubBean.getNeedPrice()){
							goodsVO.setPrice(goodsVO.getPrice().add(formatSubBean.getPrice()));
						}
					}
				}
			}

			goodsTotalPrice = goodsTotalPrice.add(goodsVO.getPrice().multiply(new BigDecimal(orderReq.getNum())));
			goodsTypeValueMap.put(goodsVO.getTypeId()+"", goodsTotalPrice);


			//
			if(goodsVO.getActivityList() != null){
				for(ActivityBean activityBean:goodsVO.getActivityList()){
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
			}
		}

		Response<List<CouponUserVO>>  respCoupon = couponService.findUserCoupons(userId, null, null, 1);
		List<CouponUserVO> couponUserList = respCoupon.getResult();
		if(couponUserList!=null){
			for(CouponUserVO couponUserVO :couponUserList){
				if(couponUserVO.getGoodsType()==null || couponUserVO.getGoodsType()==0){//全场
					if(couponUserVO.getMax()==0 || goodsTotalPrice.doubleValue() >= goodsTotalPrice.doubleValue()){
						couponUserVO.setSelect(true);
					}
				}else if(goodsTypeValueMap.containsKey(couponUserVO.getGoodsType()+"")){
					double value = goodsTypeValueMap.get(couponUserVO.getGoodsType()+"").doubleValue();
					if(value>= couponUserVO.getMax() || couponUserVO.getMax()==0){
						couponUserVO.setSelect(true);
					}
				}
			}
		}
		restultMap.put("couponList", couponUserList);
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

		//积分

		//红包

		return Result.resultSet(restultMap);
	}


	/**
	 * 生成订单
	 * @param userId
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response saveSubmitOrder(Integer userId, OrderReq orderReq) throws Exception {

		Order order = new Order();
		order.setUserId(userId);

		//所有优惠券
		List<ActivityBean> totalActivitys = new ArrayList<>();
		//订单券详情
		List<OrderItem> orderItems = new ArrayList<>();

		//购物车
		List<ShoppingCartVO> shoppingCartVOList = null;
		//orderPayType: 1立即下单,0购物车下单
		if(orderReq.getOrderPayType() == 0){
			//商品信息 - 购物车提取
			//购物车已经包含活动
			shoppingCartVOList = shoppingCartService.findShoppingsByIds(userId, orderReq.getShoppingCartIds());
			if(shoppingCartVOList == null || shoppingCartVOList.size() == 0){
				return Result.fail("购物车没找到商品！");
			}
		}else{
			GoodsVO goodsVO = goodsService.findSimpleGoodsVOById(orderReq.getGoodsId());
			if(goodsVO == null){
				return Result.fail("没有找到商品");
			}
			ShoppingCartVO shoppingCartVO = new ShoppingCartVO();
			shoppingCartVO.setGoodsId(goodsVO.getId());
			shoppingCartVO.setGoodsName(goodsVO.getName());
			shoppingCartVO.setImgUrl(goodsVO.getImgUrl());
			shoppingCartVO.setGoodsTypeId(goodsVO.getTypeId());
			shoppingCartVO.setMarkPrice(goodsVO.getMarkPrice());

//			logger.info("goodsVO.getPrice()========="+goodsVO.getPrice());
			shoppingCartVO.setPrice(goodsVO.getPrice());
			shoppingCartVO.setNum(orderReq.getNum());
			shoppingCartVO.setActivityList(goodsVO.getActivityList());
			if(orderReq.getFormatSubIdList() != null && orderReq.getFormatSubIdList().size() > 0){
				List<FormatSubBean> formatSubs = formatSubDao.findFormatSubByIds(orderReq.getFormatSubIdList());
				shoppingCartVO.setFormatSubList(formatSubs);
			}

			shoppingCartVOList = new ArrayList<>();
			shoppingCartVOList.add(shoppingCartVO);
		}


		//商品总价格
		BigDecimal goodsTotalPrice = new BigDecimal(0);
		//减免活动
		BigDecimal lostActivityMoney = new BigDecimal(0);
		//邮费减免
		BigDecimal lostPostMoney = new BigDecimal(0);
		//优惠券价格
		BigDecimal lostCouponMoney = new BigDecimal(0);

		//优惠券-筛选可用的购物券
		//每种类型的商品总价格
		Map<String, BigDecimal> goodsTypeValueMap = new HashMap<>();
		//统计每种类型的商品的总价格，用于优惠券选择
		for(ShoppingCartVO scb: shoppingCartVOList){
			//计算规格价格
			if(scb.getFormatSubList() != null){
				for(FormatSubBean formatSubBean : scb.getFormatSubList()){
					if(formatSubBean.getNeedPrice()){
//						logger.info("getPrice:"+scb.getPrice()+
//								"\nformatSubBean.getPrice():"+formatSubBean.getPrice());
						scb.setPrice(scb.getPrice().add(formatSubBean.getPrice()));
//						logger.info("##########################:"+scb.getPrice());
					}
				}
			}
			//
//			logger.info("goodsTotalPrice:"+goodsTotalPrice+
//					"\nscb.getPrice():"+scb.getPrice()
//					+"\nscb.getNum:"+scb.getNum()
//					+"\nmultiply:"+scb.getPrice().multiply(new BigDecimal(scb.getNum())));
			goodsTotalPrice = goodsTotalPrice.add(scb.getPrice().multiply(new BigDecimal(scb.getNum())));
			logger.info("goodsTotalPrice2:"+goodsTotalPrice);
			if(!goodsTypeValueMap.containsKey(scb.getGoodsTypeId()+"")){
				goodsTypeValueMap.put(scb.getGoodsTypeId()+"", scb.getPrice().multiply(new BigDecimal(scb.getNum())));
			}else{
				BigDecimal goodsTypeValue = goodsTypeValueMap.get(scb.getGoodsTypeId()+"");
				BigDecimal value = goodsTypeValue.add(scb.getPrice().multiply(new BigDecimal(scb.getNum())));
				goodsTypeValueMap.put(scb.getGoodsTypeId()+"", value);
			}

			//活动
			List<ActivityBean> activityBeanList = activityDao.findActivityByGoodsId(scb.getGoodsId());
			totalActivitys.addAll(activityBeanList);

			OrderItem orderItem = new OrderItem();
			orderItem.setGoodsId(scb.getGoodsId());
			orderItem.setGoodsImg(scb.getImgUrl());
			orderItem.setGoodsName(scb.getGoodsName());
			orderItem.setNum(scb.getNum());
			orderItem.setPrice(scb.getPrice());
			orderItem.setMarkPrice(scb.getMarkPrice());
			orderItem.setFormats(JSON.toJSONString(scb.getFormatSubList()));
			orderItem.setActivitys(JSON.toJSONString(activityBeanList));
			orderItems.add(orderItem);
		}

		//购物券处理
		int couponId = 0;//优惠券ID用于修改已经使用
		if(orderReq.getCouponUserId()>0){
			CouponUserVO couponUserVO = couponService.findUserCouponVO(userId, Integer.valueOf(orderReq.getCouponUserId()));
			if(couponUserVO!=null){
				if(couponUserVO.getGoodsType()==null || couponUserVO.getGoodsType()==0){//全场适用
					if(couponUserVO.getMax()==0 || goodsTotalPrice.doubleValue() >= goodsTotalPrice.doubleValue()){
						lostCouponMoney = lostCouponMoney.add(new BigDecimal(couponUserVO.getValue()));
						order.setCouponId(couponUserVO.getId());
//						order.setCoupon(couponUserVO.getName()+"["+couponUserVO.getCondition()+"]");
						couponId = couponUserVO.getId();
					}
				}else if(goodsTypeValueMap.containsKey(couponUserVO.getGoodsType()+"")){//指定商品类型使用
					double value = goodsTypeValueMap.get(couponUserVO.getGoodsType()+"").doubleValue();
					if(value>=couponUserVO.getMax() || couponUserVO.getMax()==0){
						lostCouponMoney = lostCouponMoney.add(new BigDecimal(couponUserVO.getValue()));
						order.setCouponId(couponUserVO.getId());
//						order.setCoupon(couponUserVO.getName()+"["+couponUserVO.getCondition()+"]");
						couponId = couponUserVO.getId();
					}
				}
			}
		}
		//购物券处理 end

		//活动处理
		//type(1打折,2包邮,3赠送,4满减)
		if(totalActivitys != null){
			for(ActivityBean activityBean:totalActivitys){
				if(activityBean.getMax() == 0 || goodsTotalPrice.doubleValue() > activityBean.getMax()){
					if(activityBean.getType() == 1){//打折
						BigDecimal zekou = goodsTotalPrice.
								subtract(goodsTotalPrice.
										multiply(new BigDecimal(activityBean.getValue())).
										divide(new BigDecimal(10),2,BigDecimal.ROUND_HALF_UP));
						if(lostActivityMoney.doubleValue()<zekou.doubleValue()){
							lostActivityMoney = zekou;
						}
					}else if(activityBean.getType() == 2){//包邮
						lostPostMoney = Constants.POST_MONEY;
					}else if(activityBean.getType() == 4){//满减
						if(lostActivityMoney.doubleValue() < activityBean.getValue()){
							lostActivityMoney = new BigDecimal( activityBean.getValue());
						}
					}
				}
			}
		}
		//活动结束end

		//地址处理
		int addressId = orderReq.getAddressId();
		if(orderReq.getAddressId() > 0){
			//地址
			UserAddress address = userAddressDao.findById(orderReq.getAddressId());
			if(address == null){
				return Result.fail("找不到地址");
			}
			order.setAddressId(address.getId());
			order.setAddress(address.getProvinceName()+address.getCityName()+address.getRegionName()+" "+address.getRoad());
			order.setUserName(address.getUserName());
			order.setUserPhone(address.getPhone());
		}else{
			order.setAddress(orderReq.getAddress());
			order.setUserName(orderReq.getUserName());
			order.setUserPhone(orderReq.getPhone());
		}
		//地址处理 end

		//支付处理
		Payment payment = paymentDao.findByCode(orderReq.getPaymentCode());
		if(payment == null){
			return Result.fail("没找到支付方式！");
		}
		order.setPaymentId(payment.getId());
		order.setPaymentName(payment.getName());

		order.setMoney(goodsTotalPrice);
		order.setLostActivityMoney(lostActivityMoney);
		order.setLostCouponMoney(lostCouponMoney);
		order.setPostMoney(Constants.POST_MONEY.subtract(lostPostMoney));
		BigDecimal totalMoney = goodsTotalPrice.add(Constants.POST_MONEY).subtract(lostPostMoney).subtract(lostCouponMoney).subtract(lostActivityMoney);
//		logger.info("\ngoodsTotalPrice:"+goodsTotalPrice
//				+"\nPOST_MONEY:"+Constants.POST_MONEY
//				+"\nlostPostMoney:"+lostPostMoney
//				+"\nlostCouponMoney:"+lostCouponMoney
//				+"\nlostActivityMoney:"+lostActivityMoney
//				+"\ntotalMoney:"+totalMoney);

		order.setTotalMoney(totalMoney);

		//ordercode
		String header = "";
        String orderCode = String.format("%s%s%s", header, sdf.format(new Date()), RandomUtil.genRandomSmscode(4));
		order.setOrderCode(orderCode);
		order.setPayStatus(OrderPayStatusEnum.waitPayment.getCode());
		order.setRemark(String.valueOf(orderReq.getRemark()));
		order.setForm(String.valueOf(orderReq.getForm()));
		order.setStatus(OrderStatusEnum.WaitPayment.getCode());
		order.setTotalMoney(totalMoney);
		logger.info ("========order=========" + JSON.toJSONString(order));
		int result = orderDao.insert(order);
		if(result == 0){
			return Result.fail("订单生成失败，请联系工作人员！");
		}

		for(OrderItem orderItem:orderItems){
			orderItem.setOrderId(order.getId());
		}
		orderItemDao.saveBatch(orderItems);

		//orderPayType: 1立即下单,0购物车下单
		if(orderReq.getOrderPayType() == 0){
			//修改优惠券已经使用了,清空已经购买了的购物车
			shoppingCartDao.deleteIds(userId, orderReq.getShoppingCartIds());
		}
		if(couponId > 0){
			couponService.useUserCoupon(userId, couponId);
		}
		//TODO 商品减去数量
		//TODO 生成唤醒支付
		UserSession userSession = userSessionDao.findByUserId(userId);
		return wxPayService.createWxPay(userId, order.getId(), userSession.getOpenId(), orderReq.getRequestIp() );
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
	public Response<List<OrderVO>> findOrderVOList(Integer userId, Integer orderStatus, Integer start, Integer rows) throws BaseException{

		Map whereMap = new HashMap();
		whereMap.put("userId", userId);
		whereMap.put("orderBy", "status");
		whereMap.put("asc", "asc");
		whereMap.put("start", start);
		whereMap.put("rows", rows);
		if(orderStatus != null){
			whereMap.put("orderStatus", orderStatus);
		}

		List<Order> orders = orderDao.findOrderByWhere(whereMap);

		List<OrderVO> orderVOs = new ArrayList<>();
		if(orders!=null){
			for(Order order:orders){
				OrderVO orderVO = order.toVO();
				orderVO.setStatusName(OrderStatusEnum.getName(orderVO.getStatus()));
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
		orderVO.setStatusName(OrderStatusEnum.getName(orderVO.getStatus()));
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
			CouponUserVO couponUserVO =  couponUserDao.findUserCouponVOById(userId, orderVO.getCouponId());
			orderVO.setCouponUserVO(couponUserVO);
		}

		
		//TODO 红包处理
		return Result.resultSet(orderVO);
	}



	public Response<String> updateCancelOrderById(Integer userId, Integer id){
		Order order = orderDao.findById(id);
		if(order == null){
			logger.error("updateCancelOrderById[id:"+id+",userId:"+userId+"]");
			return Result.fail("没找到订单");
		}
		if(order.getUserId() != userId){
			logger.error("updateCancelOrderById[id:"+id+",userId:"+userId+"], userIdError!!");
			return Result.fail("订单ID错误！");
		}
		if(order.getStatus() != OrderStatusEnum.WaitPayment.getCode()
				&& order.getPayStatus() == OrderPayStatusEnum.Success.getCode()){
			return Result.fail("订单已支付不能取消！");
		}
		order.setStatus(OrderStatusEnum.Cancel.getCode());
		int result = orderDao.update(order);
		if(result == 0){
			return Result.fail("取消订单失败，请稍后重试");
		}else{
			return Result.success("取消订单成功！");
		}
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
