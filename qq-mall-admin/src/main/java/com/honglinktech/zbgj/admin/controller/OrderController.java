package com.honglinktech.zbgj.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.honglinktech.zbgj.bean.OrderDetailBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.Address;
import com.honglinktech.zbgj.entity.Order;
import com.honglinktech.zbgj.entity.OrderAddressItem;
import com.honglinktech.zbgj.service.AddressService;
import com.honglinktech.zbgj.service.OrderService;

/**
 * 订单接口控制器
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private AddressService addressService;
    
    /**
     * 分页查询订单
     *
     * @param status 订单状态
     * @param type   销售方式
     * @param pickup 取货方式
     * @param key    关键字
     * @param index  分页页数
     * @param size   分页大小
     * @param model
     * @return
     */
    @RequiresPermissions("order/search")
    @RequestMapping("/list")
    public String search(@RequestParam(required = false) Integer status,
                         @RequestParam(required = false) Integer type,
                         @RequestParam(required = false) Integer addressType,
                         @RequestParam(required = false) Integer pickup,
                         @RequestParam(required = false) String key,
                         @RequestParam(required = false, defaultValue = "1") int index,
                         @RequestParam(required = false, defaultValue = "15") int size, Model model) {
	        int start = (index - 1) * size;
	        StringBuffer sb = new StringBuffer("list.html?");
	        if (status != null) {
	            if (status == 0) {
	                status = null;
	            } else {
	                sb.append("status=").append(status).append("&");
	            }
	        }
	        if (type != null) {
	            if (type == 0) {
	                type = null;
	            } else {
	                sb.append("type=").append(type).append("&");
	            }
	        }
	        if (addressType != null) {
	            if (addressType == 0) {
	            	addressType = null;
	            } else {
	                sb.append("addressType=").append(addressType).append("&");
	            }
	        }
	        if (pickup != null) {
	            if (pickup == 0) {
	                pickup = null;
	            } else {
	                sb.append("pickup=").append(pickup).append("&");
	            }
	        }
	        if (key != null && !key.isEmpty()) {
	            sb.append("key=").append(key).append("&");
	        }
	        Page<Order> page = orderService.selectOrder(status, type, addressType, pickup, key, start, size, sb.toString());
	        model.addAttribute("page", page);
	        model.addAttribute("status", status);
	        model.addAttribute("type", type);
	        model.addAttribute("addressType", addressType);
	        model.addAttribute("pickup", pickup);
	        model.addAttribute("key", key);
	        return "order/list";
    }
    /**
	   * 订单详情
	   * @param orderId
	   * @param model
	   * @return
	   */
    @RequiresPermissions("order/search")
    @RequestMapping("/detail")
    public String orderDetail(@RequestParam(required = false) String orderId, Model model) {
	    	Response<OrderDetailBean> orderDetailBean = orderService.selectOrderDetail(orderId);
	    	Response<List<Address>> respAddress= addressService.selectAddressByUserId(orderDetailBean.getResult().getUserId());
	    	model.addAttribute("addressList", respAddress.getResult());
	    	model.addAttribute("order", orderDetailBean.getResult());
	        return "order/detail";
    }
    /**
	   * 添加订单地址
	   * @param orderId
	   * @param model
	   * @return
	   */
	 @RequiresPermissions("order/insert")
	 @RequestMapping("/orderAddress")
	 public String orderAddAddress(@RequestParam(required = false) String orderId,@RequestParam(required = false) int[] addressIds, Model model) {
		 try{
			 if(StringUtils.isEmpty(orderId)){
				 addError(model, "订单Id不能为空");
				 return "redirect:list.html";
			 }
			 if(addressIds==null || addressIds.length==0){
				 addError(model, "地址不能为空");
				 return "redirect:detail.html?orderId="+orderId;
			 }
			
			 int count = orderService.insertOrderAddress(orderId, addressIds);
			 if(count>0){
				 addMessage(model, "添加地址成功"); 
			 }
		 }catch(Exception e){
			 addError(model, e.getMessage());
		 }
		 return "redirect:detail.html?orderId="+orderId;
	 }
	  /**
	   * 删除订单地址
	   * @param orderId
	   * @param model
	   * @return
	   */
	 @RequiresPermissions("order/update")
	 @RequestMapping("/deleteOrderAddress")
	 public String deleteOrderAddAddress(@RequestParam(required = false) String orderId,@RequestParam(required = false) int addressId, Model model) {
		 try{
			 if(StringUtils.isEmpty(orderId)){
				 addError(model, "订单Id不能为空");
				 return "redirect:detail.html?orderId="+orderId;
			 }
			 if(addressId<=0){
				 addError(model, "地址不能为空");
				 return "redirect:detail.html?orderId="+orderId;
			 }
			 
			 int count = orderService.deleteOrderAddress(orderId, addressId);
			 if(count>0){
				 addMessage(model, "删除地址成功");
			 }else{
				 addError(model, "删除未成功");
			 }
		 }catch(Exception e){
			 addError(model, e.getMessage());
		 }
		 return "redirect:detail.html?orderId="+orderId;
	 }
	  /**
	   * 删除订单新品
	   * @param orderId
	   * @param model
	   * @return
	   */
	 @RequiresPermissions("order/update")
	 @RequestMapping("/deleteOrderItem")
	 public String deleteOrderItem(@RequestParam(required = false) String orderId,@RequestParam(required = false) int itemId, Model model) {
		 try{
			 if(StringUtils.isEmpty(orderId)){
				 addError(model, "订单Id不能为空");
				 return "redirect:list.html";
			 }
			 if(itemId<=0){
				 addError(model, "单品Id不能为空");
				 return "redirect:detail.html?orderId="+orderId;
			 }
			 addMessage(model, "删除单品成功");
			 Response<Integer> resp = orderService.deleteOrderItem(orderId, itemId);
			 if(resp.getResult()>0){
				 addMessage(model, "删除单品成功");
			 }else{
				 addError(model, "删除单品失败");
			 }
		 }catch(Exception e){
			 addError(model, e.getMessage());
		 }
		 return "redirect:detail.html?orderId="+orderId;
	 }
	 
    /**
	   * 提交订单
	   * @param model
	   * @return
	   */
	@RequiresPermissions("order/update")
	@RequestMapping("/commitOrder")
	public String commitOrder(Order order, Model model) {
		
		try {
			if(order.getFee()==null){
				addError(model, "总工费不能为空");
				return "redirect:detail.html?orderId="+order.getId();
			}
			if(order.getMoney()==null){
				addError(model, "总价格不能为空");
				return "redirect:detail.html?orderId="+order.getId();
			}
			if(order.getMoney()==null){
				addError(model, "总价格不能为空");
				return "redirect:detail.html?orderId="+order.getId();
			}
			if(order.getPayFilePath()==null){
				addError(model, "订单支付指引不能为空");
				return "redirect:detail.html?orderId="+order.getId();
			}
			
			List<OrderAddressItem> orderAddressItems = new ArrayList<OrderAddressItem>();
			String[] orderAddressIds = request.getParameterValues("orderAddressIds");
			if(orderAddressIds!=null){
				for(String orderAddressId:orderAddressIds){
					String[] orderItemIds = request.getParameterValues("orderItemId_"+orderAddressId);
					if(orderItemIds!=null){
						for(String orderItemId:orderItemIds){
							String orderItemNum = request.getParameter("orderItemNum_"+orderAddressId+"_"+orderItemId);
							OrderAddressItem oai = new OrderAddressItem();
							oai.setOrderId(order.getId());
							oai.setOrderAddressId(Integer.valueOf(orderAddressId));
							oai.setOrderItemId(Integer.valueOf(orderItemId));
							oai.setNumber(Integer.valueOf(orderItemNum));
							orderAddressItems.add(oai);
						}
					}else{
						addError(model, "订单新品不能为空");
						return "redirect:detail.html?orderId="+order.getId();
					}
				}
			}else{
				addError(model, "订单地址不能为空");
				return "redirect:detail.html?orderId="+order.getId();
			}
			
			Response<String> res = orderService.updateCommitOrder(order, orderAddressItems);
			addMessage(model, res.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, e.getMessage());
		}
	    return "redirect:detail.html?orderId="+order.getId();
	}
	
	  /**
	   * 完成订单
	   * @param model
	   * @return
	   */
	@RequiresPermissions("order/update")
	@RequestMapping("/complateOrder")
	public String complateOrder(Order order, Model model) {
		
		try {
			if(order.getFee()==null){
				addError(model, "总工费不能为空");
				return "redirect:detail.html?orderId="+order.getId();
			}
			if(order.getMoney()==null){
				addError(model, "总价格不能为空");
				return "redirect:detail.html?orderId="+order.getId();
			}
			if(order.getMoney()==null){
				addError(model, "总价格不能为空");
				return "redirect:detail.html?orderId="+order.getId();
			}
			if(order.getPayFilePath()==null){
				addError(model, "订单支付指引不能为空");
				return "redirect:detail.html?orderId="+order.getId();
			}
			List<OrderAddressItem> orderAddressItems = new ArrayList<OrderAddressItem>();
			String[] orderAddressIds = request.getParameterValues("orderAddressIds");
			if(orderAddressIds!=null){
				for(String orderAddressId:orderAddressIds){
					String[] orderItemIds = request.getParameterValues("orderItemId_"+orderAddressId);
					if(orderItemIds!=null){
						for(String orderItemId:orderItemIds){
							String orderItemNum = request.getParameter("orderItemNum_"+orderAddressId+"_"+orderItemId);
							OrderAddressItem oai = new OrderAddressItem();
							oai.setOrderId(order.getId());
							oai.setOrderAddressId(Integer.valueOf(orderAddressId));
							oai.setOrderItemId(Integer.valueOf(orderItemId));
							oai.setNumber(Integer.valueOf(orderItemNum));
							orderAddressItems.add(oai);
						}
					}else{
						addError(model, "订单新品不能为空");
						return "redirect:detail.html?orderId="+order.getId();
					}
				}
			}else{
				addError(model, "订单地址不能为空");
			}
			
			Response<String> resp = orderService.updateCompleteOrder(order, orderAddressItems);
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(model, "完成订单失败");
		}
	    return "redirect:list.html";
	}
	  /**
	   * 保存编辑订单
	   * @param model
	   * @return
	   */
	@RequiresPermissions("order/update")
	@RequestMapping("/saveOrder")
	public String saveOrder(Order order, Model model) {
		
		try {
			
			List<OrderAddressItem> orderAddressItems = new ArrayList<OrderAddressItem>();
			String[] orderAddressIds = request.getParameterValues("orderAddressIds");
			if(orderAddressIds!=null){
				for(String orderAddressId:orderAddressIds){
					String[] orderItemIds = request.getParameterValues("orderItemId_"+orderAddressId);
					if(orderItemIds!=null){
						for(String orderItemId:orderItemIds){
							String orderItemNum = request.getParameter("orderItemNum_"+orderAddressId+"_"+orderItemId);
							OrderAddressItem oai = new OrderAddressItem();
							oai.setOrderId(order.getId());
							oai.setOrderAddressId(Integer.valueOf(orderAddressId));
							oai.setOrderItemId(Integer.valueOf(orderItemId));
							oai.setNumber(Integer.valueOf(orderItemNum));
							orderAddressItems.add(oai);
						}
					}else{
//						addError(model, "订单新品不能为空");
//						return "redirect:detail.html?orderId="+order.getId();
					}
				}
			}else{
				addError(model, "订单地址不能为空");
			}
			
			Response<String> resp = orderService.saveOrder(order, orderAddressItems);
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(model, "完成订单失败");
		}
		return "redirect:detail.html?orderId="+order.getId();
	}
	  /**
	   * 取消订单
	   * @param model
	   * @return
	   */
	@RequiresPermissions("order/delete")
	@RequestMapping("/cancelOrder")
	public String cancelOrder(Order order, Model model) {
		
		try {
			if(StringUtils.isEmpty(order.getId())){
				addError(model, "订单ID不能为空");
				return "redirect:list.html";
			}
			if(order.getUserId()==null || order.getUserId()==0){
				addError(model, "用户Id不能为空");
				return "redirect:detail.html?orderId="+order.getId();
			}
			
			Response<String> resp = orderService.updateCancelOrder(order.getId());
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(model, "完成订单失败");
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
    public Response<Long> checkNewOrder() {
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
				            @RequestParam(required = false) Integer addressType,
				            @RequestParam(required = false) String key,
				            @RequestParam(required = false, defaultValue = "1") int index,
				            @RequestParam(required = false, defaultValue = "15") int size, HttpServletResponse response) {
    	int start = (index - 1) * size;
        StringBuffer sb = new StringBuffer("list.html?");
        if (status != null) {
            if (status == 0) {
                status = null;
            } else {
                sb.append("status=").append(status).append("&");
            }
        }
        if (type != null) {
            if (type == 0) {
                type = null;
            } else {
                sb.append("type=").append(type).append("&");
            }
        }
        if (addressType != null) {
            if (addressType == 0) {
            	addressType = null;
            } else {
                sb.append("addressType=").append(addressType).append("&");
            }
        }
        if (type != null) {
            if (type == 0) {
            	type = null;
            } else {
                sb.append("type=").append(type).append("&");
            }
        }
        if (key != null && !key.isEmpty()) {
            sb.append("key=").append(key).append("&");
        }
        try {
            byte[] bytes = orderService.exportOrder(status, type, addressType, type, key, response);
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
