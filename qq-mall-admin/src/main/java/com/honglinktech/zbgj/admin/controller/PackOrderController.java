package com.honglinktech.zbgj.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

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

import com.honglinktech.zbgj.bean.ExpressDetailBean;
import com.honglinktech.zbgj.bean.PackUserBean;
import com.honglinktech.zbgj.common.ErrorCode;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.DeliveryCompany;
import com.honglinktech.zbgj.service.ExpressService;
import com.honglinktech.zbgj.service.PackOrderService;
import com.honglinktech.zbgj.service.SystemService;

/**
 * 订单接口控制器
 */
@Controller
@RequestMapping("/packOrder")
public class PackOrderController extends BaseController {
    @Autowired
    private SystemService systemService;
    @Autowired
    private ExpressService kd100ExpressService;
    @Autowired
    private PackOrderService packOrderService;
    
   
    /**
     * 订单包裹列表
     * @param index  分页页数
     * @param size   分页大小
     * @param model
     * @return
     */
    @RequiresPermissions("packOrder/search")
    @RequestMapping("/packList")
    public String packList(
    					 @RequestParam(required = false, defaultValue = "") String key,
    					 @RequestParam(required = false, defaultValue = "1") int index,
                         @RequestParam(required = false, defaultValue = "10") int size, Model model) {
    	Map<String, Object> whereMap = new HashMap<String, Object>();
    	if(!StringUtils.isEmpty(key)){
    		whereMap.put("key", key);
    	}
        StringBuffer sb = new StringBuffer("packList.html?key="+key+"&");
        Page<PackUserBean> page = packOrderService.selectUserPackList(index, size, sb.toString(), whereMap);
        model.addAttribute("page", page);
        model.addAttribute("key", key);
        return "orderPack/list";
    }
    /**
     * 订单包裹详情
     * @param model
     * @return
     */
    @RequiresPermissions("packOrder/search")
    @RequestMapping("/packDetail")
    public String packDetail(@RequestParam int userId,@RequestParam(required = false, defaultValue = "1") int index,
            @RequestParam(required = false, defaultValue = "10") int size, Model model) {
    	String pageUrl = "packDetail.html?userId="+userId+"&";
    	PackUserBean packUserBean;
		try {
			List<DeliveryCompany> deliCompList = systemService.findDeliveryCompanyAll();
			packUserBean = packOrderService.selectUserPackInfoByUserId(userId, index, size, pageUrl);
			model.addAttribute("packUserBean", packUserBean);
			model.addAttribute("deliveryCompanyList",deliCompList);
		} catch (Exception e) {
			addMessage(model, e.getMessage());
			e.printStackTrace();
		}
    	
        return "orderPack/detail";
    }
    /**
     * 生成包裹
     * @param model
     * @return
     */
    @RequiresPermissions("packOrder/insert")
    @RequestMapping("/addPackAll")
    public String addPackAll(@RequestParam int userId,
    							@RequestParam int addressId,
    							@RequestParam int[] shipItemIds,
    							@RequestParam int[] shipItemNums,
    							@RequestParam int deliveryCompanyId,
    							@RequestParam String expressNo,
    							Model model) {
    	
    	try {
    		if(deliveryCompanyId==0 || StringUtils.isEmpty(expressNo)){
    			addMessage(model, "请输入快递信息");
    			return "redirect:packDetail.html?userId="+userId;
    		}
			Response<String> resp = packOrderService.insertPackAll(userId,addressId,shipItemIds,shipItemNums,deliveryCompanyId,expressNo);
			addMessage(model, resp.getMsg());
		} catch (Exception e) {
			addMessage(model, e.getMessage());
			e.printStackTrace();
		}
    	
		return "redirect:packDetail.html?userId="+userId;
    }
    /**
     * 修改包裹快递号
     * @param model
     * @return
     */
    @RequiresPermissions("packOrder/update")
    @RequestMapping("/updateExpressNo")
    public String updateExpressNo(@RequestParam int id,
								  @RequestParam int deliveryCompanyId,
								  @RequestParam String expressNo,
								  @RequestParam int userId,
    							  Model model) { 
    	Response<String> resp = packOrderService.updatePackExpress(id,deliveryCompanyId,expressNo);
    	if(resp.getCode() == 0){
    		addMessage(model, resp.getMsg());
    	}else{
    		addError(model, resp.getMsg());
    	}
    	return "redirect:packDetail.html?userId="+userId;
    }
    /**
     * @param model
     * @return
     */
    @RequiresPermissions("packOrder/search")
    @RequestMapping(value = "/getExpressDetail", method = {RequestMethod.POST},
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object getExpressDetail(@RequestBody Map req) { 
    	 if (!req.containsKey("expressNo"))
         {
             return Result.fail(ErrorCode.PARAMETER_NOT_EMPTY_ERROR, "快递单号不能为空");
         }
         if (!req.containsKey("company"))
         {
             return Result.fail(ErrorCode.PARAMETER_NOT_EMPTY_ERROR, "快递公司编码不能为空");
         }
         Response<List<ExpressDetailBean>> response = kd100ExpressService.queryExpressDetail(req.get("expressNo").toString(), req.get("company").toString());
         return response;
    }
    
    /**
     * 导出
     * @return
     */
    @RequiresPermissions("packOrder/search")
    @RequestMapping("/export")
    public void orderExport(@RequestParam(required = false) String key,
				            @RequestParam(required = false, defaultValue = "1") int index,
				            @RequestParam(required = false, defaultValue = "15") int size, HttpServletResponse response) {
        try {
            byte[] bytes = packOrderService.exportPackOrder(key, response);
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
