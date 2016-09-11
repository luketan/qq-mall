package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TSocietyNote;
import com.honglinktech.zbgj.service.TSocietyNoteService;
/**
*帖子
**/
@ControllerMeta(name = "帖子")
@RestController
@RequestMapping("/tSocietyNote/api/")
public class TSocietyNoteController extends CommonBaseController<TSocietyNote,TSocietyNoteService> {

	private TSocietyNoteService tSocietyNoteService;

	public TSocietyNoteService getTSocietyNoteService() {
		return tSocietyNoteService;
	}
	@Resource
	public void setTSocietyNoteService(TSocietyNoteService tSocietyNoteService) {
		this.tSocietyNoteService = tSocietyNoteService;
	}
	@Override
	protected TSocietyNoteService getService() {
		return tSocietyNoteService;
	}
	
}
