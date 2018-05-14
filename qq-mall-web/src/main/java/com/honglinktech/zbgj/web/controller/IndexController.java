package com.honglinktech.zbgj.web.controller;


import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.HomeBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.Module;
import com.honglinktech.zbgj.service.ModuleService;
import com.honglinktech.zbgj.web.base.BaseApiController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class IndexController extends BaseApiController {
	@Resource
	private ModuleService moduleService;
	
	@RequestMapping("index")
	public String index(Model model) throws BaseException{
		return "index";
	}

	@RequestMapping("login")
	public String login(Model model) throws BaseException{
		Map where = new HashMap();
		where.put("mainType", 1);
		List<Module> modules = moduleService.findByWhere(where);
		List<HomeBean> homeBeans = new LinkedList<HomeBean>();
		for(Module module:modules){
			homeBeans.add(new HomeBean(module));
		}

		return "login";
	}

	@RequestMapping("register")
	public String register(Model model) throws BaseException{
		Map where = new HashMap();
		where.put("mainType", 1);
		List<Module> modules = moduleService.findByWhere(where);
		List<HomeBean> homeBeans = new LinkedList<HomeBean>();
		for(Module module:modules){
			homeBeans.add(new HomeBean(module));
		}

		return "register";
	}

	
	
}
