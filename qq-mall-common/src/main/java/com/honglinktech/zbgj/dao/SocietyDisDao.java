/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.bean.SocietyDisBean;
import com.honglinktech.zbgj.entity.SocietyDis;

import java.util.List;
import java.util.Map;

public interface SocietyDisDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_society_dis
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_society_dis
     *
     * @mbggenerated
     */
    int insertSelective(SocietyDis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_society_dis
     *
     * @mbggenerated
     */
    SocietyDis selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_society_dis
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SocietyDis record);

    /***************************************************************************************/
    /**
     *
     * @param socDisId
     * @param like
     * @return
     */
    int updateSocDisLikeNum(Integer socDisId, Boolean like);
    /**
     *
     * @param map
     * @return
     */
    List<SocietyDisBean> findSocietyDis(Map map);
}