package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.GoodsBean;
import com.honglinktech.zbgj.bean.request.GoodsItem;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Format;
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

	Response saveGoods(GoodsBean goodsBean, List<Format> formats, Integer[] goodsTags,  Integer[] goodsActivitys, String[] goodsImgs) throws Exception;

	/**
	 *
	 * @param goodsItem
	 * @throws BaseException
	 */
	Response updateGoods(GoodsBean goodsBean, List<Format> formats, Integer[] goodsTags,  Integer[] goodsActivitys, String[] goodsImgs) throws Exception;

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

    Response<String> deleteFormat(Integer id);

	Response<String> deleteFormatSub(Integer id);
}
