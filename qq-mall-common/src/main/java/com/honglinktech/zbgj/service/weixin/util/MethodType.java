package com.honglinktech.zbgj.service.weixin.util;

/**
 * 
 * @author  liuhaiming
 * @date 2015年2月13日
 */
public enum MethodType {
    
    POST("POST"),
    GET("GET");
    public String descr;
    
    private MethodType(String descr){
        this.descr = descr;
    }
    
}
