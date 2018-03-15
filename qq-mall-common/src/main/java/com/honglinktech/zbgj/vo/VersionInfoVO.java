package com.honglinktech.zbgj.vo;

import java.io.Serializable;

/**
 * Created by shon on 9/20/16.
 */
public class VersionInfoVO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 5738473727048113750L;
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
     *
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
     * 是否强制更新
     */
    private Boolean enforce;

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
        this.lowestVersion = lowestVersion;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
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
        this.updateInfo = updateInfo;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Boolean getEnforce() {
        return enforce;
    }

    public void setEnforce(Boolean enforce) {
        this.enforce = enforce;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }
}
