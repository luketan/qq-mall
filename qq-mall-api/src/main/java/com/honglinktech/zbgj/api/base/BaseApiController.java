package com.honglinktech.zbgj.api.base;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.honglinktech.zbgj.api.bean.ClientEnvInfo;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.base.ReturnInfo;

/**
 * Created by shon on 12/1/15.
 */
public class BaseApiController {
    protected final Logger logger = LogManager.getLogger(getClass());

    protected ClientEnvInfo clientEnvInfo;
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;

    // --- 检查参数用的功能函数 ---
    protected boolean emptyInput(Integer integer) {
        return integer == null;
    }

    protected boolean emptyInput(String str) {
        return str == null || str.isEmpty();
    }

    protected boolean emptyInput(Object obj) {
        return obj == null;
    }

    protected String outputNotEmptyString(String input) {
        if (input == null)
            return "";
        else
            return input;
    }

    @ModelAttribute
    protected void loadClientEnv() {
        clientEnvInfo = (ClientEnvInfo) request.getAttribute("clientEnvInfo");
        if (clientEnvInfo == null)
            clientEnvInfo = new ClientEnvInfo();
    }

    @ModelAttribute
	public void setArgs() {
		System.out.println("=============ModelAttribute===========");
	}
	
    /** 基于@ExceptionHandler异常处理 */
	@ResponseBody
    @ExceptionHandler
    public ReturnInfo exp(HttpServletRequest request,HttpServletResponse response, BaseException ex,Object handler) {
		logger.error(ex);
		logger.error("================baseException=============="+ex.getMessage()+"|"+ex.getExceptionEnum().getLogString());
		ex.printStackTrace();
        return new ReturnInfo(ex.getExceptionEnum());
    }
	@ResponseBody
    @ExceptionHandler
    public ReturnInfo exp(HttpServletRequest request,HttpServletResponse response, Exception ex,Object handler) {
		logger.error(ex);
		logger.error("==================未知======================"+UUID.randomUUID()+ex.getMessage());
		ex.printStackTrace();
        return new ReturnInfo(ExceptionEnum.COMMON_ERROE);
    }
}