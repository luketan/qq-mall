package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.common.ErrorCode;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.ParameterConstant;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.dao.AdminDao;
import com.honglinktech.zbgj.dao.RoleDao;
import com.honglinktech.zbgj.dao.SecurityDao;
import com.honglinktech.zbgj.entity.Admin;
import com.honglinktech.zbgj.entity.Role;
import com.honglinktech.zbgj.entity.Security;
import com.honglinktech.zbgj.service.SecurityService;
import com.honglinktech.zbgj.service.SystemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * 系统设置接口实现类
 * Created by Dayong on 16/3/15.
 */
@Service
public class SecurityServiceImpl implements SecurityService {
    private final Logger logger = LogManager.getLogger(getClass());
    /**
     *
     */
    @Autowired
    private RoleDao roleDao;
    /**
     *
     */
    @Autowired
    private SecurityDao securityDao;
    /**
     *
     */
    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Role> findAllRole(){
    	return roleDao.findAll();
    }
	@Override
    public Page<Role> findRoleByPage(int start, int size, String pageUrl) {
        if (start < 0) {
            return null;
        }
        if (size < 1) {
            size = 15;
        }
        try {
            List<Role> list = roleDao.findPage(start, size);
            Long count = roleDao.countAll();
            Page<Role> page = new Page<Role>(start, size, count, pageUrl, list);
            return page;
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public Role findRoleById(int id) {
        if (id > 0) {
            return roleDao.findById(id);
        }
        return null;
    }

    @Override
    public List<Role> findRoleByAdminId(Integer adminId) {
        if (adminId != null && adminId > 0) {
            return roleDao.findByUserId(adminId);
        }
        return null;
    }

    @Override
    public Integer saveRole(Role role, List<Integer> adds, List<Integer> dels) {
        if (role != null) {
            try {
                int id = role.getId();
                if (id > 0) {
                    adds = duplicateDetection(adds);
                    for (Integer sid : adds) {
                        securityDao.saveRoleSecurity(id, sid);
                    }
                    dels = duplicateDetection(dels);
                    for (Integer sid : dels) {
                        securityDao.deleteRoleSecurity(id, sid);
                    }
                    Role param = roleDao.findById(id);
                    param.setName(role.getName());
                    param.setType(role.getType());
                    param.setDesc(role.getDesc());
                    roleDao.update(param);
                } else {
                    roleDao.save(role);
                    id = role.getId();
                    adds = duplicateDetection(adds);
                    for (Integer sid : adds) {
                        securityDao.saveRoleSecurity(id, sid);
                    }
                }
                return id;
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return null;
    }

    /**
     * 利用set去重复
     * @param list
     * @return
     */
    private List<Integer> duplicateDetection(List<Integer> list) {
        Set<Integer> set = new HashSet<Integer>();
        for (Integer id : list) {
            set.add(id);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (Integer id : set) {
            result.add(id);
        }
        return result;
    }

    @Override
    public boolean deleteRole(int id) {
        try {
            roleDao.delete(id);
            return true;
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public Map<String, List<Admin>> findAllRoleMember(int id) {
        Map<String, List<Admin>> result = new HashMap<String, List<Admin>>();
        //

        List<Admin> admins = adminDao.findByRoleId(id);

        if(admins == null || admins.size() == 0){
            return result;
        }

        List<Admin> list = new ArrayList<Admin>();
        List<Integer> ids = roleDao.findMembers(id);
        for (Admin admin : admins) {
            if (ids.contains(admin.getId())) {
                list.add(admin);
            }
        }
        result.put("all", admins);
        result.put("list", list);
        return result;
    }

    @Override
    public void addMember(int adminId, int roleId) {
        roleDao.addMember(adminId, roleId);
    }

    @Override
    public void deleteMember(int adminId, int roleId) {
        roleDao.deleteMember(adminId, roleId);
    }

    @Override
    public List<Security> findAllSecurity() {
        return securityDao.findAll();
    }

    @SuppressWarnings("unused")
	@Override
    public Page<Security> findSecurityByPage(int start, int size, String pageUrl) {
        if (start < 0) {
            return null;
        }
        if (size < 1) {
            size = 15;
        }
        try {
            List<Security> list = securityDao.findPage(start, size);
            Long count = securityDao.countAll();
            if (count == null) {
                count = 0l;
            }
            Page<Security> page = new Page<Security>(start, size, count, pageUrl, list);
            return page;
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public Security findSecurityById(int id) {
        if (id > 0) {
            return securityDao.findById(id);
        }
        return null;
    }

    @Override
    public List<Security> findSecurityByAdminId(Integer adminId) {
        if (adminId != null && adminId > 0) {
            return securityDao.findByUserId(adminId);
        }
        return null;
    }

    @Override
    public List<Security> findSecurityByRoleId(int rid) {
        if (rid > 0) {
            return securityDao.findByRoleId(rid);
        }
        return null;
    }

    @Override
    public Integer saveSecurity(Security security) {
        if (security != null) {
            try {
                int id = security.getId();
                if (id > 0) {
                    Security result = securityDao.findById(id);
                    result.setParentId(security.getParentId());
                    result.setName(security.getName());
                    result.setType(security.getType());
                    result.setDescription(security.getDescription());
                    result.setCode(security.getCode());
                    securityDao.update(result);
                } else {
                    securityDao.save(security);
                    id = security.getId();
                }
                return id;
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return null;
    }

    @Override
    public boolean deleteSecurity(int id) {
        try {
            securityDao.delete(id);
            return true;
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

}
