package com.honglinktech.zbgj.api.common;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by shon on 12/1/15.
 */
public class ZbgjBaseJsonRespone {
    @JsonProperty("ResultInt")
    private int ResultInt = 0;

    @JsonProperty("ResultString")
    private String ResultString = "";

    public ZbgjBaseJsonRespone(int resultInt, String resultString) {
        ResultInt = resultInt;
        ResultString = resultString;
    }

    public ZbgjBaseJsonRespone(int resultInt) {
        ResultInt = resultInt;
    }

    public int getResultInt() {
        return ResultInt;
    }

    @JsonProperty("ResultInt")
    public void setResultInt(int resultInt) {
        ResultInt = resultInt;
    }

    @JsonProperty("ResultString")
    public String getResultString() {
        return ResultString;
    }

    public void setResultString(String resultString) {
        ResultString = resultString;
    }
}
