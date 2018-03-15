package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.bean.VersionInfoBean;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.vo.VersionInfoVO;

import java.util.List;
import java.util.Map;

/**
 * Created by luke on 03/14/2017.
 */
public interface VersionInfoService {

    /**
     * 通过ID获取版本信息
     * @param id
     */
    Response<VersionInfoBean> findById(Integer id);

    /**
     * 通过ID获取版本信息
     * @param map
     */
    Page<VersionInfoBean> findByPage(Map map, String url);

    /**
     * APP 获取版本信息
     * @param map
     * @return
     */
    Response<List<VersionInfoVO>> findByWhere(Map map);


    /**
     *保存修改
     * @param versionInfoBean
     */
    Response<VersionInfoBean> saveOrUpdate(VersionInfoBean versionInfoBean);

}
