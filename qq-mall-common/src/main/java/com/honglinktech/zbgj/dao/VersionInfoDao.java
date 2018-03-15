package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.bean.VersionInfoBean;
import com.honglinktech.zbgj.vo.VersionInfoVO;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 */
@Repository
public interface VersionInfoDao {
    /**
     * save
     * @param instance instance
     * @return int
     * @throws DataAccessException DataAccessException
     */
    int save(VersionInfoBean instance) throws DataAccessException;

    /**
     * update
     * @param instance instance
     * @return int
     * @throws DataAccessException DataAccessException
     */
    int update(VersionInfoBean instance) throws DataAccessException;

    /**
     * delete
     * @param id id
     * @return int
     * @throws DataAccessException DataAccessException
     */
    int deleteById(Integer id) throws DataAccessException;

    /**
     * findById
     * @param id id
     * @return T
     * @throws DataAccessException DataAccessException
     */
    VersionInfoBean findById(Integer id) throws DataAccessException;


    /**
     * APP 获取版本信息
     * @return List<T>
     * @throws DataAccessException DataAccessException
     */
    List<VersionInfoVO> findByWhere(Map map) throws DataAccessException;

    /**
     * countAll
     * @return long
     * @throws DataAccessException DataAccessException
     */
    long countAll(Map map) throws DataAccessException;

    /**
     *
     * @param map
     * @return
     */
    List<VersionInfoBean> findByPage(Map map);
}
