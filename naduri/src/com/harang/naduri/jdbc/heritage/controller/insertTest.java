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
	// insert를 위한 변수 선언
		String spotName = "";
		String ccbaKdcd = ""; // 종목코드
		String ccbaAsno = ""; // 지정번호
		String ccbaCtcd = ""; // 시도코드
		
		// 서비스 출발 
		HeritageService serviceHeri = new HeritageService();
	
	// 1. 문화재 정보 DB에서 불러와서 객체화 시키는 작업
	
	Heritage heri = new Heritage();
	
	// 문화재 이름들을 담을 어레이 리스트 준비 
	ArrayList<Heritage> heriList = new ArrayList<>();
	
	
	
	heriList = serviceHeri.selectHeriList();
	

	// 1-3단계 게시글 조회 서비스 시작 --> 서비스 Go!
	list = service.selectLocationCode(spotName);
	
	for ( Heritage h : heriList ) {
		
		spotName = h.getH_name();
		ccbaKdcd = h.getH_events(); // 종목코드
		ccbaAsno = h.getH_serial(); // 지정번호
		ccbaCtcd = h.getH_zipcode(); // 시도코드
		
		
	
	


	// 1-3단계 게시글 조회 서비스 시작 --> 서비스 Go!
	listHeri = serviceHeri.selectName(spotName);
	


// 2단계 결과 값을 가지고 이번에는 문화재청 상세검색

// 2-1단계 쿼리스트링으로 보낼 변수에 list에서 뽑아온 결과 값 넣기 (임시 변수 사용해야 함)


// Debug
System.out.println("결과 조회 : " + ccbaKdcd + ccbaAsno + ccbaCtcd);
System.out.println(spotName);

// API 호출
			try{
				
				while(true){
					// parsing할 url 지정(API 키 포함해서)
					// String callList = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do?pageIndex="+pageIndex;
					 String callDetail = "http://www.cha.go.kr/cha/SearchKindOpenapiDt.do?ccbaKdcd=" + ccbaKdcd + "&ccbaAsno=" + ccbaAsno + "&ccbaCtcd=" + ccbaCtcd + "&ccbaMnm1=" + spotName;
					 // + "&ccbaMnm1=" + spotName
					// String callImage = "http://www.cha.go.kr/cha/SearchImageOpenapi.do?ccbaKdcd=" + ccbaKdcd + "&ccbaAsno=" + ccbaAsno + "&ccbaCtcd=" + ccbaCtcd + "&ccbaMnm1=" + spotName ;
					
					 //Debug
					 System.out.println( "요청 URL : " + callDetail);
					
					DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
					Document doc = dBuilder.parse(callDetail);
					
					//Debug
					System.out.println("call Api 결과 : " + doc);
					
					// root tag 
					doc.getDocumentElement().normalize();
					
					//Debug
					System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					System.out.println("Tag element :" + doc.getDocumentElement().getTagName());
					
					// 파싱할 tag
					NodeList nList = doc.getElementsByTagName("result");
					
					//Debug
					System.out.println("파싱할 리스트 수 : "+ nList.getLength());
				
					
					
					for(int temp = 0; temp < nList.getLength(); temp++){
						Node nNode = nList.item(temp);
						
						
						//Debug
						System.out.println(nNode);
						
						if(nNode.getNodeType() == Node.ELEMENT_NODE){
							
							Element eElement = (Element) nNode;
							
							// heritage vo를 저장할 객체 
							// ArrayList<Heritage> list3 = new ArrayList<>();
							 Heritage heri = new Heritage();

							// api로 받은 정보 저장
							 	
								heri.setH_events(getTagValue("ccbaKdcd", eElement)); // 종목코드
								heri.setH_serial(getTagValue("ccbaAsno", eElement)); // 지정번호
								heri.setH_zipcode(getTagValue("ccbaCtcd", eElement)); // 시도코드
								heri.setH_name(getTagValue("ccbaMnm1", eElement)); // 문화재명
								
								
								
								// 임시 변수 부분
								heri.setCcmaName(getTagValue("ccmaName", eElement)); // 문화재종목
								heri.setGcodeName(getTagValue("gcodeName", eElement)); // 문화재분류
								heri.setCcbaAsdt(getTagValue("ccbaAsdt", eElement)); // 지정(등록일)
								heri.setCcbaLcad(getTagValue("ccbaLcad", eElement)); // 소재지 상세
								heri.setCcceName(getTagValue("ccceName", eElement)); // 시대
								heri.setCcbaPoss(getTagValue("ccbaPoss", eElement)); // 소유자
								heri.setCcbaAdmin(getTagValue("ccbaAdmin", eElement)); // 관리자
								heri.setContent(getTagValue("content", eElement)); // 내용
								
								heri.setLongitude(getTagValue("longitude", eElement)); // 경도
								heri.setLatitude(getTagValue("latitude", eElement)); // 위도
								heri.setImageUrl(getTagValue("imageUrl", eElement)); // 메인노출이미지URL



						// 객체 바구니에 저장
								listHeri.add(heri);
						
						 System.out.println(listHeri);

							
						}	// for end
						
					}	// if end
					
					
					pageIndex += 1;
					if(pageIndex > 12){	
					}
						break;
					}

				}	// while end
				
			
			catch (Exception e){	
				e.printStackTrace();
			
			}	// try~catch end
			
			request.setAttribute("listHeri", listHeri);
			
			RequestDispatcher view =
					request.getRequestDispatcher("test.jsp");
			
			view.forward(request, response);
}
		}	// main end
	
	
}
	