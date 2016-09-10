package com.honglinktech.zbgj.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.honglinktech.zbgj.admin.bean.RoleBean;
import com.honglinktech.zbgj.admin.bean.SecurityTree;
import com.honglinktech.zbgj.admin.utils.SecurityComparator;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.Address;
import com.honglinktech.zbgj.entity.Admin;
import com.honglinktech.zbgj.entity.DeliveryCompany;
import com.honglinktech.zbgj.entity.Role;
import com.honglinktech.zbgj.entity.Security;
import com.honglinktech.zbgj.entity.ShipmentMode;
import com.honglinktech.zbgj.entity.old.Parameter;
import com.honglinktech.zbgj.service.AddressService;
import com.honglinktech.zbgj.service.ParameterService;
import com.honglinktech.zbgj.service.SystemService;
import com.honglinktech.zbgj.utils.JsonHelper;

/**
 * 系统设置接口控制器
 * Created by Dayong on 16/2/24.
 */
@Controller
@RequestMapping("system")
public class SystemController extends BaseController {

    @Autowired
    private SystemService systemService;
    @Autowired
    private ParameterService parameterService;
    @Autowired
    private AddressService addressService;

    /**
     * 获取系统角色列表
     *
     * @return
     */
    @RequiresPermissions("system:role")
    @RequestMapping("/role")
    public String listRole(@RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size, Model model) {
        int start = (index - 1) * size;
        Page<Role> page = systemService.findRoleByPage(start, size, "role.html?");
        model.addAttribute("page", page);
        return "role/list";
    }

