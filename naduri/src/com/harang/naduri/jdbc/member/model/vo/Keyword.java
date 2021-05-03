package com.harang.naduri.jdbc.member.model.vo;

import java.io.Serializable;
//import java.util.ArrayList;

public class Keyword implements Serializable {

	private static final long serialVersionUID = 10091L;

	private int m_no;
	private int keyword_id;
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

	@Override
	public String toString() {
		return "Keyword [keyword_id=" + keyword_id + "]";
	}

	public int getKeyword_id() {
		return keyword_id;
	}

	public void setKeyword_id(int keyword_id) {
		this.keyword_id = keyword_id;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	
	




	
	
}
