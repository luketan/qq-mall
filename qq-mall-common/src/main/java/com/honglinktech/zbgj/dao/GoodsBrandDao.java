/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.GoodsBrandBean;
import com.honglinktech.zbgj.entity.GoodsBrand;

import java.util.List;
import java.util.Map;

public interface GoodsBrandDao extends BaseDao<GoodsBrand> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_brand
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_brand
     *
     * @mbggenerated
     */
    int insertSelective(GoodsBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_brand
     *
     * @mbggenerated
     */
    GoodsBrand selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_brand
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(GoodsBrand record);

    /*********************************************************************************/
    /**
     * 获取列表
     * @param whereMap
     * @return
     */
    List<GoodsBrandBean> findByWhere(Map whereMap);

    /**
     * 获取总数
     * @param whereMap
     * @return
     */
    int findCount(Map whereMap);
}