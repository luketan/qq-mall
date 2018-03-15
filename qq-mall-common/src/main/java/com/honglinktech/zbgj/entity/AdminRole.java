/**
 * @author ws
 * 2017-05-17 18:52:17
 */
package com.honglinktech.zbgj.entity;

public class AdminRole {
    /**
     * 
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer adminId;

    /**
     * 角色ID
     */
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}