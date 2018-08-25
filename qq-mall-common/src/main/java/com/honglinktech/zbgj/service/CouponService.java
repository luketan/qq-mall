package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.CouponUserBean;
import com.honglinktech.zbgj.bean.GoodsTagBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Coupon;
import com.honglinktech.zbgj.entity.Gactivity;
import com.honglinktech.zbgj.entity.Gtag;

import java.util.List;
import java.util.Map;

/**
 * 优惠券
 */
public interface CouponService {
    /**
     * APP获取券数量
     * @return
     * @throws BaseException
     */
    int findCouponCount(Integer userId) throws BaseException;
    /**
     * APP获取券列表
     * @param userId
     * @param index
     * @param size
     * @param type 1,有效的购物券
     * @return
     * @throws BaseException
     */
    Response<List<Coupon>> findCoupons(Integer userId, Integer start, Integer rows, int type) throws BaseException;

    /**
     * APP删除券
     * @param userId
     * @param couponId
     * @return
     * @throws BaseException
     */
    Response<Integer> deleteCoupon(Integer userId, Integer couponId) throws BaseException ;

    /**
     * App获取用户单个优惠券
     * @param userId
     * @param couponId
     * @return
     * @throws BaseException
     */
    Coupon findUserCoupon(Integer userId, Integer couponId) throws BaseException ;

    /**
     * 使用券
     * @param userId
     * @param couponId
     * @return
     * @throws BaseException
     */
    Response<String> useCoupon(Integer userId, Integer couponId) throws BaseException;

    /**
     * console 获取优惠券列表
     * @param start
     * @param rows
     * @param url
     * @param whereMap
     * @return
     */
    Page<Coupon> findPageByWhere(int start, int rows, String url, Map whereMap);

    /**
     * console获取优惠券详情
     * @param id
     * @return
     */
    Response<Coupon> findById(Integer id);

    /**
     * console保存或者修改优惠券
     * @param coupon
     * @return
     */
    Response<Coupon> saveOrUpdate(Coupon coupon);

    /**
     * console 用户优惠券分页查询
     * @param start
     * @param rows
     * @param url
     * @param whereMap
     * @return
     */
    Page<CouponUserBean> findUserCouponBeanByWhere(int start, int rows, String url, Map whereMap);
}