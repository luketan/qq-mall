package com.honglinktech.zbgj.common;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by shon on 12/1/15.
 */
public class BaseJsonRespone {
    @JsonProperty("ResultInt")
    private int ResultInt = 0;

    @JsonProperty("ResultString")
    private String ResultString = "";

    public BaseJsonRespone(int resultInt, String resultString) {
        ResultInt = resultInt;
        ResultString = resultString;
    }

    public BaseJsonRespone(int resultInt) {
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
