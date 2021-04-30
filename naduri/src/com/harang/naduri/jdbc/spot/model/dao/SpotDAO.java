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
				
				s.setSpot_id(rs.getInt("Spot_id"));
				s.setL_no(rs.getInt("l_no"));
				s.setSpot_name(rs.getString("spot_name"));
				s.setSpot_type(rs.getString("spot_type"));
				s.setSpot_tel(rs.getString("spot_tel"));
				s.setSpot_time(rs.getString("spot_time"));
				s.setSpot_location(rs.getString("spot_location"));
				s.setSpot_lat(rs.getDouble("spot_lat"));
				s.setSpot_long(rs.getDouble("spot_long"));
				s.setS_status(rs.getString("s_status"));
				s.setSpot_date(rs.getString("spot_date"));
				s.setSpot_count(rs.getInt("spot_count"));
								
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
				
				s.setSpot_name(rs.getString("spot_name"));
				s.setSpot_lat(rs.getInt("spot_lat"));
				s.setSpot_long(rs.getInt("spot_long"));
			
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
	
	

}
