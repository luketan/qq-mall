package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.bean.GoodsBrandBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Gactivity;
import com.honglinktech.zbgj.entity.GoodsBrand;

import java.util.List;
import java.util.Map;

/**
 * 商品品牌
 */
public interface GoodsBrandService {
    /**
     * 查询管理用户列表
     * @param index
     * @param size
     * @param whereMap
     * @return
     */
    Page<GoodsBrandBean> findPageByWhere(int index, int size, String url, Map whereMap);

    /**
     *
     * @param goodsBrand
     * @return
     */
    Response<GoodsBrand> saveOrUpdate(GoodsBrand goodsBrand);

    /**
     *
     * @return
     */
    Response<List<GoodsBrand>> findAll();

    /**
     *
     * @param id
     * @return
     */
    Response<GoodsBrand> findById(Integer id);
}
