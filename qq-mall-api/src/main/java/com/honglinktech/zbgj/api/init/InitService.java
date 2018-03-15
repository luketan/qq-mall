package com.honglinktech.zbgj.api.init;


import java.util.List;

import javax.annotation.Resource;

import com.honglinktech.zbgj.entity.SystemConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.common.SystemArgsCache;
import com.honglinktech.zbgj.dao.SystemConfigDao;
import com.honglinktech.zbgj.entity.SystemConfig;

/**
 */
@Component
public class InitService implements InitializingBean {
    private final Logger logger = LogManager.getLogger(getClass());
    @Resource
    private SystemConfigDao systemConfigDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    	List<SystemConfig> systemSetList = systemConfigDao.findAll();
        for (SystemConfig systemSet : systemSetList) {
            SystemArgsCache.put(systemSet.getCode(), systemSet.getVal());
        }
        logger.info("Initializing Api System!!@@!");
    }
}
