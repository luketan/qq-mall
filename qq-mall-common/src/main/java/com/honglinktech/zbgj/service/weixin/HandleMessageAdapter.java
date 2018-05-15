package com.honglinktech.zbgj.service.weixin;

import com.honglinktech.zbgj.service.weixin.msg.*;


/**
 * 处理消息适配器(适配器模式)
 * @author yc
 * */
public class HandleMessageAdapter implements HandleMessageListener {
    Session session;
    @Override
    public boolean onTextMsg(TextMsg msg)
    {
        return false;
    }

    @Override
    public boolean onImageMsg(ImageMsg msg)
    {
        return false;
        
    }

    @Override
    public boolean onEventMsg(EventMsg msg)
    {
        return false;
        
    }

    @Override
    public boolean onLinkMsg(LinkMsg msg)
    {
        return false;
        
    }

    @Override
    public boolean onLocationMsg(LocationMsg msg)
    {
        return false;
        
    }

    @Override
    public boolean onVoiceMsg(VoiceMsg msg)
    {
        return false;
        
    }

    @Override
    public boolean onErrorMsg(int errorCode)
    {
        return false;
        
    }

    @Override
    public boolean onVideoMsg(VideoMsg msg)
    {
        return false;
        
    }

    @Override
    public boolean onInterfaceValidata()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onGetToken()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onGetJsTicket()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setWeiXinSession(Session session)
    {
        // TODO Auto-generated method stub
        this.session=session;
    }
    @SuppressWarnings("unchecked")
	public  <S extends Session> S getWeiXinSession(Class<S> session1){
        return (S)this.session;
    }
    public Session getWeiXinSession(){
        return this.getWeiXinSession(Session.class);
    }
}
