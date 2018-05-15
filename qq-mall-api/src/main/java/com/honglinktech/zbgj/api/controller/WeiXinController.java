/*
 * 文 件 名:  BorrowController.java
 * 版    权:  深圳市迪蒙网络科技有限公司
 * 描    述:  <描述>
 * 修 改 人:  tonglei
 * 修改时间:  2015/6/26
 */
package com.honglinktech.zbgj.api.controller;

import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.bean.WxMpJsTicketSignedBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.service.WxMpService;
import com.honglinktech.zbgj.service.weixin.DefaultSession;
import com.honglinktech.zbgj.service.weixin.WeiXinInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信公共号验证
 *
 * @author tanhui
 */
@Controller
@RequestMapping("/weixin")
public class WeiXinController extends BaseApiController {
    private static final Log logs = LogFactory.getLog(BaseApiController.class);

    @Autowired
    private WxMpService wxMpService;

    /**
     * <功能详细描述>
     *
     * @return
     */
    @RequestMapping(value = "/weixinJs", method = {RequestMethod.GET,
            RequestMethod.POST}, produces = {"application/json",
            "application/xml"})
    @ResponseBody
    public void weixinJs(HttpServletRequest request,
                         HttpServletResponse response) {
        System.out.println(request.getParameter("func"));
        WeiXinInfo weiXinInfo = new WeiXinInfo();
        weiXinInfo.setRequest(request);
        weiXinInfo.setResponse(response);
        try {
            if ("POST".equals(request.getMethod())) {
                DefaultSession.processPost(weiXinInfo);
            } else {
                DefaultSession.processGet(weiXinInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 微信服务器调用的远程接口
     * @return
     */
    @RequestMapping(value = "/weixinService", method = {RequestMethod.GET,
            RequestMethod.POST}, produces = {"application/json",
            "application/xml"})
    @ResponseBody
    public void weixinService(HttpServletRequest request,
                              HttpServletResponse response) {

        System.out.println(request.getParameter("func"));
        WeiXinInfo weiXinInfo = new WeiXinInfo();
        weiXinInfo.setRequest(request);
        weiXinInfo.setResponse(response);
        try {
            DefaultSession.processPost(weiXinInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 转发用的
     * @param req
     * @return
     */
    @RequestMapping(value = "findWxMpJsTicket", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Response findWxMpJsTicket(@RequestBody Map req) {
        try {
            String domain = req.containsKey("domain") ? req.get("domain").toString() :  "";
            WxMpJsTicketSignedBean wxMpJsTicketSignedBean = wxMpService.grantWxMpSignForUrl("zbgj", domain);
            Map retMap = new HashMap();
            retMap.put("wxMpJsTicketSigned", wxMpJsTicketSignedBean);
            return Result.resultSet(retMap);
        } catch (Exception e) {
            logger.error(e, e);
        }

        return Result.fail("保存失败，请联系工作人员！");
    }
}
