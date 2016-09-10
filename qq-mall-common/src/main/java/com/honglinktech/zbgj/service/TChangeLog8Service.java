package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TChangeLog8Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TChangeLog8;

/**
*变更变更日志[饭卡、饭票、经验、成长点、声望、道具、联盟]业务
**/
@Component
public class TChangeLog8Service extends BaseService<TChangeLog8> {

	protected TChangeLog8Dao tChangeLog8Dao;

	
	public TChangeLog8Dao getTChangeLog8() {
		return tChangeLog8Dao;
	}
	@Resource
	public void setTChangeLog8(TChangeLog8Dao tChangeLog8Dao) {
		this.tChangeLog8Dao = tChangeLog8Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TChangeLog8Dao getDao() {
		return tChangeLog8Dao;
	}
}
