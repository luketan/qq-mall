package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.GoodsTypeDao;
import com.honglinktech.zbgj.enums.AdvStyleTypeEnum;
import com.honglinktech.zbgj.service.AdvService;
import com.honglinktech.zbgj.service.GoodsTypeService;
import com.honglinktech.zbgj.service.HomeService;
import com.honglinktech.zbgj.vo.AdvVO;
import com.honglinktech.zbgj.vo.AppletHomeVO;
import com.honglinktech.zbgj.vo.GoodsTypeVO;
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

    @Autowired
    private GoodsTypeDao goodsTypeDao;
    /**
     *
     * @return
     */
    @Override
    public Response<AppletHomeVO> findAppletHome(Integer userId) {
        Map advWhereMap = new HashMap();
        advWhereMap.put("styleType", AdvStyleTypeEnum.AppletHome.name());
        List<AdvVO> advVOs = advService.findVO(advWhereMap);

        Map gtWhereMap = new HashMap();
        gtWhereMap.put("rec", true);
        List<GoodsTypeVO> goodsTypeVOs = goodsTypeDao.findVOByWhere(gtWhereMap);

        Map itemWhereMap = new HashMap();
        itemWhereMap.put("styleType", AdvStyleTypeEnum.AppletItems.name());
        List<AdvVO> itmes = advService.findVO(itemWhereMap);

        AppletHomeVO appletHomeVO = new AppletHomeVO();
        appletHomeVO.setAdvs(advVOs);
        appletHomeVO.setItems(itmes);
        appletHomeVO.setGoodsTypes(goodsTypeVOs);
        return Result.resultSet(appletHomeVO);
    }
}
