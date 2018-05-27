/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.entity.GoodsActivity;
import com.honglinktech.zbgj.entity.GoodsActivityKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsActivityDao {


    int deleteByPrimaryKey(GoodsActivityKey key);


    int insert(GoodsActivity record);


    GoodsActivity findById(GoodsActivityKey key);


    int update(GoodsActivity record);


    /*********************************************************************************************************/
    /**
     * APP通过商品ID获取有效活动
     * @param goodsId
     * @return
     */
    List<ActivityBean> findActivityByGoodsId(@Param(value = "goodsId") Integer goodsId);

    /**
     * APP通过商品ID获取有效活动 (去重复)
     * @param goodsIds
     * @return
     */
    List<ActivityBean> findActivityByGoodsIds(@Param(value = "goodsIds") List<Integer> goodsIds);

    /**
     *
     * @param goodsActivities
     * @return
     */
    int saveBatch(@Param(value = "goodsActivitys")List<GoodsActivity> goodsActivitys);

    /**
     *
     * @param goodsId
     * @return
     */
    int deleteByGoodsId(@Param(value = "goodsId") Integer goodsId);
}