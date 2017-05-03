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
public class TUserBasis extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "用户ID关联t_user.id",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "虚拟币(逗币)",dbName = "virtual_money",length = 10,allowNull=true)
	private BigDecimal virtualMoney=null;
	@FieldMeta(primaryKey = false,fieldName = "账户余额",dbName = "money",length = 10,allowNull=true)
	private BigDecimal money=null;
	@FieldMeta(primaryKey = false,fieldName = "商城积分",dbName = "point",length = 10,allowNull=true)
	private Integer point=null;
	@FieldMeta(primaryKey = false,fieldName = "社区经验",dbName = "exp",length = 10,allowNull=true)
	private Integer exp=null;
	@FieldMeta(primaryKey = false,fieldName = "社区级别",dbName = "level",length = 10,allowNull=true)
	private Integer level=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserBasis(){
 	}
 	public TUserBasis(Integer id,BigDecimal virtualMoney,BigDecimal money,Integer point,Integer exp,Integer level){
 		this.id = id;
		this.virtualMoney = virtualMoney;
		this.money = money;
		this.point = point;
		this.exp = exp;
		this.level = level;
		
 	}
 	
		/*用户ID关联t_user.id*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*虚拟币(逗币)*/
	public BigDecimal getVirtualMoney(){
		 return this.virtualMoney; 
	}
	public void setVirtualMoney(BigDecimal virtualMoney){
		  this.virtualMoney = virtualMoney; 
	}
	/*账户余额*/
	public BigDecimal getMoney(){
		 return this.money; 
	}
	public void setMoney(BigDecimal money){
		  this.money = money; 
	}
	/*商城积分*/
	public Integer getPoint(){
		 return this.point; 
	}
	public void setPoint(Integer point){
		  this.point = point; 
	}
	/*社区经验*/
	public Integer getExp(){
		 return this.exp; 
	}
	public void setExp(Integer exp){
		  this.exp = exp; 
	}
	/*社区级别*/
	public Integer getLevel(){
		 return this.level; 
	}
	public void setLevel(Integer level){
		  this.level = level; 
	}
	/*修改时间*/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}

	
	public enum DBMaping{
		tableName("t_user_basis",0,false,false,false),
		id("id",Types.INTEGER,true,false,false),
		virtualMoney("virtual_money",Types.DECIMAL,false,false,true),
		money("money",Types.DECIMAL,false,false,true),
		point("point",Types.INTEGER,false,false,true),
		exp("exp",Types.INTEGER,false,false,true),
		level("level",Types.INTEGER,false,false,true),
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
	public static class TUserBasisRowMapper implements RowMapper<TUserBasis> {  
        @Override  
        public TUserBasis mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserBasis tUserBasis = new TUserBasis();
			tUserBasis.setId(rs.getInt("id"));
			tUserBasis.setVirtualMoney(rs.getBigDecimal("virtual_money"));
			tUserBasis.setMoney(rs.getBigDecimal("money"));
			tUserBasis.setPoint(rs.getInt("point"));
			tUserBasis.setExp(rs.getInt("exp"));
			tUserBasis.setLevel(rs.getInt("level"));
			tUserBasis.setUpdateTime(rs.getTimestamp("update_time"));
			return tUserBasis; 
        }  
          
    }
}
