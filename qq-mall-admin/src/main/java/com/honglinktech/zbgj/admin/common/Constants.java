package com.honglinktech.zbgj.admin.common;

/**
 * Created by Dayong on 16/2/24.
 */
public class Constants {

    public static final String PERMISSIONS = "ddb_permissions";

    public static final String LOGIN_ADMIN = "ddb_login_admin";

    public static final String LOGIN_ADMIN_DATA = "ddb_login_admin_data";

    public static final String UPYUN_ROOT_PATH = "http://resources.honglinktech.com/";

    public static final String IMAGES_TYPE_PNG = ".png";
    public static final String File_TYPE_PDF = ".pdf";


    public static final byte COMPANY_AUDIT_STATUS_PASS = 0X00;//通过审核
    public static final byte COMPANY_AUDIT_STATUS_NOT_PASS = 0X01;//未通过审核
    public static final byte COMPANY_AUDIT_STATUS_AUDITING = 0X02;//审核中

    public final static Byte RELEVANCE_TYPE_WJS = 0x00;//微金所
    public final static Byte RELEVANCE_TYPE_SHOP_MESSAGE = 0x02;//门店消息
    public final static Byte RELEVANCE_TYPE_SHOP_REPORT = 0x01;//门店报表


}
