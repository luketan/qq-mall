package com.honglinktech.zbgj.service.impl;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.bean.GoodsTypeSubBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.GoodsTypeDao;
import com.honglinktech.zbgj.dao.GoodsTypeSubDao;
import com.honglinktech.zbgj.entity.GoodsType;
import com.honglinktech.zbgj.entity.GoodsTypeSub;
import com.honglinktech.zbgj.service.GoodsTypeService;
import com.honglinktech.zbgj.vo.GoodsTypeSubVO;
import com.honglinktech.zbgj.vo.GoodsTypeVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GoodsTypeServiceImpl implements GoodsTypeService{

	protected final Logger logger = LogManager.getLogger(getClass());
	@Resource
	private GoodsTypeDao goodsTypeDao;
	@Resource
	private GoodsTypeSubDao goodsTypeSubDao;

	/**
	 * app
	 * @return
	 */
	@Override
	public Response<List<GoodsTypeVO>> findGoodsTypeVOAll() {
		List<GoodsType> goodsTypes = goodsTypeDao.findAll();

		List<GoodsTypeVO> goodsTypeVOs = new ArrayList<>();
		if (goodsTypes != null) {
			for (GoodsType goodsType:goodsTypes) {
				goodsTypeVOs.add(goodsType.toVO());
			}
		}
		return Result.resultSet(goodsTypeVOs);
	}

	/**
	 * app
	 * @param id
	 * @return
	 */
	@Override
	public Response<GoodsTypeVO> findGoodsTypeVOById(int id) {

		GoodsType goodsType = goodsTypeDao.findById(id);
		Map whereMap = new HashMap();
		whereMap.put("goodsType", id);
		List<GoodsTypeSubVO> gtsList = goodsTypeSubDao.findVOByWhere(whereMap);
		logger.info(id+"==========findGoodsTypeBeanById=========="+ JSON.toJSONString(goodsType));
		GoodsTypeVO goodsTypeBean = goodsType.toVO();
		goodsTypeBean.setGoodsTypeSubList(gtsList);

		return Result.resultSet(goodsTypeBean);
	}

	@Override
	public Response<GoodsTypeBean> findGoodsTypeBeanById(int id) {

		GoodsType goodsType = goodsTypeDao.findById(id);
		Map whereMap = new HashMap();
		whereMap.put("goodsType", id);
		List<GoodsTypeSubBean> gtsList = goodsTypeSubDao.findByWhere(whereMap);
		logger.info(id+"==========findGoodsTypeBeanById=========="+ JSON.toJSONString(goodsType));
		GoodsTypeBean goodsTypeBean = goodsType.toBean();
		goodsTypeBean.setGoodsTypeSubList(gtsList);
		
		return Result.resultSet(goodsTypeBean);
	}

	@Override
	public Response<List<GoodsTypeBean>> findAll() {
		List<GoodsType> goodsTypes = goodsTypeDao.findAll();

		List<GoodsTypeBean> goodsTypeBeans = new ArrayList<>();

		Map whereMap = new HashMap();
		if (goodsTypes != null) {
			for (GoodsType goodsType:goodsTypes) {
				GoodsTypeBean goodsTypeBean = goodsType.toBean();
				whereMap.put("goodsType", goodsTypeBean.getId());
				List<GoodsTypeSubBean> gtsList = goodsTypeSubDao.findByWhere(whereMap);
				goodsTypeBean.setGoodsTypeSubList(gtsList);
				goodsTypeBeans.add(goodsTypeBean);
			}
		}
		return Result.resultSet(goodsTypeBeans);
	}
//-----------------------------------------
	/**
	 * console
	 * @return
	 */
	@Override
	public Response<List<GoodsTypeBean>> findGoodsTypeAll() {
		List<GoodsType> goodsTypes = goodsTypeDao.findAll();

		List<GoodsTypeBean> goodsTypeBeans = new ArrayList<>();
		if (goodsTypes != null) {
			for (GoodsType goodsType:goodsTypes) {
				goodsTypeBeans.add(goodsType.toBean());
			}
		}
		return Result.resultSet(goodsTypeBeans);
	}

	/**
	 * console
	 * @param goodsType
	 * @return
	 */
	@Override
	public Response<GoodsType> saveOrUpdate(GoodsType goodsType) {
		if(goodsType.getId()!=null && goodsType.getId() > 0){
			goodsTypeDao.update(goodsType);
		}else{
			goodsTypeDao.insert(goodsType);
		}
		return Result.resultSet(goodsType);
	}

	/**
	 * console
	 * @param index
	 * @param size
	 * @param whereMap
	 * @return
	 */
	@Override
	public Page<GoodsType> findPageByWhere(int index, int size, String url, Map whereMap) {
		index = index >= 0 ? index : 0;
		size = size > 0 ?  size : 10;
		int start = (index -1)*size;
		if(whereMap == null) {
		}
		whereMap.put("start", start);
		whereMap.put("rows", size);

		List<GoodsType> gtags = goodsTypeDao.findByWhere(whereMap);
		int count = goodsTypeDao.findCount(whereMap);
		return new Page<>(start, size, count, url, gtags);
	}

	/**
	 * console 子类
	 * @param id
	 * @return
	 */
	@Override
	public Response<GoodsTypeSub> findSubById(Integer id) {
		GoodsTypeSub goodsTypeSub = goodsTypeSubDao.selectByPrimaryKey(id);
		return Result.resultSet(goodsTypeSub);
	}

	/**
	 * console 子类
	 * @return
	 */
	@Override
	public Response<GoodsTypeSub> saveOrUpdateSub(GoodsTypeSub goodsTypeSub) {
		if(goodsTypeSub.getId()!=null && goodsTypeSub.getId() > 0){
			goodsTypeSubDao.updateByPrimaryKeySelective(goodsTypeSub);
		}else{
			goodsTypeSubDao.insertSelective(goodsTypeSub);
		}
		return Result.resultSet(goodsTypeSub);
	}

	/**
	 * console 子类
	 * @param index
	 * @param size
	 * @param whereMap
	 * @return
	 */
	@Override
	public Page<GoodsTypeSubBean> findSubPageByWhere(int index, int size, String url, Map whereMap) {
		index = index >= 0 ? index : 0;
		size = size > 0 ?  size : 10;
		int start = (index -1)*size;
		if(whereMap == null) {
			whereMap = new HashMap();
		}
		whereMap.put("start", start);
		whereMap.put("rows", size);

		List<GoodsTypeSubBean> goodsTypeSubs = goodsTypeSubDao.findByWhere(whereMap);
		int count = goodsTypeSubDao.findCount(whereMap);
		return new Page<>(start, size, count, url, goodsTypeSubs);
	}
}
