package com.honglinktech.zbgj.admin.controller;


import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.bean.GoodsBrandBean;
import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.GoodsBrand;
import com.honglinktech.zbgj.entity.GoodsType;
import com.honglinktech.zbgj.service.GoodsBrandService;
import com.honglinktech.zbgj.service.GoodsTypeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RequestMapping("goodsBrand")
public class


GoodsBrandController extends BaseController {
	@Resource
	private GoodsBrandService goodsBrandService;
	@Resource
	private GoodsTypeService goodsTypeService;


	/**
	 * 分页查询
	 * @param keyword    关键字
	 * @param index  分页页数
	 * @param size   分页大小
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String search(
						 @RequestParam(required = false) String keyword,
						 @RequestParam(required = false, defaultValue = "1") int index,
						 @RequestParam(required = false, defaultValue = "15") int size, Model model) {

		Map whereMap = new HashMap();
		if (!StringUtils.isEmpty(keyword)) {
			whereMap.put("keyword", keyword);
		}

		Page<GoodsBrandBean> page = goodsBrandService.findPageByWhere(index, size, "list.html?keyword="+keyword+"&", whereMap);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		return "goodsBrand/list";
	}

	/**
	 * 详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/modify")
	public String modify(@RequestParam(required = false) Integer id, Model model) {

		Response<GoodsBrand>  itemResp = goodsBrandService.findById(id);
		Response<List<GoodsTypeBean>>  typeResp = goodsTypeService.findGoodsTypeAll();
		model.addAttribute("item", itemResp.getResult());
		model.addAttribute("goodsTypes", typeResp.getResult());
		return "goodsBrand/form";
	}
	/**
	 * 添加
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		Response<List<GoodsTypeBean>>  typeResp = goodsTypeService.findGoodsTypeAll();
		model.addAttribute("goodsTypes", typeResp.getResult());
		return "goodsBrand/form";
	}
	/**
	 * 保存或者修改商品
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	public String save(GoodsBrand goodsBrand, Model model)  {

		try {
			logger.info("===========goodsBrand.save=============="+ JSON.toJSONString(goodsBrand));
			Response<GoodsBrand> itemResp = goodsBrandService.saveOrUpdate(goodsBrand);
			GoodsBrand item = itemResp.getResult();
			return "redirect:modify.html?id=" + item.getId();
		}catch (Exception e){
			logger.error(e);
			model.addAttribute("error", "保存错误!");
			model.addAttribute("item", goodsBrand);
			return "goodsBrand/form";
		}
	}
	
}
