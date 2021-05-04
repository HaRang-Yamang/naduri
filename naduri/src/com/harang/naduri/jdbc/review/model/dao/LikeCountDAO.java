package com.harang.naduri.jdbc.review.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.harang.naduri.jdbc.bookmark.model.vo.Bookmark;
import com.harang.naduri.jdbc.review.model.vo.Review;
import static com.harang.naduri.jdbc.common.JDBCTemplate.close;

public class LikeCountDAO {
	private Properties prop;
	
	public LikeCountDAO() {
		prop= new Properties();
		String filePath = ReviewDAO.class
		          .getResource("/config/review.properties")
		          .getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int LikeCount(Connection con, int r_no, int m_no) {
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("likeCount");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, r_no);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		
		return result;
	}

}
