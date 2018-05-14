/**
 * Copyright &copy; Honglink All rights reserved.
 */
package com.honglinktech.zbgj.web.controller;

import com.honglinktech.zbgj.bean.UserLoginBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器支持类
 *
 */
@Configuration
public abstract class BaseController {

    protected final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    protected HttpServletRequest request;
    
    @Autowired  
    private Environment env;
    
    @ModelAttribute
    public void setArgs() {

        String contextPath = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
        request.setAttribute("basePath", basePath);

    }

    /**
     * 获取当前登录用户的信息
     * @return
     */
    protected UserLoginBean getUser() throws AuthenticationException {
        Session session = SecurityUtils.getSubject().getSession();
        UserLoginBean userLoginBean = (UserLoginBean) session.getAttribute(com.honglinktech.zbgj.web.util.Constants.LOGIN_USER);
        return userLoginBean;
    }

    /**
     * 添加Model消息
     *
     * @param messages
     */
    protected void addMessage(Model model, String... messages) {
        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            sb.append(message).append(messages.length > 1 ? "<br/>" : "");
        }
        model.addAttribute("message", sb.toString());
    }

    /**
     * 添加Flash消息
     *
     * @param messages
     */
    protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            sb.append(message).append(messages.length > 1 ? "<br/>" : "");
        }
        redirectAttributes.addFlashAttribute("message", sb.toString());
    }
    /**
     * 添加Model消息
     *
     * @param messages
     */
    protected void addError(Model model, String... messages) {
        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            sb.append(message).append(messages.length > 1 ? "<br/>" : "");
        }
        model.addAttribute("error", sb.toString());
    }

    /**
     * 添加Flash消息
     *
     * @param messages
     */
    protected void addError(RedirectAttributes redirectAttributes, String... messages) {
        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            sb.append(message).append(messages.length > 1 ? "<br/>" : "");
        }
        redirectAttributes.addFlashAttribute("error", sb.toString());
    }
    
}
