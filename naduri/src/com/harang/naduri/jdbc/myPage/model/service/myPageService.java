package com.harang.naduri.jdbc.myPage.model.service;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;

import com.harang.naduri.jdbc.attach.model.vo.*;
import com.harang.naduri.jdbc.myPage.model.dao.myPageDAO;

public class myPageService {

	private Connection con;
	private myPageDAO dao = new myPageDAO();
	
	public HashMap<String, Object> myPage(int m_no) {
		
		con = getConnection();
		HashMap<String , Object> map = new HashMap<>();
		map.put("a", dao.myPageView(con, m_no));
		map.put("listk", dao.myPageKeyword(con, m_no));
				
		close(con);
		
		return map;
	}

}
