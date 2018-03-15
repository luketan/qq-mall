package com.honglinktech.zbgj.vo;


import com.honglinktech.zbgj.entity.User;
import com.honglinktech.zbgj.entity.UserBasis;

public class UserLoginVO {

	private String token;
	private UserVO userVO;
	
	public UserLoginVO(){
		
	}

	public UserLoginVO(String token, User user, UserBasis userBasis) {
		super();
		this.token = token;
		UserVO userVO = new UserVO();
		userVO.setType(user.getType());
		userVO.setCreateTime(user.getCreateTime());
		userVO.setAccount(user.getAccount());
		userVO.setAge(user.getAge());
		userVO.setEmail(user.getEmail());
		userVO.setEmailIs(user.getEmailIs());
		userVO.setHead(user.getHead());
		userVO.setId(user.getId());
		userVO.setLevel(user.getLevel());
		userVO.setMarr(user.getMarr());
		userVO.setNickName(user.getNickName());
		userVO.setPhone(user.getPhone());
		userVO.setPhoneIs(user.getPhoneIs());
		userVO.setSex(user.getSex());
		userVO.setSexu(user.getSexu());
		userVO.setSign(user.getSign());
		userVO.setTryIs(user.getTryIs());

		userVO.setVirtualMoney(userBasis.getVirtualMoney());
		userVO.setLevel(user.getLevel());
		userVO.setPoint(userBasis.getPoint());
		userVO.setMoney(userBasis.getMoney());
		userVO.setExp(userBasis.getExp());
		this.userVO = userVO;
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
