/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

public class UserAtteKey {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 好友ID
     */
    private Integer atteUserId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAtteUserId() {
        return atteUserId;
    }

    public void setAtteUserId(Integer atteUserId) {
        this.atteUserId = atteUserId;
    }
}