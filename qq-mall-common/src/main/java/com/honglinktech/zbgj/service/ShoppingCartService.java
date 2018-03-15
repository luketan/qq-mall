package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.ShoppingCartBean;
import com.honglinktech.zbgj.bean.request.AddShoppingBean;
import com.honglinktech.zbgj.common.Response;

import java.util.List;
import java.util.Map;

public interface ShoppingCartService{

	/**
	 * App购物车查询(分页可选)
	 * @param whereMap
	 * @return
	 */
	Response<List<ShoppingCartBean>> findShoppingBeansByMap(Map whereMap);

	/**
	 *
	 * @param userId
	 * @param addShoppingBean
	 * @return
	 * @throws BaseException
	 */
	Response<String> addShoppingCart(int userId, AddShoppingBean addShoppingBean) throws BaseException;

	/**
	 * 删除购物车
	 * @param userId
	 * @param id
	 * @return
	 * @throws BaseException
	 */
	Response<String> deleteShoppingCart(Integer userId, Integer id) throws BaseException;

	/**
	 * 修改购物车的数量与选中
	 * @param userId
	 * @param id
	 * @param num
	 * @param checkbox
	 * @param checkAll
	 * @return
	 */
	Response<String> updateShoppingCart(Integer userId, Integer id, Integer num, Integer checkbox, Boolean checkAll);

}
