package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TOrderItem;
import com.honglinktech.zbgj.service.TOrderItemService;
/**
*订单详情
**/
@ControllerMeta(name = "订单详情")
@RestController
@RequestMapping("/tOrderItem/api/")
public class TOrderItemController extends CommonBaseController<TOrderItem,TOrderItemService> {

	private TOrderItemService tOrderItemService;

	public TOrderItemService getTOrderItemService() {
		return tOrderItemService;
	}
	@Resource
	public void setTOrderItemService(TOrderItemService tOrderItemService) {
		this.tOrderItemService = tOrderItemService;
	}
	@Override
	protected TOrderItemService getService() {
		return tOrderItemService;
	}
	
}
