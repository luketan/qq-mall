package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TShoppingCart;
import com.honglinktech.zbgj.service.TShoppingCartService;
/**
*
**/
@ControllerMeta(name = "")
@RestController
@RequestMapping("/tShoppingCart/api/")
public class TShoppingCartController extends CommonBaseController<TShoppingCart,TShoppingCartService> {

	private TShoppingCartService tShoppingCartService;

	public TShoppingCartService getTShoppingCartService() {
		return tShoppingCartService;
	}
	@Resource
	public void setTShoppingCartService(TShoppingCartService tShoppingCartService) {
		this.tShoppingCartService = tShoppingCartService;
	}
	@Override
	protected TShoppingCartService getService() {
		return tShoppingCartService;
	}
	
}
