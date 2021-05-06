package com.harang.naduri.jdbc.Thumbnail.model.dao;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.harang.naduri.jdbc.attach.model.vo.Attach;
import com.harang.naduri.jdbc.Thumbnail.model.vo.Thumbnail;
import com.harang.naduri.jdbc.Thumbnail.model.vo.lo_key;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.location.model.vo.Location;
import com.harang.naduri.jdbc.review.model.vo.Review;
import com.harang.naduri.jdbc.spot.model.vo.Spot;

public class ThumbnailDAO {
	private Properties prop;
	
	public ThumbnailDAO() {
		prop = new Properties();
		
		String filePath = ThumbnailDAO.class
				          .getResource("/config/thumbnail.properties")
				          .getPath();
		
		try {
			prop.load( new FileReader(filePath));
			
		} catch (IOException e) {
		
			e.printStackTrace();
		} 
	}
	
	
	// --------------------------- hot spot Main original. ver ----------------------- //
	
	/**
	 * author : dababy
	 * e-mail : pieta2529@gmail.com
	 * last-update : 2021-05-06 p.m. 12:50
	 * comment : 나드리 메인화면 썸네일을 위한 코드입니다. 
	 * 				맛집, 여행, 문화재 통합검색 및 썸네일로 표시하는 기능이지만
	 * 				매개변수가 필요 없으며 SQL문에서 조회수 TOP9 만을 조회하여 결과로 반환합니다.
	 * 
	 * **/
	public HashMap<String, Object> hotSpot(Connection con) {
		// 해시맵 준비
		HashMap<String, Object> map = new HashMap<>();
		
		// 맛집과 여행지 정보 저장 객체
		ArrayList<Thumbnail> list = new ArrayList<>();
		// 첨부파일 저장 객체
		ArrayList<Attach> list2 = new ArrayList<>();
		// 문화재 정보 저장 객체
		ArrayList<Heritage> listHeri = new ArrayList<>();
		// 장소와 키워드 정보 저장 객체
		ArrayList<Location> lo_key = new ArrayList<>();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("hotSpot");
		
		try {
			ps = con.prepareStatement(sql);
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Thumbnail t = new Thumbnail();
				Attach a = new Attach();
				Heritage h = new Heritage();
				Location l = new Location();
				
				
				// 맛집, 여행지 정보 저장
				t.setS_id(      rs.getInt("s_id"));
				t.setL_no(      rs.getInt("l_no"));
				t.setS_name(   rs.getString("s_name"));
				t.setS_tel(  rs.getString("s_tel"));
				t.setS_time(  rs.getString("s_time"));
				t.setS_address(  rs.getString("s_address"));
				t.setS_lat(  rs.getString("s_lat"));
				t.setS_lng(  rs.getString("s_lng"));
				t.setS_status(  rs.getString("s_status"));
				t.setS_count(  rs.getInt("s_count"));
				
				
				a.setA_name(rs.getString("a_name"));
				a.setS_id(rs.getInt("s_id"));
				
				list2.add(a);
				
				// 문화재 정보 저장
				h.setH_events(      rs.getString("h_events"));
				h.setH_serial(      rs.getString("h_serial")); 
				h.setH_zipcode(      rs.getString("h_zipcode"));
				h.setH_name(      rs.getString("h_name"));
				
				listHeri.add(h);
				
				// 장소와 키워드 정보 저장
				l.setL_no(rs.getInt("l_no"));
				l.setLs_code(rs.getInt("ls_code"));
				l.setKeyword_id(rs.getInt("keyword_id"));
				l.setKeyword(rs.getString("keyword"));
				
				lo_key.add(l);
				
				
				if(list.contains(t)) {
					list.add(t);
				}
				
			}
			
			map.put("list", list); // 맛집, 여행지 정보 저장
			map.put("list2", list2); // 첨부파일 정보 저장
			map.put("listHeri", listHeri); // 맛집, 여행지 정보 저장
			map.put("lo_key", lo_key); // 첨부파일 정보 저장
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);			

		}
		
		return map;
	}
	
	// --------------------------- hot spot Main 간소화 ver ----------------------- //
	
	/**
	 * author : dababy
	 * e-mail : pieta2529@gmail.com
	 * last-update : 2021-05-06 p.m. 12:50
	 * comment : 나드리 메인화면 썸네일을 위한 코드입니다. 
	 * 				맛집, 여행, 문화재 통합검색 및 썸네일로 표시하는 기능이지만
	 * 				매개변수가 필요 없으며 SQL문에서 조회수 TOP9 만을 조회하여 결과로 반환합니다.
	 * 
	 * **/
	
	public ArrayList<lo_key> hotSpot2(Connection con) {

					// 맛집과 여행지 정보 저장 객체
					ArrayList<lo_key> lokey = new ArrayList<>();

					
					
					PreparedStatement ps = null;
					ResultSet rs = null;
					
					String sql = prop.getProperty("hotSpot");
					
					try {
						ps = con.prepareStatement(sql);
						
						
						rs = ps.executeQuery();
						
						while(rs.next()) {
							
						
							lo_key l = new lo_key();
							
							l.setL_no(rs.getInt("l_no"));
							l.setLs_code(rs.getInt("ls_code"));
							l.setLocal_name(rs.getString("local_name"));
							l.setCount_all(rs.getInt("count_all"));
							l.setKeywords(rs.getString("keyword"));
							l.setA_no(rs.getInt("a_no"));
							l.setA_name(rs.getString("a_name"));
							l.setA_status(rs.getString("a_status"));
							l.setR_no(rs.getInt("r_no"));
							l.setM_no(rs.getInt("m_no"));
							l.setN_no(rs.getInt("n_no"));
							l.setS_id(rs.getInt("s_id"));
							l.setFlevel(rs.getInt("flevel"));
							
							

						
							lokey.add(l);
						}
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					} finally {
						close(ps);			

					}
					
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
		

		public ArrayList<Location> selectLocationCode(Connection con, String spotName) {
			// 게시글 코드 가지고 갈 리스트 준비 
			ArrayList<Location> list = new ArrayList();
			// 장소 객체 준비
			Location location = new Location();

			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = prop.getProperty("selectLocationCode");
			
			try {
				
				ps = con.prepareStatement(sql);
				
				ps.setString(1, spotName);
				ps.setString(2, spotName);
				
				rs = ps.executeQuery();

				
				while(rs.next()) {
					Location l = new Location();
					
					l.setL_no( rs.getInt("l_no"));
					l.setLs_code( rs.getInt("ls_code"));
					l.setL_no( rs.getInt("l_no"));
					l.setLs_code( rs.getInt("ls_code"));
					
					list.add(l);
					
					System.out.println("LOCATION 테이블 성공 여부 : " + list);
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				close(rs);
				close(ps);			

			}
			
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

	
	public HashMap<String, Object> spotDetail(Connection con, int l_no2) {
		// 맛집과 여행지 정보 저장 객체
		HashMap<String, Object> map = new HashMap<>();
		ArrayList<lo_key> lokey = new ArrayList<>();
		ArrayList<Spot> spot = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("spotDetail");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, l_no2);
			
			rs = ps.executeQuery();
			
			
			ArrayList<lo_key> keyword = new ArrayList<>(); // keyword저장
			ArrayList<lo_key> spotlo = new ArrayList<>(); // 장소 정보 저장
			
			while(rs.next()) {

				
				// 1. location keyword 저장
				
				lo_key a = new lo_key();
				
				a.setL_no(rs.getInt("l_no"));
				a.setKeywords(rs.getString("keyword"));
				a.setA_name(rs.getString("a_name"));
				a.setLocal_name(rs.getString("local_name"));

				keyword.add(a);

				if(a.getKeywords() != rs.getString("keyword")) {
				
				// 2. 장소 정보 저장
				
				lo_key l = new lo_key();
				
				l.setL_no(rs.getInt("l_no"));
				l.setLs_code(rs.getInt("ls_code"));
				l.setLocal_name(rs.getString("local_name"));
				l.setCount_all(rs.getInt("count_all"));
				l.setKeywords(rs.getString("keyword"));
				
				// l.setA_no(rs.getInt("a_no"));
				l.setA_name(rs.getString("a_name"));
				l.setA_status(rs.getString("a_status"));
				l.setR_no(rs.getInt("r_no"));
				l.setM_no(rs.getInt("m_no"));
				l.setN_no(rs.getInt("n_no"));
				l.setS_id(rs.getInt("s_id"));
				l.setFlevel(rs.getInt("flevel"));
				
//				l.setS_tel(rs.getString("s_tel"));
//				l.setS_address(rs.getString("s_address"));
//				l.setS_lat(rs.getString("s_lat"));
//				l.setS_lng(rs.getString("s_lng"));

			
				spotlo.add(l);
			}
		}
				map.put("keyword", keyword);
				map.put("spotlo", spotlo);
				
				System.out.println(keyword);
				System.out.println(spotlo);
							
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(rs);
		close(ps);
	}
	
	return map;
}


//------------------------------------- 3. select Name (Heritage) ----------------------------------------//
// 이 부분의 코드는 Heritage mvc 폴더에 있습니다. ^^ 

	
	
	
	
	
	
	

//------------------------------------- 메인페이지 썸네일  ----------------------------------------//
//public HashMap<String, Object> spotDetail(Connection con) {
//	// 맛집과 여행지 정보 저장 객체
//	HashMap<String, Object> map = new HashMap<>();
//	ArrayList<lo_key> lokey = new ArrayList<>();
//	ArrayList<Spot> spot = new ArrayList<>();
//	PreparedStatement ps = null;
//	ResultSet rs = null;
//	
//	String sql = prop.getProperty("hotSpot");
//	
//	try {
//		ps = con.prepareStatement(sql);
//		
//		rs = ps.executeQuery();
//		
//		
//		ArrayList<lo_key> keyword = new ArrayList<>(); // keyword저장
//		ArrayList<lo_key> spotlo = new ArrayList<>(); // 장소 정보 저장
//		
//
//		
//		while(rs.next()) {
//			// 1. location keyword 저장
//			
//			lo_key a = new lo_key();
//			
//			a.setL_no(rs.getInt("l_no"));
//			a.setKeyword(rs.getString("keyword"));
//			a.setA_name(rs.getString("a_name"));
//			a.setLocal_name(rs.getString("local_name"));
//
//			keyword.add(a);
//			
//			if(a.getKeyword() != rs.getString("keyword")) {
//				
//			// 2. 장소 정보 저장
//
//			
//			lo_key l = new lo_key();
//			
//			l.setL_no(rs.getInt("l_no"));
//			l.setLs_code(rs.getInt("ls_code"));
//			l.setLocal_name(rs.getString("local_name"));
//			l.setCount_all(rs.getInt("count_all"));
//			// l.setKeyword(rs.getString("keyword"));
//			
//			l.setA_no(rs.getInt("a_no"));
//			l.setA_name(rs.getString("a_name"));
//			l.setA_status(rs.getString("a_status"));
//			l.setR_no(rs.getInt("r_no"));
//			l.setM_no(rs.getInt("m_no"));
//			l.setN_no(rs.getInt("n_no"));
//			l.setS_id(rs.getInt("s_id"));
//			l.setFlevel(rs.getInt("flevel"));
//
//		
//			spotlo.add(l);
//			
//
//		}
//	}
//			map.put("keyword", keyword);
//			map.put("spotlo", spotlo);
//			
//			System.out.println(keyword);
//			System.out.println(spotlo);
//						
//	
//} catch (SQLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//} finally {
//	close(rs);
//	close(ps);
//}
//
//return map;
//}

// ------------------------------------- 메인 썸네일 ver 2.0  05-06 오후 08시 19분 수정------------------------------------- //
public ArrayList<lo_key> hotSpot3(Connection con) {
	ArrayList<lo_key> list = new ArrayList<>();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sql = prop.getProperty("hotSpot");
	
	try {
		ps = con.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		lo_key lk = new lo_key();
		
		while(rs.next()) {
			
			if (lk.getL_no() != rs.getInt("l_no")) { // 첫번째라면
				
				lk = new lo_key();
				
				lk.setL_no(rs.getInt("l_no"));
				lk.setA_name(rs.getString("a_name"));
				lk.setLocal_name(rs.getString("local_name"));
				lk.setFlevel(rs.getInt("flevel"));

				lk.setKeyword(new ArrayList<>());
				
				list.add(lk);
				System.out.println(lk);
			}
			
			lk.getKeyword().add(rs.getString("keyword"));
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(rs);
		close(ps);
	}
	
	return list;
}

// ------------------------------------------------------------------------ //
//public ArrayList<lo_key> spotDetail2(Connection con, int l_no2) {
//	
//		// 맛집과 여행지 정보 저장 객체
//		HashMap<String, Object> map = new HashMap<>();
//		ArrayList<lo_key> lokey = new ArrayList<>();
//		ArrayList<Spot> spot = new ArrayList<>();
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//		String sql = prop.getProperty("spotDetail");
//		
//		try {
//			ps = con.prepareStatement(sql);
//			
//			ps.setInt(1, l_no2);
//			
//			rs = ps.executeQuery();
//			
//			
//			ArrayList<lo_key> keyword = new ArrayList<>(); // keyword저장
//			ArrayList<lo_key> spotlo = new ArrayList<>(); // 장소 정보 저장
//			
//			while(rs.next()) {
//
//				
//				// 1. location keyword 저장
//				
//				lo_key a = new lo_key();
//				
//				a.setL_no(rs.getInt("l_no"));
//				a.setKeyword(rs.getString("keyword"));
//				a.setA_name(rs.getString("a_name"));
//				a.setLocal_name(rs.getString("local_name"));
//
//				keyword.add(a);
//
//				if(a.getKeyword() != rs.getString("keyword")) {
//				
//				// 2. 장소 정보 저장
//				
//				lo_key l = new lo_key();
//				
//				l.setL_no(rs.getInt("l_no"));
//				l.setLs_code(rs.getInt("ls_code"));
//				l.setLocal_name(rs.getString("local_name"));
//				l.setCount_all(rs.getInt("count_all"));
//				l.setKeyword(rs.getString("keyword"));
//				
//				l.setA_no(rs.getInt("a_no"));
//				l.setA_name(rs.getString("a_name"));
//				l.setA_status(rs.getString("a_status"));
//				l.setR_no(rs.getInt("r_no"));
//				l.setM_no(rs.getInt("m_no"));
//				l.setN_no(rs.getInt("n_no"));
//				l.setS_id(rs.getInt("s_id"));
//				l.setFlevel(rs.getInt("flevel"));
//				
//				l.setS_tel(rs.getString("s_tel"));
//				l.setS_address(rs.getString("s_address"));
//				l.setS_lat(rs.getString("s_lat"));
//				l.setS_lng(rs.getString("s_lng"));
//
//			
//				spotlo.add(l);
//			}
//		}
//				map.put("keyword", keyword);
//				map.put("spotlo", spotlo);
//				
//				System.out.println(keyword);
//				System.out.println(spotlo);
//							
//		
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} finally {
//		close(rs);
//		close(ps);
//	}
//	
//	return map;
//}
//
}