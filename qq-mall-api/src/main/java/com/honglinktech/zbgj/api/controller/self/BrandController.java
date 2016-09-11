package com.honglinktech.zbgj.api.controller.self;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.base.ReturnInfo;
import com.honglinktech.zbgj.bean.GoodsBean;
import com.honglinktech.zbgj.entity.TGBrand;
import com.honglinktech.zbgj.service.self.BrandService;

@RestController
@RequestMapping("/brand/api")
public class BrandController extends CommonBaseController<TGBrand,BrandService> {
	@Resource
	private BrandService brandService;
	
	@RequestMapping(value="findBrandByTypeId",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnInfo findGoodsBean(@RequestBody GoodsBean goodsBean) throws BaseException{
//		GoodsBean gb = goodsService.findGoodsInfo(goodsBean.getId());
		ReturnInfo ri = new ReturnInfo(ExceptionEnum.COMMON_SUCCESS,null);
		return ri; 
	}
	
	@Override
	protected BrandService getService() {
		return brandService;
	}
	
}
