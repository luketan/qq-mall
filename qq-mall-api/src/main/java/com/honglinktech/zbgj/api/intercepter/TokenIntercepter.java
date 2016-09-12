package com.honglinktech.zbgj.api.intercepter;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.honglinktech.zbgj.common.ErrorCode;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;

/**
 * 请求拦截器
 */
@Configuration
public class TokenIntercepter implements HandlerInterceptor {
    private final Logger logger = LogManager.getLogger(getClass());
    
    @Autowired  
    private Environment env;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	
    	String mallId = env.getProperty("system.mallId");
    	String uri = request.getRequestURI();
    	String token=request.getHeader("token");
    	System.out.println("token["+token+"],mallId["+mallId+"]"+getRemoteHost(request));
    	if(uri.indexOf("/user/login")==-1 &&
    	   uri.indexOf("/order/kd100callbac")==-1 &&
    	   uri.indexOf("/order/subscribe")==-1 &&
    	   uri.indexOf("/order/homeCount")==-1 &&
    	   uri.indexOf("/home/find/systemPara")==-1&&
    	   uri.indexOf("/platform/user/findAuthInfo")==-1){   		
    		
//        	if(StringUtils.isEmpty(token)){
//        		PrintWriter printWriter = response.getWriter();
//        		Response<Object> res = Result.fail(ErrorCode.tokenFail, "token不能为空");
//        		ObjectMapper om = new ObjectMapper();
//        		printWriter.write(om.writeValueAsString(res));
//        		printWriter.flush();
//        		return false;
//        	}
        	/*Response<UserSession> userData;
        	if(!StringUtils.isEmpty(mallId)){
        		userData = usersService.checkLoginToken(Integer.valueOf(mallId),token);
        	}else{
        		userData = usersService.checkLoginToken(0,token);
        	}
        	if(userData.getCode()!=0){
        		response.setCharacterEncoding("UTF-8");  
        		response.setContentType("application/json; charset=utf-8");  
        		PrintWriter printWriter = response.getWriter();
        		Response<Object> res = Result.fail(ErrorCode.tokenFail, userData.getMsg());
        		ObjectMapper om = new ObjectMapper();
        		printWriter.write(om.writeValueAsString(res));
        		printWriter.flush();
        		return false;
        	}*/
    	}
    	
        return true;
    }
    
    public String getRemoteHost(javax.servlet.http.HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
