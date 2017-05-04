package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.bean.PicBean;
import com.honglinktech.zbgj.dao.PicDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class PicService{
	@Resource
	private PicDao picDao;
	
	public List<PicBean> findPic(Integer objId,Integer type){
		return picDao.findBeanList(objId,type);
	}
	
	
	
}
