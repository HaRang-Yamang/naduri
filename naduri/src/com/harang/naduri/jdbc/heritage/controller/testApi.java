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

import com.harang.naduri.jdbc.heritage.model.service.HeritageService;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;



/**
 * Servlet implementation class InsertHeritage
 */
@WebServlet("/testApi.do")
public class testApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testApi() {
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
			

			
			for ( Heritage h : heriList ) {
				
				spotName = h.getH_name();
				ccbaKdcd = h.getH_events(); // 종목코드
				ccbaAsno = h.getH_serial(); // 지정번호
				ccbaCtcd = h.getH_zipcode(); // 시도코드
				
				
			
			


			// 1-3단계 게시글 조회 서비스 시작 --> 서비스 Go!
			//listHeri = serviceHeri.selectName(spotName);
			


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
									 Heritage herihang = new Heritage();

									// api로 받은 정보 저장
									 	
										herihang.setH_events(getTagValue("ccbaKdcd", eElement)); // 종목코드
										herihang.setH_serial(getTagValue("ccbaAsno", eElement)); // 지정번호
										herihang.setH_zipcode(getTagValue("ccbaCtcd", eElement)); // 시도코드
										herihang.setH_name(getTagValue("ccbaMnm1", eElement)); // 문화재명
									
										// 시 변수 부분
										herihang.setCcmaName(getTagValue("ccmaName", eElement)); // 문화재종목
										herihang.setGcodeName(getTagValue("gcodeName", eElement)); // 문화재분류
										herihang.setCcbaAsdt(getTagValue("ccbaAsdt", eElement)); // 지정(등록일)
										herihang.setCcbaLcad(getTagValue("ccbaLcad", eElement)); // 소재지 상세
										herihang.setCcceName(getTagValue("ccceName", eElement)); // 시대
										herihang.setCcbaPoss(getTagValue("ccbaPoss", eElement)); // 소유자
										herihang.setCcbaAdmin(getTagValue("ccbaAdmin", eElement)); // 관리자
										herihang.setContent(getTagValue("content", eElement)); // 내용
									
										herihang.setLongitude(getTagValue("longitude", eElement)); // 경도
										herihang.setLatitude(getTagValue("latitude", eElement)); // 위도
										herihang.setImageUrl(getTagValue("imageUrl", eElement)); // 메인노출이미지URL

										// 서비스 시작!
										HeritageService service = new HeritageService();
										
										
										int result = service.insertHeritageLong(herihang);
										

								// 객체 바구니에 저장
										heriList.add(herihang);
								
								 System.out.println(heriList);

									
								}	// for end
								
							}	// if end
							
						}

						}	// while end
						
					
					catch (Exception e){	
						e.printStackTrace();
					
					}	// try~catch end
					
					request.setAttribute("heriList", heriList);
					
					RequestDispatcher view =
							request.getRequestDispatcher("test.jsp");
					
					view.forward(request, response);
		}
				}	// main end
			



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
