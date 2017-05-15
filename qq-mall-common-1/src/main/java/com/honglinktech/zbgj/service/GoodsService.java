package com.honglinktech.zbgj.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.honglinktech.zbgj.entity.GoodsActivity;
import com.honglinktech.zbgj.entity.GoodsFormat;
import com.honglinktech.zbgj.entity.Pic;
import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.bean.FormatBean;
import com.honglinktech.zbgj.bean.FormatSubBean;
import com.honglinktech.zbgj.bean.GoodsBean;
import com.honglinktech.zbgj.bean.GoodsDisBean;
import com.honglinktech.zbgj.bean.GoodsDisCountBean;
import com.honglinktech.zbgj.bean.PicBean;
import com.honglinktech.zbgj.bean.request.GoodsItem;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.FormatDao;
import com.honglinktech.zbgj.dao.FormatSubDao;
import com.honglinktech.zbgj.dao.GoodsActivityDao;
import com.honglinktech.zbgj.dao.GoodsDao;
import com.honglinktech.zbgj.dao.GoodsDisDao;
import com.honglinktech.zbgj.dao.GoodsFormatDao;
import com.honglinktech.zbgj.dao.PicDao;

@Component
public class GoodsService{

	@Resource
	private GoodsDao goodsDao;
	@Resource
	private GoodsActivityDao goodsActivityDao;
	@Resource
	private GoodsFormatDao goodsFormatDao;
	@Resource
	private GoodsActivityDao activityDao;
	@Resource
	private FormatDao formatDao;
	@Resource
	private FormatSubDao formatSubDao;
	@Resource
	private PicDao picDao;
	@Resource
	private PicService picService;
	@Resource
	private GoodsDisService goodsDisService;
	
	public Response<GoodsBean> findGoodsBeanById(int id, int userId, int index, int size) throws BaseException{
		GoodsBean goodsBean = goodsDao.appFindKeepById(id, userId);
		//活动
		List<ActivityBean> activityBeanList = activityDao.findActivityByGoodsId(id);
		//规格
		List<FormatBean> formatBeanList = formatDao.findFormatByGoodsId(id);
		if(formatBeanList!=null){
			for(FormatBean fb:formatBeanList){
				List<FormatSubBean> formatSubBeanList = formatSubDao.findFormatSubByFormatId(fb.getId());
				fb.setFormatSubBeanList(formatSubBeanList);
			}
		}
		//图片处理
		List<PicBean> tpicList =  picService.findPic(goodsBean.getId(), Constants.PIC_GOODS);
		//List<TGoodsDis> tDisList = tgoodsDisDao.findByWhere(" WHERE goods_id = "+goodsBean.getId());
		//评论处理
		Response<GoodsDisCountBean> gdcbResp = goodsDisService.findGoodsDisCount(id);
		goodsBean.setGoodsDisCountBean(gdcbResp.getResult());
		Map<String,String> whereMap = new HashMap<String, String>();
		whereMap.put("goodsId", id+"");
		whereMap.put("index", index+"");
		whereMap.put("size", size+"");
		Response<List<GoodsDisBean>> gdbResp = goodsDisService.findGoodsDisByPage(whereMap);
		goodsBean.setGoodsDisBeanList(gdbResp.getResult());
		
		goodsBean.setActivityBeanList(activityBeanList);
		goodsBean.setFormatBeanList(formatBeanList);
		goodsBean.setPicList(tpicList);
		//goodsBean.setGoodsDisList(tDisList);
		return  Result.resultSet(goodsBean);
	}
	
	public Response<List<GoodsBean>> findGoodsSearchBeans(Map<String, String> whereMap) throws BaseException{
		if(whereMap.containsKey("searchPrice")){
			String searchPrice = whereMap.get("searchPrice").toString();
			if(searchPrice.indexOf("+")>0){
				String minPrice = searchPrice.replace("+", "");
				whereMap.put("minPrice", minPrice);
			}
			if(searchPrice.indexOf("-")>0){
				String minPrice = searchPrice.split("-")[0];
				String maxPrice = searchPrice.split("-")[1];
				whereMap.put("minPrice", minPrice);
				whereMap.put("maxPrice", maxPrice);
			}
		}
		List<GoodsBean> goodsListBeans = goodsDao.findGoodsSearchBeansByMap(whereMap);
		return Result.resultSet(goodsListBeans);
	}
	
