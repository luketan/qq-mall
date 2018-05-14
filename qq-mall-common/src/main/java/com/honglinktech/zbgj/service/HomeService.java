package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Module;
import com.honglinktech.zbgj.vo.AppletHomeVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
public interface HomeService {
    /**
     *
     * @param id
     * @return
     */
    Response<AppletHomeVO> findAppletHome(Integer id);
}
