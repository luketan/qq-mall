package com.honglinktech.zbgj.web.controller;


import java.util.Map;

import javax.annotation.Resource;

import com.honglinktech.zbgj.service.SystemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.web.base.BaseApiController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.service.SystemService;

@RestController
@RequestMapping("/system/api")
public class SystemController extends BaseApiController {
	@Resource
	private SystemService systemService;
	
	@RequestMapping(value="findSystems",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<Map<String, String>> findSystems() throws BaseException{
	        	
		Response<Map<String, String>> resp = systemService.findSystemSet();

		return resp; 
	}
	
	
}
