package com.honglinktech.zbgj.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by shon on 31/03/2017.
 *
 * @author shon
 * @date 2017/03/31
 */
public class WxMpJsTicket implements Serializable {
    private static final long serialVersionUID = 1345844109504383030L;

    private String wxMpName;
    private String jsTicket;
    private Date expDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getWxMpName() {
        return wxMpName;
    }

    public void setWxMpName(String wxMpName) {
        this.wxMpName = wxMpName;
    }

    public String getJsTicket() {
        return jsTicket;
    }

    public void setJsTicket(String jsTicket) {
        this.jsTicket = jsTicket;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }
}
