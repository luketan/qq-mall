package com.honglinktech.zbgj.api.init;


import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.common.SystemArgsCache;
import com.honglinktech.zbgj.dao.TSystemConfigDao;
import com.honglinktech.zbgj.entity.TSystemConfig;

/**
 */
@Component
public class InitService implements InitializingBean {
    private final Logger logger = LogManager.getLogger(getClass());
    @Resource
    private TSystemConfigDao tsystemConfigDao;

    @Override
    public void afterPropertiesSet() throws Exception {
    	List<TSystemConfig> systemSetList = tsystemConfigDao.findAll();
        for (TSystemConfig systemSet : systemSetList) {
            SystemArgsCache.put(systemSet.getCode(), systemSet.getVal());
        }
        logger.info("Initializing Api System!!@@!");
    }
}
