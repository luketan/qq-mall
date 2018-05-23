package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.GoodsBean;
import com.honglinktech.zbgj.bean.request.GoodsItem;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.vo.GoodsVO;

import java.util.List;
import java.util.Map;

public interface GoodsService{

	/**
	 *
	 * @param id
	 * @param userId
	 * @param index
	 * @param size
	 * @return
	 * @throws BaseException
	 */
	Response<GoodsVO> findGoodsVOById(Integer id, int userId, int index, int size) throws BaseException;
	/**
	 *
	 * @param whereMap
	 * @return
	 * @throws BaseException
	 */
	Response<List<GoodsVO>> findGoodsVOByWhere(Map whereMap) throws BaseException;


	/***************************************************************console******************************************************************/
	/**
	 *
	 * @param goodsItem
	 * @throws BaseException
	 */
	void saveGoods(GoodsItem goodsItem) throws BaseException;

	/**
	 *
	 * @param goodsItem
	 * @throws BaseException
	 */
	void updateGoods(GoodsItem goodsItem) throws BaseException;

	/**
	 * 后台分页查询商品
	 * @param whereMap
	 * @return
	 */
	Page<GoodsBean> findGoodsBeanPage(Map whereMap, String url);

	/**
	 *
	 * @param id
	 * @return
     */
	Response<GoodsBean> findGoodsBeanById(Integer id);

	/**
	 * 后台获取商品详情
	 * @param id
	 * @return
	 */
	GoodsVO findGoodsVOById(Integer id);
}
