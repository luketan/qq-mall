package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;


/**
*
**/
public class ShoppingCartBean implements Serializable{

	private Integer id=null;
	private Integer userId=null;
	private Integer goodsId=null;
	private String goodsName=null;
	private String imageUrl=null;
	private BigDecimal price=null;
	private BigDecimal markPrice=null;
	private Integer num=null;
	
	private boolean checkbox = true;
	
	private int goodsTypeId;
	private String goodsTypeName;
	
	private List<FormatSubBean> formatSubBeanList;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ShoppingCartBean(){
 	}
 	public ShoppingCartBean(Integer id,Integer userId,Integer goodsId,String goodsName,String imageUrl,BigDecimal price,BigDecimal markPrice,Integer num){
 		this.id = id;
		this.userId = userId;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.imageUrl = imageUrl;
		this.price = price;
		this.markPrice = markPrice;
		this.num = num;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/**/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/**/
	public Integer getGoodsId(){
		 return this.goodsId; 
	}
	public void setGoodsId(Integer goodsId){
		  this.goodsId = goodsId; 
	}
	/**/
	public String getGoodsName(){
		 return this.goodsName; 
	}
	public void setGoodsName(String goodsName){
		  this.goodsName = goodsName; 
	}
	/**/
	public String getImageUrl(){
		 return this.imageUrl; 
	}
	public void setImageUrl(String imageUrl){
		  this.imageUrl = imageUrl; 
	}
	/**/
	public BigDecimal getPrice(){
		 return this.price; 
	}
	public void setPrice(BigDecimal price){
		  this.price = price; 
	}
	/**/
	public BigDecimal getMarkPrice(){
		 return this.markPrice; 
	}
	public void setMarkPrice(BigDecimal markPrice){
		  this.markPrice = markPrice; 
	}
	/**/
	public Integer getNum(){
		 return this.num; 
	}
	public void setNum(Integer num){
		  this.num = num; 
	}
	public boolean isCheckbox() {
		return checkbox;
	}
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	public List<FormatSubBean> getFormatSubBeanList() {
		return formatSubBeanList;
	}
	public void setFormatSubBeanList(List<FormatSubBean> formatSubBeanList) {
		this.formatSubBeanList = formatSubBeanList;
	}
	public String getGoodsTypeName() {
		return goodsTypeName;
	}
	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}
	public int getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}


	public static class ShoppingCartBeanRowMapper implements RowMapper<ShoppingCartBean> {  
        @Override  
        public ShoppingCartBean mapRow(ResultSet rs, int rowNum) throws SQLException {  
        	
			ShoppingCartBean tShoppingCart = new ShoppingCartBean();
			tShoppingCart.setId(rs.getInt("id"));
			tShoppingCart.setUserId(rs.getInt("user_id"));
			tShoppingCart.setGoodsId(rs.getInt("goods_id"));
			tShoppingCart.setGoodsName(rs.getString("name"));
			tShoppingCart.setImageUrl(rs.getString("img_url"));
			tShoppingCart.setPrice(rs.getBigDecimal("price"));
			tShoppingCart.setMarkPrice(rs.getBigDecimal("mark_price"));
			tShoppingCart.setNum(rs.getInt("num"));
			tShoppingCart.setCheckbox(rs.getInt("checkbox")>0?true:false);
			return tShoppingCart; 
        }  
          
    }
	public static class ShoppingCartBeanGoodsInfoRowMapper implements RowMapper<ShoppingCartBean> {  
        @Override  
        public ShoppingCartBean mapRow(ResultSet rs, int rowNum) throws SQLException {  
        	
			ShoppingCartBean tShoppingCart = new ShoppingCartBean();
			tShoppingCart.setId(rs.getInt("id"));
			tShoppingCart.setUserId(rs.getInt("user_id"));
			tShoppingCart.setGoodsId(rs.getInt("goods_id"));
			tShoppingCart.setGoodsName(rs.getString("name"));
			tShoppingCart.setImageUrl(rs.getString("img_url"));
			tShoppingCart.setPrice(rs.getBigDecimal("price"));
			tShoppingCart.setMarkPrice(rs.getBigDecimal("mark_price"));
			tShoppingCart.setNum(rs.getInt("num"));
			tShoppingCart.setCheckbox(rs.getInt("checkbox")>0?true:false);
			tShoppingCart.setGoodsTypeId(rs.getInt("goods_type_id"));
			tShoppingCart.setGoodsTypeName(rs.getString("goods_type_name"));
			return tShoppingCart; 
        }  
          
    }
}
