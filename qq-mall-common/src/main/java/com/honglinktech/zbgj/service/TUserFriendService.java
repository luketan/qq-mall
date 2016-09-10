package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserFriendDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserFriend;

/**
*经理的朋友业务
**/
@Component
public class TUserFriendService extends BaseService<TUserFriend> {

	protected TUserFriendDao tUserFriendDao;

	
	public TUserFriendDao getTUserFriend() {
		return tUserFriendDao;
	}
	@Resource
	public void setTUserFriend(TUserFriendDao tUserFriendDao) {
		this.tUserFriendDao = tUserFriendDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserFriendDao getDao() {
		return tUserFriendDao;
	}
}
