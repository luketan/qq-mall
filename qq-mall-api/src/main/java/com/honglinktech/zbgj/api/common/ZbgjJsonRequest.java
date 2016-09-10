package com.honglinktech.zbgj.api.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by shon on 12/1/15.
 */
public class ZbgjJsonRequest {
    private String userCode = "";
    private String companyCode = "";
    private String token = "";
    private String forwardTo = "";
    private Map<String, Object> requstJson = null;

    public ZbgjJsonRequest() {
        this.requstJson = new LinkedHashMap<String, Object>();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, Object> getRequstJson() {
        return requstJson;
    }

    public void setRequstJson(Map<String, Object> requstJson) {
        this.requstJson = requstJson;
    }

    public String getForwardTo() {
        return forwardTo;
    }

    public void setForwardTo(String forwardTo) {
        this.forwardTo = forwardTo;
    }
}
