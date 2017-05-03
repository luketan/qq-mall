/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.util.Date;

public class PostCompany {
    /**
     * 
     */
    private Integer id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 负责人
     */
    private String director;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 接口地址
     */
    private String apiUrl;

    /**
     * 接口帐号
     */
    private String apiAccount;

    /**
     * 接口代码|KEY
     */
    private String apiCode;

    /**
     * 接口密码
     */
    private String apiPassword;

    /**
     * 快递公司编码(要跟快递100对应)
     */
    private String code;

    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl == null ? null : apiUrl.trim();
    }

    public String getApiAccount() {
        return apiAccount;
    }

    public void setApiAccount(String apiAccount) {
        this.apiAccount = apiAccount == null ? null : apiAccount.trim();
    }

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode == null ? null : apiCode.trim();
    }

    public String getApiPassword() {
        return apiPassword;
    }

    public void setApiPassword(String apiPassword) {
        this.apiPassword = apiPassword == null ? null : apiPassword.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}