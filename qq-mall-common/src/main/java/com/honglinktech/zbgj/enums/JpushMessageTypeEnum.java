package com.honglinktech.zbgj.enums;

/**
 * 极光推送 推送消息类型
 * Created by tangjc on 2016/3/15.
 */
public enum JpushMessageTypeEnum
{
    TranferStuff("C","转料") ,SystemInform("A","系统通知"), DraftStuff("D","提料"), BuyStaff("B","买料"), ExchangeStaff("M","兑料"),
    SaleInform("H","销售提醒"),UpdateInform("U","版本更新提醒");
    private String msgType;
    private String mstTile;

    JpushMessageTypeEnum(String msgType,String mstTile)
    {
        this.msgType = msgType;
        this.mstTile = mstTile;
    }

    public String getMsgType()
    {
        return msgType;
    }

    public String getMstTile()
    {
        return mstTile;
    }
}
