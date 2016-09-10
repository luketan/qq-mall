package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TChangeLog3Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TChangeLog3;

/**
*变更变更日志[饭卡、饭票、经验、成长点、声望、道具、联盟]业务
**/
@Component
public class TChangeLog3Service extends BaseService<TChangeLog3> {

	protected TChangeLog3Dao tChangeLog3Dao;

	
	public TChangeLog3Dao getTChangeLog3() {
		return tChangeLog3Dao;
	}
	@Resource
	public void setTChangeLog3(TChangeLog3Dao tChangeLog3Dao) {
		this.tChangeLog3Dao = tChangeLog3Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TChangeLog3Dao getDao() {
		return tChangeLog3Dao;
	}
}
