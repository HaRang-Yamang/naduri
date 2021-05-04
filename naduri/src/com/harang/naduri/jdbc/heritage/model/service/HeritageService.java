package com.harang.naduri.jdbc.heritage.model.service;

import static com.harang.naduri.jdbc.common.JDBCTemplate.close;
import static com.harang.naduri.jdbc.common.JDBCTemplate.commit;
import static com.harang.naduri.jdbc.common.JDBCTemplate.getConnection;
import static com.harang.naduri.jdbc.common.JDBCTemplate.rollback;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.harang.naduri.jdbc.Thumbnail.model.vo.Thumbnail;
import com.harang.naduri.jdbc.heritage.model.dao.HeritageDAO;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.location.model.vo.Location;
import com.harang.naduri.jdbc.Thumbnail.model.dao.ThumbnailDAO;


public class HeritageService {

	private Connection con;
	private HeritageDAO dao = new HeritageDAO();
	
	
	// ��� ��ȸ �� �ʿ��� �����ڵ� ����
	public ArrayList<Heritage> selectName(String spotName) {
		
		con = getConnection();
		
		ArrayList<Heritage> list = dao.selectName(con, spotName);
		
		close(con);
		
		return list;
	}

	
	
	
	
	// ��� ��ȸ
	public ArrayList<Heritage> selectList(String spotName) {
		con = getConnection();
		
		ArrayList<Heritage> list = dao.selectList(con);
		
		close(con);
		
		return list;
	}
	
	
	
	
	// ���������� DB ����
	public int insertHeritage(Heritage heri) {
		con = getConnection();
	
		
		// 1. LOCATION ���̺� ������ ����
		int result1 = dao.insertLocation(con, heri);
		
		// ó���� �� ������ �ƴ϶� Ư�� ��� ���� ������ �Ϸ���?

		
		// Debug
		System.out.println("location id ���� ���� ���� : " + result1);
		
		
		// Location VO ����
		// Location location = new Location();
		
		
		if( result1 > 0 ) {
			commit(con);
			
			
			// 2. Locaiton ID �� ��������
			int l_no = dao.selectLno(con);
			
			// Debug
			System.out.println("location id ��ȸ ���� ���� : " + l_no);

			// l_no�� ������ ���� �ִٸ� commit
			if ( l_no < 0) {
				rollback(con);
			} else {
				commit(con);
				int result2 = 0;
				
				// Debug
				System.out.println("location id ����� Ȯ�� : " + l_no);
				
				// 3. ������ ã�� l_no�� Heritage ��ü�� �Բ� insert Heritage
				result2 = dao.insertHeritage(con, l_no, heri);
				
			
				// result2�� ������� 0�̶�� rollback
				if( result2 > 0) commit(con);
				else rollback(con);
				} // ���� if�� end
				commit(con);
			
		} // else end

		close(con);
		
		return result1;

	}
	
	// 관리자페이지 문화재 리스트 부분
	public ArrayList<Heritage> heritageList() {
		con = getConnection();
		
		ArrayList<Heritage> list = dao.heritageList(con);
		
		close(con);
		
		return list;
	}








}
