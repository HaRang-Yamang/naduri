package com.harang.naduri.jdbc.bookmark.model.service;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import com.harang.naduri.jdbc.bookmark.model.dao.BookmarkDAO;
import com.harang.naduri.jdbc.bookmark.model.vo.Bookmark;


public class BookmarkService {
	private Connection con;
	private BookmarkDAO dao = new BookmarkDAO();

	public int insertBookmark(Bookmark b) {
		con = getConnection();
		
		int result = 0;
		
		Bookmark bk = dao.selectBookmark(con, b);
		if( bk == null) {
			result = dao.insertBookmark(con, b);
		} else {
			result = dao.deleteBookmark(con, b);
		}
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}


}
