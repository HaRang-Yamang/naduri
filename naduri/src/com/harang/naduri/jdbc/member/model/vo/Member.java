package com.harang.naduri.jdbc.member.model.vo;

import java.io.Serializable;

// VO = Value Object
// 데이터 전달용 그릇 역할을 하는 클래스
public class Member implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1009L;

	private String m_id;
	private String m_pwd;
	private String m_name;
	private String m_birth;
	private String m_gender;
	private String m_address;
	private String m_email;
	private String m_phone;
	private String keyword_id;
	
	
	public Member() {}


	public Member(String m_id, String m_pwd, String m_name, String m_gender, String m_birth,
			String m_phone, String m_email, String m_address, String keyword_id) {
		super();
		this.m_id = m_id;
		this.m_pwd = m_pwd;
		this.m_name = m_name;
		this.m_gender = m_gender;
		this.m_birth = m_birth;
		this.m_phone = m_phone;
		this.m_email = m_email;
		this.m_address = m_address;
		this.keyword_id = keyword_id;
	}


	public Member(String m_id, String m_pwd) {
		super();
		this.m_id = m_id;
		this.m_pwd = m_pwd;
	}


	@Override
	public String toString() {
		return "Member [m_id=" + m_id + ", m_pwd=" + m_pwd + ", m_name="
				+ m_name + ", m_gender= " + m_gender + ", m_birth=" + m_birth + ", m_phone=" + m_phone + ", m_email="
				+ m_email + ", m_address= " + m_address + ", keyword_id=" + keyword_id + "]";
	}


	public String getM_id() {
		return m_id;
	}


	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pwd() {
		return m_pwd;
	}


	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}


	public String getM_name() {
		return m_name;
	}


	public void setM_name(String m_name) {
		this.m_name = m_name;
	}


	public String getM_birth() {
		return m_birth;
	}


	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}


	public String getM_gender() {
		return m_gender;
	}


	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}


	public String getM_address() {
		return m_address;
	}


	public void setM_address(String m_address) {
		this.m_address = m_address;
	}


	public String getM_email() {
		return m_email;
	}


	public void setM_email(String m_email) {
		this.m_email = m_email;
	}


	public String getM_phone() {
		return m_phone;
	}


	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}


	public String getKeyword_id() {
		return keyword_id;
	}


	public void setKeyword_id(String keyword_id) {
		this.keyword_id = keyword_id;
	}
	
	
	
	
	
}
