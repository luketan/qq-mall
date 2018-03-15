package com.honglinktech.zbgj.enums;

/**
 * 记录类型(1:虚拟币virtual_money,2:钱money,3:商城积分point，4社区经验exp，5社区级别level)
 * Created by Dayong on 16/2/23.
 */
public enum ChangeTypeEnum {
    VirtualMoney(1, "币"), Money(2, "豆"), Point(3, "积分"), Exp(4, "经验"), Level(5, "等级");

    private int code;
    private String content;

    ChangeTypeEnum(int code, String content) {
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
