package com.harang.naduri.jdbc.qna.model.vo;

import java.io.Serializable;

public class Qna implements Serializable {
	private static final long serialVersionUID = 1011L;
	
private  int qno;
private 	int m_no;
private String q_title;
private 	String q_content;
private 	String q_date;
private 	String q_update;

public Qna() {
	super();
}

public Qna(int m_no, String q_title, String q_content) {
	super();
	this.m_no = m_no;
	this.q_title = q_title;
	this.q_content = q_content;
}


public Qna(int qno, int m_no, String q_content, String q_date, String q_update) {
	super();
	this.qno = qno;
	this.m_no = m_no;
	this.q_content = q_content;
	this.q_date = q_date;
	this.q_update = q_update;
}

@Override
public String toString() {
	return "Qna [qno=" + qno + ", m_no=" + m_no + ", q_content=" + q_content + ", q_date=" + q_date + ", q_update="
			+ q_update + "]";
}

public int getQno() {
	return qno;
}

public void setQno(int qno) {
	this.qno = qno;
}

public int getM_no() {
	return m_no;
}

public void setM_no(int m_no) {
	this.m_no = m_no;
}

public String getQ_content() {
	return q_content;
}

public void setQ_content(String q_content) {
	this.q_content = q_content;
}

public String getQ_date() {
	return q_date;
}

public void setQ_date(String q_date) {
	this.q_date = q_date;
}

public String getQ_update() {
	return q_update;
}

public void setQ_update(String q_update) {
	this.q_update = q_update;
}
	
public String getQ_title() {
	return q_title;
}

public void setQ_title(String q_title) {
	this.q_title = q_title;
}
	
	
	
	
	
}
