package com.honglinktech.zbgj.api.controller;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.annotation.RequireLogin;
import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.enums.OrderStatusEnum;
import com.honglinktech.zbgj.service.payment.wechat.PayUtil;
import com.honglinktech.zbgj.vo.request.OrderReq;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.common.AppAgent;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.PostDetail;
import com.honglinktech.zbgj.service.OrderService;
import com.honglinktech.zbgj.vo.OrderVO;
import com.honglinktech.zbgj.vo.UserVO;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequireLogin
@RestController
@RequestMapping("/order/api")
public class OrderController extends BaseApiController {
	@Resource
	private OrderService orderService;
	
	/**
	 * 准备订单
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findReadyOrder",method={RequestMethod.POST})
	@ResponseBody
	public Response<Map<String, Object>> findReadyOrder(@RequestBody OrderReq orderReq,
													@RequestAttribute UserVO user,
													@RequestAttribute AppAgent agent) throws BaseException{
		try {
			logger.info("orderReq============" + JSON.toJSONString(orderReq));
			//orderPayType: 1立即下单,0购物车下单
			if (orderReq.getOrderPayType() == 0) {
				if (orderReq.getShoppingCartIds() == null || orderReq.getShoppingCartIds().size() == 0) {
					return Result.fail("请选择购物车！");
				}
			} else {
				if (orderReq.getGoodsId() == 0 || orderReq.getNum() == 0) {
					return Result.fail("立即购买参数错误！");
				}
			}

			Response<Map<String, Object>> resp = orderService.findReadyOrder(Integer.valueOf(user.getId()), orderReq);
			return resp;
		}catch (Exception e){
			return Result.fail("获取订单信息失败，请稍后重试");
		}
	}

	/**
	 * 订单
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="submitOrder",method={RequestMethod.POST})
	@ResponseBody
	public Response submitOrder(@RequestBody OrderReq orderReq,
													 @RequestAttribute UserVO user,
													 @RequestAttribute AppAgent agent) throws BaseException{
	   
			try {

				if (StringUtils.isEmpty(orderReq.getAddress())) {
					return Result.fail("地址不能为空");
				}
				if (StringUtils.isEmpty(orderReq.getPaymentCode())) {
					return Result.fail("支付方式不能为空");
				}

				//orderPayType: 1立即下单,0购物车下单
				if (orderReq.getOrderPayType() != 1 && orderReq.getOrderPayType() != 0) {
					return Result.fail("支付方式不能为空");
				}

				if (orderReq.getOrderPayType() == 0) {
					if (orderReq.getShoppingCartIds() == null || orderReq.getShoppingCartIds().size() == 0) {
						return Result.fail("请选择购物车！");
					}
				} else {
					if (orderReq.getGoodsId() == 0) {
						return Result.fail("请选择商品！");
					}
					if (orderReq.getNum() == 0) {
						return Result.fail("请选择输入购买上商品的数量！");
					}
				}

				String requestIp = PayUtil.getIpAddr(request);
				orderReq.setRequestIp(requestIp);
				return orderService.saveSubmitOrder(user.getId(), orderReq);
			}catch (Exception e){
				logger.error(e, e);
				return Result.fail("生成订单失败，请稍后重试！");
			}
	}
	/**
	 * 获取订单列表
	 * @param req
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findOrders",method={RequestMethod.POST})
	@ResponseBody
	public Response<List<OrderVO>> findOrders(@RequestBody Map<String, Integer> req,
													   @RequestAttribute UserVO user,
													   @RequestAttribute AppAgent agent) throws BaseException{
		try {

			if (!req.containsKey("status")) {
				return Result.fail("状态不能为空！");
			}
			int status = req.get("status");
			Integer orderStatus = null;
			if(status == 0){//全部
				orderStatus = null;
			}else if(status == 1){//待付款
				orderStatus = OrderStatusEnum.WaitPayment.getCode();
			}else if(status == 2){//待发货
				orderStatus = OrderStatusEnum.WaitShip.getCode();
			}else if(status == 3){//待收货
				orderStatus = OrderStatusEnum.Send.getCode();
			}else if(status == 4){//交易成功
				orderStatus = OrderStatusEnum.Complete.getCode();
			}else if(status == 9){//已取消
				orderStatus = OrderStatusEnum.Cancel.getCode();
			}

			int start = req.containsKey("start") ? Integer.valueOf(req.get("start")) : 0;
			int rows = req.containsKey("rows") ? Integer.valueOf(req.get("rows")) : 10;

			Response<List<OrderVO>> resp = orderService.findOrderVOList(user.getId(), orderStatus, start, rows);
			return resp;
		}catch (Exception e){
			logger.error(e, e);
			return Result.fail("获取订单列表失败，请稍后重试！");
		}

	}
	/**
	 * 获取订单详情
	 * @param req
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findOrderById",method={RequestMethod.POST})
	@ResponseBody
	public Response<OrderVO> findOrderById(@RequestBody Map<String, String> req,
										   @RequestAttribute UserVO user,
										   @RequestAttribute AppAgent agent) throws BaseException{
	   
		try {
			String id = req.get("id");
			if (StringUtils.isEmpty(id)) {
				return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL, "orderId");
			}

			Response<OrderVO> resp = orderService.findOrderVOById(user.getId(), Integer.valueOf(id));
			return resp;
		}catch (Exception e){
			logger.error(e, e);
			return Result.fail("获取订单详情失败，请稍后重试");
		}
	}

	/**
	 * 获取订单详情
	 * @param req
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="updateCancelOrderById",method={RequestMethod.POST})
	@ResponseBody
	public Response<String> updateCancelOrderById(@RequestBody Map<String, String> req,
										   @RequestAttribute UserVO user,
										   @RequestAttribute AppAgent agent) throws BaseException{

		try {
			String id = req.get("id");
			if (StringUtils.isEmpty(id)) {
				return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL, "orderId");
			}

			Response<String> resp = orderService.updateCancelOrderById(user.getId(), Integer.valueOf(id));
			return resp;
		}catch (Exception e){
			logger.error(e, e);
			return Result.fail("获取订单详情失败，请稍后重试");
		}
	}
	/**
	 * 获取物流信息
	 */
	@RequestMapping(value="findPostDetail",method={RequestMethod.POST})
	@ResponseBody
	public Response<List<PostDetail>> findPostDetail(@RequestBody Map<String, String> req,
													 @RequestAttribute UserVO user,
													 @RequestAttribute AppAgent agent) throws BaseException{

		try {
			String postCode = req.get("postCode");
			if (StringUtils.isEmpty(postCode)) {
				return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL, "postCode");
			}

			Response<List<PostDetail>> resp = orderService.findPostDetail(postCode);
			return resp;
		}catch (Exception e){
			logger.error(e, e);
			return Result.fail("获取快递信息失败，请稍后重试！");
		}
	}
	
}
