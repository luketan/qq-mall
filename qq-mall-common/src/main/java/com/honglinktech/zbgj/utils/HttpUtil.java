package com.honglinktech.zbgj.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Http连接工具
 * Created by Dayong on 16/6/30.
 */
public final class HttpUtil {
    /**
     *
     */
    private static final Logger LOGGER = LogManager.getLogger(HttpUtil.class);
    /**
     *
     */
    private static final String APPLICATION_JSON = "application/json";
    /**
     *
     */
    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";
    /**
     *
     */
    private static final int SOCKET_TIMEOUT = 10000;

    /**
     *
     */
    private HttpUtil() {
    }


    /**
     * Send post string.
     *
     * @param url   the url
     * @param param the param
     * @return the string
     * @throws ParseException the parse exception
     * @throws IOException    the io exception
     */
    public static String sendPost(String url, Map<String, String> param) throws ParseException, IOException {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);
        //httppost.setHeader("");
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        if (null != param) {
            Set<String> keys = param.keySet();
            for (String key : keys) {
                formparams.add(new BasicNameValuePair(key, param.get(key)));
            }
            UrlEncodedFormEntity uefEntity;
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    return EntityUtils.toString(entity, "UTF-8");
                }
            } finally {
                response.close();
                // 关闭连接,释放资源
                try {
                    httpclient.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return null;
    }


    /**
     * Send json post string.
     *
     * @param url   the url
     * @param param the param
     * @return the string
     * @throws ParseException the parse exception
     * @throws IOException    the io exception
     */
    public static String sendJsonPost(String url, Map<String, Object> param) throws ParseException, IOException {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(SOCKET_TIMEOUT) // 10s
                .setConnectTimeout(SOCKET_TIMEOUT) // 10s
                .build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
        String reqJsonStr = JSON.toJSONString(param);
        StringEntity se = new StringEntity(reqJsonStr, "utf-8");
        se.setContentType(CONTENT_TYPE_TEXT_JSON);
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
        se.setContentEncoding("UTF-8");
        httpPost.setEntity(se);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String respJsonStr = EntityUtils.toString(entity, "UTF-8");
                LOGGER.info("HttpUtil url:{} sendJsonPost:{} response:{}", url, reqJsonStr, respJsonStr);
                return respJsonStr;
            } else {
                LOGGER.info("HttpUtil url:{} sendJsonPost:{} response:null", url, reqJsonStr);
            }
        } finally {
            response.close();
            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return null;
    }

    /**
     * post请求，可以携带header
     * @param url url
     * @param headers headers
     * @param param param
     * @return 返回content
     * @throws ParseException ParseException
     * @throws IOException IOException
     */
    public static String sendJsonPost(String url, Map<String, String> headers, Map<String, Object> param) throws ParseException, IOException {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(SOCKET_TIMEOUT) // 10s
            .setConnectTimeout(SOCKET_TIMEOUT) // 10s
            .build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
        }
        String reqJsonStr = JSON.toJSONString(param);
        StringEntity se = new StringEntity(reqJsonStr, "utf-8");
        se.setContentType(CONTENT_TYPE_TEXT_JSON);
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
        se.setContentEncoding("UTF-8");
        httpPost.setEntity(se);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String respJsonStr = EntityUtils.toString(entity, "UTF-8");
                LOGGER.info("HttpUtil url:{} sendJsonPost:{} response:{}", url, reqJsonStr, respJsonStr);
                return respJsonStr;
            } else {
                LOGGER.info("HttpUtil url:{} sendJsonPost:{} response:null", url, reqJsonStr);
            }
        } finally {
            response.close();
            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return null;
    }


    public static String sendGet(String url, int outTime) throws ParseException, IOException {

        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建HttpGet
        HttpGet httpGet = new HttpGet(url);
        if(outTime>0){
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(outTime).setConnectTimeout(outTime).build();
            httpGet.setConfig(requestConfig);
        }
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity, "UTF-8");
            }
        } finally {
            //response.close();
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return null;
    }
    /**
     * Send get string.
     *
     * @param url the url
     * @return the string
     * @throws ParseException the parse exception
     * @throws IOException    the io exception
     */
    public static String sendGet(String url) throws ParseException, IOException {
        return sendGet(url, 0);
    }


}
