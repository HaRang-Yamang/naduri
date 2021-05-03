package com.harang.naduri.jdbc.spot.model.vo;

import java.io.Serializable;

public class Spot implements Serializable {
	
	private static final long serialVersionUID = 1014L;
	
	private	int s_id;
	private	int l_no;
	private	String s_name;
	private	String s_type;
	private	String s_tel;
	private	String s_time;
	private	String s_address;
	private	double s_lat;
	private	double s_lng;
	private	String s_status;
	private	String s_date;
	private	int s_count;
	
	
	public Spot() {
		super();
	}	

	
	
	
	public Spot(String s_name, double s_lat, double st_lng) {
		super();
		this.s_name = s_name;
		this.s_lat = s_lat;
		this.s_lng = st_lng;
	}


	public Spot(double s_lat, double st_lng) {
		super();
		this.s_lat = s_lat;
		this.s_lng = st_lng;
	}




	// 전체 생성자
	public Spot(int s_id, int l_no, String s_name, String s_type, String s_tel, String s_time, String s_address,
			double s_lat, double s_lng, String s_status, String s_date, int s_count) {
		super();
		this.s_id = s_id;
		this.l_no = l_no;
		this.s_name = s_name;
		this.s_type = s_type;
		this.s_tel = s_tel;
		this.s_time = s_time;
		this.s_address = s_address;
		this.s_lat = s_lat;
		this.s_lng = s_lng;
		this.s_status = s_status;
		this.s_date = s_date;
		this.s_count = s_count;
	}

	
	@Override
	public String toString() {
		return "Spot [s_id=" + s_id + ", l_no=" + l_no + ", s_name=" + s_name + ", s_type=" + s_type + ", s_tel="
				+ s_tel + ", s_time=" + s_time + ", s_address=" + s_address + ", s_lat=" + s_lat + ", s_lng=" + s_lng
				+ ", s_status=" + s_status + ", s_date=" + s_date + ", s_count=" + s_count + "]";
	}




	public int getS_id() {
		return s_id;
	}




	public void setS_id(int s_id) {
		this.s_id = s_id;
	}




	public int getL_no() {
		return l_no;
	}




	public void setL_no(int l_no) {
		this.l_no = l_no;
	}




	public String getS_name() {
		return s_name;
	}




	public void setS_name(String s_name) {
		this.s_name = s_name;
	}




	public String getS_type() {
		return s_type;
	}




	public void setS_type(String s_type) {
		this.s_type = s_type;
	}




	public String getS_tel() {
		return s_tel;
	}




	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}




	public String getS_time() {
		return s_time;
	}




	public void setS_time(String s_time) {
		this.s_time = s_time;
	}




	public String getS_address() {
		return s_address;
	}




	public void setS_address(String s_address) {
		this.s_address = s_address;
	}




	public double getS_lat() {
		return s_lat;
	}




	public void setS_lat(double s_lat) {
		this.s_lat = s_lat;
	}




	public double getS_lng() {
		return s_lng;
	}




	public void setS_lng(double s_lng) {
		this.s_lng = s_lng;
	}




	public String getS_status() {
		return s_status;
	}




	public void setS_status(String s_status) {
		this.s_status = s_status;
	}




	public String getS_date() {
		return s_date;
	}




	public void setS_date(String s_date) {
		this.s_date = s_date;
	}




	public int getS_count() {
		return s_count;
	}




	public void setS_count(int s_count) {
		this.s_count = s_count;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	
}
