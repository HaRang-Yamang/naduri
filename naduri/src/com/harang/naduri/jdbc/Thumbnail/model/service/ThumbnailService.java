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
	
	/**
	 * author : dababy
	 * e-mail : pieta2529@gmail.com
	 * last-update : 2021-05-06 a.m. 11:19
	 * comment : 나드리 메인화면 썸네일을 위한 코드입니다. 
	 * 				맛집, 여행, 문화재 통합검색 및 썸네일로 표시하는 기능이지만
	 * 				매개변수가 필요 없으며 SQL문에서 조회수 TOP9 만을 조회하여 결과로 반환합니다.
	 * 
	 * **/
	// --------------------------- hot spot Main original. ver ----------------------- //
	public HashMap<String, Object> hotSpot() {
		con = getConnection();
		
		HashMap<String, Object> map = new HashMap<>();
		
		map = dao.hotSpot(con);
		
		close(con);
		
		return map;
	}
	
	// --------------------------- hot spot Main 간소화 ver ----------------------- //
	// ArrayList로 lo_key 객체 받아가는 버전입니다.
	
	public ArrayList<lo_key> hotSpot2() {
		con = getConnection();
		
		ArrayList<lo_key> lokey = new ArrayList<>();
		
		lokey = dao.hotSpot2(con);
		
		close(con);
		
		return lokey;
	}
	
	
	
	//------------------------------ Spot Search 로직 설명 (1->2 or 1->3) ---------------------------------//
	
	/**
	 * author : dababy
	 * e-mail : pieta2529@gmail.com
	 * last-update : 2021-05-06 a.m. 11:19
	 * comment : 나드리 메인 화면과 검색 화면에 있는 검색 기능을 위한 코드입니다.
	 * 				맛집, 여행, 문화재 통합검색 및 이미지를 전달합니다.
	 * 				사용자가 검색한 값으로 location id를 검색하고, 그 location id를 매개변수로 하여
	 * 				SQL문에서 일치하는 값을 찾아 결과로 반환합니다.
	 * 				
	 * 				1. 먼저, 사용자가 검색하는 곳의 장소분류가 문화재(ls_code=1)인지 맛집, 여행지(ls_code=2)인지 판별하는
	 * 				selectLocationCode 로직을 수행합니다.
	 * 
	 * 				2. ls_code가 1이라면 공공데이터 api를 호출하는 selectName(Heritage) 로직을 실행하게 됩니다.
	 * 					문화재 정보는 공공데이터 api를 이용하므로 selectName 이후 다른 service나 dao를 거치지 않습니다.
	 * 					(주의!) selectName 코드는 Heritage mvc 폴더에 있습니다.
	 * 
	 * 
	 * 				3. ls_code가 2라면 맛집, 여행지 정보를 가져오는 spotDetail 로직을 실행하게 됩니다.
	 * 
	 * 
	 * 				즉, 검색 기능은 총 2번의 로직을 거쳐야 하며 첫 로직의 결과에 따라 이후 수행되는 service와 dao가 달라집니다.
	 * **/
	
		//------------------------------------- 1. selectLocationCode ----------------------------------------//
	/**
	 * author : dababy
	 * e-mail : pieta2529@gmail.com
	 * last-update : 2021-05-06 a.m. 11:19
	 * comment : 사용자가 검색하는 곳의 장소분류가 문화재(ls_code=1)인지 맛집, 여행지(ls_code=2)인지 판별하는 로직입니다.
	 * 
	 * 				따라서, 매개변수로 장소명을 받습니다.
	 * 				사용자가 검색한 장소명으로 location id를 검색하고, 그 location id를 매개변수로 하여
	 * 				다음 로직인 selectName(Heritage) 또는 spotDetail 을 수행하여 
	 * 				검색 목록 페이지에 데이터를 전달합니다.
	 * 
	 * **/

		public ArrayList<Location> selectLocationCode(String spotName) {
			con = getConnection();
			
			ArrayList<Location> list = dao.selectLocationCode(con, spotName);
			
			close(con);
			
			return list;

		}

		//------------------------------------- 2. spot Detail ----------------------------------------//

		/**
		 * author : dababy
		 * e-mail : pieta2529@gmail.com
		 * last-update : 2021-05-06 a.m. 11:19
		 * comment : 나드리 상세페이지에 들어갈 정보를 보내주기 위한 코드입니다. 
		 * 				맛집, 여행, 문화재 통합검색 및 이미지를 전달합니다.
		 * 				사용자가 검색한 값으로 location id를 검색하고, 그 location id를 매개변수로 하여
		 * 				SQL문에서 일치하는 값을 찾아 결과로 반환합니다.
		 * 
		 * **/
		
		

		public HashMap<String, Object> spotDetail(int l_no2) {
			con = getConnection();
			HashMap<String, Object> map = new HashMap<>();
			ArrayList<lo_key> lokey = new ArrayList<>();
			
			map = dao.spotDetail(con, l_no2);
			
			close(con);
			
			return map;
		}

	
	
		//------------------------------------- 메인페이지 썸네일 ----------------------------------------//

		/**
		 * author : dababy
		 * e-mail : pieta2529@gmail.com
		 * last-update : 2021-05-06 a.m. 11:19
		 * comment : 나드리 상세페이지에 들어갈 정보를 보내주기 위한 코드입니다. 
		 * 				맛집, 여행, 문화재 통합검색 및 이미지를 전달합니다.
		 * 				사용자가 검색한 값으로 location id를 검색하고, 그 location id를 매개변수로 하여
		 * 				SQL문에서 일치하는 값을 찾아 결과로 반환합니다.
		 * 
		 * **/
		
		
		//------------------------------------- 메인 썸네일 ver 2.0 ----------------------------------------//
		public ArrayList<lo_key> hotSpot3() {
			
			con = getConnection();
			
			ArrayList<lo_key> list = dao.hotSpot3(con);
			
			close(con);
			
			return list;
		}
		
		
		//------------------------------------- 메인 썸네일 ver 1.0 ----------------------------------------//
		/*
		public HashMap<String, Object> spotDetail() {
			con = getConnection();
			HashMap<String, Object> map = new HashMap<>();
			ArrayList<lo_key> lokey = new ArrayList<>();
			
			map = dao.spotDetail(con);
			
			close(con);
			
			return map;
		}
		


		
		
		//------------------------------------- 2. spot Detail ver 2.0 ----------------------------------------//
		public ArrayList<lo_key> spotDetail2(int l_no2) {

			
				con = getConnection();
				ThumbnailDAO dao = new ThumbnailDAO();
				ArrayList<lo_key> lokey = new ArrayList<>();
				
				ArrayList<lo_key> lokey = dao.spotDetail2(con, l_no2);
				
				close(con);
				
				return lokey;
			}
		
		
		
*/


		
		}


	
	
