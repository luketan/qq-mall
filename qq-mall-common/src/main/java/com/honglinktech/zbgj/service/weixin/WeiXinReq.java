/*
 * 文 件 名:  WeiXinReq.java
 * 版    权:  深圳市迪蒙网络科技有限公司
 * 描    述:  <描述>
 * 修 改 人:  tanhui
 * 修改时间:  2015年8月25日
 */
package com.honglinktech.zbgj.service.weixin;

import com.alibaba.fastjson.JSONObject;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  tanhui
 * @version  [版本号, 2015年8月25日]
 */
@XmlRootElement
public class WeiXinReq
{
    private String func;
    
    private String url;
    
    // 微信加密签名
    private String signature;
    
    //随机数
    private String nonce;
    
    //时间戳
    private String timestamp;
    
    //随机字符串
    private String echostr;
    
    public String getFunc() {
		return func;
	}


	public void setFunc(String func) {
		this.func = func;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getSignature() {
		return signature;
	}


	public void setSignature(String signature) {
		this.signature = signature;
	}


	public String getNonce() {
		return nonce;
	}


	public void setNonce(String nonce) {
		this.nonce = nonce;
	}


	public String getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	public String getEchostr() {
		return echostr;
	}


	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}


	@Override
    public String toString()
    {
        return JSONObject.toJSONString(this);
    }
}
