/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.GoodsFormat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsFormatDao {

    int deleteById(@Param(value = "goodsId") Integer goodsId, @Param(value = "formatId") Integer formatId);

    int insert(GoodsFormat record);

    GoodsFormat findById(@Param(value = "goodsId") Integer goodsId, @Param(value = "formatId") Integer formatId);

    int update(GoodsFormat record);

    /***************************************************************************/
    /**
     *
     * @param goodsFormats
     * @return
     */
    int saveBatch(List<GoodsFormat> goodsFormats);
    /**
     *
     * @param goodsId
     * @return
     */
    int deleteByGoodsId(@Param(value = "goodsId") Integer goodsId);
}