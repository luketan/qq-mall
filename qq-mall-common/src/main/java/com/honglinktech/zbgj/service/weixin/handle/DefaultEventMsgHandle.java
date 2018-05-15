package com.honglinktech.zbgj.service.weixin.handle;

import com.honglinktech.zbgj.service.weixin.DefaultSession;
import com.honglinktech.zbgj.service.weixin.HandleMessageAdapter;
import com.honglinktech.zbgj.service.weixin.msg.EventMsg;
import com.honglinktech.zbgj.service.weixin.msg.TextMsg;
import com.honglinktech.zbgj.service.weixin.util.Config;

import javax.servlet.http.HttpServletRequest;


public class DefaultEventMsgHandle extends HandleMessageAdapter
{
    @SuppressWarnings("unused")
	public boolean onEventMsg(EventMsg msg){
        DefaultSession weiXinsession=this.getWeiXinSession(DefaultSession.class);
        String eventType = msg.getEvent();
        String eventKey=msg.getEventKey();
        String siteName=null;
//        siteName = weiXinsession.getResourceProvider().getResource(ConfigureProvider.class).format(SystemVariable.SITE_NAME);
        if(EventMsg.SUBSCRIBE.equals(eventType)){// 订阅
            TextMsg reMsg=msg.getReplayMsg(TextMsg.class);
            reMsg.setContent("感谢您关注"+siteName);
            return weiXinsession.callback(reMsg);//回传消息
        }else if(EventMsg.UNSUBSCRIBE.equals(eventType)){// 取消订阅
//            AppWeixinManage appWeixinManage=weiXinsession.getServiceSession().getService(AppWeixinManage.class);
//            appWeixinManage.deleteAppWeixin(msg.getFromUserName());
        }else if(EventMsg.CLICK.equals(eventType)){// 点击事件
            if("userInfo".equals(eventKey)){
                    TextMsg reMsg= msg.getReplayMsg(TextMsg.class);
                    HttpServletRequest request=weiXinsession.getWeiXininfo().getRequest();
                    String url= Config.getResourceUrl(request.getRequestURL().toString(), request.getContextPath()) ;
                    StringBuffer content=new StringBuffer();
                   
//                    AppWeixinManage appWeixinManage=weiXinsession.getServiceSession().getService(AppWeixinManage.class);
//                    try{
//                        int accountId=appWeixinManage.searchAppWeixin(msg.getFromUserName());
//                        Map<String,String> accountInfo=appWeixinManage.getWeixinAccountInfo(accountId);
//                        content.append("尊敬的"+accountInfo.get("accountName")+",您的<a href=\""+url+"?weixinUser="+accountInfo.get("accountName")+"#user/personal/userInfo"+"\">账户信息</a>如下:\r\n");
//                        content.append("    可用余额:￥"+accountInfo.get("balance")+"\r\n");
//                        content.append("    冻结金额:￥"+accountInfo.get("freezeFunds")+"\r\n");
//                        content.append("    账户净资产:￥"+BigDecimalParser.parse(accountInfo.get("yxzc"))
//                            .add(BigDecimalParser.parse(accountInfo.get("sbzc")))
//                            .subtract(BigDecimalParser.parse(accountInfo.get("loanAmount")))
//                            .add(BigDecimalParser.parse(accountInfo.get("freezeFunds")))
//                            .add(BigDecimalParser.parse(accountInfo.get("balance")))+"\r\n");
//                        content.append("    投资资产:￥"+BigDecimalParser.parse(accountInfo.get("yxzc")).add(BigDecimalParser.parse(accountInfo.get("sbzc")))+"\r\n");
//                        content.append("    借款负债:￥"+accountInfo.get("loanAmount")+"\r\n");
//                        content.append("    待还款金额:￥"+accountInfo.get("unpayTotal")+"\r\n");
//                        content.append("您绑定了<a href=\""+url+"?weixinUser="+accountInfo.get("accountName")+"#user/payment/cardManager"+"\">"+accountInfo.get("bankCount")+"张银行卡</a>\r\n");
//                        content.append("您有<a href=\""+url+"?weixinUser="+accountInfo.get("accountName")+"#other/message/messageList"+"\">"+accountInfo.get("letterCount")+"条未读消息</a>\r\n");
//                    }catch(Exception e){
//                        e.printStackTrace();
//                        content.append("您尚未绑定账号，<a href=\""+url+"#user/personal/login/"+msg.getFromUserName()+"\">请绑定您的"+siteName+"账号!</a>\r\n");
//                    }
                    content.append("您尚未绑定账号，<a href=\""+url+"#user/personal/login/"+msg.getFromUserName()+"\">请绑定您的"+siteName+"账号!</a>\r\n");
                    reMsg.setContent(content.toString());
                    return weiXinsession.callback(reMsg);
            }else if("news-mtbd".equals(eventKey)){
//                ArticleManage articleManage=weiXinsession.getServiceSession().getService(ArticleManage.class);
//                PagingResult<T5011> results = articleManage.search(T5011_F02.MTBD, new Paging() {public int getCurrentPage() {return 0;}public int getSize() {return 5;}});
//                T5011[] articles = results.getItems();
//                if (articles != null && articles.length > 0) {
//                    ImageTextMsg mit = msg.getReplayMsg(ImageTextMsg.class);
//                    for (T5011 article : articles) {
//                        Data4Item tmp = new Data4Item(article.F06, article.F08,weiXinsession.getFileUrlByCode(article.F09,"") , weiXinsession.getPagingItemURI(article.F01,Config.MEDIA_REPORT_URL));
//                        mit.addItem(tmp);
//                    }
//                    return weiXinsession.callback(mit);
//                }else{
//                    TextMsg reMsg= msg.getReplayMsg(TextMsg.class);
//                    reMsg.setContent("暂时没有相关媒体报道！");
//                    return weiXinsession.callback(reMsg);
//                }
                TextMsg reMsg= msg.getReplayMsg(TextMsg.class);
                reMsg.setContent("暂时没有相关媒体报道！");
                return weiXinsession.callback(reMsg);
            }else if("news-hyzx".equals(eventKey)){
//                ArticleManage articleManage=weiXinsession.getServiceSession().getService(ArticleManage.class);
//                PagingResult<T5011> results = articleManage.search(T5011_F02.WDHYZX, new Paging() {public int getCurrentPage() {return 0;}public int getSize() {return 5;}});
//                T5011[] articles = results.getItems();
//                if (articles != null && articles.length > 0) {
//                    ImageTextMsg mit = msg.getReplayMsg(ImageTextMsg.class);
//                    for (T5011 article : articles) {
//                        
//                        Data4Item tmp = new Data4Item(article.F06, article.F08,article.F09==null?null:weiXinsession.getFileUrlByCode(article.F09,"") , weiXinsession.getPagingItemURI(article.F01,Config.MEDIA_HYZX_URL));
//                        mit.addItem(tmp);
//                    }
//                    return weiXinsession.callback(mit);
//                }else{
//                    TextMsg reMsg= msg.getReplayMsg(TextMsg.class);
//                    reMsg.setContent("暂时没有相关行业资讯！");
//                    return weiXinsession.callback(reMsg);
//                }
                
                TextMsg reMsg= msg.getReplayMsg(TextMsg.class);
                reMsg.setContent("暂时没有相关行业资讯！");
                return weiXinsession.callback(reMsg);
            }else if("unBindUser".equals(eventKey)){
                HttpServletRequest request=weiXinsession.getWeiXininfo().getRequest();
                String url=Config.getResourceUrl(request.getRequestURL().toString(), request.getContextPath()) ;
                TextMsg reMsg= msg.getReplayMsg(TextMsg.class);
                try{
                	String accountName = null;
//                    AppWeixinManage appWeixinManage=weiXinsession.getServiceSession().getService(AppWeixinManage.class);
//                    int accountId = appWeixinManage.searchAppWeixin(msg.getFromUserName());
//                    appWeixinManage.goOnAccount(accountId);
//                    accountName=appWeixinManage.deleteAppWeixin(msg.getFromUserName());
                    if(accountName!=null){
                        reMsg.setContent("您成功解绑了账号:"+accountName+"!<a href=\""+url+"#user/personal/login/"+msg.getFromUserName()+"\">可以继续绑定您的其它"+siteName+"账号!</a>\r\n");
                    }else{
                        reMsg.setContent("未检测到绑定账号!<a href=\""+url+"#user/personal/login/"+msg.getFromUserName()+"\">您可以直接绑定您的"+siteName+"账号!</a>\r\n");
                    }
                }catch(Exception e){
                    reMsg.setContent("未检测到绑定账号!<a href=\""+url+"#user/personal/login/"+msg.getFromUserName()+"\">您可以直接绑定您的"+siteName+"账号!</a>\r\n");
                }
                return weiXinsession.callback(reMsg);
            }else if("contactUs".equals(eventKey)){
                TextMsg reMsg= msg.getReplayMsg(TextMsg.class);
                StringBuffer contnet=new StringBuffer();
//                contnet.append("联系电话:"+weiXinsession.getResourceProvider().getResource(ConfigureProvider.class).format(
//                    SystemVariable.SITE_CUSTOMERSERVICE_TEL)+"\r\n");
//                contnet.append("客服QQ:"+weiXinsession.getResourceProvider().getResource(ConfigureProvider.class).format(
//                    SystemVariable.KFQQ)+"\r\n");
                contnet.append("您也可以直接通过微信留下您的宝贵意见或者建议!");
                reMsg.setContent(contnet.toString());
                return weiXinsession.callback(reMsg);
            }else {
                TextMsg reMsg=msg.getReplayMsg(TextMsg.class);
                reMsg.setContent("该功能尚未开通！");
                return weiXinsession.callback(reMsg);//回传消息
            }
        }
        return false;
    } 
    public static void main(String[] args)
    {
        
    }
}
