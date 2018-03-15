/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ChangeLog {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 记录对象Id(商品Id，帖子Id)
     */
    private Integer objectId;

    /**
     * 记录类型(1:币,2:红包,3:积分)
     */
    private Integer type;

    /**
     * 日志类型()
     */
    private Integer logType;

    /**
     * 变更前的数量
     */
    private BigDecimal beforeNum;

    /**
     * 变更数量数目
     */
    private BigDecimal num;

    /**
     * 变更后的数量
     */
    private BigDecimal currNum;

    /**
     * 变更批注
     */
    private String comments;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public BigDecimal getBeforeNum() {
        return beforeNum;
    }

    public void setBeforeNum(BigDecimal beforeNum) {
        this.beforeNum = beforeNum;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getCurrNum() {
        return currNum;
    }

    public void setCurrNum(BigDecimal currNum) {
        this.currNum = currNum;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}