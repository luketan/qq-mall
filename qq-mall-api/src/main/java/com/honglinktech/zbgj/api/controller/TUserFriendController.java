package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TUserFriend;
import com.honglinktech.zbgj.service.TUserFriendService;
/**
*用户的朋友
**/
@ControllerMeta(name = "用户的朋友")
@RestController
@RequestMapping("/tUserFriend/api/")
public class TUserFriendController extends CommonBaseController<TUserFriend,TUserFriendService> {

	private TUserFriendService tUserFriendService;

	public TUserFriendService getTUserFriendService() {
		return tUserFriendService;
	}
	@Resource
	public void setTUserFriendService(TUserFriendService tUserFriendService) {
		this.tUserFriendService = tUserFriendService;
	}
	@Override
	protected TUserFriendService getService() {
		return tUserFriendService;
	}
	
}
