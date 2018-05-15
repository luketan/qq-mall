package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.bean.GoodsTagBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Gtag;
import com.honglinktech.zbgj.vo.GoodsVO;

import java.util.List;
import java.util.Map;

/**
 * 商品活动
 */
public interface GoodsTagService {

    /**
     * 查询管理用户列表
     * @param index
     * @param size
     * @param whereMap
     * @return
     */
    Page<Gtag> findPageByWhere(int index, int size, String url, Map whereMap);

    /**
     *
     * @param activity
     * @return
     */
    Response<Gtag> saveOrUpdate(Gtag gtag);

    /**
     * 
     * @return
     */
    Response<List<Gtag>> findAll();

    /**
     *
     * @param goodsId
     * @return
     */
    Response<List<GoodsTagBean>> findAllByGoodsId(Integer goodsId);

    /**
     *
     * @param id
     * @return
     */
    Response<Gtag>  findById(Integer id);
}
