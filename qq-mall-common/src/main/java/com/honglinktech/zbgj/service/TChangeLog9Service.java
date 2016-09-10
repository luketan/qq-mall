package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TChangeLog9Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TChangeLog9;

/**
*变更变更日志[饭卡、饭票、经验、成长点、声望、道具、联盟]业务
**/
@Component
public class TChangeLog9Service extends BaseService<TChangeLog9> {

	protected TChangeLog9Dao tChangeLog9Dao;

	
	public TChangeLog9Dao getTChangeLog9() {
		return tChangeLog9Dao;
	}
	@Resource
	public void setTChangeLog9(TChangeLog9Dao tChangeLog9Dao) {
		this.tChangeLog9Dao = tChangeLog9Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TChangeLog9Dao getDao() {
		return tChangeLog9Dao;
	}
}
