package com.honglinktech.zbgj.service.self;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.TGoodsTypeSubDao;
import com.honglinktech.zbgj.dao.self.GoodsTypeBeanDao;
import com.honglinktech.zbgj.entity.TGoodsTypeSub;
import com.honglinktech.zbgj.service.TGTypeService;

@Component
public class GoodsTypeService extends TGTypeService {
	@Resource
	private GoodsTypeBeanDao goodsTypeBeanDao;
	@Resource
	private TGoodsTypeSubDao tgoodsTypeSubDao;
	
	public Response<GoodsTypeBean> findGoodsTypeBeanById(int id) {

		GoodsTypeBean goodsTypeBean = goodsTypeBeanDao.findGoodsBeanTypeById(id);
		Map<String,String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(TGoodsTypeSub.DBMaping.goodsType.name(), new String[]{id+""});
		List<TGoodsTypeSub> gtsList = tgoodsTypeSubDao.findByWhere(whereMap);
		goodsTypeBean.setTgoodsTypeSubList(gtsList);
		
		return Result.resultSet(goodsTypeBean);
	}
	
	public Response<List<GoodsTypeBean>> findGoodsTypeAll() {
		List<GoodsTypeBean> goodsTypeBean = goodsTypeBeanDao.findAll();
		return Result.resultSet(goodsTypeBean);
	}
}
