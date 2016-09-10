package com.honglinktech.zbgj.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.honglinktech.zbgj.bean.ShipAddressBean;
import com.honglinktech.zbgj.bean.ShipUserBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Address;
import com.honglinktech.zbgj.entity.ShipItem;
import com.honglinktech.zbgj.enums.ShipStatusEnum;
import com.honglinktech.zbgj.service.AddressService;
import com.honglinktech.zbgj.service.OrderService;
import com.honglinktech.zbgj.service.ShipOrderService;
import com.honglinktech.zbgj.service.UsersService;

/**
 * 订单接口控制器
 */
@Controller
@RequestMapping("/shipOrder")
public class ShipOrderController extends BaseController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private ShipOrderService shipOrderService;
    @Autowired
    private AddressService addressService;
    
    /**
     * 待发货列表
     * @param index  分页页数
     * @param size   分页大小
     * @param model
     * @return
     */
    @RequiresPermissions("shipOrder/search")
    @RequestMapping("/shipList")
    public String shipList(
				    	 @RequestParam(required = false, defaultValue = "") String key,				
				    	 @RequestParam(required = false, defaultValue = "1") int index,
                         @RequestParam(required = false, defaultValue = "15") int size, Model model) {
    	
    	Map<String, Object> whereMap = new HashMap<String, Object>();
    	if(!StringUtils.isEmpty(key)){
    		whereMap.put("key", key);
    	}
    	
        StringBuffer sb = new StringBuffer("shipList.html?key="+key+"&");
      
        ShipStatusEnum[] sse = new ShipStatusEnum[2];
        sse[0] = ShipStatusEnum.WaitShip;
        sse[1] = ShipStatusEnum.OrderComplete;
    	Page<ShipUserBean> page;
		try {
			page = shipOrderService.selectShipItemGroupByUser(sse ,index, size, sb.toString(), whereMap);
			model.addAttribute("page", page);
			model.addAttribute("key", key);
		} catch (Exception e) {
			addError(model, e.getMessage());
			e.printStackTrace();
		}
        return "orderShip/list";
    }
    
    /**
     * 待发货详情
     * @param model
     * @return
     */
    @RequiresPermissions("shipOrder/search")
    @RequestMapping("/shipDetail")
    public String shipDetail(@RequestParam int userId, Model model) {
		try {
			Response<List<ShipAddressBean>> resp = shipOrderService.selectShipUserBeanByUserId(userId);
			Response<List<Address>> respAddress= addressService.selectAddressByUserId(userId);
			
			Response<com.honglinktech.zbgj.entity.User> respUserData = usersService.findBasicUserDataByCode(String.valueOf(userId));
			com.honglinktech.zbgj.entity.User userData = respUserData.getResult();
			
			model.addAttribute("addressList", respAddress.getResult());
			model.addAttribute("shipAddressBeanList", resp.getResult());
			model.addAttribute("userData", userData);
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, e.getMessage());
		}
        return "orderShip/detail";
    }
    
    /**
     * update待发货
     * @param model
     * @return
     */
    @RequiresPermissions("shipOrder/update")
    @RequestMapping("/updateShipList")
    public String updateShipList(@RequestParam int userId,Model model) {

    	try {
			String[] ids = request.getParameterValues("id");
			String[] orderIds = request.getParameterValues("orderId");
			String[] numbers = request.getParameterValues("number");
			
			List<ShipItem> shipItemList = new ArrayList<ShipItem>();
			for(int i=0;i<ids.length;i++){
				ShipItem shipItem = new ShipItem();
				shipItem.setId(Integer.valueOf(ids[i]));
				shipItem.setOrderId(orderIds[i]);
				shipItem.setNumber(Integer.valueOf(numbers[i]));
				shipItemList.add(shipItem);
			}
			Response<String> resp = shipOrderService.updateShipList(shipItemList);
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, e.getMessage());
		}
        return "redirect:shipDetail.html?userId="+userId;
    }
    
    /**
     * delete 待发货
     * @param model
     * @return
     */
    @RequiresPermissions("shipOrder/delete")
    @RequestMapping("/deleteShip")
    public String deleteShipList(@RequestParam int id,@RequestParam int userId,Model model) {

    	try {
    		
			Response<String> resp = shipOrderService.deleteShip(id);
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, e.getMessage());
		}
        return "redirect:shipDetail.html?userId="+userId;
    }
    
    /**
     * 添加待发货
     * @param model
     * @return
     */
    @RequiresPermissions("shipOrder/insert")
    @RequestMapping("/addShip")
    public String addShip(@RequestParam int userId,@RequestParam int shipItemId,@RequestParam int num,Model model) {
		try {
			Response<String> resp = shipOrderService.insertShip(userId, shipItemId, num);
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			addError(model, "参数错误！");
		}
        return "redirect:shipDetail.html?userId="+userId;
    }   
    
    /**
     * 导出
     * @return
     */
    @RequiresPermissions("shipOrder/search")
    @RequestMapping("/export")
    public void orderExport(@RequestParam(required = false) String key,
				            @RequestParam(required = false, defaultValue = "1") int index,
				            @RequestParam(required = false, defaultValue = "15") int size, HttpServletResponse response) {
        try {
            byte[] bytes = shipOrderService.exportShipOrder(key, response);
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
