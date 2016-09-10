package com.honglinktech.zbgj.admin.controller;

import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.entity.Advertisement;
import com.honglinktech.zbgj.service.HomeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 广告接口控制器
 * Created by Dayong on 16/2/24.
 */
@Controller
@RequestMapping("advertisement")
public class AdvertisementController extends BaseController {
    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private HomeService homeService;

    /**
     * 获取广告列表
     *
     * @return
     */
    @RequiresPermissions("advertisement:list")
    @RequestMapping("/list")
    public String list(Model model, @RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size) {
        Page<Advertisement> page = homeService.findAdvertisementPage((index - 1) * size, size, "/advertisement/list.html?");
        model.addAttribute("page", page);
        return "advertisement/list";
    }

    /**
     * 添加广告
     *
     * @return
     */
    @RequiresPermissions("advertisement:add")
    @RequestMapping("/add")
    public String add(Model model) {

        return "advertisement/form";
    }

    /**
     * 修改广告
     *
     * @return
     */
    @RequiresPermissions("advertisement:modify")
    @RequestMapping("/modify")
    public String modify(Model model, Advertisement advertisement) {
        Advertisement adv = homeService.findAdvertisementById(advertisement.getId());
        model.addAttribute("advertisement", adv);
        return "advertisement/form";
    }

    /**
     * 保存广告
     *
     * @return
     */
    @RequiresPermissions("advertisement:save")
    @RequestMapping("/save")
    public String save(Model model, Advertisement advertisement) {
        if (advertisement.getId() != null && advertisement.getId() > 0) {
            homeService.updateAdvertisement(advertisement);
        } else {
            homeService.saveAdvertisement(advertisement);
        }
        return "redirect:/advertisement/list.html";
    }

    /**
     * 删除广告
     *
     * @return
     */
    @RequiresPermissions("advertisement:delete")
    @RequestMapping("/delete")
    public String delete(Model model, Advertisement advertisement) {
        if (advertisement.getId() != null && advertisement.getId() > 0) {
            homeService.deleteAdvertisement(advertisement.getId());
        }
        return "redirect:/advertisement/list.html";
    }
}
