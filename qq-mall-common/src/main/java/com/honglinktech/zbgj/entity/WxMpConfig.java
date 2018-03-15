package com.honglinktech.zbgj.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by shon on 31/03/2017.
 *
 * @author shon
 * @date 2017/03/31
 */
public class WxMpConfig implements Serializable {
    private static final long serialVersionUID = 7075661701074487748L;

    private String wxMpName;
    private String appId;
    private String appSecret;
    private String token;
    private String baseHost;
    private Date expDate;
    private Integer needJsTicket;

    public Integer getNeedJsTicket() {
        return needJsTicket;
    }

    public void setNeedJsTicket(Integer needJsTicket) {
        this.needJsTicket = needJsTicket;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getWxMpName() {
        return wxMpName;
    }

    public void setWxMpName(String wxMpName) {
        this.wxMpName = wxMpName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getBaseHost() {
        return baseHost;
    }

    public void setBaseHost(String baseHost) {
        this.baseHost = baseHost;
    }
}
