package com.honglinktech.zbgj.enums;

/**
 * Created by on 16/2/23.
 */
public enum UserStatusEnum {
    Inactivated(0, "未激活"),
    Normal(1, "正常"),
    Locking(2, "锁定"),
    Black(3, "拉黑"),
    ;

    private int code;
    private String content;

    UserStatusEnum(int code, String content) {
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
