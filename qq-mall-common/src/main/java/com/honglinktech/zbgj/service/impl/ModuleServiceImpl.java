package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.dao.ModuleDao;
import com.honglinktech.zbgj.entity.Module;
import com.honglinktech.zbgj.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
@Component
public class ModuleServiceImpl implements ModuleService{

    /**
     *
     */
    @Autowired
    private ModuleDao moduleDao;

    /**
     *
     * @param where
     * @return
     */
    @Override
    public List<Module> findByWhere(Map where) {

        List<Module> modules = moduleDao.findByWhere(where);
        return modules;
    }
}
