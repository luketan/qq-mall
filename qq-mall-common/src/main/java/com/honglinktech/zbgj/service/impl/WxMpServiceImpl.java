package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.bean.WxMpJsTicketSignedBean;
import com.honglinktech.zbgj.dao.WxMpDao;
import com.honglinktech.zbgj.entity.WxMpConfig;
import com.honglinktech.zbgj.entity.WxMpJsTicket;
import com.honglinktech.zbgj.service.WxMpService;
import com.honglinktech.zbgj.service.wxmpapi.WxMpApi;
import com.honglinktech.zbgj.service.wxmpapi.WxMpApiAcTokenResponse;
import com.honglinktech.zbgj.service.wxmpapi.WxMpApiJsTicketResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

/**
 * Created by shon on 31/03/2017.
 *
 * @author shon
 */
@Service("wxMpService")
public class WxMpServiceImpl implements WxMpService {
    private static Logger logger = LogManager.getLogger(WxMpServiceImpl.class);

    @Autowired
    private WxMpDao wxMpDao;

    @Override public WxMpJsTicketSignedBean grantWxMpSignForUrl(String wxMpName, String signUrl) {
        if (wxMpName == null || signUrl == null) {
            return null;
        }

        WxMpConfig wxMpConfig = wxMpDao.findWxMpConfigByName(wxMpName);
        if (wxMpConfig == null || wxMpConfig.getAppId() == null) {
            return null;
        }

        if (wxMpConfig.getBaseHost() != null) {
            // 检查域名
            try {
                URL url = new URL(signUrl);
                if (!url.getHost().equals(wxMpConfig.getBaseHost())) {
                    return null;
                }

            } catch (MalformedURLException e) {
                logger.error(e, e);
                return null;
            }
        }

        WxMpJsTicket ticket = wxMpDao.findWxMpJsTicketByName(wxMpName);
        if (ticket == null || ticket.getJsTicket() == null) {
            return null;
        }

        if (ticket.getExpDate() != null && ticket.getExpDate().before(new Date())) {
            return null;
        }

        String nonceStr = getRandomString(20);
        int timestamp = (int) (System.currentTimeMillis()/1000);

        String strToSign = new StringBuilder()
            .append("jsapi_ticket=").append(ticket.getJsTicket())
            .append("&noncestr=").append(nonceStr)
            .append("&timestamp=").append(timestamp)
            .append("&url=").append(signUrl).toString();

        String sha1Sign = sha1HexStr(strToSign);
        if (sha1Sign == null) {
            return null;
        }

        WxMpJsTicketSignedBean bean = new WxMpJsTicketSignedBean();
        bean.setAppid(wxMpConfig.getAppId());
        bean.setNonceStr(nonceStr);
        bean.setTimestamp(String.valueOf(timestamp));
        bean.setSign(sha1Sign);

        return bean;
    }

    @Override
    public void refreshAllJsTicket() {
        try {
            logger.error("[refreshAllJsTicket]");
            List<WxMpConfig> configList = wxMpDao.findAllWxMpConfig();
            for (WxMpConfig config: configList) {

                if (config.getAppId() == null || config.getAppSecret() == null
                    || config.getWxMpName() == null || config.getNeedJsTicket() == null) {
                    logger.error("[refreshAllJsTicket] 结束: config设置为空");
                    continue;
                }

                if (config.getNeedJsTicket() <= 0) {
                    logger.error("[refreshAllJsTicket] 结束: 不需要JsTicket");
                    continue;
                }

                WxMpApiAcTokenResponse acTokenResponse = WxMpApi.getWxMpAccessToken(config.getAppId(), config.getAppSecret());
                if (acTokenResponse == null || acTokenResponse.getAccessToken() == null) {
                    logger.error("[refreshAllJsTicket] 结束: 微信查询access token失败");
                    continue;
                }

                // 更新 access token

                int defaultExpSec = 7200;
                if (acTokenResponse.getExpireIn() != null) {
                    defaultExpSec = acTokenResponse.getExpireIn();
                }

                Date expDate = new Date(System.currentTimeMillis() + defaultExpSec*1000);
                config.setToken(acTokenResponse.getAccessToken());
                config.setExpDate(expDate);

                wxMpDao.updateWxMpConfig(config);

                // 更新 js ticket
                boolean needInsert = false;
                WxMpJsTicket wxMpJsTicket = wxMpDao.findWxMpJsTicketByName(config.getWxMpName());
                if (wxMpJsTicket == null) {
                    wxMpJsTicket = new WxMpJsTicket();
                    wxMpJsTicket.setWxMpName(config.getWxMpName());
                    needInsert = true;
                }
                WxMpApiJsTicketResponse wxMpApiJsTicketResponse = WxMpApi.getWxMpJsTicket(acTokenResponse.getAccessToken());
                if (wxMpApiJsTicketResponse == null || wxMpApiJsTicketResponse.getTicket() == null) {
                    logger.error("[refreshAllJsTicket] 结束: 微信查询 js ticket 失败");
                    continue;
                }

                defaultExpSec = 7200;
                if (wxMpApiJsTicketResponse.getExpireIn() != null) {
                    defaultExpSec = acTokenResponse.getExpireIn();
                }

                Date ticketExpDate = new Date(System.currentTimeMillis() + defaultExpSec*1000);
                wxMpJsTicket.setJsTicket(wxMpApiJsTicketResponse.getTicket());
                wxMpJsTicket.setExpDate(ticketExpDate);
                if (needInsert) {
                    wxMpDao.insertWxMpJsTicket(wxMpJsTicket);
                } else {
                    wxMpDao.updateWxMpJsTicket(wxMpJsTicket);
                }
                logger.error("[refreshAllJsTicket] 完成");
                // 更新成功
            }

        } catch (Exception ex) {
            logger.error(ex, ex);
        }

    }

    private static String getRandomString(int length) {
        //随机字符串的随机字符库
        final String keyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        int len = keyString.length();
        for (int i = 0; i < length; i++) {
            sb.append(keyString.charAt((int) Math.round(Math.random() * (len - 1))));
        }
        return sb.toString();
    }

    private static String sha1HexStr(String decript) {
        try {
            MessageDigest digest = MessageDigest
                .getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            logger.error(e, e);
//            e.printStackTrace();
        }
        return "";

    }
}
