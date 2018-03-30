package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.common.SystemArgsCache;
import com.honglinktech.zbgj.dao.PostCompanyDao;
import com.honglinktech.zbgj.dao.PostDetailDao;
import com.honglinktech.zbgj.dao.SystemConfigDao;
import com.honglinktech.zbgj.entity.PostCompany;
import com.honglinktech.zbgj.service.PostService;
import com.honglinktech.zbgj.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PostServiceImpl implements PostService{

	@Autowired
	private PostCompanyDao postCompanyDao;
	@Autowired
	private PostDetailDao postDetailDao;


	@Override
	public Page<PostCompany> findPostCompanyByPage(int start, int rows, String url, Map whereMap) {
		if(whereMap == null){
			whereMap = new HashMap();
		}
		whereMap.put("start", start);
		whereMap.put("rows", rows);
		List<PostCompany> postCompanys = postCompanyDao.findPostCompanyByWhere(whereMap);
		int total = postCompanyDao.findPostCompanyCountByWhere(whereMap);
		return new Page<>(start, rows, total, url, postCompanys);
	}

	@Cacheable("getPostCompanyById")
	@Override
	public Response<PostCompany> findPostCompanyById(int id) {
		PostCompany postCompany = postCompanyDao.selectByPrimaryKey(id);
		return Result.resultSet(postCompany);
	}

	@Override
	public Response<Integer> saveOrUpdatePostCompany(PostCompany postCompany) {
		int result = 0;
		if(postCompany.getId() > 0){
			result = postCompanyDao.updateByPrimaryKeySelective(postCompany);
		}else{
			result = postCompanyDao.insertSelective(postCompany);
		}
		return Result.resultSet(result);
	}

	@Override
	public Response<Integer> deletePostCompany(int id) {
		int result = postCompanyDao.deleteByPrimaryKey(id);
		return Result.resultSet(result);
	}

}
