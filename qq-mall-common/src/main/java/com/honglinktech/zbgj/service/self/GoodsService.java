package com.honglinktech.zbgj.service.self;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.GoodsBean;
import com.honglinktech.zbgj.bean.request.GoodsItem;
import com.honglinktech.zbgj.dao.TGActivityDao;
import com.honglinktech.zbgj.dao.TGFormatDao;
import com.honglinktech.zbgj.dao.TGoodsActivityDao;
import com.honglinktech.zbgj.dao.TGoodsDao;
import com.honglinktech.zbgj.dao.TGoodsFormatDao;
import com.honglinktech.zbgj.dao.TPicDao;
import com.honglinktech.zbgj.entity.TGActivity;
import com.honglinktech.zbgj.entity.TGFormat;
import com.honglinktech.zbgj.entity.TGoods;
import com.honglinktech.zbgj.entity.TGoodsActivity;
import com.honglinktech.zbgj.entity.TGoodsFormat;
import com.honglinktech.zbgj.entity.TPic;
import com.honglinktech.zbgj.service.TGoodsService;

@Component
public class GoodsService extends TGoodsService {
	public static int PIC_TYPE_GOODS = 1;

	@Resource
	private TGoodsDao tgoodsDao;
	@Resource
	private TGoodsActivityDao tgoodsActivityDao;
	@Resource
	private TGoodsFormatDao tgoodsFormatDao;
	@Resource
	private TGActivityDao tgActivityDao;
	@Resource
	private TGFormatDao tgFormatDao;
	@Resource
	private TPicDao tPicDao;
	
	public GoodsBean findGoodsInfo(int id) throws BaseException{
		TGoods tgoods = tgoodsDao.findById(id);
		GoodsBean gb = new GoodsBean(tgoods);
		List<TGActivity> tgActivityList = tgActivityDao.find("select act.* from t_goods_activity ga join t_g_activity act on ga.activity_id = act.id  where ga.goods_id = "+tgoods.getId());
		List<TGFormat> tgFormatList = tgFormatDao.find("select format.* from t_goods_format gf join t_g_format format on gf.format_id = format.id  where gf.goods_id = "+tgoods.getId());
		List<TPic> tPicList = tPicDao.find("select * from t_pic where obj_id = "+tgoods.getId()+" and type="+1);

		gb.setTgActivityList(tgActivityList);
		gb.setTgFormatList(tgFormatList);
		gb.settPicList(tPicList);
		return  gb;
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
				tpic.setType(PIC_TYPE_GOODS);
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
				tpic.setType(PIC_TYPE_GOODS);
				goodsImgList.add(tpic);
			}
		}
		System.out.println("=-=-=-=-=-=-="+goodsImgList.size());
		tPicDao.delete(new TPic(null, goodsId,PIC_TYPE_GOODS,null,null));
		tPicDao.saveBatch(goodsImgList);
	}
	
}
