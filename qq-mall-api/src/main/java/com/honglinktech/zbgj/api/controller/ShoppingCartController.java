package com.honglinktech.zbgj.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.honglinktech.zbgj.annotation.RequireLogin;
import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.entity.ShoppingCart;
import com.honglinktech.zbgj.service.ShoppingCartService;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.ShoppingCartBean;
import com.honglinktech.zbgj.bean.request.AddShoppingBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;

@RequireLogin
@RestController
@RequestMapping("/shoppingCart/api")
public class ShoppingCartController extends BaseApiController {
	@Resource
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping(value="findShoppingCartBeanByUserId",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<ShoppingCartBean>> findShoppingCartBeanByUserId(@RequestHeader HttpHeaders headers,@RequestBody Map<String, String> req) throws BaseException{
		String userCode =  headers.getFirst("userId");
	    if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)<=0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		
		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("userId", userCode);
		
		if(req.containsKey("index") && req.containsKey("size")){
			whereMap.put("index", req.get("index"));
			whereMap.put("size", req.get("size"));
		}
	
	    Response<List<ShoppingCartBean>> response = shoppingCartService.findShoppingBeansByMap(whereMap);
		return response; 
	}
	
	@RequestMapping(value="addShoppingCart",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> addShoppingCart(@RequestHeader HttpHeaders headers,@RequestBody AddShoppingBean addShoppingBean) throws BaseException{
		String userCode =  headers.getFirst("userId");
	    if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)<=0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
	    
	    Response<String> response = shoppingCartService.addShoppingCart(Integer.valueOf(userCode), addShoppingBean);
	    return response;
	}
	@RequestMapping(value="updateShoppingCart",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> updateShoppingCart(@RequestHeader HttpHeaders headers,@RequestBody Map<String, String> req) throws BaseException{
		String userCode =  headers.getFirst("userId");
	    if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)<=0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
	    Integer id = null;
		if(!StringUtils.isEmpty(req.get("id"))){
			id = Integer.valueOf(req.get("id"));
		}
		Integer num = null;
		if(!StringUtils.isEmpty(req.get("num")) && Integer.valueOf(req.get("num")) > 0){
			num = Integer.valueOf(req.get("num"));
		}
		Integer checkbox = null;
		if(!StringUtils.isEmpty(req.get("checkbox"))){
			checkbox = (Boolean.valueOf(req.get("checkbox"))?1:0);
		}
		Boolean checkAll = null;
		if(!StringUtils.isEmpty(req.get("checkAll"))){
			checkAll = Boolean.valueOf(req.get("checkAll"));
		}
		
		Response<String> response = shoppingCartService.updateShoppingCart(Integer.valueOf(userCode), id, num, checkbox, checkAll);
		return response; 
	}
	@RequestMapping(value="deleteShoppingCart",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> deleteShoppingCart(@RequestHeader HttpHeaders headers,@RequestBody Map<String, String> req) throws BaseException{
		String userCode =  headers.getFirst("userId");
	    if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
	    String id = req.get("id");
		if(StringUtils.isEmpty(id) || Integer.valueOf(id)==0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"id");
		}
		Response<String> response = shoppingCartService.deleteShoppingCart(Integer.valueOf(userCode), Integer.valueOf(id));
		return response; 
	}

	
}
