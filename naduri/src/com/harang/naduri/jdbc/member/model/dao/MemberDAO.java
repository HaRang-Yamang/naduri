package com.harang.naduri.jdbc.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;
import com.harang.naduri.jdbc.member.model.vo.Member;

public class MemberDAO {
	
	private Properties prop;
	
	public MemberDAO() {
		prop = new Properties();
		
		String filePath = MemberDAO.class.getResource("/config/admin.properies").getPath();
		
		try {
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

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

	
	// 회원 조회
	public Member selectMember(Connection con, Member loginMember) {
		
		Member result = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MEMBER WHERE M_ID = ? AND M_PWD = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, loginMember.getM_id());
			ps.setString(2, loginMember.getM_pwd());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = new Member();
				
				result.setM_id(rs.getString("m_id"));
				result.setM_pwd(rs.getString("m_pwd"));
				result.setM_name(rs.getString("m_name"));
				result.setM_gender(rs.getString("m_gender"));
				result.setM_address(rs.getString("m_address"));
				result.setM_email(rs.getString("m_email"));
				result.setM_phone(rs.getString("m_phone"));
				result.setM_birth(rs.getString("m_birth"));
				result.setM_auth(rs.getInt("m_auth"));
				
			}
			
			System.out.println("조회 결과 : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return result;
	}

	// 관리자 페이지  회원관리 부분
	public ArrayList<Member> memberList(Connection con) {
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("adminMember");
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Member m = new Member();
				
				m.setM_no(rs.getInt("m_no"));
				m.setM_id(rs.getString("m_id"));
				m.setM_name(rs.getString("m_name"));
				m.setM_phone(rs.getString("m_phone"));
				m.setM_email(rs.getString("m_email"));
				m.setM_status(rs.getString("m_status"));
				
				list.add(m);
				
			}
			
			System.out.println("조회 결과 : " + list);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(rs);
			close(ps);
		}
		
		return list;
	}



}
