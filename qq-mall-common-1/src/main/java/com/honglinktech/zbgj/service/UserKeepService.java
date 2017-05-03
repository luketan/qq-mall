package com.honglinktech.zbgj.service.self;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.TGoodsDao;
import com.honglinktech.zbgj.dao.TUserKeepDao;
import com.honglinktech.zbgj.dao.helper.QueryHelper;
import com.honglinktech.zbgj.entity.TGoods;
import com.honglinktech.zbgj.entity.TUserKeep;
import com.honglinktech.zbgj.service.TUserKeepService;

@Component
public class UserKeepService extends TUserKeepService{
	
	@Resource
	private TUserKeepDao tuserKeepDao;
	@Resource
	private TGoodsDao tgoodsDao;
	
	
	public Response<String> updateGoodsKeep(Integer userId, Integer goodsId, Boolean keep) throws BaseException {
		String mag="";
		if(!keep){
			TUserKeep uk = new TUserKeep();
			uk.setObjId(goodsId);
			uk.setType(Constants.USER_KEEP_TYPE_GOODS);
			uk.setUserId(userId);
			tuserKeepDao.delete(uk);
			mag = "取消收藏成功！";
		}else{
			TGoods tgoods = tgoodsDao.findById(goodsId);
			TUserKeep uk = new TUserKeep();
			uk.setObjId(goodsId);
			uk.setType(Constants.USER_KEEP_TYPE_GOODS);
			uk.setUserId(userId);
			uk.setName(tgoods.getName());
			uk.setImgUrl(tgoods.getImgUrl());
			uk.setPrice(tgoods.getPrice());
			tuserKeepDao.save(uk);
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
	public Response<List<TUserKeep>> findKeepPage(Integer userId,Integer type,Integer index,Integer size) throws BaseException{
		
		Map<String,String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(TUserKeep.DBMaping.userId.name(), new String[]{String.valueOf(userId)});
		whereMap.put(TUserKeep.DBMaping.type.name(), new String[]{String.valueOf(type)});
		QueryHelper<TUserKeep> qh = new QueryHelper<TUserKeep>(whereMap);
		qh.setIndex(index);
		qh.setSize(size);
		QueryHelper<TUserKeep> restQH= tuserKeepDao.findByQueryHelper(qh);
		
		return Result.resultSet(restQH.getResultList(), restQH.getTotalRow());
		
	}
	
	
}
