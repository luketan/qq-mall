package com.honglinktech.zbgj.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.honglinktech.zbgj.bean.PicBean;
import com.honglinktech.zbgj.entity.FeedBack;
import com.honglinktech.zbgj.entity.User;
import com.honglinktech.zbgj.entity.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.FeedBackBean;
import com.honglinktech.zbgj.bean.UserBean;
import com.honglinktech.zbgj.bean.UserLoginBean;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.ChangeLogDao;
import com.honglinktech.zbgj.dao.FeedBackDao;
import com.honglinktech.zbgj.dao.PicDao;
import com.honglinktech.zbgj.dao.UserDao;
import com.honglinktech.zbgj.dao.UserSessionDao;
import com.honglinktech.zbgj.entity.ChangeLog;
import com.honglinktech.zbgj.entity.Pic;
import com.honglinktech.zbgj.utils.HashUtils;
import com.honglinktech.zbgj.utils.TokenProcessor;

@Component
public class UserService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserSessionDao userSessionDao;

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
		
		Response<UserBean> rsponse = userDao.login(account,password);
		//登录成功
		if(rsponse.getCode().equals(ExceptionEnum.COMMON_SUCCESS.getRetCode())){
			Map userSeesionMap = new HashMap();
			UserSession userSession = userSessionDao.selectByPrimaryKey(rsponse.getResult().getId());
			String token = TokenProcessor.getInstance().generateToken(String.valueOf(rsponse.getResult().getId()), true);
			if(userSession!=null){//update token
				userSession.setToken(token);
				userSessionDao.updateByPrimaryKeySelective(userSession);
			}else{//add token
				userSession = new UserSession();
				userSession.setToken(token);
				userSession.setUserId(rsponse.getResult().getId());
				userSessionDao.insertSelective(userSession);
			}
			return Result.resultSet(new UserLoginBean(token, rsponse.getResult()));
		}
		return Result.fail(rsponse.getCode(), rsponse.getMsg());
	}
	
	public Response<String> loginout(Integer id) throws BaseException{

		int result = userSessionDao.deleteByPrimaryKey(id);
		return Result.success();
	}

	/**
	 * 获取推荐用户
	 * @return
	 */
	public Response<List<UserBean>> findRecUsers(Integer userId) {
		int rand = (int) (Math.random() * 10);
		List<User> users;
		if (rand % 2 == 0) {
			//获取被关注数最多的用户
			users = userDao.findAtteUserByNum(userId, 0, 50);
		} else {
			//获取被添加好友数最多的用户
			users = userDao.findFriendUserByNum(userId, 0, 50);
		}
		if (users != null) {
			Collections.shuffle(users);
			users = users.subList(0, users.size() >= 5 ? 5 : users.size());
		}
		List<UserBean> userBeens = new ArrayList<UserBean>();
		if (users != null && users.size() > 0){
			for (User user:users) {
				userBeens.add(new UserBean(user));
			}
		}
		return Result.resultSet(userBeens);
	}
}
