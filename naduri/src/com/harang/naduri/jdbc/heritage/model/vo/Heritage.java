package com.harang.naduri.jdbc.heritage.model.vo;

import java.io.Serializable;

public class Heritage implements Serializable{
	
	private static final long serialVersionUID = 1003L;
	
	// ���� ������ ���̽� ���̺�� ��Ī�Ǵ� vo�Դϴ�.
	private int h_id;
	private int l_no;
	private String h_events; // �����ڵ�
	private String h_name;
	private String h_zipcode; // �õ��ڵ�
	private String h_serial; // ������ȣ
	private String h_status;
	private int h_count;

	// ���⼭���ʹ� ���������� api���� �޾ƿ� ������ �Դϴ�.
	private String ccmaName; // ��ȭ������
	private String gcodeName; // ��ȭ��з�
	private String ccbaAsdt; // ����(�����)
	private String ccbaLcad; // ������ ��
	private String ccceName; // �ô�
	private String ccbaPoss; // ������
	private String ccbaAdmin; // ������
	private String imageUrl; // ���γ����̹���URL
	private String content; // ����
	
	private Double longitude; // �浵
	private Double latitude; // ����

	
	public Heritage() {	}


	public Heritage(int h_id, int l_no, String h_events, String h_serial, String h_zipcode, String h_status,
			int h_count, String h_name) {
		super();
		this.h_id = h_id;
		this.l_no = l_no;
		this.h_events = h_events;
		this.h_serial = h_serial;
		this.h_zipcode = h_zipcode;
		this.h_status = h_status;
		this.h_count = h_count;
		this.h_name = h_name;
	}


	public Heritage(int h_id, int l_no, String h_events, String h_serial, String h_zipcode, String h_status,
			int h_count, String h_name, String ccmaName, String gcodeName, String ccbaAsdt, String ccbaLcad, String ccceName,
			String ccbaPoss, String ccbaAdmin, String imageUrl, String content, Double longitude, Double latitude) {
		super();
		this.h_id = h_id;
		this.l_no = l_no;
		this.h_events = h_events;
		this.h_serial = h_serial;
		this.h_zipcode = h_zipcode;
		this.h_status = h_status;
		this.h_count = h_count;
		this.h_name = h_name;
		this.ccmaName = ccmaName;
		this.gcodeName = gcodeName;
		this.ccbaAsdt = ccbaAsdt;
		this.ccbaLcad = ccbaLcad;
		this.ccceName = ccceName;
		this.ccbaPoss = ccbaPoss;
		this.ccbaAdmin = ccbaAdmin;
		this.imageUrl = imageUrl;
		this.content = content;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	


	public Heritage(String h_events, String h_name, String h_zipcode, String h_serial) {
		super();
		this.h_events = h_events;
		this.h_name = h_name;
		this.h_zipcode = h_zipcode;
		this.h_serial = h_serial;
	}


	@Override
	public String toString() {
		return "Heritage [h_id=" + h_id + ", l_no=" + l_no + ", h_events=" + h_events + ", h_serial=" + h_serial
				+ ", h_zipcode=" + h_zipcode + ", h_status=" + h_status + ", h_count=" + h_count + ", h_name=" + h_name + ", ccmaName="
				+ ccmaName + ", gcodeName=" + gcodeName + ", ccbaAsdt=" + ccbaAsdt + ", ccbaLcad=" + ccbaLcad
				+ ", ccceName=" + ccceName + ", ccbaPoss=" + ccbaPoss + ", ccbaAdmin=" + ccbaAdmin + ", imageUrl="
				+ imageUrl + ", content=" + content + ", longitude=" + longitude + ", latitude=" + latitude + "]";
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


	public String getH_events() {
		return h_events;
	}


	public void setH_events(String h_events) {
		this.h_events = h_events;
	}


	public String getH_serial() {
		return h_serial;
	}


	public void setH_serial(String h_serial) {
		this.h_serial = h_serial;
	}


	public String getH_zipcode() {
		return h_zipcode;
	}


	public void setH_zipcode(String h_zipcode) {
		this.h_zipcode = h_zipcode;
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


	public String getH_name() {
		return h_name;
	}


	public void setH_name(String h_name) {
		this.h_name = h_name;
	}


	public String getCcmaName() {
		return ccmaName;
	}


	public void setCcmaName(String ccmaName) {
		this.ccmaName = ccmaName;
	}


	public String getGcodeName() {
		return gcodeName;
	}


	public void setGcodeName(String gcodeName) {
		this.gcodeName = gcodeName;
	}


	public String getCcbaAsdt() {
		return ccbaAsdt;
	}


	public void setCcbaAsdt(String ccbaAsdt) {
		this.ccbaAsdt = ccbaAsdt;
	}


	public String getCcbaLcad() {
		return ccbaLcad;
	}


	public void setCcbaLcad(String ccbaLcad) {
		this.ccbaLcad = ccbaLcad;
	}


	public String getCcceName() {
		return ccceName;
	}


	public void setCcceName(String ccceName) {
		this.ccceName = ccceName;
	}


	public String getCcbaPoss() {
		return ccbaPoss;
	}


	public void setCcbaPoss(String ccbaPoss) {
		this.ccbaPoss = ccbaPoss;
	}


	public String getCcbaAdmin() {
		return ccbaAdmin;
	}


	public void setCcbaAdmin(String ccbaAdmin) {
		this.ccbaAdmin = ccbaAdmin;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}