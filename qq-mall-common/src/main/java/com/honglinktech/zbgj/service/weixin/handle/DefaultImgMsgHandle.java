package com.honglinktech.zbgj.service.weixin.handle;


import com.honglinktech.zbgj.service.weixin.HandleMessageAdapter;
import com.honglinktech.zbgj.service.weixin.msg.ImageMsg;
import com.honglinktech.zbgj.service.weixin.msg.TextMsg;

public class DefaultImgMsgHandle extends HandleMessageAdapter
{
    @Override
    public boolean onImageMsg(ImageMsg msg) {
        
            TextMsg reMsg = new TextMsg();
            reMsg.setFromUserName(msg.getToUserName());
            reMsg.setToUserName(msg.getFromUserName());
            reMsg.setCreateTime(msg.getCreateTime());
            reMsg.setContent("图片感谢您的反馈，稍后将会有客服与您联系!!");
            return this.getWeiXinSession().callback(reMsg);//回传消息
    }
}
