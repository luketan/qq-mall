/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.Problem;

public interface ProblemDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_problem
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_problem
     *
     * @mbggenerated
     */
    int insertSelective(Problem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_problem
     *
     * @mbggenerated
     */
    Problem selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_problem
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Problem record);
}