package com.honglinktech.zbgj.base;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by Dayong on 16/2/2.
 */
public interface BaseDao<T> {
    int save(T instance) throws DataAccessException;

    int update(T instance) throws DataAccessException;

    int delete(Integer id) throws DataAccessException;

    T findById(Integer id) throws DataAccessException;

    List<T> findAll() throws DataAccessException;

    List<T> findPage(@Param(value = "start") int start, @Param(value = "rows") int rows) throws DataAccessException;

    long countAll() throws DataAccessException;

}
