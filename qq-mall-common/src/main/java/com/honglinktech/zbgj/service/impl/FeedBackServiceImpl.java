package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.FeedBackBean;
import com.honglinktech.zbgj.bean.PicBean;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.FeedBackDao;
import com.honglinktech.zbgj.dao.PicDao;
import com.honglinktech.zbgj.entity.FeedBack;
import com.honglinktech.zbgj.entity.Pic;
import com.honglinktech.zbgj.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FeedBackServiceImpl implements FeedBackService {
	/**
	 * feedBackDao
	 */
	@Resource
	private FeedBackDao feedBackDao;
	/**
	 * picDao
	 */
	@Resource
	private PicDao picDao;

	/**
	 * APP添加意见反馈
	 * @param userId
	 * @param detail
	 * @param imgs
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<String> saveFeedPage(Integer userId,String detail,List<String> imgs) throws BaseException {
		FeedBack feedBack = new FeedBack();
		feedBack.setDetail(detail);
		feedBack.setUserId(userId);
		feedBack.setReadIs(Constants.N0);
		int id = feedBackDao.insertSelective(feedBack);
		if(imgs!=null && imgs.size()>0){
			for(String img:imgs){
				Pic tpic = new Pic();
				tpic.setObjId(id);
				tpic.setPicUrl(img);
				tpic.setType(Constants.PIC_FEED_BACK);
				picDao.insertSelective(tpic);
			}

		}
		return Result.success("意见反馈提交成功！");
	}

	/**
	 * APP意见反馈
	 * @param userId
	 * @param index
	 * @param size
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<List<FeedBackBean>> findFeedBackPage(Integer userId, Integer index, Integer size) throws BaseException {

		int start = index!=null?(index-1)*size:0;
		int rows = size!=null?size:10;

		Map whereMap = new HashMap();
		whereMap.put("userId", userId);
		whereMap.put("start", start);
		whereMap.put("rows", rows);

		List<FeedBack> feedBackList = feedBackDao.findByWhere(whereMap);
		//图片处理
		List<FeedBackBean> feedBackBeanList = new ArrayList<FeedBackBean>();
		for(FeedBack fb:feedBackList){
			FeedBackBean fbBean = new FeedBackBean(fb);
			List<PicBean> picList = picDao.findBeanList(fb.getId(), Constants.PIC_FEED_BACK);
			fbBean.setPicBeanList(picList);
			feedBackBeanList.add(fbBean);
		}

		return Result.resultSet(feedBackBeanList);
	}
	/**
	 * APP意见反馈
	 * @param userId
	 * @param id
	 * @return
	 */
	@Override
	public Response<FeedBackBean> findFeedBackById(Integer userId, Integer id) {
		FeedBack feedBack = feedBackDao.selectByPrimaryKey(id);

		if(userId != null && userId.intValue() != feedBack.getUserId()){
			return Result.fail(ExceptionEnum.COMMON_ERROE);
		}
		FeedBackBean fbBean = new FeedBackBean(feedBack);

		List<PicBean> picList = picDao.findBeanList(feedBack.getId(), Constants.PIC_FEED_BACK);
		fbBean.setPicBeanList(picList);

		return Result.resultSet(fbBean);
	}

	/**
	 *
	 * @param feedBack
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<Integer> updateFeedBack(FeedBack feedBack) throws BaseException {
		int result = feedBackDao.updateByPrimaryKeySelective(feedBack);
		return Result.resultSet(result);
	}

	/**
	 *
	 * @param index
	 * @param size
	 * @param url
	 * @param whereMap
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Page<FeedBack> findFeedBackByWhere(Integer index, Integer size, String url, Map whereMap) throws BaseException {
		int start = index!=null?(index-1)*size:0;
		int rows = size!=null?size:10;
		if(whereMap == null){
			whereMap = new HashMap();
		}
		whereMap.put("start", start);
		whereMap.put("rows", rows);

		List<FeedBack> feedBackList = feedBackDao.findByWhere(whereMap);
		int total = feedBackDao.findCountByWhere(whereMap);
		return new Page<FeedBack>(start, rows, total, url, feedBackList);
	}
}
