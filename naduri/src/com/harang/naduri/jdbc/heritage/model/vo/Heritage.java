package com.harang.naduri.jdbc.heritage.model.vo;

import java.io.Serializable;

public class Heritage implements Serializable{
	
	private static final long serialVersionUID = 1003L;
	
	private int h_id;
	private int l_no;
	private String h_title;
	private String h_width;
	private String h_events;
	private String h_category;
	private String h_date;
	private String h_location;
	private String h_period;
	private String h_lat;
	private String h_admin;
	private String h_long;
	private String h_status;
	private int h_count;
	
	public Heritage() {	}

	public Heritage(int h_id, int l_no, String h_title, String h_width, String h_events, String h_category,
			String h_date, String h_location, String h_period, String h_lat, String h_admin, String h_long,
			String h_status, int h_count) {
		super();
		this.h_id = h_id;
		this.l_no = l_no;
		this.h_title = h_title;
		this.h_width = h_width;
		this.h_events = h_events;
		this.h_category = h_category;
		this.h_date = h_date;
		this.h_location = h_location;
		this.h_period = h_period;
		this.h_lat = h_lat;
		this.h_admin = h_admin;
		this.h_long = h_long;
		this.h_status = h_status;
		this.h_count = h_count;
	}

	@Override
	public String toString() {
		return "Heritage [h_id=" + h_id + ", l_no=" + l_no + ", h_title=" + h_title + ", h_width=" + h_width
				+ ", h_events=" + h_events + ", h_category=" + h_category + ", h_date=" + h_date + ", h_location="
				+ h_location + ", h_period=" + h_period + ", h_lat=" + h_lat + ", h_admin=" + h_admin + ", h_long="
				+ h_long + ", h_status=" + h_status + ", h_count=" + h_count + "]";
	}

	public int getH_id() {
		return h_id;
	}

	public void setH_id(int h_id) {
		this.h_id = h_id;
	}

	public int getL_no() {
		return l_no;
	}

	public void setL_no(int l_no) {
		this.l_no = l_no;
	}

	public String getH_title() {
		return h_title;
	}

	public void setH_title(String h_title) {
		this.h_title = h_title;
	}

	public String getH_width() {
		return h_width;
	}

	public void setH_width(String h_width) {
		this.h_width = h_width;
	}

	public String getH_events() {
		return h_events;
	}

	public void setH_events(String h_events) {
		this.h_events = h_events;
	}

	public String getH_category() {
		return h_category;
	}

	public void setH_category(String h_category) {
		this.h_category = h_category;
	}

	public String getH_date() {
		return h_date;
	}

	public void setH_date(String h_date) {
		this.h_date = h_date;
	}

	public String getH_location() {
		return h_location;
	}

	public void setH_location(String h_location) {
		this.h_location = h_location;
	}

	public String getH_period() {
		return h_period;
	}

	public void setH_period(String h_period) {
		this.h_period = h_period;
	}

	public String getH_lat() {
		return h_lat;
	}

	public void setH_lat(String h_lat) {
		this.h_lat = h_lat;
	}

	public String getH_admin() {
		return h_admin;
	}

	public void setH_admin(String h_admin) {
		this.h_admin = h_admin;
	}

	public String getH_long() {
		return h_long;
	}

	public void setH_long(String h_long) {
		this.h_long = h_long;
	}

	public String getH_status() {
		return h_status;
	}

	public void setH_status(String h_status) {
		this.h_status = h_status;
	}

	public int getH_count() {
		return h_count;
	}

	public void setH_count(int h_count) {
		this.h_count = h_count;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
