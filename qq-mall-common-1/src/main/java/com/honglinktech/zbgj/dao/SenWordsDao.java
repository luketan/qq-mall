/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.SenWords;

public interface SenWordsDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sen_words
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sen_words
     *
     * @mbggenerated
     */
    int insertSelective(SenWords record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sen_words
     *
     * @mbggenerated
     */
    SenWords selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sen_words
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SenWords record);
}