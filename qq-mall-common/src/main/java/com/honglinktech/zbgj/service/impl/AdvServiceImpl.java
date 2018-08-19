package com.honglinktech.zbgj.service.impl;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.AdvDao;
import com.honglinktech.zbgj.dao.ModuleDao;
import com.honglinktech.zbgj.entity.Adv;
import com.honglinktech.zbgj.entity.Module;
import com.honglinktech.zbgj.service.AdvService;
import com.honglinktech.zbgj.service.ModuleService;
import com.honglinktech.zbgj.vo.AdvVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
@Component
public class AdvServiceImpl implements AdvService{

    /**
     *
     */
    private final Logger logger = LogManager.getLogger(getClass());

    /**
     *
     */
    @Autowired
    private AdvDao advDao;

    @Override
    public Adv findById(int id) {
        return advDao.findById(id);
    }

    @Override
    public Page<Adv> findPage(Map whereMap, int start, int rows, String url) {
        if(whereMap == null){
            whereMap = new HashMap<>();
        }
        whereMap.put("start", start);
        whereMap.put("rows", rows);
        List<Adv> advs = advDao.find(whereMap);
        int count = advDao.count(whereMap);

        return new Page<Adv>(start, rows, count, url, advs);
    }

    @Override
    public List<AdvVO> findVO(Map whereMap) {
        List<Adv> advs = advDao.find(whereMap);
        List<AdvVO> advVOs = new ArrayList<>();
        if (advs != null && advs.size() > 0) {
            for (Adv adv:advs) {
                advVOs.add(adv.toVO());
            }
        }
        return advVOs;
    }

    @Override
    public Response saveOrUpdate(Adv adv) {
        if(adv==null){
            return Result.fail("不能为空！");
        }
        int result = 0;
        logger.info("==========saveOrUpdate==========" + JSON.toJSONString(adv));
        if (adv.getId() != null && adv.getId() > 0) {
            result = advDao.update(adv);
        }else{
            result = advDao.insert(adv);
        }
        return Result.resultSet(result);
    }

    @Override
    public Response deleteById(int id) {

        int result = advDao.deleteById(id);
        logger.info(result+"==delete=deleteById================"+id);
        return Result.resultSet(result);
    }

}
