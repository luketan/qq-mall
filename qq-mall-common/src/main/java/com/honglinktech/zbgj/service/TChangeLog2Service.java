package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TChangeLog2Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TChangeLog2;

/**
*变更变更日志[饭卡、饭票、经验、成长点、声望、道具、联盟]业务
**/
@Component
public class TChangeLog2Service extends BaseService<TChangeLog2> {

	protected TChangeLog2Dao tChangeLog2Dao;

	
	public TChangeLog2Dao getTChangeLog2() {
		return tChangeLog2Dao;
	}
	@Resource
	public void setTChangeLog2(TChangeLog2Dao tChangeLog2Dao) {
		this.tChangeLog2Dao = tChangeLog2Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TChangeLog2Dao getDao() {
		return tChangeLog2Dao;
	}
}
