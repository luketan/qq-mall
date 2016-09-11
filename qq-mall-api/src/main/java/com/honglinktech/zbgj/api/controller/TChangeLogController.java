package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TChangeLog;
import com.honglinktech.zbgj.service.TChangeLogService;
/**
*变更变更日志[逗比、经验、vip]  注意分表
**/
@ControllerMeta(name = "变更变更日志[逗比、经验、vip]  注意分表")
@RestController
@RequestMapping("/tChangeLog/api/")
public class TChangeLogController extends CommonBaseController<TChangeLog,TChangeLogService> {

	private TChangeLogService tChangeLogService;

	public TChangeLogService getTChangeLogService() {
		return tChangeLogService;
	}
	@Resource
	public void setTChangeLogService(TChangeLogService tChangeLogService) {
		this.tChangeLogService = tChangeLogService;
	}
	@Override
	protected TChangeLogService getService() {
		return tChangeLogService;
	}
	
}
