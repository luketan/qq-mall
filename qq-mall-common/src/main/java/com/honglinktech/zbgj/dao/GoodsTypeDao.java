/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.GoodsType;
import com.honglinktech.zbgj.vo.GoodsTypeVO;

import java.util.List;
import java.util.Map;

public interface GoodsTypeDao {

    int deleteById(Integer id);

    int insert(GoodsType record);

    GoodsType findById(Integer id);

    int update(GoodsType record);

    List<GoodsTypeVO> findVOByWhere(Map where);

    /******************************************************************************************************************************************************/
    /**
     * 查询所有商品类别
     * @return
     */
    List<GoodsType> findAll();

    /**
     * console 类别
     * @param whereMap
     * @return
     */
    List<GoodsType> findByWhere(Map whereMap);

    /**
     * console
     * @param whereMap
     * @return
     */
    int findCount(Map whereMap);
}