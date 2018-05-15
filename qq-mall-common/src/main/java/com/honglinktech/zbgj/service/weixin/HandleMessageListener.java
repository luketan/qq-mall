package com.honglinktech.zbgj.service.weixin;


import com.honglinktech.zbgj.service.weixin.msg.*;

/**
 * 主要用于接收微信服务器消息的接口
 * @author yc
 * */
public interface HandleMessageListener {

	/**
	 * 收到文本消息
	 * @param msg
	 */
	public abstract boolean onTextMsg(TextMsg msg);
	
	/**
	 * 收到图片消息
	 * @param msg
	 */
	public abstract boolean onImageMsg(ImageMsg msg);
	
	/**
	 * 收到事件推送消息
	 * @param msg
	 * @throws Throwable 
	 */
	public abstract boolean onEventMsg(EventMsg msg);
	
	/**
	 * 收到链接消息
	 * @param msg
	 */
	public abstract boolean onLinkMsg(LinkMsg msg);
	
	/**
	 * 收到地理位置消息
	 * @param msg
	 */
	public abstract boolean onLocationMsg(LocationMsg msg);
	
	/**
	 * 语音识别消息
	 * @param msg
	 */
	public abstract boolean onVoiceMsg(VoiceMsg msg);
	
	/**
	 * 错误消息
	 * @param errorCode
	 */
	public abstract boolean onErrorMsg(int errorCode);

	/**
	 * 视频消息
	 * @param msg
	 */
	public abstract boolean onVideoMsg(VideoMsg msg);
	
    public abstract boolean onInterfaceValidata();
    
    public abstract boolean onGetToken();
    
    public abstract boolean onGetJsTicket();

	public void setWeiXinSession(Session session);
}
