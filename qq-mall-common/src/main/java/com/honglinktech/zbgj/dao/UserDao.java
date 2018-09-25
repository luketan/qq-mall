/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.User;
import com.honglinktech.zbgj.vo.UserHomeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {

    int delete(Integer id);

    int insert(User user);

    User findById(Integer id);

    int update(User record);

    /*******************************************************************************************************************************/
    /**
     * 获取被关注数最多的用户
     * @param userId
     * @param start
     * @param rows
     * @return
     */
    List<User> findAtteUserByNum(@Param(value = "userId")Integer userId, @Param(value = "start")int start, @Param(value = "rows")int rows);
    /**
     *
     * @param userId
     * @param start
     * @param rows
     * @return
     */
    List<User> findFriendUserByNum(@Param(value = "userId")Integer userId, @Param(value = "start")int start, @Param(value = "rows")int rows);

    /**
     * login
     * @param account
     * @param password
     * @return
     */
    User login(String account, String password);


    /**
     * console
     * @param whereMap
     * @return
     */
    List<User> findList(Map<String, Object> whereMap);

    /**
     * consle
     * @param whereMap
     * @return
     */
    long findCount(Map<String, Object> whereMap);

    /**
     * 获取用户页面统计数据
     * @param userId
     * @return
     */
    UserHomeVO findHomeCount(Integer userId);
}