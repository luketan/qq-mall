package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.entity.Admin;
import com.honglinktech.zbgj.entity.Role;
import com.honglinktech.zbgj.entity.Security;

import java.util.List;
import java.util.Map;

/**
 * 系统设置服务接口类
 * Created by Dayong on 16/3/15.
 */
public interface SecurityService {

	List<Role> findAllRole();
	
    Page<Role> findRoleByPage(int start, int size, String s);

    Role findRoleById(int id);

    List<Role> findRoleByAdminId(Integer adminId);

    Integer saveRole(Role role, List<Integer> adds, List<Integer> roles);

    boolean deleteRole(int id);

    /**
     * 显示角色成员列表
     * @param id 角色ID
     * @return
     */
    Map<String, List<Admin>> findAllRoleMember(int id);

    void addMember(int adminId, int roleId);

    void deleteMember(int adminId, int roleId);

    List<Security> findAllSecurity();

    Page<Security> findSecurityByPage(int start, int size, String pageUrl);

    List<Security> findSecurityByAdminId(Integer adminId);

    List<Security> findSecurityByRoleId(int id);

    Security findSecurityById(int id);

    Integer saveSecurity(Security security);

    boolean deleteSecurity(int id);

}
