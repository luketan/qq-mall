package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TChangeLog7Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TChangeLog7;

/**
*变更变更日志[饭卡、饭票、经验、成长点、声望、道具、联盟]业务
**/
@Component
public class TChangeLog7Service extends BaseService<TChangeLog7> {

	protected TChangeLog7Dao tChangeLog7Dao;

	
	public TChangeLog7Dao getTChangeLog7() {
		return tChangeLog7Dao;
	}
	@Resource
	public void setTChangeLog7(TChangeLog7Dao tChangeLog7Dao) {
		this.tChangeLog7Dao = tChangeLog7Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TChangeLog7Dao getDao() {
		return tChangeLog7Dao;
	}
}
