package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.entity.Module;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
public interface ModuleService {

    /**
     *
     * @param where
     * @return
     */
    public List<Module> findByWhere(Map where);
}
