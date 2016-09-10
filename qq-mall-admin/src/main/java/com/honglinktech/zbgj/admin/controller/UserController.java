package com.honglinktech.zbgj.admin.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
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
import com.honglinktech.zbgj.entity.Address;
import com.honglinktech.zbgj.entity.User;
import com.honglinktech.zbgj.service.AddressService;
import com.honglinktech.zbgj.service.UsersService;
import com.honglinktech.zbgj.utils.HashUtils;

/**
 * user接口控制器
 */
@Controller
@RequestMapping("/user")
@Configuration
public class UserController extends BaseController {
    @Autowired  
    private UsersService usersService;
    @Autowired
    private AddressService addressService;
    
    @Autowired  
    private Environment env;
    
    
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
    @RequiresPermissions("system:user:list")
    @RequestMapping("/list")
    public String list(@RequestParam(required = false, defaultValue = "1") int index,
            @RequestParam(required = false, defaultValue = "15") int size,Model model) {
    	
    		String mallId = env.getProperty("system.mallId");
    		int mId = StringUtils.isEmpty(mallId)?0:Integer.valueOf(mallId);
    		
    		Page<User> page = usersService.userList(mId,index, size, "user/list");
    		model.addAttribute("page", page);
	        return "user/list";
    }
    
    /**
     * 用户修改
     * @param status 订单状态
     * @param type   销售方式
     * @param pickup 取货方式
     * @param key    关键字
     * @param index  分页页数
     * @param size   分页大小
     * @param model
     * @return
     */
    @RequiresPermissions("system:user:modify")
    @RequestMapping("/modify")
    public String modify(@RequestParam(required = false) int id,@RequestParam(required = false,defaultValue="") String password, Model model) {
    	Response<User> response = usersService.findBasicUserDataByCode(String.valueOf(id));
    	if(response.getCode()==0){
    		model.addAttribute("item", response.getResult());
    	}else{
    		addError(model, response.getMsg());
    	}
    	model.addAttribute("password", password);
	    return "user/form";
    }
    
    /**
     * 保存或者修改
     * @param model
     * @return
     */
    @RequiresPermissions("system:admin:save")
    @RequestMapping("/saveOrUpdate")
    public String save(User user, Model model) {
    	
    	Response<User> response = usersService.saveOrUpdateUser(user);
    	user = response.getResult();
    	if(response.getCode()==0){
    		addMessage(model, response.getMsg());
    		model.addAttribute("item", user);
    	}else{
    		addError(model, response.getMsg());
    		model.addAttribute("item", user);
    	}
    	
    	return "redirect:modify.html?id="+user.getId();
    }
    
    /**
     * 保存或者修改
     * @param model
     * @return
     */
    @RequiresPermissions("system:user:add")
    @RequestMapping("/add")
    public String add(Model model) {
    	return "user/form";
    }
    
    /**
     * 重置密码
     * @param model
     * @return
     * @throws UnsupportedEncodingException 
     * @throws NoSuchAlgorithmException 
     */
    @RequiresPermissions("system:admin:save")
    @RequestMapping("/resetPwd")
    public String resetPwd(User user, Model model){
    	String password = "123456";
    	try {
			user.setPassword(HashUtils.encryptMD5(HashUtils.encryptMD5(password, ""), ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	Response<User> response = usersService.saveOrUpdateUser(user);
    	if(response.getCode()==0){
    		addMessage(model, response.getMsg());
    	}else{
    		addError(model, response.getMsg());
    	}
    	
    	return "redirect:modify.html?id="+user.getId()+"&password="+password;
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
    		 if(userData!=null){
    			 Response<List<Address>> respAddress= addressService.findAddressByUserId(userData.getId(),null);
    			 
    			 Map<String, Object> resp = new HashMap<String, Object>();
        		 Map<String, Object> result = new HashMap<String, Object>();
        		 result.put("user", userData);
        		 result.put("addressList", respAddress.getResult());
        		 resp.put("ResultInt", 0);
        		 resp.put("ResultString", "查询成功");
        		 resp.put("result", result);
        	     return resp;
    		 }
    	}
    	
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("ResultInt", 1);
        resp.put("ResultString", "查询失败");
        return resp;
    }
    @RequiresPermissions("system:user:modify")
    @RequestMapping("/updateUserAuthInfo")
    public String updateUserAuthInfo(@RequestParam(required = false) int id,@RequestParam(required = false,defaultValue="false") boolean active, Model model){
    	
		String mallId = env.getProperty("system.mallId");
		int mId = StringUtils.isEmpty(mallId)?0:Integer.valueOf(mallId);
    	
		Response<Integer> response;
		if(active){
			response = usersService.addUserAuthInfo(mId, id, active, "");
		}else{
			response = usersService.updateUserAuthInfo(mId, id, active, "");
		}
    	if(response.getCode() == 0){
    		addMessage(model, "操作成功");
    	}else{
    		addError(model, response.getMsg());
    	}
    	
    	return "redirect:list.html";
    }
}
