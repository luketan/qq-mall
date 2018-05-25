package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.bean.GoodsTypeSubBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.GoodsType;
import com.honglinktech.zbgj.entity.GoodsTypeSub;
import com.honglinktech.zbgj.vo.GoodsTypeVO;

import java.util.List;
import java.util.Map;

public interface GoodsTypeService{
	Response<GoodsTypeVO> findGoodsTypeVOById(int id);

	/**
	 *
	 * @param id
	 * @return
	 */
	Response<GoodsTypeBean> findGoodsTypeBeanById(int id);

	/**
	 * app
	 * @return
	 */
    Response<List<GoodsTypeVO>> findGoodsTypeVOAll();

    /**
	 * 不包含子类型
	 * @return
	 */
	Response<List<GoodsTypeBean>> findGoodsTypeAll();

	/**
	 * console 包涵子类型
	 * @return
	 */
	Response<List<GoodsTypeBean>> findAll();

	/**
	 * console
	 * @param goodsType
	 * @return
	 */
	Response<GoodsType> saveOrUpdate(GoodsType goodsType);

	/**
	 * console
	 * @param index
	 * @param size
	 * @param s
	 * @param whereMap
	 * @return
	 */
	Page<GoodsType> findPageByWhere(int index, int size, String s, Map whereMap);

	/**
	 * console 子类
	 * @param id
	 * @return
	 */
	Response<GoodsTypeSub> findSubById(Integer id);

	/**
	 * console 子类
	 * @param goodsTypeSub
	 * @return
	 */
	Response<GoodsTypeSub> saveOrUpdateSub(GoodsTypeSub goodsTypeSub);

	/**
	 * console 子类
	 * @param index
	 * @param size
	 * @param url
	 * @param whereMap
	 * @return
	 */
	Page<GoodsTypeSubBean> findSubPageByWhere(int index, int size, String url, Map whereMap);
}
