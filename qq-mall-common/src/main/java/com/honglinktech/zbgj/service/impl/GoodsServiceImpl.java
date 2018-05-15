package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.*;
import com.honglinktech.zbgj.bean.request.GoodsItem;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.*;
import com.honglinktech.zbgj.entity.Goods;
import com.honglinktech.zbgj.entity.GoodsActivity;
import com.honglinktech.zbgj.entity.GoodsFormat;
import com.honglinktech.zbgj.entity.Pic;
import com.honglinktech.zbgj.service.GoodsDisService;
import com.honglinktech.zbgj.service.GoodsService;
import com.honglinktech.zbgj.service.PicService;
import com.honglinktech.zbgj.vo.GoodsVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GoodsServiceImpl implements GoodsService{

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

	@Override
	public Response<GoodsBean> findGoodsBeanById(Integer id, int userId, int index, int size) throws BaseException{
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

	@Override
	public Response<List<GoodsBean>> findGoodsSearchBeans(Map whereMap) throws BaseException{
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
		if(whereMap.get("index") != null && whereMap.get("size") != null){
			int index = Integer.parseInt(whereMap.get("index").toString());
			int size = Integer.parseInt(whereMap.get("size").toString());

			whereMap.put("start", index > 0 ? (index-1)*size : 0);
			whereMap.put("rows", size > 0 ? size : 10);
		}

		List<GoodsBean> goodsListBeans = goodsDao.findGoodsSearchBeansByMap(whereMap);
		return Result.resultSet(goodsListBeans);
	}

	@Override
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
		List<Pic> goodsImgList = new ArrayList<Pic>();
		if(goodsImgs!=null){
			for(String goodsImg:goodsImgs){
				Pic tpic = new Pic();
				tpic.setObjId(goodsId);
				tpic.setPicUrl(goodsImg);
				tpic.setType(Constants.PIC_GOODS);
				goodsImgList.add(tpic);
			}
		}
		picDao.saveBatch(goodsImgList);
	}

	@Override
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
		Map delPicWhere = new HashMap();
		delPicWhere.put("objectId", goodsId);
		delPicWhere.put("type", Constants.PIC_GOODS);
		picDao.deleteByWhere(delPicWhere);
		picDao.saveBatch(goodsImgList);
	}

	@Override
	public Page<GoodsVO> findGoodsBeanPage(Map whereMap, String url) {

		int rows = Integer.valueOf(whereMap.get("rows").toString());
		int start =  Integer.valueOf(whereMap.get("start").toString());
		List<GoodsVO> goodsBeans = goodsDao.findGoodsVOPage(whereMap);
		long count = goodsDao.findGoodsCount(whereMap);

		Page<GoodsVO> page = new Page<GoodsVO>(start, rows, count, url, goodsBeans);
		return page;
	}

	@Override
	public GoodsVO findGoodsVOById(Integer id) {
		Goods goods = goodsDao.selectByPrimaryKey(id);
		GoodsVO goodsVO = new GoodsVO(goods);
		//活动
		//List<ActivityBean> activityBeanList = activityDao.findActivityByGoodsId(id);
		//规格
		List<FormatBean> formatBeanList = formatDao.findFormatByGoodsId(id);
		if(formatBeanList!=null){
			for(FormatBean fb:formatBeanList){
				List<FormatSubBean> formatSubBeanList = formatSubDao.findFormatSubByFormatId(fb.getId());
				fb.setFormatSubBeanList(formatSubBeanList);
			}
		}
		//图片处理
		List<PicBean> tpicList =  picService.findPic(goodsVO.getId(), Constants.PIC_GOODS);

		//goodsVO.setActivityBeanList(activityBeanList);
		goodsVO.setFormatBeanList(formatBeanList);
		goodsVO.setPicList(tpicList);

		return goodsVO;
	}
}
