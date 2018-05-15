package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.GoodsDao;
import com.honglinktech.zbgj.dao.UserKeepDao;
import com.honglinktech.zbgj.entity.Goods;
import com.honglinktech.zbgj.entity.UserKeep;
import com.honglinktech.zbgj.service.UserKeepService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserKeepServiceImpl implements UserKeepService{
	
	@Resource
	private UserKeepDao userKeepDao;
	@Resource
	private GoodsDao goodsDao;

	/**
	 *
	 * @param userId
	 * @param goodsId
	 * @param keep
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<String> updateGoodsKeep(Integer userId, Integer goodsId, Boolean keep) throws BaseException {
		String mag="";
		if(!keep){
			UserKeep uk = new UserKeep();
			uk.setObjId(goodsId);
			uk.setType(Constants.USER_KEEP_TYPE_GOODS);
			uk.setUserId(userId);
			userKeepDao.deleteKeep(uk);
			mag = "取消收藏成功！";
		}else{
			Goods goods = goodsDao.selectByPrimaryKey(goodsId);
			UserKeep uk = new UserKeep();
			uk.setObjId(goodsId);
			uk.setType(Constants.USER_KEEP_TYPE_GOODS);
			uk.setUserId(userId);
			uk.setName(goods.getName());
			uk.setImgUrl(goods.getImgUrl());
			uk.setPrice(goods.getPrice());
			userKeepDao.insertSelective(uk);
			mag = "收藏成功！";
		}
		return Result.success(mag);
	}
	
	/**
	 * 收藏列表
	 * @param userId
	 * @param type
	 * @param index
	 * @param size
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<List<UserKeep>> findKeepPage(Integer userId,Integer type,Integer index,Integer size) throws BaseException{

		int start = index!=null?(index-1)*size:0;
		int rows = size!=null?size:10;
		Map where  = new HashMap();
		where.put("userId", userId);
		where.put("type", type);
		where.put("start", start);
		where.put("rows", rows);
		List<UserKeep> userKeeps= userKeepDao.findByWhere(where);
		
		return Result.resultSet(userKeeps);
		
	}
	
	
}
