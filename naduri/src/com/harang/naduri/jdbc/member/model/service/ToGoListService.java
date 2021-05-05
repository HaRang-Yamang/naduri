package com.harang.naduri.jdbc.member.model.service;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.harang.naduri.jdbc.Thumbnail.model.vo.lo_key;
import com.harang.naduri.jdbc.member.model.dao.ToGoListDAO;

public class ToGoListService {
	private Connection con;
	 private ToGoListDAO dao = new ToGoListDAO();

	public HashMap<String, Object> togoList(int m_no) {
		con = getConnection();
		HashMap<String, Object> map = dao.togolist(con, m_no);


		close(con);
		
		return map;
	}

}
