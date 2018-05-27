package com.honglinktech.zbgj.common;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/12.
 */
public class CV implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -7975052494697806564L;

    private int code;
    private String value;

    public CV(){

    }

    public CV(int code, String value){
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
