package com.honglinktech.zbgj.web.bean.request;

import com.honglinktech.zbgj.bean.request.BaseRequest;

/**
 * Created by Dayong on 16/3/2.
 */
public class SelectAddress extends BaseRequest {
    private String userCode;
    private int carId;
    private int type;
    private int addressId;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
