package com.harang.naduri.jdbc.spot.model.vo;

import java.io.Serializable;
import java.util.ArrayList;

import com.harang.naduri.jdbc.attach.model.vo.Attach;

public class Spot implements Serializable {
	
	private static final long serialVersionUID = 1014L;
	
	private ArrayList<Attach>attList;
	
	
	private	int s_id;
	private	int l_no;
	private	String s_name;
	private	String s_type;
	private	String s_tel;
	private	String s_time;
	private	String s_address;
	private	String s_lat;
	private	String s_lng;
	private	String s_status;
	private	String s_date;
	private	int s_count;
	
	private String a_name;
	
	
	public Spot() {
		super();
	}	

	public Spot(String s_name, String s_tel, String s_date, String s_address, String s_lat, String s_lng, String a_name) {
		super();
		this.s_name = s_name;
		this.s_tel = s_tel;
		this.s_date = s_date;
		this.s_address = s_address;
		this.s_lat = s_lat;
		this.s_lng = s_lng;
		
		this.a_name = a_name;
	}
	
	
	public Spot(String s_name, String s_lat, String st_lng) {
		super();
		this.s_name = s_name;
		this.s_lat = s_lat;
		this.s_lng = st_lng;
	}


	public Spot(String s_lat, String st_lng) {
		super();
		this.s_lat = s_lat;
		this.s_lng = st_lng;
	}




	// 전체 생성자
	public Spot(int s_id, int l_no, String s_name, String s_type, String s_tel, String s_time, String s_address,
			String s_lat, String s_lng, String s_status, String s_date, int s_count) {
		super();
		this.s_id = s_id;
		this.l_no = l_no;
		this.s_name = s_name;
		this.s_type = s_type;
		this.s_tel = s_tel;
		this.s_time = s_time;s
		this.s_address = s_address;
		this.s_lat = s_lat;
		this.s_lng = s_lng;
		this.s_status = s_status;
		this.s_date = s_date;
		this.s_count = s_count;
	}

	
	@Override
	public String toString() {
		return "Spot [attList=" + attList + ", s_id=" + s_id + ", l_no=" + l_no + ", s_name=" + s_name + ", s_type="
				+ s_type + ", s_tel=" + s_tel + ", s_time=" + s_time + ", s_address=" + s_address + ", s_lat=" + s_lat
				+ ", s_lng=" + s_lng + ", s_status=" + s_status + ", s_date=" + s_date + ", s_count=" + s_count
				+ ", a_name=" + a_name + "]";
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

	public String getS_lat() {
		return s_lat;
	}

	public void setS_lat(String s_lat) {
		this.s_lat = s_lat;
	}

	public String getS_lng() {
		return s_lng;
	}

	public void setS_lng(String s_lng) {
		this.s_lng = s_lng;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}


	public ArrayList<Attach> getAttList() {
		return attList;
	}

	public void setAttList(ArrayList<Attach> attList) {
		this.attList = attList;

	
}