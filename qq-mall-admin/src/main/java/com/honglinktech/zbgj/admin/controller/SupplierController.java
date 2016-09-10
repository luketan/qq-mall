package com.honglinktech.zbgj.admin.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Supplier;
import com.honglinktech.zbgj.service.SupplierService;

/**
 * 
 */
@Controller
@RequestMapping("supplier")
public class SupplierController extends BaseController {
    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private SupplierService supplierService;
    /**
     * 获取供应商列表
     *
     * @return
     */
    @RequiresPermissions("supplier:list")
    @RequestMapping("/list")
    public String list(Model model, @RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size) {
        Page<Supplier> page = supplierService.findByPage((index - 1) * size, size, "/supplier/list.html?");
        model.addAttribute("page", page);
        return "supplier/list";
    }
    /**
     * 添加供应商
     *
     * @return
     */
    @RequiresPermissions("supplier:add")
    @RequestMapping("/add")
    public String add(Model model) {

        return "supplier/form";
    }

    /**
     * 修改供应商
     *
     * @return
     */
    @RequiresPermissions("supplier:modify")
    @RequestMapping("/modify")
    public String modify(Model model, Supplier supplier) {
    	Response<Supplier> response= supplierService.findById(supplier.getId());
        model.addAttribute("supplier", response.getResult());
        return "supplier/form";
    }

    /**
     * 保存供应商
     *
     * @return
     */
    @RequiresPermissions("supplier:save")
    @RequestMapping("/save")
    public String save(Model model, Supplier supplier) {
    	Response<Integer> response = supplierService.saveOrUpdate(supplier);
        return "redirect:/supplier/list.html";
    }

    /**
     * 删除供应商
     *
     * @return
     */
    @RequiresPermissions("supplier:delete")
    @RequestMapping("/delete")
    public String delete(Model model, Supplier supplier) {
        if (supplier.getId() != null && supplier.getId() > 0) {
            supplierService.delete(supplier.getId());
        }
        return "redirect:/supplier/list.html";
    }
}
