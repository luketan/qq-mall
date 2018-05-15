package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.enums.AdvStyleTypeEnum;
import com.honglinktech.zbgj.service.AdvService;
import com.honglinktech.zbgj.service.HomeService;
import com.honglinktech.zbgj.vo.AdvVO;
import com.honglinktech.zbgj.vo.AppletHomeVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
@Component
public class HomeServiceImpl implements HomeService{

    /**
     *
     */
    private final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private AdvService advService;
    /**
     *
     * @return
     */
    @Override
    public Response<AppletHomeVO> findAppletHome(Integer userId) {
        Map whereMap = new HashMap();
        whereMap.put("styleType", AdvStyleTypeEnum.AppletHome.name());
        List<AdvVO> advVOs = advService.findVO(whereMap);

        AppletHomeVO appletHomeVO = new AppletHomeVO();
        appletHomeVO.setAdvs(advVOs);
        return Result.resultSet(appletHomeVO);
    }
}
