/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.UserBasis;

public interface UserBasisDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_basis
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_basis
     *
     * @mbggenerated
     */
    int insertSelective(UserBasis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_basis
     *
     * @mbggenerated
     */
    UserBasis selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_basis
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserBasis record);
}