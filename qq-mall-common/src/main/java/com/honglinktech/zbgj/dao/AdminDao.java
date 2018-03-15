package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统管理员 数据操作接口类
 */
public interface AdminDao extends BaseDao<Admin> {

	Admin login(@Param("loginName") String loginName, @Param("password") String password) throws DataAccessException;
	 
	int updateLoginPwd(@Param("id") int id, @Param("newPwd") String newPwd, @Param("oldPwd") String oldPwd);
	
	List<Admin> page(@Param("start") int start, @Param("rows") int rows);

	/**
	 * 通过角色获取用户列表
	 * @param roleId
	 * @return
	 */
    List<Admin> findByRoleId(@Param("roleId") Integer roleId);
}
