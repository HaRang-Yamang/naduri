package com.harang.naduri.jdbc.member.model.dao;

import static com.harang.naduri.jdbc.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.harang.naduri.jdbc.Thumbnail.model.vo.lo_key;
import com.harang.naduri.jdbc.member.model.vo.Keyword;
import com.harang.naduri.jdbc.review.model.dao.ReviewDAO;

public class ToGoListDAO {
	private Properties prop;
	
	public ToGoListDAO(){
		
		prop= new Properties();
		String filePath = ReviewDAO.class
		          .getResource("/config/togolist.properties")
		          .getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<lo_key> togolist(Connection con, int m_no) {
		ArrayList<lo_key> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("togolist");
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, m_no);
			rs = ps.executeQuery();
			
			lo_key lk = new lo_key();
			
			while(rs.next()) {
				
				if (lk.getL_no() != rs.getInt("l_no")) { // 첫번째라면
					
					lk = new lo_key();
					
					lk.setL_no(rs.getInt("l_no"));
					lk.setA_name(rs.getString("a_name"));
					lk.setLocal_name(rs.getString("local_name"));
					lk.setFlevel(rs.getInt("flevel"));

					lk.setKeyword(new ArrayList<>());
					
					list.add(lk);
				}
				
				lk.getKeyword().add(rs.getString("keyword"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}

}
