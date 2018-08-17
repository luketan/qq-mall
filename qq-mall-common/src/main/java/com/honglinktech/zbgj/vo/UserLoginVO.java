package com.honglinktech.zbgj.vo;


public class UserLoginVO {

	private String token;
	private UserVO userVO;
	private UserBasisVO userBasisVO;
	
	public UserLoginVO(){
		
	}

	public UserLoginVO(String token, UserVO userVO, UserBasisVO userBasisVO) {
		super();
		this.token = token;
		this.userVO = userVO;
		this.userBasisVO = userBasisVO;
	}
	public UserLoginVO(String token, UserVO userVO) {
		super();
		this.token = token;
		this.userVO = userVO;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
}
