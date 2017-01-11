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
public class TGoods extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "商品名称",dbName = "name",length = 255,allowNull=false)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "子标题（提醒）",dbName = "sub_name",length = 255,allowNull=true)
	private String subName=null;
	@FieldMeta(primaryKey = false,fieldName = "商品详情",dbName = "detail",length = 65535,allowNull=true)
	private String detail=null;
	@FieldMeta(primaryKey = false,fieldName = "售出数量",dbName = "sales_num",length = 10,allowNull=true)
	private Integer salesNum=null;
	@FieldMeta(primaryKey = false,fieldName = "库存数量",dbName = "keep_num",length = 10,allowNull=true)
	private Integer keepNum=null;
	@FieldMeta(primaryKey = false,fieldName = "市场价",dbName = "mark_price",length = 10,allowNull=true)
	private BigDecimal markPrice=null;
	@FieldMeta(primaryKey = false,fieldName = "原价",dbName = "former_price",length = 10,allowNull=true)
	private BigDecimal formerPrice=null;
	@FieldMeta(primaryKey = false,fieldName = "现在价格",dbName = "price",length = 10,allowNull=true)
	private BigDecimal price=null;
	@FieldMeta(primaryKey = false,fieldName = "评论数量",dbName = "discuss_num",length = 10,allowNull=true)
	private Integer discussNum=null;
	@FieldMeta(primaryKey = false,fieldName = "促销名字",dbName = "promo_name",length = 225,allowNull=true)
	private String promoName=null;
	@FieldMeta(primaryKey = false,fieldName = "促销价",dbName = "promo_price",length = 10,allowNull=true)
	private BigDecimal promoPrice=null;
	@FieldMeta(primaryKey = false,fieldName = "是否促销",dbName = "promo_is",length = 10,allowNull=true)
	private Integer promoIs=null;
	@FieldMeta(primaryKey = false,fieldName = "是否热卖",dbName = "hot_is",length = 10,allowNull=true)
	private Integer hotIs=null;
	@FieldMeta(primaryKey = false,fieldName = "是否是精品",dbName = "gifts_is",length = 10,allowNull=true)
	private Integer giftsIs=null;
	@FieldMeta(primaryKey = false,fieldName = "品牌ID",dbName = "brand_id",length = 10,allowNull=true)
	private Integer brandId=null;
	@FieldMeta(primaryKey = false,fieldName = "品牌名称",dbName = "brand_name",length = 128,allowNull=true)
	private String brandName=null;
	@FieldMeta(primaryKey = false,fieldName = "类别ID",dbName = "type_id",length = 10,allowNull=true)
	private Integer typeId=null;
	@FieldMeta(primaryKey = false,fieldName = "类别名称",dbName = "type_name",length = 128,allowNull=true)
	private String typeName=null;
	@FieldMeta(primaryKey = false,fieldName = "子类别(款式)ID",dbName = "type_sub_id",length = 10,allowNull=true)
	private Integer typeSubId=null;
	@FieldMeta(primaryKey = false,fieldName = "子类别(款式)名称",dbName = "type_sub_name",length = 128,allowNull=true)
	private String typeSubName=null;
	@FieldMeta(primaryKey = false,fieldName = "收藏数量",dbName = "collect_num",length = 10,allowNull=true)
	private Integer collectNum=null;
	@FieldMeta(primaryKey = false,fieldName = "商品状态（1正常,2已售完，3已下架,4删除，5待审核）",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "主图路径",dbName = "img_url",length = 225,allowNull=true)
	private String imgUrl=null;
	@FieldMeta(primaryKey = false,fieldName = "排序",dbName = "sort",length = 10,allowNull=true)
	private Integer sort=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGoods(){
 	}
 	public TGoods(Integer id,String name,String subName,String detail,Integer salesNum,Integer keepNum,BigDecimal markPrice,BigDecimal formerPrice,BigDecimal price,Integer discussNum,String promoName,BigDecimal promoPrice,Integer promoIs,Integer hotIs,Integer giftsIs,Integer brandId,String brandName,Integer typeId,String typeName,Integer typeSubId,String typeSubName,Integer collectNum,Integer status,String imgUrl,Integer sort){
 		this.id = id;
		this.name = name;
		this.subName = subName;
		this.detail = detail;
		this.salesNum = salesNum;
		this.keepNum = keepNum;
		this.markPrice = markPrice;
		this.formerPrice = formerPrice;
		this.price = price;
		this.discussNum = discussNum;
		this.promoName = promoName;
		this.promoPrice = promoPrice;
		this.promoIs = promoIs;
		this.hotIs = hotIs;
		this.giftsIs = giftsIs;
		this.brandId = brandId;
		this.brandName = brandName;
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeSubId = typeSubId;
		this.typeSubName = typeSubName;
		this.collectNum = collectNum;
		this.status = status;
		this.imgUrl = imgUrl;
		this.sort = sort;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*商品名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*子标题（提醒）*/
	public String getSubName(){
		 return this.subName; 
	}
	public void setSubName(String subName){
		  this.subName = subName; 
	}
	/*商品详情*/
	public String getDetail(){
		 return this.detail; 
	}
	public void setDetail(String detail){
		  this.detail = detail; 
	}
	/*售出数量*/
	public Integer getSalesNum(){
		 return this.salesNum; 
	}
	public void setSalesNum(Integer salesNum){
		  this.salesNum = salesNum; 
	}
	/*库存数量*/
	public Integer getKeepNum(){
		 return this.keepNum; 
	}
	public void setKeepNum(Integer keepNum){
		  this.keepNum = keepNum; 
	}
	/*市场价*/
	public BigDecimal getMarkPrice(){
		 return this.markPrice; 
	}
	public void setMarkPrice(BigDecimal markPrice){
		  this.markPrice = markPrice; 
	}
	/*原价*/
	public BigDecimal getFormerPrice(){
		 return this.formerPrice; 
	}
	public void setFormerPrice(BigDecimal formerPrice){
		  this.formerPrice = formerPrice; 
	}
	/*现在价格*/
	public BigDecimal getPrice(){
		 return this.price; 
	}
	public void setPrice(BigDecimal price){
		  this.price = price; 
	}
	/*评论数量*/
	public Integer getDiscussNum(){
		 return this.discussNum; 
	}
	public void setDiscussNum(Integer discussNum){
		  this.discussNum = discussNum; 
	}
	/*促销名字*/
	public String getPromoName(){
		 return this.promoName; 
	}
	public void setPromoName(String promoName){
		  this.promoName = promoName; 
	}
	/*促销价*/
	public BigDecimal getPromoPrice(){
		 return this.promoPrice; 
	}
	public void setPromoPrice(BigDecimal promoPrice){
		  this.promoPrice = promoPrice; 
	}
	/*是否促销*/
	public Integer getPromoIs(){
		 return this.promoIs; 
	}
	public void setPromoIs(Integer promoIs){
		  this.promoIs = promoIs; 
	}
	/*是否热卖*/
	public Integer getHotIs(){
		 return this.hotIs; 
	}
	public void setHotIs(Integer hotIs){
		  this.hotIs = hotIs; 
	}
	/*是否是精品*/
	public Integer getGiftsIs(){
		 return this.giftsIs; 
	}
	public void setGiftsIs(Integer giftsIs){
		  this.giftsIs = giftsIs; 
	}
	/*品牌ID*/
	public Integer getBrandId(){
		 return this.brandId; 
	}
	public void setBrandId(Integer brandId){
		  this.brandId = brandId; 
	}
	/*品牌名称*/
	public String getBrandName(){
		 return this.brandName; 
	}
	public void setBrandName(String brandName){
		  this.brandName = brandName; 
	}
	/*类别ID*/
	public Integer getTypeId(){
		 return this.typeId; 
	}
	public void setTypeId(Integer typeId){
		  this.typeId = typeId; 
	}
	/*类别名称*/
	public String getTypeName(){
		 return this.typeName; 
	}
	public void setTypeName(String typeName){
		  this.typeName = typeName; 
	}
	/*子类别(款式)ID*/
	public Integer getTypeSubId(){
		 return this.typeSubId; 
	}
	public void setTypeSubId(Integer typeSubId){
		  this.typeSubId = typeSubId; 
	}
	/*子类别(款式)名称*/
	public String getTypeSubName(){
		 return this.typeSubName; 
	}
	public void setTypeSubName(String typeSubName){
		  this.typeSubName = typeSubName; 
	}
	/*收藏数量*/
	public Integer getCollectNum(){
		 return this.collectNum; 
	}
	public void setCollectNum(Integer collectNum){
		  this.collectNum = collectNum; 
	}
	/*商品状态（1正常,2已售完，3已下架,4删除，5待审核）*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/*主图路径*/
	public String getImgUrl(){
		 return this.imgUrl; 
	}
	public void setImgUrl(String imgUrl){
		  this.imgUrl = imgUrl; 
	}
	/*排序*/
	public Integer getSort(){
		 return this.sort; 
	}
	public void setSort(Integer sort){
		  this.sort = sort; 
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
		tableName("t_goods",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,false),
		subName("sub_name",Types.VARCHAR,false,false,true),
		detail("detail",Types.LONGVARCHAR,false,false,true),
		salesNum("sales_num",Types.INTEGER,false,false,true),
		keepNum("keep_num",Types.INTEGER,false,false,true),
		markPrice("mark_price",Types.DECIMAL,false,false,true),
		formerPrice("former_price",Types.DECIMAL,false,false,true),
		price("price",Types.DECIMAL,false,false,true),
		discussNum("discuss_num",Types.INTEGER,false,false,true),
		promoName("promo_name",Types.VARCHAR,false,false,true),
		promoPrice("promo_price",Types.DECIMAL,false,false,true),
		promoIs("promo_is",Types.INTEGER,false,false,true),
		hotIs("hot_is",Types.INTEGER,false,false,true),
		giftsIs("gifts_is",Types.INTEGER,false,false,true),
		brandId("brand_id",Types.INTEGER,false,false,true),
		brandName("brand_name",Types.VARCHAR,false,false,true),
		typeId("type_id",Types.INTEGER,false,false,true),
		typeName("type_name",Types.VARCHAR,false,false,true),
		typeSubId("type_sub_id",Types.INTEGER,false,false,true),
		typeSubName("type_sub_name",Types.VARCHAR,false,false,true),
		collectNum("collect_num",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		imgUrl("img_url",Types.VARCHAR,false,false,true),
		sort("sort",Types.INTEGER,false,false,true),
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
	public static class TGoodsRowMapper implements RowMapper<TGoods> {  
        @Override  
        public TGoods mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGoods tGoods = new TGoods();
			tGoods.setId(rs.getInt("id"));
			tGoods.setName(rs.getString("name"));
			tGoods.setSubName(rs.getString("sub_name"));
			tGoods.setDetail(rs.getString("detail"));
			tGoods.setSalesNum(rs.getInt("sales_num"));
			tGoods.setKeepNum(rs.getInt("keep_num"));
			tGoods.setMarkPrice(rs.getBigDecimal("mark_price"));
			tGoods.setFormerPrice(rs.getBigDecimal("former_price"));
			tGoods.setPrice(rs.getBigDecimal("price"));
			tGoods.setDiscussNum(rs.getInt("discuss_num"));
			tGoods.setPromoName(rs.getString("promo_name"));
			tGoods.setPromoPrice(rs.getBigDecimal("promo_price"));
			tGoods.setPromoIs(rs.getInt("promo_is"));
			tGoods.setHotIs(rs.getInt("hot_is"));
			tGoods.setGiftsIs(rs.getInt("gifts_is"));
			tGoods.setBrandId(rs.getInt("brand_id"));
			tGoods.setBrandName(rs.getString("brand_name"));
			tGoods.setTypeId(rs.getInt("type_id"));
			tGoods.setTypeName(rs.getString("type_name"));
			tGoods.setTypeSubId(rs.getInt("type_sub_id"));
			tGoods.setTypeSubName(rs.getString("type_sub_name"));
			tGoods.setCollectNum(rs.getInt("collect_num"));
			tGoods.setStatus(rs.getInt("status"));
			tGoods.setImgUrl(rs.getString("img_url"));
			tGoods.setSort(rs.getInt("sort"));
			tGoods.setUpdateTime(rs.getTimestamp("update_time"));
			tGoods.setCreateTime(rs.getTimestamp("create_time"));
			return tGoods; 
        }  
          
    }
}
