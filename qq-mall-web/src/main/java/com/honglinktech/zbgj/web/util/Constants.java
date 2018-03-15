package com.honglinktech.zbgj.web.util;

/**
 * Created by Dayong on 16/2/24.
 */
public class Constants {

    public static final String PERMISSIONS = "zbgj_user_permissions_v0";

    public static final String LOGIN_USER = "login_user";

    public static final String LOGIN_USER_DATA = "zbgj_user_login_data_v0";

    public static final String UPYUN_ROOT_PATH = "http://resources.honglinktech.com/";
    public static final String UPYUN_COMPANY_ROOT_PATH = "https://cdn2.honglinktech.com/";

    public static final String UPYUN_ROOT_PATH_LONG = "https://www.honglinktech.com/upyun/resources/";

    public static final String ADVERTISE_TURN_URL = "https://www.honglinktech.com/zbgjh5/html/common.html?url=";

    public static final String IMAGES_TYPE_PNG = ".png";


    public static final byte COMPANY_AUDIT_STATUS_PASS = 0X00;//通过审核
    public static final byte COMPANY_AUDIT_STATUS_NOT_PASS = 0X01;//未通过审核
    public static final byte COMPANY_AUDIT_STATUS_AUDITING = 0X02;//审核中

    public final static Byte RELEVANCE_TYPE_WJS = 0x00;//微金所
    public final static Byte RELEVANCE_TYPE_SHOP_MESSAGE = 0x02;//门店消息
    public final static Byte RELEVANCE_TYPE_SHOP_REPORT = 0x01;//门店报表


}
