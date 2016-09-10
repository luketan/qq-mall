package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TChangeLog5Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TChangeLog5;

/**
*变更变更日志[饭卡、饭票、经验、成长点、声望、道具、联盟]业务
**/
@Component
public class TChangeLog5Service extends BaseService<TChangeLog5> {

	protected TChangeLog5Dao tChangeLog5Dao;

	
	public TChangeLog5Dao getTChangeLog5() {
		return tChangeLog5Dao;
	}
	@Resource
	public void setTChangeLog5(TChangeLog5Dao tChangeLog5Dao) {
		this.tChangeLog5Dao = tChangeLog5Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TChangeLog5Dao getDao() {
		return tChangeLog5Dao;
	}
}
