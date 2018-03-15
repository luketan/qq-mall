/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.util.Date;

public class SocietyDis {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer societyNoteId;

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
     * 是否有回复,0没有，1有
     */
    private Integer replyIs;

    /**
     * 点赞数量
     */
    private Integer goodNum;

    /**
     * 跟帖的上级（0表示回复帖子）
     */
    private Integer parent;

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

    public Integer getReplyIs() {
        return replyIs;
    }

    public void setReplyIs(Integer replyIs) {
        this.replyIs = replyIs;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
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