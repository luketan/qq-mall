package com.honglinktech.zbgj.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpUtil {

    private final static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

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
                    logger.error(e.getMessage());
                }
            }
        }
        return null;
    }


    public static String sendPostMul(String url, Map<String, Object> param) throws ParseException, IOException {
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
                formparams.add(new BasicNameValuePair(key, (String) param.get(key)));
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
                    logger.error(e.getMessage());
                }
            }
        }
        return null;
    }


    public static String sendGet(String url) throws ParseException, IOException {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        //HttpPost httppost = new HttpPost(url);
        HttpGet httpGet = new HttpGet(url);
        //httpGet.setHeader("");
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

			/*UrlEncodedFormEntity uefEntity;
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);*/
        CloseableHttpResponse response = httpclient.execute(httpGet);
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
                logger.error(e.getMessage());
            }
        }

        return null;
    }


}
