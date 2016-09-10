package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TPicDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TPic;

/**
*商品图片业务
**/
@Component
public class TPicService extends BaseService<TPic> {

	protected TPicDao tPicDao;

	
	public TPicDao getTPic() {
		return tPicDao;
	}
	@Resource
	public void setTPic(TPicDao tPicDao) {
		this.tPicDao = tPicDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TPicDao getDao() {
		return tPicDao;
	}
}
