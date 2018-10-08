/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.util.Date;

public class CouponUser {
    /**
     * 
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 券ID
     */
    private Integer couponId;

    /**
     * 唯一识别码
     */
    private String code;

    /**
     * 状态(0未使用，1是已使用)
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date useTime;
    /**
     * 创建时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     *
     */
    private String version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}