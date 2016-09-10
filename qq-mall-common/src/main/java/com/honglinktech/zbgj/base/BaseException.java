package com.honglinktech.zbgj.base;

import org.springframework.util.StringUtils;

public class BaseException extends Exception {
	private ExceptionEnum exceptionEnum;
	public BaseException(ExceptionEnum exceptionEnum) {
		super("["+exceptionEnum.getRetCode()+"]"+exceptionEnum.getRetString());
		this.exceptionEnum = exceptionEnum;
	}
	public BaseException(ExceptionEnum exceptionEnum,String args) {
		super("["+exceptionEnum.getRetCode()+"]"+exceptionEnum.getRetString(args)+"|"+exceptionEnum.getLogString(args));
		this.exceptionEnum = exceptionEnum;
		exceptionEnum.setRetString(exceptionEnum.getRetString(args));
		exceptionEnum.setLogString(exceptionEnum.getLogString(args));
	}
    public BaseException() {
        super();
        this.exceptionEnum = ExceptionEnum.COMMON_ERROE;
    }
    public BaseException(String message){
        super(message);
        ExceptionEnum ee = ExceptionEnum.COMMON_ERROE;
        if(!StringUtils.isEmpty(message))
        ee.setRetString(message);
     	this.exceptionEnum = ee;
        
    }
    public BaseException(String message,String code, ExceptionEnum exceptionEnum) {
        super(message);
        this.exceptionEnum = exceptionEnum;
        if(!StringUtils.isEmpty(code)){
        	exceptionEnum.setRetCode(code);
        }
        if(!StringUtils.isEmpty(message)){
        	exceptionEnum.setRetString(message);
        }
    }
	public BaseException(String message,String code, Throwable cause, ExceptionEnum exceptionEnum) {
        super(message, cause);
        this.exceptionEnum = exceptionEnum;
        if(!StringUtils.isEmpty(code)){
        	exceptionEnum.setRetCode(code);
        }
        if(!StringUtils.isEmpty(message)){
        	exceptionEnum.setRetString(message);
        }
    }
    public BaseException(Throwable cause, ExceptionEnum exceptionEnum) {
        super(cause);
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
  		return exceptionEnum;
  	}
  	public void setExceptionEnum(ExceptionEnum exceptionEnum) {
  		this.exceptionEnum = exceptionEnum;
  	}
  	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4022481413371743737L;
	
}
