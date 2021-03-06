package com.honglinktech.zbgj.service.impl;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.GoodsDao;
import com.honglinktech.zbgj.dao.UserKeepDao;
import com.honglinktech.zbgj.entity.Goods;
import com.honglinktech.zbgj.entity.UserKeep;
import com.honglinktech.zbgj.service.UserKeepService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserKeepServiceImpl implements UserKeepService{

	protected final Logger logger = LogManager.getLogger(getClass());
	
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
			Goods goods = goodsDao.findById(goodsId);
			UserKeep uk = new UserKeep();
			uk.setObjId(goodsId);
			uk.setType(Constants.USER_KEEP_TYPE_GOODS);
			uk.setUserId(userId);
			int result = userKeepDao.insert(uk);
			mag = "收藏成功！";
		}
		return Result.success(mag);
	}
	
	/**
	 * 收藏列表
	 * @param userId
	 * @param type
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<List<UserKeep>> findKeepGoodsList(Integer userId, Integer type, Integer start, Integer rows) throws BaseException{

		Map where  = new HashMap();
		where.put("userId", userId);
		where.put("type", type);
		where.put("start", start);
		where.put("rows", rows);
		List<UserKeep> userKeeps= userKeepDao.findGoodsByWhere(where);
		
		return Result.resultSet(userKeeps);
		
	}


	/**
	 * 收藏列表
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<String> delKeepGoods(Integer userId, Integer id) throws BaseException{

		int result= userKeepDao.deleteById(userId, id);
		if(result>0){
			return Result.success();
		}else {
			return Result.fail("删除失败请稍后重试！");
		}


	}


}
