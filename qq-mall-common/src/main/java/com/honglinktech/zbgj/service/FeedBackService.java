package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.FeedBackBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.FeedBack;

import java.util.List;
import java.util.Map;

public interface FeedBackService {

	/**
	 * APP添加意见反馈
	 * @param userId
	 * @param detail
	 * @param imgs
	 * @return
	 * @throws BaseException
	 */
	Response<String> saveFeedPage(Integer userId, String detail, List<String> imgs) throws BaseException;

	/**
	 * APP意见反馈
	 * @param userId
	 * @param index
	 * @param size
	 * @return
	 * @throws BaseException
	 */
	Response<List<FeedBackBean>> findFeedBackPage(Integer userId, Integer start, Integer rows) throws BaseException;

	/**
	 * APP意见反馈
	 * @param userId
	 * @param id
	 * @return
	 */
	Response<FeedBackBean> findFeedBackById(Integer userId, Integer id) throws BaseException;

	/**
	 * console
	 * @param feedBack
	 * @return
	 */
	Response<Integer> updateFeedBack(FeedBack feedBack) throws BaseException;

	/**
	 * console
	 * @param index
	 * @param size
	 * @param url
	 * @param whereMap
	 * @return
	 * @throws BaseException
	 */
	Page<FeedBack> findFeedBackByWhere(Integer index, Integer size, String url, Map whereMap) throws BaseException;

}
