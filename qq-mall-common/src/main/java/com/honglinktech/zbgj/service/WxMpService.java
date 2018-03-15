package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.bean.WxMpJsTicketSignedBean;

/**
 * Created by shon on 31/03/2017.
 *
 * @author shon
 */
public interface WxMpService {
    /**
     * 签名
     * @param wxMpName 内部公众号名称，英文
     * @param url 完整url
     * @return WxMpJsTicketSignedBean
     */
    WxMpJsTicketSignedBean grantWxMpSignForUrl(String wxMpName, String url);

    /**
     * 给调度模块定时调用
     */
    void refreshAllJsTicket();
}
