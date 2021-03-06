package com.honglinktech.zbgj.admin.controller;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.bean.OrderBean;
import com.honglinktech.zbgj.bean.OrderSimpleBean;
import com.honglinktech.zbgj.bean.PostDetailBean;
import com.honglinktech.zbgj.common.CV;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.Order;
import com.honglinktech.zbgj.entity.PostCompany;
import com.honglinktech.zbgj.enums.GoodsStatusEnum;
import com.honglinktech.zbgj.enums.OrderPayStatusEnum;
import com.honglinktech.zbgj.enums.OrderStatusEnum;
import com.honglinktech.zbgj.enums.PaymentTypeEnum;
import com.honglinktech.zbgj.service.OrderService;
import com.honglinktech.zbgj.service.PostDetailService;
import com.honglinktech.zbgj.service.PostService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 订单接口控制器
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;

	@Autowired
	private PostService postService;

	@Autowired
	private PostDetailService postDetailService;

	/**
     * 分页查询订单
     *
     * @param status 订单状态
     * @param index  分页页数
     * @param size   分页大小
     * @param model
     * @return
     */
    @RequiresPermissions("order")
    @RequestMapping("/list")
    public String search(@RequestParam(required = false) Integer status,
                         @RequestParam(required = false) Integer payStatus,
						 @RequestParam(required = false) Integer paymentId,
                         @RequestParam(required = false) String keyword,
                         @RequestParam(required = false, defaultValue = "1") int index,
                         @RequestParam(required = false, defaultValue = "15") int size, Model model) {

			Map whereMap = new HashMap();
			String url = "list.html?";
	        if (status != null && status != 0) {
				whereMap.put("status", status);
				url += ("status="+status+"&");
	        }
			if (paymentId != null && paymentId != 0) {
				whereMap.put("paymentId", paymentId);
				url += ("paymentId="+paymentId+"&");
			}
			if (payStatus != null && payStatus != 0) {
				whereMap.put("payStatus", payStatus);
				url += ("payStatus="+payStatus+"&");
			}
	        if (!StringUtils.isEmpty(keyword)) {
				whereMap.put("keyword", keyword);
				url += ("keyword="+keyword+"&");
	        }
	        int start = (index - 1)*size;

	        Page<OrderSimpleBean> page = orderService.findOrderPage(start, size, whereMap, url);
	        model.addAttribute("page", page);
	        model.addAttribute("status", status);
	        model.addAttribute("payStatus", payStatus);
			model.addAttribute("paymentId", paymentId);
	        model.addAttribute("keyword", keyword);


			List<CV> orderStatusList = new ArrayList<CV>();
			for(OrderStatusEnum a: OrderStatusEnum.values()) {
				orderStatusList.add(new CV(a.getCode(), a.getName()));
			}
			model.addAttribute("orderStatusList", orderStatusList);

			List<CV> paymentTypeList = new ArrayList<CV>();
			for(PaymentTypeEnum a: PaymentTypeEnum.values()) {
				paymentTypeList.add(new CV(a.getCode(), a.getName()));
			}
			model.addAttribute("paymentTypeList", paymentTypeList);

			List<CV> orderPayStatusList = new ArrayList<CV>();
			for(OrderPayStatusEnum a: OrderPayStatusEnum.values()) {
				orderPayStatusList.add(new CV(a.getCode(), a.getName()));
			}
			model.addAttribute("orderPayStatusList", orderPayStatusList);

	        return "order/list";
    }
    /**
	   * 订单详情
	 * , RedirectAttributes attr
	   * @param orderId
	   * @param model
	   * @return
	   */
    @RequiresPermissions("order")
    @RequestMapping("/detail")
    public String orderDetail(@RequestParam(required = false)int orderId, Model model) {
		Response<OrderBean> response = orderService.findOrderBeanById(orderId);
		if(response.getCode() == 0){
			model.addAttribute("order", response.getResult());
		}else{
			addError(model, response.getMsg());
		}


		List<CV> orderStatusList = new ArrayList<CV>();
		for(OrderStatusEnum a: OrderStatusEnum.values()) {
			orderStatusList.add(new CV(a.getCode(), a.getName()));
			model.addAttribute(a.name(), a.getCode());
		}
		model.addAttribute("orderStatusList", orderStatusList);

		List<CV> paymentTypeList = new ArrayList<CV>();
		for(PaymentTypeEnum a: PaymentTypeEnum.values()) {
			paymentTypeList.add(new CV(a.getCode(), a.getName()));
		}
		model.addAttribute("paymentTypeList", paymentTypeList);

		List<CV> orderPayStatusList = new ArrayList<CV>();
		for(OrderPayStatusEnum a: OrderPayStatusEnum.values()) {
			orderPayStatusList.add(new CV(a.getCode(), a.getName()));
		}
		model.addAttribute("orderPayStatusList", orderPayStatusList);

		//快递公司
		List<PostCompany> postCompanyList = postService.findAllPostCompany();
		model.addAttribute("postCompanyList", postCompanyList);

		return "order/detail";
    }

	/**
	 * 发货订单
	 * , RedirectAttributes attr
	 * @param model
	 * @return
	 */
	@RequiresPermissions("order")
	@RequestMapping("/shipOrder")
	public String shipOrder(Order order, Model model) {

		try {
			if(StringUtils.isEmpty(order.getId())){
				addError(model, "订单ID不能为空");
				return "redirect:detail.html?orderId="+order.getId();
			}

			if(StringUtils.isEmpty(order.getPostId())){
				addError(model, "快递公司ID不能为空");
				return "redirect:detail.html?orderId="+order.getId();
			}
			if(StringUtils.isEmpty(order.getPostCode())){
				addError(model, "快递单号不能为空");
				return "redirect:detail.html?orderId="+order.getId();
			}

			order.setStatus(OrderStatusEnum.Send.getCode());
			Response<Integer> resp = orderService.updateShipOrder(order);
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "发货失败");
		}
		return "redirect:detail.html?orderId="+order.getId();
	}
	/**
	 * 完成订单
	 * @param model
	 * @return
	 */
	@RequiresPermissions("order")
	@RequestMapping("/completeOrder")
	public String completeOrder(Order order, Model model) {

		try {
			if(StringUtils.isEmpty(order.getId())){
				addError(model, "订单ID不能为空");
				return "redirect:list.html";
			}
			Order upOrder = new Order();
			upOrder.setId(order.getId());
			upOrder.setExplain(order.getExplain());
			upOrder.setStatus(OrderStatusEnum.Complete.getCode());
			Response<Integer> resp = orderService.updateCompleteOrder(upOrder);
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "完成订单失败");
		}
		return "redirect:detail.html?orderId="+order.getId();
	}
   /**
   * 取消订单
   * @param model
   * @return
   */
	@RequiresPermissions("order")
	@RequestMapping("/cancelOrder")
	public String cancelOrder(Order order, Model model) {
		
		try {
			if(StringUtils.isEmpty(order.getId())){
				addError(model, "订单ID不能为空");
				return "redirect:list.html";
			}
			order.setStatus(OrderStatusEnum.Cancel.getCode());
			Response<Integer> resp = orderService.updateCancleOrder(order);
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "取消订单失败");
		}
	    return "redirect:detail.html?orderId="+order.getId();
	}

	/**
	 * 取消订单
	 * @param model
	 * @return
	 */
	@RequiresPermissions("order")
	@RequestMapping("/updateOrder")
	public String updateOrder(Order order, Model model) {

		try {
			if(StringUtils.isEmpty(order.getId())){
				addError(model, "订单ID不能为空");
				return "redirect:list.html";
			}
			Response<Integer> resp = orderService.updateOrder(order);
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "修改订单失败");
		}
		return "redirect:detail.html?orderId="+order.getId();
	}

	/**
	 * 删除订单
	 * @param model
	 * @return
	 */
	@RequiresPermissions("order")
	@RequestMapping("/deleteOrder")
	public String deleteOrder(Order order, Model model) {

		try {
			if(StringUtils.isEmpty(order.getId())){
				addError(model, "订单ID不能为空");
				return "redirect:list.html";
			}
			Response<Integer> resp = orderService.deleteOrder(order.getId());
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(model, "取消订单失败");
		}
		return "redirect:list.html";
	}

    /**
     * 检查新订单
     *
     * @return
     */
    @RequestMapping(value = "/count/new", method = RequestMethod.POST)
    @ResponseBody
    public Response<Integer> checkNewOrder() {
        return Result.resultSet(orderService.countNewOrder());
    }

	/**
	 * 导出订单
	 * @return
	 */
	@RequiresPermissions("order/search")
	@RequestMapping("/export")
	public void orderExport(@RequestParam(required = false) Integer status,
							@RequestParam(required = false) Integer type,
							@RequestParam(required = false) String key,
							@RequestParam(required = false, defaultValue = "1") int index,
							@RequestParam(required = false, defaultValue = "15") int size,
							HttpServletResponse response,
							Model model) {

		Map whereMap = new HashMap();
		if (status != null && status != 0) {
			whereMap.put("status", status);
		}
		if (!StringUtils.isEmpty(key)) {
			whereMap.put("type", type);
		}
		int start = (index - 1) * size;
		whereMap.put("start", start);
		whereMap.put("size", size);

		try {
			byte[] bytes = orderService.exportOrder(whereMap);
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment;filename=" + UUID.randomUUID() + ".xls");
			response.setContentLength(bytes.length);
			response.getOutputStream().write(bytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 获取快递信息
	 *
	 * @return
	 */
	@RequestMapping(value = "/getPostDetail", method = {RequestMethod.POST},
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Object getPostDetail(@RequestBody Map req) {
		if (!req.containsKey("postCode"))
		{
			return Result.fail("快递单号不能为空");
		}
		if (!req.containsKey("companyId"))
		{
			return Result.fail("快递公司Id");
		}
		Response<List<PostDetailBean>> response = postDetailService.findPostDetails(req.get("postCode").toString(), Integer.valueOf(req.get("companyId").toString()));
		return response;
	}
}
