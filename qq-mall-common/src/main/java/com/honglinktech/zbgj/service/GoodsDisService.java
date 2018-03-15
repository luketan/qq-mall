package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.GoodsDisBean;
import com.honglinktech.zbgj.bean.GoodsDisCountBean;
import com.honglinktech.zbgj.common.Response;

import java.util.List;
import java.util.Map;

public interface GoodsDisService{
	/**
	 * 获取评论数量
	 * @param goodsId
	 * @return
	 */
	Response<GoodsDisCountBean> findGoodsDisCount(int goodsId);

	/**
	 * 获取评论
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	Response<List<GoodsDisBean>> findGoodsDisByPage(Map<String, String> map) throws BaseException;
	
}
