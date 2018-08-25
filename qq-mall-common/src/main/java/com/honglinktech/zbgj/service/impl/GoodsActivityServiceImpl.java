package com.honglinktech.zbgj.service.impl;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.GactivityDao;
import com.honglinktech.zbgj.entity.Gactivity;
import com.honglinktech.zbgj.service.GoodsActivityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
@Component
public class GoodsActivityServiceImpl implements GoodsActivityService {

    protected final Logger logger = LogManager.getLogger(getClass());

    @Resource
    private GactivityDao gactivityDao;

    @Override
    public Response<Gactivity> saveOrUpdate(Gactivity activity) {
        int count = 0;
        logger.info("===========saveOrUpdate============"+ JSON.toJSONString(activity));
        if(activity.getId()  != null && activity.getId() > 0){
            count = gactivityDao.update(activity);
        }else{
            count = gactivityDao.insert(activity);
        }
        return Result.resultSet(activity);
    }

    @Override
    public Response<List<ActivityBean>> findAllByGoodsId(Integer goodsId) {
        List<ActivityBean> activityBeens = gactivityDao.findAllByGoodsId(goodsId);
        return Result.resultSet(activityBeens);
    }

    @Override
    public Page<Gactivity> findPageByWhere(int start, int rows, String url, Map whereMap) {
        if(whereMap == null) {
            whereMap = new HashMap();
        }
        whereMap.put("start", start);
        whereMap.put("rows", rows);

        List<Gactivity> gactivities = gactivityDao.findByWhere(whereMap);
        int count = gactivityDao.findCount(whereMap);
        return new Page<>(start, rows, count, url, gactivities);
    }

    @Override
    public Response<List<Gactivity>> findAll() {
        List<Gactivity> gactivities = gactivityDao.findByWhere(null);
        return Result.resultSet(gactivities);
    }

    @Override
    public Response<Gactivity> findById(Integer id) {
        Gactivity gactivity = gactivityDao.findById(id);
        return Result.resultSet(gactivity);
    }
}
