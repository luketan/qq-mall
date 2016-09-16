package com.honglinktech.zbgj.service.self;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.UserLoginBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.TUserCollectDao;
import com.honglinktech.zbgj.dao.TUserSessionDao;
import com.honglinktech.zbgj.dao.helper.QueryHelper;
import com.honglinktech.zbgj.dao.self.UserDao;
import com.honglinktech.zbgj.dao.self.UserSessionDao;
import com.honglinktech.zbgj.entity.TUser;
import com.honglinktech.zbgj.entity.TUserCollect;
import com.honglinktech.zbgj.entity.TUserSession;
import com.honglinktech.zbgj.service.TUserService;
import com.honglinktech.zbgj.utils.HashUtils;
import com.honglinktech.zbgj.utils.TokenProcessor;

@Component
public class UserService extends TUserService {

	@Resource
	private UserDao userDao;
	@Resource
	private UserSessionDao userSessionDao;
	@Resource
	private TUserCollectDao tuserCollectDao;
	

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
			userSeesionMap.put(TUserSessionDao.DBMaping.userId.getDbName(), new String[]{String.valueOf(rsponse.getResult().getId())});
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
	public Response<String> saveOrUpdateCollect(TUserCollect userCollect) throws BaseException{
		
		if(userCollect.getId() != null && userCollect.getId() > 0){//取消收藏
			tuserCollectDao.deleteById(userCollect.getId());
			return Result.success("取消收藏成功~");
		}else{//添加收藏
			tuserCollectDao.save(userCollect);
			return Result.success("添加收藏成功~");
		}
		
		
	}
	public Response<List<TUserCollect>> findCollects(Integer userId,Integer type,Integer index,Integer size) throws BaseException{
		
		Map<String,String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(TUserCollectDao.DBMaping.userId.getDbName(), new String[]{String.valueOf(userId)});
		whereMap.put(TUserCollectDao.DBMaping.type.getDbName(), new String[]{String.valueOf(type)});
		QueryHelper<TUserCollect> qh = new QueryHelper<TUserCollect>(whereMap);
		qh.setIndex(index);
		qh.setSize(size);
		QueryHelper<TUserCollect> restQH= tuserCollectDao.findByQueryHelper(qh);
		
		if(restQH.getResultList().size()==0){
			return Result.resultSet("没有查询到数据~", null);
		}
		return Result.resultSet(restQH.getResultList(), restQH.getTotalRow());
		
	}
}
