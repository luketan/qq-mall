/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderItemDao {

    int deleteById(Integer id);


    int insert(OrderItem record);


    OrderItem findById(Integer id);

    int update(OrderItem record);

    /************************************************************************************************************/
    /**
     * 批量插入
     * @param orderItems
     * @return
     */
    int saveBatch(@Param(value = "orderItems") List<OrderItem> orderItems);

    /**
     * 查询订单商品
     * @param map
     * @return
     */
    List<OrderItem> findByWhere(Map map);

    /**
     * 查询订单商品
     * @param map
     * @return
     */
    List<OrderItem> findByOrderId(@Param(value = "orderId") int orderId);
}