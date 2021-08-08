package com.harang.naduri.jdbc.location_keyworld.model.vo;

import java.io.Serializable;

public class Location_keyword implements Serializable {

	private static final long serialVersionUID = 1006L;
	
	private int l_no;	//장소번호
	private int keyword_id;	//키워드 식별자
	
	public Location_keyword() {}

	public Location_keyword(int l_no, int keyword_id) {
		super();
		this.l_no = l_no;
		this.keyword_id = keyword_id;
	}

	@Override
	public String toString() {
		return "location_keyword [l_no=" + l_no + ", keyword_id=" + keyword_id + "]";
	}

	public int getL_no() {
		return l_no;
	}

	public void setL_no(int l_no) {
		this.l_no = l_no;
	}

	public int getKeyword_id() {
		return keyword_id;
	}

	public void setKeyword_id(int keyword_id) {
		this.keyword_id = keyword_id;
	}
	
	
	
	
}
	
