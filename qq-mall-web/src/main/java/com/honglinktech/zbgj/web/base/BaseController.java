/**
 * Copyright &copy; Honglink All rights reserved.
 */
package com.honglinktech.zbgj.web.base;

import com.honglinktech.zbgj.common.SystemArgsCache;
import com.honglinktech.zbgj.vo.UserVO;
import com.honglinktech.zbgj.web.util.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器支持类
 *
 * @author Dayong
 * @version 2016-2-03
 */
public abstract class BaseController {

    protected Logger logger = LogManager.getLogger(getClass());

    @Autowired
    protected HttpServletRequest request;

    @ModelAttribute
    public void setArgs() {
        SystemArgsCache.put("title", "珠宝管家后台管理系统");
        SystemArgsCache.put("name", "珠宝管家后台管理系统");
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
    protected UserVO getUserData() throws AuthenticationException {
        Session session = SecurityUtils.getSubject().getSession();
        UserVO user = (UserVO) session.getAttribute(Constants.LOGIN_USER);
        return user;
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
}
