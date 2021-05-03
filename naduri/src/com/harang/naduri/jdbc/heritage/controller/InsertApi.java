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
@WebServlet("/insertApi.do")
public class InsertApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertApi() {
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
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
