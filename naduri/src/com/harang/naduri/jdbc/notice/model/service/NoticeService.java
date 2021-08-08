package com.harang.naduri.jdbc.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.harang.naduri.jdbc.notice.model.dao.NoticeDAO;
import com.harang.naduri.jdbc.attach.model.vo.*;
import com.harang.naduri.jdbc.notice.model.vo.Notice;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

public class NoticeService {
	
	private Connection con;
	private NoticeDAO dao = new NoticeDAO();

	public ArrayList<Notice> selectList(int currentPage) {
		con = getConnection();
		
		ArrayList<Notice> list = dao.selectList(con, currentPage);
		
		close(con);
		
		return list;
	}

	// 공지사항 작성 시
	public int insertNotice(Notice n) {
		con = getConnection();
		ArrayList<Attach> list = n.getAttList();
		
		// 1. 게시글 저장
		int result = dao.insertNotice(con, n);
		
		if(result > 0) {
			int n_no = dao.getCurrentN_no(con);
			
			for(int i = 0; i < list.size(); i++ ) {
				list.get(i).setN_no(n_no);
			}
			
		} 
		
		// 2. 첨부파일 저장
		int result2 = 0;
		
		for( int i = 0; i < list.size(); i++) {
			if(list.get(i) != null && list.get(i).getA_name() != null) {
				
				result2 = dao.insertAttachment(con, list.get(i));
				
				if(result2 == 0 ) break;
			} else {
				result2 = 1;
			}
		}
		
		if (result > 0 && result2 > 0 ) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}
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

	// 게시물 수정
	public Notice noticeUpdate(int n_no) {
		// 수정하고자 하는 내용이 들어있어야 거기서 수정이 가능!
		// 위의 게시글 1개 조회 시 사용한 서비스와 동일하게 작성
		con = getConnection();
		
		int result = 0;
		
		Notice n = dao.selectOne(con, n_no);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return n;
		
	}

	public int updateList(Notice n) {
		con = getConnection();
		
		int result = dao.updateList(con, n);
		
		if( result > 0 ) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int deleteNotice(int n_no) {
		
		con = getConnection();
		
		int result = dao.deleteNotice(con, n_no);
		
		if ( result > 0) {
			commit(con);
			
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	// 페이지네이션을 위한 서비스 생성
	public int getListCount() {
		con = getConnection();
		
		int result = dao.getListCount(con);
		
		close(con);
		
		return result;
	}

}
