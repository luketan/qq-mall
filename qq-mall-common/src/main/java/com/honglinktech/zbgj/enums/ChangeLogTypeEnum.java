package com.honglinktech.zbgj.enums;

/**
 * 记录类型(1:虚拟币virtual_money,2:钱money,3:商城积分point，4社区经验exp，5社区级别level)
 * Created by on 16/2/23.
 */
public enum ChangeLogTypeEnum {
    Console(1, "后台管理"),
    Rgister(2, "注册奖励"),
    RgisterRec(3, "推荐注册奖励"),
    Goods(4, "购买商品"),
    GoodsDis(5, "评论商品"),
    Society(6, "发帖"),
    SocietyDis(7, "帖子评论")
    ;

    private int code;
    private String content;

    ChangeLogTypeEnum(int code, String content) {
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
