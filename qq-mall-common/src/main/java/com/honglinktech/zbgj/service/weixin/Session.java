package com.honglinktech.zbgj.service.weixin;

import com.honglinktech.zbgj.service.weixin.msg.*;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;


public abstract class Session {

	/** 时间格式化 */
    /** 微信会话    待拓展 */
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
	
	//输入流
	private InputStream is;
	//输出流
	private OutputStream os;
	
	/** XML  Document构建类 */
	private static DocumentBuilder builder;
	private static TransformerFactory tffactory;
	  
	static{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		//格式化工厂对象
		tffactory = TransformerFactory.newInstance();
	}
	
	/**
	 * Session 
	 * 
	 */
	public Session() { }


	public void doGet(WeiXinInfo weixinInfo) throws IOException {
	    init(weixinInfo);
        this.is  = weixinInfo.getRequest().getInputStream();
        this.os = weixinInfo.getResponse().getOutputStream();
        try{
            String func=weixinInfo.getFunc();
            if(StringUtils.isNotEmpty(func)){
                this.onGetJsTicket();
            }else{
                this.onInterfaceValidata();
            }
        }catch(Throwable e){
            this.onException(e);
        }finally{
            this.close();
        }
        return;
	}
	/**
	 * 解析微信消息，并传递给对应方法 is 输入流 os 输出流
	 * @throws IOException 
	 */
	public void process(WeiXinInfo weixinInfo) throws IOException {
	    init(weixinInfo);
        this.is  = weixinInfo.getRequest().getInputStream();
        this.os = weixinInfo.getResponse().getOutputStream();
		try {
			//读取微信消息内容转换
		    Document document = builder.parse(is);
			HeadMsg head = new HeadMsg();
			head.read(document);
			String type = head.getMsgType();
		 
			if(Msg.MSG_TYPE_TEXT.equals(type)){//文本消息
				TextMsg msg = new TextMsg(head);
				msg.read(document);
				this.onTextMsg(msg);
			}else if(Msg.MSG_TYPE_IMAGE.equals(type)){//图片消息
				ImageMsg msg = new ImageMsg(head);
				msg.read(document);
				this.onImageMsg(msg);
			}else if(Msg.MSG_TYPE_EVENT.equals(type)){//事件推送
				EventMsg msg = new EventMsg(head);
				msg.read(document);
				this.onEventMsg(msg);
			}else if(Msg.MSG_TYPE_LINK.equals(type)){//链接消息
				LinkMsg msg = new LinkMsg(head);
				msg.read(document);
				this.onLinkMsg(msg);
			}else if(Msg.MSG_TYPE_LOCATION.equals(type)){//地理位置消息
				LocationMsg msg = new LocationMsg(head);
				msg.read(document);
				this.onLocationMsg(msg);
			}else if(Msg.MSG_TYPE_VOICE.equals(type)){
				VoiceMsg msg = new VoiceMsg(head);
				msg.read(document);
				this.onVoiceMsg(msg);
			}else if(Msg.MSG_TYPE_VIDEO.equals(type)){
				VideoMsg msg = new VideoMsg(head);
				msg.read(document);
				this.onVideoMsg(msg);
			}else{
				this.onErrorMsg(-1);//这里暂时这样处理的
			}
		} catch (SAXException e) { 
			this.onException(e);
		} catch (IOException e) { 
			this.onException(e);
		} catch (Throwable e){
		    this.onException(e);
		}finally{
		    this.close();
		}
	}






	/**
	 * 回传消息给微信服务器
	 * 只能再接收到微信服务器消息后，才能调用此方法
	 * @param msg 消息对象（支持：文本、音乐、图文）
	 * */
	public boolean callback(Msg msg){
	    if(Msg.MSG_TYPE_JSON.equals(msg.getMsgType())){
	        try
            {
                msg.write(os);
            }catch (IOException e)
            {
                this.onException(e);
                return false;
            }
	        return true;
	    }
		Document document = builder.newDocument();
		msg.write(document);
		try {
			Transformer transformer = tffactory.newTransformer();
			
			;
			transformer.transform(new DOMSource(document), new StreamResult(new OutputStreamWriter(os,"utf-8")));
			return true;
		} catch ( Exception e) { 
		    this.onException(e);
			return false;
		}
	}
	
	
	/**
	 * 关闭
	 * */
	public void close(){
		try {
			if(is != null){
				is.close();
			}
			if(os != null){
				os.flush();
				os.close();	
			}
			this.onDestory();
		} catch (Throwable e) {
		    this.onException(e);
		}
	}
	
	
	
	/**
	 * 收到文本消息
	 * @param msg
	 */
	public abstract void onTextMsg(TextMsg msg);
	
	/**
	 * 收到图片消息
	 * @param msg
	 */
	public abstract void onImageMsg(ImageMsg msg);
	
	/**
	 * 收到事件推送消息
	 * @param msg
	 * @throws Throwable 
	 */
	public abstract void onEventMsg(EventMsg msg);
	
	/**
	 * 收到链接消息
	 * @param msg
	 */
	public abstract void onLinkMsg(LinkMsg msg);
	
	/**
	 * 收到地理位置消息
	 * @param msg
	 */
	public abstract void onLocationMsg(LocationMsg msg);
	
	/**
	 * 收到语音识别消息
	 * @param msg
	 */
	public abstract void onVoiceMsg(VoiceMsg msg);
	

	/**
	 * 收到视频消息
	 * @param msg
	 */
	public abstract void onVideoMsg(VideoMsg msg);
	/**
	 * 微信公共号验证
	 */
	public abstract void onInterfaceValidata();
	
	public abstract void onGetToken();
	
	public abstract void onGetJsTicket();
	
	
	/**
	 * 错误消息
	 * @param errorCode
	 */
	public abstract void onErrorMsg(int errorCode);
 
	public abstract  void init (WeiXinInfo weixinInfo);
	public abstract void onDestory() throws Throwable;
	public abstract void onException(Throwable e);
}
