package com.honglinktech.zbgj.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.User;
import com.honglinktech.zbgj.entity.UserColor;
import com.honglinktech.zbgj.service.UserColorService;
import com.honglinktech.zbgj.service.UsersService;

/**
 * 特殊用户接口控制器
 */
@Controller
@RequestMapping("/userColor")
public class UserColorController extends BaseController {
    @Autowired  
    private UsersService usersService;
    @Autowired
    private UserColorService userColorService;
    
    /**
     * 分页查询订单
     * @param index  分页页数
     * @param size   分页大小
     * @param model
     * @return
     */
    @RequiresPermissions("system:userColor:search")
    @RequestMapping("/list")
    public String list(@RequestParam(required = false, defaultValue = "1") int index,
            @RequestParam(required = false, defaultValue = "15") int size,Model model) {
    	
    		Page<UserColor> page = userColorService.userColorList(index, size, "userColor/list");
    		model.addAttribute("page", page);
	        return "userColor/list";
    }
    /**
     * 添加特殊用户
     * @param model
     * @return
     */
    @RequiresPermissions("system:userColor:save")
    @RequestMapping("/saveOrDelete")
    public String saveOrDelete(@RequestParam int id,
    				   @RequestParam boolean active,
    				   Model model) {
    	
    		if(active){
    			
    			Response<UserColor> resUserColor = userColorService.findById(id);
    			if(resUserColor.getResult()!=null){
    				addError(model, "操作失败，账号已经存在!");
    				return "redirect:list.html";
    			}
    			userColorService.saveUserColor(id);
    	        
    		}else{
    			
    			userColorService.deleteUserColor(id);
    		}
    		
    		addMessage(model, "操作成功!");
	        return "redirect:list.html";
    }
    /**
     * 取消特殊用户
     * @param model
     * @return
     */
    @RequiresPermissions("system:userColor:delete")
    @RequestMapping("/delete")
    public String delete(@RequestParam int id,Model model) {
    		userColorService.deleteUserColor(id);
    		addMessage(model, "操作成功!");
	        return "redirect:list.html";
    }
    
    @RequestMapping(value = "/searchPhone", method = {RequestMethod.POST},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Object> searchPhone(HttpServletRequest request, HttpServletResponse response) {
    	String phone = request.getParameter("phone");
    	if(!StringUtils.isEmpty(phone)){
    	     Response<User> respUserData = usersService.findBasicUserDataByPhone(phone);
    	     User userData = respUserData.getResult();
			 Map<String, Object> resp = new HashMap<String, Object>();
    		 Map<String, Object> result = new HashMap<String, Object>();
    		 result.put("user", userData);
    		 resp.put("ResultInt", 0);
    		 resp.put("ResultString", "查询成功");
    		 resp.put("result", result);
    	     return resp;
    	}
    	
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("ResultInt", 1);
        resp.put("ResultString", "查询失败");
        return resp;
    }
   
}
