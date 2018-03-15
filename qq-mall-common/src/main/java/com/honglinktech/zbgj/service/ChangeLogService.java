package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.ChangeLog;

import java.util.List;

public interface ChangeLogService {

	/**
	 * 获取消费记录
	 * @param userId
	 * @param type
	 * @param index
	 * @param size
	 * @return
	 * @throws BaseException
	 */
	Response<List<ChangeLog>> findChangeLog(Integer userId, Integer type, Integer index, Integer size) throws BaseException;

	/**
	 *
	 * @param changeLog
	 * @return
	 */
	int saveChangeLog(ChangeLog changeLog);
	
	
}
