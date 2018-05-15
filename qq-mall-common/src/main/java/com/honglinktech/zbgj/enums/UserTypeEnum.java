package com.honglinktech.zbgj.enums;

/**
 * Created by on 16/2/23.
 */
public enum UserTypeEnum {
    General(1, "一般用户")
    ;

    private int code;
    private String content;

    UserTypeEnum(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
