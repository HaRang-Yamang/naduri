package com.harang.naduri.jdbc.spot.model.dao;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.harang.naduri.jdbc.spot.model.vo.Spot;

public class SpotDAO {

	private Properties prop;
		
	public SpotDAO() {
		prop = new Properties(); 
		
		String filePath = SpotDAO.class
						  .getResource("/config/spot.properties")
						  .getPath();
				
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public ArrayList<Spot> selectList(Connection con) {
		
		ArrayList<Spot> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Spot s = new Spot();
				
				s.setS_id(rs.getInt("s_id"));
				s.setL_no(rs.getInt("l_no"));
				s.setS_name(rs.getString("s_name"));
				s.setS_type(rs.getString("s_type"));
				s.setS_tel(rs.getString("s_tel"));
				s.setS_time(rs.getString("s_time"));
				s.setS_address(rs.getString("s_address"));
				s.setS_lat(rs.getString("s_lat"));
				s.setS_lng(rs.getString("s_lng"));
				s.setS_status(rs.getString("s_status"));
				s.setS_date(rs.getString("s_date"));
				s.setS_count(rs.getInt("s_count"));
								
				list.add(s);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		
		return list;
	}

	public List<Spot> getlocation(Connection con) {
		
		List<Spot> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("getlocation");
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Spot s = new Spot();
				
				s.setS_name(rs.getString("s_name"));
				s.setS_lat(rs.getString("s_lat"));
				s.setS_lng(rs.getString("s_lng"));
			
				list.add(s);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}




	public ArrayList<Spot> foodList(Connection con, int currentPage) {
		
		ArrayList<Spot> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("foodList");
		
		int startRow = (currentPage - 1) * 10 + 1;
		int endRow = currentPage * 10;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, endRow);
			ps.setInt(2, startRow);
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Spot ss = new Spot();
				
				
				ss.setS_id(rs.getInt("s_id"));
				ss.setS_name(rs.getString("s_name"));
				ss.setS_status(rs.getString("s_status"));
				
				list.add(ss);
				
			}
			//System.out.println("list : " + list);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
	
		return list;
	}




	public ArrayList<Spot> spotList(Connection con, int currentPage) {
		ArrayList<Spot> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("spotList");
		int startRow = (currentPage - 1) * 10 + 1;
		int endRow = currentPage * 10;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, endRow);
			ps.setInt(2, startRow);
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Spot ss = new Spot();
				
				
				ss.setS_id(rs.getInt("s_id"));
				ss.setS_name(rs.getString("s_name"));
				ss.setS_status(rs.getString("s_status"));
				
				list.add(ss);
				
			}
			// System.out.println("여행지 list : " + list);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
	
		return list;
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



	//관리자페이지 맛집데이터 업데이트 부분
	public int foodUpdateList(Connection con, int s_id, String s_status) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("adminUpdateFood");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, s_status);
			ps.setInt(2, s_id);
			
			result = ps.executeUpdate();
			
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close(ps);
		}
		
		return result;
	}

}
