package com.honglinktech.zbgj.base;


public class ReturnInfo {

	public String code;
	public String msg;
	public Object result=null;
	
	public ReturnInfo(ExceptionEnum exceptionEnum) {
		this.code=exceptionEnum.getRetCode();
		this.msg=exceptionEnum.getRetString();
	}
	public ReturnInfo(ExceptionEnum exceptionEnum,Object...args) {
		this.code=exceptionEnum.getRetCode();
		this.msg=exceptionEnum.getRetString();
	}
	public ReturnInfo(ExceptionEnum exceptionEnum,Object result) {
		this.result = result;
		this.code=exceptionEnum.getRetCode();
		this.msg=exceptionEnum.getRetString();
	}
	public ReturnInfo(ExceptionEnum exceptionEnum,Object result,Object...args) {
		this.result = result;
		this.code=exceptionEnum.getRetCode();
		this.msg=exceptionEnum.getRetString(args);
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
//	@Override
//	public String toString() {
//		System.out.println("[code]->"+code+"[retString]->"+msg+"[obj]->"+new Gson().toJson(result));
//		return "[code]->"+code+"[msg]->"+msg+"[obj]->"+new Gson().toJson(result);
//	}
}
