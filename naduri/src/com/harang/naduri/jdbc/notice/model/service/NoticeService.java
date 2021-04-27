package com.harang.naduri.jdbc.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.harang.naduri.jdbc.notice.model.dao.NoticeDAO;
import com.harang.naduri.jdbc.notice.model.vo.Notice;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

public class NoticeService {
	
	private Connection con;
	private NoticeDAO dao = new NoticeDAO();

	public ArrayList<Notice> selectList() {
		con = getConnection();
		
		ArrayList<Notice> list = dao.selectList(con);
		
		close(con);
		
		return list;
	}

}
