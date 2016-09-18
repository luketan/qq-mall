package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*商品活动
**/
public class TGoodsActivity extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "商品ID",dbName = "goods_id",length = 10,allowNull=false)
	private Integer goodsId=null;
	@FieldMeta(primaryKey = true,fieldName = "活动ID",dbName = "activity_id",length = 10,allowNull=false)
	private Integer activityId=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGoodsActivity(){
 	}
 	public TGoodsActivity(Integer goodsId,Integer activityId){
 		this.goodsId = goodsId;
		this.activityId = activityId;
		
 	}
 	
		/*商品ID*/
	public Integer getGoodsId(){
		 return this.goodsId; 
	}
	public void setGoodsId(Integer goodsId){
		  this.goodsId = goodsId; 
	}
	/*活动ID*/
	public Integer getActivityId(){
		 return this.activityId; 
	}
	public void setActivityId(Integer activityId){
		  this.activityId = activityId; 
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
		tableName("t_goods_activity",0,false,false,false),
		goodsId("goods_id",Types.INTEGER,true,false,false),
		activityId("activity_id",Types.INTEGER,true,false,false),
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
	public static class TGoodsActivityRowMapper implements RowMapper<TGoodsActivity> {  
        @Override  
        public TGoodsActivity mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGoodsActivity tGoodsActivity = new TGoodsActivity();
			tGoodsActivity.setGoodsId(rs.getInt("goods_id"));
			tGoodsActivity.setActivityId(rs.getInt("activity_id"));
			tGoodsActivity.setCreateTime(rs.getTimestamp("create_time"));
			tGoodsActivity.setUpdateTime(rs.getTimestamp("update_time"));
			return tGoodsActivity; 
        }  
          
    }
}
