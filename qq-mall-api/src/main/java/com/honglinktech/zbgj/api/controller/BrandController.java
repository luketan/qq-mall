package com.honglinktech.zbgj.api.controller;


import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.base.ReturnInfo;
import com.honglinktech.zbgj.bean.GoodsBean;
import com.honglinktech.zbgj.service.GoodsBrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 品牌管理
 * @author Administrator
 */
@RestController
@RequestMapping("/brand/api")
public class BrandController extends BaseApiController{
	@Resource
	private GoodsBrandService brandService;
	
	@RequestMapping(value="findBrandByTypeId",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnInfo findGoodsBean(@RequestBody GoodsBean goodsBean) throws BaseException{

		ReturnInfo ri = new ReturnInfo(ExceptionEnum.COMMON_SUCCESS,null);
		return ri; 
	}
	
}
