package com.honglinktech.zbgj.service.wxmpapi;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.utils.HttpUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by shon on 31/03/2017.
 *
 * @author shon
 * @date 2017/03/31
 */
public class WxMpApi {
    private static Logger logger = LogManager.getLogger(WxMpApi.class);


    public static WxMpApiAcTokenResponse getWxMpAccessToken(String appid, String appSecret) {
        if (appid == null || appid.isEmpty() || appSecret == null || appSecret.isEmpty()) {
            logger.error("[getWxMpAccessToken] 参数错误");
            return null;
        }

        String url = new StringBuilder(
            "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential").append("&appid=").append(appid).append("&secret=").append(appSecret).toString();

        StringBuilder logSb = new StringBuilder("[getWxMpAccessToken] ").append(url);

        try {

            String respContent = null;
            try {
                respContent = HttpUtil.sendGet(url);

            } catch (IOException e) {
                logger.error(e, e);
                throw new Exception("网络异常");
            }

            if (respContent == null) {
                throw new Exception("返回的content为空");
            }

            logSb.append(" 返回:").append(respContent);
            WxMpApiAcTokenResponse wxMpApiAcTokenResponse =
                JSON.parseObject(respContent, WxMpApiAcTokenResponse.class);
            logger.error(logSb.toString());
            return wxMpApiAcTokenResponse;

        } catch (Exception ex) {
            logSb.append(" 失败：").append(ex.toString());
        }

        logger.error(logSb.toString());
        return null;
    }

    public static WxMpApiJsTicketResponse getWxMpJsTicket(String accessToken) {
        if (accessToken == null || accessToken.isEmpty()) {
            logger.error("[getWxMpJsTicket] 参数错误");
            return null;
        }

        String url = new StringBuilder(
            "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=")
            .append(accessToken).append("&type=jsapi").toString();

        StringBuilder logSb = new StringBuilder("[getWxMpJsTicket] ").append(url);

        try {

            String respContent = null;
            try {
                respContent = HttpUtil.sendGet(url);

            } catch (IOException e) {
                logger.error(e, e);
                throw new Exception("网络异常");
            }

            if (respContent == null) {
                throw new Exception("返回的content为空");
            }

            logSb.append(" 返回:").append(respContent);
            WxMpApiJsTicketResponse wxMpApiJsTicketResponse =
                JSON.parseObject(respContent, WxMpApiJsTicketResponse.class);
            logger.error(logSb.toString());
            return wxMpApiJsTicketResponse;

        } catch (Exception ex) {
            logSb.append(" 失败：").append(ex.toString());
        }

        logger.error(logSb.toString());
        return null;
    }
}
