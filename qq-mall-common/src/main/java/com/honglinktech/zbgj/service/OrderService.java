package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.OrderBean;
import com.honglinktech.zbgj.bean.OrderSimpleBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Order;
import com.honglinktech.zbgj.entity.PostDetail;

import java.util.List;
import java.util.Map;

public interface OrderService{
	/**
	 * 准备订单
	 * @param userId
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	Response<Map<String, Object>> AppReadyOrder(Integer userId, Map map) throws BaseException ;
	/**
	 * 生成订单
	 * @param userId
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	Response<Map<String, Object>> submitOrder(Integer userId, Map<String, Object> map) throws BaseException ;
	/**
	 * 选择支付方式
	 * @param userId
	 * @param paymentId
	 * @return
	 */
	Response<String> orderCheckedPayment(Integer userId, Integer paymentId) ;

	/**
	 * APP获取订单列表
	 * @param userId
	 * @param index
	 * @param size
	 * @return
	 * @throws BaseException
	 */
	Response<List<OrderBean>> appFindOrderBeanList(Integer userId, Integer index, Integer size) throws BaseException;

	/**
	 * APP获取订单的详情
	 * @param userId
	 * @param id
	 * @return
	 */
	Response<OrderBean> appFindOrderBeanById(Integer userId, Integer id) ;

	/**
	 * APP获取快递信息
	 * @param postCode
	 * @return
	 */
	Response<List<PostDetail>> appFindPostDetail(String postCode) ;

	/**********************************************console**************************/
	/**
	 * console修改订单
	 * @param order
	 * @return
	 */
    Response<Integer> updateOrder(Order order);

	/**
	 * consle查询订单详情
	 * @param id
	 * @return
	 */
	Response<OrderBean> findOrderBeanById(int id);

	/**
	 * console检查新订单
	 * @return
	 */
	int countNewOrder();

	/**
	 * console
	 * @param whereMap
	 * @param url
	 * @return
	 */
	 Page<OrderSimpleBean> findOrderPage(Integer index, Integer size, Map whereMap, String url);

	/**
	 * consle导出订单
	 * @param whereMap
	 * @return
	 */
	byte[] exportOrder(Map whereMap);

}
