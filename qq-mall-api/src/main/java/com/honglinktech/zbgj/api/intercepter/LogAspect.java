package com.honglinktech.zbgj.api.intercepter;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.honglinktech.zbgj.utils.JsonHelper;

import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 */
@Aspect
public class LogAspect {
    private static final String JSONBODYATTRIBUTE = "JSON_REQUEST_BODY";

    private final Logger logger = LogManager.getLogger(getClass());

    private String requestPath = "";
    private Map<String, String[]> inputParamMap = null; // 传入参数
    private String inputJsonStr = "";
    private Map<String, Object> outputParamMap = null; // 存放输出结果
    private long startTimeMillis = 0; // 开始时间
    private long endTimeMillis = 0; // 结束时间
    private String userAgent = "";

    @Before("execution(* com.honglinktech.zbgj.api.controller..*.*(..))")
    public void doBeforeInServiceLayer(JoinPoint joinPoint) {
        startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
    }

    @After("execution(* com.honglinktech.zbgj.api.controller..*.*(..))")
    public void doAfterInServiceLayer(JoinPoint joinPoint) {
        endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
        this.printOptLog();
    }

    @Around("execution(* com.honglinktech.zbgj.api.controller..*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        //ResettableStreamHttpServletRequest wrappedRequest = new ResettableStreamHttpServletRequest(
        //    (HttpServletRequest) request);

        /*
        ServletRequestAttributes attributes = new ServletRequestAttributes(wrappedRequest);
        //request.setAttribute(REQUEST_ATTRIBUTES_ATTRIBUTE, attributes);
        LocaleContextHolder.setLocale(request.getLocale());
        RequestContextHolder.setRequestAttributes(attributes);  //把requestAttributes的属性设置好
        */

        // 获取输入参数
        inputParamMap = request.getParameterMap();
        // 获取JSON
        inputJsonStr = IOUtils.toString(request.getReader());
        //inputJsonStr = IOUtils.toString(wrappedRequest.getReader());
        //wrappedRequest.resetInputStream();
        // 获取请求地址
        requestPath = request.getRequestURI();

        // 获取User-Agent
        userAgent = request.getHeader("User-Agent");
        if (userAgent == null) userAgent = "not found";

        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
        outputParamMap = new LinkedHashMap<String, Object>();
        Object result = pjp.proceed();// result的值就是被拦截方法的返回值
        outputParamMap.put("json", result);

        return result;
    }

    private void printOptLog() {
        Map<String, Object> logData = new LinkedHashMap<String, Object>();
        String optTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTimeMillis);
        logData.put("optDate", optTime);
        logData.put("requestPath", requestPath);
        logData.put("User-Agent", userAgent);
        logData.put("costTime", (endTimeMillis - startTimeMillis) + "ms");
        logData.put("param", inputParamMap);
        logData.put("inputData", inputJsonStr);
        logData.put("output", outputParamMap);

        String logStr = "";
        try {
            logStr = JsonHelper.map2JsonStr(logData);
        } catch (Exception e) {
            logStr = e.toString();
        }

        logger.info(logStr);
    }
}
