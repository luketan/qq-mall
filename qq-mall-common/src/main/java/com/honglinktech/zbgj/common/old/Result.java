package com.honglinktech.zbgj.common.old;


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
        return new Response<T>(0, "操作成功");
    }


    /**
     * 生成操作成功的返回对象
     *
     * @param desc
     * @return
     */
    public static <T> Response<T> success(String desc) {
        return new Response<T>(0, desc);
    }

    /**
     * 生成操作失败的返回对象
     *
     * @param desc
     * @return
     */
    public static <T> Response<T> fail(String desc) {
        return new Response<T>(1, desc);
    }

    /**
     * 生成操作失败的返回对象
     *
     * @param code
     * @param desc
     * @return
     */
    public static <T> Response<T> fail(int code, String desc) {
        return new Response<T>(code, desc);
    }

    /**
     * 把结果对象返回到客户端
     *
     * @param result
     * @return
     */
    public static <T> Response<T> resultSet(T result) {
        return new Response<T>(0, "操作成功", result);
    }

    /**
     * @param result
     * @param totalRecord 总数
     * @param <T>
     * @return
     */
    public static <T> Response<T> resultSet(T result, int totalRecord) {
        return new Response<T>(0, "操作成功", result, totalRecord);
    }

    /**
     * 把结果对象返回到客户端
     *
     * @param msg    提示信息
     * @param result 结果
     * @return
     */
    public static <T> Response<T> resultSet(String msg, T result) {
        return new Response<T>(0, msg, result);
    }


    public static <T> Response<T> resultSet(String msg, T result, int totalRecord) {
        return new Response<T>(0, msg, result, totalRecord);
    }
}
