/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.util.Date;

public class SocietyNote {
    /**
     * 
     */
    private Integer id;

    /**
     * 社区主题id
     */
    private Integer societySubId;

    /**
     * 帖子类型名称
     */
    private String societySubName;

    /**
     * 
     */
    private Integer userId;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 标题
     */
    private String title;

    /**
     * 帖子详情
     */
    private String detail;

    /**
     * 发表地址
     */
    private String address;

    /**
     * 发表的ip地址
     */
    private String ip;

    /**
     * 点赞数量
     */
    private Integer goodNum;

    /**
     * 评论数量
     */
    private Integer disNum;

    /**
     * 是否置顶
     */
    private Integer topIs;

    /**
     * 是否推荐
     */
    private Integer recIs;

    /**
     * 是否是精品
     */
    private Integer giftsIs;

    /**
     * 是否有图片(0没有)
     */
    private Integer imgIs;

    /**
     * 是否打赏
     */
    private Integer rewardIs;

    /**
     * 0社区公告，1是社区讨论帖子，2是体验贴，
     */
    private Integer type;

    /**
     * 是否匿名发帖
     */
    private Integer anoIs;

    /**
     * 是否是公告(0不是，1是)
     */
    private Integer annIs;

    /**
     * 1是待审核，2是已经审核通过
     */
    private Integer status;

    /**
     * 帖子标签
     */
    private String tags;

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

    public Integer getSocietySubId() {
        return societySubId;
    }

    public void setSocietySubId(Integer societySubId) {
        this.societySubId = societySubId;
    }

    public String getSocietySubName() {
        return societySubName;
    }

    public void setSocietySubName(String societySubName) {
        this.societySubName = societySubName == null ? null : societySubName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public Integer getDisNum() {
        return disNum;
    }

    public void setDisNum(Integer disNum) {
        this.disNum = disNum;
    }

    public Integer getTopIs() {
        return topIs;
    }

    public void setTopIs(Integer topIs) {
        this.topIs = topIs;
    }

    public Integer getRecIs() {
        return recIs;
    }

    public void setRecIs(Integer recIs) {
        this.recIs = recIs;
    }

    public Integer getGiftsIs() {
        return giftsIs;
    }

    public void setGiftsIs(Integer giftsIs) {
        this.giftsIs = giftsIs;
    }

    public Integer getImgIs() {
        return imgIs;
    }

    public void setImgIs(Integer imgIs) {
        this.imgIs = imgIs;
    }

    public Integer getRewardIs() {
        return rewardIs;
    }

    public void setRewardIs(Integer rewardIs) {
        this.rewardIs = rewardIs;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAnoIs() {
        return anoIs;
    }

    public void setAnoIs(Integer anoIs) {
        this.anoIs = anoIs;
    }

    public Integer getAnnIs() {
        return annIs;
    }

    public void setAnnIs(Integer annIs) {
        this.annIs = annIs;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
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