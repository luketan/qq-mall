package com.honglinktech.zbgj.admin.controller;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.bean.OrderBean;
import com.honglinktech.zbgj.bean.OrderSimpleBean;
import com.honglinktech.zbgj.common.CV;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.Order;
import com.honglinktech.zbgj.enums.GoodsStatusEnum;
import com.honglinktech.zbgj.enums.OrderPayStatusEnum;
import com.honglinktech.zbgj.enums.OrderStatusEnum;
import com.honglinktech.zbgj.enums.PaymentTypeEnum;
import com.honglinktech.zbgj.service.OrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	        Page<OrderSimpleBean> page = orderService.findOrderPage(index, size, whereMap, url);
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
	   * @param orderId
	   * @param model
	   * @return
	   */
    @RequiresPermissions("order")
    @RequestMapping("/detail")
    public String orderDetail(@RequestParam(required = false)int orderId, Model model) {
		Response<OrderBean> response = orderService.findOrderBeanById(orderId);
		logger.info("=========orderDetail========"+JSON.toJSON(response));
		if(response.getCode() == 0){
			model.addAttribute("order", response.getResult());
		}else{
			addError(model, response.getMsg());
		}


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

		return "order/detail";
    }

	/**
	 * 发货订单
	 * @param model
	 * @return
	 */
	@RequiresPermissions("order")
	@RequestMapping("/shipOrder")
	public String shipOrder(Order order, Model model) {

		try {
			if(StringUtils.isEmpty(order.getId())){
				addError(model, "订单ID不能为空");
				return "redirect:list.html";
			}
			Order upOrder = new Order();
			upOrder.setId(order.getId());
			upOrder.setExplain(order.getExplain());
			upOrder.setStatus(OrderStatusEnum.Send.getCode());
			Response<Integer> resp = orderService.updateOrder(upOrder);
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "完成订单失败");
		}
		return "redirect:list.html";
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
			Response<Integer> resp = orderService.updateOrder(upOrder);
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "完成订单失败");
		}
		return "redirect:list.html";
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
			Order upOrder = new Order();
			upOrder.setId(order.getId());
			upOrder.setExplain(order.getExplain());
			upOrder.setStatus(OrderStatusEnum.Cancel.getCode());
			Response<Integer> resp = orderService.updateOrder(upOrder);
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "取消订单失败");
		}
	    return "redirect:list.html";
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
    
}
