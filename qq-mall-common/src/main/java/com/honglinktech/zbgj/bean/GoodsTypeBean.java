package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.entity.TGoodsType;
import com.honglinktech.zbgj.entity.TGoodsTypeSub;


/**
*
**/
public class GoodsTypeBean implements Serializable{

	private Integer id=null;
	private String name=null;
	private String ico=null;
	private String img=null;
	private String search=null;
	private String summary=null;
	
	private List<TGoodsTypeSub> tgoodsTypeSubList;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GoodsTypeBean(){
 	}
 	public GoodsTypeBean(TGoodsType goodsType){
 		this.id = goodsType.getId();
		this.name = goodsType.getName();
		this.ico = goodsType.getIco();
		this.img = goodsType.getImg();
		this.search = goodsType.getSearch();
		this.summary = goodsType.getSummary();
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*类别名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*类型图标*/
	public String getIco(){
		 return this.ico; 
	}
	public void setIco(String ico){
		  this.ico = ico; 
	}
	/*类型图片*/
	public String getImg(){
		 return this.img; 
	}
	public void setImg(String img){
		  this.img = img; 
	}
	/**/
	public String getSearch(){
		 return this.search; 
	}
	public void setSearch(String search){
		  this.search = search; 
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public List<TGoodsTypeSub> getTgoodsTypeSubList() {
		return tgoodsTypeSubList;
	}
	public void setTgoodsTypeSubList(List<TGoodsTypeSub> tgoodsTypeSubList) {
		this.tgoodsTypeSubList = tgoodsTypeSubList;
	}


	public enum DBMaping{
		tableName("t_goods_type",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,false),
		ico("ico",Types.VARCHAR,false,false,true),
		img("img",Types.VARCHAR,false,false,true),
		search("search",Types.VARCHAR,false,false,true),
		summary("summary",Types.VARCHAR,false,false,true);
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
	public static class GoodsTypeBeanRowMapper implements RowMapper<GoodsTypeBean> {  
        @Override  
        public GoodsTypeBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

        	GoodsTypeBean goodsTypeBean = new GoodsTypeBean();
        	goodsTypeBean.setId(rs.getInt("id"));
        	goodsTypeBean.setName(rs.getString("name"));
        	goodsTypeBean.setIco(rs.getString("ico"));
        	goodsTypeBean.setImg(rs.getString("img"));
        	goodsTypeBean.setSearch(rs.getString("search"));
        	goodsTypeBean.setSummary(rs.getString("summary"));
			return goodsTypeBean; 
        }  
          
    }
}
