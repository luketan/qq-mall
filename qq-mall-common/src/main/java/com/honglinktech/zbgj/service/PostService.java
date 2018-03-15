package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.PostCompany;

import java.util.Map;

/**
 * 快递业务接口
 */
public interface PostService {

	/**
	 *
	 * @param start
	 * @param size
	 * @param url
	 * @return
	 */
	Page<PostCompany> findPostCompanyByPage(int start, int rows, String url, Map whereMap);

	/**
	 *
	 * @param id
	 * @return
	 */
	Response<PostCompany> findPostCompanyById(int id);

	/**
	 *
	 * @param postCompany
	 */
	Response<Integer> saveOrUpdatePostCompany(PostCompany postCompany);

	/**
	 *
	 * @param id
	 * @return
	 */
	Response<Integer> deletePostCompany(int id);
}
