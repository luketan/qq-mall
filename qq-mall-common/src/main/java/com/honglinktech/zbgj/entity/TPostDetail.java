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
*快递单详情表
**/
public class TPostDetail extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = false,fieldName = "快递单号",dbName = "post_code",length = 50,allowNull=false)
	private String postCode=null;
	@FieldMeta(primaryKey = false,fieldName = "物流详情描述",dbName = "context",length = 256,allowNull=true)
	private String context=null;
	@FieldMeta(primaryKey = false,fieldName = "地址节点",dbName = "address_node",length = 256,allowNull=true)
	private String addressNode=null;
	@FieldMeta(primaryKey = false,fieldName = "物流时间节点",dbName = "time_node",length = 19,allowNull=false)
	private Date timeNode=null;
	@FieldMeta(primaryKey = false,fieldName = "kd100推送时间",dbName = "push_time",length = 19,allowNull=true)
	private Date pushTime=null;
	@FieldMeta(primaryKey = false,fieldName = "是否签收",dbName = "is_sign_in",length = 1,allowNull=true)
	private String isSignIn=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "company_code",length = 100,allowNull=true)
	private String companyCode=null;
	@FieldMeta(primaryKey = false,fieldName = "删除标志",dbName = "delete_flag",length = 1,allowNull=true)
	private String deleteFlag=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TPostDetail(){
 	}
 	public TPostDetail(String postCode,String context,String addressNode,Date timeNode,Date pushTime,String isSignIn,String companyCode,String deleteFlag){
 		this.postCode = postCode;
		this.context = context;
		this.addressNode = addressNode;
		this.timeNode = timeNode;
		this.pushTime = pushTime;
		this.isSignIn = isSignIn;
		this.companyCode = companyCode;
		this.deleteFlag = deleteFlag;
		
 	}
 	
		/*快递单号*/
	public String getPostCode(){
		 return this.postCode; 
	}
	public void setPostCode(String postCode){
		  this.postCode = postCode; 
	}
	/*物流详情描述*/
	public String getContext(){
		 return this.context; 
	}
	public void setContext(String context){
		  this.context = context; 
	}
	/*地址节点*/
	public String getAddressNode(){
		 return this.addressNode; 
	}
	public void setAddressNode(String addressNode){
		  this.addressNode = addressNode; 
	}
	/*物流时间节点*/
	public Date getTimeNode(){
		 return this.timeNode; 
	}
	public void setTimeNode(Date timeNode){
		  this.timeNode = timeNode; 
	}
	/*kd100推送时间*/
	public Date getPushTime(){
		 return this.pushTime; 
	}
	public void setPushTime(Date pushTime){
		  this.pushTime = pushTime; 
	}
	/*是否签收*/
	public String getIsSignIn(){
		 return this.isSignIn; 
	}
	public void setIsSignIn(String isSignIn){
		  this.isSignIn = isSignIn; 
	}
	/**/
	public String getCompanyCode(){
		 return this.companyCode; 
	}
	public void setCompanyCode(String companyCode){
		  this.companyCode = companyCode; 
	}
	/*删除标志*/
	public String getDeleteFlag(){
		 return this.deleteFlag; 
	}
	public void setDeleteFlag(String deleteFlag){
		  this.deleteFlag = deleteFlag; 
	}

	
	public enum DBMaping{
		tableName("t_post_detail",0,false,false,false),
		postCode("post_code",Types.VARCHAR,false,false,false),
		context("context",Types.VARCHAR,false,false,true),
		addressNode("address_node",Types.VARCHAR,false,false,true),
		timeNode("time_node",Types.TIMESTAMP,false,false,false),
		pushTime("push_time",Types.TIMESTAMP,false,false,true),
		isSignIn("is_sign_in",Types.CHAR,false,false,true),
		companyCode("company_code",Types.VARCHAR,false,false,true),
		deleteFlag("delete_flag",Types.CHAR,false,false,true);
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
	public static class TPostDetailRowMapper implements RowMapper<TPostDetail> {  
        @Override  
        public TPostDetail mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TPostDetail tPostDetail = new TPostDetail();
			tPostDetail.setPostCode(rs.getString("post_code"));
			tPostDetail.setContext(rs.getString("context"));
			tPostDetail.setAddressNode(rs.getString("address_node"));
			tPostDetail.setTimeNode(rs.getTimestamp("time_node"));
			tPostDetail.setPushTime(rs.getTimestamp("push_time"));
			tPostDetail.setIsSignIn(rs.getString("is_sign_in"));
			tPostDetail.setCompanyCode(rs.getString("company_code"));
			tPostDetail.setDeleteFlag(rs.getString("delete_flag"));
			return tPostDetail; 
        }  
          
    }
}
