package com.harang.naduri.jdbc.bookmark.model.vo;

import java.io.Serializable;

public class Bookmark implements Serializable {
	
	private static final long serialVersionUID = 1002L;
	
	private int mark_id;
	private int l_no;
	private int m_no;
	private int rno;
	
	
	public Bookmark() {	}


	public Bookmark(int mark_id, int l_no, int m_no, int rno) {
		super();
		this.mark_id = mark_id;
		this.l_no = l_no;
		this.m_no = m_no;
		this.rno = rno;
	}
	public Bookmark(int mark_id, int l_no, int m_no) {
		super();
		this.mark_id = mark_id;
		this.l_no = l_no;
		this.m_no = m_no;
	}


	public Bookmark(int l_no, int m_no) {
		super();
		this.l_no = l_no;
		this.m_no = m_no;
	}


	@Override
	public String toString() {
		return "Bookmark [mark_id=" + mark_id + ", l_no=" + l_no + ", m_no=" + m_no + ", rno=" + rno + "]";
	}


	public int getMark_id() {
		return mark_id;
	}


	public void setMark_id(int mark_id) {
		this.mark_id = mark_id;
	}


	public int getL_no() {
		return l_no;
	}


	public void setL_no(int l_no) {
		this.l_no = l_no;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
