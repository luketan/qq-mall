package com.honglinktech.zbgj.service;


import com.honglinktech.zbgj.common.Response;

/**
 *
 */
public interface WxPayService {

    /**
     * createWxPay
     * @return
     */
    Response createWxPay(int userId, int orderId, String openId, String requestIp) throws Exception;

    /**
     * 微信支付回调处理
     * @param notityXml
     * @return
     */
    String wxNotify(String notityXml) throws Exception;

    String wxNotifyTest(int orderId) throws Exception;
}
