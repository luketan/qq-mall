package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.bean.PicBean;
import com.honglinktech.zbgj.dao.PicDao;
import com.honglinktech.zbgj.service.PicService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class PicServiceImpl implements PicService{
	@Resource
	private PicDao picDao;

	/**
	 *
	 * @param objId
	 * @param type
	 * @return
	 */
	@Override
	public List<PicBean> findPic(Integer objId,Integer type){
		return picDao.findBeanList(objId,type);
	}
	
	
	
}
