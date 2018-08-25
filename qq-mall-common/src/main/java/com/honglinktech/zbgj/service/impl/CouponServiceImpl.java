package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.CouponUserBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.CouponDao;
import com.honglinktech.zbgj.dao.CouponUserDao;
import com.honglinktech.zbgj.dao.GoodsBrandDao;
import com.honglinktech.zbgj.entity.Coupon;
import com.honglinktech.zbgj.entity.Gactivity;
import com.honglinktech.zbgj.entity.GoodsBrand;
import com.honglinktech.zbgj.service.CouponService;
import com.honglinktech.zbgj.service.GoodsBrandService;
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
     * 获取券数量
     * @return
     * @throws BaseException
     */
    @Override
    public int findCouponCount(Integer userId) throws BaseException{
        int count= couponUserDao.findCouponCountByUser(userId);
        return count;
    }
    /**
     * APP获取券列表
     * @param userId
     * @param index
     * @param size
     * @param type 1,有效的购物券
     * @return
     * @throws BaseException
     */
    @Override
    public Response<List<Coupon>> findCoupons(Integer userId,Integer start,Integer rows,int type) throws BaseException{
        Map<String, Integer> whereMap = new HashMap<String, Integer>();
        whereMap.put("userId", userId);
        whereMap.put("start", start);
        whereMap.put("rows", rows);
        whereMap.put("type", type);
        List<Coupon> coupons = couponDao.findCoupons(whereMap);
        return Result.resultSet(coupons);
    }

    /**
     * APP删除券
     * @param userId
     * @param couponId
     * @return
     * @throws BaseException
     */
    @Override
    public Response<Integer> deleteCoupon(Integer userId, Integer couponId) throws BaseException {

        int result = couponUserDao.deleteByUserIdAndCouponId(userId, couponId);
        return Result.resultSet(result);
    }

    /**
     * APP获取用户单个优惠券
     * @param userId
     * @param couponId
     * @return
     * @throws BaseException
     */
    @Override
    public Coupon findUserCoupon(Integer userId, Integer couponId) throws BaseException {
        List<Coupon> tcoupons = couponDao.findCouponByUser(userId, couponId);
        if(tcoupons!=null && tcoupons.size() > 0){
            return tcoupons.get(0);
        }else{
            return null;
        }

    }

    /**
     * APP使用券
     * @param userId
     * @param couponId
     * @return
     * @throws BaseException
     */
    @Override
    public Response<String> useCoupon(Integer userId, Integer couponId) throws BaseException {
        int result = couponUserDao.useCoupon(userId, couponId);
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
        Coupon coupon = couponDao.selectByPrimaryKey(id);
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
            couponDao.updateByPrimaryKeySelective(coupon);
        }else{
            couponDao.insertSelective(coupon);
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
