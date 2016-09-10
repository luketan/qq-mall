package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserMsgDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserMsg;

/**
*用户聊天记录，用户id分表 注意分表业务
**/
@Component
public class TUserMsgService extends BaseService<TUserMsg> {

	protected TUserMsgDao tUserMsgDao;

	
	public TUserMsgDao getTUserMsg() {
		return tUserMsgDao;
	}
	@Resource
	public void setTUserMsg(TUserMsgDao tUserMsgDao) {
		this.tUserMsgDao = tUserMsgDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserMsgDao getDao() {
		return tUserMsgDao;
	}
}
