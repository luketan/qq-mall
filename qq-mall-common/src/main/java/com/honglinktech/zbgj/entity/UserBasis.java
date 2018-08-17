/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.vo.UserBasisVO;

import java.math.BigDecimal;
import java.util.Date;

public class UserBasis {
    /**
     * 用户ID关联t_user.id
     */
    private Integer id;

    /**
     * 虚拟币(逗币)
     */
    private BigDecimal virtualMoney;

    /**
     * 账户余额
     */
    private BigDecimal money;

    /**
     * 商城积分
     */
    private Integer point;

    /**
     * 社区经验
     */
    private Integer exp;

    /**
     * 社区级别
     */
    private Integer level;

    /**
     * 乐观锁版本号
     */
    private Integer version;
    /**
     * 乐观锁版本号
     */
    private Integer newVersion;

    /**
     * 修改时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getVirtualMoney() {
        return virtualMoney;
    }

    public void setVirtualMoney(BigDecimal virtualMoney) {
        this.virtualMoney = virtualMoney;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(Integer newVersion) {
        this.newVersion = newVersion;
    }

    public UserBasisVO toVO() {
        UserBasisVO userBasisVO= new UserBasisVO();
        userBasisVO.setId(this.getId());
        userBasisVO.setExp(this.getExp());
        userBasisVO.setLevel(this.getLevel());
        userBasisVO.setMoney(this.getMoney());
        userBasisVO.setPoint(this.getPoint());
        userBasisVO.setVirtualMoney(this.getVirtualMoney());
        userBasisVO.setUpdateTime(this.getUpdateTime());
        return userBasisVO;
    }
}