package com.harang.naduri.jdbc.member.model.vo;

import java.io.Serializable;

public class KeywordId implements Serializable{
	
	private static final long serialVersionUId = 1209L;
	
	private int keyword_id;
	private String keyword;
	
	
	public KeywordId() { }

	
	public KeywordId(int keyword_id, String keyword) {
		super();
		this.keyword_id = keyword_id;
		this.keyword = keyword;
	}

	
	@Override
	public String toString() {
		return "KeywordId [keyword_id=" + keyword_id + ", keyword=" + keyword + "]";
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
	
	

}
