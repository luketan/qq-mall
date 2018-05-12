/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.dao;

import com.honglinktech.zbgj.entity.Adv;
import com.honglinktech.zbgj.entity.Hint;
import com.honglinktech.zbgj.entity.HintKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdvDao {

    int deleteById(Integer id);

    int insert(Adv adv);

    Adv findById(@Param(value = "id")Integer id);

    List<Adv> find(Map whereMap);

    int count(Map whereMap);

    int update(Adv adv);
}