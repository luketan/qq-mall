package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TOrder;
import com.honglinktech.zbgj.service.TOrderService;
/**
*订单信息
**/
@ControllerMeta(name = "订单信息")
@RestController
@RequestMapping("/tOrder/api/")
public class TOrderController extends BaseController<TOrder,TOrderService> {

	private TOrderService tOrderService;

	public TOrderService getTOrderService() {
		return tOrderService;
	}
	@Resource
	public void setTOrderService(TOrderService tOrderService) {
		this.tOrderService = tOrderService;
	}
	@Override
	protected TOrderService getService() {
		return tOrderService;
	}
	
}
