/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.util.Date;

public class User {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 社区经验
     */
    private Integer exp;

    /**
     * 社区级别
     */
    private Integer level;

    /**
     * 个性签名
     */
    private String sign;

    /**
     * 头像
     */
    private String head;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否已认证(0否,1是)
     */
    private Integer emailIs;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 是否已认证(0否,1是)
     */
    private Integer phoneIs;

    /**
     * 年龄（出生年月）
     */
    private String age;

    /**
     * 性别(1男，2女)
     */
    private Integer sex;

    /**
     * 性取向(1爱好男，2爱好女，3双性恋，4无性恋，5保密)
     */
    private Integer sexu;

    /**
     * 婚恋状态(1单身，2恋爱中，3已婚，4离异)
     */
    private Integer marr;

    /**
     * 是否是体验师
     */
    private Integer tryIs;

    /**
     * 用户类型，1普通，2小编
     */
    private Integer type;

    /**
     * 状态(0未激活,1正常，2被锁定，3被拉黑)
     */
    private Integer status;

    /**
     * 
     */
    private String from;

    /**
     * 备注
     */
    private String remark;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 微信ID
     */
    private String openId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getEmailIs() {
        return emailIs;
    }

    public void setEmailIs(Integer emailIs) {
        this.emailIs = emailIs;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getPhoneIs() {
        return phoneIs;
    }

    public void setPhoneIs(Integer phoneIs) {
        this.phoneIs = phoneIs;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getSexu() {
        return sexu;
    }

    public void setSexu(Integer sexu) {
        this.sexu = sexu;
    }

    public Integer getMarr() {
        return marr;
    }

    public void setMarr(Integer marr) {
        this.marr = marr;
    }

    public Integer getTryIs() {
        return tryIs;
    }

    public void setTryIs(Integer tryIs) {
        this.tryIs = tryIs;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from == null ? null : from.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}