package com.honglinktech.zbgj.admin.controller;

import com.honglinktech.zbgj.service.SystemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 系统设置接口控制器
 * Created by Dayong on 16/2/24.
 */
@Controller
@RequestMapping("system")
public class SystemController extends BaseController {

    @Autowired
    private SystemService systemService;

    /**
     * 获取系统设置参数列表
     * @return
     */
    @RequestMapping("/parameter")
    public String listParameter(@RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size, Model model) {
        int start = (index - 1) * size;
//        Page<SystemConfig> page = systemService.findParameterByPage(start, size, "parameter.html?");
//        model.addAttribute("parameterage", page);
        return "setting/parameter-list";
    }

    /**
     * 添加系统参数
     * @return
     */
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
//        Parameter parameter = parameterService.findParameterById(id);
//        model.addAttribute("item", parameter);
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
//        Parameter parameter = new Parameter(id, name, type, code, value, remark);
//        parameterService.saveParameter(getAdmin(), parameter);
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
//    	parameterService.deleteParameter(id);
        return "setting/parameter-list";
    }

}
