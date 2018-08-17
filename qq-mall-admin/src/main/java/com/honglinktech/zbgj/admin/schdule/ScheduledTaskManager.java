package com.honglinktech.zbgj.admin.schdule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shon on 1/25/16.
 */
@Component("scheduledTaskManager")
@Configuration
public class ScheduledTaskManager {
    protected final Logger logger = LogManager.getLogger(getClass());

    @Autowired  
    private Environment env;
    

    @Async
    public void autoNoticeExpiredOrder() {
    	logger.info("ScheduledTask:check order status->time["+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"]");
    }
}
