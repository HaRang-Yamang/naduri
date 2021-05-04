package com.harang.naduri.jdbc.review.model.service;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import com.harang.naduri.jdbc.review.model.dao.LikeCountDAO;
import com.harang.naduri.jdbc.review.model.vo.Review;

public class LikeCountService {
	private Connection con;
	 private LikeCountDAO dao = new LikeCountDAO();

	public int LikeCount(int r_no, int m_no) {
		con = getConnection();
		int re = dao.LikeCount(con, r_no, m_no);
		
		close(con);
		
		System.out.println("re : " + re);
		
		return re;
	}

	

	
}
