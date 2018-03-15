package com.honglinktech.zbgj.service.payment.ebankpay;

/**
 * Created by shon on 3/16/16.
 */
public class EBankPayOrderOrig {
    private String masterId;
    private String orderId;
    private String amount;
    private String payDate;
    private String docNum;


    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String genStr() {
        String strOrig = "<kColl id=\"inputOrig\" append=\"false\"><field id=\"masterId\" value=\"@masterId\"/><field id=\"orderId\" value=\"@orderId\"/><field id=\"transtype\" value=\"01\" append=\"false\"/><field id=\"currency\" value=\"RMB\"/><field id=\"amount\" value=\"@amount\"/><field id=\"paydate\" value=\"@paydate\"/><field id=\"remark\" value=\"JL\"/><field id=\"objectName\" value=\"@docnum\"/><field id=\"validtime\" value=\"15000000\"/></kColl>";

        strOrig = strOrig.replace("@masterId", this.masterId);
        strOrig = strOrig.replace("@orderId", this.orderId);
        strOrig = strOrig.replace("@amount", this.amount);
        strOrig = strOrig.replace("@paydate", this.payDate);
        strOrig = strOrig.replace("@docnum", this.docNum);

        return strOrig;
    }

}
