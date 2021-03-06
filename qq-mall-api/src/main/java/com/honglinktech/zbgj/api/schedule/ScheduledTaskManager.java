package com.honglinktech.zbgj.api.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.honglinktech.zbgj.service.WxMpService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by shon on 1/25/16.
 */
@Component("scheduledTaskManager")
@Configuration
public class ScheduledTaskManager {
    protected final Logger logger = LogManager.getLogger(getClass());

    @Autowired  
    private Environment env;

    /**
     *
     */
    @Autowired
    private WxMpService wxMpService;

    @Async
    public void autoNoticeExpiredOrder() {
    	logger.info("ScheduledTask:check order status->time["+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"]");
    	      
    }
    @Async
    public void refreshWxJsTicketScheduler() {
        try {
            logger.info("refreshJsTicketScheduler:refresh");
            wxMpService.refreshAllJsTicket();
        } catch (Exception e) {
            logger.error(e, e);
        }
    }

    /**
     * 刷新微信公众号的accesstoken和ticket(30分钟一次)
     */
    @Scheduled(cron = " 0 */30 * * * * ")
    public void refresh() {
        try {
            logger.info("refreshJsTicketScheduler:refresh");
            wxMpService.refreshAllJsTicket();
        } catch (Exception e) {
            logger.error(e, e);
        }
    }
}
