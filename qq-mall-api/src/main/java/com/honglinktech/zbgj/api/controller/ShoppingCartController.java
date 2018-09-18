package com.honglinktech.zbgj.api.controller;


import com.honglinktech.zbgj.annotation.RequireLogin;
import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.request.AddShoppingBean;
import com.honglinktech.zbgj.common.AppAgent;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.service.ShoppingCartService;
import com.honglinktech.zbgj.vo.UserVO;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RequireLogin
@RestController
@RequestMapping("/shoppingCart/api")
public class ShoppingCartController extends BaseApiController {
	@Resource
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping(value="findList",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response findShoppingCartBeanByUserId(@RequestBody Map<String, String> req,
																	   @RequestAttribute UserVO user,
																	   @RequestAttribute AppAgent agent) throws BaseException{


		int start = req.containsKey("start")?Integer.valueOf(req.get("start")):0;
		int rows = req.containsKey("rows")?Integer.valueOf(req.get("rows")):10;

		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("userId", user.getId());
		whereMap.put("start", start);
		whereMap.put("rows", Integer.MAX_VALUE);
	
	    Response response = shoppingCartService.findShoppingsByMap(whereMap);
		return response; 
	}
	
	@RequestMapping(value="addShoppingCart",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> addShoppingCart(@RequestBody AddShoppingBean addShoppingBean,
											@RequestAttribute UserVO user,
											@RequestAttribute AppAgent agent) throws BaseException{

		if(addShoppingBean.getGoodsId() == null || addShoppingBean.getGoodsId()<= 0){
			return Result.fail("商品ID不能为空");
		}
		if(addShoppingBean.getNum() == null || addShoppingBean.getNum()<= 0){
			return Result.fail("数量不能为空");
		}
		if(addShoppingBean.getFormatSubIds() == null || addShoppingBean.getFormatSubIds().length == 0){
			return Result.fail("规格不能为空");
		}
	    Response<String> response = shoppingCartService.addShoppingCart(user.getId(), addShoppingBean);
	    return response;
	}
	@RequestMapping(value="updateShoppingCart",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> updateShoppingCart(@RequestBody Map<String, String> req,
											   @RequestAttribute UserVO user,
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
		
		Response<String> response = shoppingCartService.updateShoppingCart(user.getId(), id, num, checkbox, checkAll);
		return response; 
	}
	@RequestMapping(value="deleteShoppingCart",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> deleteShoppingCart(@RequestBody Map<String, String> req,
											   @RequestAttribute UserVO user,
											   @RequestAttribute AppAgent agent) throws BaseException{

	    String id = req.get("id");
		if(StringUtils.isEmpty(id) || Integer.valueOf(id)==0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"id");
		}
		Response<String> response = shoppingCartService.deleteShoppingCart(user.getId(), Integer.valueOf(id));
		return response; 
	}

	@RequestMapping(value="cleanInvalid",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> cleanInvalid(@RequestBody Map<String, String> req,
											   @RequestAttribute UserVO user,
											   @RequestAttribute AppAgent agent) throws BaseException{
		Response<String> response = shoppingCartService.deleteInvalid(user.getId());
		return response;
	}

	
}
