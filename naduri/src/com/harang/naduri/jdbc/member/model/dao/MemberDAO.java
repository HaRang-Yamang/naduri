package com.harang.naduri.jdbc.member.model.dao;

import java.sql.*;
import java.util.ArrayList;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import com.harang.naduri.jdbc.member.model.vo.KeywordId;
import com.harang.naduri.jdbc.member.model.vo.Member;

public class MemberDAO {

	public int insertMember(Connection con, Member joinMember) {
		
		int result = 0;

		PreparedStatement ps = null;
		
		String sql = "INSERT INTO MEMBER VALUES "
						+ "(SEQ_M_NO.NEXTVAL, ?, '일반', ?, ?, ?, ?, ?, ?, ?, ? DEFAULT)";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, joinMember.getM_id());
			ps.setString(2, joinMember.getM_pwd());
			ps.setString(3, joinMember.getM_name());
			ps.setString(4, joinMember.getM_birth());
			ps.setString(5, joinMember.getM_gender());
			ps.setString(6, joinMember.getM_address());
			ps.setString(7, joinMember.getM_email());
			ps.setString(8, joinMember.getM_phone());
			ps.setString(9, joinMember.get);


			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(ps);
		}
		
		return result;
	}
	
	

}
