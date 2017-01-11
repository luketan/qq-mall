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
*订单详情
**/
public class TOrderItem extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "订单项Id",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "主订单ID",dbName = "order_id",length = 10,allowNull=false)
	private Integer orderId=null;
	@FieldMeta(primaryKey = false,fieldName = "产品单品ID",dbName = "goods_id",length = 10,allowNull=false)
	private Integer goodsId=null;
	@FieldMeta(primaryKey = false,fieldName = "单品名称",dbName = "goods_name",length = 64,allowNull=false)
	private String goodsName=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "goods_img",length = 128,allowNull=true)
	private String goodsImg=null;
	@FieldMeta(primaryKey = false,fieldName = "商品规格名称",dbName = "formats",length = 225,allowNull=true)
	private String formats=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "activitys",length = 255,allowNull=true)
	private String activitys=null;
	@FieldMeta(primaryKey = false,fieldName = "购买数量",dbName = "num",length = 10,allowNull=true)
	private Integer num=null;
	@FieldMeta(primaryKey = false,fieldName = "成交价格",dbName = "price",length = 10,allowNull=true)
	private BigDecimal price=null;
	@FieldMeta(primaryKey = false,fieldName = "市场价格",dbName = "market_price",length = 10,allowNull=true)
	private BigDecimal marketPrice=null;
	@FieldMeta(primaryKey = false,fieldName = "备注",dbName = "remark",length = 225,allowNull=true)
	private String remark=null;
	@FieldMeta(primaryKey = false,fieldName = "是否已经评论(0未评论,1已评论)",dbName = "dis_is",length = 10,allowNull=true)
	private Integer disIs=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TOrderItem(){
 	}
 	public TOrderItem(Integer id,Integer orderId,Integer goodsId,String goodsName,String goodsImg,String formats,String activitys,Integer num,BigDecimal price,BigDecimal marketPrice,String remark,Integer disIs){
 		this.id = id;
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsImg = goodsImg;
		this.formats = formats;
		this.activitys = activitys;
		this.num = num;
		this.price = price;
		this.marketPrice = marketPrice;
		this.remark = remark;
		this.disIs = disIs;
		
 	}
 	
		/*订单项Id*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*主订单ID*/
	public Integer getOrderId(){
		 return this.orderId; 
	}
	public void setOrderId(Integer orderId){
		  this.orderId = orderId; 
	}
	/*产品单品ID*/
	public Integer getGoodsId(){
		 return this.goodsId; 
	}
	public void setGoodsId(Integer goodsId){
		  this.goodsId = goodsId; 
	}
	/*单品名称*/
	public String getGoodsName(){
		 return this.goodsName; 
	}
	public void setGoodsName(String goodsName){
		  this.goodsName = goodsName; 
	}
	/**/
	public String getGoodsImg(){
		 return this.goodsImg; 
	}
	public void setGoodsImg(String goodsImg){
		  this.goodsImg = goodsImg; 
	}
	/*商品规格名称*/
	public String getFormats(){
		 return this.formats; 
	}
	public void setFormats(String formats){
		  this.formats = formats; 
	}
	/**/
	public String getActivitys(){
		 return this.activitys; 
	}
	public void setActivitys(String activitys){
		  this.activitys = activitys; 
	}
	/*购买数量*/
	public Integer getNum(){
		 return this.num; 
	}
	public void setNum(Integer num){
		  this.num = num; 
	}
	/*成交价格*/
	public BigDecimal getPrice(){
		 return this.price; 
	}
	public void setPrice(BigDecimal price){
		  this.price = price; 
	}
	/*市场价格*/
	public BigDecimal getMarketPrice(){
		 return this.marketPrice; 
	}
	public void setMarketPrice(BigDecimal marketPrice){
		  this.marketPrice = marketPrice; 
	}
	/*备注*/
	public String getRemark(){
		 return this.remark; 
	}
	public void setRemark(String remark){
		  this.remark = remark; 
	}
	/*是否已经评论(0未评论,1已评论)*/
	public Integer getDisIs(){
		 return this.disIs; 
	}
	public void setDisIs(Integer disIs){
		  this.disIs = disIs; 
	}
	/*修改时间*/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

	
	public enum DBMaping{
		tableName("t_order_item",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		orderId("order_id",Types.INTEGER,false,false,false),
		goodsId("goods_id",Types.INTEGER,false,false,false),
		goodsName("goods_name",Types.VARCHAR,false,false,false),
		goodsImg("goods_img",Types.VARCHAR,false,false,true),
		formats("formats",Types.VARCHAR,false,false,true),
		activitys("activitys",Types.VARCHAR,false,false,true),
		num("num",Types.INTEGER,false,false,true),
		price("price",Types.DECIMAL,false,false,true),
		marketPrice("market_price",Types.DECIMAL,false,false,true),
		remark("remark",Types.VARCHAR,false,false,true),
		disIs("dis_is",Types.INTEGER,false,false,true),
		updateTime("update_time",Types.TIMESTAMP,false,false,true),
		createTime("create_time",Types.TIMESTAMP,false,false,true);
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
	public static class TOrderItemRowMapper implements RowMapper<TOrderItem> {  
        @Override  
        public TOrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TOrderItem tOrderItem = new TOrderItem();
			tOrderItem.setId(rs.getInt("id"));
			tOrderItem.setOrderId(rs.getInt("order_id"));
			tOrderItem.setGoodsId(rs.getInt("goods_id"));
			tOrderItem.setGoodsName(rs.getString("goods_name"));
			tOrderItem.setGoodsImg(rs.getString("goods_img"));
			tOrderItem.setFormats(rs.getString("formats"));
			tOrderItem.setActivitys(rs.getString("activitys"));
			tOrderItem.setNum(rs.getInt("num"));
			tOrderItem.setPrice(rs.getBigDecimal("price"));
			tOrderItem.setMarketPrice(rs.getBigDecimal("market_price"));
			tOrderItem.setRemark(rs.getString("remark"));
			tOrderItem.setDisIs(rs.getInt("dis_is"));
			tOrderItem.setUpdateTime(rs.getTimestamp("update_time"));
			tOrderItem.setCreateTime(rs.getTimestamp("create_time"));
			return tOrderItem; 
        }  
          
    }
}
