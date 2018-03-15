/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.util.Date;

public class SocietyDisDis {
    /**
     * 
     */
    private Integer id;

    /**
     * 评论ID
     */
    private Integer societyDisId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String userName;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 是否有图片0没有，1有
     */
    private Integer imgIs;

    /**
     * 跟帖的上级（0表示回复帖子）
     */
    private Integer parent;

    /**
     * 点赞数量
     */
    private Integer goodNum;

    /**
     * 
     */
    private Integer replyUserId;

    /**
     * 
     */
    private String replyUserName;

    /**
     * 0正常
     */
    private Integer status;

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

    public Integer getSocietyDisId() {
        return societyDisId;
    }

    public void setSocietyDisId(Integer societyDisId) {
        this.societyDisId = societyDisId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getImgIs() {
        return imgIs;
    }

    public void setImgIs(Integer imgIs) {
        this.imgIs = imgIs;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public Integer getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Integer replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName == null ? null : replyUserName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}