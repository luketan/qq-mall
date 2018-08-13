/*
 * 文 件 名:  BorrowController.java
 * 版    权:  深圳市迪蒙网络科技有限公司
 * 描    述:  <描述>
 * 修 改 人:  tonglei
 * 修改时间:  2015/6/26
 */
package com.honglinktech.zbgj.api.controller;

import com.honglinktech.zbgj.annotation.NoRequireLogin;
import com.honglinktech.zbgj.annotation.RequireLogin;
import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.service.UserService;
import com.honglinktech.zbgj.vo.UserLoginVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 * @author tanhui
 */
@Controller
@RequestMapping("/weixinApplet")
@RequireLogin
public class WeiXinAppletController extends BaseApiController {
    private static final Log logs = LogFactory.getLog(BaseApiController.class);

    @Resource
    private UserService userService;

    /**
     * 获取session
     */
    @RequestMapping(value = "login", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @NoRequireLogin
    public Response<UserLoginVO> login(@RequestBody Map<String, String> map) {

        try {
            if (!map.containsKey("code")) {
                return Result.fail("code不能为空！");
            }
            return userService.appletLoginByCode(map.get("code"));
        } catch (Exception e) {
            logger.info(e, e);
            return null;
        }
    }
}
