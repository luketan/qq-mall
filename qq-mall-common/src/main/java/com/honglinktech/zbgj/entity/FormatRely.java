package com.honglinktech.zbgj.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * 单品标签
 */
public class FormatRely implements Serializable {
    private static final long serialVersionUID = 8994668831720914852L;
    
    @JsonIgnore
    private Integer id;
    @JsonIgnore
    private Integer formatSubId;
    private Integer relyFormatSubId;
    private Integer type;
    
	public Integer getFormatSubId() {
		return formatSubId;
	}
	public void setFormatSubId(Integer formatSubId) {
		this.formatSubId = formatSubId;
	}
	public Integer getRelyFormatSubId() {
		return relyFormatSubId;
	}
	public void setRelyFormatSubId(Integer relyFormatSubId) {
		this.relyFormatSubId = relyFormatSubId;
	}
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
    
    
}
