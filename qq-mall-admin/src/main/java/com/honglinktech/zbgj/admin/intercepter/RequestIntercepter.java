package com.honglinktech.zbgj.admin.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.honglinktech.zbgj.entity.Admin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.honglinktech.zbgj.admin.common.Constants;

/**
 * 请求拦截器
 * Created by Dayong on 16/2/24.
 */
public class RequestIntercepter implements HandlerInterceptor {
    private final Logger logger = LogManager.getLogger(getClass());
    String uri;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        uri = request.getRequestURI();
        if (uri.contains("login") || uri.contains("logout")) {
            return true;
        } else {
            Session session = SecurityUtils.getSubject().getSession();
            Admin admin = (Admin) session.getAttribute(Constants.LOGIN_ADMIN_DATA);
            if (admin == null) {
                response.sendRedirect("logout.html");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
