package com.honglinktech.zbgj.admin.controller;


import com.honglinktech.zbgj.bean.FeedBackBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Coupon;
import com.honglinktech.zbgj.entity.FeedBack;
import com.honglinktech.zbgj.service.FeedBackService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 优惠券
 */
@RestController
@RequestMapping("feedBack")
public class FeedBackController extends BaseController {

	@Resource
	private FeedBackService feedBackService;

	/**
	 * 分页查询
	 * @param keyword    关键字
	 * @param index  分页页数
	 * @param size   分页大小
	 * @param model
	 * @return
	 */
	@RequiresPermissions("feedBack:search")
	@RequestMapping("/list")
	public String search(@RequestParam(required = false, defaultValue = "") String keyword,
						 @RequestParam(required = false, defaultValue = "1") int index,
						 @RequestParam(required = false, defaultValue = "15") int size, Model model) throws Exception {

		Map whereMap = new HashMap();
		if (!StringUtils.isEmpty(keyword)) {
			whereMap.put("keyword", keyword);
		}
		Page<FeedBack> page = feedBackService.findFeedBackByWhere(index, size, "list.html?keyword="+keyword+"&", whereMap);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		return "feedBack/list";
	}

	/**
	 * 详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("feedBack:search")
	@RequestMapping("/modify")
	public String modify(@RequestParam(required = false) Integer id, Model model) throws Exception {

		Response<FeedBackBean> itemResp = feedBackService.findFeedBackById(null, id);
		model.addAttribute("item", itemResp.getResult());
		return "feedBack/form";
	}

	/**
	 * 保存或者修改商品
	 * @param model
	 * @return
	 */
	@RequiresPermissions("feedBack:update")
	@RequestMapping("/update")
	public String save(FeedBack feedBack, Model model) throws Exception {

		try {
			Response<Integer> itemResp = feedBackService.updateFeedBack(feedBack);
			if(itemResp.getResult() > 0){
				model.addAttribute("message", "保存成功!");
			}
			return "redirect:modify.html?id=" + feedBack.getId();
		}catch (Exception e){
			logger.error(e);
			model.addAttribute("error", "保存错误!");
			Response<FeedBackBean> itemResp = feedBackService.findFeedBackById(null, feedBack.getId());
			model.addAttribute("item", itemResp.getResult());
			return "feedBack/form";
		}
	}
	
}
