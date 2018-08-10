package com.honglinktech.zbgj.bean;

import java.util.Date;

/**
 * Created by tangjc on 2016/3/29.
 */
public class PostDetailBean {
    //    private String expressNo; //快递编号
    private Date timeNode; //时间节点
    private String addressNode; //地址节点
    private String context;//快递状态描述
    private String IsSignIn;//是否已经签收

    public String getIsSignIn() {
        return IsSignIn;
    }

    public void setIsSignIn(String isSignIn) {
        IsSignIn = isSignIn;
    }

    public String getAddressNode() {
        return addressNode;
    }

    public void setAddressNode(String addressNode) {
        this.addressNode = addressNode;
    }


    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

//    public String getExpressNo()
//    {
//        return expressNo;
//    }

//    public void setExpressNo(String expressNo)
//    {
//        this.expressNo = expressNo;
//    }


    public Date getTimeNode() {
        return timeNode;
    }

    public void setTimeNode(Date timeNode) {
        this.timeNode = timeNode;
    }
}
