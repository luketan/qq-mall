package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TUserAddress;
import com.honglinktech.zbgj.service.TUserAddressService;
/**
*用户地址
**/
@ControllerMeta(name = "用户地址")
@RestController
@RequestMapping("/tUserAddress/api/")
public class TUserAddressController extends CommonBaseController<TUserAddress,TUserAddressService> {

	private TUserAddressService tUserAddressService;

	public TUserAddressService getTUserAddressService() {
		return tUserAddressService;
	}
	@Resource
	public void setTUserAddressService(TUserAddressService tUserAddressService) {
		this.tUserAddressService = tUserAddressService;
	}
	@Override
	protected TUserAddressService getService() {
		return tUserAddressService;
	}
	
}
