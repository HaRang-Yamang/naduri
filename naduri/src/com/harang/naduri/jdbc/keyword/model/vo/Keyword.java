package com.harang.naduri.jdbc.keyword.model.vo;

import java.io.Serializable;

public class Keyword implements Serializable{
	
	private static final long serialVersionUID = 1004L;
	
	private int keyword_id;
	private String keyword;
	
	
	public Keyword() { }


	public Keyword(int keyword_id, String keyword) {
		super();
		this.keyword_id = keyword_id;
		this.keyword = keyword;
	}


	@Override
	public String toString() {
		return "Keyword [keyword_id=" + keyword_id + ", keyword=" + keyword + "]";
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
