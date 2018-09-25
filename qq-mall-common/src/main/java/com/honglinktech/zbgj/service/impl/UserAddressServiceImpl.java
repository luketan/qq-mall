package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.UserAddressDao;
import com.honglinktech.zbgj.entity.UserAddress;
import com.honglinktech.zbgj.service.UserAddressService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserAddressServiceImpl implements UserAddressService{
	/**
	 * userAddressDao
	 */
	@Resource
	private UserAddressDao userAddressDao;

	/**
	 * 查询地址列表
	 * @param userId
	 * @param id
	 * @return
	 */
	@Override
	public Response<UserAddress> findAddressById(Integer userId, Integer id){
		UserAddress userAddress = userAddressDao.findById(id);
		if(userAddress.getUserId().intValue()!=userId.intValue()){
			return Result.fail(ExceptionEnum.COMMON_USER_ILLEGAL_REQUEST);
		}
		return Result.resultSet(userAddress);
	}

	/**
	 * 查询地址列表
	 * @param userId
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<List<UserAddress>> findAddress(Integer userId) throws BaseException{
		
		Map whereMap = new HashMap();
		whereMap.put("userId", userId);
		whereMap.put("status", 1);
		List<UserAddress> addressList = userAddressDao.findByWhere(whereMap);
		
		return Result.resultSet(addressList);
		
	}

	/**
	 * 修改地址默认地址
	 * @param userAddress
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<String> updateAddressDefault(UserAddress userAddress) throws BaseException{
		int count = userAddressDao.update(userAddress);
		if (count > 0){
			return Result.success();
		}else{
			return Result.fail("修改失败");
		}

	}
	
}
