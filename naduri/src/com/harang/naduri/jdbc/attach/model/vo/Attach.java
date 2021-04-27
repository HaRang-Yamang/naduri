package com.harang.naduri.jdbc.attach.model.vo;

import java.io.Serializable;

public class Attach implements Serializable {

	private static final long serialVersionUID = 1001L;
	
	private int attach_no;
	private String attach_name;
	private String a_status;
	private String a_path;
	private String a_type;
	private int rno;
	private int m_no;
	private int spot_id;
	private int n_no;

	public Attach() { }

	@Override
	public String toString() {
		return "Attach [attach_no=" + attach_no + ", attach_name=" + attach_name + ", a_status=" + a_status
				+ ", a_path=" + a_path + ", a_type=" + a_type + ", rno=" + rno + ", m_no=" + m_no + ", spot_id="
				+ spot_id + ", n_no=" + n_no + "]";
	}

	public int getAttach_no() {
		return attach_no;
	}

	public void setAttach_no(int attach_no) {
		this.attach_no = attach_no;
	}

	public String getAttach_name() {
		return attach_name;
	}

	public void setAttach_name(String attach_name) {
		this.attach_name = attach_name;
	}

	public String getA_status() {
		return a_status;
	}

	public void setA_status(String a_status) {
		this.a_status = a_status;
	}

	public String getA_path() {
		return a_path;
	}

	public void setA_path(String a_path) {
		this.a_path = a_path;
	}

	public String getA_type() {
		return a_type;
	}

	public void setA_type(String a_type) {
		this.a_type = a_type;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public int getSpot_id() {
		return spot_id;
	}

	public void setSpot_id(int spot_id) {
		this.spot_id = spot_id;
	}

	public int getN_no() {
		return n_no;
	}

	public void setN_no(int n_no) {
		this.n_no = n_no;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}