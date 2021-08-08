package com.harang.naduri.jdbc.Thumbnail.model.vo;

import java.io.Serializable;
import java.util.ArrayList;

import com.harang.naduri.jdbc.attach.model.vo.Attach;
import com.harang.naduri.jdbc.spot.model.vo.Spot;

public class Thumbnail extends Spot implements Serializable {
	
	private static final long serialVersionUID = 827L; // ������!
	
	private ArrayList<Attach> attList;

	
	
	public Thumbnail(int s_id, int l_no, String s_name, String s_type, String s_tel, String s_time, String s_address,
			String s_lat, String s_lng, String s_status, String s_date, int s_count) {
		super(s_id, l_no, s_name, s_type, s_tel, s_time, s_address, s_lat, s_lng, s_status, s_date, s_count);
		// TODO Auto-generated constructor stub
	}




	public Thumbnail(String s_name, String s_tel, String s_date, String s_address, String s_lat, String s_lng,
			String a_name) {
		super(s_name, s_tel, s_date, s_address, s_lat, s_lng, a_name);
		// TODO Auto-generated constructor stub
	}




	public Thumbnail(String s_name, String s_lat, String st_lng) {
		super(s_name, s_lat, st_lng);
		// TODO Auto-generated constructor stub
	}




	public Thumbnail(String s_lat, String st_lng) {
		super(s_lat, st_lng);
		// TODO Auto-generated constructor stub
	}




	public Thumbnail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	@Override
	public String toString() {
		return "Thumbnail [attList=" + attList + "]";
	}

	public ArrayList<Attach> getAttList() {
		return attList;
	}

	public void setAttList(ArrayList<Attach> attList) {
		this.attList = attList;
	}



	
	
}
