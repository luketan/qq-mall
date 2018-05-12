package com.honglinktech.zbgj.admin.shiro;

import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Admin;
import com.honglinktech.zbgj.entity.Role;
import com.honglinktech.zbgj.entity.Security;
import com.honglinktech.zbgj.entity.SystemConfig;
import com.honglinktech.zbgj.service.AdminService;
import com.honglinktech.zbgj.service.SecurityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import com.honglinktech.zbgj.admin.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class ShiroDbRealm extends AuthorizingRealm {
    protected final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private SecurityService securityService;

    @Autowired
    private AdminService adminService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("&*&*&*&****&*");
        Session session = SecurityUtils.getSubject().getSession();
        Object permissions = session.getAttribute(Constants.PERMISSIONS);
        if (permissions != null) {
            System.out.println("&*&*&*&****&*permissions=null");
            return (SimpleAuthorizationInfo) permissions;
        } else {
            // TODO 这里可以考虑把权限的信息都放到内存里面
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            Admin admin = (Admin) session.getAttribute(Constants.LOGIN_ADMIN_DATA);
            System.out.println("&*&*&*&****&*admin=null");
            if (admin != null) {
                // 获取当前管理员的登录名称
                Integer adminId = admin.getId();
                List<String> permissionList = new ArrayList<String>();
                System.out.println(adminId+"++++&*&*&*&****&*permissionList=null"+permissionList);
                if (adminId != null || adminId > 0) {
                    List<Security> list = securityService.findSecurityByAdminId(adminId);
                    for (Security security : list) {
                        System.out.println(security.getName());
                        permissionList.add(security.getCode());
                    }
                    // 给当前管理员设置角色
                    List<Role> roles = securityService.findRoleByAdminId(adminId);
                    for (Role role : roles) {
                        info.addRole(role.getName());
                    }
                    // 给当前管理员设置权限
                    info.addStringPermissions(permissionList);
                    session.setTimeout(3600000);
                    session.setAttribute(Constants.PERMISSIONS, info);
                    return info;
                }
            }
            throw new AuthorizationException("登录失效!请重新登录!");
        }
    }

    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authToken;
        try {
            String username = token.getUsername();
            String password = new String(token.getPassword());
            System.out.println("*****************************************" + username+"____" + password);
            Response<Admin> response = adminService.adminLogin(username, password);
            if (0!=response.getCode()) {
                throw new AuthenticationException(response.getMsg());
            }
            Admin admin = response.getResult();
            Session session = SecurityUtils.getSubject().getSession();
            session.setTimeout(3600000);
            session.setAttribute(Constants.LOGIN_ADMIN_DATA, admin);
            System.out.println(Constants.LOGIN_ADMIN_DATA + "*****************************************admin="+admin);
            return new SimpleAuthenticationInfo(username, password, username);
            //SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, username);
            //authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username + username));
            //return authenticationInfo;
        } catch (AuthenticationException e) {
            throw new AuthenticationException(e.getMessage());
        } catch (Exception e) {
        	e.printStackTrace();
            logger.error(e);
            throw new AuthenticationException("登录失败!");
        }
    }
}
