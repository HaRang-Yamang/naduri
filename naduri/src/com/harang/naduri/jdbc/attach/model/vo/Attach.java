package com.harang.naduri.jdbc.attach.model.vo;

import java.io.Serializable;

public class Attach implements Serializable {

	private static final long serialVersionUID = 1001L;

	private int a_no;
	private String a_name;
	private String a_status;
	private int r_no;
	private int m_no;
	private int L_no;
	private int n_no;
	private int spot_id;

	public Attach() { }



	@Override
	public String toString() {
		return "Attach [a_no=" + a_no + ", a_name=" + a_name + ", a_status=" + a_status + ", r_no=" + r_no + ", m_no="
				+ m_no + ", spot_id=" + spot_id + ", n_no=" + n_no + "]";
	}


	public int getA_no() {
		return a_no;

	}

	public void setA_no(int a_no) {
		this.a_no = a_no;

	}

	public String getA_name() {
		return a_name;
	}


	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getA_status() {
		return a_status;
	}

	public void setA_status(String a_status) {
		this.a_status = a_status;
	}

	public int getR_no() {
		return r_no;

	}

	public void setR_no(int r_no) {
		this.r_no = r_no;

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