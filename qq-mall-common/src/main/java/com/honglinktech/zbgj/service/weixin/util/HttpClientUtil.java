package com.honglinktech.zbgj.service.weixin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;


/**
 * 
 * @author  liuhaiming
 * @date 2015年2月13日
 */
public class HttpClientUtil {

   // private final static DimengLogger log = new DimengLogger(HttpClientUtil.class);
    
    public static Result httpRemote(String url, Parameter parameter) {
        HttpClient client = new HttpClient();
        HttpMethod method = null;
        BufferedReader br = null;
        try {
        	MethodType type = parameter.getType();
        	if(MethodType.GET == type){
        		method = getGetMethod(parameter, url);
        	}else{
        		method = getPostMethod(parameter, url);
        	}
        	method.getParams().setContentCharset("UTF-8");
            client.executeMethod(method);
            if(HttpStatus.SC_OK != method.getStatusCode()){
                return new Result(Result.FAILURE,"连接失败，" + method.getResponseBodyAsString() + " 返回状态码：" + method.getStatusCode() , parameter);
            }
            br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8"));
            StringBuilder buf = new StringBuilder();  
            String line;  
            while (null != (line = br.readLine())) {
            	if(buf == null){
            		buf = new StringBuilder();
            		buf.append(line);
            	}else{
            		buf.append("\n").append(line);  
            	}
            }
            return new Result(Result.SUCCESS, Result.SUCCESS_MSG, buf.toString());
        } catch (Exception e) {
           // log.error(e.getMessage(),e);
            return new Result(Result.FAILURE, e.getMessage(), parameter);
        } finally {
			try {
				if (br != null)
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
            if (method != null)
                method.releaseConnection();
        }
    }
    
    private static PostMethod getPostMethod(Parameter parameter, String url){
        PostMethod method = new PostMethod(url);
        Map<String,String> data = parameter.getData();
        if(data != null && !data.isEmpty()){
            for(String key : data.keySet()){
                method.addParameter(key, data.get(key));
            }
        }
        return method;
    }
    
    private static GetMethod getGetMethod(Parameter parameter, String url){
        Map<String,String> data = parameter.getData();
        StringBuilder sb = new StringBuilder();
        if(data != null && !data.isEmpty()){
            for(String key : data.keySet()){
                try {
                    sb.append("&" + key +"=" + URLEncoder.encode(data.get(key),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if(url.indexOf('?') != -1){
                url += sb.toString();
            }else{
                url += "?" + sb.substring(1);
            }
        }
        GetMethod method = new GetMethod(url);
        return method;
    }
}
