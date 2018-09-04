/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.UserKeep;

import java.util.List;
import java.util.Map;

public interface UserKeepDao {

    int deleteById(Integer id);

    int insert(UserKeep record);


    UserKeep findById(Integer id);


    int update(UserKeep record);

    /**********************************************************************************************************/
    /**
     * 查询
     * @param where
     * @return
     */
    List<UserKeep> findByWhere(Map where);

    /**
     * 删除收藏
     * @param uk
     * @return
     */
    int deleteKeep(UserKeep uk);
}