package com.harang.naduri.jdbc.member.model.dao;

import java.sql.*;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;
import com.harang.naduri.jdbc.member.model.vo.Member;

public class MemberDAO {

	public int insertMember(Connection con, Member joinMember) {
		// 실행 결과 추가된 행의 개수
		int result = 0;
//		Statement st = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO MEMBER VALUES "
						+ "(SEQ_M_NO.NEXTVAL, ?, DEFAULT, ?, ?, ?, ?, ?, ?, DEFAULT, ?)";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			// DB 숫자 시작은 1부터
			ps.setString(1, joinMember.getM_id());
			ps.setString(2, joinMember.getM_pwd());
			ps.setString(3, joinMember.getM_name());
			ps.setString(4, joinMember.getM_gender());
			ps.setString(5, joinMember.getM_address());
			ps.setString(6, joinMember.getM_email());
			ps.setString(7, joinMember.getM_phone());
			ps.setString(8, joinMember.getM_birth());
			
//			st = con.createStatement();
//			
//			String sql = "INSERT INTO MEMBER "
//						+ " VALUES(SEQ_M_NO.NEXTVAL" 
//						+ ", '" + joinMember.getM_id()
//						+ "', DEFAULT"
//						+ ", '" + joinMember.getM_pwd()
//						+ "', '" + joinMember.getM_name()
//						+ "', '" + joinMember.getM_gender()
//						+ "', '" + joinMember.getM_address()
//						+ "', '" + joinMember.getM_email()
//						+ "', '" + joinMember.getM_phone()
//						+ "', DEFAULT"
//						+ ", '" + joinMember.getM_birth()
//						+"')";
//			
//			System.out.println(sql);
			
			result = ps.executeUpdate();
//			result = st.executeUpdate(sql);
			
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			
			close(ps);
//			close(st);
		}
		
		return result;
	}

}
