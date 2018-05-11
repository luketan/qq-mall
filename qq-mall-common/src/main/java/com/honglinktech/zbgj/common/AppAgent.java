package com.honglinktech.zbgj.common;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by Dayong on 16/9/15.
 */
public class AppAgent implements Serializable {

    private static final long serialVersionUID = -4591626563264806026L;
    /**
     * IP地址
     */
    private String ip = "";
    /**
     * 登录句柄
     */
    private String token = "";
    /**
     * 设备编号
     */
    private String device = "";
    /**
     * 平台
     */
    private String platform = "";
    /**
     * 纬度
     */
    private String latitude = "";
    /**
     * 经度
     */
    private String longitude = "";
    /**
     * 系统版本
     */
    private String osVersion = "";
    /**
     * 应用版本
     */
    private String appVersion = "";
    /**
     * 内部版本
     */
    private int bundleVersion = 0;

    /**
     * Gets ip.
     *
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Sets ip.
     *
     * @param ip the ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Gets device.
     *
     * @return the device
     */
    public String getDevice() {
        return device;
    }

    /**
     * Sets device.
     *
     * @param device the device
     */
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * Gets platform.
     *
     * @return the platform
     */
    @JSONField(name = "platform")
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets platform.
     *
     * @param platform the platform
     */
    @JSONField(name = "platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude.
     *
     * @param latitude the latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude.
     *
     * @param longitude the longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets os version.
     *
     * @return the os version
     */
    @JSONField(name = "version")
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * Sets os version.
     *
     * @param osVersion the os version
     */
    @JSONField(name = "version")
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    /**
     * Gets app version.
     *
     * @return the app version
     */
    @JSONField(name = "zbgj")
    public String getAppVersion() {
        return appVersion;
    }

    /**
     * Sets app version.
     *
     * @param appVersion the app version
     */
    @JSONField(name = "zbgj")
    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    /**
     * Gets bundle version.
     *
     * @return the bundle version
     */
    @JSONField(name = "zbgj_version")
    public int getBundleVersion() {
        return bundleVersion;
    }

    /**
     * Sets bundle version.
     *
     * @param bundleVersion the bundle version
     */
    @JSONField(name = "zbgj_version")
    public void setBundleVersion(int bundleVersion) {
        this.bundleVersion = bundleVersion;
    }

    /**
     * Is android boolean.
     *
     * @return the boolean
     */
    public boolean isAndroid() {
        return platform.equals("Android");
    }

    /**
     * Is ios boolean.
     *
     * @return the boolean
     */
    public boolean isIOS() {
        return platform.equals("iOS");
    }
}
