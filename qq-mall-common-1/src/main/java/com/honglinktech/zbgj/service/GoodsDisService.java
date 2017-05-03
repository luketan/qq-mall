package com.honglinktech.zbgj.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.GoodsDisBean;
import com.honglinktech.zbgj.bean.GoodsDisCountBean;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.GoodsDisDao;

@Component
public class GoodsDisService{
	@Resource
	private GoodsDisDao goodsDisDao;
	@Resource
	private PicService picService;
	
	public Response<GoodsDisCountBean> findGoodsDisCount(int goodsId){
		String sql = "SELECT "+
					" (select count(1) FROM t_goods_dis where goods_id="+goodsId+") as totalCount,"+
					" (select count(1) FROM t_goods_dis where goods_id="+goodsId+" AND img=1) as imgCount,"+
					" (select count(1) FROM t_goods_dis where goods_id="+goodsId+" AND (dis_value>=4)) as goodCount,"+
					" (select count(1) FROM t_goods_dis where goods_id="+goodsId+" AND (dis_value=2 OR dis_value=3)) as generalCount,"+
					" (select count(1) FROM t_goods_dis where goods_id="+goodsId+" AND (dis_value=1)) as errorCount,"+
					" (select IFNULL(AVG(dis_value),0) FROM t_goods_dis where goods_id="+goodsId+") as avgDisValue";
		
		Map<String, Object> map = goodsDisDao.findMap(sql);
		GoodsDisCountBean gdcb = new GoodsDisCountBean();
		gdcb.setErrorCount(Integer.valueOf(map.get("errorCount").toString()));
		gdcb.setGeneralCount(Integer.valueOf(map.get("generalCount").toString()));
		gdcb.setGoodCount(Integer.valueOf(map.get("goodCount").toString()));
		gdcb.setImgCount(Integer.valueOf(map.get("imgCount").toString()));
		gdcb.setTotalCount(Integer.valueOf(map.get("totalCount").toString()));
		gdcb.setAvgDisValue(Float.valueOf(map.get("avgDisValue").toString()));
		
		return Result.resultSet(gdcb);
	}
	
	public Response<List<GoodsDisBean>> findGoodsDisByPage(Map<String, String> map) throws BaseException{
		
		int index = map.containsKey("index")?Integer.valueOf(map.get("index")):1;
		int size = map.containsKey("size")?Integer.valueOf(map.get("size")):10;
		int goodsId = Integer.valueOf(map.get("goodsId"));
		
		Map<String, String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(TGoodsDis.DBMaping.goodsId.name(), new String[]{String.valueOf(goodsId)});
		if(map.containsKey("type") && !StringUtils.isEmpty(map.get("type"))){
			if(Integer.valueOf(map.get("type"))==1){//差评
				whereMap.put(TGoodsDis.DBMaping.disValue.name(), new String[]{"1"});
			}else if(Integer.valueOf(map.get("type"))==2){
				whereMap.put(TGoodsDis.DBMaping.disValue.name(), new String[]{"2","3"});
			}else if(Integer.valueOf(map.get("type"))==3){
				whereMap.put(TGoodsDis.DBMaping.disValue.name(), new String[]{"4","5"});
			}else if(Integer.valueOf(map.get("type"))==10){//有图的
				whereMap.put(TGoodsDis.DBMaping.img.name(), new String[]{"1"});
			}
		}
		QueryHelper<TGoodsDis> qh = new QueryHelper<TGoodsDis>(index, size, whereMap);
		QueryHelper<TGoodsDis> resutlQH = goodsDisDao.findByQueryHelperNoCount(qh);
		List<TGoodsDis> tgoodsDisList = resutlQH.getResultList();
		List<GoodsDisBean> goodsDisBeanList = new ArrayList<GoodsDisBean>();
		
		if(tgoodsDisList!=null){
			for(TGoodsDis tgoodsDis:tgoodsDisList){
				GoodsDisBean goodsDisBean = new GoodsDisBean(tgoodsDis);
				goodsDisBean.setPicBeanList(picService.findPic(tgoodsDis.getId(), Constants.PIC_GOODS_DIS));
				goodsDisBeanList.add(new GoodsDisBean(tgoodsDis));
			}
		}
		
		return Result.resultSet(goodsDisBeanList);
	}
	
}
