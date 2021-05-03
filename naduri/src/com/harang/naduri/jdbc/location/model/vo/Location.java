package com.harang.naduri.jdbc.location.model.vo;

import java.io.Serializable;

public class Location implements Serializable{
	
	private static final long serialVersionUID = 1005L;
	
	// location table
	private int l_no;
	private int ls_code;
	
	
	// location_keyword table

	
	// keyword table
	private int keyword_id;
	private String keyword;
	
	public Location() {}
	
	
	public Location(int l_no, int ls_code) {
		super();
		this.l_no = l_no;
		this.ls_code = ls_code;
	}



	public Location(int keyword_id, String keyword) {
		super();
		this.keyword_id = keyword_id;
		this.keyword = keyword;
	}



	public Location(int l_no, int ls_code, int keyword_id, String keyword) {
		super();
		this.l_no = l_no;
		this.ls_code = ls_code;
		this.keyword_id = keyword_id;
		this.keyword = keyword;
	}

	
	
	
	@Override
	public String toString() {
		return "Location [l_no=" + l_no + ", ls_code=" + ls_code + ", keyword_id=" + keyword_id + ", keyword=" + keyword
				+ "]";
	}

	public int getL_no() {
		return l_no;
	}

	public void setL_no(int l_no) {
		this.l_no = l_no;
	}

	public int getLs_code() {
		return ls_code;
	}

	public void setLs_code(int ls_code) {
		this.ls_code = ls_code;
	}

	public int getKeyword_id() {
		return keyword_id;
	}

	public void setKeyword_id(int keyword_id) {
		this.keyword_id = keyword_id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
