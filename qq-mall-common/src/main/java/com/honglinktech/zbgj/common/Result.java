package com.honglinktech.zbgj.common;

import com.honglinktech.zbgj.base.ExceptionEnum;



/**
 * 结果处理类
 */
public class Result {
    /**
     * 生成操作成功的返回对象
     *
     * @return
     */
    public static <T> Response<T> success() {
        return new Response<T>(ExceptionEnum.COMMON_SUCCESS.getRetCode(), "操作成功");
    }


    /**
     * 生成操作成功的返回对象
     *
     * @param desc
     * @return
     */
    public static <T> Response<T> success(String desc) {
        return new Response<T>(ExceptionEnum.COMMON_SUCCESS.getRetCode(), desc);
    }

    /**
     * 生成操作失败的返回对象
     *
     * @param desc
     * @return
     */
    public static <T> Response<T> fail(String desc) {
        return new Response<T>(ExceptionEnum.COMMON_ERROE.getRetCode(), desc);
    }
    /**
     * 生成操作失败的返回对象
     *
     * @param desc
     * @return
     */
    public static <T> Response<T> fail(ExceptionEnum ee, String...args) {
        return new Response<T>(ee.getRetCode(), ee.getRetString(args));
    }

    /**
     * 生成操作失败的返回对象
     *
     * @param code
     * @param desc
     * @return
     */
    public static <T> Response<T> fail(String code, String desc) {
        return new Response<T>(code, desc);
    }

    /**
     * 把结果对象返回到客户端
     *
     * @param result
     * @return
     */
    public static <T> Response<T> resultSet(T result) {
        return new Response<T>(ExceptionEnum.COMMON_SUCCESS.getRetCode(), "操作成功", result);
    }
    /**
     * 
     * @param ee
     * @param args
     * @return
     */
    public static <T> Response<T> resultExceptionEnum(ExceptionEnum ee, String...args) {
        return new Response<T>(ee.getRetCode(), ee.getRetString(args));
    }
    /**
     * @param result
     * @param totalRecord 总数
     * @param <T>
     * @return
     */
    public static <T> Response<T> resultSet(T result, int totalRecord) {
        return new Response<T>(ExceptionEnum.COMMON_SUCCESS.getRetCode(), "操作成功", result, totalRecord);
    }

    /**
     * 把结果对象返回到客户端
     *
     * @param msg    提示信息
     * @param result 结果
     * @return
     */
    public static <T> Response<T> resultSet(String msg, T result) {
        return new Response<T>(ExceptionEnum.COMMON_SUCCESS.getRetCode(), msg, result);
    }


    public static <T> Response<T> resultSet(String msg, T result, int totalRecord) {
        return new Response<T>(ExceptionEnum.COMMON_SUCCESS.getRetCode(), msg, result, totalRecord);
    }
}
