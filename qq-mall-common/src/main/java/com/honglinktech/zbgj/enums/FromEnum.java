package com.honglinktech.zbgj.enums;

/**
 * Created by on 16/2/23.
 */
public enum FromEnum {
    WXAPPLET("微信小程序"),
    WXWEB("微信网页"),
    APP("手机APP"),
    WEB("网页浏览器"),
    ;

    private String content;

    FromEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
