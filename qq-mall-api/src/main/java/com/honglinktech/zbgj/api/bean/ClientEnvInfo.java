package com.honglinktech.zbgj.api.bean;


import java.util.Map;

import com.honglinktech.zbgj.utils.JsonHelper;

/**
 * Created by shon on 12/19/15.
 */
public class ClientEnvInfo {
    private String osVersion = "";
    private String device = "";
    private String appVersion = "";
    private String platform = "";
    private String latitude = "";
    private String longitude = "";
    private String lastErrorMessage = "";
    private int appBundleVersion = 0;

    public ClientEnvInfo() {
        this.reset();
    }

    public int getAppBundleVersion() {
        return appBundleVersion;
    }

    public void setAppBundleVersion(int appBundleVersion) {
        this.appBundleVersion = appBundleVersion;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public void setLastErrorMessage(String lastErrorMessage) {
        this.lastErrorMessage = lastErrorMessage;
    }

    public void reset() {
        this.osVersion = "";
        this.device = "";
        this.appVersion = "";
        this.platform = "";
        this.latitude = "";
        this.longitude = "";
        this.lastErrorMessage = "";
    }

    public boolean parseJsonFromHeaderUserAgent(String jsonUserAgent) {
        this.reset();
        try {
            Map<String, Object> userAgentMap = JsonHelper.jsonStr2Map(jsonUserAgent);
            if (userAgentMap.containsKey("device")) {
                this.setDevice(userAgentMap.get("device").toString());
            }
            if (userAgentMap.containsKey("version")) {
                this.setOsVersion(userAgentMap.get("version").toString());
            }
            if (userAgentMap.containsKey("zbgj")) {
                this.setAppVersion(userAgentMap.get("zbgj").toString());
            }
            if (userAgentMap.containsKey("platform")) {
                this.setPlatform(userAgentMap.get("platform").toString());
            }
            if (userAgentMap.containsKey("latitude")) {
                this.setLatitude(userAgentMap.get("latitude").toString());
            }
            if (userAgentMap.containsKey("longitude")) {
                this.setLongitude(userAgentMap.get("longitude").toString());
            }
            if (userAgentMap.containsKey("zbgj_version")) {
                this.setAppBundleVersion(Integer.parseInt(userAgentMap.get("zbgj_version").toString()));
            }

            return true;
        } catch (Exception ex) {
            this.setLastErrorMessage(ex.toString());
        }

        return false;
    }

    public boolean isAndroid() {
        return platform.equals("Android");
    }

    public boolean isIOS() {
        return platform.equals("iOS");
    }
}
