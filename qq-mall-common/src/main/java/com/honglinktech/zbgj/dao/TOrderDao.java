package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TOrder;
/**
*订单信息Dao
**/
@Component
public class TOrderDao extends BaseDao<TOrder>{
	public enum DBMaping{
		tableName("t_order",0,false,false,false),
		id("id",Types.INTEGER,true,false,false),
		orderCode("order_code",Types.VARCHAR,false,false,true),
		userId("user_id",Types.INTEGER,false,false,false),
		money("money",Types.DECIMAL,false,false,true),
		postMoney("post_money",Types.DECIMAL,false,false,true),
		payType("pay_type",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		form("form",Types.INTEGER,false,false,true),
		postCode("post_code",Types.VARCHAR,false,false,true),
		remark("remark",Types.VARCHAR,false,false,true),
		invoiceIs("invoice_is",Types.INTEGER,false,false,true),
		invoiceHead("invoice_head",Types.VARCHAR,false,false,true),
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
	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		super.jdbcTemplate = jdbcTemplate;
	}
	public JdbcTemplate jdbcTemplate(){
		return jdbcTemplate;
	}
	
	public class TOrderRowMapper implements RowMapper<TOrder> {  
        @Override  
        public TOrder mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TOrder tOrder = new TOrder();
			tOrder.setId(rs.getInt("id"));
			tOrder.setOrderCode(rs.getString("order_code"));
			tOrder.setUserId(rs.getInt("user_id"));
			tOrder.setMoney(rs.getBigDecimal("money"));
			tOrder.setPostMoney(rs.getBigDecimal("post_money"));
			tOrder.setPayType(rs.getInt("pay_type"));
			tOrder.setStatus(rs.getInt("status"));
			tOrder.setForm(rs.getInt("form"));
			tOrder.setPostCode(rs.getString("post_code"));
			tOrder.setRemark(rs.getString("remark"));
			tOrder.setInvoiceIs(rs.getInt("invoice_is"));
			tOrder.setInvoiceHead(rs.getString("invoice_head"));
			tOrder.setUpdateTime(rs.getTimestamp("update_time"));
			tOrder.setCreateTime(rs.getTimestamp("create_time"));
			return tOrder; 
        }  
          
    }  
	@Override
	protected RowMapper<TOrder> getRowMapper() {
		return new TOrderRowMapper();
	}
}
