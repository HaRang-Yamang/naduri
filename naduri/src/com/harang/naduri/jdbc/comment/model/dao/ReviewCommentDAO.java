package com.harang.naduri.jdbc.comment.model.dao;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.harang.naduri.jdbc.comment.model.vo.ReviewComment;


public class ReviewCommentDAO {
	private Properties prop;
	
	public ReviewCommentDAO() {
		prop = new Properties();
		
		String filePath = ReviewCommentDAO.class
				          .getResource("/config/comment.properties")
				          .getPath();
		
		try {
			
			prop.load(new FileReader(filePath));
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}

	public int insertComment(Connection con, ReviewComment comment) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertComment");
		
		try {
			pstmt = con.prepareStatement(sql);
		
			pstmt.setInt(1, comment.getReplyno());
			pstmt.setInt(2, comment.getMno());
			
			if(comment.getRno() > 0 ) {
				pstmt.setInt(3, comment.getRno());
			} else {
				pstmt.setNull(3, java.sql.Types.NULL);
			}
			
			if(comment.getQno() > 0 ) {
				pstmt.setInt(4, comment.getQno());
			} else {
				pstmt.setNull(4, java.sql.Types.NULL);
			}
			
			pstmt.setString(5, comment.getReply_content());
			
			pstmt.setDate(6, comment.getReply_date());
			
			pstmt.setDate(7, comment.getReply_update());
			
			
			if(comment.getRef_no() > 0 ) {
				pstmt.setInt(4, comment.getRef_no());
			} else {
				pstmt.setNull(4, java.sql.Types.NULL);
			}
			
			
			result = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<ReviewComment> selectList(Connection con, int bno) {
		ArrayList<ReviewComment> clist = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, bno);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				ReviewComment bco = new ReviewComment();
				
				bco.setReplyno(   rs.getInt(1) );
				bco.setMno(   rs.getInt(2) );
				bco.setRno(   rs.getInt(2) );
				bco.setQno(   rs.getInt(2) );
				bco.setReply_content( rs.getString(3));
				bco.setReply_date( rs.getDate("date"));
				bco.setReply_update( rs.getDate("update"));
				bco.setRef_no(rs.getInt("ref_cno"));

				
				clist.add(bco);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}		
		
		return clist;
	}

	public int updateComment(Connection con, ReviewComment bco) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("updateComment");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, bco.getMno());
			ps.setInt(2, bco.getReplyno());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		} finally {
			close(ps);
		}
				
		return result;
	}

	public int deleteComment(Connection con, int cno) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteComment");
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, cno);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(ps);
		}
				
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}