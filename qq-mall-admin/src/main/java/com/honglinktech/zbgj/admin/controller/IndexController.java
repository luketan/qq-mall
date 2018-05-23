package com.honglinktech.zbgj.admin.controller;

import com.honglinktech.zbgj.admin.common.Constants;
import com.honglinktech.zbgj.entity.SystemConfig;
import com.honglinktech.zbgj.utils.HashUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 */
@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

    @RequestMapping("index")
    public String index() {
        System.out.println("===========index==============");
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "index";
        } else {
            return "redirect:login.html";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:index.html";
        } else {
            Boolean flag = subject.isRemembered();
            if (flag) {
                subject.getSession().setAttribute("isRemembered", flag);
            }
            return "login";
        }
    }

    /**
     * 登录的时候调用的接口
     *
     * @param userName
     * @param password
     * @param rememberMe
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String doLogin(String userName, String password, boolean rememberMe, Model model) {
        UsernamePasswordToken token = null;
        String msg;
        try {
            Subject subject = SecurityUtils.getSubject();
            String encryptPwd = HashUtils.encryptMD5(password, "");
            token = new UsernamePasswordToken(userName, encryptPwd);
            token.setRememberMe(rememberMe);
            subject.login(token);
            return "redirect:index.html";
        } catch (IncorrectCredentialsException e) {
            if (token != null) {
                token.clear();
            }
            msg = "认证失败!";
        } catch (Exception e) {
            if (token != null) {
                token.clear();
            }
            msg = e.getMessage();
        }
        model.addAttribute("error", msg);
        return "login";
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("logout")
    public String logout() {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.getSession().removeAttribute(Constants.PERMISSIONS);
            subject.logout();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "redirect:login.html";
    }
}
