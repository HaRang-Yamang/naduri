package com.harang.naduri.jdbc.comment.model.service;


import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.harang.naduri.jdbc.comment.model.dao.CommentDAO;

import com.harang.naduri.jdbc.comment.model.vo.Comment;


public class CommentService {

private Connection con;
	
	private CommentDAO dao = new CommentDAO();
	
	
	
	
	// 리뷰 댓글 등록
	public int insertRComment(Comment Rcomment) {
		con = getConnection();
		
		int result = dao.insertComment(con, Rcomment);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	
	
	

	// 리뷰 댓글 목록
	public ArrayList<Comment> selectList(int bno) {
		con = getConnection();
		
		ArrayList<Comment> clist = dao.selectList(con, bno);
		
		close(con);
		
		return clist;
	}

	// 리뷰 댓글 수정
	public int updateComment(Comment bco) {
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

	
	// 리뷰 댓글 삭제
	public int deleteComment(int cno) {
		con = getConnection();
		
		int result = dao.deleteComment(con, cno);
		
		if ( result > 0 ) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	
	
	
	
	
	// ------------------------------------------ QNA 등록 ------------------------------------------------- //
	
	
	// 질문 댓글 등록
	public int insertQComment(Comment Qcomment) {
		con = getConnection();
		
		int result = dao.insertComment(con, Qcomment);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	
	
	
	
	
	
}