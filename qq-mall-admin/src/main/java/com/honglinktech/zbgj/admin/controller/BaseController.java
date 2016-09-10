/**
 * Copyright &copy; Honglink All rights reserved.
 */
package com.honglinktech.zbgj.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.honglinktech.zbgj.admin.common.Constants;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.SystemArgsCache;
import com.honglinktech.zbgj.entity.CAdmin;

/**
 * 控制器支持类
 *
 * @author Dayong
 * @version 2016-2-03
 */
@Configuration
public abstract class BaseController {

    protected Logger logger = LogManager.getLogger(getClass());

    @Autowired
    protected HttpServletRequest request;
    
    @Autowired  
    private Environment env;
    
    @ModelAttribute
    public void setArgs() {
    	String mallName = env.getProperty("system.mallName");
        SystemArgsCache.put("title", mallName+"后台管理系统");
        SystemArgsCache.put("name", mallName+"后台管理系统");
        request.setAttribute("site", SystemArgsCache.getMap());
        
        
        String uri = request.getRequestURI();
        String[] path = uri.replace(".", "/").split("/");
        if (path.length > 0) {
            String selectMenu = path[1];
            request.setAttribute("selectMenu", selectMenu);
        }
    }

    /**
     * 获取当前登录用户的信息
     * @return
     */
    protected CAdmin getAdmin() throws AuthenticationException {
        Session session = SecurityUtils.getSubject().getSession();
        CAdmin admin = (CAdmin) session.getAttribute(Constants.LOGIN_ADMIN_DATA);
        return admin;
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
