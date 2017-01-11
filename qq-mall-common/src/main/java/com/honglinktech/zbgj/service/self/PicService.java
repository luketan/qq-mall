package com.honglinktech.zbgj.service.self;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.bean.PicBean;
import com.honglinktech.zbgj.dao.TPicDao;
import com.honglinktech.zbgj.dao.self.PicDao;
import com.honglinktech.zbgj.service.TPicService;

@Component
public class PicService extends TPicService {
	@Resource
	private PicDao picDao;
	@Resource
	private TPicDao tpicDao;
	
	public List<PicBean> findPic(int objId,int type){
		return picDao.findBeanList(objId,type);
	}
	
	
	
}
