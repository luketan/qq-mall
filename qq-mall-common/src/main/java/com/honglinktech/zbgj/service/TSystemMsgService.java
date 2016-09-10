package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSystemMsgDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSystemMsg;

/**
*系统消息业务
**/
@Component
public class TSystemMsgService extends BaseService<TSystemMsg> {

	protected TSystemMsgDao tSystemMsgDao;

	
	public TSystemMsgDao getTSystemMsg() {
		return tSystemMsgDao;
	}
	@Resource
	public void setTSystemMsg(TSystemMsgDao tSystemMsgDao) {
		this.tSystemMsgDao = tSystemMsgDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSystemMsgDao getDao() {
		return tSystemMsgDao;
	}
}
