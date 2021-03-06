/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.vo.ShoppingCartVO;
import com.honglinktech.zbgj.entity.ShoppingCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShoppingCartDao {

    int delete(Integer id);

    int insert(ShoppingCart record);

    ShoppingCart findById(Integer id);

    int update(ShoppingCart record);

    /****************************************************************************************/
    /**
     * 查询购物车
     * @param map
     * @return
     */
    List<ShoppingCartVO> findShoppingCartsByMap(Map map);

    /**
     * 查询
     * @param map
     * @return
     */
    List<ShoppingCart> findByWhere(Map map);

    /**
     * 删除
     * @param userId
     * @param id
     * @return
     */
    int deleteByIdAndUserId(@Param(value = "userId") Integer userId, @Param(value = "id") Integer id);

    /**
     * 删除选中了的商品
     * @param userId
     * @return
     */
    int deleteByUserIdAndCheck(@Param(value = "userId") Integer userId);

    /**
     * 修改
     * @param shoppingCart
     * @return
     */
    int updateShoppingCart(ShoppingCart shoppingCart);

    /**
     * 修改
     * @param userId
     * @param checkAll
     * @return
     */
    int updateShoppingCartChckboxAll(@Param(value = "userId") Integer userId, @Param(value = "checkAll") Boolean checkAll);

    /**
     *
     * @param userId
     * @return
     */
    int findCount(@Param(value = "userId")int userId);

    /**
     *
     * @param userId
     * @return
     */
    int deleteInvalid(@Param(value = "userId")Integer userId);

    /**
     *
     * @param ids
     * @return
     */
    List<ShoppingCartVO> findShoppingCartsByIds(@Param(value = "userId")Integer userId, @Param(value = "ids")List<Integer> ids);

    /**
     * 删除选中了的商品
     * @param userId
     * @param shoppingCartIds
     */
    int deleteIds(@Param(value = "userId")Integer userId, @Param(value = "shoppingCartIds") List<Integer> shoppingCartIds);
}