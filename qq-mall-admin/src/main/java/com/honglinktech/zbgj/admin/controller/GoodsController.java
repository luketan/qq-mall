package com.honglinktech.zbgj.admin.controller;


import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.bean.GoodsBean;
import com.honglinktech.zbgj.bean.GoodsTagBean;
import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.bean.request.GoodsItem;
import com.honglinktech.zbgj.common.*;
import com.honglinktech.zbgj.entity.Format;
import com.honglinktech.zbgj.entity.FormatSub;
import com.honglinktech.zbgj.entity.Goods;
import com.honglinktech.zbgj.entity.GoodsBrand;
import com.honglinktech.zbgj.enums.AdvStyleTypeEnum;
import com.honglinktech.zbgj.enums.GoodsStatusEnum;
import com.honglinktech.zbgj.service.*;
import com.honglinktech.zbgj.vo.GoodsVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("goods")
public class GoodsController extends BaseController {

	@Resource
	private GoodsService goodsService;
	@Resource
	private GoodsTypeService goodsTypeService;
	@Resource
	private GoodsDisService goodsDisService;
	@Resource
	private GoodsTagService goodsTagService;
	@Resource
	private GoodsActivityService goodsActivityService;
	@Resource
	private GoodsBrandService goodsBrandService;

	/**
	 * 分页查询订单
	 *
	 * @param status 订单状态
	 * @param type   销售方式
	 * @param keyword    关键字
	 * @param index  分页页数
	 * @param size   分页大小
	 * @param model
	 * @return
	 */
	@RequiresPermissions("goods:search")
	@RequestMapping("/list")
	public String search(@RequestParam(required = false) Integer status,
						 @RequestParam(required = false) Integer type,
						 @RequestParam(required = false) String keyword,
						 @RequestParam(required = false, defaultValue = "1") int index,
						 @RequestParam(required = false, defaultValue = "15") int size, Model model) {

		Map whereMap = new HashMap();
		String url = "list.html?";
		if (!StringUtils.isEmpty(keyword)) {
			whereMap.put("keyword", keyword);
			url+=("keyword="+keyword+"&");
		}
		if (status != null && status != 0) {
			whereMap.put("status", status);
			url+=("status="+status+"&");
		}
		if (!StringUtils.isEmpty(type)) {
			whereMap.put("type", type);
			url+=("type="+type+"&");
		}
		int start = (index - 1) * size;
		whereMap.put("start", start);
		whereMap.put("rows", size);


		Page<GoodsBean> page = goodsService.findGoodsBeanPage(whereMap, url);
		model.addAttribute("page", page);
		model.addAttribute("status", status);
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);

		List<CV> goodsStatusList = new ArrayList<CV>();
		for(GoodsStatusEnum a: GoodsStatusEnum.values()) {
			goodsStatusList.add(new CV(a.getCode(), a.getName()));
		}
		model.addAttribute("goodsStatusList", goodsStatusList);

