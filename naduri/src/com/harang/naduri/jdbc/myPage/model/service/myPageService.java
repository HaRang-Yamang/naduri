package com.harang.naduri.jdbc.myPage.model.service;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import com.harang.naduri.jdbc.attach.model.vo.*;
import com.harang.naduri.jdbc.myPage.model.dao.myPageDAO;

public class myPageService {

	private Connection con;
	private myPageDAO dao = new myPageDAO();
	
	public Attach myPage(int m_no) {
		
		con = getConnection();
		
		Attach result = dao.myPageView(con, m_no);
				
		close(con);
		
		return result;
	}

}
