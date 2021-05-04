package com.harang.naduri.jdbc.heritage.model.dao;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.harang.naduri.jdbc.heritage.model.vo.Heritage;

public class HeritageDAO {
	private Properties prop;
	
	public HeritageDAO() {
		prop = new Properties();
		
		String filePath = HeritageDAO.class
				          .getResource("/config/heritage.properties")
				          .getPath();
		
		try {
			prop.load( new FileReader(filePath));
			
		} catch (IOException e) {
		
			e.printStackTrace();
		} 
	}
	
	
	// select Heritage Name
	
	public ArrayList<Heritage> selectName(Connection con, String spotName) {
		ArrayList<Heritage> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectName");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, spotName);
			
			
			rs = ps.executeQuery();
			
			// Debug
			System.out.println("쿼리문 실행 결과 : " + rs);
			
			// 결과데이터 반복문돌려서 리스트에 담기 (객체 배열 생성)
						while(rs.next()) {
							Heritage h = new Heritage();
							
							h.setH_events(      rs.getString("h_events"));
							h.setH_serial(      rs.getString("h_serial"));
							h.setH_zipcode(      rs.getString("h_zipcode"));
							h.setH_name(      rs.getString("h_name"));
							
							// Debug
							System.out.println("DAO 반복문 결과 : " + h);
							
							list.add(h);
						}
						// Debug
						System.out.println("DAO 반복문 결과2 : " + list);
						
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {

			close(rs);
			close(ps);
		}
		
		// Debug
		System.out.println(list);
		return list;
	}
	
	
	

	
	// insert Heritage
	
	public int insertLocation(Connection con, Heritage heri) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("insertLocation");
		
		try {
			
			ps = con.prepareStatement(sql);
			
			result = ps.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			close(ps);
		}
			
		return result;
	}
	

			public int selectLno(Connection con) {

				int result = 0;
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				String sql = prop.getProperty("selectLno");
				
				try {
				
					ps = con.prepareStatement(sql);
					
					rs = ps.executeQuery();

					if(rs.next()){
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
	
	
	public int insertHeritage(Connection con, int l_no, Heritage heri) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("insertHeritage");
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, l_no);
			ps.setString(2, heri.getH_events());
			ps.setString(3, heri.getH_serial());
			ps.setString(4, heri.getH_zipcode());
			ps.setString(5, heri.getH_name());
			
			
			result = ps.executeUpdate();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			close(ps);
		}
			
		return result;
	}
	
	

	public ArrayList<Heritage> selectList(Connection con) {
		
		// 문화재 데이터 담을 리스트
		ArrayList<Heritage> list = new ArrayList<>();
		
		// 쿼리문 준비
		PreparedStatement ps = null;
		
		// 결과 데이터
		ResultSet rs = null;
		
		// properties 변수에 담기
		String sql = prop.getProperty("selectHeritage");
		
		try {
			
			// 쿼리문 실행
			ps = con.prepareStatement(sql);
			
			// 실행결과 결과데이터에 담기
			rs = ps.executeQuery();
			
			
			// 결과데이터 반복문돌려서 리스트에 담기 (객체 배열 생성)
			while(rs.next()) {
				Heritage h = new Heritage();
				
				h.setH_id(      rs.getInt("h_id"));
				h.setL_no(      rs.getInt("l_no"));
				h.setH_events(      rs.getString("h_events"));
				h.setH_serial(      rs.getString("h_serial"));
				h.setH_zipcode(      rs.getString("h_zipcode"));
				h.setH_status(      rs.getString("h_status"));
				h.setH_count(      rs.getInt("h_count"));
				
				list.add(h);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);			
					
			
		}
		
		return list;
	}

	// 관리자 페이지 문화재 리스트 부분
	public ArrayList<Heritage> heritageList(Connection con) {
		ArrayList<Heritage> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("adminHeritage");
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Heritage h = new Heritage();
				
				h.setH_id(      rs.getInt("h_id"));
				h.setH_name(      rs.getString("h_name"));
		
				
				list.add(h);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close(rs);
			close(ps);
		}
		return list;
	}




	
	
	
	
	
	
	
	
	
	
}
