package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.ChangeLogDao;
import com.honglinktech.zbgj.entity.ChangeLog;
import com.honglinktech.zbgj.service.ChangeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ChangeLogServiceImpl implements ChangeLogService {
	@Resource
	private ChangeLogDao changeLogDao;

	/**
	 * 日志
	 * @param userId
	 * @param type
	 * @param index
	 * @param size
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<List<ChangeLog>> findChangeLog(Integer userId, Integer type, Integer index, Integer size) throws BaseException {
		int start = index != null ? (index-1)*size : 0;
		int rows = size != null? size : 0;
		Map whereMap = new HashMap();
		whereMap.put("userId", userId);
		whereMap.put("type", type);
		whereMap.put("start",start);
		whereMap.put("rows", rows);
		whereMap.put("orderBy", "create_time");
		whereMap.put("asc", "desc");
		List<ChangeLog> changeLogs = changeLogDao.findByWhere(whereMap);

		return Result.resultSet(changeLogs);
	}

	@Override
	public int saveChangeLog(ChangeLog changeLog) {
		int result = changeLogDao.insertSelective(changeLog);
		return result;
	}
}
