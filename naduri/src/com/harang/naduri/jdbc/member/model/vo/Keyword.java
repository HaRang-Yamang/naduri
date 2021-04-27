package com.harang.naduri.jdbc.member.model.vo;

import java.io.Serializable;
import java.util.Arrays;

public class Keyword implements Serializable {

	private static final long serialVersionUID = 10091L;

	// private String m_no; 만들어야하나??
	private String[] keyword_id;
	
	public Keyword() {}

	public Keyword(String[] keyword_id) {
		super();
		this.keyword_id = keyword_id;
	}

	@Override
	public String toString() {
		return "Keyword [keyword_id=" + Arrays.toString(keyword_id) + "]";
	}

	public String[] getKeyword_id() {
		return keyword_id;
	}

	public void setKeyword_id(String[] keyword_id) {
		this.keyword_id = keyword_id;
	}


	
	
}
