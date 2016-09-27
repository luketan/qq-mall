package com.honglinktech.zbgj.base;

import java.text.MessageFormat;

public enum ExceptionEnum {

	//common 000000
	COMMON_SUCCESS("000000","操作成功！","success!"),
	COMMON_ERROE("000001","操作失败，请联系工作人员！","error,{0}"),
	COMMON_PARAMETER_ERROR("000002","参数错误！","parameter error:name{0},value:{1}!"),
	COMMON_PARAMETER_ERROR_NOT_NULL("000003","参数错误,{0}不允许为空！","parameter error:name:{1}!"),
	COMMON_DATEBASE_REFLEX_ERROE("000004","系统错误，请联系工作人员！","data base error!"),
	COMMON_DATEBASE_PARAMETER_ERROE("000005","系统错误，请联系工作人员！","data base set parameter error!"),
	COMMON_DATEBASE_PRIMARYKEY_ERROE("000006","系统错误，请联系工作人员！","data base set primarykey error!"),
	COMMON_TOKEN_ERROE("000007","用户会话信息错误，或者过期，请重新登录！","token error，ip{0}!"),
	COMMON_USER_CODE_NOT_EMPTY("000008","用户会话信息错误，或者过期，请重新登录！","user code not empty!"),
	COMMON_USER_ILLEGAL_REQUEST("000009","用户非法请求！","user code not empty!"),
	//admin 010000
	ADMIN_ACCOUNT_NOT_EXIST("010001","账户不存在","account name[{0}] does not exist!"),
	ADMIN_ACCOUNT_PASSWORD_ERROR("010002","密码错误！","account name[{0}]，password [{1}] is error!"),
	ADMIN_ACCOUNT_ERROR("010003","系统错误，请联系后台工作人员！","account must error，account name[{0}]，password [{1}]!"),
	ADMIN_ACCOUNT_NOT_NULL("010004","用户名不能为空！","account not null!"),
	ADMIN_PASSWORD_NOT_NULL("010005","密码不能为空！","password not null!"),
	//user 020000
	USER_PASSWORD_ERROR("020001","用户名或者密码错误","account or password error!"),
	USER_MUCH_ERROR("020002","系统错误","much user,account:{0},password:{1}!"),
	USER_LOGINOUT_ERROR("020003","退出登录失败！","loginout error,userId:{0}!"),
	//good 030000
	
	//society 040000
	;
	
	
	private String retCode;
	private String retString;
	private String logString;
	public String getRetCode(){
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
	public void setRetCode(String retCode){
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
	
	private ExceptionEnum(String retCode,String retString,String logString){
		this.retCode = retCode;
		this.retString = retString;
		this.logString = logString;
    }

}