		return "goods/list";
	}
	/**
	 * 添加
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		Response<List<GoodsTagBean>> tagResp = goodsTagService.findAllByGoodsId(null);
		model.addAttribute("tags", tagResp.getResult());
		Response<List<ActivityBean>> actResp = goodsActivityService.findAllByGoodsId(null);
		model.addAttribute("activitys", actResp.getResult());
		Response<List<GoodsBrand>> brandResp = goodsBrandService.findAll();
		model.addAttribute("brands", brandResp.getResult());
		Response<List<GoodsTypeBean>> typeResp = goodsTypeService.findAll();
		model.addAttribute("types", typeResp.getResult());

		List<CV> goodsStatusList = new ArrayList<CV>();
		for(GoodsStatusEnum a: GoodsStatusEnum.values()) {
			goodsStatusList.add(new CV(a.getCode(), a.getName()));
		}
		model.addAttribute("goodsStatusList", goodsStatusList);

		return "goods/form";
	}
	/**
	 * 商品详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("goods:update")
	@RequestMapping("/modify")
	public String modify(@RequestParam(required = false) Integer id, Model model) {

		Response<GoodsBean> goodsBeanResponse = goodsService.findGoodsBeanById(id);
		if(goodsBeanResponse.getCode() == 0){
			GoodsBean goodsBean = goodsBeanResponse.getResult();
			model.addAttribute("item", goodsBeanResponse.getResult());
			Response<List<GoodsTagBean>> tagResp = goodsTagService.findAllByGoodsId(goodsBean.getId());
			model.addAttribute("tags", tagResp.getResult());
			Response<List<ActivityBean>> actResp = goodsActivityService.findAllByGoodsId(goodsBean.getId());
			model.addAttribute("activitys", actResp.getResult());
			Response<List<GoodsBrand>> brandResp = goodsBrandService.findAll();
			model.addAttribute("brands", brandResp.getResult());
			Response<List<GoodsTypeBean>> typeResp = goodsTypeService.findAll();
			model.addAttribute("types", typeResp.getResult());
		}else{
			addError(model, goodsBeanResponse.getMsg());
		}

		List<CV> goodsStatusList = new ArrayList<CV>();
		for(GoodsStatusEnum a: GoodsStatusEnum.values()) {
			goodsStatusList.add(new CV(a.getCode(), a.getName()));
		}
		model.addAttribute("goodsStatusList", goodsStatusList);

		return "goods/form";
	}

	/**
	 * 保存或者修改商品
	 * @param goodsBean
	 * @param model
	 * @return
	 */
	@RequiresPermissions("goods:save")
	@RequestMapping("/save")
	@ResponseBody
	public Response save(GoodsBean goodsBean, Model model)  {
		try {
			String[] activityIds = request.getParameterValues("activityIds");
			String[] tagIds = request.getParameterValues("tagIds");
			String[] picUrl = request.getParameterValues("picUrl");
			Integer[] goodsActivityIds = null;
			Integer[] goodsTagIds = null;
			if(activityIds != null && activityIds.length > 0){
				goodsActivityIds = new Integer[activityIds.length];
				for(int i=0;i<activityIds.length;i++){
					goodsActivityIds[i] = Integer.valueOf(activityIds[i]);
				}
			}
			if(tagIds != null && tagIds.length > 0){
				goodsTagIds = new Integer[tagIds.length];
				for(int i=0;i<tagIds.length;i++){
					goodsTagIds[i] = Integer.valueOf(tagIds[i]);
				}
			}

			//款式处理
			List<Format> formatList = new ArrayList<Format>();//样式
			String[] formatFlagIds = request.getParameterValues("formatFlagIds");
			if(formatFlagIds!=null && formatFlagIds.length>0){
				for(int i=0;i<formatFlagIds.length;i++){
					String formatFlagId = formatFlagIds[i];
					if(!StringUtils.isEmpty(formatFlagId)){
						Format proItemFormat = new Format();
						List<FormatSub> formatSubs = new ArrayList<FormatSub>();

						String formatId = request.getParameter("formatIds_"+formatFlagId);
						String formatName = request.getParameter("formatName_"+formatFlagId);
						String needFee = request.getParameter("needValue_"+formatFlagId);
						String type = request.getParameter("type_"+formatFlagId);
						String[] formatSubFlagIds = request.getParameterValues("formatSubFlagId_"+formatFlagId);

						System.out.println("*formatFlagId:"+formatFlagId);
						System.out.println("formatIds_"+formatFlagId+"|formatIds:"+formatId);
						System.out.println("formatName_"+formatFlagId+"|formatName:"+formatName);
						System.out.println("needFee_"+formatFlagId+"|needFee:"+needFee);
						System.out.println("type_"+formatFlagId+"|type:"+type);
						System.out.println("--------------------------------");
						if(formatSubFlagIds != null && formatSubFlagIds.length > 0){
							for(int j=0; j<formatSubFlagIds.length;j++){
								String formatSubFlagId = formatSubFlagIds[j];
								String formatSubId = request.getParameter("formatSubIds_"+formatFlagId+"_"+formatSubFlagId);
								String formatSubName = request.getParameter("formatSubName_"+formatFlagId+"_"+formatSubFlagId);
								String formatSubSelect = request.getParameter("select_"+formatFlagId+"_"+formatSubFlagId);
								String formatSubFee = request.getParameter("price_"+formatFlagId+"_"+formatSubFlagId);
								String formatSubVipFee = request.getParameter("vipPrice_"+formatFlagId+"_"+formatSubFlagId);
								String[] relyFormatSubIds = request.getParameterValues("relyFormatSubId_"+formatFlagId+"_"+formatSubFlagId);

								FormatSub formatSub = new FormatSub();
//								formatSub.setFormatSubFalg(formatSubFlagId);
								formatSub.setId(StringUtils.isEmpty(formatSubId)?null:Integer.valueOf(formatSubId));
								formatSub.setName(formatSubName);
								formatSub.setSelect(Integer.valueOf(formatSubSelect));
								formatSub.setPrice(new BigDecimal(StringUtils.isEmpty(formatSubFee)?"0":formatSubFee));
								formatSub.setVipPrice(new BigDecimal(StringUtils.isEmpty(formatSubVipFee)?"0":formatSubVipFee));
								if(relyFormatSubIds != null){
									List<Integer> relyIds = new ArrayList<Integer>();
									for(String relyId:relyFormatSubIds){
										relyIds.add(Integer.valueOf(relyId));
									}
//									formatSub.setRelyFormatSubIds(relyIds);
								}
								formatSubs.add(formatSub);
							}
						}
						System.out.println("*************************************************************");
						proItemFormat.setId(StringUtils.isEmpty(formatId)?null:Integer.valueOf(formatId));
						proItemFormat.setName(formatName);
						proItemFormat.setNeedPrice(Integer.valueOf(needFee));
						proItemFormat.setFormatSubs(formatSubs);
//						proItemFormat.setType(Integer.valueOf(type));
						formatList.add(proItemFormat);
					}
				}
			}

			return goodsService.saveGoods(goodsBean, null, null, null);
		}catch (Exception e){
			logger.error(e, e);
		}
		return Result.fail("系统错误联系工作人员！");
	}
	
}