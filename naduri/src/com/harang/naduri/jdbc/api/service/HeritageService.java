package service;

import java.sql.Connection;
import java.util.ArrayList;

import vo.Heritage;
import vo.HeritageDAO;

import static common.JDBCTemplate.*;

public class HeritageService {

	private Connection con;
	private HeritageDAO dao = new HeritageDAO();
	
	public ArrayList<Heritage> selectList(int currentPage) {
		con = getConnection();
		
		ArrayList<Heritage> list = dao.selectList(con, currentPage);
		
		close(con);
		
		return list;
	}


	
}



























