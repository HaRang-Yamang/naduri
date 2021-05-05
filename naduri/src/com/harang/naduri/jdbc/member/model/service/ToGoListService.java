package com.harang.naduri.jdbc.member.model.service;

import static com.harang.naduri.jdbc.common.JDBCTemplate.close;
import static com.harang.naduri.jdbc.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.harang.naduri.jdbc.member.model.dao.ToGoListDAO;


public class ToGoListService {
	private Connection con;
	 private ToGoListDAO dao = new ToGoListDAO();

	public List<Map<String, Object>> togolist(int m_no) {
		con = getConnection();
		List<Map<String, Object>> list = dao.togolist(con, m_no);
		List<Map<String, Object>> list2 = dao.togolist(con, m_no);
		
		close(con);
		
		return list;
	}

}
