package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.common.SystemArgsCache;
import com.honglinktech.zbgj.dao.SystemConfigDao;
import com.honglinktech.zbgj.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SystemServiceImpl implements SystemService{

	@Autowired
	private SystemConfigDao systemConfigDao;

	/**
	 *
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<Map<String,String>> findSystemSet() throws BaseException{

		return Result.resultSet(SystemArgsCache.getMap());
	}
	
	
}
