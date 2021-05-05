package com.harang.naduri.jdbc.heritage.model.service;

import static com.harang.naduri.jdbc.common.JDBCTemplate.close;
import static com.harang.naduri.jdbc.common.JDBCTemplate.commit;
import static com.harang.naduri.jdbc.common.JDBCTemplate.getConnection;
import static com.harang.naduri.jdbc.common.JDBCTemplate.rollback;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.harang.naduri.jdbc.Thumbnail.model.vo.Thumbnail;
import com.harang.naduri.jdbc.heritage.model.dao.HeritageDAO;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.location.model.vo.Location;
import com.harang.naduri.jdbc.Thumbnail.model.dao.ThumbnailDAO;


public class HeritageService {

	private Connection con;
	private HeritageDAO dao = new HeritageDAO();
	
	
	// 목록 조회 시 필요한 종목코드 추출
	public ArrayList<Heritage> selectName(String spotName) {
		
		con = getConnection();
		
		ArrayList<Heritage> list = dao.selectName(con, spotName);
		
		close(con);
		
		return list;
	}

	
	
	
	
	// 목록 조회
	public ArrayList<Heritage> selectList(String spotName) {
		con = getConnection();
		
		ArrayList<Heritage> list = dao.selectList(con);
		
		close(con);
		
		return list;
	}
	
	
	
	
	// 공공데이터 DB 저장
	public int insertHeritage(Heritage heri) {
		con = getConnection();
	
		
		// 1. LOCATION 테이블 데이터 생성
		int result1 = dao.insertLocation(con, heri);
		
		// 처리된 행 개수가 아니라 특정 결과 값이 나오게 하려면?

		
		// Debug
		System.out.println("location id 생성 성공 여부 : " + result1);
		
		
		// Location VO 생성
		// Location location = new Location();
		
		
		if( result1 > 0 ) {
			commit(con);
			
			
			// 2. Locaiton ID 값 가져오기
			int l_no = dao.selectLno(con);
			
			// Debug
			System.out.println("location id 조회 성공 여부 : " + l_no);

			// l_no를 가져온 값이 있다면 commit
			if ( l_no < 0) {
				rollback(con);
			} else {
				commit(con);
				int result2 = 0;
				
				// Debug
				System.out.println("location id 결과값 확인 : " + l_no);
				
				// 3. 위에서 찾은 l_no와 Heritage 객체를 함께 insert Heritage
				result2 = dao.insertHeritage(con, l_no, heri);
				
			
				// result2의 결과값이 0이라면 rollback
				if( result2 > 0) commit(con);
				else rollback(con);
				} // 안쪽 if문 end
				commit(con);
			
		} // else end

		close(con);
		
		return result1;

	}

	
	// 관리자페이지 문화재 리스트 부분
	public ArrayList<Heritage> heritageList(int currentPage) {
	   con = getConnection();
	   
	   ArrayList<Heritage> list = dao.heritageList(con, currentPage);
	   
	   close(con);
	   
	   return list;
	}

	// tag값의 정보를 가져오는 메소드
	public String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	   }
	
	//상세검색 위한 코드 불러오는 코드
	public ArrayList<Heritage> getHerCode() {
	   con = getConnection();
	   
	   ArrayList<Heritage> list = dao.getHerCode(con);
	   
	   
	   System.out.println("list : " + list);
	   
		String ccbaKdcd = ""; // 종목코드
		String ccbaAsno = ""; // 지정번호
		String ccbaCtcd = ""; // 시도코드
		String ccbaMnm1 = "";
		
		for(Heritage h : list) {
			
			ccbaKdcd = h.getH_events(); // 종목코드
			ccbaAsno = h.getH_serial(); // 지정번호
			ccbaCtcd = h.getH_zipcode(); // 시도코드
			ccbaMnm1 = h.getH_name(); // 문화재

			// System.out.println("종목코드 : "+ h.getL_no() + ", "+ ccbaKdcd);
			
			try {
			
			String callDetail = "http://www.cha.go.kr/cha/SearchKindOpenapiDt.do"+"?ccbaKdcd=" + ccbaKdcd + "&ccbaAsno=" + ccbaAsno + "&ccbaCtcd=" + ccbaCtcd + "&ccbaMnm1=" + ccbaMnm1;
			
			System.out.println(callDetail);
			
			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			Document doc = dBuilder.parse(callDetail);
			
			
			System.out.println("api result : " + doc);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			System.out.println("Tag element :" + doc.getDocumentElement().getTagName());
			
			// 파싱할 tag
			NodeList nList = doc.getElementsByTagName("result");
			
			//Debug
			System.out.println("파싱할 리스트 수 : "+ nList.getLength());
		
			
			
			
			} catch (ParserConfigurationException | SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
			
		}
		
		
	  
	   
	   
	   close(con);
	   
	   return list;
	}

	// 페이지네이션을 위한 서비스 생성
		public int getListCount() {
			con = getConnection();
			
			int result = dao.getListCount(con);
			
			close(con);
			
			return result;
		}


		// delete Adimin Heritage
		public int deleteHeritage(int h_id) {
			
			con = getConnection();
			
			
			int result = dao.deletHeritage(con, h_id);
			
			
			if ( result > 0) {
				commit(con);
				
			} else {
				rollback(con);
			}
			
			close(con);
			
			return result;
		}





}