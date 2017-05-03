/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.util.Date;

public class UserFriend extends UserFriendKey {
    /**
     * 类型（1：好友申请，2：好友，3陌生人）
     */
    private Integer type;

    /**
     * 好友名字
     */
    private String friendUserName;

    /**
     * 好友经理头像
     */
    private String friendUserHead;

    /**
     * 好友等级
     */
    private Integer friendUserLevel;

    /**
     * 
     */
    private Integer friendMoney;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFriendUserName() {
        return friendUserName;
    }

    public void setFriendUserName(String friendUserName) {
        this.friendUserName = friendUserName == null ? null : friendUserName.trim();
    }

    public String getFriendUserHead() {
        return friendUserHead;
    }

    public void setFriendUserHead(String friendUserHead) {
        this.friendUserHead = friendUserHead == null ? null : friendUserHead.trim();
    }

    public Integer getFriendUserLevel() {
        return friendUserLevel;
    }

    public void setFriendUserLevel(Integer friendUserLevel) {
        this.friendUserLevel = friendUserLevel;
    }

    public Integer getFriendMoney() {
        return friendMoney;
    }

    public void setFriendMoney(Integer friendMoney) {
        this.friendMoney = friendMoney;
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
}