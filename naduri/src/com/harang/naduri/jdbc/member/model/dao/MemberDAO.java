package com.harang.naduri.jdbc.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import com.harang.naduri.jdbc.member.model.dao.MemberDAO;
import com.harang.naduri.jdbc.member.model.vo.Keyword;
import com.harang.naduri.jdbc.member.model.vo.Member;

public class MemberDAO {
	
	private Properties prop;

	public MemberDAO() {
	   prop = new Properties();
	   
	   String filePath = MemberDAO.class
	                   .getResource("/config/member.properties")
	                   .getPath();
	   
	   try {
	      prop.load( new FileReader(filePath));
	      
	   } catch (IOException e) {
	   
	      e.printStackTrace();
	   } 
	}

	// DB의 Member 테이블에 jsp에서 받아온 정보값 입력
	// 회원 가입 - 회원 기본 정보
	public int insertMember(Connection con, Member joinMember) {
		// 실행 결과 추가된 행의 개수
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("insertMember");
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, joinMember.getM_id());
			ps.setString(2, joinMember.getM_pwd());
			ps.setString(3, joinMember.getM_name());
			ps.setString(4, joinMember.getM_gender());
			ps.setString(5, joinMember.getM_address());
			ps.setString(6, joinMember.getM_email());
			ps.setString(7, joinMember.getM_phone());
			ps.setString(8, joinMember.getM_birth());
			
			result = ps.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			close(ps);
		}		
		return result;
	}
	
	// m_id로 m_no 조회
	public int selectMno(Connection con, String m_id) {
	
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectMno");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, m_id);
			rs = ps.executeQuery();
	
			if(rs.next()){				
				result = rs.getInt("m_no");	
			}
			System.out.println("m_no : " + rs.getInt("m_no"));			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return result;
	}
		
	
	// 회원 가입 - 관심사 (MCHOICE 테이블)
	public int insertKeyword(Connection con, Keyword key) {		
		
		int result = 0;
		PreparedStatement ps = null;		
		String sql = prop.getProperty("insertKeyword");


		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, key.getM_no());
			ps.setInt(2, key.getKeyword_id());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {		
			e.printStackTrace();
		}		
		return result;
	}

	
	// 아이디 중복 확인
	public int idCheck(Connection con, String m_id) {
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("idCheck");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, m_id);
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return result;
	}
	
	

	
	// 회원 정보 수정
	public int updateMember(Connection con, Member updateMember) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("updateMemberInfo");
		System.out.println(sql );
		try {
			ps = con.prepareStatement(sql);	
			
			ps.setString(1, updateMember.getM_pwd());
			ps.setString(2, updateMember.getM_gender());
			ps.setString(3, updateMember.getM_email());
			ps.setString(4, updateMember.getM_phone());
			ps.setString(5, updateMember.getM_address());
			ps.setString(6, updateMember.getM_id());
	
			result = ps.executeUpdate();
			System.out.println(ps);
			System.out.println(result);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(ps);
		}	
		return result;
	}

	
	// 키워드 정보 수정
	public int updateKeyword(Connection con, Keyword key) {
		
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("updateKeyword");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, key.getKeyword_id());
			ps.setInt(2,  key.getM_no());
			
			result = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	
	// 회원 삭제
	public int deleteMember(Connection con, String m_id) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1,  m_id);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return result;
	}

	// 관리자 페이지  회원관리 부분
	public ArrayList<Member> memberList(Connection con, int currentPage) {
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("adminMember");
		
		int startRow = (currentPage - 1) * 10 + 1;
		int endRow = currentPage * 10;
		
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, endRow);
			ps.setInt(2, startRow);
			
			
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
		
	// 관리자페이지 회원정보 업데이트 부분
	public int memberUpdateList(Connection con, int m_no, String m_status) {
		
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, m_status);
			ps.setInt(2, m_no);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close(ps);
		}
		
		return result;
		
	}

	// 로그인 - 회원 기본 정보 찾기
	public Member selectMember(Connection con, Member loginMember) {

		Member result = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		String sql = prop.getProperty("selectMember");
	
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1,  loginMember.getM_id());
			ps.setString(2,  loginMember.getM_pwd());
			
			rs = ps.executeQuery();
		      
		      if(rs.next()) {
		         result = new Member();
		         
		         result.setM_id(rs.getString("m_id"));
		         result.setM_no(rs.getInt("m_no"));
		         result.setM_pwd(rs.getString("m_pwd"));
		         result.setM_name(rs.getString("m_name"));
		         result.setM_gender(rs.getString("m_gender"));
		         result.setM_address(rs.getString("m_address"));
		         result.setM_email(rs.getString("m_email"));
		         result.setM_phone(rs.getString("m_phone"));
		         result.setM_birth(rs.getString("m_birth"));
		         result.setM_auth(rs.getInt("m_auth"));
		         result.setM_status(rs.getString("m_status"));
		         
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
	
	// 회원 로그인 - 키워드 찾기
	public ArrayList<Keyword> selectKeyword(Connection con, int m_no) {
		ArrayList<Keyword> keywordArr = new ArrayList<>();		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectKeyword");
		
		try {
			ps = con.prepareStatement(sql);			
			ps.setInt(1,  m_no);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Keyword key = new Keyword();
				
				key.setKeyword_id(rs.getInt("keyword_id"));
				
				keywordArr.add(key);
			}
					
			System.out.println("키워드 조회 결과 : " + keywordArr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return keywordArr;
	}


	// 회원정보 수정 - 키워드 값 삭제
	public int deleteKeyword(Connection con, int m_no) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteKeyword");
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, m_no);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
	
	
	// 아이디 찾기
	public Member searchId(Connection con, Member searchId) {
		Member result = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("searchId");
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,  searchId.getM_name());
			ps.setString(2,  searchId.getM_email());
			
			rs = ps.executeQuery();
			
			if( rs.next()) {
				result = new Member();
				result.setM_id(rs.getString("m_id"));
				result.setM_name(rs.getString("m_name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return result;
	}

	// 페이지네이션을 위한 DAO
	public int getListCount(Connection con) {
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("listCount");
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if( rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return result;
	}



	

}
