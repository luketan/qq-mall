package com.honglinktech.zbgj.service.weixin.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 
 * @author tanhui
 */
public class HttpCore {
	
	public JsonObject getJSON(String url) throws Exception {
		System.out.println("weixin httpcline:" + url);
		Parameter parameter = new Parameter();
		parameter.setType(MethodType.GET);
		Result result = HttpClientUtil.httpRemote(url, parameter);
		if (Result.SUCCESS.equals(result.getCode())) {

			String resultJson = String.valueOf(result.getData());
			JsonParser jp = new JsonParser();
			JsonElement jsonElement = jp.parse(resultJson);
			return jsonElement.getAsJsonObject();
		} else {
			
			throw new Exception(result.getMsg());
		}

	}

	public static void main(String[] args) throws Exception {
		HttpCore hc = new HttpCore();
		hc.getJSON("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc699f8967d702406&secret=1f2c61c56e3f2074ddc5f8222e6b2daf");
	}
}
