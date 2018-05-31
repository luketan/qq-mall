/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.GoodsTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsTagDao {

    int deleteById(@Param(value = "goodsId") Integer goodsId, @Param(value = "tagId") Integer tagId);

    int insert(GoodsTag record);

    GoodsTag findById(@Param(value = "goodsId") Integer goodsId, @Param(value = "tagId") Integer tagId);

    int update(GoodsTag record);

    int saveBatch(@Param(value = "goodsTags") List<GoodsTag> goodsTags);

    int deleteByGoodsId(int goodsId);
}