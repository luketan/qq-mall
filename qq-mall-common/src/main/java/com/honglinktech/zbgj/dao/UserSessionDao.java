/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.UserSession;

public interface UserSessionDao {
    /**
     *
     * @param userId
     * @return
     */
    int delete(Integer userId);

    /**
     *
     * @param record
     * @return
     */
    int insert(UserSession record);

    /**
     *
     * @param userId
     * @return
     */
    UserSession findByUserId(Integer userId);

    /**
     *
     * @param record
     * @return
     */
    int update(UserSession record);

    /**
     * find by token
     * @param token
     * @return
     */
    UserSession findByToken(String token);
}