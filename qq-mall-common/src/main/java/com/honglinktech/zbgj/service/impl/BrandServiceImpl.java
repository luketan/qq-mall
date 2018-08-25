package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.bean.GoodsBrandBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.GoodsBrandDao;
import com.honglinktech.zbgj.entity.GoodsBrand;
import com.honglinktech.zbgj.service.GoodsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
@Component
public class BrandServiceImpl implements GoodsBrandService {

    @Autowired
    private GoodsBrandDao goodsBrandDao;

    @Override
    public Page<GoodsBrandBean> findPageByWhere(int start, int rows, String url, Map whereMap) {
        if(whereMap == null) {
            whereMap = new HashMap();
        }
        whereMap.put("start", start);
        whereMap.put("rows", rows);

        List<GoodsBrandBean> goodsBrands = goodsBrandDao.findByWhere(whereMap);
        int count = goodsBrandDao.findCount(whereMap);
        return new Page<>(start, rows, count, url, goodsBrands);
    }

    @Override
    public Response<GoodsBrand> saveOrUpdate(GoodsBrand goodsBrand) {

        int count = 0;
        if(goodsBrand.getId()  != null && goodsBrand.getId() > 0){
            count = goodsBrandDao.updateByPrimaryKeySelective(goodsBrand);
        }else{
            count = goodsBrandDao.insertSelective(goodsBrand);
        }
        return Result.resultSet(goodsBrand);
    }

    @Override
    public Response<List<GoodsBrand>> findAll() {
        List<GoodsBrand> goodsBrands = goodsBrandDao.findAll();
        return Result.resultSet(goodsBrands);
    }

    @Override
    public Response<GoodsBrand> findById(Integer id) {
        GoodsBrand goodsBrand = goodsBrandDao.selectByPrimaryKey(id);
        return Result.resultSet(goodsBrand);
    }
}
