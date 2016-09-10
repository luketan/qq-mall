package com.honglinktech.zbgj.admin.init;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Dayong on 16/3/15.
 */
@Component
public class InitService implements InitializingBean {
    private final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    //private ParameterDao parameterDao;

    @Override
    public void afterPropertiesSet() throws Exception {
//        List<Parameter> list = parameterDao.findAll();
//        for (Parameter parameter : list) {
//            SystemArgsCache.put(parameter.getCode(), parameter.getValue());
//        }
        logger.info("Initializing Api System!!!");
    }
}
