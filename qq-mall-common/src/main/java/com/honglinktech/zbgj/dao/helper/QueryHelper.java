package com.honglinktech.zbgj.dao.helper;

import java.util.List;
import java.util.Map;

public class QueryHelper<T> {  
  
	//页下标
	private Integer index=1;
	//页大小
	private Integer size=10;
	//查询条件
	private String queryWhere;
	// 结果集  
    private List<T> resultList;
    // 总记录数  
    private int totalRow;
    //排序
    private Map<String, String> orderBy;
    //查询条件
    private Map<String, String[]> whereMap;
    
	public Integer getIndex() {
		if(index<=0){
			index=1;
		}
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
	public String getQueryWhere() {
		return queryWhere;
	}
	public void setQueryWhere(String queryWhere) {
		this.queryWhere = queryWhere;
	}
	public Map<String, String> getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(Map<String, String> orderBy) {
		this.orderBy = orderBy;
	}
	public Map<String, String[]> getWhereMap() {
		return whereMap;
	}
	public void setWhereMap(Map<String, String[]> whereMap) {
		this.whereMap = whereMap;
	}
	public QueryHelper(){
		
	}
	public QueryHelper(int index,int size,String queryWhere){
		this.index = index;
		this.size = size;
		this.queryWhere = queryWhere;
	}
	public QueryHelper(int index,int size,Map<String, String[]> whereMap){
		this.index = index;
		this.size = size;
		this.whereMap = whereMap;
	}
	public QueryHelper(Map<String, String[]> whereMap){
		this.whereMap = whereMap;
	}
	public QueryHelper(List<T> resultList, int totalRow) {
		super();
		this.resultList = resultList;
		this.totalRow = totalRow;
	}
	
    @Override
    public String toString() {
    	System.out.println("[pageIndex]->"+index+"[pageSize]->"+size+"[queryWhere]->"+queryWhere+"[totalRow]->"+totalRow+"[orderBy]->"+orderBy+"[whereMap]->"+whereMap+"[resultList]->"+resultList);
    	return super.toString();
    }
}  