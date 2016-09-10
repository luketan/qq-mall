package com.honglinktech.zbgj.admin.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.honglinktech.zbgj.entity.CSecurity;

/**
 * Created by Dayong on 16/3/22.
 */
public class SecurityTree {
    private int id;
    @JsonProperty("pId")
    private int pid;
    private String name;

    public SecurityTree() {
    }

    public SecurityTree(CSecurity security) {
        this.id = security.getId();
        this.pid = security.getParentId();
        this.name = security.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}