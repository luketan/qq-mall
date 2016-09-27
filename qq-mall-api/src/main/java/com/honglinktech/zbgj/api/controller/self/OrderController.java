package com.honglinktech.zbgj.api.controller.self;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.OrderBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.TPostDetail;
import com.honglinktech.zbgj.service.self.OrderService;

@RestController
@RequestMapping("/order/api")
public class OrderController extends BaseApiController {
	@Resource
	private OrderService orderService;
	
	@RequestMapping(value="findOrderBeanByPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<OrderBean>> findOrderBeanByPage(@RequestBody Map<String, String> req,@RequestHeader HttpHeaders headers) throws BaseException{
	   
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode)){
			return Result.fail(ExceptionEnum.COMMON_USER_ILLEGAL_REQUEST);
		}
		Integer index = req.get("index")==null?1:Integer.valueOf(req.get("index"));
		Integer size = req.get("size")==null?10:Integer.valueOf(req.get("size"));
		
		Response<List<OrderBean>> resp = orderService.appFindOrderBeanList(Integer.valueOf(userCode),index,size);
		return resp; 
	}
	
	@RequestMapping(value="findOrderBeanById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<OrderBean> findOrderBean(@RequestBody Map<String, String> req,@RequestHeader HttpHeaders headers) throws BaseException{
	   
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode)){
			return Result.fail(ExceptionEnum.COMMON_USER_ILLEGAL_REQUEST);
		}
		String id = req.get("id");
		if(StringUtils.isEmpty(id)){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"orderId");
		}
		
		Response<OrderBean> resp = orderService.appFindOrderBeanById(Integer.valueOf(userCode),Integer.valueOf(id));
		return resp; 
	}
	
	@RequestMapping(value="findPostDetail",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<TPostDetail>> findPostDetail(@RequestBody Map<String, String> req,@RequestHeader HttpHeaders headers) throws BaseException{
	   
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode)){
			return Result.fail(ExceptionEnum.COMMON_USER_ILLEGAL_REQUEST);
		}
		String postCode = req.get("postCode");
		if(StringUtils.isEmpty(postCode)){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"postCode");
		}
		
		Response<List<TPostDetail>> resp = orderService.findPostDetail(postCode);
		return resp; 
	}
	
	
	
}
