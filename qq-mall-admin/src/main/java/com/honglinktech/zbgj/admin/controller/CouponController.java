package com.honglinktech.zbgj.admin.controller;


import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.bean.CouponBean;
import com.honglinktech.zbgj.bean.CouponUserBean;
import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Coupon;
import com.honglinktech.zbgj.entity.Gactivity;
import com.honglinktech.zbgj.service.CouponService;
import com.honglinktech.zbgj.service.GoodsActivityService;
import com.honglinktech.zbgj.service.GoodsTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 优惠券
 */
@RestController
@RequestMapping("coupon")
public class CouponController extends BaseController {

	@Resource
	private CouponService couponService;
	@Resource
	private GoodsTypeService goodsTypeService;

	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	/**
	 * 分页查询
	 * @param keyword    关键字
	 * @param index  分页页数
	 * @param size   分页大小
	 * @param model
	 * @return
	 */
	@RequiresPermissions("coupon:search")
	@RequestMapping("/list")
	public String search(@RequestParam(required = false) String keyword,
						 @RequestParam(required = false, defaultValue = "1") int index,
						 @RequestParam(required = false, defaultValue = "15") int size, Model model) {

		Map whereMap = new HashMap();
		if (!StringUtils.isEmpty(keyword)) {
			whereMap.put("keyword", keyword);
		}
		int start = (index - 1)*size;

		Page<Coupon> page = couponService.findPageByWhere(start, size, "list.html?keyword="+keyword+"&", whereMap);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		return "coupon/list";
	}

	/**
	 * 详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("coupon:search")
	@RequestMapping("/modify")
	public String modify(@RequestParam(required = false) Integer id, Model model) {

		Response<Coupon>  itemResp = couponService.findById(id);
		model.addAttribute("item", itemResp.getResult());
		Response<List<GoodsTypeBean>> goodsTypeResp= goodsTypeService.findGoodsTypeAll();
		model.addAttribute("goodsTypes", goodsTypeResp.getResult());
		return "coupon/form";
	}
	/**
	 * 添加
	 * @param model
	 * @return
	 */
	@RequiresPermissions("coupon:add")
	@RequestMapping("/add")
	public String add(Model model) {
		Response<List<GoodsTypeBean>> goodsTypeResp= goodsTypeService.findGoodsTypeAll();
		model.addAttribute("goodsTypes", goodsTypeResp.getResult());
		return "coupon/form";
	}
	/**
	 * 保存或者修改商品
	 * @param model
	 * @return
	 */
	@RequiresPermissions("coupon:save")
	@RequestMapping("/save")
	public String save(Coupon coupon, Model model)  {
		String startTimeTime = request.getParameter("startTimeTime");
		String endTimeTime = request.getParameter("endTimeTime");
		try {
			if(!StringUtils.isEmpty(startTimeTime)){
				coupon.setStartDate(sdf.parse(startTimeTime));
			}
			if(!StringUtils.isEmpty(endTimeTime)){
				coupon.setEndDate(sdf.parse(endTimeTime));
			}
			Response<Coupon> itemResp = couponService.saveOrUpdate(coupon);
			Coupon item = itemResp.getResult();
			return "redirect:modify.html?id=" + item.getId();
		}catch (Exception e){
			logger.error(e);
			model.addAttribute("error", "保存错误!");
			model.addAttribute("item", coupon);
			return "coupon/form";
		}
	}

	/**
	 * 用户优惠券列表
	 * @param keyword
	 * @param index
	 * @param size
	 * @param useTime
	 * @param status
	 * @param model
	 * @return
	 */
	@RequiresPermissions("coupon:search")
	@RequestMapping("/userConponList")
	public String searchCouponUser(@RequestParam(required = false, defaultValue = "") String keyword,
								   @RequestParam(required = false, defaultValue = "1") int index,
								   @RequestParam(required = false, defaultValue = "15") int size,
								   @RequestParam(required = false) String useTime,
								   @RequestParam(required = false) String status,
								   Model model) {
		int start = (index - 1)*size;
		Map whereMap = new HashMap();
		String url = "userConponList.html?";
		if(!StringUtils.isEmpty(keyword)){
			whereMap.put("keyword", keyword);
			url += ("keyword="+keyword+"&");
		}
		if(!StringUtils.isEmpty(useTime)){
			whereMap.put("useTime", Boolean.valueOf(useTime));
			url += ("useTime="+useTime+"&");
		}
		if(!StringUtils.isEmpty(status)){
			whereMap.put("status", Integer.valueOf(status));
			url += ("status="+status+"&");
		}
		Page<CouponUserBean>  page = couponService.findUserCouponBeanByWhere(start, size, url, whereMap);
		model.addAttribute("page", page);
		model.addAttribute("useTime", useTime);
		model.addAttribute("status", status);
		model.addAttribute("keyword", keyword);
		return "coupon/userConponList";
	}
	
}
