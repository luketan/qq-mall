package com.honglinktech.zbgj.admin.controller;


import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.bean.GoodsTagBean;
import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.bean.GoodsTypeSubBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.GoodsType;
import com.honglinktech.zbgj.entity.GoodsTypeSub;
import com.honglinktech.zbgj.entity.Gtag;
import com.honglinktech.zbgj.service.GoodsTagService;
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
@RequestMapping("goodsType")
public class GoodsTypeController extends BaseController {

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
	public String search(@RequestParam(required = false) String keyword,
						 @RequestParam(required = false, defaultValue = "1") int index,
						 @RequestParam(required = false, defaultValue = "15") int size, Model model) {

		Map whereMap = new HashMap();
		if (!StringUtils.isEmpty(keyword)) {
			whereMap.put("keyword", keyword);
		}

		Page<GoodsType> page = goodsTypeService.findPageByWhere(index, size, "list.html?keyword="+keyword+"&", whereMap);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		return "goodsType/list";
	}
	/**
	 * 添加
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		return "goodsType/form";
	}
	/**
	 * 详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/modify")
	public String modify(@RequestParam(required = false) Integer id, Model model) {

		Response<GoodsTypeBean> tagResp = goodsTypeService.findGoodsTypeBeanById(id);
		model.addAttribute("item", tagResp.getResult());
		return "goodsType/form";
	}

	/**
	 * 保存或者修改商品
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	public String save(GoodsType goodsType, Model model)  {

		try {
			Response<GoodsType> goodsTypeResp = goodsTypeService.saveOrUpdate(goodsType);
			GoodsType retGoodsType = goodsTypeResp.getResult();
			return "redirect:modify.html?id=" + retGoodsType.getId();
		}catch (Exception e){
			logger.error(e);
			model.addAttribute("error", "保存错误!");
			model.addAttribute("item", goodsType);
			return "goodsType/form";
		}
	}

	/**
	 * 分页查询
	 * @param keyword    关键字
	 * @param index  分页页数
	 * @param size   分页大小
	 * @param model
	 * @return
	 */
	@RequestMapping("/subList")
	public String subSearch(@RequestParam(required = false) String keyword,
						 @RequestParam(required = false, defaultValue = "1") int index,
						 @RequestParam(required = false, defaultValue = "15") int size, Model model) {

		Map whereMap = new HashMap();
		if (!StringUtils.isEmpty(keyword)) {
			whereMap.put("keyword", keyword);
		}

		Page<GoodsTypeSubBean> page = goodsTypeService.findSubPageByWhere(index, size, "subList.html?keyword=" + keyword + "&", whereMap);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		return "goodsType/subList";
	}
	/**
	 * 详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/subModify")
	public String subModify(@RequestParam(required = false) Integer id, Model model) {

		Response<GoodsTypeSub> goodsTypeSubResp = goodsTypeService.findSubById(id);
		logger.info(id+"=====id================"+ JSON.toJSON(goodsTypeSubResp));
		Response<List<GoodsTypeBean>> goodsTypeResp= goodsTypeService.findGoodsTypeAll();
		model.addAttribute("goodsTypes", goodsTypeResp.getResult());
		model.addAttribute("item", goodsTypeSubResp.getResult());
		return "goodsType/subForm";
	}

	/**
	 * 添加
	 * @param model
	 * @return
	 */
	@RequestMapping("/subAdd")
	public String subAdd(Model model) {
		Response<List<GoodsTypeBean>> goodsTypeResp= goodsTypeService.findGoodsTypeAll();
		model.addAttribute("goodsTypes", goodsTypeResp.getResult());
		return "goodsType/subForm";
	}

	/**
	 * 保存或者修改商品
	 * @param model
	 * @return
	 */
	@RequestMapping("/subSave")
	public String subSave(GoodsTypeSub goodsTypeSub, Model model)  {

		try {
			Response<GoodsTypeSub> goodsTypeSubResp = goodsTypeService.saveOrUpdateSub(goodsTypeSub);
			GoodsTypeSub retGoodsTypeSub = goodsTypeSubResp.getResult();
			return "redirect:subModify.html?id=" + retGoodsTypeSub.getId();
		}catch (Exception e){
			logger.error(e);
			model.addAttribute("error", "保存错误!");
			model.addAttribute("item", goodsTypeSub);
			return "goodsType/subForm";
		}
	}


	
}
