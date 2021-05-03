package com.harang.naduri.jdbc.spot.model.vo;

import java.io.Serializable;

public class Spot implements Serializable {
	
	private static final long serialVersionUID = 1014L;
	
	private	int spot_id;
	private	int l_no;
	private	String spot_name;
	private	String spot_type;
	private	String spot_tel;
	private	String spot_time;
	private	String spot_location;
	private	double spot_lat;
	private	double spot_long;
	private	String s_status;
	private	String spot_date;
	private	int spot_count;
	
	
	public Spot() {
		super();
	}	

	
	public Spot(String spot_name, double spot_lat, double spot_long) {
		super();
		this.spot_name = spot_name;
		this.spot_lat = spot_lat;
		this.spot_long = spot_long;
	}


	public Spot(double spot_lat, double spot_long) {
		super();
		this.spot_lat = spot_lat;
		this.spot_long = spot_long;
	}


	// 전체 생성자
	public Spot(int spot_id, int l_no, String spot_name, String spot_type, String spot_tel, String spot_time,
			String spot_location, double spot_lat, double spot_long, String s_status, String spot_date,
			int spot_count) {
		super();
		this.spot_id = spot_id;
		this.l_no = l_no;
		this.spot_name = spot_name;
		this.spot_type = spot_type;
		this.spot_tel = spot_tel;
		this.spot_time = spot_time;
		this.spot_location = spot_location;
		this.spot_lat = spot_lat;
		this.spot_long = spot_long;
		this.s_status = s_status;
		this.spot_date = spot_date;
		this.spot_count = spot_count;
	}
	
	

	@Override
	public String toString() {
		return "Spot [spot_id=" + spot_id + ", l_no=" + l_no + ", spot_name=" + spot_name + ", spot_type=" + spot_type
				+ ", spot_tel=" + spot_tel + ", spot_time=" + spot_time + ", spot_location=" + spot_location
				+ ", spot_lat=" + spot_lat + ", spot_long=" + spot_long + ", s_status=" + s_status + ", spot_date="
				+ spot_date + ", spot_count=" + spot_count + "]";
	}

	public int getSpot_id() {
		return spot_id;
	}

	public void setSpot_id(int spot_id) {
		this.spot_id = spot_id;
	}

	public int getL_no() {
		return l_no;
	}

	public void setL_no(int l_no) {
		this.l_no = l_no;
	}

	public String getSpot_name() {
		return spot_name;
	}

	public void setSpot_name(String spot_name) {
		this.spot_name = spot_name;
	}

	public String getSpot_type() {
		return spot_type;
	}

	public void setSpot_type(String spot_type) {
		this.spot_type = spot_type;
	}

	public String getSpot_tel() {
		return spot_tel;
	}

	public void setSpot_tel(String spot_tel) {
		this.spot_tel = spot_tel;
	}

	public String getSpot_time() {
		return spot_time;
	}

	public void setSpot_time(String spot_time) {
		this.spot_time = spot_time;
	}

	public String getSpot_location() {
		return spot_location;
	}

	public void setSpot_location(String spot_location) {
		this.spot_location = spot_location;
	}

	public double getSpot_lat() {
		return spot_lat;
	}

	public void setSpot_lat(double spot_lat) {
		this.spot_lat = spot_lat;
	}

	public double getSpot_long() {
		return spot_long;
	}

	public void setSpot_long(double spot_long) {
		this.spot_long = spot_long;
	}

	public String getS_status() {
		return s_status;
	}

	public void setS_status(String s_status) {
		this.s_status = s_status;
	}

	public String getSpot_date() {
		return spot_date;
	}

	public void setSpot_date(String spot_date) {
		this.spot_date = spot_date;
	}

	public int getSpot_count() {
		return spot_count;
	}

	public void setSpot_count(int spot_count) {
		this.spot_count = spot_count;
	}

	
}
