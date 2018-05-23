/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.bean.GoodsBean;
import com.honglinktech.zbgj.entity.Goods;
import com.honglinktech.zbgj.entity.GoodsPhone;
import com.honglinktech.zbgj.vo.GoodsVO;

import java.util.List;
import java.util.Map;

public interface GoodsPhoneDao {

    int deleteById(Integer id);

    int insert(GoodsPhone record);

    GoodsPhone findById(Integer id);

    int update(GoodsPhone record);

}