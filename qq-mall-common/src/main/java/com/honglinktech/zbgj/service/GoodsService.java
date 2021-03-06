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
	 * App获取商品详情，规格，活动
	 * @param id
	 * @return
	 */
	GoodsVO findSimpleGoodsVOById(Integer id) throws Exception;

	/**
	 *
	 * @param id
	 * @param userId
	 * @return
	 * @throws BaseException
	 */
	Response findGoodsVOById(Integer id, Integer userId) throws BaseException;

	/**
	 *
	 * @param whereMap
	 * @return
	 * @throws BaseException
	 */
	List<GoodsVO> findGoodsVOByWhere(Map whereMap) throws BaseException;


	/***************************************************************console******************************************************************/

	Response saveGoods(GoodsBean goodsBean, List<Format> formats, Integer[] goodsTags,  Integer[] goodsActivitys, String[] goodsImgs) throws Exception;

	/**
	 *
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
	 *
	 * @param id
	 * @return
     */
    Response<String> deleteFormat(Integer id);

	/**
	 *
	 * @param id
	 * @return
     */
	Response<String> deleteFormatSub(Integer id);
}
