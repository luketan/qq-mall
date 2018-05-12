package com.honglinktech.zbgj.common;


/**
 * @param <T>
 */
public class Response<T> {
    private int code;  //0表示成功   1表示失败  9999token超时
    private String msg;
    private T result;
    private int totalRecord;//总记录数


    /**
     * <p>Title: </p>
     * <p>Description: </p>
     *
     * @param id
     * @param desc
     */
    public Response(int code, String desc) {
        this.code = code;
        this.msg = desc;
    }

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     *
     * @param id
     * @param desc
     */
    public Response(int code, String desc, T result) {
        this.code = code;
        this.msg = desc;
        this.result = result;
    }

    public Response(int code, String msg, T result, int totalRecord) {
        this.code = code;
        this.msg = msg;
        this.result = result;
        this.totalRecord = totalRecord;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }
}