package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TUserMsg;
import com.honglinktech.zbgj.service.TUserMsgService;
/**
*用户聊天记录，用户id分表 注意分表
**/
@ControllerMeta(name = "用户聊天记录，用户id分表 注意分表")
@RestController
@RequestMapping("/tUserMsg/api/")
public class TUserMsgController extends CommonBaseController<TUserMsg,TUserMsgService> {

	private TUserMsgService tUserMsgService;

	public TUserMsgService getTUserMsgService() {
		return tUserMsgService;
	}
	@Resource
	public void setTUserMsgService(TUserMsgService tUserMsgService) {
		this.tUserMsgService = tUserMsgService;
	}
	@Override
	protected TUserMsgService getService() {
		return tUserMsgService;
	}
	
}
