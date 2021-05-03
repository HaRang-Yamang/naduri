package com.harang.naduri.jdbc.Thumbnail.model.service;

import static com.harang.naduri.jdbc.common.JDBCTemplate.close;
import static com.harang.naduri.jdbc.common.JDBCTemplate.commit;
import static com.harang.naduri.jdbc.common.JDBCTemplate.getConnection;
import static com.harang.naduri.jdbc.common.JDBCTemplate.rollback;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;


import com.harang.naduri.jdbc.Thumbnail.model.vo.Thumbnail;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.location.model.vo.Location;
import com.harang.naduri.jdbc.Thumbnail.model.dao.ThumbnailDAO;


public class ThumbnailService {

	private Connection con;
	private ThumbnailDAO dao = new ThumbnailDAO();
	
	
	// ���� �α��� ��ȸ
	public HashMap<String, Object> selectList() {
		con = getConnection();
		
		HashMap<String, Object> map = new HashMap<>();
		
		map = dao.selectList(con);
		
		close(con);
		
		return map;
	}
	
	//-------------------------------- ���� �˻� 2 ------------------------------//
	
	public HashMap<String, Object> selectListCollection(String spotName) {
		con = getConnection();
		
		HashMap<String, Object> map = dao.selectListCollection(con, spotName);
		
		close(con);
		
		return map;
	}
	
	//----------------------- �˻��� ���� 3�ܰ� -------------------------//
	// 1. ��� �ڵ� ��ȸ (����� �Է� ���� ���� l_no, ls_code�� �޾ư���.)
		public ArrayList<Location> selectLocationCode(String spotName) {
			con = getConnection();
			
			ArrayList<Location> list = dao.selectLocationCode(con, spotName);
			
			close(con);
			
			return list;

		}

	// ls_code�� 2(����/������)��� ÷�����ϵ��� �����´�.
	// ����� �Է� ��(Spot_name)�� ������ �Խñ�, ÷������ ���� ��������
	public HashMap<String, Object> selectThumnail1(String spotName) {
		con = getConnection();
		
		HashMap<String, Object> list = dao.selectThumnail(con, spotName);
		
		close(con);
		
		return list;

	}


	// ls_code�� 1(��ȭ��)��� api ��û�� ���� ������ �����´�.
	// ����� �Է� ��(Spot_name)�� ������ ��ȭ�� ������ ����Ʈ�� ��� ��������
	
	
	//-------------------------------- ���� �˻� ------------------------------//
	// select One...
	public HashMap<String, Object> selectThumnailOne(int l_no2) {
		con = getConnection();
		
		HashMap<String, Object> map = dao.selectThumnailOne(con, l_no2);
		
		close(con);
		
		return map;
	}


	
	

}