package com.honglinktech.zbgj.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.honglinktech.zbgj.common.Constants;

import java.io.Serializable;
import java.util.Date;


/**
 * 标签
 * @author Administrator
 *
 */
public class GoodsTagBean implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private Integer id;
	/**
	 * 标签名称
	 */
	private String name;

	/**
	 * 标签类型(1商品标签，2是帖子标签)
	 */
	private Integer type;
	/**
	 *
	 */
	private String img;

	/**
	 * 状态
	 */
	private Boolean sale;
	/**
	 *
	 */
	private String title;
	/**
	 *
	 */
	private String subtitle;
	/**
	 * 是否显示首页
	 */
	private Integer showMain;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 创建时间
	 */
	private Date createTime;

	private Integer goodsId;



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
		this.name = name == null ? null : name.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img == null ? null : img.trim();
	}

	public Boolean getSale() {
		return sale;
	}

	public void setSale(Boolean sale) {
		this.sale = sale;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle == null ? null : subtitle.trim();
	}

	public Integer getShowMain() {
		return showMain;
	}

	public void setShowMain(Integer showMain) {
		this.showMain = showMain;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
}
