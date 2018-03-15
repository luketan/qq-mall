/**
 * @author ws
 * 2017-05-17 18:52:17
 */
package com.honglinktech.zbgj.entity;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 9033975762456704623L;
    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 真实名称
     */
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 密码加盐
     */
    private String solt;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 是否可用
     */
    private Boolean active;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSolt() {
        return solt;
    }

    public void setSolt(String solt) {
        this.solt = solt == null ? null : solt.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}