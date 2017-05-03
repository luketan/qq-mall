package com.honglinktech.zbgj.bean;


public class UserLoginBean {
	
	public UserLoginBean(){
		
	}
	
	public UserLoginBean(String token, UserBean userBean) {
		super();
		this.token = token;
		this.tuser = userBean;
	}
	private String token;
	private UserBean tuser;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UserBean getTuser() {
		return tuser;
	}
	public void setTuser(UserBean tuser) {
		this.tuser = tuser;
	}
	
}
