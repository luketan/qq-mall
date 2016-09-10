package com.honglinktech.zbgj.dao.helper;

import java.util.List;
import java.util.Map;

public class QueryHelper<T> {  
  
	//页下标
	private Integer pageIndex=1;
	//页大小
	private Integer pageSize=10;
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
    
	public Integer getPageIndex() {
		if(pageIndex==0){
			pageIndex=1;
		}
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
	public QueryHelper(int pageIndex,int pageSize,String queryWhere){
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.queryWhere = queryWhere;
	}
	public QueryHelper(int pageIndex,int pageSize,Map<String, String[]> whereMap){
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
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
    	System.out.println("[pageIndex]->"+pageIndex+"[pageSize]->"+pageSize+"[queryWhere]->"+queryWhere+"[totalRow]->"+totalRow+"[orderBy]->"+orderBy+"[whereMap]->"+whereMap+"[resultList]->"+resultList);
    	return super.toString();
    }
}  