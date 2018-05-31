/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.UserFriend;
import org.apache.ibatis.annotations.Param;

public interface UserFriendDao {

    int deleteById(@Param(value = "userId") Integer userId, @Param(value = "friendUserId") Integer friendUserId);

    int insert(UserFriend record);

    UserFriend findById(@Param(value = "userId") Integer userId, @Param(value = "friendUserId") Integer friendUserId);

    int update(UserFriend record);
}