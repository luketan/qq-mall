/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

public class SocietyNoteLikeKey {
    /**
     * ID(帖子ID,或者评论ID或者评论的评论ID）
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

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
}