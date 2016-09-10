package com.honglinktech.zbgj.api.init;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by Dayong on 16/2/15.
 */
@Component
public class InitService implements InitializingBean {
    private final Logger logger = LogManager.getLogger(getClass());


    @Override
    public void afterPropertiesSet() throws Exception {
       /* List<Parameter> list = parameterDao.findAll();
        for (Parameter parameter : list) {
            SystemArgsCache.put(parameter.getCode(), parameter.getValue());
        }*/
        logger.info("Initializing Api System!!!");
    }
}
