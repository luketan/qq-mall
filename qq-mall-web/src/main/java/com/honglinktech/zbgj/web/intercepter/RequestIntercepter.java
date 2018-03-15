package com.honglinktech.zbgj.web.intercepter;

import com.honglinktech.zbgj.vo.UserVO;
import com.honglinktech.zbgj.web.util.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求拦截器
 */
public class RequestIntercepter implements HandlerInterceptor {
    private final Logger logger = LogManager.getLogger(getClass());
    String uri;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        uri = request.getRequestURI();
//        if (uri.contains("login") || uri.contains("logout")) {
//            return true;
//        } else {
//            Session session = SecurityUtils.getSubject().getSession();
//            UserVO user = (UserVO) session.getAttribute(Constants.LOGIN_USER_DATA);
//            if (user == null) {
//                response.sendRedirect("/logout.html");
//                return false;
//            }
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
