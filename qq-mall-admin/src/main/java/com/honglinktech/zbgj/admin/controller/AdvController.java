package com.honglinktech.zbgj.admin.controller;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.common.KV;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.Adv;
import com.honglinktech.zbgj.enums.AdvStyleTypeEnum;
import com.honglinktech.zbgj.enums.AdvTypeEnum;
import com.honglinktech.zbgj.service.AdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 快递设置接口控制器
 */
@Controller
@RequestMapping("adv")
public class AdvController extends BaseController {

    @Autowired
    private AdvService advService;


    @RequestMapping("/list")
    public String list(@RequestParam(required = false, defaultValue = "1") int index,
                       @RequestParam(required = false, defaultValue = "15") int size,
                       Model model) {
        int start = (index - 1) * size;
        Page<Adv> page = advService.findPage(null, start, size, "list.html?");
        model.addAttribute("page", page);
        List<KV> styleTypeList = new ArrayList<KV>();
        for(AdvStyleTypeEnum a: AdvStyleTypeEnum.values()) {
            styleTypeList.add(new KV(a.toString(), a.getName()));
        }
        model.addAttribute("styleTypeList", styleTypeList);
        return "adv/list";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        return "adv/form";
    }

    @RequestMapping("/modify")
    public String modify(@RequestParam int id, Model model) {
        Adv adv = advService.findById(id);
        model.addAttribute("item", adv);

        List<KV> typeList = new ArrayList<KV>();
        for(AdvTypeEnum a: AdvTypeEnum.values()) {
            typeList.add(new KV(a.toString(), a.getName()));
        }
        model.addAttribute("typeList", typeList);

        List<KV> styleTypeList = new ArrayList<KV>();
        for(AdvStyleTypeEnum a: AdvStyleTypeEnum.values()) {
            styleTypeList.add(new KV(a.toString(), a.getName()));
        }
        model.addAttribute("styleTypeList", styleTypeList);

        return "adv/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Response save(Adv adv, Model model) {
        logger.info("adv===========1======"+ JSON.toJSONString(adv));
        Response response = advService.saveOrUpdate(adv);
        if (response.getCode() != 0) {
            return response;
        }else{
            return Result.resultSet(adv);
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Response delete(Integer id, Model model) {

        try {
            if (id == null) {
                return Result.fail("id为空");
            }
            advService.deleteById(id);
        } catch (Exception e) {
            logger.error(e, e);
            return Result.fail("删除失败，请联系工作人员！");
        }
        return Result.success();
    }


}
