package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Response;

import java.util.Map;

public interface SystemService{

	/**
	 *
	 * @return
	 * @throws BaseException
	 */
	Response<Map<String,String>> findSystemSet() throws BaseException;
	
	
}
