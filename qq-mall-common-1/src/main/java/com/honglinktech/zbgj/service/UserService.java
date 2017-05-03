package com.honglinktech.zbgj.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
import com.honglinktech.zbgj.entity.FeedBackWithBLOBs;
import com.honglinktech.zbgj.entity.Pic;
import com.honglinktech.zbgj.utils.HashUtils;
import com.honglinktech.zbgj.utils.TokenProcessor;

@Component
public class UserService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserSessionDao userSessionDao;
	@Resource
	private ChangeLogDao tchangeLogDao;
	@Resource
	private FeedBackDao tfeedBackDao;
	@Resource
	private PicDao tpicDao;
	

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

	/**
	 * 获取推荐用户
	 * @return
	 */
	public Response<List<UserBean>> findRecUsers(Integer userId){
		int rand = (int)(Math.random()*10);
		List<UserBean> userBeans;
		if(rand%2==0){
			//获取被关注数最多的用户
			userBeans = userDao.findAtteUserByNum(userId,1,50);
		}else{
			//获取被添加好友数最多的用户
			userBeans = userDao.findFriendUserByNum(userId,1,50);
		}
		if(userBeans != null){
			Collections.shuffle(userBeans);
			userBeans = userBeans.subList(0, userBeans.size()>=5?5:userBeans.size());
		}
		return Result.resultSet(userBeans);
	}
	public static void main(String[] args) {
		System.out.println();
	}
	
	/**
	 * 日志
	 * @param valueOf
	 * @param couponId
	 * @return
	 * @throws BaseException 
	 */
	public Response<List<ChangeLog>> findChangeLog(Integer userId, Integer type,Integer index,Integer size) throws BaseException {
		
		Map<String, String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(TChangeLog.DBMaping.userId.name(), new String[]{userId+""});
		whereMap.put(TChangeLog.DBMaping.type.name(), new String[]{type+""});
		QueryHelper<TChangeLog> qh = new QueryHelper<TChangeLog>(index,size,whereMap);
		Map<String, String> orderMap = new HashMap<String, String>();
		orderMap.put(TChangeLog.DBMaping.createTime.getDbName(), "desc");
		qh.setOrderBy(orderMap);
		QueryHelper<TChangeLog> resultQH = tchangeLogDao.findByQueryHelperNoCount(qh);
		return Result.resultSet(resultQH.getResultList());
	}

	/**
	 * 意见反馈
	 * @param valueOf
	 * @param couponId
	 * @return
	 * @throws BaseException 
	 */
	public Response<String> saveFeedPage(Integer userId,String detail,List<String> imgs) throws BaseException {
		FeedBackWithBLOBs feedBack = new FeedBackWithBLOBs();
		feedBack.setDetail(detail);
		feedBack.setUserId(userId);
		feedBack.setReadIs(Constants.N0);
		int id = tfeedBackDao.insertSelective(feedBack);
		if(imgs!=null && imgs.size()>0){
			for(String img:imgs){
				Pic tpic = new Pic();
				tpic.setObjId(id);
				tpic.setPicUrl(img);
				tpic.setType(Constants.PIC_FEED_BACK);
				tpicDao.insertSelective(tpic);
			}
			
		}
		return Result.success("意见反馈提交成功！");
	}
	
	/**
	 * 意见反馈
	 * @param valueOf
	 * @param couponId
	 * @return
	 * @throws BaseException 
	 */
	public Response<List<FeedBackBean>> findFeedBackPage(Integer userId,Integer index,Integer size) throws BaseException {
		
		Map<String, String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(TFeedBack.DBMaping.userId.name(), new String[]{userId+""});
		QueryHelper<TFeedBack> qh = new QueryHelper<TFeedBack>(index,size,whereMap);
		Map<String, String> orderMap = new HashMap<String, String>();
		orderMap.put(TChangeLog.DBMaping.createTime.getDbName(), "desc");
		qh.setOrderBy(orderMap);
		QueryHelper<TFeedBack> resultQH = tfeedBackDao.findByQueryHelperNoCount(qh);
		List<TFeedBack> feedBackList = resultQH.getResultList();
		//图片处理
		List<FeedBackBean> feedBackBeanList = new ArrayList<FeedBackBean>();
		for(TFeedBack fb:feedBackList){
			FeedBackBean fbBean = new FeedBackBean(fb);
			Map<String,String[]> picWhere = new HashMap<String, String[]>();
			picWhere.put(TPic.DBMaping.objId.name(), new String[]{fb.getId()+""});
			picWhere.put(TPic.DBMaping.type.name(), new String[]{Constants.PIC_FEED_BACK+""});
			List<TPic> picList = tpicDao.findByWhere(picWhere);
			fbBean.setPicList(picList);
			feedBackBeanList.add(fbBean);
		}
		
		return Result.resultSet(feedBackBeanList);
	}
	/**
	 * 意见反馈
	 * @param userId
	 * @param id
	 * @return
	 */
	public Response<FeedBackBean> findFeedBackById(Integer userId, Integer id) {
		FeedBackWithBLOBs feedBack = tfeedBackDao.selectByPrimaryKey(id);
		
		if(userId.intValue() != feedBack.getUserId()){
			return Result.fail(ExceptionEnum.COMMON_ERROE);
		}
		
		FeedBackBean fbBean = new FeedBackBean(feedBack);
		Map<String,String[]> picWhere = new HashMap<String, String[]>();
		picWhere.put(TPic.DBMaping.objId.name(), new String[]{feedBack.getId()+""});
		picWhere.put(TPic.DBMaping.type.name(), new String[]{Constants.PIC_FEED_BACK+""});
		List<TPic> picList = tpicDao.findByWhere(picWhere);
		fbBean.setPicList(picList);
		
		return Result.resultSet(fbBean);
	}
	
	
}
