package com.honglinktech.zbgj.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseEntity {
	private int index;
	private int size;
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
	
}
