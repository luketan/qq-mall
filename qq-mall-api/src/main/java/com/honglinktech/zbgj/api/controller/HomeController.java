package com.honglinktech.zbgj.api.controller;


import com.honglinktech.zbgj.annotation.NoRequireLogin;
import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.HomeBean;
import com.honglinktech.zbgj.common.AppAgent;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.Module;
import com.honglinktech.zbgj.service.HomeService;
import com.honglinktech.zbgj.service.ModuleService;
import com.honglinktech.zbgj.vo.AppletHomeVO;
import com.honglinktech.zbgj.vo.UserVO;
import org.springframework.web.bind.annotation.RequestAttribute;
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
@RequestMapping("/home/api")
public class HomeController extends BaseApiController {
	@Resource
	private ModuleService moduleService;

	@Resource
	private HomeService homeService;

	@NoRequireLogin
	@RequestMapping(value="findHome",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<HomeBean>> findHome() throws BaseException{
		Map where = new HashMap();
		where.put("mainType", 1);
		List<Module> modules = moduleService.findByWhere(where);
		List<HomeBean> homeBeans = new LinkedList<HomeBean>();
		for(Module module:modules){
			homeBeans.add(new HomeBean(module));
		}

		return Result.resultSet(homeBeans); 
	}

	@NoRequireLogin
	@RequestMapping(value="findAppletHome",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response findAppletHome(@RequestAttribute("user") UserVO user,
												   @RequestAttribute("agent") AppAgent agent) throws BaseException{

		try{
			Response<AppletHomeVO> response = homeService.findAppletHome(user.getId());
			return response;
		}catch (Exception e){
			logger.error(e, e);
		}
		return Result.fail("获取失败！");
	}


	
	
}
