/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.UserSessionLog;

public interface UserSessionLogDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_session_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_session_log
     *
     * @mbggenerated
     */
    int insertSelective(UserSessionLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_session_log
     *
     * @mbggenerated
     */
    UserSessionLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_session_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserSessionLog record);
}