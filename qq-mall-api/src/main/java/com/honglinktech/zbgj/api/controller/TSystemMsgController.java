package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TSystemMsg;
import com.honglinktech.zbgj.service.TSystemMsgService;
/**
*系统消息
**/
@ControllerMeta(name = "系统消息")
@RestController
@RequestMapping("/tSystemMsg/api/")
public class TSystemMsgController extends CommonBaseController<TSystemMsg,TSystemMsgService> {

	private TSystemMsgService tSystemMsgService;

	public TSystemMsgService getTSystemMsgService() {
		return tSystemMsgService;
	}
	@Resource
	public void setTSystemMsgService(TSystemMsgService tSystemMsgService) {
		this.tSystemMsgService = tSystemMsgService;
	}
	@Override
	protected TSystemMsgService getService() {
		return tSystemMsgService;
	}
	
}
