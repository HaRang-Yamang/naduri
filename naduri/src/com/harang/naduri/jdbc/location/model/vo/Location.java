package com.harang.naduri.jdbc.location.model.vo;

import java.io.Serializable;

public class Location implements Serializable{
	
	private static final long serialVersionUID = 1005L;
	
	private int l_no;
	private int ls_code;
	
	public Location() {	}

	public Location(int l_no, int ls_code) {
		super();
		this.l_no = l_no;
		this.ls_code = ls_code;
	}

	@Override
	public String toString() {
		return "Location [l_no=" + l_no + ", ls_code=" + ls_code + "]";
	}

	public int getL_no() {
		return l_no;
	}

	public void setL_no(int l_no) {
		this.l_no = l_no;
	}

	public int getLs_code() {
		return ls_code;
	}

	public void setLs_code(int ls_code) {
		this.ls_code = ls_code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
