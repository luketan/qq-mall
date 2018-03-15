/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.util.Date;

public class SocietyNoteReward {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer societyNoteId;

    /**
     * 收的
     */
    private Integer userId;

    /**
     * 出的
     */
    private Integer busUserId;

    /**
     * 1打赏类型逗币，
     */
    private Integer type;

    /**
     * 价值数量
     */
    private Integer valNum;

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

    public Integer getSocietyNoteId() {
        return societyNoteId;
    }

    public void setSocietyNoteId(Integer societyNoteId) {
        this.societyNoteId = societyNoteId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBusUserId() {
        return busUserId;
    }

    public void setBusUserId(Integer busUserId) {
        this.busUserId = busUserId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getValNum() {
        return valNum;
    }

    public void setValNum(Integer valNum) {
        this.valNum = valNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}