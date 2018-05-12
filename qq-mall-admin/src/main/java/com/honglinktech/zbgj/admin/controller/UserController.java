package com.honglinktech.zbgj.admin.controller;

import com.honglinktech.zbgj.bean.UserBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.User;
import com.honglinktech.zbgj.entity.UserBasis;
import com.honglinktech.zbgj.service.UserAddressService;
import com.honglinktech.zbgj.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * user接口控制器
 */
@Controller
@RequestMapping("/user")
@Configuration
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

    @Autowired
    private UserAddressService userAddressService;
    
    @Autowired  
    private Environment env;

	/**
	 * 分页查询订单
	 * @param model
	 * @return
	 */
	@RequiresPermissions("user:search")
	@RequestMapping("/list")
	public String search(@RequestParam(required = false) Integer status,
						 @RequestParam(required = false) Integer type,
						 @RequestParam(required = false) String keyword,
						 @RequestParam(required = false, defaultValue = "1") int index,
						 @RequestParam(required = false, defaultValue = "15") int size, Model model) {

		Map whereMap = new HashMap();
		String url = "list.html?";
		if (status != null && status != 0) {
			whereMap.put("status", status);
			url += ("status="+status+"&");
		}
		if (type != null && type != 0) {
			whereMap.put("type", type);
			url += ("type="+type+"&");
		}
		if (!StringUtils.isEmpty(keyword)) {
			whereMap.put("keyword", keyword);
			url += ("keyword="+keyword+"&");
		}
		int start = (index - 1) * size;
		whereMap.put("start", start);
		whereMap.put("rows", size);


		Page<User> page = userService.findPage(start, size, url, whereMap);
		model.addAttribute("page", page);
		model.addAttribute("status", status);
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);
		return "user/list";
	}
	/**
	 * 用户修改
	 * @param id
	 * @param password
	 * @param model
	 * @return
	 */
	@RequiresPermissions("user:modify")
    @RequestMapping("/modify")
    public String modify(@RequestParam(required = false) int id,@RequestParam(required = false,defaultValue="") String password, Model model) {
    	Response<UserBean> response = userService.findUserBeanById(id);
    	if(0!=response.getCode()){
    		model.addAttribute("item", response.getResult());
    	}else{
    		addError(model, response.getMsg());
    	}
    	model.addAttribute("password", password);
	    return "user/form";
    }
    
    /**
     * 修改user
     * @param model
     * @return
     */
    @RequiresPermissions("user:save")
    @RequestMapping("/updateUser")
    public String updateUser(UserBean userBean, Model model) {
		if(userBean == null){
			addError(model, "系统错误请联系工作人员！");
			return "redirect:list.html?";
		}
		try {
			Response<Integer> response = userService.updateUser(userBean.toUsre(), null);
			if(0!=response.getCode()){
				addMessage(model, response.getMsg());
			}else{
				addError(model, response.getMsg());
			}
			model.addAttribute("item", userBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "redirect:modify.html?id="+userBean.getId();
    }

	/**
	 * 修改 UserBasis
	 * @param model
	 * @return
	 */
	@RequiresPermissions("user:save")
	@RequestMapping("/updateUserBasis")
	public String updateUserBasis(UserBean userBean, Model model) {
		if(userBean == null){
			addError(model, "系统错误请联系工作人员！");
			return "redirect:list.html?";
		}
		try {
			Response<Integer> response = userService.updateUserBasis(userBean.toUserBasis());
			if(0!=response.getCode()){
				addMessage(model, response.getMsg());
			}else{
				addError(model, response.getMsg());
			}
			model.addAttribute("item", userBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:modify.html?id="+userBean.getId();
	}
}
