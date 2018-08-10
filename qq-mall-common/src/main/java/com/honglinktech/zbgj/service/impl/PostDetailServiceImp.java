package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.bean.PostDetailBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.PostCompanyDao;
import com.honglinktech.zbgj.dao.PostDetailDao;
import com.honglinktech.zbgj.entity.PostCompany;
import com.honglinktech.zbgj.entity.PostDetail;
import com.honglinktech.zbgj.service.PostDetailService;
import com.honglinktech.zbgj.utils.JsonHelper;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 快递100查询服务
 * Created by tangjc on 2016/3/28.
 */
@Configuration
public class PostDetailServiceImp implements PostDetailService {
    private final Logger logger = LogManager.getLogger(getClass());
    
    @Autowired
    private PostDetailDao kd100Dao;

    @Autowired
    private PostCompanyDao postCompanyDao;

    @Autowired
    private Environment env;

    @Override
    public Response<String> subscribeService(String company, String number, String from, String to) {
    	String callbackurl = env.getProperty("kd100.callbackurl");
    	String key = env.getProperty("kd100.key");
    	String url = env.getProperty("kd100.url");
    	logger.info("kd100-subscribe:company["+company+"],number["+number+"],callbackurl["+callbackurl+"],key["+key+"],url["+url+"]");
    	if(callbackurl.indexOf("192.168.1.68")>-1){
    		//TODO 内网不需要
    		return Result.success();
    	}
        Map<String, String> postMap = new HashMap<String, String>();
        postMap.put("schema", "json");
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> parms = new HashMap<String, Object>();
        parms.put("callbackurl", callbackurl);
        try {
            map.put("company", company);
            map.put("number", number);
            if (!from.isEmpty())
                map.put("from", from);
            if (!to.isEmpty())
                map.put("to", to);
            map.put("key", key);
            map.put("parameters", parms);
            String strParam = JsonHelper.map2JsonStr(map);
            postMap.put("param", strParam);
            String result = "";
            result = postData(url, postMap, "UTF-8");

            Map<String, Object> ret = JsonHelper.jsonStr2Map(result);
            logger.info("kd100-subscribe-ret:"+ret);
            if (ret.containsKey("result") && Boolean.parseBoolean(ret.get("result").toString())) {
                return Result.success();
            } else {
                if (ret.containsKey("returnCode") && ret.containsKey("message")) {
                    logger.info(ret.get("message").toString());
                    return Result.fail(Integer.parseInt(ret.get("returnCode").toString()), ret.get("message").toString());
                }
                return Result.fail("未知错误");
            }

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return Result.fail("异常错误");
        }

    }

    @Override
    public Response<List<PostDetailBean>> queryPostDetail(String number, String company) {
        try {
            List<PostDetailBean> ret = kd100Dao.findPostDetailByNum(number, company);
            if (ret.size() == 0) {
            	return Result.resultSet("暂无快递信息呢~", ret);
            }
            return Result.resultSet(ret, ret.size());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return Result.fail("异常错误");
        }

    }

    /**
     *
     * @param postCode
     * @param companyId
     * @return
     */
    @Override
    public Response<List<PostDetailBean>> findPostDetails(String postCode, Integer companyId) {
        PostCompany postCompany = postCompanyDao.findById(companyId);
        List<PostDetailBean> ret = kd100Dao.findPostDetailByNum(postCode, postCompany.getCode());
        return Result.resultSet(ret);
    }

    /**
     *
     * @param postDetail 录入快递单详情
     * 更新快递单的信息
     * @return
     */
    @Override
    public Object updatePostDetail(PostDetail postDetail) {
        Map<String, Object> ret = new HashMap<String, Object>();
        try {
            kd100Dao.save(postDetail);
            ret.put("result", true);
            ret.put("returnCode", "200");
            ret.put("message", "提交成功");
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            ret.put("result", false);
            ret.put("returnCode", "501");
            ret.put("message", "数据库错误");

        }
        return ret;
    }

    @Override
    public Response<String> deletePostDetail(PostDetail postDetail) {
        try {
            kd100Dao.update(postDetail);
            return Result.success();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return Result.fail("数据库错误");
        }
    }


    private synchronized static String postData(String url, Map<String, String> params, String codePage) throws Exception {

        final HttpClient httpClient = new HttpClient();
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(10 * 1000);
        httpClient.getHttpConnectionManager().getParams().setSoTimeout(10 * 1000);

        final PostMethod method = new PostMethod(url);
        if (params != null) {
            method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, codePage);
            method.setRequestBody(assembleRequestParams(params));
        }
        String result = "";
        try {
            httpClient.executeMethod(method);
            result = new String(method.getResponseBody(), codePage);
        } catch (final Exception e) {
            throw e;
        } finally {
            method.releaseConnection();
        }
        return result;
    }

    /**
     * 组装http请求参数
     *
     * @param data
     * @return
     */
    private synchronized static NameValuePair[] assembleRequestParams(Map<String, String> data) {
        final List<NameValuePair> nameValueList = new ArrayList<NameValuePair>();

        Iterator<Map.Entry<String, String>> it = data.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
            nameValueList.add(new NameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }

        return nameValueList.toArray(new NameValuePair[nameValueList.size()]);
    }
}
