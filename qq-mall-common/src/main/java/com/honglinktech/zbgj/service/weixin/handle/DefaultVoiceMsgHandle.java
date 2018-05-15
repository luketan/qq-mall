package com.honglinktech.zbgj.service.weixin.handle;

import com.honglinktech.zbgj.service.weixin.HandleMessageAdapter;
import com.honglinktech.zbgj.service.weixin.msg.TextMsg;
import com.honglinktech.zbgj.service.weixin.msg.VoiceMsg;

public class DefaultVoiceMsgHandle extends HandleMessageAdapter
{
    public boolean onVoiceMsg(VoiceMsg msg) {
        TextMsg reMsg = new TextMsg();
        reMsg.setFromUserName(msg.getToUserName());
        reMsg.setToUserName(msg.getFromUserName());
        reMsg.setCreateTime(msg.getCreateTime()); 
        reMsg.setContent("识别结果: "+msg.getRecognition()); 
        return this.getWeiXinSession().callback(reMsg);// 回传消息 
    }
}
