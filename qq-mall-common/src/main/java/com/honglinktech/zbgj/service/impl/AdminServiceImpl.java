package com.honglinktech.zbgj.service.impl;

import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.AdminDao;
import com.honglinktech.zbgj.dao.RoleDao;
import com.honglinktech.zbgj.entity.Admin;
import com.honglinktech.zbgj.entity.AdminRole;
import com.honglinktech.zbgj.service.AdminService;
import com.honglinktech.zbgj.utils.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

@Component
public class AdminServiceImpl implements AdminService {

	/**
	 *
	 */
	@Autowired
	private AdminDao adminDao;
	/**
	 *
	 */
	@Autowired
	private RoleDao roleDao;

	@Override
	public Page<Admin> findPageByWhere(int start, int rows, String url, Map whereMap) {

		List<Admin> admins = adminDao.page(start, rows);
		long count = adminDao.countAll();
		Page<Admin> page = new Page<Admin>(start, rows, count, url, admins);

		return page;
	}

	/**
	 * 登录
	 * @param loginName
	 * @param password
	 * @return
	 */
	@Override
	public Response<Admin> adminLogin(String loginName, String password){
		try {
			password = HashUtils.encryptMD5(password, "");
			Admin admin = adminDao.login(loginName, password);
			if(admin == null){
				return Result.fail("用户名或密码错误！");
			}
			if(admin.getActive()==null || !admin.getActive()){
				return Result.fail("用户已经被拉黑了");
			}
			return Result.resultSet(admin);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return Result.fail("系统错误，请联系工作人员");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return Result.fail("系统错误，请联系工作人员");
		} catch (Exception e) {
			e.printStackTrace();
			return Result.fail("系统错误，请联系工作人员");
		}
	}

	@Override
	public Response<Admin> saveOrUpdateAdmin(Admin admin, String[] roles) {

		try{
			if(admin.getId()!=null && admin.getId()>0){

				adminDao.update(admin);
			}else{
				admin.setPassword(HashUtils.encryptMD5(HashUtils.encryptMD5(admin.getPassword(), ""), ""));
				adminDao.save(admin);
			}
			if(admin.getId()!=null && admin.getId()>0 && roles!=null){
				roleDao.deleteMember(admin.getId(), null);
				for(String roleId:roles){
					roleDao.addMember(admin.getId(), Integer.valueOf(roleId));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return Result.fail("系统错误，请联系工作人员");
		}

		return Result.resultSet(admin);
	}

	@Override
	public Response<Admin> findAdminById(int id) {
		Admin admin = adminDao.findById(id);
		return Result.resultSet(admin);
	}

	@Override
	public List<AdminRole> findAdminRoleByWhere(Map adminRoleMap) {
		//TODO
		return null;
	}

}
