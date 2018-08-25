package com.honglinktech.zbgj.api.controller;

import com.honglinktech.zbgj.annotation.RequireLogin;
import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.common.AppAgent;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.PostDetail;
import com.honglinktech.zbgj.service.OrderService;
import com.honglinktech.zbgj.vo.OrderVO;
import com.honglinktech.zbgj.vo.UserVO;
import org.springframework.http.HttpHeaders;
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
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="readyOrder",method={RequestMethod.POST})
	@ResponseBody
	public Response<Map<String, Object>> readyOrder(@RequestBody Map map,
													@RequestAttribute UserVO user,
													@RequestAttribute AppAgent agent) throws BaseException{

		Response<Map<String, Object>> resp = orderService.findOrderView(Integer.valueOf(user.getId()),map);
		return resp; 
	}
	/**
	 * 用户选择支付方式
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="orderCheckedPayment",method={RequestMethod.POST})
	@ResponseBody
	public Response<String> orderCheckedPayment(@RequestBody Map<String,String> map,
												@RequestAttribute UserVO user,
												@RequestAttribute AppAgent agent) throws BaseException{

		String paymentId =  map.get("paymentId");
		if(StringUtils.isEmpty(paymentId)){
			return Result.fail(ExceptionEnum.COMMON_USER_ILLEGAL_REQUEST);
		}
		
		Response<String> resp = orderService.findCheckedPayment(user.getId(), Integer.valueOf(paymentId));
		return resp; 
	}
	/**
	 * 订单
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="submitOrder",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<Map<String, Object>> submitOrder(@RequestBody Map<String,Object> map,
													 @RequestAttribute UserVO user,
													 @RequestAttribute AppAgent agent) throws BaseException{
	   

		Object addressId =  map.get("addressId");
		if(StringUtils.isEmpty(addressId)){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"addressId");
		}
		Object paymentId =  map.get("paymentId");
		if(StringUtils.isEmpty(paymentId)){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"paymentId");
		}
		
		Response<Map<String, Object>> resp = orderService.saveSubmitOrder(user.getId(), map);
		return resp; 
	}
	/**
	 * 获取订单列表
	 * @param req
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findOrderBeanByPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<OrderVO>> findOrderBeanByPage(@RequestBody Map<String, String> req,
													   @RequestAttribute UserVO user,
													   @RequestAttribute AppAgent agent) throws BaseException{

		int start = req.containsKey("start")?Integer.valueOf(req.get("start")):0;
		int rows = req.containsKey("rows")?Integer.valueOf(req.get("rows")):10;
		
		Response<List<OrderVO>> resp = orderService.findOrderVOList(user.getId(), start, rows);
		return resp; 
	}
	/**
	 * 获取订单详情
	 * @param req
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findOrderBeanById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<OrderVO> findOrderBean(@RequestBody Map<String, String> req,
										   @RequestAttribute UserVO user,
										   @RequestAttribute AppAgent agent) throws BaseException{
	   

		String id = req.get("id");
		if(StringUtils.isEmpty(id)){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"orderId");
		}
		
		Response<OrderVO> resp = orderService.findOrderVOById(user.getId(), Integer.valueOf(id));
		return resp; 
	}
	/**
	 * 获取物流信息
	 */
	@RequestMapping(value="findPostDetail",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<PostDetail>> findPostDetail(@RequestBody Map<String, String> req,
													 @RequestAttribute UserVO user,
													 @RequestAttribute AppAgent agent) throws BaseException{
	   

		String postCode = req.get("postCode");
		if(StringUtils.isEmpty(postCode)){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"postCode");
		}
		
		Response<List<PostDetail>> resp = orderService.findPostDetail(postCode);
		return resp; 
	}
	
	
	
}
