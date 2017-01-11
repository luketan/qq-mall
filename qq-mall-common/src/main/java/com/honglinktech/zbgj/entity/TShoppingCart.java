package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.math.BigDecimal; 

import java.util.Date; 


/**
*
**/
public class TShoppingCart extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "goods_id",length = 10,allowNull=false)
	private Integer goodsId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "goods_name",length = 225,allowNull=true)
	private String goodsName=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "image_url",length = 225,allowNull=true)
	private String imageUrl=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "price",length = 10,allowNull=true)
	private BigDecimal price=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "mark_price",length = 10,allowNull=true)
	private BigDecimal markPrice=null;
	@FieldMeta(primaryKey = false,fieldName = "商品规格id",dbName = "format_id",length = 10,allowNull=true)
	private Integer formatId=null;
	@FieldMeta(primaryKey = false,fieldName = "商品规格名字",dbName = "format_name",length = 225,allowNull=true)
	private String formatName=null;
	@FieldMeta(primaryKey = false,fieldName = "数量",dbName = "num",length = 10,allowNull=true)
	private Integer num=null;
	@FieldMeta(primaryKey = false,fieldName = "是否选中",dbName = "checkbox",length = 10,allowNull=true)
	private Integer checkbox=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TShoppingCart(){
 	}
 	public TShoppingCart(Integer id,Integer userId,Integer goodsId,String goodsName,String imageUrl,BigDecimal price,BigDecimal markPrice,Integer formatId,String formatName,Integer num,Integer checkbox){
 		this.id = id;
		this.userId = userId;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.imageUrl = imageUrl;
		this.price = price;
		this.markPrice = markPrice;
		this.formatId = formatId;
		this.formatName = formatName;
		this.num = num;
		this.checkbox = checkbox;
		
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
	/*商品规格id*/
	public Integer getFormatId(){
		 return this.formatId; 
	}
	public void setFormatId(Integer formatId){
		  this.formatId = formatId; 
	}
	/*商品规格名字*/
	public String getFormatName(){
		 return this.formatName; 
	}
	public void setFormatName(String formatName){
		  this.formatName = formatName; 
	}
	/*数量*/
	public Integer getNum(){
		 return this.num; 
	}
	public void setNum(Integer num){
		  this.num = num; 
	}
	/*是否选中*/
	public Integer getCheckbox(){
		 return this.checkbox; 
	}
	public void setCheckbox(Integer checkbox){
		  this.checkbox = checkbox; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}
	/*修改时间*/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}

	
	public enum DBMaping{
		tableName("t_shopping_cart",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,false),
		goodsId("goods_id",Types.INTEGER,false,false,false),
		goodsName("goods_name",Types.VARCHAR,false,false,true),
		imageUrl("image_url",Types.VARCHAR,false,false,true),
		price("price",Types.DECIMAL,false,false,true),
		markPrice("mark_price",Types.DECIMAL,false,false,true),
		formatId("format_id",Types.INTEGER,false,false,true),
		formatName("format_name",Types.VARCHAR,false,false,true),
		num("num",Types.INTEGER,false,false,true),
		checkbox("checkbox",Types.INTEGER,false,false,true),
		createTime("create_time",Types.TIMESTAMP,false,false,true),
		updateTime("update_time",Types.TIMESTAMP,false,false,true);
		private String dbName;
		private int dbType;
		private boolean primaryKey;
		private boolean isAotuIn;
		private boolean isAllowNull;
	    public String getDbName(){
	    	 return this.dbName;
	    }
	    public int getDbType(){
	    	 return this.dbType;
	    }
	    public boolean getPrimaryKey(){
	    	 return this.primaryKey;
	    }
	    public boolean isAotuIn(){
	    	 return this.isAotuIn;
	    }
	    public boolean isAllowNull(){
	    	 return this.isAllowNull;
	    }
	    private DBMaping(String dbName,int dbType,boolean primaryKey,boolean isAotuIn,boolean isAllowNull){
	    	 this.dbName = dbName;
	    	 this.dbType = dbType;
	    	 this.primaryKey = primaryKey;
	    	 this.isAotuIn = isAotuIn;
	    	 this.isAllowNull = isAllowNull;
	    }
	}
	public Object[] getDBMapping(String filedName){
		for(DBMaping d:DBMaping.values()){
			if(d.toString().equals(filedName)){
				DBMaping dbMaping = DBMaping.valueOf(filedName);
				Object[] values = {dbMaping.dbName,dbMaping.dbType,dbMaping.primaryKey,dbMaping.isAotuIn,dbMaping.isAllowNull};
				return values;
			}
		}
		return null;
	}
	public static class TShoppingCartRowMapper implements RowMapper<TShoppingCart> {  
        @Override  
        public TShoppingCart mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TShoppingCart tShoppingCart = new TShoppingCart();
			tShoppingCart.setId(rs.getInt("id"));
			tShoppingCart.setUserId(rs.getInt("user_id"));
			tShoppingCart.setGoodsId(rs.getInt("goods_id"));
			tShoppingCart.setGoodsName(rs.getString("goods_name"));
			tShoppingCart.setImageUrl(rs.getString("image_url"));
			tShoppingCart.setPrice(rs.getBigDecimal("price"));
			tShoppingCart.setMarkPrice(rs.getBigDecimal("mark_price"));
			tShoppingCart.setFormatId(rs.getInt("format_id"));
			tShoppingCart.setFormatName(rs.getString("format_name"));
			tShoppingCart.setNum(rs.getInt("num"));
			tShoppingCart.setCheckbox(rs.getInt("checkbox"));
			tShoppingCart.setCreateTime(rs.getTimestamp("create_time"));
			tShoppingCart.setUpdateTime(rs.getTimestamp("update_time"));
			return tShoppingCart; 
        }  
          
    }
}
