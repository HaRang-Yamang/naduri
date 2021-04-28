package controller;

import java.io.IOException;
import java.util.ArrayList;

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

import vo.Heritage;


/**
 * Servlet implementation class InsertHeritage
 */
@WebServlet("/index.do")
public class InsertHeritage2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertHeritage2() {
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
		
		


		
			int page = 1;	// 페이지 초기값 
			
			// heritage 객체들을 저장할 list
			ArrayList<Heritage> list = new ArrayList<>();
			// 서비스에서 vo를 받아오자
//			HeriService service = new HeriService();
			
			// 서버에 있는 문화재 DB를 list에 담기
			// list = service.selectList();
			
			// heritage vo를 저장할 객체 
			 Heritage heri = new Heritage();
			

			
			try{
				
				while(true){
					// parsing할 url 지정(API 키 포함해서)
					String url = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do?pageIndex="+page;
					
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

							// api로 받은 정보 저장
							String title = getTagValue("ccbaMnm1", eElement);
							String events = getTagValue("ccmaName", eElement);

							
							heri.setH_TITLE(title);
							heri.setH_EVENTS(events);
							
							list.add(heri);
							
							System.out.println(list);

							
						}	// for end
						
					}	// if end
					
					
					page += 1;
					if(page > 10){	
					}
						break;
					}

				}	// while end
				
			
			catch (Exception e){	
				e.printStackTrace();
			
			}	// try~catch end
			
			request.setAttribute("list", list);
			
			RequestDispatcher view =
					request.getRequestDispatcher("index.jsp");
			
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
