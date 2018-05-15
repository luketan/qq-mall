package com.honglinktech.zbgj.service.weixin.handle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import com.google.gson.JsonObject;
import com.honglinktech.zbgj.service.weixin.DefaultSession;
import com.honglinktech.zbgj.service.weixin.HandleMessageAdapter;
import com.honglinktech.zbgj.service.weixin.WeiXinInfo;
import com.honglinktech.zbgj.service.weixin.msg.JsonMsg;
import com.honglinktech.zbgj.service.weixin.msg.StringMsg;
import com.honglinktech.zbgj.service.weixin.util.Config;
import com.honglinktech.zbgj.service.weixin.util.HttpCore;
import com.honglinktech.zbgj.service.weixin.util.MySecurity;
import com.honglinktech.zbgj.service.weixin.util.Result;

public class DefaultGetMsgHandle extends HandleMessageAdapter
{
    public final static String CONTEXT_KEY_TOKEN="_weixin_token";
    public final static String CONTEXT_KEY_JSTICKET="_weixin_js_ticket";
    public final static String CONTEXT_WEIXIN="_weixin_cache";
    private WeiXinInfo weixinInfo;
    //    private ConfigureProvider configureProvider;
    private int urlHash;
    @SuppressWarnings("unused")
	@Override
    public boolean onInterfaceValidata()
    {
    	weixinInfo=this.getWeiXinSession(DefaultSession.class).getWeiXininfo();
        String signature = weixinInfo.getSignature();// 微信加密签名
        String timestamp = weixinInfo.getTimestamp();// 时间戳
        String nonce = weixinInfo.getNonce();// 随机数
        String echostr = weixinInfo.getEchostr();// 随机字符串
//        configureProvider=this.getWeiXinSession(DefaultSession.class).getResourceProvider().getResource(ConfigureProvider.class);
        List<String> list = new ArrayList<String>(3) {
        private static final long serialVersionUID = 2621444383666420433L;
            public String toString() {
                return this.get(0) + this.get(1) + this.get(2);
            }
        };
        try
        {
            list.add(Config.getWeiXinToken());
        }
        catch (Throwable e)
        {
            this.getWeiXinSession().onException(e);
        }
        list.add(timestamp);
        list.add(nonce);
        StringMsg rc=new StringMsg();
        if(list==null ){
        	Collections.sort(list);// 排序
        	String tmpStr = new MySecurity().encode(list.toString(),MySecurity.SHA_1);// SHA-1加密
        	if(tmpStr.equals(signature)){
        		rc.setDescription(echostr);
        	}else{
        		rc.setDescription("error");
        	}
        }else{
        	rc.setDescription("error");
        }
      
        rc.setCallback(this.getWeiXinSession(DefaultSession.class).getWeiXininfo().getRequest().getParameter("callback"));
        this.getWeiXinSession().callback(rc);
        return true;
    }
    @Override
    public boolean onGetJsTicket()
    {
//        configureProvider=this.getWeiXinSession(DefaultSession.class).getResourceProvider().getResource(ConfigureProvider.class);
        weixinInfo=this.getWeiXinSession(DefaultSession.class).getWeiXininfo();
        urlHash=weixinInfo.getUrl().hashCode();
        JsonObject jsticketInfo;
		try {
			jsticketInfo = this.getJsTicket(this.getToken());
			JsonMsg rc=new JsonMsg();
	        rc.setData(jsticketInfo);
            // TODO
	        rc.setCode("0");
	        rc.setDescription("success");
	        rc.setCallback(this.getWeiXinSession(DefaultSession.class).getWeiXininfo().getRequest().getParameter("callback"));
	        this.getWeiXinSession().callback(rc);
	        return true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
       
    }
    private JsonObject getToken() throws Exception{
        JsonObject tokenInfo= this.getCache(CONTEXT_KEY_TOKEN+urlHash);
        if(tokenInfo==null||tokenInfo.get("expiresTime").getAsLong()<new Date().getTime()){
            long _curentTime=new Date().getTime();
            tokenInfo=new HttpCore().getJSON(Config.getWeixinAccessTokenUrl(Config.getWeiXinAppID(), Config.getWeiXinAppSecret()));
            long expiresIn=tokenInfo.get("expires_in").getAsLong();
            tokenInfo.addProperty("timestamp", _curentTime);
            tokenInfo.addProperty("expiresTime", (_curentTime+expiresIn*1000));
            this.syncCache(CONTEXT_KEY_TOKEN+urlHash,tokenInfo);
        }
        return tokenInfo;
    }
    private JsonObject getJsTicket(JsonObject tokenInfo){
        JsonObject ticketInfo= this.getCache(CONTEXT_KEY_JSTICKET+urlHash);
        String token=tokenInfo.get("access_token").getAsString();
        if(ticketInfo==null||ticketInfo.get("expiresTime").getAsLong()<new Date().getTime()){
            long _curentTime=new Date().getTime();
            try {
				ticketInfo=new HttpCore().getJSON(Config.WEIXIN_ACCESS_JSTICKET_URL+token);
				long expiresIn=ticketInfo.get("expires_in").getAsLong();
	            ticketInfo.addProperty("timestamp", _curentTime);
	            ticketInfo.addProperty("expiresTime", (_curentTime+expiresIn*1000));
	            ticketInfo.addProperty("noncestr", Config.JSAPI_NONCESTR);
	            ticketInfo.addProperty("url", weixinInfo.getUrl());
	            ticketInfo.addProperty("appId", Config.getWeiXinAppID());
	            buildJsSignature(ticketInfo);
	            this.syncCache(CONTEXT_KEY_JSTICKET+urlHash,ticketInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
           
        }
        return ticketInfo;
    }
    private void buildJsSignature(JsonObject ticketInfo){
        StringBuffer encryptBase=new StringBuffer();
        encryptBase.append("jsapi_ticket="+ticketInfo.get("ticket").getAsString());
        encryptBase.append("&noncestr="+ticketInfo.get("noncestr").getAsString());
        encryptBase.append("&timestamp="+ticketInfo.get("timestamp").getAsLong());
        encryptBase.append("&url="+ticketInfo.get("url").getAsString());
        String encryptResult=new MySecurity().encode(encryptBase.toString(), MySecurity.SHA_1);
        ticketInfo.addProperty("signature", encryptResult);
    }
    private void syncCache(String type,JsonObject ins){
    	ServletContext servlstConText = weixinInfo.getRequest().getSession().getServletContext();
        @SuppressWarnings("unchecked")
		Map<String,JsonObject> cache=(Map<String,JsonObject>)servlstConText.getAttribute(CONTEXT_WEIXIN);
        if(cache==null){
            cache=new  HashMap<String,JsonObject> ();
            servlstConText.setAttribute(CONTEXT_WEIXIN, cache);
        }
        cache.put(type, ins);
    }
    private JsonObject getCache(String type){
    	ServletContext servlstConText = weixinInfo.getRequest().getSession().getServletContext();
    	@SuppressWarnings("unchecked")
        Map<String,JsonObject> cache=(Map<String,JsonObject>)servlstConText.getAttribute(CONTEXT_WEIXIN);
        if(cache==null){
            cache=new  HashMap<String,JsonObject> ();
            servlstConText.setAttribute(CONTEXT_WEIXIN, cache);
        }
        return cache.get(type);
    }
}
