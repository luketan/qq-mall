package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TChangeLog4Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TChangeLog4;

/**
*变更变更日志[饭卡、饭票、经验、成长点、声望、道具、联盟]业务
**/
@Component
public class TChangeLog4Service extends BaseService<TChangeLog4> {

	protected TChangeLog4Dao tChangeLog4Dao;

	
	public TChangeLog4Dao getTChangeLog4() {
		return tChangeLog4Dao;
	}
	@Resource
	public void setTChangeLog4(TChangeLog4Dao tChangeLog4Dao) {
		this.tChangeLog4Dao = tChangeLog4Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TChangeLog4Dao getDao() {
		return tChangeLog4Dao;
	}
}
