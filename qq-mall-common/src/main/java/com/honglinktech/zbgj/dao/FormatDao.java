/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.bean.FormatBean;
import com.honglinktech.zbgj.entity.Format;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FormatDao {

    int deleteById(Integer id);

    int insert(Format record);

    Format findById(Integer id);

    int update(Format record);

    /***************************************************************************************************/
    /**
     *
     * @param goodsId
     * @return
     */
    List<FormatBean> findFormatByGoodsId(@Param(value = "goodsId") Integer goodsId);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    int delete(Integer id);
}