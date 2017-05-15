/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.bean.PicBean;
import com.honglinktech.zbgj.entity.Pic;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PicDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pic
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pic
     *
     * @mbggenerated
     */
    int insertSelective(Pic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pic
     *
     * @mbggenerated
     */
    Pic selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pic
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Pic record);

    /********************************************************************************************************************************************************************/
    /**
     * 查询
     * @param objId
     * @param type
     * @return
     */
    List<PicBean> findBeanList(@Param(value = "objId")Integer objId, @Param(value = "type") Integer type);
}