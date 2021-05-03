package com.harang.naduri.jdbc.review.model.dao;

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

import com.harang.naduri.jdbc.attach.model.vo.Attach;
import com.harang.naduri.jdbc.review.model.vo.Review;

public class SelectOneDAO {
	private Properties prop;
	
	public SelectOneDAO() {
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


	public Review selectOneMyReview(Connection con, int r_no, int m_no) {
		Review review = new Review();
		review.setAttList(new ArrayList<>());
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectOneMyReview");
		
		try {
			ps = con.prepareStatement(sql);
		
			ps.setInt(1, r_no);
			ps.setInt(2, m_no);
			
			rs = ps.executeQuery();
			
			Review r = new Review();
			int oneTime =0;
			while(rs.next()) {
				if( oneTime == 0) {
					review.setRno( rs.getInt("r_no"));
					review.setR_title(rs.getString("r_title"));
					review.setR_content(rs.getString("r_content"));
					review.setR_period(rs.getString("r_period"));
					review.setR_rank(rs.getInt("r_rank"));
					
					oneTime++;
				}
				
				Attach a = new Attach();
				a.setA_name(rs.getString("a_name"));
				a.setRno(rs.getInt("r_no"));
				
				review.getAttList().add(a);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return review;
	}


	public Review selectOneLikeReview(Connection con, int r_no, int m_no) {
		Review review = new Review();
		review.setAttList(new ArrayList<>());
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectOneLikeReview");
		
		try {
			ps = con.prepareStatement(sql);
		
			ps.setInt(1, r_no);
			ps.setInt(2, m_no);
			
			rs = ps.executeQuery();
			
			Review r = new Review();
			int oneTime =0;
			while(rs.next()) {
				if( oneTime == 0) {
					review.setM_name(rs.getString("m_name"));
					review.setRno( rs.getInt("r_no"));
					review.setR_title(rs.getString("r_title"));
					review.setR_content(rs.getString("r_content"));
					review.setR_period(rs.getString("r_period"));
					review.setR_rank(rs.getInt("r_rank"));
					
					oneTime++;
				}
				
				Attach a = new Attach();
				a.setA_name(rs.getString("a_name"));
				a.setRno(rs.getInt("r_no"));
				
				review.getAttList().add(a);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return review;
	}

}

