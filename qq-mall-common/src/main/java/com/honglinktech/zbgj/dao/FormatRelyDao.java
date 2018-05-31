package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.FormatRely;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 */
@Repository("formatRelyDao")
public interface FormatRelyDao extends BaseDao<FormatRely> {

    public List<Integer> findByFormatSubId(@Param("formatSubId") Integer formatSubId) throws DataAccessException;

    public int deleteByFormatSubId(@Param("formatSubId") Integer formatSubId) throws DataAccessException;
    
}
