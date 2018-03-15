package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.SocietyDisBean;
import com.honglinktech.zbgj.bean.SocietyNoteBean;
import com.honglinktech.zbgj.bean.SocietyNoteRewardBean;
import com.honglinktech.zbgj.bean.SocietySubTypeBean;
import com.honglinktech.zbgj.bean.SocietyTypeBean;
import com.honglinktech.zbgj.common.Response;

import java.util.List;
import java.util.Map;

public interface SocietyService{

	/**
	 * 获取用户关注的主题
	 * @param id
	 * @return
	 */
	Response<SocietySubTypeBean> findSocSubBeanById(Integer id);
	
	/**
	 * 获取用户关注的主题
	 * @param userId
	 * @return
	 */
	Response<List<SocietySubTypeBean>> findUserSocSubBean(Integer userId);
	/**
	 * 获取推荐主题
	 * @param userId
	 * @return
	 */
	Response<List<SocietySubTypeBean>> findRecSocSubBean(Integer userId);

	/**
	 * 关注主题、取消关注
	 * @param userId
	 * @param type 0关注，1取消关注
	 * @return
	 * @throws BaseException 
	 */
	Response<String> atteSocSub(Integer userId, Integer atteSocSubId, Integer type) throws BaseException ;
	/**
	 * 关注用户、取消用户
	 * @param userId
	 * @param atteUserId
	 * @param type 0关注，1取消关注
	 * @return
	 * @throws BaseException 
	 */
	Response<String> atteUser(Integer userId, Integer atteUserId, Integer type) throws BaseException ;
	/**
	 * 获取所有的社区主题类型
	 * @param userId
	 * @return
	 */
	Response<List<SocietyTypeBean>> findAllSocTypes(Integer userId) ;

	/**
	 * 获取帖子,获取所有贴，获取关注用户帖子，获取好友帖子，获取附近人帖子，获取主题帖子
	 * @param userId
	 * @param whereMap
	 * @return
	 */
	Response<List<SocietyNoteBean>> findSocNotes(Integer userId, Integer index, Integer size, Map whereMap) ;
	/**
	 * 查询帖子详情通过帖子Id
	 * @param userId
	 * @param id
	 * @return
	 */
	Response<SocietyNoteBean> findSocNoteById(Integer userId, Integer id, Boolean socSubInfo) ;
	/**
	 * 帖子点赞
	 * @param userId
	 * @param socNoteId
	 * @param like
	 * @return
	 * @throws BaseException 
	 */
	Response<Boolean> updateSocNotelike(int userId, int socNoteId, boolean like) throws BaseException ;
	/**
	 * 评论点赞
	 * @param userId
	 * @param socDisId
	 * @param like
	 * @return
	 * @throws BaseException 
	 */
	Response<Boolean> updateSocDislike(int userId, int socDisId, boolean like);
	/**
	 * 打赏
	 * @param userId
	 * @param recUserId
	 * @param value
	 * @param socNoteId
	 * @return
	 */
	Response<Boolean> socNotePlayingReward(int userId, int recUserId,int value, int socNoteId) ;
	/**
	 * 获取打赏列表
	 * @param userId
	 * @param socNoteId
	 * @param index
	 * @param size
	 * @return
	 */
	Response<List<SocietyNoteRewardBean>> findSocietyNoteRewards(Integer userId, Integer socNoteId, int index, int size) ;
	
	/**
	 * 查询帖子评论通过帖子Id
	 * @param index
	 * @param size
	 * @param whereMap
	 * @return
	 */
	Response<List<SocietyDisBean>> findSocietyDisBySocNoteId(int socNoteId,Integer userId, Integer index, Integer size, Map whereMap) ;

}
