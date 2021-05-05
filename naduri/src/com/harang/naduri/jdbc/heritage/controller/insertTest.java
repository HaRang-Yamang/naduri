package com.harang.naduri.jdbc.heritage.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.harang.naduri.jdbc.Thumbnail.model.service.ThumbnailService;
import com.harang.naduri.jdbc.heritage.model.service.HeritageService;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.location.model.vo.Location;

public class insertTest {
	
	String spotName = "숭례문";
	
	// 1-2단계 게시글 서비스 객체 생성
	ThumbnailService service = new ThumbnailService();

	// 1-3단계 게시글 조회 서비스 시작 --> 서비스 Go!
	list = service.selectLocationCode(spotName);
	
	
	//Debug
	System.out.println("결과 확인 : " + list);
	
	// 결과 값 ls_code에 담기
	int l_no2 = 0;
	int ls_code = 0;
	
	
	for (Location l : list ) {
		l_no2 = l.getL_no();
		ls_code = l.getLs_code();
		
		// -------------------------------------- //
		
		int pageIndex = 1;	// 페이지 초기값 
		
		// 객체 바구니
		 HashMap<String, Object> apis = null;
		
		// heritage 객체들을 저장할 list
		ArrayList<Heritage> list = new ArrayList<>();	
		
		// insert를 위해서 추가되는 부분 // 
		// 서비스 객체 호출
		
		 
		try{
			
			while(true){
				// parsing할 url 지정(API 키 포함해서)
				String url = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do?pageIndex="+pageIndex;
				
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				// root tag 
				doc.getDocumentElement().normalize();
				// System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("item");
				System.out.println("파싱할 리스트 수 : "+ nList.getLength());
			
				
				
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						
						Element eElement = (Element) nNode;
						
						// heritage vo를 저장할 객체 
						 Heritage heri = new Heritage();

						// api로 받은 정보 저장
							heri.setH_events(getTagValue("ccbaKdcd", eElement)); // 종목코드
							heri.setH_serial(getTagValue("ccbaAsno", eElement)); // 지정번호
							heri.setH_zipcode(getTagValue("ccbaCtcd", eElement)); // 시도코드
							heri.setH_name(getTagValue("ccbaMnm1", eElement)); // 문화재명
							
							list.add(heri);
							
							// 서비스 시작!
							HeritageService service = new HeritageService();
							
							
							int result = service.insertHeritage(heri);

					// 객체 바구니에 저장
					// list.add(heri);
					
					 // System.out.println(list);

						
					}	// for end
					
				}	// if end
				pageIndex += 1;
				
				if(pageIndex > 70){	
					break;	
				}
				}

			}	// while end
			
		
		catch (Exception e){	
			e.printStackTrace();
		
		}	// try~catch end
		
		request.setAttribute("list", list);
		
		RequestDispatcher view =
				request.getRequestDispatcher("test.jsp");
		
		view.forward(request, response);
		
	}	// main end
	

}
