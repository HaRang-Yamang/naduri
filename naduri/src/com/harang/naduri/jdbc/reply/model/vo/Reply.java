package com.harang.naduri.jdbc.reply.model.vo;

import java.io.Serializable;

public class Reply implements Serializable{
	private static final long serialVersionUID = 1012L;
	
private int	replyno;
private int	m_no;
private int 	rno;
private int	qno;
private String reply_content;
private String reply_date;
private String reply_update;
public Reply() {
	super();
}
public Reply(int replyno, int m_no, int rno, int qno, String reply_content, String reply_date, String reply_update) {
	super();
	this.replyno = replyno;
	this.m_no = m_no;
	this.rno = rno;
	this.qno = qno;
	this.reply_content = reply_content;
	this.reply_date = reply_date;
	this.reply_update = reply_update;
}
@Override
public String toString() {
	return "Reply [replyno=" + replyno + ", m_no=" + m_no + ", rno=" + rno + ", qno=" + qno + ", reply_content="
			+ reply_content + ", reply_date=" + reply_date + ", reply_update=" + reply_update + "]";
}
public int getReplyno() {
	return replyno;
}
public void setReplyno(int replyno) {
	this.replyno = replyno;
}
public int getM_no() {
	return m_no;
}
public void setM_no(int m_no) {
	this.m_no = m_no;
}
public int getRno() {
	return rno;
}
public void setRno(int rno) {
	this.rno = rno;
}
public int getQno() {
	return qno;
}
public void setQno(int qno) {
	this.qno = qno;
}
public String getReply_content() {
	return reply_content;
}
public void setReply_content(String reply_content) {
	this.reply_content = reply_content;
}
public String getReply_date() {
	return reply_date;
}
public void setReply_date(String reply_date) {
	this.reply_date = reply_date;
}
public String getReply_update() {
	return reply_update;
}
public void setReply_update(String reply_update) {
	this.reply_update = reply_update;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
	
	
	
	
}
