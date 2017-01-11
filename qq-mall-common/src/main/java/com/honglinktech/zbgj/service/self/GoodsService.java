package com.honglinktech.zbgj.service.self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
import com.honglinktech.zbgj.dao.TGoodsActivityDao;
import com.honglinktech.zbgj.dao.TGoodsDao;
import com.honglinktech.zbgj.dao.TGoodsDisDao;
import com.honglinktech.zbgj.dao.TGoodsFormatDao;
import com.honglinktech.zbgj.dao.TPicDao;
import com.honglinktech.zbgj.dao.self.ActivityDao;
import com.honglinktech.zbgj.dao.self.FormatDao;
import com.honglinktech.zbgj.dao.self.FormatSubDao;
import com.honglinktech.zbgj.dao.self.GoodsBeanDao;
import com.honglinktech.zbgj.entity.TGoodsActivity;
import com.honglinktech.zbgj.entity.TGoodsFormat;
import com.honglinktech.zbgj.entity.TPic;
import com.honglinktech.zbgj.service.TGoodsService;

@Component
public class GoodsService extends TGoodsService {

	@Resource
	private TGoodsDao tgoodsDao;
	@Resource
	private GoodsBeanDao goodsBeanDao;
	@Resource
	private TGoodsActivityDao tgoodsActivityDao;
	@Resource
	private TGoodsFormatDao tgoodsFormatDao;
	@Resource
	private ActivityDao activityDao;
	@Resource
	private FormatDao formatDao;
	@Resource
	private FormatSubDao formatSubDao;
	@Resource
	private TPicDao tPicDao;
	@Resource
	private TGoodsDisDao tgoodsDisDao;
	@Resource
	private PicService picService;
	@Resource
	private GoodsDisService goodsDisService;
	
	public Response<GoodsBean> findGoodsBeanById(int id, int userId, int index, int size) throws BaseException{
		GoodsBean goodsBean = goodsBeanDao.appFindById(id, userId);
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
		List<GoodsBean> goodsListBeans = goodsBeanDao.findGoodsSearchBeansByMap(whereMap);
		return Result.resultSet(goodsListBeans);
	}
	
	public void saveGoods(GoodsItem goodsItem) throws BaseException{
		int goodsId = tgoodsDao.save(goodsItem.getTGoods());
		Integer[] goodsFormats = goodsItem.getGoodsFormats();
		Integer[] goodsActivitys = goodsItem.getGoodsActivitys();
		String[] goodsImgs = goodsItem.getGoodsImgs();
		List<TGoodsActivity> goodsActivityList = new ArrayList<TGoodsActivity>();
		if(goodsActivitys!=null){
			for(Integer activityId:goodsActivitys){
				TGoodsActivity ga = new TGoodsActivity();
				ga.setActivityId(activityId);
				ga.setGoodsId(goodsId);
				goodsActivityList.add(ga);
			}
		}
		tgoodsActivityDao.saveBatch(goodsActivityList);
		List<TGoodsFormat> goodsFormatList = new ArrayList<TGoodsFormat>();
		if(goodsFormats!=null){
			for(Integer formatId:goodsFormats){
				TGoodsFormat gf = new TGoodsFormat();
				gf.setFormatId(formatId);
				gf.setGoodsId(goodsId);
				goodsFormatList.add(gf);
			}
		}
		tgoodsFormatDao.saveBatch(goodsFormatList);
		List<TPic> goodsImgList = new ArrayList<TPic>();
		if(goodsImgs!=null){
			for(String goodsImg:goodsImgs){
				TPic tpic = new TPic();
				tpic.setObjId(goodsId);
				tpic.setPicUrl(goodsImg);
				tpic.setType(Constants.PIC_GOODS);
				goodsImgList.add(tpic);
			}
		}
		tPicDao.saveBatch(goodsImgList);
		
	}
	
	
	public void updateGoods(GoodsItem goodsItem) throws BaseException{
		int goodsId = goodsItem.getId();
		tgoodsDao.update(goodsItem.getTGoods());
		Integer[] goodsFormats = goodsItem.getGoodsFormats();
		Integer[] goodsActivitys = goodsItem.getGoodsActivitys();
		String[] goodsImgs = goodsItem.getGoodsImgs();
		
		List<TGoodsActivity> goodsActivityList = new ArrayList<TGoodsActivity>();
		if(goodsActivitys!=null){
			for(Integer activityId:goodsActivitys){
				TGoodsActivity ga = new TGoodsActivity();
				ga.setActivityId(activityId);
				ga.setGoodsId(goodsId);
				goodsActivityList.add(ga);
			}
		}
		tgoodsActivityDao.delete(new TGoodsActivity(goodsId, null));
		tgoodsActivityDao.saveBatch(goodsActivityList);
		
		
		List<TGoodsFormat> goodsFormatList = new ArrayList<TGoodsFormat>();
		if(goodsFormats!=null){
			for(Integer formatId:goodsFormats){
				TGoodsFormat gf = new TGoodsFormat();
				gf.setFormatId(formatId);
				gf.setGoodsId(goodsId);
				goodsFormatList.add(gf);
			}
		}
		tgoodsFormatDao.delete(new TGoodsFormat(goodsId, null));
		tgoodsFormatDao.saveBatch(goodsFormatList);
		
		System.out.println(goodsImgs);
		System.out.println(goodsImgs.length);
		List<TPic> goodsImgList = new ArrayList<TPic>();
		if(goodsImgs!=null){
			for(String goodsImg:goodsImgs){
				TPic tpic = new TPic();
				tpic.setObjId(goodsId);
				tpic.setPicUrl(goodsImg);
				tpic.setType(Constants.PIC_GOODS);
				goodsImgList.add(tpic);
			}
		}
		tPicDao.delete(new TPic(null, goodsId,Constants.PIC_GOODS,Constants.PIC_URL_TYPE_HTTP,null,null));
		tPicDao.saveBatch(goodsImgList);
	}

	
}
