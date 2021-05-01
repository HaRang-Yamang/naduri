package com.harang.naduri.jdbc.Thumbnail.model.dao;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.harang.naduri.jdbc.Thumbnail.model.vo.Attach;



public class ProfileImgDAO {
	private Properties prop;
	
	public ProfileImgDAO() {
		prop = new Properties();
		
		String filePath = ProfileImgDAO.class
				          .getResource("/config/profileImg.properties")
				          .getPath();
		
		try {
			prop.load( new FileReader(filePath));
			
		} catch (IOException e) {
		
			e.printStackTrace();
		} 
	}

	public int insertProfileImg(Connection con, Attach a) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertProfileImg");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, a.getAttach_name());
			ps.setInt(2, a.getM_no());
			
			result = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			close(ps);
		}

		
		return result;
	}




}

