/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.bean.FormatSubBean;
import com.honglinktech.zbgj.entity.FormatSub;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FormatSubDao {

    int deleteById(Integer id);

    int insert(FormatSub record);

    FormatSub findById(Integer id);

    int update(FormatSub record);

    /************************************************************************************************/
    /**
     *
     * @param shoppingId
     * @return
     */
    List<FormatSubBean> findFormatSubByShoppingId(@Param(value = "shoppingId") Integer shoppingId);

    /**
     *
     * @param ids
     * @return
     */
    List<FormatSubBean> findFormatSubByIds(@Param(value = "ids") List<Integer> ids);

    /**
     *
     * @param formatId
     * @return
     */
    List<FormatSubBean> findFormatSubByFormatId(@Param(value = "formatId") Integer formatId);


    int delete(Integer id);
}