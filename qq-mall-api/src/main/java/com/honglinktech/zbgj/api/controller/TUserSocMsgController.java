package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TUserSocMsg;
import com.honglinktech.zbgj.service.TUserSocMsgService;
/**
*用户社区消息
**/
@ControllerMeta(name = "用户社区消息")
@RestController
@RequestMapping("/tUserSocMsg/api/")
public class TUserSocMsgController extends CommonBaseController<TUserSocMsg,TUserSocMsgService> {

	private TUserSocMsgService tUserSocMsgService;

	public TUserSocMsgService getTUserSocMsgService() {
		return tUserSocMsgService;
	}
	@Resource
	public void setTUserSocMsgService(TUserSocMsgService tUserSocMsgService) {
		this.tUserSocMsgService = tUserSocMsgService;
	}
	@Override
	protected TUserSocMsgService getService() {
		return tUserSocMsgService;
	}
	
}
