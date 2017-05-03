package com.honglinktech.zbgj.service.self;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.common.SystemArgsCache;
import com.honglinktech.zbgj.dao.TSystemConfigDao;

@Component
public class SystemService{

	@Autowired
	private TSystemConfigDao tsystemConfigDao;
	
	public Response<Map<String,String>> findSystemSet() throws BaseException{

		return Result.resultSet(SystemArgsCache.getMap());
	}
	
	
}
