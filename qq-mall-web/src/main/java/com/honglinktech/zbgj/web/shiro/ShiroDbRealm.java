package com.honglinktech.zbgj.web.shiro;

import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Role;
import com.honglinktech.zbgj.entity.Security;
import com.honglinktech.zbgj.service.SecurityService;
import com.honglinktech.zbgj.service.SystemService;
import com.honglinktech.zbgj.service.UserService;
import com.honglinktech.zbgj.vo.UserLoginVO;
import com.honglinktech.zbgj.vo.UserVO;
import com.honglinktech.zbgj.web.util.Constants;
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

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


public class ShiroDbRealm extends AuthorizingRealm {
    protected final Logger logger = LogManager.getLogger(getClass());

    @Resource
    private SystemService systemService;

    @Resource
    private SecurityService securityService;

    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Session session = SecurityUtils.getSubject().getSession();
        Object permissions = session.getAttribute(Constants.PERMISSIONS);
        if (permissions != null) {
            return (SimpleAuthorizationInfo) permissions;
        } else {
            // TODO 这里可以考虑把权限的信息都放到内存里面
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            UserVO user = (UserVO) session.getAttribute(Constants.LOGIN_USER_DATA);
            if (user != null) {
                // 获取当前管理员的登录名称
                Integer userId = user.getId();
                List<String> permissionList = new ArrayList<String>();
                if (userId != null || userId > 0) {
                    List<Security> list = securityService.findSecurityByAdminId(userId);
                    for (Security security : list) {
                        permissionList.add(security.getCode());
                    }
                    // 给当前管理员设置角色
                    List<Role> roles = securityService.findRoleByAdminId(userId);
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
            Response<UserLoginVO> userLoginDataResponse = userService.login( username, password);
            if (0!=userLoginDataResponse.getCode()) {
                throw new AuthenticationException("用户名或密码错误！");
            }
            UserLoginVO userLoginData = userLoginDataResponse.getResult();


            List<Security> list = securityService.findSecurityByAdminId(userLoginData.getUserVO().getId());
            if (list == null || list.size() == 0) {
                // 无权限，禁止登录
                throw new AuthorizationException("登录失效!账号无权限!");
            }

            Session session = SecurityUtils.getSubject().getSession();
            session.setTimeout(3600000);
            session.setAttribute(Constants.LOGIN_USER_DATA, userLoginData);
            return new SimpleAuthenticationInfo(username, password, username);
            //SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, username);
            //authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username + username));
            //return authenticationInfo;
        } catch (AuthorizationException e) {
            throw new AuthenticationException(e.getMessage());
        } catch (Exception e) {
            logger.error(e);
            throw new AuthenticationException("登录失败!");
        }
    }
}
