package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.bean.PaymentBean;
import com.honglinktech.zbgj.common.Response;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by Dayong on 16/2/24.
 */
public interface PaymentService {

    /**
     * 预览支付信息
     *
     * @param id
     * @return
     */
    Response<PaymentBean> reviewPayment(String id);

    /**
     * 请求支付
     *
     * @param id   订单ID
     * @param type 支付类型[1.支付宝，2.微信，3.银联，4.橙E付]
     * @param code
     * @param ip   请求的IP  @return
     */
    Response<? extends Object> requestPayment(String id, int type, String code, String payPsw, String ip);

    /**
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    boolean handleAlipayNotify(HttpServletRequest request) throws UnsupportedEncodingException;

    /**
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    boolean handleWeiXinNotify(HttpServletRequest request) throws UnsupportedEncodingException;

    /**
     * @param request
     * @return
     */
    boolean handleUnionpayNotify(HttpServletRequest request);

    /**
     * @param request
     * @return
     */
    boolean handleOrangeNotify(HttpServletRequest request);

    /**
     * @param userCode
     * @return
     */
    Response<String> sendMessage(String userCode);
}
