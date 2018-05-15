package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.PicBean;
import com.honglinktech.zbgj.bean.SocietyDisBean;
import com.honglinktech.zbgj.bean.SocietyDisDisBean;
import com.honglinktech.zbgj.bean.SocietyNoteBean;
import com.honglinktech.zbgj.bean.SocietyNoteRewardBean;
import com.honglinktech.zbgj.bean.SocietySubTypeBean;
import com.honglinktech.zbgj.bean.SocietyTypeBean;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.SocietyDisDao;
import com.honglinktech.zbgj.dao.SocietyDisDisDao;
import com.honglinktech.zbgj.dao.SocietyDisLikeDao;
import com.honglinktech.zbgj.dao.SocietyNoteDao;
import com.honglinktech.zbgj.dao.SocietyNoteLikeDao;
import com.honglinktech.zbgj.dao.SocietyNoteRewardDao;
import com.honglinktech.zbgj.dao.SocietySubTypeDao;
import com.honglinktech.zbgj.dao.SocietySubTypeUserDao;
import com.honglinktech.zbgj.dao.SocietyTypeDao;
import com.honglinktech.zbgj.dao.UserAtteDao;
import com.honglinktech.zbgj.entity.SocietyDisLike;
import com.honglinktech.zbgj.entity.SocietyNoteLike;
import com.honglinktech.zbgj.entity.SocietySubTypeUser;
import com.honglinktech.zbgj.entity.SocietySubUserKey;
import com.honglinktech.zbgj.entity.UserAtte;
import com.honglinktech.zbgj.entity.UserAtteKey;
import com.honglinktech.zbgj.service.PicService;
import com.honglinktech.zbgj.service.SocietyService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SocietyServiceImpl implements SocietyService{
	
	@Resource
	private SocietySubTypeUserDao societySubTypeUserDao;
	@Resource
	private SocietySubTypeDao societySubTypeDao;
	@Resource
	private SocietyTypeDao societyTypeDao;
	@Resource
	private SocietyNoteDao societyNoteDao;
	@Resource
	private SocietyDisDao societyDisDao;
	@Resource
	private SocietyDisDisDao societyDisDisDao;
	@Resource
	private UserAtteDao userAtteDao;
	@Resource
	private PicService picService;
	@Resource
	private SocietyNoteRewardDao societyNoteRewardDao;
	@Resource
	private SocietyNoteLikeDao societyNoteLikeDao;
	@Resource
	private SocietyDisLikeDao societyDisLikeDao;

	/**
	 * 获取用户关注的主题
	 * @param id
	 * @return
	 */
	@Override
	public Response<SocietySubTypeBean> findSocSubBeanById(Integer id){
		
		SocietySubTypeBean socSubBean = societySubTypeDao.findBeanById(id);
		return Result.resultSet(socSubBean);
	}
	
	/**
	 * 获取用户关注的主题
	 * @param userId
	 * @return
	 */
	@Override
	public Response<List<SocietySubTypeBean>> findUserSocSubBean(Integer userId){
		
		List<SocietySubTypeBean> societySubTypeBeen = societySubTypeDao.findUserSocietySubBean(userId);
		return Result.resultSet(societySubTypeBeen);
	}
	/**
	 * 获取推荐主题
	 * @param userId
	 * @return
	 */
	@Override
	public Response<List<SocietySubTypeBean>> findRecSocSubBean(Integer userId){
		
		List<SocietySubTypeBean> societySubTypeBeen = societySubTypeDao.findRecSocietySubBean(userId);
		
		if(societySubTypeBeen != null){
			Collections.shuffle(societySubTypeBeen);
			societySubTypeBeen = societySubTypeBeen.subList(0, societySubTypeBeen.size()>=5?5: societySubTypeBeen.size());
		}
		
		return Result.resultSet(societySubTypeBeen);
	}

	/**
	 * 关注主题、取消关注
	 * @param userId
	 * @param type 0关注，1取消关注
	 * @return
	 * @throws BaseException 
	 */
	@Override
	public Response<String> atteSocSub(Integer userId, Integer atteSocSubId, Integer type) throws BaseException {
		SocietySubTypeUser ssu = new SocietySubTypeUser();
		ssu.setUserId(userId);
		ssu.setSocietySubId(atteSocSubId);
		if(type!=null && type == 0){
			societySubTypeUserDao.insertSelective(ssu);
			return Result.success("关注主题成功！");
		}else if(type!=null && type == 1){
			SocietySubUserKey ssk = new SocietySubUserKey();
			ssk.setUserId(userId);
			ssk.setSocietySubId(atteSocSubId);
			societySubTypeUserDao.deleteByPrimaryKey(ssu);
			return Result.success("取消主题关注成功！");
		}
		
		return Result.fail("操作失败！");
	}
	/**
	 * 关注用户、取消用户
	 * @param userId
	 * @param atteUserId
	 * @param type 0关注，1取消关注
	 * @return
	 * @throws BaseException 
	 */
	@Override
	public Response<String> atteUser(Integer userId, Integer atteUserId, Integer type) throws BaseException {
		
		UserAtte userAtte = new UserAtte();
		userAtte.setUserId(userId);
		userAtte.setAtteUserId(atteUserId);
		
		if(type!=null && type == 0){
			userAtteDao.insertSelective(userAtte);
			return Result.success("关注用户成功！");
		}else if(type!=null && type == 1){
			UserAtteKey uak = new UserAtteKey();
			uak.setUserId(userId);
			uak.setAtteUserId(atteUserId);
			userAtteDao.deleteByPrimaryKey(uak);
			return Result.success("取消用户关注成功！");
		}
		
		return Result.fail("操作失败！");
	}
	/**
	 * 获取所有的社区主题类型
	 * @param userId
	 * @return
	 */
	@Override
	public Response<List<SocietyTypeBean>> findAllSocTypes(Integer userId) {
		List<SocietyTypeBean> societyTypes = societyTypeDao.findBeanByWhere(null);
		if(societyTypes != null){
			for(SocietyTypeBean stb:societyTypes){
				List<SocietySubTypeBean> societySubTypeBeen = societySubTypeDao.findSocSubBySocTypeId(stb.getId() ,userId);
				stb.setSocietySubTypeBeanList(societySubTypeBeen);
			}
		}
		return Result.resultSet(societyTypes);
	}

	/**
	 * 获取帖子,获取所有贴，获取关注用户帖子，获取好友帖子，获取附近人帖子，获取主题帖子
	 * @param userId
	 * @param whereMap
	 * @return
	 */
	@Override
	public Response<List<SocietyNoteBean>> findSocNotes(Integer userId, Integer index, Integer size, Map whereMap) {

		if(whereMap == null){
			whereMap = new HashMap();
		}
		whereMap.put("start", index!=null && index > 0 ? (index-1)*size: 0);
		whereMap.put("start", size!=null && size > 0 ? size: 10);
		whereMap.put("userId", userId);
		
		List<SocietyNoteBean> societyNoteBeans = societyNoteDao.findSocietyNotes(whereMap);
		if(societyNoteBeans != null){
			for(SocietyNoteBean snb:societyNoteBeans){
				System.out.println(snb.getImgIs());
				if(snb.getImgIs()==1){
					List<PicBean> picBeans =  picService.findPic(snb.getId(), Constants.PIC_SOCIETY);
					snb.setPicBeans(picBeans);
				}
			}
		}
		return Result.resultSet(societyNoteBeans);
	}
	/**
	 * 查询帖子详情通过帖子Id
	 * @param userId
	 * @param id
	 * @return
	 */
	@Override
	public Response<SocietyNoteBean> findSocNoteById(Integer userId, Integer id, Boolean socSubInfo) {
		SocietyNoteBean societyNoteBean = societyNoteDao.findSocietyNoteById(userId, id, socSubInfo);
		if(societyNoteBean != null){
			System.out.println(societyNoteBean.getImgIs());
			if(societyNoteBean.getImgIs()==1){
				List<PicBean> picBeans =  picService.findPic(societyNoteBean.getId(), Constants.PIC_SOCIETY);
				societyNoteBean.setPicBeans(picBeans);
			}
			if(societyNoteBean.getRewardIs() == 1){
				Map whereMap = new HashMap();
				whereMap.put("socNoteId", id);
				whereMap.put("start", 0);
				whereMap.put("rows", 9);
				List<SocietyNoteRewardBean> socNoteRewardBeans = societyNoteRewardDao.findSocietyNoteRewardByWhere(whereMap);
				societyNoteBean.setSocNoteRewardBeans(socNoteRewardBeans);
				int socNoteRewardCount = societyNoteRewardDao.findSocietyNoteRewardCount(id);
				societyNoteBean.setSocNoteRewardCount(socNoteRewardCount);
			}
			return Result.resultSet(societyNoteBean);
		}else{
			return Result.fail("没有查到数据，或者帖子被和谐了！");
		}
		
	}
	/**
	 * 帖子点赞
	 * @param userId
	 * @param socNoteId
	 * @param like
	 * @return
	 * @throws BaseException 
	 */
	@Override
	public Response<Boolean> updateSocNotelike(int userId, int socNoteId, boolean like) throws BaseException {
		SocietyNoteLike societyNoteLike = new SocietyNoteLike();
		societyNoteLike.setUserId(userId);
		societyNoteLike.setId(socNoteId);
		int count = 0;
		try{
			if(like){
				count = societyNoteLikeDao.insertSelective(societyNoteLike);
			}else{
				count = societyNoteLikeDao.deleteByPrimaryKey(societyNoteLike);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		societyNoteDao.updateSocNoteLikeNum(socNoteId, like);
		return Result.resultSet(count > 0);
	}
	/**
	 * 评论点赞
	 * @param userId
	 * @param socDisId
	 * @param like
	 * @return
	 * @throws BaseException 
	 */
	@Override
	public Response<Boolean> updateSocDislike(int userId, int socDisId, boolean like){

		SocietyDisLike societyDisLike = new SocietyDisLike();
		societyDisLike.setId(socDisId);
		societyDisLike.setUserId(userId);
		int count = 0;
		try{
			if(like){
				count = societyDisLikeDao.insertSelective(societyDisLike);
			}else{
				count = societyDisLikeDao.deleteByPrimaryKey(societyDisLike);
			}
			societyDisDao.updateSocDisLikeNum(socDisId, like);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		return Result.resultSet(count > 0);
	}
	/**
	 * 打赏
	 * @param userId
	 * @param recUserId
	 * @param value
	 * @param socNoteId
	 * @return
	 */
	@Override
	public Response<Boolean> socNotePlayingReward(int userId, int recUserId,int value, int socNoteId) {
		//select stock from good where id=1 for update;
		//update good set stock=stock-1 where id=1
		return null;
	}
	/**
	 * 获取打赏列表
	 * @param userId
	 * @param socNoteId
	 * @param index
	 * @param size
	 * @return
	 */
	@Override
	public Response<List<SocietyNoteRewardBean>> findSocietyNoteRewards(Integer userId, Integer socNoteId, int index, int size) {

		Map whereMap = new HashMap();
		whereMap.put("start", index > 0 ? (index-1)*size: 0);
		whereMap.put("rows", size > 0 ? size: 10);
		whereMap.put("socNoteId", socNoteId);
		whereMap.put("userId", userId);

		List<SocietyNoteRewardBean> socNoteRewardBeans = societyNoteRewardDao.findSocietyNoteRewardByWhere(whereMap);
		return Result.resultSet(socNoteRewardBeans);
	}
	
	/**
	 * 查询帖子评论通过帖子Id
	 * @param index
	 * @param size
	 * @param whereMap
	 * @return
	 */
	@Override
	public Response<List<SocietyDisBean>> findSocietyDisBySocNoteId(int socNoteId,Integer userId, Integer index, Integer size, Map whereMap) {
		if(whereMap == null){
			whereMap = new HashMap();
		}
		whereMap.put("orderBy","create_time");
		whereMap.put("asc","desc");
		whereMap.put("socNoteId","socNoteId");
		whereMap.put("start", index!=null && index > 0 ? (index-1)*size: 0);
		whereMap.put("start", size!=null && size > 0 ? size: 10);
		List<SocietyDisBean> societyDisBeans =  societyDisDao.findSocietyDis(whereMap);
		if(societyDisBeans!=null){
			for(SocietyDisBean sd:societyDisBeans){
				if(sd.getImgIs() == 1){
					List<PicBean> picBeans =  picService.findPic(sd.getId(), Constants.PIC_SOCIETY_DIC);
					sd.setPicBeans(picBeans);
				}
				if(sd.getReplyIs() == 1){
					List<SocietyDisDisBean> societyDisDisBeans = societyDisDisDao.findSocietyDisDis(sd.getId());
					sd.setSocietyDisDisBeans(societyDisDisBeans);
				}
			}
		}
		return Result.resultSet(societyDisBeans);
	}

}
