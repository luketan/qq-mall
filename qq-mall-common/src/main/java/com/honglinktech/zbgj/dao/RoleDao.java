package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色数据操作接口类
 * Created by Dayong on 16/2/24.
 */
@Repository
public interface RoleDao extends BaseDao<Role> {

    List<Role> findByUserId(@Param("adminId") Integer adminId);

    List<Integer> findMembers(int id);

    void addMember(@Param("adminId") Integer adminId, @Param("roleId") int roleId);

    void deleteMember(@Param("adminId") Integer adminId, @Param("roleId") Integer roleId);
}
