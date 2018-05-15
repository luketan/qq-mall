package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.GoodsType;
import com.honglinktech.zbgj.entity.GoodsTypeSub;
import com.honglinktech.zbgj.entity.SocietySubType;
import com.honglinktech.zbgj.entity.SocietyType;

import java.util.List;
import java.util.Map;

public interface SocietyTypeService {
	/**
	 *
	 * @param id
	 * @return
	 */
	Response<SocietyType> findById(int id);

	/**
	 * console
	 * @return
	 */
	Response<List<SocietyType>> findAll();

	/**
	 * console
	 * @param societyType
	 * @return
	 */
	Response<SocietyType> saveOrUpdate(SocietyType societyType);

	/**
	 * console
	 * @param index
	 * @param size
	 * @param s
	 * @param whereMap
	 * @return
	 */
	Page<SocietyType> findPageByWhere(int start, int rows, String s, Map whereMap);

	/**
	 * console 子类
	 * @param id
	 * @return
	 */
	Response<SocietySubType> findSubById(Integer id);

	/**
	 * console 子类
	 * @param societySubType
	 * @return
	 */
	Response<SocietySubType> saveOrUpdateSub(SocietySubType societySubType);

	/**
	 * console 子类
	 * @param index
	 * @param size
	 * @param url
	 * @param whereMap
	 * @return
	 */
	Page<SocietySubType> findSubPageByWhere(int index, int size, String url, Map whereMap);
}
