package com.honglinktech.zbgj.admin.controller;

import com.honglinktech.zbgj.bean.VersionInfoBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.service.VersionInfoService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hhq on 2017/3/17.
 */
@Controller
@RequestMapping("/version")
public class VersionInfoController extends BaseController {
    private Logger logger = LogManager.getLogger(getClass());
    /**
     * companyService
     */
    @Autowired
    private VersionInfoService versionInfoService;

    @RequestMapping("/list")
    public String findByPage(@RequestParam(required = false,defaultValue = "1")int index,
                             @RequestParam(required = false,defaultValue = "15")int size, Model model){
        try {
            String url = "list.html?";

            Map map  = new HashMap();
            map.put("start", (index-1)*size);
            map.put("rows", size);
            Page<VersionInfoBean> page = versionInfoService.findByPage(map, url);
            model.addAttribute("page", page);
        } catch (Exception e) {
            logger.error(e, e);
        }
        return "version/list";
    }

    @RequestMapping("/modify")
    public String findById(@RequestParam(required = true) Integer id, Model model) {
        try {
            Response<VersionInfoBean> response = versionInfoService.findById(id);
            if (response.getCode() == 0) {
                model.addAttribute("item",response.getResult());
            }
        }catch (Exception e) {
            logger.error(e, e);
        }
        return "version/form";
    }

    @RequestMapping("/toAdd")
    public String toAddVersion() throws Exception {
        return "version/form";
    }

    @RequestMapping("/save")
    public String save(VersionInfoBean versionInfoBean, Model model) {
        try {
            Response<VersionInfoBean> response = versionInfoService.saveOrUpdate(versionInfoBean);
            if (response.getCode() == 0) {
                model.addAttribute("message","保存成功！");
            }else{
                model.addAttribute("error","保存失败！");
            }
            return "redirect:modify.html?id=" +  response.getResult().getId();
        }catch (Exception e) {
            logger.error(e, e);
            model.addAttribute("item", versionInfoBean);
            return "version/form";
        }

    }

}
