package com.honglinktech.zbgj.admin.controller;


import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.GoodsType;
import com.honglinktech.zbgj.entity.GoodsTypeSub;
import com.honglinktech.zbgj.entity.SocietySubType;
import com.honglinktech.zbgj.entity.SocietyType;
import com.honglinktech.zbgj.service.GoodsTypeService;
import com.honglinktech.zbgj.service.SocietyTypeService;
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
@RequestMapping("societyType")
public class SocietyTypeController extends BaseController {

	@Resource
	private SocietyTypeService societyTypeService;

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
		int start = (index-1)*size;
		Page<SocietyType> page = societyTypeService.findPageByWhere(start, size, "list.html?keyword="+keyword+"&", whereMap);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		return "societyType/list";
	}
	/**
	 * 添加
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		return "societyType/form";
	}
	/**
	 * 详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/modify")
	public String modify(@RequestParam(required = false) Integer id, Model model) {

		Response<SocietyType> itemResp = societyTypeService.findById(id);
		model.addAttribute("item", itemResp.getResult());
		return "societyType/form";
	}

	/**
	 * 保存或者修改商品
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	public String save(SocietyType societyType, Model model)  {

		try {
			Response<SocietyType> itemResp = societyTypeService.saveOrUpdate(societyType);
			SocietyType item = itemResp.getResult();
			return "redirect:modify.html?id=" + item.getId();
		}catch (Exception e){
			logger.error(e, e);
			model.addAttribute("error", "保存错误!");
			model.addAttribute("item", societyType);
			return "societyType/form";
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

		Page<SocietySubType> page = societyTypeService.findSubPageByWhere(index, size, "subList.html?keyword=" + keyword + "&", whereMap);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		return "societyType/subList";
	}
	/**
	 * 详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/subModify")
	public String subModify(@RequestParam(required = false) Integer id, Model model) {

		Response<SocietySubType> societySubTypeResp = societyTypeService.findSubById(id);
		Response<List<SocietyType>> societyTypesResp= societyTypeService.findAll();
		model.addAttribute("societyTypes", societyTypesResp.getResult());
		model.addAttribute("item", societySubTypeResp.getResult());
		return "societyType/subForm";
	}

	/**
	 * 添加
	 * @param model
	 * @return
	 */
	@RequestMapping("/subAdd")
	public String subAdd(Model model) {
		Response<List<SocietyType>> societyTypesResp= societyTypeService.findAll();
		model.addAttribute("societyTypes", societyTypesResp.getResult());
		return "societyType/subForm";
	}

	/**
	 * 保存或者修改商品
	 * @param model
	 * @return
	 */
	@RequestMapping("/subSave")
	public String subSave(SocietySubType societySubType, Model model)  {

		try {
			Response<SocietySubType> societySubTypeResp = societyTypeService.saveOrUpdateSub(societySubType);
			SocietySubType retSocietySubTypeSub = societySubTypeResp.getResult();
			return "redirect:subModify.html?id=" + retSocietySubTypeSub.getId();
		}catch (Exception e){
			logger.error(e, e);
			model.addAttribute("error", "保存错误!");
			Response<List<SocietyType>> societyTypesResp= societyTypeService.findAll();
			model.addAttribute("societyTypes", societyTypesResp.getResult());
			model.addAttribute("item", societySubType);
			return "societyType/subForm";
		}
	}


	
}
