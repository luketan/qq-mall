package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.UserAddress;

import java.util.List;

public interface UserAddressService{

	/**
	 * 查询地址列表
	 * @param userId
	 * @param id
	 * @return
	 */
	Response<UserAddress> findAddressById(Integer userId, Integer id);
	/**
	 * 查询地址列表
	 * @param userId
	 * @return
	 * @throws BaseException
	 */
	Response<List<UserAddress>> findAddress(Integer userId) throws BaseException;
	/**
	 * 修改地址默认地址
	 * @param userAddress
	 * @return
	 * @throws BaseException
	 */
	Response<String> updateAddressDefault(UserAddress userAddress) throws BaseException;
	
}
