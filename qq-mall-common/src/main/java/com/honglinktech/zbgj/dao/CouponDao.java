/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import java.util.List;
import java.util.Map;

import com.honglinktech.zbgj.entity.Coupon;

public interface CouponDao {

    int deleteById(Integer id);

    int insert(Coupon record);

    Coupon findById(Integer id);
    
    int update(Coupon record);
    
    /**************************************************************************************************************/

    /**
     * APP 获取优惠券列表
     * @param whereMap
     * @return
     */
    List<Coupon> findCoupons(Map<String, Integer> whereMap);

	/**
	 * APP 获取用户优惠券详情
	 * @param userId
	 * @param couponId
	 * @return
	 */
	List<Coupon> findCouponByUser(Integer userId, Integer couponId);

    /**
     * console
     * @param where
     * @return
     */
    List<Coupon> findCouponWhere(Map where);
    /**
     * console
     * @param where
     * @return
     */
    int findCouponCountWhere(Map where);
}