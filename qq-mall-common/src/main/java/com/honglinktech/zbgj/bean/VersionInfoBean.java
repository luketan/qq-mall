package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class VersionInfoBean implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -8470546564897472441L;

    /**
     *  最低版本
     */
    private Integer id;

    /**
     * 最低版本
     */
    private String lowestVersion;

    /**
     * 最新版本
     */
    private String latestVersion;

    /**
     * 标题
     */
    private String title;

    /**
     * 更新提示内容
     */
    private String updateInfo;
    /**
     * 备注
     */
    private String remark;
    /**
     * 文件的SHA-1值
     */
    private String sha;

    /**
     * 更新的url
     */
    private String updateUrl;

    /**
     * fileSize
     */
    private String fileSize;

    /**
     * 系统类型，platform(平台)，company(商户版)
     */
    private String type;

    /**
     * android or ios
     */
    private String osType;

    /**
     * 是否强制更新
     */
    private Boolean enforce;

    /**
     * 状态(0,未激活，1激活)
     */
    private Integer status;

    /**
     *  updateTime
     */
    private Date updateTime;

    /**
     *  createTime
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLowestVersion() {
        return lowestVersion;
    }

    public void setLowestVersion(String lowestVersion) {
        this.lowestVersion = lowestVersion == null ? null : lowestVersion.trim();
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion == null ? null : latestVersion.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo == null ? null : updateInfo.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl == null ? null : updateUrl.trim();
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType == null ? null : osType.trim();
    }

    public Boolean getEnforce() {
        return enforce;
    }

    public void setEnforce(Boolean enforce) {
        this.enforce = enforce;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
