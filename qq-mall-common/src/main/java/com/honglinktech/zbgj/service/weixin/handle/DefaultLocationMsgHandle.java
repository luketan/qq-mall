package com.honglinktech.zbgj.service.weixin.handle;

import com.honglinktech.zbgj.service.weixin.HandleMessageAdapter;
import com.honglinktech.zbgj.service.weixin.msg.LocationMsg;
import com.honglinktech.zbgj.service.weixin.msg.TextMsg;

public class DefaultLocationMsgHandle extends HandleMessageAdapter
{
   
    public boolean onLocationMsg(LocationMsg msg) {
        TextMsg reMsg = msg.getReplayMsg(TextMsg.class);
        reMsg.setFromUserName(msg.getToUserName());
        reMsg.setToUserName(msg.getFromUserName());
        reMsg.setCreateTime(msg.getCreateTime()); 
        reMsg.setContent("感谢您分享位置信息!"); 
        return this.getWeiXinSession().callback(reMsg);// 回传消息 
    }
}
