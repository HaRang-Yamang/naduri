package com.harang.naduri.jdbc.heritage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.harang.naduri.jdbc.Thumbnail.model.service.ThumbnailService;
import com.harang.naduri.jdbc.Thumbnail.model.vo.Thumbnail;
import com.harang.naduri.jdbc.heritage.model.service.HeritageService;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.location.model.vo.Location;



/**
 * Servlet implementation class InsertHeritage
 */
@WebServlet("/CallApiDetailSelectOneCollection.do")
public class CallApiDetailSelectOneCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallApiDetailSelectOneCollection() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    
    
	// tag값의 정보를 가져오는 메소드
	public String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	   }

	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			// 파라미터 선언 및 초기화
			int pageIndex = 1;	// 페이지 초기값 
			
			// (2단계) 결과 값 받을 변수들 초기화
			String ccbaKdcd = ""; // 종목코드
			String ccbaAsno = ""; // 지정번호
			String ccbaCtcd = ""; // 시도코드
			
			// SelectOne을 위한 사용자 선택 값 
			// int l_no = Integer.parseInt(request.getParameter("l_no"));
			// 장소 정보 객체 list
			ArrayList<Location> list = new ArrayList();
						

			
			// 사용자 입력 값 가져오기
			// 1단계 - 사용자가 입력한 장소명을 서버 데이터베이스에서 조회 & 장소코드(LS_CODE)가 1(문화재)면 공공데이터 호출


			// 먼저 선택된 게시물의 l_no를 가지고 ls_code를 조회하는 로직 수행
			// 여기서 반환된 ls_code를 가지고 if문을 통해 1번 혹은 2번 로직 수행
			
			
			// 1-1단계 - 조회를 위한 입력값 추출
			// String spotName = request.getParameter("spotName");
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
			
			
			

			
			//--------------------------- 결과 값이 도착하면 --------------------------- //
			
			
			
			// ls_code 가 2 라면 해시맵으로 이미지 가져오기!
			// 장소테이블 조회하러 출발
			if ( ls_code == 2 ) {
				ArrayList<Thumbnail> spot = new ArrayList();

				// 장소들의 썸네일을 받아올 객체 필요
				HashMap<String, Object> map = new HashMap<>();
				
				// 결과를 list 객체에 저장
				map = service.selectThumnailOne(l_no2);
				
				// request에 list 객체 담아서 보냄
				if ( map != null) {
					request.setAttribute("list", map.get("list")); // 맛집/여행지 정보 ( spot )
					request.setAttribute("list2", map.get("list2")); // 사진 ( attach )
					request.setAttribute("listHeri", map.get("listHeri")); // 문화재 정보 ( Heritage )
					request.setAttribute("lo_key", map.get("lo_key")); // 장소and키워드 정보 (location and keyword)
					
					
					System.out.println(map.get("list"));
					System.out.println(map.get("list2"));
					System.out.println(map.get("listHeri"));
					System.out.println(map.get("lo_key"));
				
				
				request.getRequestDispatcher("index.jsp")
				       .forward(request, response);
				}
			}
				

			
				
			//----------------------------- 문화재인 경우 API 호출 -----------------------------------//
			// ls_code가 1(문화재)인 경우에만 아래 로직 수행
			else if ( ls_code == 1 ) {
			
				// 서버에서 문화재 정보 검색하러 출발
				
				// 객체 바구니
				HashMap<String, Object> apis = null;
				
				// heritage 객체들을 저장할 list
				// HashMap<String, Object> list = new HashMap<>();	
				
				
				// heritage 객체들을 저장할 list
				ArrayList<Heritage> listHeri = new ArrayList<>();	
				// service 결과를 담을 객체 생성 (h_name, h_events, h_serial...)
				Heritage heriName = new Heritage();

				
				// 1-2단계 게시글 서비스 객체 생성
				HeritageService serviceHeri = new HeritageService();

				// 1-3단계 게시글 조회 서비스 시작 --> 서비스 Go!
				listHeri = serviceHeri.selectName(spotName);
				
				
			for(Heritage h : listHeri) {
				
				ccbaKdcd = h.getH_events(); // 종목코드
				ccbaAsno = h.getH_serial(); // 지정번호
				ccbaCtcd = h.getH_zipcode(); // 시도코드
			}
			
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}