package com.honglinktech.zbgj.service.impl;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.UserBean;
import com.honglinktech.zbgj.bean.UserLoginBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.UserBasisDao;
import com.honglinktech.zbgj.dao.UserDao;
import com.honglinktech.zbgj.dao.UserSessionDao;
import com.honglinktech.zbgj.entity.ChangeLog;
import com.honglinktech.zbgj.entity.User;
import com.honglinktech.zbgj.entity.UserBasis;
import com.honglinktech.zbgj.entity.UserSession;
import com.honglinktech.zbgj.enums.ChangeLogTypeEnum;
import com.honglinktech.zbgj.enums.ChangeTypeEnum;
import com.honglinktech.zbgj.service.ChangeLogService;
import com.honglinktech.zbgj.service.UserService;
import com.honglinktech.zbgj.utils.HashUtils;
import com.honglinktech.zbgj.utils.TokenProcessor;
import com.honglinktech.zbgj.vo.UserLoginVO;
import com.honglinktech.zbgj.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserBasisDao userBasisDao;
	@Autowired
	private UserSessionDao userSessionDao;
	@Autowired
	private ChangeLogService changeLogService;

	/**
	 *
	 * @param account
	 * @param password
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<UserLoginVO> login(String account, String password) throws BaseException{

		if(StringUtils.isEmpty(account)){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR, "account", account);
		}
		if(StringUtils.isEmpty(password)){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR, "password", password);
		}
		try {
			password = HashUtils.md5(password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(ExceptionEnum.COMMON_ERROE);
		}

		User user = userDao.login(account,password);

		if (user.getStatus() == 2) {//账户被锁定
			return Result.fail(ExceptionEnum.USER_LOCKED_ERROR, account);
		}
		if (user.getStatus() == 3) {//账户被拉黑
			return Result.fail(ExceptionEnum.USER_BLACK_ERROR, account);
		}
		if (user.getStatus() != 1) {//系统错误
			return Result.fail(ExceptionEnum.COMMON_ERROE, account);
		}
		if(user == null){
			return Result.fail(ExceptionEnum.USER_PASSWORD_ERROR);
		}
		UserBasis userBasis =  userBasisDao.selectByPrimaryKey(user.getId());
		if(userBasis==null){
			return Result.fail(ExceptionEnum.USER_MUCH_ERROR, account, password);
		}

		//登录成功
		Map userSeesionMap = new HashMap();
		UserSession userSession = userSessionDao.selectByPrimaryKey(user.getId());
		String token = TokenProcessor.getInstance().generateToken(String.valueOf(user.getId()), true);
		if(userSession!=null){//update token
			userSession.setToken(token);
			userSessionDao.updateByPrimaryKeySelective(userSession);
		}else{//add token
			userSession = new UserSession();
			userSession.setToken(token);
			userSession.setUserId(user.getId());
			userSessionDao.insertSelective(userSession);
		}

		return Result.resultSet(new UserLoginVO(token, user, userBasis));

	}

	/**
	 *
	 * @param id
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<String> loginout(Integer id) throws BaseException{

		int result = userSessionDao.deleteByPrimaryKey(id);
		return Result.success();
	}

	/**
	 * 获取推荐用户
	 * @return
	 */
	@Override
	public Response<List<UserVO>> findRecUsers(Integer userId) {
		int rand = (int) (Math.random() * 10);
		List<User> users;
		if (rand % 2 == 0) {
			//获取被关注数最多的用户
			users = userDao.findAtteUserByNum(userId, 0, 50);
		} else {
			//获取被添加好友数最多的用户
			users = userDao.findFriendUserByNum(userId, 0, 50);
		}
		if (users != null && users.size() > 0) {
			Collections.shuffle(users);
			users = users.subList(0, users.size() >= 5 ? 5 : users.size());
		}
		List<UserVO> userBeens = new ArrayList<UserVO>();
		if (users != null && users.size() > 0){
			for (User user:users) {
				userBeens.add(new UserVO(user));
			}
		}
		return Result.resultSet(userBeens);
	}

	@Override
	public UserVO getByToken(String token) {
		//TODO redis缓存
//		userSessionDao.selectByPrimaryKey()
		return null;
	}

	/***********************conosle**************************/
	/**
	 * console 分页
	 * @param start
	 * @param size
	 * @param url
	 * @param whereMap
	 * @return
	 */
	@Override
	public Page<User> findPage(int start, int size, String url, Map<String, Object> whereMap){
		List<User> users = userDao.findList(whereMap);
		long total = userDao.findCount(whereMap);

		return new Page<User>(start, size, total, url, users);
	}

	/**
	 * console 获取用户信息
	 * @param id
	 * @return
	 */
	@Override
	public Response<UserBean> findUserBeanById(int id) {
		User user = userDao.selectByPrimaryKey(id);
		UserBasis userBasis = userBasisDao.selectByPrimaryKey(id);

		UserBean userBean = new UserBean(user, userBasis);
		return Result.resultSet(userBean);
	}

	/**
	 * 后台修改用户信息
	 * @param user
	 * @param userBasis
	 * @return
	 */
	@Override
	public Response<Integer> updateUser(User user, UserBasis userBasis) throws Exception {

		int result = 0;
		result += userDao.updateByPrimaryKeySelective(user);
		updateUserBasis(userBasis);
		return Result.resultSet(result);
	}

	/**
	 * console 修改用户金融信息
	 * @param userBasis
	 * @return
	 */
	@Override
	public Response<Integer> updateUserBasis(UserBasis userBasis) throws Exception {
		if (userBasis == null || userBasis.getId() == null || userBasis.getId() <= 0) {
			return Result.fail("系统错误,请联系工作人员！");
		}

		UserBasis OldUserBasis = userBasisDao.selectByPrimaryKey(userBasis.getId());

		ChangeLog changeLog = new ChangeLog();
		changeLog.setUserId(userBasis.getId());
		changeLog.setObjectId(0);
		changeLog.setBeforeNum(OldUserBasis.getMoney());
		changeLog.setCurrNum(userBasis.getMoney());
		changeLog.setType(ChangeTypeEnum.Money.getCode());
		changeLog.setLogType(ChangeLogTypeEnum.Console.getCode());
		changeLog.setNum(userBasis.getMoney().subtract(OldUserBasis.getMoney()));
		changeLog.setComments(ChangeLogTypeEnum.Console.getContent() + "；" + JSON.toJSONString(userBasis));
		changeLogService.saveChangeLog(changeLog);

		OldUserBasis.setVirtualMoney(userBasis.getVirtualMoney());
		OldUserBasis.setMoney(userBasis.getMoney());
		OldUserBasis.setExp(userBasis.getExp());
		OldUserBasis.setLevel(userBasis.getLevel());
		OldUserBasis.setPoint(userBasis.getPoint());
		OldUserBasis.setNewVersion(OldUserBasis.getVersion()+1);
		int result = userBasisDao.updateByPrimaryKeySelective(OldUserBasis);
		if (result == 0) {
			if (userBasis.getNewVersion() >= 5) {
				throw new Exception("错误次数超过5次了！");
			}
			updateUserBasis(userBasis);
			userBasis.setNewVersion(userBasis.getNewVersion()+1);
		}

		return Result.success();
	}

	/**
	 * 修改用户状态，锁定，拉黑
	 * @param status
	 * @param remark
	 * @return
	 */
	@Override
	public Response<Integer> updateUserStatus(int userId, int status, String remark) {
		if (userId <= 0 || status <= 0) {
			return Result.fail("系统错误,请联系工作人员！");
		}

		if(status == 1){ //正常

		}else if(status == 2){ //锁定
			userSessionDao.deleteByPrimaryKey(userId);
		}else if(status == 3){ //拉黑
			userSessionDao.deleteByPrimaryKey(userId);
		}
		User user = userDao.selectByPrimaryKey(userId);
		user.setStatus(status);
		user.setRemark(remark);
		int result = userDao.updateByPrimaryKeySelective(user);

		return Result.resultSet(result);
	}
}
