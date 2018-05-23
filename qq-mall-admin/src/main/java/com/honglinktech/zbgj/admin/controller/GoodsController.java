package com.honglinktech.zbgj.admin.controller;


import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.bean.GoodsBean;
import com.honglinktech.zbgj.bean.GoodsTagBean;
import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.bean.request.GoodsItem;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Goods;
import com.honglinktech.zbgj.entity.GoodsBrand;
import com.honglinktech.zbgj.service.*;
import com.honglinktech.zbgj.vo.GoodsVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
	 * @param key    关键字
	 * @param index  分页页数
	 * @param size   分页大小
	 * @param model
	 * @return
	 */
	@RequiresPermissions("goods:search")
	@RequestMapping("/list")
	public String search(@RequestParam(required = false) Integer status,
						 @RequestParam(required = false) Integer type,
						 @RequestParam(required = false) String key,
						 @RequestParam(required = false, defaultValue = "1") int index,
						 @RequestParam(required = false, defaultValue = "15") int size, Model model) {

		Map whereMap = new HashMap();
		String url = "list.html?";
		if (status != null && status != 0) {
			whereMap.put("status", status);
			url+=("status="+status+"&");
		}
		if (!StringUtils.isEmpty(key)) {
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
		model.addAttribute("key", key);
		return "goods/list";
	}
	/**
	 * 添加
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Model model) {
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

		return "goods/form";
	}

	/**
	 * 保存或者修改商品
	 * @param goods
	 * @param model
	 * @return
	 */
	@RequiresPermissions("goods:save")
	@RequestMapping("/save")
	public String save(Goods goods, Model model)  {

		GoodsItem goodsItem = new GoodsItem(goods);
		try {
			goodsService.saveGoods(goodsItem);
		}catch (Exception e){
			logger.error(e, e);
			model.addAttribute("error", "保存商品错误!");
			GoodsVO goodsVO = new GoodsVO(goods);
			model.addAttribute("item", goodsVO);
			Response<List<GoodsTagBean>> tagResp = goodsTagService.findAllByGoodsId(goodsVO.getId());
			model.addAttribute("tags", tagResp.getResult());
			Response<List<ActivityBean>> actResp = goodsActivityService.findAllByGoodsId(goodsVO.getId());
			model.addAttribute("activitys", actResp.getResult());
			Response<List<GoodsBrand>> brandResp = goodsBrandService.findAll();
			model.addAttribute("brands", brandResp.getResult());
			Response<List<GoodsTypeBean>> typeResp = goodsTypeService.findAll();
			model.addAttribute("types", typeResp.getResult());
			return "goods/form";
		}
		return "redirect:modify.html?id=" + goodsItem.getId();
	}
	
}