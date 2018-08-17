/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.UserBasis;

public interface UserBasisDao {

    int delete(Integer id);

    int insert(UserBasis record);

    UserBasis findById(Integer id);

    int update(UserBasis record);
}