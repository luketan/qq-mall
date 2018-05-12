package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.Adv;
import com.honglinktech.zbgj.entity.Module;
import com.honglinktech.zbgj.vo.AdvVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17.
 */
public interface AdvService {

    /**
     *
     * @return
     */
    Adv findById(int id);

    /**
     *
     * @param where
     * @param url
     * @return
     */
    Page<Adv> findPage(Map where, int start, int rows, String url);
    /**
     *
     * @param where
     * @return
     */
    List<AdvVO> findVO(Map where);

    /**
     *
     * @return
     */
    Response saveOrUpdate(Adv adv);

    /**
     *
     * @return
     */
    Response deleteById(int id);

}
