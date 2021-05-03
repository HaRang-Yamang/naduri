package com.harang.naduri.jdbc.Thumbnail.model.dao;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.harang.naduri.jdbc.Thumbnail.model.vo.Attach;
import com.harang.naduri.jdbc.Thumbnail.model.vo.Thumbnail;

public class ThumbnailDAO {
	private Properties prop;
	
	public ThumbnailDAO() {
		prop = new Properties();
		
		String filePath = ThumbnailDAO.class
				          .getResource("/config/thumbnail.properties")
				          .getPath();
		
		try {
			prop.load( new FileReader(filePath));
			
		} catch (IOException e) {
		
			e.printStackTrace();
		} 
	}

	public ArrayList<Thumbnail> selectList(Connection con) {
		ArrayList<Thumbnail> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Thumbnail t = new Thumbnail();
				Attach a = new Attach();
				
				t.setSpot_id(      rs.getInt("spot_id"));
				t.setL_no(      rs.getInt("l_no"));
				t.setSpot_name(   rs.getString("spot_name"));
				t.setSpot_type( rs.getString("spot_type"));
				t.setSpot_tel(  rs.getString("spot_tel"));
				t.setSpot_time(  rs.getString("spot_time"));
				t.setSpot_location(  rs.getString("spot_location"));
				t.setSpot_lat(  rs.getInt("spot_lat"));
				t.setSpot_long(  rs.getInt("spot_long"));
				t.setS_status(  rs.getString("s_status"));
				t.setSpot_count(  rs.getInt("spot_count"));
				t.setSpot_file(rs.getString("spot_file"));
				
				a.setA_name(rs.getString("a_name"));
				
				list.add(t);
				
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
