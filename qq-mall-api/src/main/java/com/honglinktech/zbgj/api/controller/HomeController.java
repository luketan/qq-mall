package com.honglinktech.zbgj.api.controller;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.HomeBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.TModule;
import com.honglinktech.zbgj.service.TModuleService;

@RestController
@RequestMapping("/home/api")
public class HomeController extends BaseApiController {
	@Resource
	private TModuleService tModuleService;
	
	@RequestMapping(value="findHome",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<HomeBean>> findHome() throws BaseException{
		Map<String,String[]> where = new HashMap<String, String[]>();
		where.put(TModule.DBMaping.mainType.name(), new String[]{"1"});
		List<TModule> modules = tModuleService.findByWhere(where);
		List<HomeBean> homeBeans = new LinkedList<HomeBean>();
		for(TModule module:modules){
			homeBeans.add(new HomeBean(module));
		}

		return Result.resultSet(homeBeans); 
	}
	
	
}
