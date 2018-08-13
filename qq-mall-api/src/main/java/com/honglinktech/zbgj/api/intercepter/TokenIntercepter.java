package com.honglinktech.zbgj.api.intercepter;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.annotation.NoRequireLogin;
import com.honglinktech.zbgj.annotation.RequireLogin;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.common.AppAgent;
import com.honglinktech.zbgj.common.ErrorCode;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.User;
import com.honglinktech.zbgj.service.UserService;
import com.honglinktech.zbgj.vo.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 请求拦截器
 */
@Configuration
public class TokenIntercepter implements HandlerInterceptor {
    private final Logger logger = LogManager.getLogger(getClass());
    
    @Autowired  
    private Environment env;

    /**
     * The user service
     */
    @Autowired
    private UserService userService;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (userService == null) {
            //解决service为null无法注入问题
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
            userService = (UserService) factory.getBean("userService");
        }

        HandlerMethod myHandlerMethod = (HandlerMethod) handler;
        Object bean = myHandlerMethod.getBean();
        Method method= myHandlerMethod.getMethod();
        Annotation classAnnotation = bean.getClass().getAnnotation(RequireLogin.class);//类上有该标记
        Annotation methodAnnotation=method.getAnnotation(RequireLogin.class);//方法上有该标记
        Annotation methodNologinAnnotation=method.getAnnotation(NoRequireLogin.class);//

        System.out.println("-----zbgj-user------1----: "+request.getHeader("zbgj-user"));
        if((classAnnotation!=null&&methodNologinAnnotation==null)
                ||(classAnnotation==null&&methodAnnotation!=null)){
            AppAgent agent = null;
            // 先从自定义的header获取，如获取不到再去user-agent查找
            String userInfo = request.getHeader("zbgj-user");
            if (userInfo != null && !userInfo.isEmpty()) {
                logger.info("zbgj-user: ", userInfo+", ip:"+getRemoteHost(request));
                System.out.println("-----zbgj-user: "+userInfo);
                agent = JSON.parseObject(userInfo, AppAgent.class);
                if (agent == null) {
                    write(response, "非法请求！");
                    return false;
                }
            } else {
                String userAgent = request.getHeader("User-Agent");
                logger.info("User-Agent: ", userAgent+", ip:"+getRemoteHost(request));
                agent = JSON.parseObject(userAgent, AppAgent.class);
                if (agent == null) {
                    write(response, "非法请求！");
                    return false;
                }
            }

            String token = agent.getToken();
            if (StringUtils.isEmpty(token)) {
                writeTokenExpiredResponse(response);
                return false;
            }

            UserVO user = userService.getByToken(token);
            System.out.print("==========user==============="+JSON.toJSONString(user));
            if (user == null) {
                writeTokenExpiredResponse(response);
                return false;
            }

            request.setAttribute("agent", agent);
            request.setAttribute("user", user);
        }else{//不需要校验，有时也需要获取用户信息

            AppAgent agent = null;
            // 先从自定义的header获取，如获取不到再去user-agent查找
            String userInfo = request.getHeader("zbgj-user");
            if (!StringUtils.isEmpty(userInfo)) {
                logger.info("zbgj-user: ", userInfo+", ip:"+getRemoteHost(request));
                agent = JSON.parseObject(userInfo, AppAgent.class);

            } else {
                String userAgent = request.getHeader("User-Agent");
                if(!StringUtils.isEmpty(userAgent)){
                    logger.info("User-Agent: ", userAgent+", ip:"+getRemoteHost(request));
                    agent = JSON.parseObject(userAgent, AppAgent.class);
                }
            }
            if(agent == null){
                return true;
            }

            String token = agent.getToken();
            if (!StringUtils.isEmpty(token)) {
                UserVO user = userService.getByToken(token);
                if (user != null) {
                    request.setAttribute("user", user);
                    request.setAttribute("agent", agent);
                }
            }

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

    /**
     * 把返回内容写到请求返回里面去
     *
     * @param response HTTP请求
     * @param content 返回内容
     */
    private void write(HttpServletResponse response, String content) {
        response.setContentType("application/json;charset=UTF-8");
        Writer writer = null;
        try {
            writer = response.getWriter();
            writer.write(JSON.toJSONString(Result.fail(content)));
            writer.flush();
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }
    /**
     * 返回Token超时给客户端
     * @param response HTTP请求返回
     */
    private void writeTokenExpiredResponse(HttpServletResponse response) {
        response.setContentType("application/json;charset=UTF-8");
        Writer writer = null;
        try {
            writer = response.getWriter();
            writer.write(JSON.toJSONString(Result.fail(ExceptionEnum.COMMON_TOKEN_FAIL, "登陆态过期")));
            writer.flush();
        } catch (IOException e) {
            logger.error(e, e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                logger.error(e, e);
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
