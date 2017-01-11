package com.honglinktech.zbgj.service.self;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.PicBean;
import com.honglinktech.zbgj.bean.SocietyDisBean;
import com.honglinktech.zbgj.bean.SocietyDisDisBean;
import com.honglinktech.zbgj.bean.SocietyNoteBean;
import com.honglinktech.zbgj.bean.SocietySubBean;
import com.honglinktech.zbgj.bean.SocietyTypeBean;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.TSocietySubUserDao;
import com.honglinktech.zbgj.dao.TUserAtteDao;
import com.honglinktech.zbgj.dao.self.SocietyDisDao;
import com.honglinktech.zbgj.dao.self.SocietyDisDisDao;
import com.honglinktech.zbgj.dao.self.SocietyNoteDao;
import com.honglinktech.zbgj.dao.self.SocietySubDao;
import com.honglinktech.zbgj.dao.self.SocietyTypeDao;
import com.honglinktech.zbgj.entity.TSocietySubUser;
import com.honglinktech.zbgj.entity.TUserAtte;

@Component
public class SocietyService{
	
	@Resource
	private TSocietySubUserDao tsocietySubUserDao;
	@Resource
	private SocietySubDao societySubDao;
	@Resource
	private SocietyTypeDao societyTypeDao;
	@Resource
	private SocietyNoteDao societyNoteDao;
	@Resource
	private SocietyDisDao societyDisDao;
	@Resource
	private SocietyDisDisDao societyDisDisDao;
	@Resource
	private TUserAtteDao tuserAtteDao;
	@Resource
	private PicService picService;
	/**
	 * 获取用户关注的主题
	 * @param userId
	 * @return
	 */
	public Response<SocietySubBean> findSocSubBeanById(Integer id){
		
		SocietySubBean socSubBean = societySubDao.findById(id);
		return Result.resultSet(socSubBean);
	}
	
	/**
	 * 获取用户关注的主题
	 * @param userId
	 * @return
	 */
	public Response<List<SocietySubBean>> findUserSocSubBean(Integer userId){
		
		List<SocietySubBean> societySubBeans = societySubDao.findUserSocietySubBean(userId);
		return Result.resultSet(societySubBeans);
	}
	/**
	 * 获取推荐主题
	 * @param userId
	 * @return
	 */
	public Response<List<SocietySubBean>> findRecSocSubBean(Integer userId){
		
		List<SocietySubBean> societySubBeans = societySubDao.findRecSocietySubBean(userId);
		
		if(societySubBeans != null){
			Collections.shuffle(societySubBeans);
			societySubBeans = societySubBeans.subList(0, societySubBeans.size()>=5?5:societySubBeans.size());
		}
		
		return Result.resultSet(societySubBeans);
	}

	/**
	 * 关注主题、取消关注
	 * @param userId
	 * @param socId
	 * @param type 0关注，1取消关注
	 * @return
	 * @throws BaseException 
	 */
	public Response<String> atteSocSub(Integer userId, Integer atteSocSubId, Integer type) throws BaseException {
		TSocietySubUser ssu = new TSocietySubUser();
		ssu.setUserId(userId);
		ssu.setSocietySubId(atteSocSubId);
		if(type!=null && type == 0){
			tsocietySubUserDao.save(ssu);
			return Result.success("关注主题成功！");
		}else if(type!=null && type == 1){
			tsocietySubUserDao.delete(ssu);
			return Result.success("取消主题关注成功！");
		}
		
		return Result.fail("操作失败！");
	}
	/**
	 * 关注用户、取消用户
	 * @param userId
	 * @param socId
	 * @param type 0关注，1取消关注
	 * @return
	 * @throws BaseException 
	 */
	public Response<String> atteUser(Integer userId, Integer atteUserId, Integer type) throws BaseException {
		
		TUserAtte userAtte = new TUserAtte();
		userAtte.setUserId(userId);
		userAtte.setAtteUserId(atteUserId);
		
		if(type!=null && type == 0){
			tuserAtteDao.save(userAtte);
			return Result.success("关注用户成功！");
		}else if(type!=null && type == 1){
			tuserAtteDao.delete(userAtte);
			return Result.success("取消用户关注成功！");
		}
		
		return Result.fail("操作失败！");
	}
	/**
	 * 获取所有的社区主题类型
	 * @param userId
	 * @return
	 */
	public Response<List<SocietyTypeBean>> findAllSocTypes(Integer userId) {
		List<SocietyTypeBean> societyTypes = societyTypeDao.findAllSocTypes(userId);
		if(societyTypes != null){
			for(SocietyTypeBean stb:societyTypes){
				List<SocietySubBean> societySubBeans = societySubDao.findSocSubBySocTypeId(stb.getId() ,userId);
				stb.setSocietySubBeanList(societySubBeans);
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
	public Response<List<SocietyNoteBean>> findSocNotes(Integer userId, Integer index, Integer size, Map<String, Object> whereMap) {
		if(index == null || index <= 0){
			index = 1;
		}
		if(size == null || size <= 0){
			size = 10;
		}
		
		List<SocietyNoteBean> societyNoteBeans = societyNoteDao.findSocietyNotes(userId, (index-1)*size, size, whereMap);
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
	public Response<SocietyNoteBean> findSocNoteById(Integer userId, Integer id, Boolean socSubInfo) {
		SocietyNoteBean societyNoteBean = societyNoteDao.findSocietyNoteById(userId, id, socSubInfo);
		if(societyNoteBean != null){
			System.out.println(societyNoteBean.getImgIs());
			if(societyNoteBean.getImgIs()==1){
				List<PicBean> picBeans =  picService.findPic(societyNoteBean.getId(), Constants.PIC_SOCIETY);
				societyNoteBean.setPicBeans(picBeans);
			}
			return Result.resultSet(societyNoteBean);
		}else{
			return Result.fail("没有查到数据，或者帖子被和谐了！");
		}
		
	}
	
	/**
	 * 查询帖子评论通过帖子Id
	 * @param index
	 * @param size
	 * @param whereMap
	 * @return
	 */
	public Response<List<SocietyDisBean>> findSocietyDisBySocNoteId(int socNoteId,Integer userId, int index, int size, Map<String, Object> whereMap, Map<String, Object> orderMap) {
		List<SocietyDisBean> societyDisBeans =  societyDisDao.findSocietyDis(socNoteId, userId, index, size, whereMap, orderMap);
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
