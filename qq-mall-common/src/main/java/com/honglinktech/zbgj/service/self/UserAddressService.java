package com.honglinktech.zbgj.service.self;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.TUserAddressDao;
import com.honglinktech.zbgj.entity.TUserAddress;
import com.honglinktech.zbgj.service.TUserAddressService;

@Component
public class UserAddressService extends TUserAddressService{
	
	@Resource
	private TUserAddressDao tuserAddressDao;
	
	/**
	 * 查询地址列表
	 * @param userId
	 * @param index
	 * @param size
	 * @return
	 * @throws BaseException
	 */
	public Response<TUserAddress> findAddressById(Integer userId, Integer id){
		TUserAddress tuserAddress = tuserAddressDao.findById(id);
		if(tuserAddress.getUserId().intValue()!=userId.intValue()){
			return Result.fail(ExceptionEnum.COMMON_USER_ILLEGAL_REQUEST);
		}
		return Result.resultSet(tuserAddress);
	}
	/**
	 * 查询地址列表
	 * @param userId
	 * @param index
	 * @param size
	 * @return
	 * @throws BaseException
	 */
	public Response<List<TUserAddress>> findAddress(Integer userId) throws BaseException{
		
		Map<String,String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(TUserAddress.DBMaping.userId.name(), new String[]{String.valueOf(userId)});
		whereMap.put(TUserAddress.DBMaping.status.name(), new String[]{String.valueOf(1)});
		List<TUserAddress> addressList = tuserAddressDao.findByWhere(whereMap);
		
		return Result.resultSet(addressList);
		
	}
	/**
	 * 修改地址
	 * @param tuserAddress
	 * @return
	 * @throws BaseException
	 */
	public Response<String> updateAddressDefault(TUserAddress tuserAddress) throws BaseException{
		String sql = "update "+TUserAddress.DBMaping.tableName.getDbName()+" set "+TUserAddress.DBMaping.defaultIs.getDbName()+"=0,"+
				TUserAddress.DBMaping.updateTime.getDbName()+"=NOW() where "+TUserAddress.DBMaping.userId.getDbName()+"="+tuserAddress.getUserId();
		System.out.println("updateAddressDefault-sql:"+sql);
		tuserAddressDao.updateExecute(sql);
		tuserAddress.setDefaultIs(1);
		tuserAddressDao.update(tuserAddress);
		return Result.success();
	}
	
}
