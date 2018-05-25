package com.honglinktech.zbgj.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/5/12.
 */
public class AppletHomeVO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 459416925930628334L;

    private List<AdvVO> advs;
    private List<GoodsTypeVO> goodsTypes;
    private List<GoodsVO> goodsVOs;

    public List<AdvVO> getAdvs() {
        return advs;
    }

    public void setAdvs(List<AdvVO> advs) {
        this.advs = advs;
    }

    public List<GoodsTypeVO> getGoodsTypes() {
        return goodsTypes;
    }

    public void setGoodsTypes(List<GoodsTypeVO> goodsTypes) {
        this.goodsTypes = goodsTypes;
    }
}
