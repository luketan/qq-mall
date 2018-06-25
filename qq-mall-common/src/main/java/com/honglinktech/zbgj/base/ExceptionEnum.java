package com.honglinktech.zbgj.base;

import java.text.MessageFormat;

public enum ExceptionEnum {

	//common 000000
	COMMON_TOKEN_FAIL(999,"token已经失效！","token fail!"), //token失效
	COMMON_SUCCESS(0,"操作成功！","success!"),
	COMMON_ERROE(1,"操作失败，请联系工作人员！","error,{0}"),
	COMMON_PARAMETER_ERROR(2,"参数错误！{0}","parameter error:name{0},value:{1}!"),
	COMMON_PARAMETER_ERROR_NOT_NULL(3,"参数错误,{0}不允许为空！","parameter error:name:{1}!"),
	COMMON_DATEBASE_REFLEX_ERROE(4,"系统错误，请联系工作人员！","data base error!"),
	COMMON_DATEBASE_PARAMETER_ERROE(5,"系统错误，请联系工作人员！","data base set parameter error!"),
	COMMON_DATEBASE_PRIMARYKEY_ERROE(6,"系统错误，请联系工作人员！","data base set primarykey error!"),
	COMMON_TOKEN_ERROE(7,"用户会话信息错误，或者过期，请重新登录！","token error，ip{0}!"),
	COMMON_USER_CODE_NOT_EMPTY(8,"用户会话信息错误，或者过期，请重新登录！","user code not empty!"),
	COMMON_USER_ILLEGAL_REQUEST(9,"用户非法请求！","user code not empty!"),
	//admin 010000
	ADMIN_ACCOUNT_NOT_EXIST(100001,"账户不存在","account name[{0}] does not exist!"),
	ADMIN_ACCOUNT_PASSWORD_ERROR(100002,"密码错误！","account name[{0}]，password [{1}] is error!"),
	ADMIN_ACCOUNT_ERROR(100003,"系统错误，请联系后台工作人员！","account must error，account name[{0}]，password [{1}]!"),
	ADMIN_ACCOUNT_NOT_NULL(100004,"用户名不能为空！","account not null!"),
	ADMIN_PASSWORD_NOT_NULL(100005,"密码不能为空！","password not null!"),
	//user 020000
	USER_PASSWORD_ERROR(200001,"用户名或者密码错误","account or password error!"),
	USER_MUCH_ERROR(200002,"系统错误","much user,account:{0},password:{1}!"),
	USER_LOGINOUT_ERROR(200003,"退出登录失败！","loginout error,userId:{0}!"),
	USER_LOCKED_ERROR(200004,"账户被锁定，请联系系统解锁。","user locked,account:{0}!"),
	USER_BLACK_ERROR(200005,"账户被拉黑，永久性不能使用。","user black,account:{0}!"),
	//good 030000
	GOODS_ORDER_PAYMENT_NOT_FIND(300001,"没找到支付方式！","没找到支付方式，paymentId:{0}!"),
	GOODS_ORDER_ADDRESS_NOT_FIND(300002,"没找到用户地址！","没找到用户地址，addressId:{0}!"),
	//society 040000

	//order
	ORDER_UPDATE_STATUS_ERROR(300002,"订单状态修改失败！","订单状态修改失败，id:{0}!"),
	ORDER_NOT_EXIST_ERROR(300003,"订单不存在！","订单不存在，id:{0}!");
	
	
	private int retCode;
	private String retString;
	private String logString;
	public int getRetCode(){
		return retCode;
	}
	public String getRetString(Object... args){
		if(args!=null && args.length>0){
			return MessageFormat.format(retString, args);
		}else{
			return retString;
		}
	}
	public String getLogString(){
		return logString;
	}
	public String getLogString(Object... args){
		if(args!=null && args.length>0){
			return MessageFormat.format(logString, args);
		}else{
			return logString;
		}
	}
	public void setRetCode(int retCode){
		this.retCode = retCode;
	}
	public void setRetString(String retString){
		this.retString = retString;
	}
	public void setRetString(String retString,Object... args){
		this.retString = MessageFormat.format(retString, args);
	}
	public void setLogString(String logString){
		this.logString = logString;
	}
	
	private ExceptionEnum(int retCode,String retString,String logString){
		this.retCode = retCode;
		this.retString = retString;
		this.logString = logString;
    }

}
