/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.util.Date;

public class PostDetail {
    /**
     * 快递单号
     */
    private String postCode;

    /**
     * 物流详情描述
     */
    private String context;

    /**
     * 地址节点
     */
    private String addressNode;

    /**
     * 物流时间节点
     */
    private Date timeNode;

    /**
     * kd100推送时间
     */
    private Date pushTime;

    /**
     * 是否签收
     */
    private String isSignIn;

    /**
     * 
     */
    private String companyCode;

    /**
     * 删除标志
     */
    private String deleteFlag;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getAddressNode() {
        return addressNode;
    }

    public void setAddressNode(String addressNode) {
        this.addressNode = addressNode == null ? null : addressNode.trim();
    }

    public Date getTimeNode() {
        return timeNode;
    }

    public void setTimeNode(Date timeNode) {
        this.timeNode = timeNode;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public String getIsSignIn() {
        return isSignIn;
    }

    public void setIsSignIn(String isSignIn) {
        this.isSignIn = isSignIn == null ? null : isSignIn.trim();
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}