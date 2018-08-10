package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.PostDetailBean;
import com.honglinktech.zbgj.entity.PostDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 快递100
 */
@Repository
public interface PostDetailDao extends BaseDao<PostDetail>
{
    /**
     * 查询快递单的详情
     *
     * @param expressNum
     * @return
     */
    List<PostDetailBean> findPostDetailByNum(@Param(value = "expressNum") String expressNum
            , @Param(value = "company") String company) throws DataAccessException;

    /**
     *
     * @param whereMap
     * @return
     */
    List<PostDetail> findByWhere(Map whereMap);
}
