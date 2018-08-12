package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.PostCompanyDao;
import com.honglinktech.zbgj.dao.PostDetailDao;
import com.honglinktech.zbgj.entity.PostCompany;
import com.honglinktech.zbgj.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public Response<PostCompany> findPostCompanyById(int id) {
		PostCompany postCompany = postCompanyDao.findById(id);
		return Result.resultSet(postCompany);
	}

	@Override
	public List<PostCompany> findAllPostCompany() {
		List<PostCompany> postCompanyList = postCompanyDao.findPostCompanyByWhere(null);
		return postCompanyList;
	}

	@Override
	public Response<Integer> saveOrUpdatePostCompany(PostCompany postCompany) {
		int result = 0;
		if(postCompany.getId() > 0){
			result = postCompanyDao.update(postCompany);
		}else{
			result = postCompanyDao.insert(postCompany);
		}
		return Result.resultSet(result);
	}

	@Override
	public Response<Integer> deletePostCompany(int id) {
		int result = postCompanyDao.delete(id);
		return Result.resultSet(result);
	}

}
