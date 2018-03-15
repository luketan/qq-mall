/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.math.BigDecimal;

public class UserRanking {
    /**
     * 用户ID关联t_user.id
     */
    private Integer id;

    /**
     * 打赏周
     */
    private BigDecimal playReward;

    /**
     * 打赏总
     */
    private BigDecimal playRewardTotal;

    /**
     * 打赏排名
     */
    private Integer playRewardRank;

    /**
     * 获得奖励总
     */
    private BigDecimal getReward;

    /**
     * 账户余额
     */
    private BigDecimal getRewardTotal;

    /**
     * 商城积分
     */
    private Integer getRewardRank;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPlayReward() {
        return playReward;
    }

    public void setPlayReward(BigDecimal playReward) {
        this.playReward = playReward;
    }

    public BigDecimal getPlayRewardTotal() {
        return playRewardTotal;
    }

    public void setPlayRewardTotal(BigDecimal playRewardTotal) {
        this.playRewardTotal = playRewardTotal;
    }

    public Integer getPlayRewardRank() {
        return playRewardRank;
    }

    public void setPlayRewardRank(Integer playRewardRank) {
        this.playRewardRank = playRewardRank;
    }

    public BigDecimal getGetReward() {
        return getReward;
    }

    public void setGetReward(BigDecimal getReward) {
        this.getReward = getReward;
    }

    public BigDecimal getGetRewardTotal() {
        return getRewardTotal;
    }

    public void setGetRewardTotal(BigDecimal getRewardTotal) {
        this.getRewardTotal = getRewardTotal;
    }

    public Integer getGetRewardRank() {
        return getRewardRank;
    }

    public void setGetRewardRank(Integer getRewardRank) {
        this.getRewardRank = getRewardRank;
    }
}