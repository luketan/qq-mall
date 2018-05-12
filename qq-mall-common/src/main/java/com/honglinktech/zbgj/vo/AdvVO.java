package com.honglinktech.zbgj.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/12.
 */
public class AdvVO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 5529852755089308224L;

    private String image;
    private String title;
    private String url;
    private String type;
    private String styleType;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStyleType() {
        return styleType;
    }

    public void setStyleType(String styleType) {
        this.styleType = styleType;
    }
}
