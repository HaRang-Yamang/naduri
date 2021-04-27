package com.harang.naduri.jdbc.location_sort.model.vo;

import java.io.Serializable;

public class Location_sort implements Serializable{
	

	private static final long serialVersionUID = 1007L;
	
	private int ls_code ;	//장소코드
	private String ls_name ;	//장소분류명
	
	public Location_sort() {}

	public Location_sort(int ls_code, String ls_name) {
		super();
		this.ls_code = ls_code;
		this.ls_name = ls_name;
	}

	@Override
	public String toString() {
		return "location_sort [ls_code=" + ls_code + ", ls_name=" + ls_name + "]";
	}

	public int getLs_code() {
		return ls_code;
	}

	public void setLs_code(int ls_code) {
		this.ls_code = ls_code;
	}

	public String getLs_name() {
		return ls_name;
	}

	public void setLs_name(String ls_name) {
		this.ls_name = ls_name;
	}
	
	
	
	
	
	
	
	
}