	public void saveGoods(GoodsItem goodsItem) throws BaseException{
		int goodsId = goodsDao.insertSelective(goodsItem.getGoods());
		Integer[] goodsFormats = goodsItem.getGoodsFormats();
		Integer[] goodsActivitys = goodsItem.getGoodsActivitys();
		String[] goodsImgs = goodsItem.getGoodsImgs();
		List<GoodsActivity> goodsActivityList = new ArrayList<GoodsActivity>();
		if(goodsActivitys!=null){
			for(Integer activityId:goodsActivitys){
				GoodsActivity ga = new GoodsActivity();
				ga.setActivityId(activityId);
				ga.setGoodsId(goodsId);
				goodsActivityList.add(ga);
			}
		}
		goodsActivityDao.saveBatch(goodsActivityList);
		List<GoodsFormat> goodsFormatList = new ArrayList<GoodsFormat>();
		if(goodsFormats!=null){
			for(Integer formatId:goodsFormats){
				GoodsFormat gf = new GoodsFormat();
				gf.setFormatId(formatId);
				gf.setGoodsId(goodsId);
				goodsFormatList.add(gf);
			}
		}
		goodsFormatDao.saveBatch(goodsFormatList);
		List<Pic> goodsImgList = new ArrayList<TPic>();
		if(goodsImgs!=null){
			for(String goodsImg:goodsImgs){
				Pic tpic = new Pic();
				tpic.setObjId(goodsId);
				tpic.setPicUrl(goodsImg);
				tpic.setType(Constants.PIC_GOODS);
				goodsImgList.add(tpic);
			}
		}
		PicDao.saveBatch(goodsImgList);
	}

	public void updateGoods(GoodsItem goodsItem) throws BaseException{
		int goodsId = goodsItem.getId();
		goodsDao.updateByPrimaryKeySelective(goodsItem.getGoods());
		Integer[] goodsFormats = goodsItem.getGoodsFormats();
		Integer[] goodsActivitys = goodsItem.getGoodsActivitys();
		String[] goodsImgs = goodsItem.getGoodsImgs();
		
		List<GoodsActivity> goodsActivityList = new ArrayList<GoodsActivity>();
		if(goodsActivitys!=null){
			for(Integer activityId:goodsActivitys){
				GoodsActivity ga = new GoodsActivity();
				ga.setActivityId(activityId);
				ga.setGoodsId(goodsId);
				goodsActivityList.add(ga);
			}
		}
		goodsActivityDao.deleteByGoodsId(goodsId);
		goodsActivityDao.saveBatch(goodsActivityList);

		List<GoodsFormat> goodsFormatList = new ArrayList<GoodsFormat>();
		if(goodsFormats!=null){
			for(Integer formatId:goodsFormats){
				GoodsFormat gf = new GoodsFormat();
				gf.setFormatId(formatId);
				gf.setGoodsId(goodsId);
				goodsFormatList.add(gf);
			}
		}
		goodsFormatDao.deleteByGoodsId(goodsId);
		goodsFormatDao.saveBatch(goodsFormatList);
		
		System.out.println(goodsImgs);
		System.out.println(goodsImgs.length);
		List<Pic> goodsImgList = new ArrayList<Pic>();
		if(goodsImgs!=null){
			for(String goodsImg:goodsImgs){
				Pic pic = new Pic();
				pic.setObjId(goodsId);
				pic.setPicUrl(goodsImg);
				pic.setType(Constants.PIC_GOODS);
				goodsImgList.add(pic);
			}
		}
		picDao.delete(new Pic(null, goodsId,Constants.PIC_GOODS,Constants.PIC_URL_TYPE_HTTP,null,null));
		picDao.saveBatch(goodsImgList);
	}

	
}
