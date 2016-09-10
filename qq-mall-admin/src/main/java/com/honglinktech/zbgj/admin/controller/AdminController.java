package com.honglinktech.zbgj.admin.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.old.Response;
import com.honglinktech.zbgj.entity.Admin;
import com.honglinktech.zbgj.entity.Role;
import com.honglinktech.zbgj.service.SystemService;
import com.honglinktech.zbgj.service.UsersService;
import com.honglinktech.zbgj.utils.HashUtils;

/**
 * user接口控制器
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
	@Autowired  
    private UsersService usersService;
	@Autowired
	private SystemService systemService;
    
    /**
     * 分页查询订单
     *
     * @param index  分页页数
     * @param size   分页大小
     * @param model
     * @return
     */
    @RequiresPermissions("system:admin:list")
    @RequestMapping("/list")
    public String list(@RequestParam(required = false, defaultValue = "1") int index,
                         @RequestParam(required = false, defaultValue = "15") int size, Model model) {
    	
    	Page<Admin> page = usersService.adminList(index, size, "admin/list");
		model.addAttribute("page", page);
        return "admin/list";
    }
    
    /**
     * 详情
     * @param model
     * @return
     */
    @RequiresPermissions("system:admin:list")
    @RequestMapping("/modify")
    public String modify(@RequestParam(required = false) int id,@RequestParam(required = false ,defaultValue = "") String password, Model model) {
       	List<Role> roles = systemService.findAllRole();
    	model.addAttribute("roles", roles);
    	List<Role> adminRoles = systemService.findRoleByAdminId(id);
    	model.addAttribute("adminRoles", adminRoles);

    	Response<Admin> response = usersService.findAdminById(id);
    	if(response.getCode()==0){
    		model.addAttribute("item", response.getResult());
    	}else{
    		addError(model, response.getMsg());
    		model.addAttribute("item", new Admin());
    	}
    	model.addAttribute("password", password);
        return "admin/form";
    }
    /**
     * 保存或者修改
     * @param model
     * @return
     */
    @RequiresPermissions("system:admin:save")
    @RequestMapping("/saveOrUpdate")
    public String save(Admin admin, Model model) {
    	String[] roles = request.getParameterValues("roles");
    	System.out.println(roles);
    	for(String r:roles){
    		System.err.println("r:"+r);
    	}
    	Response<Admin> response = usersService.saveOrUpdateAdmin(admin,roles);
    	admin = response.getResult();
    	if(response.getCode()==0){
    		addMessage(model, response.getMsg());
    		model.addAttribute("item", response.getResult());
    	}else{
    		addError(model, response.getMsg());
    		model.addAttribute("item", admin);
    	}
    	
    	return "redirect:modify.html?id="+admin.getId();
    }
    /**
     * 重置密码
     * @param model
     * @return
     */
    @RequiresPermissions("system:admin:save")
    @RequestMapping("/resetPwd")
    public String resetPwd(Admin admin, Model model) {
    	String password = "123456";
    	try {
			admin.setPassword(HashUtils.encryptMD5(HashUtils.encryptMD5(password, ""), ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	Response<Admin> response = usersService.saveOrUpdateAdmin(admin,null);
    	admin = response.getResult();
    	if(response.getCode()==0){
    		addMessage(model, response.getMsg());
    	}else{
    		addError(model, response.getMsg());
    	}
    	
    	return "redirect:modify.html?id="+admin.getId()+"&password="+password;
    }
    
    
    /**
     * 保存或者修改
     * @param model
     * @return
     */
    @RequiresPermissions("system:admin:add")
    @RequestMapping("/add")
    public String add(Model model) {
    	List<Role> roles = systemService.findAllRole();
    	model.addAttribute("roles", roles);
    	return "admin/form";
    }
   
    
    /**
     * 修改当前用户密码
     * @param model
     * @return
     */
    @RequiresPermissions("system:admin:update")
    @RequestMapping("/updatePwdForm")
    public String updatePwdForm( Model model){
    	
    	return "admin/updatePwd";
    }
    /**
     * 修改当前用户密码
     * @param model
     * @return
     */
    @RequiresPermissions("system:admin:update")
    @RequestMapping("/updatePwd")
    public String updatePwd(Model model){
    	
    	try {
    		Admin admin = getAdmin();
    		
    		String pwd = request.getParameter("pwd");
    		String newPwd = request.getParameter("newPwd");
    		String newPwds = request.getParameter("newPwds");
    		
    		pwd = HashUtils.encryptMD5(pwd, "");
    		Response<Admin> adminResp = usersService.adminLogin(0, admin.getLoginName(), pwd, "");
    		if(adminResp.getCode()!=0){
    			addError(model, "原密码错误！");
    			return "admin/updatePwd";
    		}
    		
    		if(StringUtils.isEmpty(newPwd)){
    			addError(model, "密码不能为空！");
    			return "admin/updatePwd";
    		}
    		if(!newPwd.equals(newPwds)){
    			addError(model, "两次输入密码不一致！");
    			return "admin/updatePwd";
    		}
    	
    		admin.setPassword(HashUtils.encryptMD5(HashUtils.encryptMD5(newPwd, ""), ""));
    		Response<Admin> respon = usersService.saveOrUpdateAdmin(admin, null);
    		if(respon.getCode()==0){
    			addMessage(model, respon.getMsg());
    		}else{
    			addError(model, respon.getMsg());
    		}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			addError(model, e.getMessage());
		}
    	
    	return "redirect:/index.html";
    }
}
