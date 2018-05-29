package com.honglinktech.zbgj.service.impl;

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
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.FormatDao;
import com.honglinktech.zbgj.dao.FormatSubDao;
import com.honglinktech.zbgj.dao.GoodsActivityDao;
import com.honglinktech.zbgj.dao.GoodsDao;
import com.honglinktech.zbgj.dao.GoodsFormatDao;
import com.honglinktech.zbgj.dao.GoodsPhoneDao;
import com.honglinktech.zbgj.dao.PicDao;
import com.honglinktech.zbgj.entity.Goods;
import com.honglinktech.zbgj.entity.GoodsActivity;
import com.honglinktech.zbgj.entity.GoodsFormat;
import com.honglinktech.zbgj.entity.GoodsPhone;
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
	@Resource
	private GoodsPhoneDao goodsPhoneDao;

	@Override
	public Response<GoodsVO> findGoodsVOById(Integer id, int userId, int index, int size) throws BaseException{
		GoodsVO goodsVO = goodsDao.findVOById(id, userId);
		if (goodsVO == null) {
			return Result.fail("没有找到商品！");
		}
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
		List<PicBean> tpicList =  picService.findPic(goodsVO.getId(), Constants.PIC_GOODS);
		//List<TGoodsDis> tDisList = tgoodsDisDao.findByWhere(" WHERE goods_id = "+goodsBean.getId());
		//评论处理
		Response<GoodsDisCountBean> gdcbResp = goodsDisService.findGoodsDisCount(id);
		goodsVO.setGoodsDisCountBean(gdcbResp.getResult());
		Map<String,String> whereMap = new HashMap<String, String>();
		whereMap.put("goodsId", id+"");
		whereMap.put("index", index+"");
		whereMap.put("size", size+"");
		Response<List<GoodsDisBean>> gdbResp = goodsDisService.findGoodsDisByPage(whereMap);
		goodsVO.setGoodsDisBeanList(gdbResp.getResult());
		GoodsPhone goodsPhone = goodsPhoneDao.findById(id);
		if(goodsPhone != null){
			goodsVO.setGoodsPhoneVO(goodsPhone.toVO());
		}
		goodsVO.setActivityBeanList(activityBeanList);
		goodsVO.setFormatBeanList(formatBeanList);
		goodsVO.setPicList(tpicList);
		//goodsBean.setGoodsDisList(tDisList);
		return  Result.resultSet(goodsVO);
	}

	@Override
	public Response<List<GoodsVO>> findGoodsVOByWhere(Map whereMap) throws BaseException{
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

		List<GoodsVO> goodsListBeans = goodsDao.findGoodsByWhere(whereMap);
		return Result.resultSet(goodsListBeans);
	}

	@Override
	public Response saveGoods(GoodsBean goodsBean, Integer[] goodsFormats, Integer[] goodsActivitys, String[] goodsImgs) throws BaseException{
		Goods goods = new Goods(goodsBean);
		if(goods.getId() != null && goods.getId() > 0){
			goodsDao.update(goods);
		}else{
			goodsDao.insert(goods);
		}
		int goodsId = goods.getId();

		if(goodsActivitys != null && goodsActivitys.length > 0){
			List<GoodsActivity> goodsActivityList = new ArrayList<GoodsActivity>();
			for(Integer activityId:goodsActivitys){
				GoodsActivity ga = new GoodsActivity();
				ga.setActivityId(activityId);
				ga.setGoodsId(goodsId);
				goodsActivityList.add(ga);
			}
			goodsActivityDao.saveBatch(goodsActivityList);
		}

		if(goodsFormats != null && goodsFormats.length > 0){
			List<GoodsFormat> goodsFormatList = new ArrayList<GoodsFormat>();
			for(Integer formatId:goodsFormats){
				GoodsFormat gf = new GoodsFormat();
				gf.setFormatId(formatId);
				gf.setGoodsId(goodsId);
				goodsFormatList.add(gf);
			}
			goodsFormatDao.saveBatch(goodsFormatList);
		}


		if(goodsImgs!=null && goodsImgs.length > 0){
			List<Pic> goodsImgList = new ArrayList<Pic>();
			for(String goodsImg:goodsImgs){
				Pic tpic = new Pic();
				tpic.setObjId(goodsId);
				tpic.setPicUrl(goodsImg);
				tpic.setType(Constants.PIC_GOODS);
				goodsImgList.add(tpic);
			}
			picDao.saveBatch(goodsImgList);
		}

		goodsBean.setId(goods.getId());
		return Result.resultSet(goodsBean);
	}

	@Override
	public Response updateGoods(GoodsItem goodsItem) throws BaseException{
		int goodsId = goodsItem.getId();
		goodsDao.update(goodsItem.getGoods());
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
		return Result.success();
	}

	@Override
	public Page<GoodsBean> findGoodsBeanPage(Map whereMap, String url) {

		int rows = Integer.valueOf(whereMap.get("rows").toString());
		int start =  Integer.valueOf(whereMap.get("start").toString());
		List<GoodsBean> goodsBeans = goodsDao.findGoodsPage(whereMap);
		long count = goodsDao.findGoodsCount(whereMap);

		Page<GoodsBean> page = new Page<GoodsBean>(start, rows, count, url, goodsBeans);
		return page;
	}


	@Override
	public Response findGoodsBeanById(Integer id) {
		Goods goods = goodsDao.findById(id);
		if(goods==null){
			return Result.fail("没有找到~！");
		}
		GoodsBean goodsBean = new GoodsBean(goods);

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
		List<PicBean> tpicList =  picService.findPic(goodsBean.getId(), Constants.PIC_GOODS);

		//goodsVO.setActivityBeanList(activityBeanList);
		goodsBean.setFormatList(formatBeanList);
		goodsBean.setPicList(tpicList);

		return Result.resultSet(goodsBean);
	}

	@Override
	public GoodsVO findGoodsVOById(Integer id) {
		Goods goods = goodsDao.findById(id);
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
