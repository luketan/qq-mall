package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietyNoteDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietyNote;

/**
*帖子业务
**/
@Component
public class TSocietyNoteService extends BaseService<TSocietyNote> {

	protected TSocietyNoteDao tSocietyNoteDao;

	
	public TSocietyNoteDao getTSocietyNote() {
		return tSocietyNoteDao;
	}
	@Resource
	public void setTSocietyNote(TSocietyNoteDao tSocietyNoteDao) {
		this.tSocietyNoteDao = tSocietyNoteDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietyNoteDao getDao() {
		return tSocietyNoteDao;
	}
}
