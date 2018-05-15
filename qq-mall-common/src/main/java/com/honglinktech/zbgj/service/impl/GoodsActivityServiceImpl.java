package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.GactivityDao;
import com.honglinktech.zbgj.entity.Gactivity;
import com.honglinktech.zbgj.service.GoodsActivityService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
@Component
public class GoodsActivityServiceImpl implements GoodsActivityService {

    @Resource
    private GactivityDao gactivityDao;

    @Override
    public Response<Gactivity> saveOrUpdate(Gactivity activity) {
        int count = 0;
        if(activity.getId()  != null && activity.getId() > 0){
            count = gactivityDao.updateByPrimaryKeySelective(activity);
        }else{
            count = gactivityDao.insertSelective(activity);
        }
        return Result.resultSet(activity);
    }

    @Override
    public Response<List<ActivityBean>> findAllByGoodsId(Integer goodsId) {
        List<ActivityBean> activityBeens = gactivityDao.findAllByGoodsId(goodsId);
        return Result.resultSet(activityBeens);
    }

    @Override
    public Page<Gactivity> findPageByWhere(int index, int size, String url, Map whereMap) {
        index = index >= 0 ? index : 0;
        size = size > 0 ?  size : 10;
        int start = (index -1)*size;
        if(whereMap == null) {
        }
        whereMap.put("start", start);
        whereMap.put("rows", size);

        List<Gactivity> gactivities = gactivityDao.findByWhere(whereMap);
        int count = gactivityDao.findCount(whereMap);
        return new Page<>(start, size, count, url, gactivities);
    }

    @Override
    public Response<List<Gactivity>> findAll() {
        List<Gactivity> gactivities = gactivityDao.findByWhere(null);
        return Result.resultSet(gactivities);
    }

    @Override
    public Response<Gactivity> findById(Integer id) {
        Gactivity gactivity = gactivityDao.selectByPrimaryKey(id);
        return Result.resultSet(gactivity);
    }
}
