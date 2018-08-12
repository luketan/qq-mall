/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.PostCompany;

import java.util.List;
import java.util.Map;

public interface PostCompanyDao {

    int delete(Integer id);

    int insert(PostCompany record);

    PostCompany findById(Integer id);

    int update(PostCompany record);
    /*******************************************************************************************/
    /**
     * console
     * @param whereMap
     * @return
     */
    List<PostCompany> findPostCompanyByWhere(Map whereMap);

    /**
     * console
     * @param whereMap
     * @return
     */
    int findPostCompanyCountByWhere(Map whereMap);

}