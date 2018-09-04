package com.honglinktech.zbgj.vo;

/**
 * Created by Administrator on 2018/8/25.
 */
public class UserHomeVO {
    private UserVO userVO;
    private int couponNum;
    private int orderNum;
    private int keepNum;

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public int getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(int couponNum) {
        this.couponNum = couponNum;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getKeepNum() {
        return keepNum;
    }

    public void setKeepNum(int keepNum) {
        this.keepNum = keepNum;
    }
}
