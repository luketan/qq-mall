package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.GoodsTypeDao;
import com.honglinktech.zbgj.dao.GoodsTypeSubDao;
import com.honglinktech.zbgj.entity.GoodsType;
import com.honglinktech.zbgj.entity.GoodsTypeSub;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GoodsTypeService{
	@Resource
	private GoodsTypeDao goodsTypeDao;
	@Resource
	private GoodsTypeSubDao goodsTypeSubDao;
	
	public Response<GoodsTypeBean> findGoodsTypeBeanById(int id) {

		GoodsType goodsType = goodsTypeDao.selectByPrimaryKey(id);
		Map whereMap = new HashMap();
		whereMap.put("goodsType", id);
		List<GoodsTypeSub> gtsList = goodsTypeSubDao.findByWhere(whereMap);

		GoodsTypeBean goodsTypeBean = new GoodsTypeBean(goodsType);
		goodsTypeBean.setTgoodsTypeSubList(gtsList);
		
		return Result.resultSet(goodsTypeBean);
	}
	
	public Response<List<GoodsTypeBean>> findGoodsTypeAll() {
		List<GoodsType> goodsTypes = goodsTypeDao.findAll();

		List<GoodsTypeBean> goodsTypeBeans = new ArrayList<>();
		if (goodsTypes != null) {
			for (GoodsType goodsType:goodsTypes) {
				goodsTypeBeans.add(new GoodsTypeBean(goodsType));
			}
		}
		return Result.resultSet(goodsTypeBeans);
	}
}
