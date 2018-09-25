/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.bean.PaymentBean;
import com.honglinktech.zbgj.entity.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PaymentDao {

    int deleteById(Integer id);

    int insert(Payment record);

    Payment findById(Integer id);

    int update(Payment record);

    /************************************************************************************/
    /**
     * app获取用户支付信息
     * @param map
     * @return
     */
    List<PaymentBean> findBeanByWhere(Map map);

    /**
     *
     * @return
     */
    Payment findByCode(@Param(value = "code") String code);
}