/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.UserKeep;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserKeepDao {

    int deleteById(@Param(value = "userId") Integer userId, @Param(value = "id") Integer id);

    int insert(UserKeep record);


    UserKeep findById(Integer id);


    int update(UserKeep record);

    /**********************************************************************************************************/
    /**
     * 查询
     * @param where
     * @return
     */
    List<UserKeep> findGoodsByWhere(Map where);

    /**
     * 删除收藏
     * @param uk
     * @return
     */
    int deleteKeep(UserKeep uk);
}