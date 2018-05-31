package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Admin;
import com.honglinktech.zbgj.entity.AdminRole;
import com.honglinktech.zbgj.entity.Gactivity;
import com.honglinktech.zbgj.entity.GoodsActivity;

import java.util.List;
import java.util.Map;

/**
 * 商品活动
 */
public interface GoodsActivityService {
    /**
     * 查询管理用户列表
     * @param index
     * @param size
     * @param whereMap
     * @return
     */
    Page<Gactivity> findPageByWhere(int index, int size, String url, Map whereMap);

    /**
     *
     * @param activity
     * @return
     */
    Response<Gactivity> saveOrUpdate(Gactivity activity);

    /**
     *
     * @return
     */
    Response<List<Gactivity>> findAll();

    /**
     *
     * @param goodsId
     * @return
     */
    Response<List<ActivityBean>> findAllByGoodsId(Integer goodsId);

    /**
     *
     * @param id
     * @return
     */
    Response<Gactivity> findById(Integer id);
}
