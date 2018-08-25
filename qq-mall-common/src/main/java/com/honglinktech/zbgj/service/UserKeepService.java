package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.UserKeep;

import java.util.List;

public interface UserKeepService{

	/**
	 *
	 * @param userId
	 * @param goodsId
	 * @param keep
	 * @return
	 * @throws BaseException
	 */
	Response<String> updateGoodsKeep(Integer userId, Integer goodsId, Boolean keep) throws BaseException;
	
	/**
	 * 收藏列表
	 * @param userId
	 * @param type
	 * @param index
	 * @param size
	 * @return
	 * @throws BaseException
	 */
	Response<List<UserKeep>> findKeepPage(Integer userId, Integer type, Integer start, Integer rows) throws BaseException;
	
	
}
