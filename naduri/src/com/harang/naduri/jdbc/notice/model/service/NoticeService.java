package com.harang.naduri.jdbc.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.harang.naduri.jdbc.notice.model.dao.NoticeDAO;
import com.harang.naduri.jdbc.notice.model.vo.Notice;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

public class NoticeService {
	
	private Connection con;
	private NoticeDAO dao = new NoticeDAO();

	public ArrayList<Notice> selectList() {
		con = getConnection();
		
		ArrayList<Notice> list = dao.selectList(con);
		
		close(con);
		
		return list;
	}

	public int insertNotice(Notice n) {
		con = getConnection();
		
		int result = dao.insertNotice(con, n);
		
		if( result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	// 공지사항 게시글 1개 조회 시
	public Notice selectOne(int n_no) {
		con = getConnection();
		
		int result = 0;
		
		Notice n = dao.selectOne(con, n_no);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return n;	// 여기서 이제 서블릿으로 다시 이동!
	}

}
