/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.PaymentUser;

public interface PaymentUserDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_user
     *
     * @mbggenerated
     */
    int insertSelective(PaymentUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_user
     *
     * @mbggenerated
     */
    PaymentUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PaymentUser record);
}