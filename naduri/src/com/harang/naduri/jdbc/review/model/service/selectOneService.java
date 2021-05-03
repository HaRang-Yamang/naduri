package com.harang.naduri.jdbc.review.model.service;

import static com.harang.naduri.jdbc.common.JDBCTemplate.close;
import static com.harang.naduri.jdbc.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.HashMap;

import com.harang.naduri.jdbc.review.model.dao.SelectOneDAO;
import com.harang.naduri.jdbc.review.model.vo.Review;


public class selectOneService {
	private Connection con;
	 private SelectOneDAO dao = new SelectOneDAO();

	public Review selectOneMyReview(int r_no, int m_no) {
		con = getConnection();
		Review re = dao.selectOneMyReview(con, r_no, m_no);
		
		close(con);
		
		System.out.println("re : " + re);
		
		return re;
	}

	public Review selectOneLikeReview(int r_no, int m_no) {
		con = getConnection();
		Review re = dao.selectOneLikeReview(con, r_no, m_no);
		
		close(con);
		
		System.out.println("re : " + re);
		
		return re;
	}

}
