package com.honglinktech.zbgj.bean;

import com.honglinktech.zbgj.entity.TUser;

public class UserLoginBean {
	
	public UserLoginBean(){
		
	}
	
	public UserLoginBean(String token, TUser tuser) {
		super();
		this.token = token;
		this.tuser = tuser;
	}
	private String token;
	private TUser tuser;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public TUser getTuser() {
		return tuser;
	}
	public void setTuser(TUser tuser) {
		this.tuser = tuser;
	}
	
}
