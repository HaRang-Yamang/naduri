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
import com.harang.naduri.jdbc.member.model.vo.Member;
import com.harang.naduri.jdbc.review.model.vo.Review;

public class ReviewDAO {
private Properties prop;

public ReviewDAO() {
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
	public int insertReview(Connection con, Review r) {
	int result =0;
	PreparedStatement ps = null;
	String sql = prop.getProperty("insertReview");
	try {
		ps = con.prepareStatement(sql);
		ps.setInt(1, r.getM_no());
		ps.setInt(2, r.getR_rank());
		ps.setString(3, r.getR_title());
		ps.setString(4, r.getR_content());
		ps.setString(5,r.getR_period());
		ps.setInt(6, r.getR_with());
				result = ps.executeUpdate();
				
	} catch (SQLException e) {

		e.printStackTrace();
	}finally {
		close(ps);
	}
	
	
		return result;
	}
	public int getCurrentRno(Connection con) {
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("currentRno");
		try {
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}

		return result;
	}
	public int insertAttach(Connection con, Attach attach) {
		int result =0;
		PreparedStatement ps = null;
		String sql =prop.getProperty("insertAttach");
		
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, attach.getA_name());
			ps.setInt(2,attach.getM_no() );
		 result =ps.executeUpdate();
					} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}
	public ArrayList<Review> selectMyReview(Connection con, int m_no) {
		ArrayList<Review> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectMyReview");
		
		try {
			ps = con.prepareStatement(sql);
		
			ps.setInt(1, m_no);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Review r = new Review();
				//Attach a = new Attach();
				// R_TITLE, R_CONTENT, R_PERIOD, R_LIKE
				r.setR_title(rs.getString("r_title"));
				r.setR_content(rs.getString("r_content"));
				r.setR_period(rs.getString("r_period"));
				r.setR_rank(rs.getInt("r_rank"));
				//a.setA_path(rs.getString("a_path"));
				// r.setR_like(rs.getInt("r_like"));
				
				list.add(r);
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
	public ArrayList<Review> selectReviewList(Connection con, int lno) {
		ArrayList<Review> reviewList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectReviewList");
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, lno);
			
			rs=ps.executeQuery();
			
			Review r = new Review();
			ArrayList<Attach>list = new ArrayList<>();
			
			while(rs.next()) {
				if(r.getRno() == rs.getInt("r_no")) {
					// 첨부파일
					Attach a = new Attach();
					a.setA_no(rs.getInt("a_no"));
					a.setA_name(rs.getString("a_name"));
				
					list.add(a);
					
					r.setAttList(list);
				} else {
					r = new Review();
					r.setRno(rs.getInt("r_no"));
					r.setR_title(rs.getString("r_title"));
					r.setR_content(rs.getString("r_content"));
					r.setR_period(rs.getString("r_period"));
					r.setR_rank(rs.getInt("r_rank"));
					r.setR_with(rs.getInt("r_with"));
					r.setR_date(rs.getDate("r_date"));
					r.setM_id(rs.getString("m_name"));
					
					list = new ArrayList<>();
					
					Attach a = new Attach();
					a.setA_no(rs.getInt("a_no"));
					a.setA_name(rs.getString("a_name"));
					
					list.add(a);
					
					r.setAttList(list);
				}
				reviewList.add(r);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return reviewList;
	}
	
}
