package com.honglinktech.zbgj.vo;

import com.honglinktech.zbgj.entity.User;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/7.
 */
public class UserVO  implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 6882367935780127306L;
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 微信昵称
     */
    private String wxNickName;
    /**
     * 微信头像
     */
    private String wxHead;

    /**
     * 账号
     */
    private String account;

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
     * 创建时间
     */
    private Date createTime;


    /**********************************************************
     * 虚拟币(逗币)
     */
    private BigDecimal virtualMoney;

    /**
     * 账户余额
     */
    private BigDecimal money;

    /**
     * 商城积分
     */
    private Integer point;

    /**
     * 社区经验
     */
    private Integer exp;

    /**
     * 社区级别
     */
    private Integer level;

    public UserVO(){}

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
        this.nickName = nickName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        this.phone = phone;
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
        this.age = age;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getVirtualMoney() {
        return virtualMoney;
    }

    public void setVirtualMoney(BigDecimal virtualMoney) {
        this.virtualMoney = virtualMoney;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
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

    public String getWxNickName() {
        return wxNickName;
    }

    public void setWxNickName(String wxNickName) {
        this.wxNickName = wxNickName;
    }

    public String getWxHead() {
        return wxHead;
    }

    public void setWxHead(String wxHead) {
        this.wxHead = wxHead;
    }
}
