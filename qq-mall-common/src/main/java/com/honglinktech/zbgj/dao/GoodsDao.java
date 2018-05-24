/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.bean.GoodsBean;
import com.honglinktech.zbgj.entity.Goods;
import com.honglinktech.zbgj.vo.GoodsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodsDao {

    int deleteById(Integer id);

    int insert(Goods record);

    Goods findById(Integer id);

    int update(Goods record);

    /*****************************************************************************************************/
    /**
     * App find by Id
     * @param id
     * @param userId
     * @return
     */
    GoodsVO findVOById(@Param(value = "id") int id, @Param(value = "userId") int userId);

    /**
     *
     * @param map
     * @return
     */
    List<GoodsVO> findGoodsByWhere(Map map);

    /**
     * console.获取商品分页
     * @param whereMap
     * @return
     */
    List<GoodsBean> findGoodsPage(Map whereMap);
    /**
     * console.获取商品总数
     * @param whereMap
     * @return
     */
    long findGoodsCount(Map whereMap);
}