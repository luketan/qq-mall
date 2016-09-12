package com.honglinktech.zbgj.base;

public class ReturnPageData {
	private int total;
	private int index;
	private int size;
	
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
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public ReturnPageData(int index, int size,int total, Object results) {
		super();
		this.index = index;
		this.size = size;
		this.total = total;
		this.results = results;
	}
	
}
