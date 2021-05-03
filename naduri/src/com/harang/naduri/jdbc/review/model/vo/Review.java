package com.harang.naduri.jdbc.review.model.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import com.harang.naduri.jdbc.attach.model.vo.Attach;

public class Review implements Serializable{

	private static final long serialVersionUID = 1013L;
	
	private ArrayList<Attach>attList;
	private	int rno;
	private	int l_no;
	private	int m_no;
	private String m_name;
	private	int r_rank;
	private	String r_title;
	private	String r_content;
	private	String r_period;
	private	int r_with;
	private	Date r_date;
	private	Date r_update;
	private int r_count;
	private	String r_status;
	private String m_id;
	
	public Review() {
		super();
	}

	public Review(int m_no, int r_rank, String r_title, String r_content, String r_period, int r_with) {
		   super();
		   this.m_no = m_no;
		   this.r_rank = r_rank;
		   this.r_title = r_title;
		   this.r_content = r_content;
		   this.r_period = r_period;
		   this.r_with = r_with;
		}
	
	public Review(ArrayList<Attach> attList, int rno, int l_no, int m_no, String m_name, int r_rank, String r_title,
			String r_content, String r_period, int r_with, Date r_date, Date r_update, int r_count, String r_status,
			String m_id) {
		super();
		this.attList = attList;
		this.rno = rno;
		this.l_no = l_no;
		this.m_no = m_no;
		this.m_name = m_name;
		this.r_rank = r_rank;
		this.r_title = r_title;
		this.r_content = r_content;
		this.r_period = r_period;
		this.r_with = r_with;
		this.r_date = r_date;
		this.r_update = r_update;
		this.r_count = r_count;
		this.r_status = r_status;
		this.m_id = m_id;
	}

	@Override
	public String toString() {
		return "Review [attList=" + attList + ", rno=" + rno + ", l_no=" + l_no + ", m_no=" + m_no + ", m_name="
				+ m_name + ", r_rank=" + r_rank + ", r_title=" + r_title + ", r_content=" + r_content + ", r_period="
				+ r_period + ", r_with=" + r_with + ", r_date=" + r_date + ", r_update=" + r_update + ", r_count="
				+ r_count + ", r_status=" + r_status + ", m_id=" + m_id + "]";
	}

	public ArrayList<Attach> getAttList() {
		return attList;
	}

	public void setAttList(ArrayList<Attach> attList) {
		this.attList = attList;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
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

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getR_rank() {
		return r_rank;
	}

	public void setR_rank(int r_rank) {
		this.r_rank = r_rank;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getR_period() {
		return r_period;
	}

	public void setR_period(String r_period) {
		this.r_period = r_period;
	}

	public int getR_with() {
		return r_with;
	}

	public void setR_with(int r_with) {
		this.r_with = r_with;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	public Date getR_update() {
		return r_update;
	}

	public void setR_update(Date r_update) {
		this.r_update = r_update;
	}

	public int getR_count() {
		return r_count;
	}

	public void setR_count(int r_count) {
		this.r_count = r_count;
	}

	public String getR_status() {
		return r_status;
	}

	public void setR_status(String r_status) {
		this.r_status = r_status;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	
	
}