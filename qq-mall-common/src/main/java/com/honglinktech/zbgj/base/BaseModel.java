package com.honglinktech.zbgj.base;

public class BaseModel {
	public int pageIndex;
	public int pageSize;
	public String token;
	
	public int getPageIndex() {
		if(pageIndex==0)
			pageIndex = 1;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