    /**
     * 添加系统角色
     *
     * @return
     */
    @RequiresPermissions("system:role:add")
    @RequestMapping("/role/add")
    public String addRole(Model model) {
        try {
            //获取所有权限
            List<Security> securityList = systemService.findAllSecurity();
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
    @RequiresPermissions("system:role:modify")
    @RequestMapping("/role/modify")
    public String modifyRole(@RequestParam int id, Model model) {
        try {
            Role role = systemService.findRoleById(id);
            model.addAttribute("item", role);
            //获取所有权限
            List<Security> securityList = systemService.findAllSecurity();
            List<SecurityTree> treeList = new ArrayList<SecurityTree>();
            Collections.sort(securityList, new SecurityComparator());
            for (Security security : securityList) {
                SecurityTree item = new SecurityTree(security);
                treeList.add(item);
            }
            model.addAttribute("tree", JsonHelper.object2JsonStr(treeList));
            //获取角色拥有的权限
            securityList = systemService.findSecurityByRoleId(role.getId());
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
    @RequiresPermissions("system:role:save")
    @RequestMapping(value = "/role/save", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Response<String> saveRole(@RequestBody RoleBean bean) {
        Role role = new Role(bean.getId(), bean.getName(), bean.getType(), bean.getDesc());
        // TODO 设置当前操作的用户
        systemService.saveRole(role, bean.getAdds(), bean.getDels());
        return Result.success();
    }

    /**
     * 删除系统角色
     *
     * @return
     */
    @RequiresPermissions("system:role:delete")
    @RequestMapping(value = "/role/delete")
    public String deleteRole(int id) {
        systemService.deleteRole(id);
        return "redirect:../role.html";
    }

    /**
     * 系统角色成员列表
     *
     * @return
     */
    @RequiresPermissions("system:role:member")
    @RequestMapping(value = "/role/member")
    public String listMember(int id, Model model) {
        Map<String, List<Admin>> result = systemService.findAllRoleMember(id);
        model.addAttribute("id", id);
        model.addAttribute("result", result);
        return "role/member";
    }

    /**
     * 添加系统角色成员
     *
     * @return
     */
    @RequiresPermissions("system:role:member")
    @RequestMapping(value = "/role/member/add")
    public String addMember(int userId, int roleId) {
        systemService.addMember(userId, roleId);
        return "redirect:../member.html?id=" + roleId;
    }

    /**
     * 删除系统角色成员
     *
     * @return
     */
    @RequiresPermissions("system:role:member")
    @RequestMapping(value = "/role/member/delete")
    public String deleteMember(int userId, int roleId) {
        systemService.deleteMember(userId, roleId);
        return "redirect:../member.html?id=" + roleId;
    }


    /**
     * 获取系统权限列表
     *
     * @return
     */
    @RequiresPermissions("system:security")
    @RequestMapping("/security")
    public String listSecurity(@RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size, Model model) {
        int start = (index - 1) * size;
        Page<Security> page = systemService.findSecurityByPage(start, size, "security.html?");
        model.addAttribute("page", page);
        return "security/list";
    }

    /**
     * 添加系统权限
     *
     * @return
     */
    @RequiresPermissions("system:security:add")
    @RequestMapping("/security/add")
    public String addSecurity(Model model) {
    	List<Security> securitys = systemService.findAllSecurity();
    	model.addAttribute("securitys", securitys);
        return "security/form";
    }

    /**
     * 修改系统权限
     *
     * @return
     */
    @RequiresPermissions("system:security:modify")
    @RequestMapping("/security/modify")
    public String modifySecurity(@RequestParam int id, Model model) {
        Security security = systemService.findSecurityById(id);
        List<Security> securitys = systemService.findAllSecurity();
        model.addAttribute("securitys", securitys);
        model.addAttribute("item", security);
        return "security/form";
    }

    /**
     * 保存系统权限(新增:id为空,修改:id不为空)
     *
     * @return
     */
    @RequiresPermissions("system:security:save")
    @RequestMapping(value = "/security/save", method = RequestMethod.POST)
    public String saveSecurity(Integer id, int parentId, int type, String name, String code, String desc) {
        Security security = new Security(id, parentId, type, name, code, desc);
        // TODO 设置当前操作的用户
        systemService.saveSecurity(security);
        return "redirect:../security.html";
    }

    /**
     * 删除系统权限
     *
     * @return
     */
    @RequiresPermissions("system:security:delete")
    @RequestMapping(value = "/security/delete")
    public String deleteSecurity(int id) {
        systemService.deleteSecurity(id);
        return "redirect:../security.html";
    }

    /**
     * 获取系统参数列表
     *
     * @return
     */
    @RequiresPermissions("system:parameter")
    @RequestMapping("/parameter")
    public String listParameter(@RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size, Model model) {
        int start = (index - 1) * size;
        Page<Parameter> page = parameterService.findParameterByPage(start, size, "parameter.html?");
        model.addAttribute("page", page);
        return "setting/parameter-list";
    }

    /**
     * 添加系统参数
     *
     * @return
     */
    @RequiresPermissions("system:parameter:add")
    @RequestMapping("/parameter/add")
    public String addParameter(Model model) {
        return "setting/parameter-form";
    }

    /**
     * 修改系统参数
     *
     * @return
     */
    @RequiresPermissions("system:parameter:modify")
    @RequestMapping("/parameter/modify")
    public String modifyParameter(@RequestParam int id, Model model) {
        Parameter parameter = parameterService.findParameterById(id);
        model.addAttribute("item", parameter);
        return "setting/parameter-form";
    }

    /**
     * 保存参数信息(新增:id为空,修改:id不为空)
     *
     * @return
     */
    @RequiresPermissions("system:parameter:save")
    @RequestMapping(value = "/parameter/save", method = RequestMethod.POST)
    public String saveParameter(Integer id, String name, int type, String code, String value, String remark) {
        Parameter parameter = new Parameter(id, name, type, code, value, remark);
        parameterService.saveParameter(getAdmin(), parameter);
        return "redirect:../parameter.html";
    }

    /**
     * 删除系统参数
     *
     * @return
     */
    @RequiresPermissions("system:parameter:delete")
    @RequestMapping(value = "/parameter/delete")
    public String deleteParameter(int id) {
    	parameterService.deleteParameter(id);
        return "setting/parameter-list";
    }


    /**
     * 获取快递公司列表
     *
     * @return
     */
    @RequiresPermissions("system:delivery")
    @RequestMapping("/delivery")
    public String listDelivery(@RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size, Model model) {
        int start = (index - 1) * size;
        Page<DeliveryCompany> page = systemService.findDeliveryCompanyByPage(start, size, "delivery.html?");
        model.addAttribute("page", page);
        return "setting/delivery-list";
    }

    /**
     * 添加快递公司
     *
     * @return
     */
    @RequiresPermissions("system:delivery:add")
    @RequestMapping("/delivery/add")
    public String addDelivery(Model model) {
        return "setting/delivery-form";
    }

    /**
     * 修改快递公司
     *
     * @return
     */
    @RequiresPermissions("system:delivery:modify")
    @RequestMapping("/delivery/modify")
    public String modifyDelivery(@RequestParam int id, Model model) {
        DeliveryCompany deliveryCompany = systemService.findDeliveryCompanyById(id);
        model.addAttribute("item", deliveryCompany);
        return "setting/delivery-form";
    }

    /**
     * 保存快递公司
     *
     * @return
     */
    @RequiresPermissions("system:delivery:save")
    @RequestMapping("/delivery/save")
    public String saveDelivery(Integer id, String name, String code, String address, String director, String telephone, String apiURL, String apiAccount, String apiCode, String apiPassword, Model model) {
        DeliveryCompany deliveryCompany = new DeliveryCompany(id, name, code, address, director, telephone, apiURL, apiAccount, apiCode, apiPassword);
        systemService.saveDeliveryCompany(deliveryCompany);
        return "redirect:../delivery.html";
    }

    /**
     * 删除快递公司
     *
     * @return
     */
    @RequiresPermissions("system:delivery:delete")
    @RequestMapping("/delivery/delete")
    public String deleteDelivery(int id, Model model) {
        systemService.deleteDeliveryCompany(id);
        return "redirect:../delivery.html";
    }


    /**
     * 获取自提地址列表
     *
     * @return
     */
    @RequiresPermissions("system:pickup")
    @RequestMapping("/pickup")
    public String listPickedup(@RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size, Model model) {
        int start = (index - 1) * size;
        Page<ShipmentMode> page = systemService.findShipmentModeByPage(start, size, "pickup.html?");
        model.addAttribute("page", page);
        return "setting/pickup-list";
    }

    /**
     * 添加自提地址
     *
     * @return
     */
    @RequiresPermissions("system:pickup:add")
    @RequestMapping("/pickup/add")
    public String addPickedup(Model model) {
        return "setting/pickup-form";
    }

    /**
     * 修改自提地址
     *
     * @return
     */
    @RequiresPermissions("system:pickup:modify")
    @RequestMapping("/pickup/modify")
    public String modifyPickedup(int id, Model model) {
        ShipmentMode mode = systemService.findShipmentModeById(id);
        model.addAttribute("item", mode);
        return "setting/pickup-form";
    }

    /**
     * 保存自提地址
     *
     * @return
     */
    @RequiresPermissions("system:pickup:save")
    @RequestMapping("/pickup/save")
    public String savePickedup(Integer id, String description, String contactPhone, String contactPerson, String remarkDate) {
        ShipmentMode mode = new ShipmentMode(id, description, contactPhone, contactPerson, remarkDate);
        systemService.saveShipmentMode(mode);
        return "redirect:../pickup.html";
    }

    /**
     * 删除自提地址
     *
     * @return
     */
    @RequiresPermissions("system:pickup:delete")
    @RequestMapping("/pickup/delete")
    public String deletePickedup(int id, Model model) {
        systemService.deleteShipmentMode(id);
        return "redirect:../pickup.html";
    }
    
    /**
     * 获取自提地址列表
     *
     * @return
     */
    @RequiresPermissions("system:pickup")
    @RequestMapping("/address")
    public String listAddress(@RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size, Model model) {
        Page<Address> page = addressService.findAddressByPage(null, 1, index, size, "address.html?");
        model.addAttribute("page", page);
        return "address/list";
    }

    /**
     * 添加自提地址
     *
     * @return
     */
    @RequiresPermissions("system:pickup:add")
    @RequestMapping("/address/add")
    public String addAddresss(Model model) {
        return "address/form";
    }

    /**
     * 修改自提地址
     *
     * @return
     */
    @RequiresPermissions("system:pickup:modify")
    @RequestMapping("/address/modify")
    public String modifyAdddress(int id, Model model) {
        Address address = addressService.findAddressById(id);
        model.addAttribute("item", address);
        return "address/form";
    }

    /**
     * 保存自提地址
     *
     * @return
     */
    @RequiresPermissions("system:pickup:save")
    @RequestMapping("/address/save")
    public String saveAddress(Address address, Model model) {
    	address.setType(1);
    	addressService.insertAddress(address);
        return "redirect:../address.html";
    }

    /**
     * 删除自提地址
     *
     * @return
     */
    @RequiresPermissions("system:pickup:delete")
    @RequestMapping("/address/delete")
    public String deleteAddress(int id, Model model) {
    	addressService.deleteAddress(id);
        return "redirect:../address.html";
    }
}
