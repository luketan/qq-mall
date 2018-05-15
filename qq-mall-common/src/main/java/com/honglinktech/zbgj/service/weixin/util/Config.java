package com.honglinktech.zbgj.service.weixin.util;

import com.google.gson.JsonObject;
import com.honglinktech.zbgj.service.weixin.HandleMessageListener;
import com.honglinktech.zbgj.service.weixin.handle.DefaultEventMsgHandle;
import com.honglinktech.zbgj.service.weixin.handle.DefaultImgMsgHandle;
import com.honglinktech.zbgj.service.weixin.handle.DefaultLocationMsgHandle;
import com.honglinktech.zbgj.service.weixin.handle.DefaultTextMsgHandle;
import com.honglinktech.zbgj.service.weixin.handle.DefaultVoiceMsgHandle;
import com.honglinktech.zbgj.service.weixin.msg.EventMsg;
import org.apache.commons.lang3.StringUtils;

public class Config {

    
	// 赋权类型 
//	String grant_type = "client_credential";
	
	// 修改为开发者申请的appid
//    public static final String  APPID      = "wxc699f8967d702406";
	public static final String JSAPI_NONCESTR="EAFDASFEFADG";
	// 修改为开发者申请的secret密钥
//	public static final String SECRET     = "1f2c61c56e3f2074ddc5f8222e6b2daf";
//	public static final String API_SERVICE_TOKEN="dimeng000000";
	
	public final static String MEDIA_REPORT_URL="http://${SYSTEM.SITE_DOMAIN}/zxdt/mtbd/#id#.html";
	public final static String MEDIA_HYZX_URL="http://${SYSTEM.SITE_DOMAIN}/zxdt/wdhyzx/#id#.html";
    public static String getWeixinAccessTokenUrl(String APPID,String SECRET){
       return "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+SECRET;
    }
    public final static String WEIXIN_ACCESS_JSTICKET_URL="https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi&access_token=";
    
    @SuppressWarnings("unchecked")
	public final static Class<HandleMessageListener>[]  handers=new Class[]{DefaultTextMsgHandle.class,DefaultVoiceMsgHandle.class,DefaultEventMsgHandle.class,DefaultLocationMsgHandle.class,DefaultImgMsgHandle.class};
//    public final static String WEIXIN_WAP_INDEX="http://www.kyygo.com/DimengApp/weixin/dev/";
	public enum MENU_ITEM{
	    ABSTRACT(MENU_TYPE.CLICK,"abstract","公司简介"),
	    INVEST(MENU_TYPE.VIEW,"http:www.baidu.com","我要投资"),
	    MEDIAREPORT(MENU_TYPE.CLICK,"mediareport","媒体报道"),
	    ANQUANBAOZHANG(MENU_TYPE.CLICK,"anquanbaozhang","安保保障"),
	    HANGYEZX(MENU_TYPE.CLICK,"hangyezx","行业资讯"),
	    APPDOWNLOAD(MENU_TYPE.CLICK,"appdownload","APP下载"),
	    CONTACTUS(MENU_TYPE.CLICK,"contactus","联系我们"),
	    NONE(null,null,null);
	    private MENU_TYPE type;
	    private String url;
	    private String key;
	    private String displayName;
	    private MENU_ITEM(MENU_TYPE type,String value,String displayName){
	        if(type==MENU_TYPE.VIEW){
	            this.url=value;
	        }else{
	            this.key=value;
	        }
	        this.displayName=displayName;
	    }
	    public MENU_ITEM getByKey(String key){
	        if(StringUtils.isNotEmpty(key)){
                for(MENU_ITEM ins: MENU_ITEM.values()){
                    if(key.equals(ins.key)){
                        return ins;
                    }
                }
            }
            return NONE;
	    }
	    public void write(JsonObject json){
	        json.addProperty("name", displayName);
	        json.addProperty("type", type.toString());
	        if(StringUtils.isNotBlank(url)){
	            json.addProperty("url", url);
	        }
	        if(StringUtils.isNotBlank(key)){
                json.addProperty("key", key);
            }
	    }
	}

    public enum MENU_TYPE{
        CLICK("click"),VIEW("view"),TEXT("text"),GETTOKEN("getToken"),GETJSTICKET("getJsTicket"),LOCATION("location"),IMAGE("image"),VALIDATION("validation")
        ,SUBSCRIBE(EventMsg.SUBSCRIBE),UNSUBSCRIBE(EventMsg.UNSUBSCRIBE);
        private String name;
        private MENU_TYPE(String name){
            this.name=name;
        }
        @Override
        public String toString(){
            return name;
        }
        public MENU_TYPE getByName(String name){
            if(StringUtils.isNotEmpty(name)){
                for(MENU_TYPE ins: MENU_TYPE.values()){
                    if(name.equals(ins.name)){
                        return ins;
                    }
                }
            }
            return null;
        }
    }
    public static String getResourceUrl(String requestUrl,String contentPath){
        return requestUrl.substring(0, requestUrl.lastIndexOf(contentPath)+contentPath.length())+"/weixin/";
    }
    
    
    public static String getWeiXinToken(){
    	//TODO weixinToken
    	String weixinToken = "";//SystemConfig.getProperty("WEIXIN_API_SERVICE_TOKEN");
    	if(StringUtils.isEmpty(weixinToken)){
    		weixinToken = "dimeng000000";
    	}
    	return weixinToken;
    }
    public static String getWeiXinAppID(){
    	String weixinAppId = "";//SystemConfig.getProperty("WEIXIN_APP_ID");
    	if(StringUtils.isEmpty(weixinAppId)){
    		weixinAppId = "wxc699f8967d702406";
    	}
    	return weixinAppId;
    }
    public static String getWeiXinAppSecret(){
    	String weixinAppId = "";//SystemConfig.getProperty("WEIXIN_APP_ID");
    	if(StringUtils.isEmpty(weixinAppId)){
    		weixinAppId = "1f2c61c56e3f2074ddc5f8222e6b2daf";
    	}
    	return weixinAppId;
    }
    
}
