package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.Security;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限数据操作接口类
 * Created by Dayong on 16/2/24.
 */
@Repository
public interface SecurityDao extends BaseDao<Security> {

    /**
     * 根据用户ID查询其所有的权限
     *
     * @param userId
     * @return
     */
    List<Security> findByUserId(Integer userId);

    /**
     * 根据角色来查询其权限
     *
     * @param rid
     * @return
     */
    List<Security> findByRoleId(int rid);

    /**
     * 增加角色的权限
     *
     * @param rid
     * @param sid
     */
    void saveRoleSecurity(@Param("rid") int rid, @Param("sid") Integer sid);

    /**
     * 删除角色的权限
     *
     * @param rid
     * @param sid
     */
    void deleteRoleSecurity(@Param("rid") int rid, @Param("sid") Integer sid);
}
