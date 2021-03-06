/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.bean.OrderBean;
import com.honglinktech.zbgj.bean.OrderSimpleBean;
import com.honglinktech.zbgj.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {

    int deleteById(Integer id);

    int insert(Order record);

    OrderBean findBeanById(Integer id);

    Order findById(Integer id);

    int update(Order record);

    /****************************************************************************************/


    Order findByCode(String orderCode);
    /**
     * app 获取订单列表
     * @param map
     * @return
     */
    List<Order> findOrderByWhere(Map map);

    /**
     * console 获取订单列表
     * @param whereMap
     * @return
     */
    List<OrderSimpleBean> findByWhere(Map whereMap);

    /**
     * console 获取数量
     * @param whereMap
     * @return
     */
    int findCount(Map whereMap);

    /**
     *
     * @param order
     * @return
     */
    int updateOrder(Order order);

}