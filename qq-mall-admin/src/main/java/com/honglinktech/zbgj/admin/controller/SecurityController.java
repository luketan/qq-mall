package com.honglinktech.zbgj.admin.controller;

import com.honglinktech.zbgj.admin.bean.RoleBean;
import com.honglinktech.zbgj.admin.bean.SecurityTree;
import com.honglinktech.zbgj.admin.utils.SecurityComparator;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.Admin;
import com.honglinktech.zbgj.entity.Role;
import com.honglinktech.zbgj.entity.Security;
import com.honglinktech.zbgj.entity.User;
import com.honglinktech.zbgj.service.SecurityService;
import com.honglinktech.zbgj.service.UserAddressService;
import com.honglinktech.zbgj.service.UserService;
import com.honglinktech.zbgj.utils.HashUtils;
import com.honglinktech.zbgj.utils.JsonHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.AliasDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * user接口控制器
 */
@Controller
@RequestMapping("/security")
@Configuration
public class SecurityController extends BaseController {

	/**
	 *
	 */
	@Autowired
	private SecurityService securityService;

    @Autowired  
    private Environment env;

	/**
	 * 获取系统角色列表
	 *
	 * @return
	 */
	@RequiresPermissions("security")
	@RequestMapping("/role")
	public String listRole(@RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size, Model model) {
		int start = (index - 1) * size;
		Page<Role> page = securityService.findRoleByPage(start, size, "role.html?");
		model.addAttribute("page", page);
		return "role/list";
	}

	/**
	 * 添加系统角色
	 *
	 * @return
	 */
	@RequiresPermissions("security")
	@RequestMapping("/role/add")
	public String addRole(Model model) {
		try {
			//获取所有权限
			List<Security> securityList = securityService.findAllSecurity();
			List<SecurityTree> treeList = new ArrayList<SecurityTree>();
			Collections.sort(securityList, new SecurityComparator());
			for (Security security : securityList) {
				SecurityTree item = new SecurityTree(security);
				treeList.add(item);
			}
			model.addAttribute("tree", JsonHelper.object2JsonStr(treeList));
			model.addAttribute("role", new ArrayList<Integer>());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "role/form";
	}

	/**
	 * 修改系统角色
	 *
	 * @return
	 */
	@RequiresPermissions("security")
	@RequestMapping("/role/modify")
	public String modifyRole(@RequestParam int id, Model model) {
		try {
			Role role = securityService.findRoleById(id);
			model.addAttribute("item", role);
			//获取所有权限
			List<Security> securityList = securityService.findAllSecurity();
			List<SecurityTree> treeList = new ArrayList<SecurityTree>();
			Collections.sort(securityList, new SecurityComparator());
			for (Security security : securityList) {
				SecurityTree item = new SecurityTree(security);
				treeList.add(item);
			}
			model.addAttribute("tree", JsonHelper.object2JsonStr(treeList));
			//获取角色拥有的权限
			securityList = securityService.findSecurityByRoleId(role.getId());
			List<Integer> list = new ArrayList<Integer>();
			for (Security security : securityList) {
				SecurityTree item = new SecurityTree(security);
				list.add(item.getId());
			}
			model.addAttribute("role", JsonHelper.object2JsonStr(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "role/form";
	}

	/**
	 * 保存系统角色(新增:id为空,修改:id不为空)
	 *
	 * @return
	 */
	@RequiresPermissions("security")
	@RequestMapping(value = "/role/save", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Response<String> saveRole(@RequestBody RoleBean bean) {
		Role role = new Role();
		role.setId(bean.getId());
		role.setName(bean.getName());
		role.setType(bean.getType());
		role.setDesc(bean.getDesc());
		// TODO 设置当前操作的用户
		securityService.saveRole(role, bean.getAdds(), bean.getDels());
		return Result.success();
	}

	/**
	 * 删除系统角色
	 *
	 * @return
	 */
	@RequiresPermissions("security")//security:role:delete
	@RequestMapping(value = "/role/delete")
	public String deleteRole(int id) {
		securityService.deleteRole(id);
		return "redirect:../role.html";
	}

	/**
	 * 系统角色成员列表
	 *
	 * @return
	 */
	@RequiresPermissions("security")
	@RequestMapping(value = "/role/member")
	public String listMember(int id, Model model) {
		System.out.println("id===================================="+id);
		Map<String, List<Admin>> result = securityService.findAllRoleMember(id);
		model.addAttribute("id", id);
		model.addAttribute("result", result);
		return "role/member";
	}

	/**
	 * 添加系统角色成员
	 *
	 * @return
	 */
	@RequiresPermissions("security:role:member")
	@RequestMapping(value = "/role/member/add")
	public String addMember(int userId, int roleId) {
		securityService.addMember(userId, roleId);
		return "redirect:../member.html?id=" + roleId;
	}

	/**
	 * 删除系统角色成员
	 *
	 * @return
	 */
	@RequiresPermissions("security")
	@RequestMapping(value = "/role/member/delete")
	public String deleteMember(int userId, int roleId) {
		securityService.deleteMember(userId, roleId);
		return "redirect:../member.html?id=" + roleId;
	}


	/**
	 * 获取系统权限列表
	 *
	 * @return
	 */
	@RequiresPermissions("security")
	@RequestMapping("/security")
	public String listSecurity(@RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size, Model model) {
		int start = (index - 1) * size;
		Page<Security> page = securityService.findSecurityByPage(start, size, "security.html?");
		model.addAttribute("page", page);
		return "security/list";
	}

	/**
	 * 添加系统权限
	 *
	 * @return
	 */
	@RequiresPermissions("security")
	@RequestMapping("/security/add")
	public String addSecurity(Model model) {
		List<Security> securitys = securityService.findAllSecurity();
		model.addAttribute("securitys", securitys);
		return "security/form";
	}

	/**
	 * 修改系统权限
	 *
	 * @return
	 */
	@RequiresPermissions("security")
	@RequestMapping("/security/modify")
	public String modifySecurity(@RequestParam int id, Model model) {
		Security security = securityService.findSecurityById(id);
		List<Security> securitys = securityService.findAllSecurity();
		model.addAttribute("securitys", securitys);
		model.addAttribute("item", security);
		return "security/form";
	}

	/**
	 * 保存系统权限(新增:id为空,修改:id不为空)
	 * @return
	 */
	@RequiresPermissions("security")
	@RequestMapping(value = "/security/save", method = RequestMethod.POST)
	public String saveSecurity(Security security, Model model) {

		// TODO 设置当前操作的用户
		securityService.saveSecurity(security);
		return "redirect:../security.html";
	}

	/**
	 * 删除系统权限
	 *
	 * @return
	 */
	@RequiresPermissions("security")
	@RequestMapping(value = "/security/delete")
	public String deleteSecurity(int id) {
		securityService.deleteSecurity(id);
		return "redirect:../security.html";
	}

}
