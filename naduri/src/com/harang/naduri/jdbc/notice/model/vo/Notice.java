package com.harang.naduri.jdbc.notice.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Notice implements Serializable {

	private static final long serialVersionUID = 1010L;
	
	private int n_no ;		// 글번호
	private String n_title ;	// 제목
	private String n_content ;	// 내용
	private Date n_date ;       // 작성일
	private int m_no;			// 회원번호
	private String n_file ; 	// 공지사항 첨부파일

	
	
	public Notice() {}
	

	// 전체
	public Notice(int n_no, String n_title, String n_content, Date n_date, int m_no, String n_file) {
		super();
		this.n_no = n_no;
		this.n_title = n_title;
		this.n_content = n_content;
		this.n_date = n_date;
		this.m_no = m_no;
		this.n_file = n_file;
	}


	// 공지사항 게시글 작성할 때
	public Notice(String n_title, String n_content, String n_file) {
		super();
		this.n_title = n_title;
		this.n_content = n_content;
		this.n_file = n_file;
	}
	
	// 게시물 하나 조회할 때
	


	
	

	@Override
	public String toString() {
		return "Notice [n_no=" + n_no + ", n_title=" + n_title + ", n_content=" + n_content + ", n_date=" + n_date
				+ ", m_no=" + m_no + ", n_file=" + n_file + "]";
	}


	public int getN_no() {
		return n_no;
	}

	public void setN_no(int n_no) {
		this.n_no = n_no;
	}

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public Date getN_date() {
		return n_date;
	}

	public void setN_date(Date n_date) {
		this.n_date = n_date;
	}

	public String getN_file() {
		return n_file;
	}

	public void setN_file(String n_file) {
		this.n_file = n_file;
	}


	public int getM_no() {
		return m_no;
	}


	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	
	
	
	
	
}

