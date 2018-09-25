package com.honglinktech.zbgj.service.impl;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.*;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.*;
import com.honglinktech.zbgj.entity.*;
import com.honglinktech.zbgj.service.GoodsDisService;
import com.honglinktech.zbgj.service.GoodsService;
import com.honglinktech.zbgj.service.PicService;
import com.honglinktech.zbgj.service.ShoppingCartService;
import com.honglinktech.zbgj.vo.GoodsVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GoodsServiceImpl implements GoodsService{


	protected final Logger logger = LogManager.getLogger(getClass());

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
	@Resource
	private FormatRelyDao formatRelyDao;
	@Resource
	private GoodsTagDao goodsTagDao;
	@Resource
	private UserKeepDao userKeepDao;
	@Resource
	private ShoppingCartService shoppingCartService;
	@Resource
	private ShoppingCartDao shoppingCartDao;

	/**
	 * App 带评论
	 * @param id
	 * @param userId
	 * @return
	 * @throws BaseException
     */
	@Override
	public Response findGoodsVOById(Integer id, Integer userId) throws BaseException{
		GoodsVO goodsVO = goodsDao.findVOById(id, userId);

		logger.info(userId+"======findGoodsVOById======"+JSON.toJSONString(goodsVO));
		if (goodsVO == null) {
			return Result.fail("没有找到商品！");
		}
		//活动
		List<ActivityBean> activityList = activityDao.findActivityByGoodsId(id);
		goodsVO.setActivityList(activityList);
		//规格
		List<FormatBean> formatList = formatDao.findFormatByGoodsId(id);
		if(formatList!=null){
			for(FormatBean fb:formatList){
				List<FormatSubBean> formatSubs = formatSubDao.findFormatSubByFormatId(fb.getId());
				if(formatSubs != null){
					for(FormatSubBean fs:formatSubs){
						fs.setRelyFormatSubIds(formatRelyDao.findByFormatSubId(fs.getId()));
					}
				}
				fb.setFormatSubList(formatSubs);
			}
		}
		goodsVO.setFormatList(formatList);

		//评论处理
		Response<GoodsDisCountBean> gdcbResp = goodsDisService.findGoodsDisCount(id);
		goodsVO.setGoodsDisCountBean(gdcbResp.getResult());
		Map whereMap = new HashMap();
		whereMap.put("goodsId", id);
		whereMap.put("start", 0);
		whereMap.put("rows", 10);
		Response<List<GoodsDisBean>> gdbResp = goodsDisService.findGoodsDisByPage(whereMap);
		goodsVO.setGoodsDisBeanList(gdbResp.getResult());

		//参数配置
		GoodsPhone goodsPhone = goodsPhoneDao.findById(id);
		if(goodsPhone != null){
			goodsVO.setGoodsPhoneVO(goodsPhone.toVO());
		}

		//图片处理
		List<PicBean> tpicList =  picService.findPic(goodsVO.getId(), Constants.PIC_GOODS);
		goodsVO.setPicList(tpicList);

		Map retMap = new HashMap<>();
		retMap.put("goods", goodsVO);
		if(userId > 0){
			int num = shoppingCartDao.findCount(userId);
			retMap.put("shoppingCartNum", num);
		}


		return  Result.resultSet(retMap);
	}

	/**
	 * APP 商品详情，规格，活动
	 * @param id
	 * @return
	 */
	@Override
	public GoodsVO findSimpleGoodsVOById(Integer id) throws Exception {
		Goods goods = goodsDao.findById(id);
		GoodsVO goodsVO = new GoodsVO(goods);
		//活动
		List<ActivityBean> activityBeanList = activityDao.findActivityByGoodsId(id);
		goodsVO.setActivityList(activityBeanList);
		//规格
		List<FormatBean> formatBeanList = formatDao.findFormatByGoodsId(id);
		if(formatBeanList!=null){
			for(FormatBean fb:formatBeanList){
				List<FormatSubBean> formatSubBeanList = formatSubDao.findFormatSubByFormatId(fb.getId());
				fb.setFormatSubList(formatSubBeanList);
			}
		}
		goodsVO.setFormatList(formatBeanList);

		//图片处理
		List<PicBean> picList =  picService.findPic(goodsVO.getId(), Constants.PIC_GOODS);
		goodsVO.setPicList(picList);

		return goodsVO;
	}

	/**
	 * app
	 * @param whereMap
	 * @return
	 * @throws BaseException
     */
	@Override
	public List<GoodsVO> findGoodsVOByWhere(Map whereMap) throws BaseException{
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


		List<GoodsVO> goodsListBeans = goodsDao.findGoodsByWhere(whereMap);
		return goodsListBeans;
	}

	/**
	 * console
	 * @param goodsBean
	 * @param formats
	 * @param goodsTags
	 * @param goodsActivitys
	 * @param goodsImgs
	 * @return
     * @throws Exception
     */
	@Override
	public Response saveGoods(GoodsBean goodsBean,
							  List<Format> formats,
							  Integer[] goodsTags,
							  Integer[] goodsActivitys,
							  String[] goodsImgs) throws Exception{
		Goods goods = new Goods(goodsBean);
		goodsDao.insert(goods);
		int goodsId = goods.getId();
		//
		if(goodsBean.getGoodsPhone() != null){
			GoodsPhone goodsPhone = new GoodsPhone(goodsBean.getGoodsPhone());
			goodsPhone.setId(goodsId);
			goodsPhoneDao.update(goodsPhone);
		}
		//
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

		//
		if(goodsTags != null && goodsTags.length > 0){
			List<GoodsTag> goodsTagList = new ArrayList<GoodsTag>();
			for(Integer tagId:goodsTags){
				GoodsTag gt = new GoodsTag();
				gt.setTagId(tagId);
				gt.setGoodsId(goodsId);
				goodsTagList.add(gt);
			}
			goodsTagDao.saveBatch(goodsTagList);
		}

		//
		if(formats!=null){
			for(Format format : formats){
				format.setGoodsId(goods.getId());
				formatDao.insert(format);
				if(format != null && format.getFormatSubs() != null){
					for(FormatSub fs : format.getFormatSubs()){
						fs.setFormatId(format.getId());
						formatSubDao.insert(fs);
					}
				}
			}
			//依赖关系处理
			for(int i=0; i<formats.size(); i++){
				Format fomart = formats.get(i);
				if(fomart.getFormatSubs()!=null){
					for(FormatSub fs:fomart.getFormatSubs()){
						formatRelyDao.deleteByFormatSubId(fs.getId());
						if(fs.getRelyFormatSubIds()!=null){
							for(Integer relyId:fs.getRelyFormatSubIds()){
								for(Format format2:formats){
									if(format2.getFormatSubs()!=null){
										for(FormatSub fs2:format2.getFormatSubs()){
											if(fs2.getFormatSubFalg().equals(""+relyId)){
												FormatRely formatRely = new FormatRely();
												formatRely.setRelyFormatSubId(fs2.getId());
												formatRely.setFormatSubId(fs.getId());
												formatRelyDao.save(formatRely);
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		//图片处理
		if(goodsImgs!=null && goodsImgs.length > 0){
			List<Pic> goodsImgList = new ArrayList<Pic>();
			for(String goodsImg:goodsImgs){
				Pic pic = new Pic();
				pic.setObjId(goodsId);
				pic.setPicUrl(goodsImg);
				pic.setType(Constants.PIC_GOODS);
				goodsImgList.add(pic);
			}
			picDao.saveBatch(goodsImgList);
		}

		goodsBean.setId(goods.getId());
		return Result.resultSet(goodsBean);
	}

	/**
	 * conosle
	 * @param goodsBean
	 * @param formats
	 * @param goodsTags
	 * @param goodsActivitys
	 * @param goodsImgs
	 * @return
     * @throws Exception
     */
	@Override
	public Response updateGoods(GoodsBean goodsBean,
								List<Format> formats,
								Integer[] goodsTags,
								Integer[] goodsActivitys,
								String[] goodsImgs) throws Exception{
		Goods goods = new Goods(goodsBean);
		goodsDao.update(goods);
		int goodsId = goods.getId();
		//
		if(goodsBean.getGoodsPhone() != null){
			GoodsPhone goodsPhone = new GoodsPhone(goodsBean.getGoodsPhone());
			goodsPhone.setId(goodsId);
			goodsPhoneDao.update(goodsPhone);
		}
		//
		goodsActivityDao.deleteByGoodsId(goodsId);
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
		//
		goodsTagDao.deleteByGoodsId(goodsId);
		if(goodsTags != null && goodsTags.length > 0){
			List<GoodsTag> goodsTagList = new ArrayList<GoodsTag>();
			for(Integer tagId:goodsTags){
				GoodsTag gt = new GoodsTag();
				gt.setTagId(tagId);
				gt.setGoodsId(goodsId);
				goodsTagList.add(gt);
			}
			goodsTagDao.saveBatch(goodsTagList);
		}
		//
		if(formats!=null){
			for(Format format : formats){
				if(format != null){
					format.setGoodsId(goodsId);
					if(format.getId()!=null && format.getId()>0){
						formatDao.update(format);
					}else{
						formatDao.insert(format);
					}
					if(format.getFormatSubs() != null){
						for(FormatSub fs : format.getFormatSubs()){
							fs.setFormatId(format.getId());
							if(fs.getId()!=null && fs.getId()>0){
								formatSubDao.update(fs);
							}else{
								formatSubDao.insert(fs);
							}

						}
					}
				}
			}
			//依赖关系处理
			for(int i=0; i<formats.size(); i++){
				Format fomart = formats.get(i);
				if(fomart.getFormatSubs()!=null){
					for(FormatSub fs:fomart.getFormatSubs()){
						formatRelyDao.deleteByFormatSubId(fs.getId());
						if(fs.getRelyFormatSubIds()!=null){
							for(Integer relyId:fs.getRelyFormatSubIds()){
								for(Format format2:formats){
									if(format2.getFormatSubs()!=null){
										for(FormatSub fs2:format2.getFormatSubs()){
											if(fs2.getFormatSubFalg().equals(""+relyId)){
												FormatRely formatRely = new FormatRely();
												formatRely.setRelyFormatSubId(fs2.getId());
												formatRely.setFormatSubId(fs.getId());
												formatRelyDao.save(formatRely);
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		//图片处理
		Map delPicWhere = new HashMap();
		delPicWhere.put("objectId", goodsId);
		delPicWhere.put("type", Constants.PIC_GOODS);
		picDao.deleteByWhere(delPicWhere);

		List<Pic> goodsImgList = new ArrayList<Pic>();
		if(goodsImgs!=null){
			for(String goodsImg:goodsImgs){
				Pic pic = new Pic();
				pic.setObjId(goodsId);
				pic.setPicUrl(goodsImg);
				pic.setType(Constants.PIC_GOODS);
				pic.setUrlType(Constants.PIC_URL_TYPE_HTTP);
				goodsImgList.add(pic);
			}
			picDao.saveBatch(goodsImgList);
		}

		return Result.success();
	}

	/**
	 * conosle
	 * @param whereMap
	 * @param url
     * @return
     */
	@Override
	public Page<GoodsBean> findGoodsBeanPage(Map whereMap, String url) {

		int rows = Integer.valueOf(whereMap.get("rows").toString());
		int start =  Integer.valueOf(whereMap.get("start").toString());
		List<GoodsBean> goodsBeans = goodsDao.findGoodsPage(whereMap);
		long count = goodsDao.findGoodsCount(whereMap);

		Page<GoodsBean> page = new Page<GoodsBean>(start, rows, count, url, goodsBeans);
		return page;
	}


	/**
	 * console
	 * @param id
	 * @return
     */
	@Override
	public Response findGoodsBeanById(Integer id) {
		Goods goods = goodsDao.findById(id);
		if(goods==null){
			return Result.fail("没有找到~！");
		}
		GoodsBean goodsBean = new GoodsBean(goods);

		//活动 其他已经处理了
//		List<ActivityBean> activityBeanList = activityDao.findActivityByGoodsId(id);
//		goodsBean.setActivityBeanList(activityBeanList);

		//规格
		List<FormatBean> formatBeanList = formatDao.findFormatByGoodsId(id);
		if(formatBeanList!=null){
			for(FormatBean fb:formatBeanList){
				List<FormatSubBean> formatSubs = formatSubDao.findFormatSubByFormatId(fb.getId());
				if(formatSubs != null){
					for(FormatSubBean fs:formatSubs){
						fs.setRelyFormatSubIds(formatRelyDao.findByFormatSubId(fs.getId()));
					}
				}
				fb.setFormatSubList(formatSubs);
			}
		}
		goodsBean.setFormatList(formatBeanList);

		//图片处理
		List<PicBean> tpicList =  picService.findPic(goodsBean.getId(), Constants.PIC_GOODS);
		goodsBean.setPicList(tpicList);

		//参数配置
		GoodsPhone goodsPhone = goodsPhoneDao.findById(id);
		if(goodsPhone != null){
			goodsBean.setGoodsPhone(goodsPhone.toBean());
		}


		return Result.resultSet(goodsBean);
	}

	/**
	 * console ajax删除产品规格
	 *
	 * @return
	 */
	@Override
	public Response<String> deleteFormat(Integer id) {
		int result = formatDao.delete(id);
		if(result > 0){
			return Result.success("删除成功~");
		}else{
			return Result.fail("删除失败~");
		}
	}
	/**
	 * console ajax删除产品规格子项
	 *
	 * @return
	 */
	@Override
	public Response<String> deleteFormatSub(Integer id) {
		int result = formatSubDao.delete(id);
		if(result > 0){
			return Result.success("删除成功~");
		}else{
			return Result.fail("删除失败~");
		}
	}
}
