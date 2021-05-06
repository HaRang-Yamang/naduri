package com.harang.naduri.jdbc.bookmark.model.dao;

import static com.harang.naduri.jdbc.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.harang.naduri.jdbc.bookmark.model.vo.Bookmark;

public class BookmarkDAO {
	private Properties prop;
	
	public BookmarkDAO() {
		prop = new Properties();
		
		// 파일 경로
		String filePath = BookmarkDAO.class
				         .getResource("/config/bookmark.properties")
				         .getPath();
		
		try {
			
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public int insertBookmark(Connection con, Bookmark b) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertBookmark");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, b.getL_no());
			ps.setInt(2, b.getM_no());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(ps);
		}
		
		return result;
		
		
		
	}

}
