package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.GoodsDisBean;
import com.honglinktech.zbgj.bean.GoodsDisCountBean;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.GoodsDisDao;
import com.honglinktech.zbgj.entity.GoodsDis;
import com.honglinktech.zbgj.service.GoodsDisService;
import com.honglinktech.zbgj.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GoodsDisServiceImpl implements GoodsDisService{
	@Resource
	private GoodsDisDao goodsDisDao;
	@Resource
	private PicService picService;

	@Override
	public Response<GoodsDisCountBean> findGoodsDisCount(int goodsId){

		GoodsDisCountBean gdcb = goodsDisDao.findGoodsDisCount(goodsId);
		return Result.resultSet(gdcb);
	}

	@Override
	public Response<List<GoodsDisBean>> findGoodsDisByPage(Map map) throws BaseException{
		
		int start = map.containsKey("start")?Integer.valueOf(map.get("start").toString()):0;
		int rows = map.containsKey("rows")?Integer.valueOf(map.get("rows").toString()):10;
		int goodsId = Integer.valueOf(map.get("goodsId").toString());
		Integer type = map.containsKey("type")?Integer.valueOf(map.get("type").toString()):null;
		
		Map whereMap = new HashMap();
		whereMap.put("start", start);
		whereMap.put("rows", rows);
		whereMap.put("goodsId", goodsId);
		if (type != null) {
			if (type == 1) {//差评
				whereMap.put("disValues", new Integer[]{1});
			} else if (type == 2){//中评
				whereMap.put("disValues", new Integer[]{2, 3});
			} else if (type == 3) {//好评
				whereMap.put("disValues", new Integer[]{4, 5});
			} else if (type == 10) {//有图的
				whereMap.put("disValues", new Integer[]{1});
			}
		}
		List<GoodsDis> goodsDises = goodsDisDao.findByGoodsId(whereMap);
		List<GoodsDisBean> goodsDisBeanList = new ArrayList<GoodsDisBean>();
		
		if(goodsDises!=null){
			for(GoodsDis goodsDis:goodsDises){
				GoodsDisBean goodsDisBean = new GoodsDisBean(goodsDis);
				goodsDisBean.setPicBeanList(picService.findPic(goodsDis.getId(), Constants.PIC_GOODS_DIS));
				goodsDisBeanList.add(goodsDisBean);
			}
		}
		
		return Result.resultSet(goodsDisBeanList);
	}
	
}
