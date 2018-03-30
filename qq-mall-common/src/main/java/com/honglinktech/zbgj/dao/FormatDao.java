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
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_format
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_format
     *
     * @mbggenerated
     */
    int insertSelective(Format record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_format
     *
     * @mbggenerated
     */
    Format selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_format
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Format record);

    /***************************************************************************************************/
    /**
     *
     * @param goodsId
     * @return
     */
    List<FormatBean> findFormatByGoodsId(@Param(value = "goodsId")Integer goodsId);
}