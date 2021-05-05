package com.harang.naduri.jdbc.member.model.service;

import static com.harang.naduri.jdbc.common.JDBCTemplate.close;
import static com.harang.naduri.jdbc.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.HashMap;

import com.harang.naduri.jdbc.member.model.dao.ToGoListDAO;


public class ToGoListService {
	private Connection con;
	 private ToGoListDAO dao = new ToGoListDAO();

	public HashMap<String, Object> togolist(int m_no) {
		con = getConnection();
		HashMap<String , Object> map = dao.togolist(con, m_no);
		
		close(con);
		
		return map;
	}

}
