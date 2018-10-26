/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.GoodsTypeSubBean;
import com.honglinktech.zbgj.entity.GoodsType;
import com.honglinktech.zbgj.entity.GoodsTypeSub;
import com.honglinktech.zbgj.vo.GoodsTypeSubVO;

import java.util.List;
import java.util.Map;

public interface GoodsTypeSubDao{


    int deleteById(Integer id);


    int insert(GoodsTypeSub record);


    GoodsTypeSub findById(Integer id);

    /**
     *
     * @param record
     * @return
     */
    int update(GoodsTypeSub record);

    /************************************************************************************************************************************/
    /**
     * 查询商品类型子类型
     * @param map
     * @return
     */
    List<GoodsTypeSubVO> findVOByWhere(Map map);
    /**
     * 查询商品类型子类型
     * @param map
     * @return
     */
    List<GoodsTypeSubBean> findBeanByWhere(Map map);

    /**
     * 查询商品类型子类型
     * @param map
     * @return
     */
    List<GoodsTypeSub> findByWhere(Map map);

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