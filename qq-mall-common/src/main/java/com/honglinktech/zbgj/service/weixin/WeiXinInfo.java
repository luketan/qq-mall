/*
 * 文 件 名:  WeiXinReq.java
 * 版    权:  深圳市迪蒙网络科技有限公司
 * 描    述:  <描述>
 * 修 改 人:  tanhui
 * 修改时间:  2015年8月25日
 */
package com.honglinktech.zbgj.service.weixin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author tanhui
 * @version [版本号, 2015年8月25日]
 */
public class WeiXinInfo {
	
	private HttpServletRequest request;
	
	private HttpServletResponse response;

	private String func;

	private String url;

	// 微信加密签名
	private String signature;

	// 随机数
	private String nonce;

	// 时间戳
	private String timestamp;

	// 随机字符串
	private String echostr;

	public String getFunc() {
		if (StringUtils.isEmpty(func)) {
			func = this.request.getParameter("func");
		}
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}

	public String getUrl() {
		if (StringUtils.isEmpty(url)) {
			url = this.request.getParameter("url");
		}
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSignature() {
		if (StringUtils.isEmpty(signature)) {
			signature = this.request.getParameter("signature");
		}
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getNonce() {
		if (StringUtils.isEmpty(nonce)) {
			nonce = this.request.getParameter("nonce");
		}
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getTimestamp() {
		if (StringUtils.isEmpty(timestamp)) {
			timestamp = this.request.getParameter("timestamp");
		}
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getEchostr() {
		if (StringUtils.isEmpty(echostr)) {
			echostr = this.request.getParameter("echostr");
		}
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
