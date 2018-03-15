package com.honglinktech.zbgj.service.wxmpapi;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by shon on 31/03/2017.
 *
 * @author shon
 * @date 2017/03/31
 */
public class WxMpApiAcTokenResponse implements Serializable {
    private static final long serialVersionUID = -8904119553071308883L;

    @JSONField(name = "access_token")
    private String accessToken;

    @JSONField(name = "expires_in")
    private Integer expireIn;

    @JSONField(name = "errcode")
    private Integer errCode = 0;

    @JSONField(name = "errmsg")
    private String errMsg = "";

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
