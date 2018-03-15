package com.honglinktech.zbgj.service.weixin.Service;

import com.honglinktech.zbgj.utils.HttpUtil;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/19.
 */
public class DataService {

    public String imeiFindDataByGet(String imei){
        try {
            return HttpUtil.sendGet("http://api.3023.com/3023/apple?app=coverage&token=1a4c827931fa2b0499a924ca42d6c0dd8e8c5fy78a&sn="+imei, 100000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String imeiFindDataByPost(String imei){
        return null;
    }

    public static void main(String[] args) {
        //imei:356988067298808
        //序列号:DNPP1BJDG5MC
        //35 438406 651461 3
        //FK5NPPUKG5QY
        int i = 0;
        while (true) {
            i++;
            DataService dataService = new DataService();
            String respon = dataService.imeiFindDataByGet("356988067298808");
            System.out.println(i+"======222222222222222========"+new Date() + "======" + respon);
            if (respon.indexOf("产地：中国（郑州）")==-1) {
                System.out.println(new Date() + "***********************************");
                break;
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
