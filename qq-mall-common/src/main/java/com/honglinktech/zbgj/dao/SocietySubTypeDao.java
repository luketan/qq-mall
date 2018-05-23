/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.bean.SocietySubTypeBean;
import com.honglinktech.zbgj.entity.SocietySubType;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SocietySubTypeDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_society_sub
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_society_sub
     *
     * @mbggenerated
     */
    int insertSelective(SocietySubType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_society_sub
     *
     * @mbggenerated
     */
    SocietySubType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_society_sub
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SocietySubType record);

    /**********************************************************************/
    /**
     * APP
     * @param id
     * @return
     */
    SocietySubTypeBean findBeanById(@Param(value = "id") Integer id);

    /**
     *  APP获取用户关注的主题
     * @param userId
     * @return
     */
    List<SocietySubTypeBean> findUserSocietySubBean(@Param(value = "userId") Integer userId);

    /**
     * APP获取用户推荐的主题
     * @param userId
     * @return
     */
    List<SocietySubTypeBean> findRecSocietySubBean(@Param(value = "userId") Integer userId);

    /**
     * APP通过主题类型获取主题（包括是否关注）
     * @param userId
     * @param type
     * @return
     */
    List<SocietySubTypeBean> findSocSubBySocTypeId(@Param(value = "userId") Integer userId, @Param(value = "type") Integer type);

    /**
     * consle
     * @param whereMap
     * @return
     */
    List<SocietySubType> findByWhere(Map whereMap);

    /**
     * conosle
     * @param whereMap
     * @return
     */
    int findCountByWhere(Map whereMap);
}