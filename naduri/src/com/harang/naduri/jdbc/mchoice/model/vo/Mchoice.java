package com.harang.naduri.jdbc.mchoice.model.vo;

import java.io.Serializable;

public class mchoice implements Serializable{


	private static final long serialVersionUID = 1008L;
	
	private int m_no  ;	//회원번호
	private int Keyword_Id ;	//키워드 식별자
	
	public mchoice() {}

	public mchoice(int m_no, int keyword_Id) {
		super();
		this.m_no = m_no;
		Keyword_Id = keyword_Id;
	}

	@Override
	public String toString() {
		return "mchoice [m_no=" + m_no + ", Keyword_Id=" + Keyword_Id + "]";
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public int getKeyword_Id() {
		return Keyword_Id;
	}

	public void setKeyword_Id(int keyword_Id) {
		Keyword_Id = keyword_Id;
	}
	
	
}
