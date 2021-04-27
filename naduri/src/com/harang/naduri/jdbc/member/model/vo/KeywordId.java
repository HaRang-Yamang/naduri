package com.harang.naduri.jdbc.member.model.vo;

import java.io.Serializable;

public class KeywordId implements Serializable {

	private static final long serialVersionUID = 10092L;
	
	private int m_no;
	private int keyword_id;
	
	
	public KeywordId() {}
	
	
	public KeywordId(int m_no, int keyword_id) {
		super();
		this.m_no = m_no;
		this.keyword_id = keyword_id;
	}

	
	@Override
	public String toString() {
		return "KeywordId [m_no=" + m_no + ", keyword_id=" + keyword_id + "]";
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public int getKeyword_id() {
		return keyword_id;
	}

	public void setKeyword_id(int keyword_id) {
		this.keyword_id = keyword_id;
	}
	
	
	
	

}
