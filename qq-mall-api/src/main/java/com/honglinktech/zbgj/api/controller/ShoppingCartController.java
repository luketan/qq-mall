package com.honglinktech.zbgj.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.honglinktech.zbgj.annotation.RequireLogin;
import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.common.AppAgent;
import com.honglinktech.zbgj.entity.ShoppingCart;
import com.honglinktech.zbgj.service.ShoppingCartService;
import com.honglinktech.zbgj.vo.UserVO;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
	
	@RequestMapping(value="findList",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<ShoppingCartBean>> findShoppingCartBeanByUserId(@RequestBody Map<String, String> req,
																		 @RequestAttribute UserVO userVO,
																		 @RequestAttribute AppAgent agent) throws BaseException{
		
		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("userId", userVO.getId());
		
		if(req.containsKey("index") && req.containsKey("size")){
			whereMap.put("index", req.get("index"));
			whereMap.put("size", req.get("size"));
		}
	
	    Response<List<ShoppingCartBean>> response = shoppingCartService.findShoppingBeansByMap(whereMap);
		return response; 
	}
	
	@RequestMapping(value="addShoppingCart",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> addShoppingCart(@RequestBody AddShoppingBean addShoppingBean,
											@RequestAttribute UserVO userVO,
											@RequestAttribute AppAgent agent) throws BaseException{
	    
	    Response<String> response = shoppingCartService.addShoppingCart(userVO.getId(), addShoppingBean);
	    return response;
	}
	@RequestMapping(value="updateShoppingCart",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> updateShoppingCart(@RequestBody Map<String, String> req,
											   @RequestAttribute UserVO userVO,
											   @RequestAttribute AppAgent agent) throws BaseException{

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
		
		Response<String> response = shoppingCartService.updateShoppingCart(userVO.getId(), id, num, checkbox, checkAll);
		return response; 
	}
	@RequestMapping(value="deleteShoppingCart",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> deleteShoppingCart(@RequestBody Map<String, String> req,
											   @RequestAttribute UserVO userVO,
											   @RequestAttribute AppAgent agent) throws BaseException{

	    String id = req.get("id");
		if(StringUtils.isEmpty(id) || Integer.valueOf(id)==0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"id");
		}
		Response<String> response = shoppingCartService.deleteShoppingCart(userVO.getId(), Integer.valueOf(id));
		return response; 
	}

	
}
