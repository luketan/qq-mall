package com.honglinktech.zbgj.service.impl;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.UserBean;
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
import com.honglinktech.zbgj.enums.UserStatusEnum;
import com.honglinktech.zbgj.enums.UserTypeEnum;
import com.honglinktech.zbgj.service.ChangeLogService;
import com.honglinktech.zbgj.service.CouponService;
import com.honglinktech.zbgj.service.UserService;
import com.honglinktech.zbgj.utils.HashUtils;
import com.honglinktech.zbgj.utils.HttpUtil;
import com.honglinktech.zbgj.utils.TokenProcessor;
import com.honglinktech.zbgj.vo.UserHomeVO;
import com.honglinktech.zbgj.vo.UserLoginVO;
import com.honglinktech.zbgj.vo.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

@Component
public class UserServiceImpl implements UserService{

	private final Logger logger = LogManager.getLogger(getClass());

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserBasisDao userBasisDao;
	@Autowired
	private UserSessionDao userSessionDao;
	@Autowired
	private ChangeLogService changeLogService;
	@Autowired
	private CouponService couponService;
	/**
	 * appId
	 */
	@Value("${wechat.appletAppId}")
	private String appletAppId;
	/**
	 * AppSecret
	 */
	@Value("${wechat.appletAppSecret}")
	private String appletAppSecret;

	/**
	 *
	 * @param account
	 * @param password
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<UserLoginVO> login(String account, String password) throws BaseException{

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
		UserBasis userBasis =  userBasisDao.findById(user.getId());
		if(userBasis==null){
			return Result.fail(ExceptionEnum.USER_MUCH_ERROR, account, password);
		}

		//登录成功
		Map userSeesionMap = new HashMap();
		UserSession userSession = userSessionDao.findByUserId(user.getId());
		String token = TokenProcessor.getInstance().generateToken(String.valueOf(user.getId()), true);
		if(userSession!=null){//update token
			userSession.setToken(token);
			userSessionDao.update(userSession);
		}else{//add token
			userSession = new UserSession();
			userSession.setToken(token);
			userSession.setUserId(user.getId());
			userSessionDao.insert(userSession);
		}

		return Result.resultSet(new UserLoginVO(token, user.toVO(), userBasis.toVO()));

	}

	/**
	 * 小程序登录
	 * @param code
	 * @return
	 */
	@Override
	public Response<UserLoginVO> updateAppletLoginByCode(String code) {
		try {
			String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appletAppId + "&secret=" + appletAppSecret + "&js_code=" + code + "&grant_type=authorization_code";
			logger.info("url------------"+url);
			String respon = HttpUtil.sendGet(url);
			System.out.println("url------------"+url+"==========="+respon);
			if (StringUtils.isEmpty(respon)) {
				return Result.fail("系统错误，请联系工作人员！");
			}
			Map<String, String> respMap = JSON.parseObject(respon, new HashMap<String, String>().getClass());
			if (respMap.containsKey("errcode")) {
				return Result.fail(respMap.get("errmsg"));
			}
			String openId = respMap.get("openid");
			String sessionKey = respMap.get("session_key");
			String unionId = respMap.get("unionid");

			UserSession userSession = userSessionDao.findByOpenId(openId);

			User user = null;
			UserBasis userBasis = null;
			if (userSession == null) {
				user = new User();
				user.setStatus(UserStatusEnum.Normal.getCode());
				user.setType(UserTypeEnum.General.getCode());
				userDao.insert(user);

				userBasis = new UserBasis();
				userBasis.setId(user.getId());
				userBasisDao.insert(userBasis);

			}else{
				user = userDao.findById(userSession.getUserId());
				userBasis = userBasisDao.findById(userSession.getUserId());
				if (user.getStatus() == 2) {//账户被锁定
					return Result.fail(ExceptionEnum.USER_LOCKED_ERROR, user.getAccount()+",openId:"+openId);
				}
				if (user.getStatus() == 3) {//账户被拉黑
					return Result.fail(ExceptionEnum.USER_BLACK_ERROR, user.getAccount()+",openId:"+openId);
				}
				if (user.getStatus() != 1) {//系统错误
					return Result.fail(ExceptionEnum.COMMON_ERROE, user.getAccount()+",openId:"+openId);
				}
			}

			String token = TokenProcessor.getInstance().generateToken(String.valueOf(user.getId()), true);
			if(userSession!=null){//update token
//				userSession.setToken(token);
				userSession.setOpenId(openId);
				userSession.setSessionKey(sessionKey);
				userSession.setUnionId(unionId);
				userSessionDao.update(userSession);
				token = userSession.getToken();
			}else{//add token
				userSession = new UserSession();
				userSession.setToken(token);
				userSession.setOpenId(openId);
				userSession.setSessionKey(sessionKey);
				userSession.setUnionId(unionId);
				userSession.setUserId(user.getId());
				userSessionDao.insert(userSession);
			}

			return Result.resultSet(new UserLoginVO(token, user.toVO(), userBasis.toVO()));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e, e);
			return Result.fail("系统错误，请联系工作人员！");
		}
	}

	/**
	 *
	 * @param id
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<String> loginout(Integer id) throws BaseException{

		int result = userSessionDao.delete(id);
		return Result.success();
	}

	@Override
	public UserVO getByToken(String token) {
		//TODO redis缓存
		UserSession userSession = userSessionDao.findByToken(token);
		if(userSession == null){
			//return Result.fail(ExceptionEnum.COMMON_TOKEN_FAIL ,"token失效！");
			return null;
		}
		User user = userDao.findById(userSession.getUserId());
		if(user == null){
			return null;
		}
		UserBasis userBasis =  userBasisDao.findById(userSession.getUserId());
		if(userBasis == null){
			return null;
		}
		return user.toVO();
	}

	@Override
	public Response<UserHomeVO> findUserHome(Integer userId) throws BaseException {
		UserHomeVO userHomeVO = userDao.findHomeCount(userId);

		return Result.resultSet(userHomeVO);
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
		List<UserVO> userVOs = new ArrayList<UserVO>();
		if (users != null && users.size() > 0){
			for (User user:users) {
				userVOs.add(user.toVO());
			}
		}
		return Result.resultSet(userVOs);
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
		User user = userDao.findById(id);
		UserBasis userBasis = userBasisDao.findById(id);

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
		result += userDao.update(user);
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

		UserBasis OldUserBasis = userBasisDao.findById(userBasis.getId());

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
		int result = userBasisDao.update(OldUserBasis);
		if (result == 0) {
//			if (userBasis.getNewVersion() >= 5) {
//				throw new Exception("错误次数超过5次了！");
//			}
//			updateUserBasis(userBasis);
//			userBasis.setNewVersion(userBasis.getNewVersion()+1);
			Result.fail("修改失败，请重试！");
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
			userSessionDao.delete(userId);
		}else if(status == 3){ //拉黑
			userSessionDao.delete(userId);
		}
		User user = userDao.findById(userId);
		user.setStatus(status);
		user.setRemark(remark);
		int result = userDao.update(user);

		return Result.resultSet(result);
	}
}
