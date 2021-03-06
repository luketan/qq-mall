/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.FeedBack;

import java.util.List;
import java.util.Map;

public interface FeedBackDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_feed_back
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_feed_back
     *
     * @mbggenerated
     */
    int insertSelective(FeedBack record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_feed_back
     *
     * @mbggenerated
     */
    FeedBack selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_feed_back
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(FeedBack record);
    /*********************************************************************************************************************/
    /**
     *  通过条件查询
     * @param whereMap
     * @return
     */
    List<FeedBack> findByWhere(Map whereMap);

    /**
     * console 查询输了
     * @param whereMap
     * @return
     */
    int findCountByWhere(Map whereMap);
}