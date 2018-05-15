package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.SocietySubTypeDao;
import com.honglinktech.zbgj.dao.SocietyTypeDao;
import com.honglinktech.zbgj.entity.GoodsType;
import com.honglinktech.zbgj.entity.GoodsTypeSub;
import com.honglinktech.zbgj.entity.SocietySubType;
import com.honglinktech.zbgj.entity.SocietyType;
import com.honglinktech.zbgj.service.GoodsTypeService;
import com.honglinktech.zbgj.service.SocietyTypeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SocietyTypeServiceImpl implements SocietyTypeService{

	protected final Logger logger = LogManager.getLogger(getClass());
	@Resource
	private SocietyTypeDao societyTypeDao;
	@Resource
	private SocietySubTypeDao societySubTypeDao;

	@Override
	public Response<SocietyType> findById(int id) {

		SocietyType societyType = societyTypeDao.selectByPrimaryKey(id);
		return Result.resultSet(societyType);
	}

	@Override
	public Response<List<SocietyType>> findAll() {
		List<SocietyType> societyTypes = societyTypeDao.findByWhere(null);
		return Result.resultSet(societyTypes);
	}

	@Override
	public Response<SocietyType> saveOrUpdate(SocietyType societyType) {
		if(societyType.getId() > 0){
			societyTypeDao.updateByPrimaryKeySelective(societyType);
		}else{
			societyTypeDao.insertSelective(societyType);
		}
		return Result.resultSet(societyType);
	}

	@Override
	public Page<SocietyType> findPageByWhere(int start, int rows, String url, Map whereMap) {
		if(whereMap == null){
			whereMap = new HashMap();
		}
		whereMap.put("start", start);
		whereMap.put("rows", rows);
		whereMap.put("start", 0);
		List societyTypes = societyTypeDao.findByWhere(whereMap);
		int total = societyTypeDao.findCountByWhere(whereMap);
		return new Page<>(start, rows, total, url, societyTypes);
	}

	@Override
	public Response<SocietySubType> findSubById(Integer id) {
		SocietySubType societySubType = societySubTypeDao.selectByPrimaryKey(id);
		return Result.resultSet(societySubType);
	}

	@Override
	public Response<SocietySubType> saveOrUpdateSub(SocietySubType societySubType) {
		if(societySubType.getId() > 0){
			societySubTypeDao.updateByPrimaryKeySelective(societySubType);
		}else{
			societySubTypeDao.insertSelective(societySubType);
		}
		return Result.resultSet(societySubType);
	}

	@Override
	public Page<SocietySubType> findSubPageByWhere(int start, int rows, String url, Map whereMap) {
		if(whereMap == null){
			whereMap = new HashMap();
		}
		whereMap.put("start", start);
		whereMap.put("rows", rows);
		whereMap.put("start", 0);

		List<SocietySubType> societySubTypes = societySubTypeDao.findByWhere(whereMap);
		int total = societySubTypeDao.findCountByWhere(whereMap);
		return new Page<SocietySubType>(start, rows, total, url, societySubTypes);
	}
}
