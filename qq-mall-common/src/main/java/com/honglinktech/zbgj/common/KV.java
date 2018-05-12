package com.honglinktech.zbgj.common;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/12.
 */
public class KV implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -7975052494697806564L;

    private String key;
    private String value;

    public KV(){

    }

    public KV(String key, String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
