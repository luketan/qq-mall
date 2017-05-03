package com.honglinktech.zbgj.bean.request;

/**
 * Created by Dayong on 16/3/1.
 */
public class Id extends BaseRequest {
    private String id;
    private String userCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
