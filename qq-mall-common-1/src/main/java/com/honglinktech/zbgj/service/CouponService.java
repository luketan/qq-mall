package com.honglinktech.zbgj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.CouponDao;
import com.honglinktech.zbgj.dao.CouponUserDao;
import com.honglinktech.zbgj.entity.Coupon;

/**
 * 优惠券
 */
@Component
public class CouponService {

	@Resource
	private CouponDao couponDao;
	@Resource
	private CouponUserDao couponUserDao;
		
	/**
	 * 获取券数量
	 * @param tuserAddress
	 * @return
	 * @throws BaseException
	 */
	public Response<Object> findCouponCount(Integer userId) throws BaseException{
		int count= couponUserDao.findCouponCountByUser(userId);
		return Result.resultSet(count);
	}
	/**
	 * 获取券列表
	 * @param userId
	 * @param index
	 * @param size
	 * @param type 1,有效的购物券
	 * @return
	 * @throws BaseException
	 */
	public Response<List<Coupon>> findCoupons(Integer userId,Integer index,Integer size,int type) throws BaseException{
		Map<String, Integer> whereMap = new HashMap<String, Integer>();
		whereMap.put("userId", userId);
		whereMap.put("index", index);
		whereMap.put("size", size);
		whereMap.put("type", type);
		List<Coupon> tcoupons = couponDao.findCoupons(whereMap);
		return Result.resultSet(tcoupons);
	}
	/**
	 *  删除券
	 * @param valueOf
	 * @param couponId
	 * @return
	 * @throws BaseException 
	 */
	public Response<Integer> deleteCoupon(Integer userId, Integer couponId) throws BaseException {
		
		int result = couponUserDao.deleteByUserIdAndCouponId(userId, couponId);
		return Result.resultSet(result);
	}
	/**
	 * 获取用户单个优惠券
	 * @param valueOf
	 * @param couponId
	 * @return
	 * @throws BaseException 
	 */
	public Coupon findUserCoupon(Integer userId, Integer couponId) throws BaseException {
		List<Coupon> tcoupons = couponDao.findCouponByUser(userId, couponId);
		if(tcoupons!=null && tcoupons.size() > 0){
			return tcoupons.get(0);
		}else{
			return null;
		}
		
	}
	
	/**
	 *  使用券
	 * @param valueOf
	 * @param couponId
	 * @return
	 * @throws BaseException 
	 */
	public Response<String> useCoupon(Integer userId, Integer couponId) throws BaseException {		
		int result = couponUserDao.useCoupon(userId, couponId);
		if(result>0){
			return Result.success();
		}else{
			return Result.fail("优惠券使用失败");
		}
		
	}
	
}
