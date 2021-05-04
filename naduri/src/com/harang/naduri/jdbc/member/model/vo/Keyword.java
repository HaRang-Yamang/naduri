package com.harang.naduri.jdbc.member.model.vo;

import java.io.Serializable;
//import java.util.ArrayList;

public class Keyword implements Serializable {

	private static final long serialVersionUID = 10091L;

	private int m_no;
	private int keyword_id;
	private String keyword;
	//private ArrayList<Keyword> Keylist;
	
	public Keyword() {}

	public Keyword(int keyword_id) {
		super();
		this.keyword_id = keyword_id;
	}
	

	public Keyword(int m_no, int keyword_id) {
		super();
		this.m_no = m_no;
		this.keyword_id = keyword_id;
	}


	public Keyword(int m_no, int keyword_id, String keyword) {
		super();
		this.m_no = m_no;
		this.keyword_id = keyword_id;
		this.keyword = keyword;
	}
	
	
	@Override
	public String toString() {
		return "Keyword [m_no=" + m_no + ", keyword_id=" + keyword_id + ", keyword=" + keyword + "]";
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