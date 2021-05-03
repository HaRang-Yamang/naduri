package com.harang.naduri.jdbc.member.model.vo;

import java.io.Serializable;

public class Member implements Serializable{


   private static final long serialVersionUID = 1009L;
   
   // 1. 필드 변수
   private int m_no;
   private String m_id;
   private String m_pwd;
   private String m_name;
   private String m_birth;
   private String m_gender;
   private String m_address;
   private String m_email;
   private String m_phone;
   private int m_auth;
   private String m_status;

   
   // 2. 생성자
   public Member() {}

		// 전체용
	public Member(int m_no, String m_id, String m_pwd, String m_name, String m_birth, String m_gender,
				String m_address, String m_email, String m_phone, int m_auth, String m_status) {
			super();
			this.m_no = m_no;
			this.m_id = m_id;
			this.m_pwd = m_pwd;
			this.m_name = m_name;
			this.m_birth = m_birth;
			this.m_gender = m_gender;
			this.m_address = m_address;
			this.m_email = m_email;
			this.m_phone = m_phone;
			this.m_auth = m_auth;
			this.m_status = m_status;
		}	

		// 회원 가입 용
	public Member(String m_id, String m_pwd, String m_name, String m_birth, String m_gender, String m_address,
			String m_email, String m_phone) {
		super();
		this.m_id = m_id;
		this.m_pwd = m_pwd;
		this.m_name = m_name;
		this.m_birth = m_birth;
		this.m_gender = m_gender;
		this.m_address = m_address;
		this.m_email = m_email;
		this.m_phone = m_phone;
	}
	
	// 아이디 수정
	public Member(String m_pwd, String m_gender, String m_address, String m_email, String m_phone) {
		super();
		this.m_pwd = m_pwd;
		this.m_gender = m_gender;
		this.m_address = m_address;
		this.m_email = m_email;
		this.m_phone = m_phone;
	}	

		// 아이디, 비밀번호
	public Member(String m_id, String m_pwd) {
		super();
		this.m_id = m_id;
		this.m_pwd = m_pwd;
	}
	
	// 관리자페이지 회원관리
	public Member(int m_no, String m_id, String m_name, String m_phone, String m_email,  String m_status) {
		super();
		this.m_no = m_no;
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_phone = m_phone;
		this.m_email = m_email;
		this.m_status = m_status;
	}

	
	@Override
	public String toString() {
		return "Member [m_no=" + m_no + ", m_id=" + m_id + ", m_pwd=" + m_pwd + ", m_name=" + m_name + ", m_birth="
				+ m_birth + ", m_gender=" + m_gender + ", m_address=" + m_address + ", m_email=" + m_email
				+ ", m_phone=" + m_phone + ", m_auth=" + m_auth + ", m_status=" + m_status + "]";
	}

	public int getM_no() {
		return m_no;
	}

   public void setM_no(int m_no) {
      this.m_no = m_no;
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

   public int getM_auth() {
      return m_auth;
   }

   public void setM_auth(int m_auth) {
      this.m_auth = m_auth;
   }

   public String getM_status() {
      return m_status;
   }

   public void setM_status(String m_status) {
      this.m_status = m_status;
   }


}

