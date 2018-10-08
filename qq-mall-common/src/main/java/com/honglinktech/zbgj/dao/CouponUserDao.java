/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.bean.CouponUserBean;
import com.honglinktech.zbgj.entity.CouponUser;
import com.honglinktech.zbgj.vo.CouponUserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CouponUserDao {

    int deleteById(Integer id);


    int insert(CouponUser record);


    CouponUser findId(Integer id);


    int update(CouponUser record);

    /***************************************************************************************************************/

	/**
	 *
	 * @param whereMap
	 * @return
     */
	List<CouponUserVO> findUserCouponVOs(Map<String, Integer> whereMap);
	/**
	 * APP
	 * @return
	 */
	CouponUserVO findUserCouponVOById(@Param(value = "userId") int userId, @Param(value = "id") int id);
	
	/**
	 * App删除用户的优惠券
	 * @param userId
	 * @return
	 */
	int deleteByUserIdAndCouponId(@Param(value = "userId") Integer userId, @Param(value = "id") Integer id);
	
	/**
	 * App使用优惠券
	 * @param userId
	 * @param couponId
	 * @return
	 */
	int useUserCoupon(Integer userId, Integer couponId);

	////

	/**
	 * console
	 * @param whereMap
	 * @return
	 */
    List<CouponUserBean> findUserCouponBeanByWhere(Map whereMap);

	/**
	 * console
	 * @return
	 */
	CouponUserBean findUserCouponBeanById(int id);

	/**
	 * console
	 * @param whereMap
	 * @return
	 */
	int findUserCouponBeanCountByWhere(Map whereMap);

}