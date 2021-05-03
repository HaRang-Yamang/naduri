package com.harang.naduri.jdbc.Thumbnail.model.vo;

import java.io.Serializable;
import java.util.ArrayList;

import com.harang.naduri.jdbc.spot.model.vo.Spot;

public class Thumbnail extends Spot implements Serializable {
	
	private static final long serialVersionUID = 827L; // ÆÄÀÌÆÃ!
	
	private ArrayList<Attach> attList;

	public Thumbnail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Thumbnail(int spot_id, int l_no, String spot_name, String spot_tel, String spot_time,
			String spot_location, int spot_lat, int spot_long, String s_status, String spot_date, int spot_count, String spot_file) {
		super(spot_id, l_no, spot_name, spot_tel, spot_time, spot_location, spot_lat, spot_long, s_status, spot_date,
				spot_count, spot_file);
		// TODO Auto-generated constructor stub
	}
	
	

	public Thumbnail(String spot_file) {
		super(spot_file);
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
