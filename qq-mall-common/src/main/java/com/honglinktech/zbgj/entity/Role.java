/**
 * @author ws
 * 2017-05-17 18:52:17
 */
package com.honglinktech.zbgj.entity;

public class Role {
    /**
     * 角色ID
     */
    private Integer id;

    /**
     * 关联系统
     */
    private Integer type;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}