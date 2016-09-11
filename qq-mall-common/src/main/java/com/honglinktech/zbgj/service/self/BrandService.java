package com.honglinktech.zbgj.service.self;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGBrandDao;
import com.honglinktech.zbgj.entity.TGBrand;
import com.honglinktech.zbgj.service.TGBrandService;

@Component
public class BrandService extends TGBrandService{
	
	@Resource
	private TGBrandDao tgBrandDao;
	
	public List<TGBrand> findTgBrandByGoodsType(int goodsTypeId){
		return tgBrandDao.find("select ");
	}
	
	
}
