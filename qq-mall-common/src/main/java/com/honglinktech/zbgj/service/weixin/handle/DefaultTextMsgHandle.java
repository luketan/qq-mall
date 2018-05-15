package com.honglinktech.zbgj.service.weixin.handle;


import com.honglinktech.zbgj.service.weixin.HandleMessageAdapter;
import com.honglinktech.zbgj.service.weixin.msg.TextMsg;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultTextMsgHandle extends HandleMessageAdapter
{
    @Override
    public boolean onTextMsg(TextMsg msg) {

        String retText = "";
        String text = msg.getContent();
        text = cleanText(text);
        String type = checkText(text);
        if(type != null){
            if (type.equalsIgnoreCase("imei")) {
                //TODO
            }else{
                //TODO
            }
        }else{
            retText = "你输入有误，请检查输入的序列号或者IMEI！";
        }
        System.out.println("===============" + text);

        TextMsg reMsg = new TextMsg();
        reMsg.setFromUserName(msg.getToUserName());
        reMsg.setToUserName(msg.getFromUserName());
        reMsg.setCreateTime(msg.getCreateTime());
        reMsg.setContent(retText);
        return this.getWeiXinSession().callback(reMsg);//回传消息
    }

    private String cleanText(String text){
        if(StringUtils.isEmpty(text)){
            return null;
        }
        String regEx="[a-zA-Z0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(text);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            sb.append(m.group());
        }

        return  sb.toString();
    }

    private static String checkText(String text){
        text = text.replace(" ","");
        String imeiReg = "[0-9]{15}|[0-9]{17}";
        String xuliehaoReg = "[0-9A-Z]{12}";
        Pattern imeiPattern = Pattern.compile(imeiReg);
        Matcher imeiMat = imeiPattern.matcher(text);
        if(imeiMat.matches()){
            return "imei";
        }
        Pattern xuliehaoPattern = Pattern.compile(xuliehaoReg);
        Matcher xuliehaoMat = xuliehaoPattern.matcher(text);
        if(xuliehaoMat.matches()){
            return "xlh";
        }
        return  null;
    }

    public static void main(String[] args) {
        //imei:356988067298808
        //序列号:DNPP1BJDG5MC
        //35 438406 651461 3
        //FK5NPPUKG5QY
        System.out.println("======"+ checkText("35 438406 651461 3"));
    }
}
