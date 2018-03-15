package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.bean.PicBean;

import java.util.List;

public interface PicService{


	/**
	 *
	 * @param objId
	 * @param type
	 * @return
	 */
	List<PicBean> findPic(Integer objId,Integer type);
	
	
	
}
