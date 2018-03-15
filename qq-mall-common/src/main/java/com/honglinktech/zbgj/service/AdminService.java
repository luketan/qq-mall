package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Admin;
import com.honglinktech.zbgj.entity.AdminRole;

import java.util.List;
import java.util.Map;

public interface AdminService {
    /**
     * 查询管理用户列表
     * @param index
     * @param size
     * @param s
     * @param whereMap
     * @return
     */
    Page<Admin> findPageByWhere(int index, int size, String url, Map whereMap);

    /**
     *
     * @param admin
     * @param roles
     * @return
     */
    Response<Admin> saveOrUpdateAdmin(Admin admin, String[] roles);

    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     */
    Response<Admin> adminLogin(String loginName, String password);

    /**
     *
     * @param id
     * @return
     */
    Response<Admin> findAdminById(int id);

    /**
     * 查询管理用户角色
     * @param adminRoleMap
     * @return
     */
    List<AdminRole> findAdminRoleByWhere(Map adminRoleMap);
}
