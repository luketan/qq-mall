/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.UserAddress;

import java.util.List;
import java.util.Map;

public interface UserAddressDao {

    int deleteById(Integer id);


    int insert(UserAddress record);


    UserAddress findById(Integer id);


    int update(UserAddress record);
    /**********************************************************************************************************/
    /**
     *
     * @param whereMap
     * @return
     */
    List<UserAddress> findByWhere(Map whereMap);
}