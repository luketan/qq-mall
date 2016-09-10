package com.honglinktech.zbgj.base;

public class ReturnPageData {
	private int total;
	private int pageIndex;
	private int pageSize;
	
	private Object results;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Object getResults() {
		return results;
	}
	public void setResults(Object results) {
		this.results = results;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public ReturnPageData(int pageIndex, int pageSize,int total, Object results) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.total = total;
		this.results = results;
	}
	
}
