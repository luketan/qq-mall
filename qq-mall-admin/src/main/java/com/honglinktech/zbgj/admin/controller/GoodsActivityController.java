package com.honglinktech.zbgj.admin.controller;


import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Gactivity;
import com.honglinktech.zbgj.entity.Gtag;
import com.honglinktech.zbgj.service.GoodsActivityService;
import com.honglinktech.zbgj.service.GoodsTagService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("goodsActivity")
public class GoodsActivityController extends BaseController {

	@Resource
	private GoodsActivityService goodsActivityService;

	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

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

		Page<Gactivity> page = goodsActivityService.findPageByWhere(index, size, "list.html?keyword="+keyword+"&", whereMap);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		return "goodsActivity/list";
	}

	/**
	 * 详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/modify")
	public String modify(@RequestParam(required = false) Integer id, Model model) {

		Response<Gactivity>  itemResp = goodsActivityService.findById(id);
		model.addAttribute("item", itemResp.getResult());
		return "goodsActivity/form";
	}
	/**
	 * 添加
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		return "goodsActivity/form";
	}
	/**
	 * 保存或者修改商品
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	public String save(Gactivity activity, Model model)  {
		String startTimeTime = request.getParameter("startTimeTime");
		String endTimeTime = request.getParameter("endTimeTime");
		try {
			if(!StringUtils.isEmpty(startTimeTime)){
				activity.setStartTime(sdf.parse(startTimeTime));
			}
			if(!StringUtils.isEmpty(endTimeTime)){
				activity.setEndTime(sdf.parse(endTimeTime));
			}
			Response<Gactivity> itemResp = goodsActivityService.saveOrUpdate(activity);
			Gactivity item = itemResp.getResult();
			return "redirect:modify.html?id=" + item.getId();
		}catch (Exception e){
			logger.error(e);
			model.addAttribute("error", "保存错误!");
			model.addAttribute("item", activity);
			return "goodsActivity/form";
		}
	}
	
}
