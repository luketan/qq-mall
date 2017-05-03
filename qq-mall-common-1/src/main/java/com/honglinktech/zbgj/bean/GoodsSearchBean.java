//package com.honglinktech.zbgj.bean;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//
///**
//*商品列表Bean
//**/
//public class GoodsSearchBean implements Serializable{
//
//	private Integer id;
//	private String name;
//	private String subName;
//	private Integer salesNum;
//	private BigDecimal markPrice;
//	private BigDecimal price;
//	private String imgUrl;
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	public GoodsSearchBean(){
// 	}
//	
//	
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getSubName() {
//		return subName;
//	}
//
//	public void setSubName(String subName) {
//		this.subName = subName;
//	}
//
//	public Integer getSalesNum() {
//		return salesNum;
//	}
//
//	public void setSalesNum(Integer salesNum) {
//		this.salesNum = salesNum;
//	}
//
//	public BigDecimal getMarkPrice() {
//		return markPrice;
//	}
//
//	public void setMarkPrice(BigDecimal markPrice) {
//		this.markPrice = markPrice;
//	}
//
//	public BigDecimal getPrice() {
//		return price;
//	}
//
//	public void setPrice(BigDecimal price) {
//		this.price = price;
//	}
//
//	public String getImgUrl() {
//		return imgUrl;
//	}
//
//	public void setImgUrl(String imgUrl) {
//		this.imgUrl = imgUrl;
//	}
//
//	public static class GoodsListBeanRowMapper implements RowMapper<GoodsSearchBean> {  
//        @Override  
//        public GoodsSearchBean mapRow(ResultSet rs, int rowNum) throws SQLException {  
//        	
//        	GoodsSearchBean goodsListBean = new GoodsSearchBean();
//        	goodsListBean.setId(rs.getInt("id"));
//        	goodsListBean.setImgUrl(rs.getString("img_url"));
//        	goodsListBean.setMarkPrice(rs.getBigDecimal("mark_price"));
//        	goodsListBean.setName(rs.getString("name"));
//        	goodsListBean.setPrice(rs.getBigDecimal("price"));
//        	goodsListBean.setSalesNum(rs.getInt("sales_num"));
//        	goodsListBean.setSubName(rs.getString("sub_name"));
//        	
//        	return goodsListBean;
//        }
//    }
//}
