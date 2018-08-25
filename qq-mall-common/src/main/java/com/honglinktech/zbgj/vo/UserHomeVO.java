package com.honglinktech.zbgj.vo;

/**
 * Created by Administrator on 2018/8/25.
 */
public class UserHomeVO {
    private UserVO userVO;
    private int couponNum;

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
}
