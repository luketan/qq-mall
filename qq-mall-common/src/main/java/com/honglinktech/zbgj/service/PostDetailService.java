package com.honglinktech.zbgj.service;

import com.honglinktech.zbgj.bean.PostDetailBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.entity.PostDetail;

import java.util.List;

/**
 * 快递查询接口
 * Created by tangjc on 2016/3/28.
 */
public interface PostDetailService
{
    /**
     * 订阅快递100服务
     * @param company 快递公司编码
     * @param number 快递单号
     * @param from 出发地城市，省-市-区，非必填，填了有助于提升签收状态的判断的准确率 传空时忽略此项
     * @param to 目的地城市，省-市-区，非必填，填了有助于提升签收状态的判断的准确率，且到达目的地后会加大监控频率 传空时忽略此项
     * @return
     */
    Response<String> subscribeService(String company, String number, String from, String to);

    /**
     * 查询快递单详情
     * @param number 快递单号
     * @param company 快递公司单号
     * @return
     */
    Response<List<PostDetailBean>> queryPostDetail(String number, String company);

    /**
     * @param postDetail 录入快递单详情
     * 更新快递单的信息
     * @return
     */
    Object updatePostDetail(PostDetail postDetail);


    /**
     * 由于快递100每次推送数据是全时的数据,所以每次插入数据时,先删除以前的数据
     * @param postDetail
     * @return
     */
    Response<String> deletePostDetail(PostDetail postDetail);

    /**
     *
     * @param postCode
     * @param integer
     * @return
     */
    Response<List<PostDetailBean>> findPostDetails(String postCode, Integer integer);
}
