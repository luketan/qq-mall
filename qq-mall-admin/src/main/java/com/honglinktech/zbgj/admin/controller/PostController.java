package com.honglinktech.zbgj.admin.controller;

import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.PostCompany;
import com.honglinktech.zbgj.service.PostService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 快递设置接口控制器
 */
@Controller
@RequestMapping("post")
public class PostController extends BaseController {

    @Autowired
    private PostService postService;

      /**
     * 获取快递公司列表
     *
     * @return
     */
    @RequiresPermissions("post:list")
    @RequestMapping("/list")
    public String list(@RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size, Model model) {
        int start = (index - 1) * size;
        Page<PostCompany> page = postService.findPostCompanyByPage(start, size, "delivery.html?", null);
        model.addAttribute("page", page);
        return "post/list";
    }

    /**
     * 添加快递公司
     *
     * @return
     */
    @RequiresPermissions("post:add")
    @RequestMapping("/add")
    public String add(Model model) {
        return "post/form";
    }

    /**
     * 修改快递公司
     *
     * @return
     */
    @RequiresPermissions("post:modify")
    @RequestMapping("/modify")
    public String modify(@RequestParam int id, Model model) {
        Response<PostCompany> postCompany = postService.findPostCompanyById(id);
        model.addAttribute("item", postCompany.getResult());
        return "post/form";
    }

    /**
     * 保存快递公司
     *
     * @return
     */
    @RequiresPermissions("post:save")
    @RequestMapping("/save")
    public String save(PostCompany postCompany, Model model) {
        postService.saveOrUpdatePostCompany(postCompany);
        return "redirect:list.html?id = " + postCompany.getId();
    }

    /**
     * 删除快递公司
     *
     * @return
     */
    @RequiresPermissions("post:delete")
    @RequestMapping("/post/delete")
    public String delete(int id, Model model) {
        postService.deletePostCompany(id);
        return "redirect:list.html";
    }


}
