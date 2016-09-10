package com.honglinktech.zbgj.admin.bean;

import java.util.List;

/**
 * Created by Dayong on 16/3/22.
 */
public class RoleBean {
    private Integer id;
    private String name;
    private int type;
    private String desc;
    private List<Integer> adds;
    private List<Integer> dels;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Integer> getAdds() {
        return adds;
    }

    public void setAdds(List<Integer> adds) {
        this.adds = adds;
    }

    public List<Integer> getDels() {
        return dels;
    }

    public void setDels(List<Integer> dels) {
        this.dels = dels;
    }
}
