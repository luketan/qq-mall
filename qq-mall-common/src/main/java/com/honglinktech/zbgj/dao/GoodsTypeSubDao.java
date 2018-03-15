/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.GoodsTypeSubBean;
import com.honglinktech.zbgj.entity.GoodsType;
import com.honglinktech.zbgj.entity.GoodsTypeSub;

import java.util.List;
import java.util.Map;

public interface GoodsTypeSubDao{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_type_sub
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_type_sub
     *
     * @mbggenerated
     */
    int insertSelective(GoodsTypeSub record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_type_sub
     *
     * @mbggenerated
     */
    GoodsTypeSub selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_type_sub
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(GoodsTypeSub record);

    /************************************************************************************************************************************/
    /**
     * 查询商品类型子类型
     * @param map
     * @return
     */
    List<GoodsTypeSubBean> findByWhere(Map map);

    /**
     *
     * @param whereMap
     * @return
     */
    int findCount(Map whereMap);

    /**
     *
     * @return
     */
    List<GoodsTypeSub> findAll();
}