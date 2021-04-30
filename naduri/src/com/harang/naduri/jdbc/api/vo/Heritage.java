package vo;

import java.sql.Connection;

public class Heritage {
	private int H_ID;
	private int L_NO;
	private String TITLE;
	private String H_WIDTH;
	private String EVENTS;
	private String H_CATEGORY;
	private String H_DATE;
	private String H_LOCATION;
	private String H_PERIOD;
	private String H_LAT;
	private String H_ADMIN;
	private String H_LONG;
	private String H_STATUS;
	private int H_COUNT;
	
	public Heritage() {}
	
	public Heritage(int h_ID, int l_NO, String h_TITLE, String h_WIDTH, String h_EVENTS, String h_CATEGORY,
			String h_DATE, String h_LOCATION, String h_PERIOD, String h_LAT, String h_ADMIN, String h_LONG,
			String h_STATUS, int h_COUNT) {
		super();
		H_ID = h_ID;
		L_NO = l_NO;
		TITLE = h_TITLE;
		H_WIDTH = h_WIDTH;
		EVENTS = h_EVENTS;
		H_CATEGORY = h_CATEGORY;
		H_DATE = h_DATE;
		H_LOCATION = h_LOCATION;
		H_PERIOD = h_PERIOD;
		H_LAT = h_LAT;
		H_ADMIN = h_ADMIN;
		H_LONG = h_LONG;
		H_STATUS = h_STATUS;
		H_COUNT = h_COUNT;
	}
	
	
	public Heritage(String h_TITLE, String h_EVENTS) {
		super();
		TITLE = h_TITLE;
		EVENTS = h_EVENTS;
	}

	@Override
	public String toString() {
		return "Heritage [H_ID=" + H_ID + ", L_NO=" + L_NO + ", H_TITLE=" + TITLE + ", H_WIDTH=" + H_WIDTH
				+ ", H_EVENTS=" + EVENTS + ", H_CATEGORY=" + H_CATEGORY + ", H_DATE=" + H_DATE + ", H_LOCATION="
				+ H_LOCATION + ", H_PERIOD=" + H_PERIOD + ", H_LAT=" + H_LAT + ", H_ADMIN=" + H_ADMIN + ", H_LONG="
				+ H_LONG + ", H_STATUS=" + H_STATUS + ", H_COUNT=" + H_COUNT + "]";
	}
	
	

	public int getH_ID() {
		return H_ID;
	}

	public void setH_ID(int h_ID) {
		H_ID = h_ID;
	}

	public int getL_NO() {
		return L_NO;
	}

	public void setL_NO(int l_NO) {
		L_NO = l_NO;
	}

	public String getH_TITLE() {
		return TITLE;
	}

	public void setH_TITLE(String h_TITLE) {
		TITLE = h_TITLE;
	}

	public String getH_WIDTH() {
		return H_WIDTH;
	}

	public void setH_WIDTH(String h_WIDTH) {
		H_WIDTH = h_WIDTH;
	}

	public String getH_EVENTS() {
		return EVENTS;
	}

	public void setH_EVENTS(String h_EVENTS) {
		EVENTS = h_EVENTS;
	}

	public String getH_CATEGORY() {
		return H_CATEGORY;
	}

	public void setH_CATEGORY(String h_CATEGORY) {
		H_CATEGORY = h_CATEGORY;
	}

	public String getH_DATE() {
		return H_DATE;
	}

	public void setH_DATE(String h_DATE) {
		H_DATE = h_DATE;
	}

	public String getH_LOCATION() {
		return H_LOCATION;
	}

	public void setH_LOCATION(String h_LOCATION) {
		H_LOCATION = h_LOCATION;
	}

	public String getH_PERIOD() {
		return H_PERIOD;
	}

	public void setH_PERIOD(String h_PERIOD) {
		H_PERIOD = h_PERIOD;
	}

	public String getH_LAT() {
		return H_LAT;
	}

	public void setH_LAT(String h_LAT) {
		H_LAT = h_LAT;
	}

	public String getH_ADMIN() {
		return H_ADMIN;
	}

	public void setH_ADMIN(String h_ADMIN) {
		H_ADMIN = h_ADMIN;
	}

	public String getH_LONG() {
		return H_LONG;
	}

	public void setH_LONG(String h_LONG) {
		H_LONG = h_LONG;
	}

	public String getH_STATUS() {
		return H_STATUS;
	}

	public void setH_STATUS(String h_STATUS) {
		H_STATUS = h_STATUS;
	}

	public int getH_COUNT() {
		return H_COUNT;
	}

	public void setH_COUNT(int h_COUNT) {
		H_COUNT = h_COUNT;
	}


	
	
	
	
	
	

}
