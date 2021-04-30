package com.harang.naduri.jdbc.comment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class ReviewComment implements Serializable {

	private static final long serialVersionUID = 2848L; 
	
	private int replyno;
	private int mno;
	private int rno;
	private int qno;
	private String reply_content;
	private Date reply_date;
	private Date reply_update;
	private int ref_no;

	
	public ReviewComment() {
		super();
	}
	

	public ReviewComment(int replyno, int mno, int rno, int qno, String reply_content, Date reply_date,
			Date reply_update, int ref_no) {
		super();
		this.replyno = replyno;
		this.mno = mno;
		this.rno = rno;
		this.qno = qno;
		this.reply_content = reply_content;
		this.reply_date = reply_date;
		this.reply_update = reply_update;
		this.ref_no = ref_no;
	}


	@Override
	public String toString() {
		return "ReviewComment [replyno=" + replyno + ", mno=" + mno + ", rno=" + rno + ", qno=" + qno
				+ ", reply_content=" + reply_content + ", reply_date=" + reply_date + ", reply_update=" + reply_update
				+ ", ref_no=" + ref_no + "]";
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}