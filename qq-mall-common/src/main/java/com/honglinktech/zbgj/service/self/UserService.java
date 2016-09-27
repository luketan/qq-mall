package com.honglinktech.zbgj.service.self;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.UserLoginBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.TUserAddressDao;
import com.honglinktech.zbgj.dao.TUserKeepDao;
import com.honglinktech.zbgj.dao.helper.QueryHelper;
import com.honglinktech.zbgj.dao.self.UserDao;
import com.honglinktech.zbgj.dao.self.UserSessionDao;
import com.honglinktech.zbgj.entity.TUser;
import com.honglinktech.zbgj.entity.TUserAddress;
import com.honglinktech.zbgj.entity.TUserKeep;
import com.honglinktech.zbgj.entity.TUserSession;
import com.honglinktech.zbgj.service.TUserService;
import com.honglinktech.zbgj.utils.HashUtils;
import com.honglinktech.zbgj.utils.TokenProcessor;

@Component
public class UserService extends TUserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserSessionDao userSessionDao;
	@Resource
	private TUserKeepDao tuserKeepDao;
	@Resource
	private TUserAddressDao tuserAddressDao;
	

	public Response<UserLoginBean> login(String account, String password) throws BaseException{

		if(StringUtils.isEmpty(account)){
			Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR.getRetCode(), "用户名不能为空！");
		}
		if(StringUtils.isEmpty(password)){
			Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR.getRetCode(), "密码不能为空！");
		}
		try {
			password = HashUtils.md5(password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(ExceptionEnum.COMMON_ERROE);
		}
		
		Response<TUser> rsponse = userDao.login(account,password);
		//登录成功
		if(rsponse.getCode().equals(ExceptionEnum.COMMON_SUCCESS.getRetCode())){
			Map<String,String[]> userSeesionMap = new HashMap<String,String[]>();
			userSeesionMap.put(TUserSession.DBMaping.userId.name(), new String[]{String.valueOf(rsponse.getResult().getId())});
			List<TUserSession> userSessions = userSessionDao.findByWhere(userSeesionMap);
			String token = TokenProcessor.getInstance().generateToken(String.valueOf(rsponse.getResult().getId()), true);
			if(userSessions!=null && userSessions.size()>0){//update token
				TUserSession userSession = userSessions.get(0);
				userSession.setToken(token);
				userSessionDao.update(userSession);
			}else{//add token
				TUserSession userSession = new TUserSession();
				userSession.setToken(token);
				userSession.setUserId(rsponse.getResult().getId());
				userSessionDao.save(userSession);
			}
			
			return Result.resultSet(new UserLoginBean(token, rsponse.getResult()));
		}
		return Result.fail(rsponse.getCode(), rsponse.getMsg());
	}
	
	public Response<String> loginout(Integer id) throws BaseException{

		return userSessionDao.loginout(id);
		
	}
	public Response<String> saveOrUpdateKeep(TUserKeep userKeep) throws BaseException{
		
		if(userKeep.getId() != null && userKeep.getId() > 0){//取消收藏
			tuserKeepDao.deleteById(userKeep.getId());
			return Result.success("取消收藏成功~");
		}else{//添加收藏
			tuserKeepDao.save(userKeep);
			return Result.success("添加收藏成功~");
		}
		
		
	}
	public Response<List<TUserKeep>> findKeepPage(Integer userId,Integer type,Integer index,Integer size) throws BaseException{
		
		Map<String,String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(TUserKeep.DBMaping.userId.name(), new String[]{String.valueOf(userId)});
		whereMap.put(TUserKeep.DBMaping.type.name(), new String[]{String.valueOf(type)});
		QueryHelper<TUserKeep> qh = new QueryHelper<TUserKeep>(whereMap);
		qh.setIndex(index);
		qh.setSize(size);
		QueryHelper<TUserKeep> restQH= tuserKeepDao.findByQueryHelper(qh);
		
		if(restQH.getResultList().size()==0){
			return Result.resultSet("没有查询到数据~", null);
		}
		return Result.resultSet(restQH.getResultList(), restQH.getTotalRow());
		
	}
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
	public Response<List<TUserAddress>> findAddressPage(Integer userId,Integer index,Integer size) throws BaseException{
		
		Map<String,String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(TUserKeep.DBMaping.userId.name(), new String[]{String.valueOf(userId)});
		QueryHelper<TUserAddress> qh = new QueryHelper<TUserAddress>(whereMap);
		qh.setIndex(index);
		qh.setSize(size);
		QueryHelper<TUserAddress> restQH= tuserAddressDao.findByQueryHelper(qh);
		
		if(restQH.getResultList().size()==0){
			return Result.resultSet("没有查询到数据~", null);
		}
		return Result.resultSet(restQH.getResultList(), restQH.getTotalRow());
		
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
