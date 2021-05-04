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
import com.harang.naduri.jdbc.Thumbnail.model.vo.lo_key;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.location.model.vo.Location;
import com.harang.naduri.jdbc.Thumbnail.model.dao.ThumbnailDAO;


public class ThumbnailService {

	private Connection con;
	private ThumbnailDAO dao = new ThumbnailDAO();
	
	
	// 메인 인기명소 조회
	public HashMap<String, Object> hotSpot() {
		con = getConnection();
		
		HashMap<String, Object> map = new HashMap<>();
		
		map = dao.hotSpot(con);
		
		close(con);
		
		return map;
	}
	
	// --------------------------- hot spot 2 ----------------------- //
	
	public ArrayList<lo_key> hotSpot2() {
		con = getConnection();
		
		ArrayList<lo_key> lokey = new ArrayList<>();
		
		lokey = dao.hotSpot2(con);
		
		close(con);
		
		return lokey;
	}
	
	//-------------------------------- 통합 검색 2 ------------------------------//
	
	public HashMap<String, Object> selectListCollection(String spotName) {
		con = getConnection();
		
		HashMap<String, Object> map = dao.selectListCollection(con, spotName);
		
		close(con);
		
		return map;
	}
	
	//----------------------- 검색을 위한 3단계 -------------------------//
	// 1. 장소 코드 조회 (사용자 입력 값에 따라서 l_no, ls_code를 받아간다.)
		public ArrayList<Location> selectLocationCode(String spotName) {
			con = getConnection();
			
			ArrayList<Location> list = dao.selectLocationCode(con, spotName);
			
			close(con);
			
			return list;

		}

	// ls_code가 2(맛집/여행지)라면 첨부파일들을 가져온다.
	// 사용자 입력 값(Spot_name)을 가지고 게시글, 첨부파일 정보 가져오기
	public HashMap<String, Object> selectThumnail1(String spotName) {
		con = getConnection();
		
		HashMap<String, Object> list = dao.selectThumnail(con, spotName);
		
		close(con);
		
		return list;

	}


	// ls_code가 1(문화재)라면 api 요청을 위한 정보를 가져온다.
	// 사용자 입력 값(Spot_name)을 가지고 문화재 정보를 리스트에 담아 가져오기
	
	
	//-------------------------------- 통합 검색 ------------------------------//
	// select One...
	public HashMap<String, Object> selectThumnailOne(int l_no2) {
		con = getConnection();
		
		HashMap<String, Object> map = dao.selectThumnailOne(con, l_no2);
		
		close(con);
		
		return map;
	}


	
	

}