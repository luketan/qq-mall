/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.PostDetail;

import java.util.List;
import java.util.Map;

public interface PostDetailDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_post_detail
     *
     * @mbggenerated
     */
    int insertSelective(PostDetail record);

    /***********************************************/
    /**
     *
     * @param map
     * @return
     */
    List<PostDetail> findByWhere(Map map);

}