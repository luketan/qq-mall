/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.util.Date;

public class UserMsg {
    /**
     * 
     */
    private Integer id;

    /**
     * 发送方0是客服
     */
    private Integer userId;

    /**
     * 接收消息放
     */
    private Integer receiveUserId;

    /**
     * 内容
     */
    private String content;

    /**
     * 消息类型1聊天，2礼物，3逗币
     */
    private Integer type;

    /**
     * 价值数量
     */
    private Integer valNum;

    /**
     * 是否已读(0未读，1已读)
     */
    private Integer readIs;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

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

    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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

    public Integer getReadIs() {
        return readIs;
    }

    public void setReadIs(Integer readIs) {
        this.readIs = readIs;
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