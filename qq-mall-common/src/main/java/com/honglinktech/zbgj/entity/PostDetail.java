package com.honglinktech.zbgj.entity;

/**
 * 快递详情描述
 */
public class PostDetail
{
    private String postCode; //快递编号
    private String timeNode; //时间节点
    private String addressNode; //地址节点
    private String context;//快递状态描述
    private String pushTime; //kd100推送时间
    private String IsSignIn;//是否已经签收
    private String companyCode; //快递公司代码

    public String getCompanyCode()
    {
        return companyCode;
    }

    public void setCompanyCode(String companyCode)

    {
         this.companyCode = companyCode;
    }

    public String getIsSignIn()
    {
        return IsSignIn;
    }

    public void setIsSignIn(String isSignIn)
    {
        IsSignIn = isSignIn;
    }

    public String getAddressNode()
    {
        return addressNode;
    }

    public String getPushTime()
    {
        return pushTime;
    }

    public void setPushTime(String pushTime)
    {
        this.pushTime = pushTime;
    }

    public void setAddressNode(String addressNode)
    {
        this.addressNode = addressNode;
    }


    public String getContext()
    {
        return context;
    }

    public void setContext(String context)
    {
        this.context = context;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTimeNode()
    {
        return timeNode;
    }

    public void setTimeNode(String timeNode)
    {
        this.timeNode = timeNode;
    }


}
