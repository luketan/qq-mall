package com.honglinktech.zbgj.service.self;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.TCouponDao;
import com.honglinktech.zbgj.dao.TCouponUserDao;
import com.honglinktech.zbgj.entity.TCoupon;
import com.honglinktech.zbgj.entity.TCouponUser;
import com.honglinktech.zbgj.service.TCouponService;

/**
 * 优惠券
 */
@Component
public class CouponService extends TCouponService {

	@Resource
	private TCouponDao tcouponDao;
	@Resource
	private TCouponUserDao tcouponUserDao;
		
	/**
	 * 获取券数量
	 * @param tuserAddress
	 * @return
	 * @throws BaseException
	 */
	public Response<Object> findCouponCount(Integer userId) throws BaseException{
		String sql = "SELECT count(1) AS count FROM t_coupon_user couUser LEFT JOIN t_coupon c ON(couUser.coupon_id = c.id ) WHERE couUser.user_id = "+userId+" AND couUser.status=0 AND c.start_date <= CURDATE() AND c.end_date >= CURDATE()";
		Map<String,Object> resMap= tcouponUserDao.queryForMap(sql);
		return Result.resultSet(resMap.get("count"));
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
	public Response<List<TCoupon>> findCoupons(Integer userId,Integer index,Integer size,int type) throws BaseException{
		String sql = "";
		if(type==1){
			sql = "SELECT c.* FROM t_coupon_user couUser LEFT JOIN t_coupon c ON(couUser.coupon_id = c.id) WHERE couUser.user_id = "+userId+" AND  couUser.status=0  AND  c.start_date <= CURDATE() AND c.end_date >= CURDATE() ORDER BY c.start_date DESC";
		}else{
			sql = "SELECT c.* FROM t_coupon_user couUser LEFT JOIN t_coupon c ON(couUser.coupon_id = c.id) WHERE couUser.user_id = "+userId+" AND  (couUser.status<>0 OR c.start_date > CURDATE() OR c.end_date < CURDATE()) ORDER BY c.start_date DESC";
		}
		if(index!=null && size!=null && size > 0){
			int start = (index-1)*size;
			start = (start<0?0:start);
			sql+=(" LIMIT "+start+","+size);
		}
		System.out.println("sql="+sql);
		List<TCoupon> tcoupons = tcouponDao.find(sql);
		return Result.resultSet(tcoupons);
	}
	/**
	 *  删除券
	 * @param valueOf
	 * @param couponId
	 * @return
	 * @throws BaseException 
	 */
	public Response<String> deleteCoupon(Integer userId, Integer couponId) throws BaseException {
		
		TCouponUser cu = new TCouponUser();
		cu.setCouponId(couponId);
		cu.setUserId(userId);
		tcouponUserDao.delete(cu);
		return Result.success();
	}
	/**
	 * 获取用户单个优惠券
	 * @param valueOf
	 * @param couponId
	 * @return
	 * @throws BaseException 
	 */
	public TCoupon findUserCoupon(Integer userId, Integer couponId) throws BaseException {
		String sql = "SELECT c.* FROM t_coupon_user couUser LEFT JOIN t_coupon c ON(couUser.coupon_id = c.id) WHERE couUser.user_id = "+userId+" AND couUser.coupon_id = "+couponId+" AND  couUser.status=0  AND  c.start_date <= CURDATE() AND c.end_date >= CURDATE() ORDER BY c.start_date DESC";
		List<TCoupon> tcoupons = tcouponDao.find(sql);
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
		int result = tcouponUserDao.updateExecute("update t_coupon_user set status = 1 where user_id="+userId+" AND coupon_id = "+couponId);
		if(result>0){
			return Result.success();
		}else{
			return Result.fail("优惠券使用失败");
		}
		
	}
	
}
