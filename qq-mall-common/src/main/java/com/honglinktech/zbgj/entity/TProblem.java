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
*活动
**/
public class TProblem extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "商品类型",dbName = "goods_id",length = 10,allowNull=true)
	private Integer goodsId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_name",length = 50,allowNull=true)
	private String userName=null;
	@FieldMeta(primaryKey = false,fieldName = "活动详情",dbName = "question",length = 225,allowNull=true)
	private String question=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "answer",length = 225,allowNull=true)
	private String answer=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "admin_id",length = 10,allowNull=true)
	private Integer adminId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "admin_name",length = 50,allowNull=true)
	private String adminName=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TProblem(){
 	}
 	public TProblem(Integer id,Integer goodsId,Integer userId,String userName,String question,String answer,Integer adminId,String adminName){
 		this.id = id;
		this.goodsId = goodsId;
		this.userId = userId;
		this.userName = userName;
		this.question = question;
		this.answer = answer;
		this.adminId = adminId;
		this.adminName = adminName;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*商品类型*/
	public Integer getGoodsId(){
		 return this.goodsId; 
	}
	public void setGoodsId(Integer goodsId){
		  this.goodsId = goodsId; 
	}
	/**/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/**/
	public String getUserName(){
		 return this.userName; 
	}
	public void setUserName(String userName){
		  this.userName = userName; 
	}
	/*活动详情*/
	public String getQuestion(){
		 return this.question; 
	}
	public void setQuestion(String question){
		  this.question = question; 
	}
	/**/
	public String getAnswer(){
		 return this.answer; 
	}
	public void setAnswer(String answer){
		  this.answer = answer; 
	}
	/**/
	public Integer getAdminId(){
		 return this.adminId; 
	}
	public void setAdminId(Integer adminId){
		  this.adminId = adminId; 
	}
	/**/
	public String getAdminName(){
		 return this.adminName; 
	}
	public void setAdminName(String adminName){
		  this.adminName = adminName; 
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
		tableName("t_problem",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		goodsId("goods_id",Types.INTEGER,false,false,true),
		userId("user_id",Types.INTEGER,false,false,false),
		userName("user_name",Types.VARCHAR,false,false,true),
		question("question",Types.VARCHAR,false,false,true),
		answer("answer",Types.VARCHAR,false,false,true),
		adminId("admin_id",Types.INTEGER,false,false,true),
		adminName("admin_name",Types.VARCHAR,false,false,true),
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
	public static class TProblemRowMapper implements RowMapper<TProblem> {  
        @Override  
        public TProblem mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TProblem tProblem = new TProblem();
			tProblem.setId(rs.getInt("id"));
			tProblem.setGoodsId(rs.getInt("goods_id"));
			tProblem.setUserId(rs.getInt("user_id"));
			tProblem.setUserName(rs.getString("user_name"));
			tProblem.setQuestion(rs.getString("question"));
			tProblem.setAnswer(rs.getString("answer"));
			tProblem.setAdminId(rs.getInt("admin_id"));
			tProblem.setAdminName(rs.getString("admin_name"));
			tProblem.setCreateTime(rs.getTimestamp("create_time"));
			tProblem.setUpdateTime(rs.getTimestamp("update_time"));
			return tProblem; 
        }  
          
    }
}
