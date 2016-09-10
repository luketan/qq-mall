package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserSocMsgDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserSocMsg;

/**
*用户社区消息业务
**/
@Component
public class TUserSocMsgService extends BaseService<TUserSocMsg> {

	protected TUserSocMsgDao tUserSocMsgDao;

	
	public TUserSocMsgDao getTUserSocMsg() {
		return tUserSocMsgDao;
	}
	@Resource
	public void setTUserSocMsg(TUserSocMsgDao tUserSocMsgDao) {
		this.tUserSocMsgDao = tUserSocMsgDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserSocMsgDao getDao() {
		return tUserSocMsgDao;
	}
}
