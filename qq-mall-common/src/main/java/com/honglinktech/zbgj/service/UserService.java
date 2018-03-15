package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.UserBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.User;
import com.honglinktech.zbgj.entity.UserBasis;
import com.honglinktech.zbgj.vo.UserLoginVO;
import com.honglinktech.zbgj.vo.UserVO;

import java.util.List;
import java.util.Map;

public interface UserService{

	/**
	 * app
	 * @param account
	 * @param password
	 * @return
	 * @throws BaseException
	 */
	Response<UserLoginVO> login(String account, String password) throws BaseException;

	/**
	 * app
	 * @param id
	 * @return
	 * @throws BaseException
	 */
	Response<String> loginout(Integer id) throws BaseException;

	/**
	 * APP获取推荐用户
	 * @return
	 */
	Response<List<UserVO>> findRecUsers(Integer userId);
/***********************************************console**************************************************/
	/**
	 * console 分页
	 * @param start
	 * @param size
	 * @param url
	 * @param whereMap
	 * @return
	 */
	Page<User> findPage(int start, int size, String url, Map<String, Object> whereMap);

	/**
	 * console 获取用户详情
	 * @param id
	 * @return
	 */
	Response<UserBean> findUserBeanById(int id);

	/**
	 * 修改基础信息
	 * @param user
	 * @return
	 */
	Response<Integer> updateUser(User user, UserBasis userBasis) throws Exception;

	/**
	 * 修改用户金融信息
	 * @param userBasis
	 * @return
	 */
	Response<Integer> updateUserBasis(UserBasis userBasis) throws Exception;

	/**
	 * 拉黑用户
	 * @param status
	 * @param remark
	 * @return
	 */
	Response<Integer> updateUserStatus(int userId, int status, String remark);

}
