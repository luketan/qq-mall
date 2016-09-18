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
*注册用户推荐奖励
**/
public class TUserRec extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "用户id",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "rec_user_id",length = 10,allowNull=false)
	private Integer recUserId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "rec_user_name",length = 20,allowNull=true)
	private String recUserName=null;
	@FieldMeta(primaryKey = false,fieldName = "奖励类型（1逗币）",dbName = "award_type",length = 10,allowNull=true)
	private Integer awardType=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "award_num",length = 10,allowNull=true)
	private Integer awardNum=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserRec(){
 	}
 	public TUserRec(Integer id,Integer userId,Integer recUserId,String recUserName,Integer awardType,Integer awardNum){
 		this.id = id;
		this.userId = userId;
		this.recUserId = recUserId;
		this.recUserName = recUserName;
		this.awardType = awardType;
		this.awardNum = awardNum;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*用户id*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/**/
	public Integer getRecUserId(){
		 return this.recUserId; 
	}
	public void setRecUserId(Integer recUserId){
		  this.recUserId = recUserId; 
	}
	/**/
	public String getRecUserName(){
		 return this.recUserName; 
	}
	public void setRecUserName(String recUserName){
		  this.recUserName = recUserName; 
	}
	/*奖励类型（1逗币）*/
	public Integer getAwardType(){
		 return this.awardType; 
	}
	public void setAwardType(Integer awardType){
		  this.awardType = awardType; 
	}
	/**/
	public Integer getAwardNum(){
		 return this.awardNum; 
	}
	public void setAwardNum(Integer awardNum){
		  this.awardNum = awardNum; 
	}
	/**/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

	
	public enum DBMaping{
		tableName("t_user_rec",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,false),
		recUserId("rec_user_id",Types.INTEGER,false,false,false),
		recUserName("rec_user_name",Types.VARCHAR,false,false,true),
		awardType("award_type",Types.INTEGER,false,false,true),
		awardNum("award_num",Types.INTEGER,false,false,true),
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
	public static class TUserRecRowMapper implements RowMapper<TUserRec> {  
        @Override  
        public TUserRec mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserRec tUserRec = new TUserRec();
			tUserRec.setId(rs.getInt("id"));
			tUserRec.setUserId(rs.getInt("user_id"));
			tUserRec.setRecUserId(rs.getInt("rec_user_id"));
			tUserRec.setRecUserName(rs.getString("rec_user_name"));
			tUserRec.setAwardType(rs.getInt("award_type"));
			tUserRec.setAwardNum(rs.getInt("award_num"));
			tUserRec.setCreateTime(rs.getTimestamp("create_time"));
			return tUserRec; 
        }  
          
    }
}
