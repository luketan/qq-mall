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
import com.honglinktech.zbgj.bean.request.GoodsItem;
import com.honglinktech.zbgj.entity.TGoods;
import com.honglinktech.zbgj.service.TGoodsService;
import com.honglinktech.zbgj.service.self.GoodsService;

@RestController
@RequestMapping("/goods/api")
public class GoodsController extends CommonBaseController<TGoods,TGoodsService> {
	@Resource
	private GoodsService goodsService;
	
	@RequestMapping(value="findGoodsBeanById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnInfo findGoodsBean(@RequestBody TGoods goods) throws BaseException{
		GoodsBean gb = goodsService.findGoodsInfo(goods.getId());
		ReturnInfo ri = new ReturnInfo(ExceptionEnum.COMMON_SUCCESS,gb);
		return ri; 
	}
	
	@RequestMapping(value="saveGoods",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnInfo save(@RequestBody GoodsItem goodsItem) throws BaseException{
		checkParameter(goodsItem.getTGoods(), SAVE);
		goodsService.saveGoods(goodsItem);
		ReturnInfo ri = new ReturnInfo(ExceptionEnum.COMMON_SUCCESS,null);
		return ri; 
	}
	@RequestMapping(value="updateGoods",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnInfo update(@RequestBody GoodsItem goodsItem) throws BaseException{
		checkParameter(goodsItem.getTGoods(), UPDATE);
		goodsService.updateGoods(goodsItem);
		ReturnInfo ri = new ReturnInfo(ExceptionEnum.COMMON_SUCCESS,null);
		return ri; 
	}
	
	@Override
	protected GoodsService getService() {
		return goodsService;
	}
	
}
