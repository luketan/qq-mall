package com.honglinktech.zbgj.admin.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义页面错误处理类
 * Created by Dayong on 16/2/25.
 */
@Component
public class AdminHandlerExceptionResolver implements HandlerExceptionResolver {
    private Log logger = LogFactory.getLog(getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.error("Catch Exception: ", ex);//把异常信息记入日志
        Map<String, String> map = new HashMap<String, String>();
        map.put("errorMsg", ex.getMessage());//将错误信息传递给view
        return new ModelAndView("error", map);
    }
}
