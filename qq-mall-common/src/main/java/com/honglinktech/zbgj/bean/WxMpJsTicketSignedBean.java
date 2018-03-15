package com.honglinktech.zbgj.bean;

import java.io.Serializable;

/**
 * Created by shon on 31/03/2017.
 *
 * @author shon
 */
public class WxMpJsTicketSignedBean implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2774371250646657130L;

    /**
     * nonceStr
     */
    private String nonceStr;
    /**
     * timestamp
     */
    private String timestamp;
    /**
     * sign
     */
    private String sign;
    /**
     * appid
     */
    private String appid;


    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
