/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.entity.Gactivity;

import java.util.List;
import java.util.Map;

public interface GactivityDao {

    int deleteById(Integer id);

    int insert(Gactivity record);

    Gactivity findById(Integer id);

    int update(Gactivity record);

    /**************************************************************************************/
    /**
     *
     * @param whereMap
     * @return
     */
    List<Gactivity> findByWhere(Map whereMap);

    /**
     *
     * @param whereMap
     * @return
     */
    int findCount(Map whereMap);

    /**
     *
     * @param goodsId
     * @return
     */
    List<ActivityBean> findAllByGoodsId(Integer goodsId);
}