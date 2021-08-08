package com.harang.naduri.jdbc.comment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Comment implements Serializable {

	private static final long serialVersionUID = 2848L; 
	
	private int replyno;
	private int mno;
	private int rno;
	private int qno;
	private String reply_content;
	private Date reply_date;
	private Date reply_update;
	private int ref_no;
	

	private 	int m_no;
	private String q_title;
	private 	String q_content;
	private 	Date q_date;
	private 	Date q_update;
	private String m_id;
	
	public Comment() {};
	
	
	
	public Comment(int mno, int rno, String reply_content, int ref_no) {
		super();
		this.mno = mno;
		this.rno = rno;
		this.reply_content = reply_content;
		this.ref_no = ref_no;
	}

	
	public Comment(int mno, int qno, String q_title, String q_content) {
		super();
		this.mno = mno;
		this.qno = qno;
		this.q_title = q_title;
		this.q_content = q_content;
	}


	public Comment(int replyno, int mno, int rno, int qno, String reply_content, Date reply_date,
			Date reply_update, int ref_no, int m_no, String q_title, String q_content, Date q_date, Date q_update,
			String m_id) {
		super();
		this.replyno = replyno;
		this.mno = mno;
		this.rno = rno;
		this.qno = qno;
		this.reply_content = reply_content;
		this.reply_date = reply_date;
		this.reply_update = reply_update;
		this.ref_no = ref_no;
		this.m_no = m_no;
		this.q_title = q_title;
		this.q_content = q_content;
		this.q_date = q_date;
		this.q_update = q_update;
		this.m_id = m_id;
	}

	public int getReplyno() {
		return replyno;
	}

	public void setReplyno(int replyno) {
		this.replyno = replyno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
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

	public Date getReply_date() {
		return reply_date;
	}

	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}

	public Date getReply_update() {
		return reply_update;
	}

	public void setReply_update(Date reply_update) {
		this.reply_update = reply_update;
	}

	public int getRef_no() {
		return ref_no;
	}

	public void setRef_no(int ref_no) {
		this.ref_no = ref_no;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
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

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Comment [replyno=" + replyno + ", mno=" + mno + ", rno=" + rno + ", qno=" + qno + ", reply_content="
				+ reply_content + ", reply_date=" + reply_date + ", reply_update=" + reply_update + ", ref_no=" + ref_no
				+ ", m_no=" + m_no + ", q_title=" + q_title + ", q_content=" + q_content + ", q_date=" + q_date
				+ ", q_update=" + q_update + ", m_id=" + m_id + "]";
	}
	
}

	
	