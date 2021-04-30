package com.harang.naduri.jdbc.comment.model.service;


import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.harang.naduri.jdbc.comment.model.dao.ReviewCommentDAO;
import com.harang.naduri.jdbc.comment.model.vo.ReviewComment;

public class ReviewCommentService {

private Connection con;
	
	private ReviewCommentDAO dao = new ReviewCommentDAO();
	
	public int insertComment(ReviewComment comment) {
		con = getConnection();
		
		int result = dao.insertComment(con, comment);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<ReviewComment> selectList(int bno) {
		con = getConnection();
		
		ArrayList<ReviewComment> clist = dao.selectList(con, bno);
		
		close(con);
		
		return clist;
	}

	public int updateComment(ReviewComment bco) {
		con = getConnection();
		
		int result = dao.updateComment(con, bco);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int deleteComment(int cno) {
		con = getConnection();
		
		int result = dao.deleteComment(con, cno);
		
		if ( result > 0 ) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}