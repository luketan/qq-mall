package com.honglinktech.zbgj.common;

import org.springframework.context.annotation.Configuration;

/**
 * 常量类
 * Created by Administrator on 2016/1/22.
 */
@Configuration
public class Constants {

    public final static String CONFIG_FILE_PATH = "config.properties";
    public static final String IMAGE_FILE_PATH = "images.file.path";

    //模块
    public final static String MODULE_NEW_PRODUCE = "2";//新品

    //删除标志
    public final static byte DELETE_TYPE_ZERO = 0X00;//未删除
    public final static byte DELETE_TYPE_ONE = 0X01;//已删除


    //CommonConfig key
    public final static String GROUP_HEAG_IMAGE_PAHT = "/data/services/zbgjapi/image";

    // 供货方式关联id类型
    public final static Integer SHIPMENT_MODE_REL_TYPE_NEW_PRODUCT = 1;//关联新品表

    public static final byte COMPANY_AUDIT_STATUS_PASS = 0X00;//通过审核
    public static final byte COMPANY_AUDIT_STATUS_NOT_PASS = 0X01;//未通过审核
    public static final byte COMPANY_AUDIT_STATUS_AUDITING = 0X02;//审核中

}
