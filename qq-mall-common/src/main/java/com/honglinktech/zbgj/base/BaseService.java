package com.honglinktech.zbgj.base;

import java.util.List;
import java.util.Map;

import com.honglinktech.zbgj.dao.helper.QueryHelper;

public abstract class BaseService<T>{
	/**
	 * 插入数据 返回自增长id
	 * @param t
	 * @return
	 * @throws BaseException
	 */
	public int save(T t) throws BaseException{
		return getDao().save(t);
	}
	public void saveBatch(List<T> list) throws BaseException{
		getDao().saveBatch(list);
	}
	public int update(T t) throws BaseException{
		return getDao().update(t);
	}
	public int delete(T t) throws BaseException{
		return getDao().delete(t);
	}
	public int delete(int id) throws BaseException{
		return getDao().deleteById(id);
	}
	public void deleteAll() throws BaseException{
		getDao().deleteAll();
	}
	public List<T> find(String sql) throws BaseException{
		return getDao().find(sql);
	}
	public T findById(int id) throws BaseException{
		return getDao().findById(id);
	}
	public List<T> findAll() throws BaseException{
		return getDao().findAll();
	}
	public QueryHelper<T> findByQueryHelper(QueryHelper<T> queryHelper) throws BaseException{
		return getDao().findByQueryHelper(queryHelper);
	}
	public QueryHelper<T> findByQueryHelperNoCount(QueryHelper<T> queryHelper) throws BaseException{
		return getDao().findByQueryHelperNoCount(queryHelper);
	}
	public int findCount(String where) throws BaseException{
		return getDao().findCountWhere(where);
	}
	public int findCount(Map<String, String[]> where) throws BaseException{
		return getDao().findCount(where);
	}
	public List<T> findByWhere(Map<String, String[]> where) throws BaseException{
		return getDao().findByWhere(where);
	}
	
	
	public abstract <E extends BaseDao<T>> E getDao() ;
}
