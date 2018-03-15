package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.bean.VersionInfoBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.VersionInfoDao;
import com.honglinktech.zbgj.service.VersionInfoService;
import com.honglinktech.zbgj.vo.VersionInfoVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 */
@Service("versionInfoService")
public class VersionInfoServiceImpl implements VersionInfoService {


    /**
     * logger
     */
    private final Logger logger = LogManager.getLogger(getClass());

    /**
     * versionInfoDao
     */
    @Autowired
    private VersionInfoDao versionInfoDao;

    @Override
    public Response<VersionInfoBean> findById(Integer id) {
        VersionInfoBean versionInfoBean = versionInfoDao.findById(id);
        return Result.resultSet(versionInfoBean);
    }

    @Override
    public Page<VersionInfoBean> findByPage(Map map, String url) {
        int start = map.containsKey("start") ? Integer.valueOf(map.get("start").toString()) : 0;
        int rows = map.containsKey("rows") ? Integer.valueOf(map.get("rows").toString()) : 10;
        map.put("start", start);
        map.put("rows", rows);

        List<VersionInfoBean> versionInfoBeens = versionInfoDao.findByPage(map);
        Long count = versionInfoDao.countAll(map);
        Page<VersionInfoBean> page = new Page<VersionInfoBean>(start, rows, count, url, versionInfoBeens);
        return page;
    }

    @Override
    public Response<List<VersionInfoVO>> findByWhere(Map map) {
        int start = map.containsKey("start") ? Integer.valueOf(map.get("start").toString()) : 0;
        int rows = map.containsKey("rows") ? Integer.valueOf(map.get("rows").toString()) : 10;
        map.put("start", start);
        map.put("rows", rows);

        List<VersionInfoVO> versionInfoVOs = versionInfoDao.findByWhere(map);
        return Result.resultSet(versionInfoVOs);
    }




    @Override
    public Response<VersionInfoBean> saveOrUpdate(VersionInfoBean versionInfoBean) {
        int resutl = 0;
        if (versionInfoBean.getId() != null && versionInfoBean.getId() > 0) {
            resutl = versionInfoDao.update(versionInfoBean);
        } else {
            resutl = versionInfoDao.save(versionInfoBean);
        }
        return Result.resultSet(versionInfoBean);
    }
}
