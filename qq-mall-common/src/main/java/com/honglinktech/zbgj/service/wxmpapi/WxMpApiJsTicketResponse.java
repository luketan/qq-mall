package com.honglinktech.zbgj.service.wxmpapi;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by shon on 31/03/2017.
 *
 * @author shon
 * @date 2017/03/31
 */
public class WxMpApiJsTicketResponse implements Serializable {
    private static final long serialVersionUID = 2530262464762758702L;

    @JSONField(name = "ticket")
    private String ticket;

    @JSONField(name = "expires_in")
    private Integer expireIn;

    @JSONField(name = "errcode")
    private Integer errCode = 0;

    @JSONField(name = "errmsg")
    private String errMsg = "";

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
