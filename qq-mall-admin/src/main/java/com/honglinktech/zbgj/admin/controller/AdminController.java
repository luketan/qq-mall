package com.honglinktech.zbgj.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.dao.CAdminRoleDao;
import com.honglinktech.zbgj.dao.helper.QueryHelper;
import com.honglinktech.zbgj.entity.CAdmin;
import com.honglinktech.zbgj.entity.CAdminRole;
import com.honglinktech.zbgj.entity.CRole;
import com.honglinktech.zbgj.service.CAdminRoleService;
import com.honglinktech.zbgj.service.CAdminService;
import com.honglinktech.zbgj.service.CRoleService;
import com.honglinktech.zbgj.utils.HashUtils;

/**
 * user接口控制器
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
	@Autowired  
	private CAdminService cadminService;
	@Autowired  
	private CRoleService croleService;
	@Autowired  
	private CAdminRoleService cadminRoleService;
    
    /**
     * 分页查询订单
     *
     * @param index  分页页数
     * @param size   分页大小
     * @param model
     * @return
     * @throws BaseException 
     */
    @RequiresPermissions("admin:list")
    @RequestMapping("/list")
    public String list(@RequestParam(required = false, defaultValue = "1") int index,
                         @RequestParam(required = false, defaultValue = "15") int size, Model model) throws BaseException {
    	
    	QueryHelper<CAdmin> qhAdmin= cadminService.findByQueryHelper(new QueryHelper<CAdmin>(index, size, ""));
    	Page<CAdmin> page = new Page<CAdmin>((qhAdmin.getIndex()-1)*qhAdmin.getSize(), qhAdmin.getSize(), qhAdmin.getTotalRow(), "admin/list", qhAdmin.getResultList());
		model.addAttribute("page", page);
        return "admin/list";
    }
    
    /**
     * 详情
     * @param model
     * @return
     * @throws BaseException 
     */
    @RequiresPermissions("admin:list")
    @RequestMapping("/modify")
    public String modify(@RequestParam(required = false) int id,@RequestParam(required = false ,defaultValue = "") String password, Model model) throws BaseException {
       	List<CRole> roles = croleService.findAll();
    	model.addAttribute("roles", roles);
    	Map<String,String[]> adminRoleMap = new HashMap<String, String[]>();
    	adminRoleMap.put(CAdminRoleDao.DBMaping.adminId.getDbName(), new String[]{id+""});
    	List<CAdminRole> adminRoles = cadminRoleService.findByWhere(adminRoleMap);
    	model.addAttribute("adminRoles", adminRoles);
    	CAdmin cadmin = cadminService.findById(id);
    	model.addAttribute("item", cadmin);
    	model.addAttribute("password", password);
        return "admin/form";
    }
    /**
     * 保存或者修改
     * @param model
     * @return
     */
    @RequiresPermissions("admin:save")
    @RequestMapping("/saveOrUpdate")
    public String save(CAdmin admin, Model model) {
    	String[] roles = request.getParameterValues("roles");
    	System.out.println(roles);
    	for(String r:roles){
    		System.err.println("r:"+r);
    	}
//    	Response<CAdmin> response = usersService.saveOrUpdateAdmin(admin,roles);
//    	admin = response.getResult();
//    	if(response.getCode()==0){
//    		addMessage(model, response.getMsg());
//    		model.addAttribute("item", response.getResult());
//    	}else{
//    		addError(model, response.getMsg());
//    		model.addAttribute("item", admin);
//    	}
    	
    	return "redirect:modify.html?id="+admin.getId();
    }
    /**
     * 重置密码
     * @param model
     * @return
     */
    @RequiresPermissions("admin:save")
    @RequestMapping("/resetPwd")
    public String resetPwd(CAdmin admin, Model model) {
    	String password = "123456";
    	try {
			admin.setPassword(HashUtils.encryptMD5(HashUtils.encryptMD5(password, ""), ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
//    	Response<CAdmin> response = usersService.saveOrUpdateAdmin(admin,null);
//    	admin = response.getResult();
//    	if(response.getCode()==0){
//    		addMessage(model, response.getMsg());
//    	}else{
//    		addError(model, response.getMsg());
//    	}
    	
    	return "redirect:modify.html?id="+admin.getId()+"&password="+password;
    }
    
    
    /**
     * 保存或者修改
     * @param model
     * @return
     * @throws BaseException 
     */
    @RequiresPermissions("admin:add")
    @RequestMapping("/add")
    public String add(Model model) throws BaseException {
    	List<CRole> roles = croleService.findAll();
    	model.addAttribute("roles", roles);
    	return "admin/form";
    }
   
    
    /**
     * 修改当前用户密码
     * @param model
     * @return
     */
    @RequiresPermissions("admin:update")
    @RequestMapping("/updatePwdForm")
    public String updatePwdForm( Model model){
    	
    	return "admin/updatePwd";
    }
    /**
     * 修改当前用户密码
     * @param model
     * @return
     */
    @RequiresPermissions("admin:update")
    @RequestMapping("/updatePwd")
    public String updatePwd(Model model){
    	
    	try {
    		CAdmin admin = getAdmin();
    		
    		String pwd = request.getParameter("pwd");
    		String newPwd = request.getParameter("newPwd");
    		String newPwds = request.getParameter("newPwds");
    		
    		pwd = HashUtils.encryptMD5(pwd, "");
//    		Response<Admin> adminResp = usersService.adminLogin(0, admin.getLoginName(), pwd, "");
//    		if(adminResp.getCode()!=0){
//    			addError(model, "原密码错误！");
//    			return "admin/updatePwd";
//    		}
    		
    		if(StringUtils.isEmpty(newPwd)){
    			addError(model, "密码不能为空！");
    			return "admin/updatePwd";
    		}
    		if(!newPwd.equals(newPwds)){
    			addError(model, "两次输入密码不一致！");
    			return "admin/updatePwd";
    		}
    	
    		admin.setPassword(HashUtils.encryptMD5(HashUtils.encryptMD5(newPwd, ""), ""));
//    		Response<Admin> respon = usersService.saveOrUpdateAdmin(admin, null);
//    		if(respon.getCode()==0){
//    			addMessage(model, respon.getMsg());
//    		}else{
//    			addError(model, respon.getMsg());
//    		}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			addError(model, e.getMessage());
		}
    	
    	return "redirect:/index.html";
    }
}
