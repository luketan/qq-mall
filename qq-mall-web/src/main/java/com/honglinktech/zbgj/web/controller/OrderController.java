package com.honglinktech.zbgj.web.controller;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.PostDetail;
import com.honglinktech.zbgj.service.OrderService;
import com.honglinktech.zbgj.vo.OrderVO;
import com.honglinktech.zbgj.vo.UserVO;
import com.honglinktech.zbgj.vo.request.OrderReq;
import com.honglinktech.zbgj.web.base.BaseApiController;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order/api")
public class OrderController extends BaseApiController {
	@Resource
	private OrderService orderService;
	
	/**
	 * 准备订单
	 * @param map
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="readyOrder",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<Map<String, Object>> readyOrder(@RequestBody OrderReq orderReq, @RequestHeader HttpHeaders headers) throws BaseException{
	   
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode)){
			return Result.fail(ExceptionEnum.COMMON_USER_ILLEGAL_REQUEST);
		}

		Response<Map<String, Object>> resp = null;
		try {
			resp = orderService.findReadyOrder(Integer.valueOf(userCode), orderReq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp; 
	}
	/**
	 * 用户选择支付方式
	 * @param map
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="orderCheckedPayment",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> orderCheckedPayment(@RequestBody Map<String,String> map,@RequestHeader HttpHeaders headers) throws BaseException{
	   
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode)){
			return Result.fail(ExceptionEnum.COMMON_USER_ILLEGAL_REQUEST);
		}
		String paymentId =  map.get("paymentId");
		if(StringUtils.isEmpty(paymentId)){
			return Result.fail(ExceptionEnum.COMMON_USER_ILLEGAL_REQUEST);
		}
		
		Response<String> resp = orderService.findCheckedPayment(Integer.valueOf(userCode), Integer.valueOf(paymentId));
		return resp; 
	}
	/**
	 * 订单
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="submitOrder",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<Map<String, Object>> submitOrder(@RequestBody OrderReq orderReq, @RequestAttribute UserVO user) throws BaseException{

		Response<Map<String, Object>> resp = null;
		try {
			resp = orderService.saveSubmitOrder(user.getId(), orderReq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp; 
	}
	/**
	 * 获取订单列表
	 * @param req
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findOrderBeanByPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<OrderVO>> findOrderBeanByPage(@RequestBody Map<String, String> req, @RequestHeader HttpHeaders headers) throws BaseException{
	   
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode)){
			return Result.fail(ExceptionEnum.COMMON_USER_ILLEGAL_REQUEST);
		}
		Integer index = req.get("index")==null?1:Integer.valueOf(req.get("index"));
		Integer size = req.get("size")==null?10:Integer.valueOf(req.get("size"));
		
		Response<List<OrderVO>> resp = orderService.findOrderVOList(Integer.valueOf(userCode),index,size);
		return resp; 
	}
	/**
	 * 获取订单详情
	 * @param req
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findOrderBeanById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<OrderVO> findOrderBean(@RequestBody Map<String, String> req,@RequestHeader HttpHeaders headers) throws BaseException{
	   
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode)){
			return Result.fail(ExceptionEnum.COMMON_USER_ILLEGAL_REQUEST);
		}
		String id = req.get("id");
		if(StringUtils.isEmpty(id)){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"orderId");
		}
		
		Response<OrderVO> resp = orderService.findOrderVOById(Integer.valueOf(userCode),Integer.valueOf(id));
		return resp; 
	}
	/**
	 * 获取物流信息
	 */
	@RequestMapping(value="findPostDetail",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<PostDetail>> findPostDetail(@RequestBody Map<String, String> req, @RequestHeader HttpHeaders headers) throws BaseException{
	   
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode)){
			return Result.fail(ExceptionEnum.COMMON_USER_ILLEGAL_REQUEST);
		}
		String postCode = req.get("postCode");
		if(StringUtils.isEmpty(postCode)){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"postCode");
		}
		
		Response<List<PostDetail>> resp = orderService.findPostDetail(postCode);
		return resp; 
	}
	
	
	
}
