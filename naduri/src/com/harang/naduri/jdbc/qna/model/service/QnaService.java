package com.harang.naduri.jdbc.qna.model.service;

import com.harang.naduri.jdbc.qna.model.dao.QnaDAO;
import com.harang.naduri.jdbc.qna.model.vo.Qna;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
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

}
