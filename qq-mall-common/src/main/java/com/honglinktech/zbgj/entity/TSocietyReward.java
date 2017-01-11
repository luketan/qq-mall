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
*社区打赏
**/
public class TSocietyReward extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "society_note_id",length = 10,allowNull=false)
	private Integer societyNoteId=null;
	@FieldMeta(primaryKey = false,fieldName = "收的",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "出的",dbName = "bus_user_id",length = 10,allowNull=true)
	private Integer busUserId=null;
	@FieldMeta(primaryKey = false,fieldName = "1打赏类型逗币，",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "价值数量",dbName = "val_num",length = 10,allowNull=true)
	private Integer valNum=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSocietyReward(){
 	}
 	public TSocietyReward(Integer id,Integer societyNoteId,Integer userId,Integer busUserId,Integer type,Integer valNum){
 		this.id = id;
		this.societyNoteId = societyNoteId;
		this.userId = userId;
		this.busUserId = busUserId;
		this.type = type;
		this.valNum = valNum;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/**/
	public Integer getSocietyNoteId(){
		 return this.societyNoteId; 
	}
	public void setSocietyNoteId(Integer societyNoteId){
		  this.societyNoteId = societyNoteId; 
	}
	/*收的*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*出的*/
	public Integer getBusUserId(){
		 return this.busUserId; 
	}
	public void setBusUserId(Integer busUserId){
		  this.busUserId = busUserId; 
	}
	/*1打赏类型逗币，*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*价值数量*/
	public Integer getValNum(){
		 return this.valNum; 
	}
	public void setValNum(Integer valNum){
		  this.valNum = valNum; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

	
	public enum DBMaping{
		tableName("t_society_reward",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		societyNoteId("society_note_id",Types.INTEGER,false,false,false),
		userId("user_id",Types.INTEGER,false,false,false),
		busUserId("bus_user_id",Types.INTEGER,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		valNum("val_num",Types.INTEGER,false,false,true),
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
	public static class TSocietyRewardRowMapper implements RowMapper<TSocietyReward> {  
        @Override  
        public TSocietyReward mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSocietyReward tSocietyReward = new TSocietyReward();
			tSocietyReward.setId(rs.getInt("id"));
			tSocietyReward.setSocietyNoteId(rs.getInt("society_note_id"));
			tSocietyReward.setUserId(rs.getInt("user_id"));
			tSocietyReward.setBusUserId(rs.getInt("bus_user_id"));
			tSocietyReward.setType(rs.getInt("type"));
			tSocietyReward.setValNum(rs.getInt("val_num"));
			tSocietyReward.setCreateTime(rs.getTimestamp("create_time"));
			return tSocietyReward; 
        }  
          
    }
}
