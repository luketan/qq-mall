package com.honglinktech.zbgj.admin.shiro;

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


public class ShiroDbRealm extends AuthorizingRealm {
    protected final Logger logger = LogManager.getLogger(getClass());

//    @Resource
//    private CSecurityService securityService;
//
//    @Autowired  
//    private UsersService usersService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Session session = SecurityUtils.getSubject().getSession();
        Object permissions = session.getAttribute(Constants.PERMISSIONS);
        if (permissions != null) {
            return (SimpleAuthorizationInfo) permissions;
        } else {
            // TODO 这里可以考虑把权限的信息都放到内存里面
//            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//            CAdmin admin = (CAdmin) session.getAttribute(Constants.LOGIN_ADMIN_DATA);
//            if (admin != null) {
//                // 获取当前管理员的登录名称
//                Integer adminId = admin.getId();
//                List<String> permissionList = new ArrayList<String>();
//                if (adminId != null || adminId > 0) {
//                    List<CSecurity> list = systemService.findSecurityByAdminId(adminId);
//                    for (CSecurity security : list) {
//                        permissionList.add(security.getCode());
//                    }
//                    // 给当前管理员设置角色
//                    List<CRole> roles = systemService.findRoleByAdminId(adminId);
//                    for (CRole role : roles) {
//                        info.addRole(role.getName());
//                    }
//                    // 给当前管理员设置权限
//                    info.addStringPermissions(permissionList);
//                    session.setTimeout(3600000);
//                    session.setAttribute(Constants.PERMISSIONS, info);
//                    return info;
//                }
//            }
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
//            Response<Admin> response = usersService.adminLogin(ServiceInfo.SVID_DAHOUTAI, username, password, "");
//            if (response.getCode() != 0) {
//                throw new AuthenticationException(response.getMsg());
//            }
//            Admin admin = response.getResult();
//            Session session = SecurityUtils.getSubject().getSession();
//            session.setTimeout(3600000);
//            session.setAttribute(Constants.LOGIN_ADMIN_DATA, admin);
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
