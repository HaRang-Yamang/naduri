package com.harang.naduri.jdbc.attach.model.vo;

import java.io.Serializable;

public class Attach implements Serializable {

	private static final long serialVersionUID = 1001L;
	
	private int a_no;
	private String a_name;
	private String a_status;
	private String a_path;
	private String a_type;
	private int rno;
	private int m_no;
	private int L_no;
	private int n_no;

	public Attach() { }

	@Override
	public String toString() {
		return "Attach [a_no=" + a_no + ", a_name=" + a_name + ", a_status=" + a_status + ", a_path=" + a_path
				+ ", a_type=" + a_type + ", rno=" + rno + ", m_no=" + m_no + ", L_no=" + L_no + ", n_no=" + n_no + "]";
	}

	public Attach(int a_no, String a_name, String a_status, String a_path, String a_type, int rno, int m_no, int l_no,
			int n_no) {
		super();
		this.a_no = a_no;
		this.a_name = a_name;
		this.a_status = a_status;
		this.a_path = a_path;
		this.a_type = a_type;
		this.rno = rno;
		this.m_no = m_no;
		this.L_no = l_no;
		this.n_no = n_no;
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

	public int getL_no() {
		return L_no;
	}

	public void setL_no(int l_no) {
		L_no = l_no;
	}

	public int getN_no() {
		return n_no;
	}

	public void setN_no(int n_no) {
		this.n_no = n_no;
	}


	
}