package com.honglinktech.zbgj.utils;

/**
 * Created by shon on 11/16/15.
 */

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpRequests {
    private static final Logger logger = LogManager.getLogger(HttpRequests.class);

    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";

    public static Map<String, Object> httpPostWithJSON(String url, Map<String, Object> reqJson) throws IOException {

        long startTimeMillis = 0;
        long endTimeMillis = 0;

        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, reqJson);
        String json = stringWriter.toString();

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000) // 10s
                .setConnectTimeout(10000) // 10s
                .build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
        try {
            StringEntity se = new StringEntity(json, "utf-8");
            se.setContentType(CONTENT_TYPE_TEXT_JSON);
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
            se.setContentEncoding("UTF-8");
            httpPost.setEntity(se);

            startTimeMillis = System.currentTimeMillis();
            HttpResponse httpResponse = httpClient.execute(httpPost);
            endTimeMillis = System.currentTimeMillis();

            StatusLine statusLine = httpResponse.getStatusLine();
            HttpEntity entity = httpResponse.getEntity();
            if (statusLine.getStatusCode() >= 300) {
                throw new HttpResponseException(statusLine.getStatusCode(),
                        statusLine.getReasonPhrase());
            }
            if (entity == null) {
                throw new ClientProtocolException("Response contains no content");
            }
            ContentType contentType = ContentType.getOrDefault(entity);
            Charset charset = contentType.getCharset();
            Reader reader = new InputStreamReader(entity.getContent(), charset);

            ObjectMapper mapper = new ObjectMapper();
            resultMap = mapper.readValue(reader, new TypeReference<Map<String, Object>>() {
            });

        } catch (IOException ex) {
            printHttpErrorLog(url, reqJson, ex.toString(), endTimeMillis - startTimeMillis);
            throw ex;
            //throw new IOException(ex.toString());
        } finally {
            httpClient.close();
        }

        // Log
        printHttpLog(url, reqJson, resultMap, endTimeMillis - startTimeMillis);

        return resultMap;
    }

    public static String httpPostJsonObject(String url, Object reqObj) throws IOException {

        long startTimeMillis = 0;
        long endTimeMillis = 0;

        String respBody = "";
        String json = JSON.toJSONString(reqObj);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000) // 10s
                .setConnectTimeout(10000) // 10s
                .build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
        try {
            StringEntity se = new StringEntity(json, "utf-8");
            se.setContentType(CONTENT_TYPE_TEXT_JSON);
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
            se.setContentEncoding("UTF-8");
            httpPost.setEntity(se);

            startTimeMillis = System.currentTimeMillis();
            HttpResponse httpResponse = httpClient.execute(httpPost);
            endTimeMillis = System.currentTimeMillis();

            StatusLine statusLine = httpResponse.getStatusLine();
            HttpEntity entity = httpResponse.getEntity();
            if (statusLine.getStatusCode() >= 300) {
                throw new HttpResponseException(statusLine.getStatusCode(),
                        statusLine.getReasonPhrase());
            }
            if (entity == null) {
                throw new ClientProtocolException("Response contains no content");
            }
            ContentType contentType = ContentType.getOrDefault(entity);
            Charset charset = contentType.getCharset();
            InputStreamReader reader = new InputStreamReader(entity.getContent(), charset);
            BufferedReader br = new BufferedReader(reader);

            StringBuilder sb = new StringBuilder();
            String aux = "";
            while ((aux = br.readLine()) != null) {
                sb.append(aux);
            }
            respBody = sb.toString();
            br.close();
            reader.close();
        } catch (IOException ex) {
            printHttpErrorLog(url, json, ex.toString(), endTimeMillis - startTimeMillis);
            throw ex;
        } finally {
            httpClient.close();
        }

        // Log
        printHttpLog(url, json, respBody, endTimeMillis - startTimeMillis);

        return respBody;

    }


    public static Map<String, Object> httpPostWithJSON(String url, String username, String password, Map<String, Object> reqJson) throws IOException {

        long startTimeMillis = 0;
        long endTimeMillis = 0;

        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, reqJson);
        String json = stringWriter.toString();

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        String auth = new StringBuffer(username).append(":").append(password).toString();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        httpPost.setHeader("AUTHORIZATION", authHeader);

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000) // 10s
                .setConnectTimeout(10000) // 10s
                .build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
        try {
            StringEntity se = new StringEntity(json, "utf-8");
            se.setContentType(CONTENT_TYPE_TEXT_JSON);
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
            se.setContentEncoding("UTF-8");
            httpPost.setEntity(se);

            startTimeMillis = System.currentTimeMillis();
            HttpResponse httpResponse = httpClient.execute(httpPost);
            endTimeMillis = System.currentTimeMillis();

            StatusLine statusLine = httpResponse.getStatusLine();
            HttpEntity entity = httpResponse.getEntity();
//            if (statusLine.getStatusCode() >= 300)
//            {
//                throw new HttpResponseException(statusLine.getStatusCode(),
//                        statusLine.getReasonPhrase());
//            }
//            if (entity == null)
//            {
//                throw new ClientProtocolException("Response contains no content");
//            }
            ContentType contentType = ContentType.getOrDefault(entity);
            Charset charset = contentType.getCharset();
            if (charset == null) {
                charset = HTTP.DEF_CONTENT_CHARSET;
            }
            Reader reader = new InputStreamReader(entity.getContent(), charset);

            ObjectMapper mapper = new ObjectMapper();
            resultMap = mapper.readValue(reader, new TypeReference<Map<String, Object>>() {
            });

        } catch (IOException ex) {
            printHttpErrorLog(url, reqJson, ex.toString(), endTimeMillis - startTimeMillis);
            throw ex;
            //throw new IOException(ex.toString());
        } finally {
            httpClient.close();
        }

        // Log
        printHttpLog(url, reqJson, resultMap, endTimeMillis - startTimeMillis);

        return resultMap;
    }

    private static void printHttpErrorLog(String url, Map<String, Object> req, String errmsg, long costMs) {
        Map<String, Object> logData = new LinkedHashMap<String, Object>();
        logData.put("url", url);
        logData.put("costMs", (costMs) + "ms");
        logData.put("req", req);
        logData.put("errmsg", errmsg);

        String logStr = "";
        try {
            logStr = JsonHelper.map2JsonStr(logData);
        } catch (Exception e) {
            logStr = e.toString();
        }

        logger.info(logStr);
    }

    private static void printHttpErrorLog(String url, String req, String errmsg, long costMs) {
        Map<String, Object> logData = new LinkedHashMap<String, Object>();
        logData.put("url", url);
        logData.put("costMs", (costMs) + "ms");
        logData.put("reqStr", req);
        logData.put("errmsg", errmsg);

        String logStr = "";
        try {
            logStr = JsonHelper.map2JsonStr(logData);
        } catch (Exception e) {
            logStr = e.toString();
        }

        logger.info(logStr);
    }

    private static void printHttpLog(String url, Map<String, Object> req, Map<String, Object> resp, long costMs) {
        Map<String, Object> logData = new LinkedHashMap<String, Object>();
        logData.put("url", url);
        logData.put("costMs", (costMs) + "ms");
        logData.put("req", req);
        logData.put("resp", resp);

        String logStr = "";
        try {
            logStr = JsonHelper.map2JsonStr(logData);
        } catch (Exception e) {
            logStr = e.toString();
        }

        logger.info(logStr);
    }

    private static void printHttpLog(String url, String reqStr, String respStr, long costMs) {
        Map<String, Object> logData = new LinkedHashMap<String, Object>();
        logData.put("url", url);
        logData.put("costMs", (costMs) + "ms");
        logData.put("reqStr", reqStr);
        logData.put("respStr", respStr);

        String logStr = "";
        try {
            logStr = JsonHelper.map2JsonStr(logData);
        } catch (Exception e) {
            logStr = e.toString();
        }

        logger.info(logStr);
    }
}
