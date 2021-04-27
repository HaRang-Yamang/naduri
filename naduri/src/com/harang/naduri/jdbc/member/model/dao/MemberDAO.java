package com.harang.naduri.jdbc.member.model.dao;

import java.sql.*;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;
import com.harang.naduri.jdbc.member.model.vo.Member;

public class MemberDAO {

	public int insertMember(Connection con, Member joinMember) {
		
		int result = 0;
		Statement st = null;
		
		try {
			st = con.createStatement();
			
			String sql = "INSERT INTO MEMBER "
						+ "VALUES('" + joinMember.getM_id()
						+ "', '" + joinMember.getM_pwd()
						+ "', '" + joinMember.getM_name()
						+ "', '" + joinMember.getM_gender()
						+ "', '" + joinMember.getM_birth()
						+ "', '" + joinMember.getM_phone()
						+ "', '" + joinMember.getM_email()
						+ "', '" + joinMember.getM_address()
						+ "', '" + joinMember.getKeyword_id()
						+ "', DEFAULT)";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	

}
