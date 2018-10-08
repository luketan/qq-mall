package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.CouponUserBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.CouponDao;
import com.honglinktech.zbgj.dao.CouponUserDao;
import com.honglinktech.zbgj.entity.Coupon;
import com.honglinktech.zbgj.service.CouponService;
import com.honglinktech.zbgj.vo.CouponUserVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
@Component
public class CouponServiceImpl implements CouponService{


    @Resource
    private CouponDao couponDao;
    @Resource
    private CouponUserDao couponUserDao;

    /**
     * APP获取用户优惠券列表
     * @param userId
     * @param type 1,有效的购物券
     * @return
     * @throws BaseException
     */
    @Override
    public Response<List<CouponUserVO>> findUserCoupons(Integer userId, Integer start, Integer rows, int type) throws BaseException{
        Map<String, Integer> whereMap = new HashMap<String, Integer>();
        whereMap.put("userId", userId);
        whereMap.put("start", start);
        whereMap.put("rows", rows);
        whereMap.put("type", type);
        List<CouponUserVO> coupons = couponUserDao.findUserCouponVOs(whereMap);
        return Result.resultSet(coupons);
    }

    @Override
    public Response<CouponUserVO> findUserCouponById(Integer userId, Integer id) throws BaseException {
        CouponUserVO couponUserVO = couponUserDao.findUserCouponVOById(userId, id);
        if(couponUserVO == null){
            return Result.fail("找不到优惠券！");
        }else{
            return Result.resultSet(couponUserVO);
        }

    }

    /**
     * APP删除用户优惠券
     * @param userId
     * @return
     * @throws BaseException
     */
    @Override
    public Response<Integer> deleteUserCoupon(Integer userId, Integer id) throws BaseException {

        int result = couponUserDao.deleteByUserIdAndCouponId(userId, id);
        return Result.resultSet(result);
    }

    /**
     * APP获取用户单个优惠券详情
     * @param userId
     * @return
     * @throws BaseException
     */
    @Override
    public CouponUserVO findUserCouponVO(Integer userId, Integer couponUserId) throws BaseException {
        CouponUserVO couponUserVO = couponUserDao.findUserCouponVOById(userId, couponUserId);
        return couponUserVO;
    }

    /**
     * APP使用券
     * @param userId
     * @param couponId
     * @return
     * @throws BaseException
     */
    @Override
    public Response<String> useUserCoupon(Integer userId, Integer couponId) throws BaseException {
        int result = couponUserDao.useUserCoupon(userId, couponId);
        if(result>0){
            return Result.success();
        }else{
            return Result.fail("优惠券使用失败");
        }
    }


    /**
     * console 分页查询
     * @param start
     * @param rows
     * @param url
     * @param whereMap
     * @return
     */
    @Override
    public Page<Coupon> findPageByWhere(int start, int rows, String url, Map whereMap) {
        if(whereMap == null){
            whereMap = new HashMap();
        }

        whereMap.put("start", start);
        whereMap.put("rows", rows);
        List<Coupon> coupons = couponDao.findCouponWhere(whereMap);
        int total = couponDao.findCouponCountWhere(whereMap);
        return new Page<Coupon>(start, rows, total, url, coupons);
    }

    /**
     * console 获取优惠券详情
     * @param id
     * @return
     */
    @Override
    public Response<Coupon> findById(Integer id) {
        Coupon coupon = couponDao.findById(id);
        return Result.resultSet(coupon);
    }

    /**
     * conosle 保存或者修改优惠券
     * @param coupon
     * @return
     */
    @Override
    public Response<Coupon> saveOrUpdate(Coupon coupon) {
        if(coupon.getId() != null && coupon.getId() > 0){
            couponDao.update(coupon);
        }else{
            couponDao.insert(coupon);
        }
        return Result.resultSet(coupon);
    }

    /**
     * console 用户优惠券分页查询
     * @param start
     * @param rows
     * @param url
     * @param whereMap
     * @return
     */
    @Override
    public Page<CouponUserBean> findUserCouponBeanByWhere(int start, int rows, String url, Map whereMap) {
        if(whereMap == null){
            whereMap = new HashMap();
        }
        whereMap.put("start", start);
        whereMap.put("rows", rows);

        List<CouponUserBean> couponUserBeans = couponUserDao.findUserCouponBeanByWhere(whereMap);
        int total = couponUserDao.findUserCouponBeanCountByWhere(whereMap);
        return new Page<CouponUserBean>(start, rows, total, url, couponUserBeans);
    }
}
