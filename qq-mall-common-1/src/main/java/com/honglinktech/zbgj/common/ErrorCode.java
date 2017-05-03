package com.honglinktech.zbgj.common;

/**
 * Created by Administrator on 2016/1/11.
 */
public class ErrorCode {
    public static final int PARAMETER_NOT_EMPTY_ERROR = 20000;//参数不能为空

    public static final int PARAMETER_TYPE_ERROR = 20001;//参数类型错误


    public static final int DATABASE_NONENTITY_ERROR = 21002;//数据库不存在此数据
    public static final int DATABASE_ERROR = 21000;//数据库错误

    public static final int DATABASE_UPDATE_ERROR = 21001;//数据库为更新数据

    public static final int SYSTEM_ERROR = 22000;//系统异常
    
    public static int tokenFail = 9999; //token失效

    public static int SHOP__HAVE_AUTH_ERROR = 23000 ; // 门店已经授权
    public static int SHOP__NOT_AUTH_ERROR = 23001 ; //门店没有授权
    
    public static final int EXPRESS_NO_DATA_ERROR = 30000;//没有查询出快递信息

    public static final int SYSTEM_NO_BUSINESS_TIME = 50000;//不是系统运营时间
    public static final int USER_LOGIN_ERROR = 50001;//用户登录名或者密码错误
    public static final int USER_BLACKLIST_ERROR = 50002;//用户被锁定

}
