package com.harang.naduri.jdbc.member.model.service;

import java.sql.Connection;

import com.harang.naduri.jdbc.member.model.dao.KeywordDAO;
import com.harang.naduri.jdbc.member.model.vo.Keyword;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

public class KeywordService {
	
	private Connection con;
	private KeywordDAO dao = new KeywordDAO();
	
//	public int insertKeyword(Keyword joinKeyword) {
		
//		con = getConnection();
//		
//		int result = dao.insertKeyword(con, joinKeyword);
//		
//		if( result <= 0 ) {
//			rollback(con);
//		} else {
//			commit(con);
//		}
//		
//		close(con);
//		
//		return result;
//	}

}
