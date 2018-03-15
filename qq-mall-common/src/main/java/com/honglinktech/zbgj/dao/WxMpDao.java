package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.WxMpConfig;
import com.honglinktech.zbgj.entity.WxMpJsTicket;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shon on 31/03/2017.
 *
 * @author shon
 */
@Repository
public interface WxMpDao {

    WxMpConfig findWxMpConfigByName(@Param("name") String wxMpName);
    WxMpJsTicket findWxMpJsTicketByName(@Param("name") String wxMpName);

    void updateWxMpConfig(WxMpConfig wxMpConfig);
    void insertWxMpJsTicket(WxMpJsTicket wxMpJsTicket);
    void updateWxMpJsTicket(WxMpJsTicket wxMpJsTicket);

    List<WxMpConfig> findAllWxMpConfig();

}
