package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.bean.GoodsTagBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.GtagDao;
import com.honglinktech.zbgj.entity.Gtag;
import com.honglinktech.zbgj.service.GoodsTagService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
@Component
public class GoodsTagServiceImpl implements GoodsTagService{

    @Resource
    private GtagDao gtagDao;

    @Override
    public Response<Gtag> saveOrUpdate(Gtag gtag) {
        int count = 0;
        if(gtag.getId() != null && gtag.getId() > 0){
            count = gtagDao.update(gtag);
        }else{
            count = gtagDao.insert(gtag);
        }
        return Result.resultSet(gtag);
    }

    @Override
    public Response<List<GoodsTagBean>> findAllByGoodsId(Integer tagId) {
        List<GoodsTagBean> tagBeen = gtagDao.findAllByGoodsId(tagId);
        return Result.resultSet(tagBeen);
    }

    @Override
    public Page<Gtag> findPageByWhere(int start, int rows, String url, Map whereMap) {

        if(whereMap == null) {
            whereMap = new HashMap();
        }
        whereMap.put("start", start);
        whereMap.put("rows", rows);

        List<Gtag> gtags = gtagDao.findByWhere(whereMap);
        int count = gtagDao.findCount(whereMap);
        return new Page<>(start, rows, count, url, gtags);
    }

    @Override
    public Response<List<Gtag>> findAll() {
        List<Gtag> gtags = gtagDao.findByWhere(null);
        return Result.resultSet(gtags);
    }

    @Override
    public Response<Gtag> findById(Integer id) {
        Gtag tag = gtagDao.findById(id);
        return Result.resultSet(tag);
    }
}
