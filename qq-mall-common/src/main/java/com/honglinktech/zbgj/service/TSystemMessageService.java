package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSystemMessageDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSystemMessage;

/**
*系统消息业务
**/
@Component
public class TSystemMessageService extends BaseService<TSystemMessage> {

	protected TSystemMessageDao tSystemMessageDao;

	
	public TSystemMessageDao getTSystemMessage() {
		return tSystemMessageDao;
	}
	@Resource
	public void setTSystemMessage(TSystemMessageDao tSystemMessageDao) {
		this.tSystemMessageDao = tSystemMessageDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSystemMessageDao getDao() {
		return tSystemMessageDao;
	}
}
