package com.harang.naduri.jdbc.qna.model.service;

import com.harang.naduri.jdbc.qna.model.dao.QnaDAO;
import com.harang.naduri.jdbc.qna.model.vo.Qna;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
public class QnaService {
	private Connection con;
	private QnaDAO dao = new QnaDAO();
	
	public int insertQna(Qna qn) {
		con =getConnection();
		int result =dao.insertQna(con,qn);
		if(result>0) commit(con);
		else rollback(con);
		close(con);
		return result;
	}
	public ArrayList<Qna> selectQnaList() {
		con = getConnection();
		ArrayList<Qna>list= dao.SelectQnaList(con);
		close(con);
		return list;
	}
	public ArrayList<Qna> selectMyQnaList(int m_no) {
		con = getConnection();
		ArrayList<Qna>list= dao.SelectMyQnaList(con, m_no);
		close(con);
		return list;
	}

}
