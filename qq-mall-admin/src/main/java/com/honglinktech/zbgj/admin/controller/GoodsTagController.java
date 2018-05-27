package com.honglinktech.zbgj.admin.controller;


import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.bean.GoodsTagBean;
import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.bean.request.GoodsItem;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Goods;
import com.honglinktech.zbgj.entity.GoodsBrand;
import com.honglinktech.zbgj.entity.GoodsTag;
import com.honglinktech.zbgj.entity.Gtag;
import com.honglinktech.zbgj.service.GoodsActivityService;
import com.honglinktech.zbgj.service.GoodsBrandService;
import com.honglinktech.zbgj.service.GoodsDisService;
import com.honglinktech.zbgj.service.GoodsService;
import com.honglinktech.zbgj.service.GoodsTagService;
import com.honglinktech.zbgj.service.GoodsTypeService;
import com.honglinktech.zbgj.vo.GoodsVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RequestMapping("goodsTag")
public class GoodsTagController extends BaseController {

	@Resource
	private GoodsTagService goodsTagService;
	/**
	 * 分页查询
	 * @param keyword 关键字
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

		Page<Gtag> page = goodsTagService.findPageByWhere(index, size, "list.html?keyword="+keyword+"&", whereMap);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		return "goodsTag/list";
	}

	/**
	 * 详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/modify")
	public String modify(@RequestParam(required = false) Integer id, Model model) {

		Response<Gtag>  tagResp = goodsTagService.findById(id);
		model.addAttribute("item", tagResp.getResult());
		return "goodsTag/form";
	}

	/**
	 * 添加
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		return "goodsTag/form";
	}

	/**
	 * 保存或者修改商品
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	public String save(Gtag tag, Model model)  {

		try {
			Response<Gtag> tagResp = goodsTagService.saveOrUpdate(tag);
			Gtag retTag = tagResp.getResult();
			logger.info(JSON.toJSONString(tag)+"====Gtag.save============"+retTag.getId());
			return "redirect:modify.html?id=" + retTag.getId();
		}catch (Exception e){
			logger.error(e, e);
			model.addAttribute("error", "保存错误!");
			model.addAttribute("item", tag);
			return "goodsTag/form";
		}
	}
	
}
