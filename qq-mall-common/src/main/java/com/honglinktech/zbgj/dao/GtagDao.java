/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.bean.GoodsTagBean;
import com.honglinktech.zbgj.entity.Gtag;

import java.util.List;
import java.util.Map;

public interface GtagDao {

    int deleteById(Integer id);

    int insert(Gtag record);

    Gtag findById(Integer id);


    int update(Gtag record);

    /*#############################################################################*/
    /**
     *
     * @param tagId
     * @return
     */
    List<GoodsTagBean> findAllByGoodsId(Integer tagId);

    /**
     *
     * @param whereMap
     * @return
     */
    List<Gtag> findByWhere(Map whereMap);

    /**
     *
     * @param whereMap
     * @return
     */
    int findCount(Map whereMap);
}