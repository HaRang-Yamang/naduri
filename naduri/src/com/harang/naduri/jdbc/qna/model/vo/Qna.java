package com.harang.naduri.jdbc.qna.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Qna implements Serializable {
	private static final long serialVersionUID = 1011L;
	
private  int qno;
private	int l_no;
private 	int m_no;
private String q_title;
private 	String q_content;
private 	Date q_date;
private 	Date q_update;
private String m_id;


public Qna() {
	super();
}




public Qna(int l_no, int m_no, String q_title, String q_content) {
	super();
	this.l_no = l_no;
	this.m_no = m_no;
	this.q_title = q_title;
	this.q_content = q_content;
}


public Qna(int qno, int m_no, String q_content, Date q_date, Date q_update) {
	super();
	this.qno = qno;
	this.m_no = m_no;
	this.q_content = q_content;
	this.q_date = q_date;
	this.q_update = q_update;
}

@Override
public String toString() {
	return "Qna [qno=" + qno + ", l_no=" + l_no + ", m_no=" + m_no + ", q_title=" + q_title + ", q_content=" + q_content
			+ ", q_date=" + q_date + ", q_update=" + q_update + ", m_id=" + m_id + "]";
}

public int getQno() {
	return qno;
}
public int getL_no() {
	return l_no;
}

public void setL_no(int l_no) {
	this.l_no = l_no;
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

public Date getQ_date() {
	return q_date;
}

public void setQ_date(Date q_date) {
	this.q_date = q_date;
}

public Date getQ_update() {
	return q_update;
}

public void setQ_update(Date q_update) {
	this.q_update = q_update;
}
	
public String getQ_title() {
	return q_title;
}

public void setQ_title(String q_title) {
	this.q_title = q_title;
}
public String getM_id() {
	return m_id;
}

public void setM_id(String m_id) {
	this.m_id = m_id;
}
	
	
	
	
}
