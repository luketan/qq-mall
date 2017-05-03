package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.math.BigDecimal; 


/**
*
**/
public class TUserRanking extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "用户ID关联t_user.id",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "打赏周",dbName = "play_reward",length = 10,allowNull=true)
	private BigDecimal playReward=null;
	@FieldMeta(primaryKey = false,fieldName = "打赏总",dbName = "play_reward_total",length = 10,allowNull=true)
	private BigDecimal playRewardTotal=null;
	@FieldMeta(primaryKey = false,fieldName = "打赏排名",dbName = "play_reward_rank",length = 10,allowNull=true)
	private Integer playRewardRank=null;
	@FieldMeta(primaryKey = false,fieldName = "获得奖励总",dbName = "get_reward",length = 10,allowNull=true)
	private BigDecimal getReward=null;
	@FieldMeta(primaryKey = false,fieldName = "账户余额",dbName = "get_reward_total",length = 10,allowNull=true)
	private BigDecimal getRewardTotal=null;
	@FieldMeta(primaryKey = false,fieldName = "商城积分",dbName = "get_reward_rank",length = 10,allowNull=true)
	private Integer getRewardRank=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserRanking(){
 	}
 	public TUserRanking(Integer id,BigDecimal playReward,BigDecimal playRewardTotal,Integer playRewardRank,BigDecimal getReward,BigDecimal getRewardTotal,Integer getRewardRank){
 		this.id = id;
		this.playReward = playReward;
		this.playRewardTotal = playRewardTotal;
		this.playRewardRank = playRewardRank;
		this.getReward = getReward;
		this.getRewardTotal = getRewardTotal;
		this.getRewardRank = getRewardRank;
		
 	}
 	
		/*用户ID关联t_user.id*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*打赏周*/
	public BigDecimal getPlayReward(){
		 return this.playReward; 
	}
	public void setPlayReward(BigDecimal playReward){
		  this.playReward = playReward; 
	}
	/*打赏总*/
	public BigDecimal getPlayRewardTotal(){
		 return this.playRewardTotal; 
	}
	public void setPlayRewardTotal(BigDecimal playRewardTotal){
		  this.playRewardTotal = playRewardTotal; 
	}
	/*打赏排名*/
	public Integer getPlayRewardRank(){
		 return this.playRewardRank; 
	}
	public void setPlayRewardRank(Integer playRewardRank){
		  this.playRewardRank = playRewardRank; 
	}
	/*获得奖励总*/
	public BigDecimal getGetReward(){
		 return this.getReward; 
	}
	public void setGetReward(BigDecimal getReward){
		  this.getReward = getReward; 
	}
	/*账户余额*/
	public BigDecimal getGetRewardTotal(){
		 return this.getRewardTotal; 
	}
	public void setGetRewardTotal(BigDecimal getRewardTotal){
		  this.getRewardTotal = getRewardTotal; 
	}
	/*商城积分*/
	public Integer getGetRewardRank(){
		 return this.getRewardRank; 
	}
	public void setGetRewardRank(Integer getRewardRank){
		  this.getRewardRank = getRewardRank; 
	}

	
	public enum DBMaping{
		tableName("t_user_ranking",0,false,false,false),
		id("id",Types.INTEGER,true,false,false),
		playReward("play_reward",Types.DECIMAL,false,false,true),
		playRewardTotal("play_reward_total",Types.DECIMAL,false,false,true),
		playRewardRank("play_reward_rank",Types.INTEGER,false,false,true),
		getReward("get_reward",Types.DECIMAL,false,false,true),
		getRewardTotal("get_reward_total",Types.DECIMAL,false,false,true),
		getRewardRank("get_reward_rank",Types.INTEGER,false,false,true);
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
	public static class TUserRankingRowMapper implements RowMapper<TUserRanking> {  
        @Override  
        public TUserRanking mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserRanking tUserRanking = new TUserRanking();
			tUserRanking.setId(rs.getInt("id"));
			tUserRanking.setPlayReward(rs.getBigDecimal("play_reward"));
			tUserRanking.setPlayRewardTotal(rs.getBigDecimal("play_reward_total"));
			tUserRanking.setPlayRewardRank(rs.getInt("play_reward_rank"));
			tUserRanking.setGetReward(rs.getBigDecimal("get_reward"));
			tUserRanking.setGetRewardTotal(rs.getBigDecimal("get_reward_total"));
			tUserRanking.setGetRewardRank(rs.getInt("get_reward_rank"));
			return tUserRanking; 
        }  
          
    }
}
