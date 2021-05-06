package com.harang.naduri.jdbc.admin.model.dao;

import static com.harang.naduri.jdbc.common.JDBCTemplate.close;
import static com.harang.naduri.jdbc.common.JDBCTemplate.commit;
import static com.harang.naduri.jdbc.common.JDBCTemplate.getConnection;
import static com.harang.naduri.jdbc.common.JDBCTemplate.rollback;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.harang.naduri.jdbc.Thumbnail.model.vo.Thumbnail;
import com.harang.naduri.jdbc.Thumbnail.model.vo.lo_key;
import com.harang.naduri.jdbc.attach.model.vo.Attach;
import com.harang.naduri.jdbc.comment.model.dao.ReviewCommentDAO;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.location.model.vo.Location;
import com.harang.naduri.jdbc.review.model.dao.ReviewDAO;
import com.harang.naduri.jdbc.review.model.vo.Review;
import com.harang.naduri.jdbc.spot.model.vo.Spot;
import com.harang.naduri.jdbc.Thumbnail.model.dao.ThumbnailDAO;


public class AdminDAO {

// 전역변수로 prop 선언
private Properties prop;
	
	public AdminDAO() {
		
	prop = new Properties();
	
	String filePath = ReviewCommentDAO.class
			          .getResource("/config/admin.properties")
			          .getPath();
	
	try {
		
		prop.load(new FileReader(filePath));
		
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	} catch (IOException e) {

		e.printStackTrace();
	}
	
}
// 0. location table 데이터 생성
	public int insertLocation(Connection con, Spot s) {
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
	
	
	// 1. select no
	public int selectLno(Connection con) {

		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectLno");

		try {

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			if (rs.next()) {
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
	
	
//	// 맛집 정보 등록 
//	public int	AdminFoodLocation (Connection con, int l_no, Spot s) {
//		
//		int result =0;
//		
//		PreparedStatement ps = null;
//		
//		String sql = prop.getProperty("AdminFoodLocation");
//		
//		try {
//			ps = con.prepareStatement(sql);
//			
//			result = ps.executeUpdate();
//					
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}finally {
//			close(ps);
//		}
//		return result;
//	}
	
	
	
	// 2. 최신 장소 정보 가져오기
	public int getCurrentLno(Connection con) {
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("currentSid");
		try {
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}

		return result;
	}
	

// 1. 글 정보 insert
public int AdminFoodInsert(Connection con, int l_no, Spot s) {
	
	int result =0;
	
	PreparedStatement ps = null;
	
	String sql = prop.getProperty("AdminFoodInsert");
	
	try {
		ps = con.prepareStatement(sql);
		
		ps.setInt(1, l_no);
		ps.setString(2, s.getS_name());
		ps.setString(3, s.getS_tel());
		ps.setString(4, s.getS_time());
		ps.setString(5, s.getS_address());
		ps.setString(6, s.getS_lat());
		ps.setString(7, s.getS_lng());


		result = ps.executeUpdate();
				
	} catch (SQLException e) {

		e.printStackTrace();
	}finally {
		close(ps);
	}
	return result;
}


// 2. 최신 장소 정보 가져오기
public int getCurrentSid(Connection con) {
	int result = 0;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = prop.getProperty("getCurrentSid");
	try {
		ps=con.prepareStatement(sql);
		
		rs=ps.executeQuery();
		if(rs.next()) {
			result = rs.getInt(1);
		}
	} catch (SQLException e) {

		e.printStackTrace();
	}finally {
		close(rs);
		close(ps);
	}

	return result;
}


// 3. 첨부파일 정보 저장하기
public int insertAttach(Connection con, Attach attach) {
	int result =0;
	PreparedStatement ps = null;
	String sql = prop.getProperty("insertAttach");
	
	try {
		ps= con.prepareStatement(sql);
		ps.setString(1, attach.getA_name());
		ps.setInt(2,attach.getM_no() );
		ps.setInt(3, attach.getL_no());
	 result =ps.executeUpdate();
				} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close(ps);
	}
	return result;
}






		
	}