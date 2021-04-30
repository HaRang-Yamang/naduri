package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
@WebServlet("/hi")
public class InsertHeritage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertHeritage() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//XML 데이터를 호출할 URL
		String url = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do?ccbaMnm1=경복궁";
		
		//URL에 파라미터로 'size' 항목이 존재하는지 체크
		String size = request.getParameter("size");
		
		//size 파라미터가 null이 아니고, 0이 아닐경우에만 URL에 추가, size항목은 가져올 게시물의 갯수를 의미함.
		if(size != null && !"0".equals(size)){
			url += "?size=" + size;
		}
		
		//서버에서리턴될 XML데이터의 엘리먼트 이름 배열 
		String[] fieldNames ={"ccbaMnm1", "ccmaName"};
		
		//각 게시물하나에 해당하는 XML 노드를 담을 리스트
		ArrayList<Map> pubList = new ArrayList<Map>();
		
		try {
			//XML파싱 준비
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			DocumentBuilder b = f.newDocumentBuilder();
			//위에서 구성한 URL을 통해 XMl 파싱 시작
			Document doc = b.parse(url);
			doc.getDocumentElement().normalize();
			
			//서버에서 응답한 XML데이터를 publication(발행문서 1개 해당)태그로 각각 나눔(파라미터로 요청한 size항목의 수만큼)
			NodeList items = doc.getElementsByTagName("publication");
			
			//for 루프시작
			for (int i = 0; i < items.getLength(); i++) {
				//i번째 publication 태그를 가져와서
				Node n = items.item(i);
				//노드타입을 체크함, 노드 타입이 엘리먼트가 아닐경우에만 수행
				if (n.getNodeType() != Node.ELEMENT_NODE)
					continue;
				
				Element e = (Element) n;
				HashMap pub = new HashMap();
				//for 루프 시작
				for(String name : fieldNames){
					//"id", "title", "userName", "recommendId", "recommendName", "recommendDate", "url"에 해당하는 값을 XML 노드에서 가져옴
					NodeList titleList = e.getElementsByTagName(name);
					Element titleElem = (Element) titleList.item(0);
		
					Node titleNode = titleElem.getChildNodes().item(0);
					// 가져온 XML 값을 맵에 엘리먼트 이름 - 값 쌍으로 넣음
					pub.put(name, titleNode.getNodeValue());
				}
				//데이터가 전부 들어간 맵을 리스트에 넣고 화면에 뿌릴 준비.
				pubList.add(pub);
				
				request.setAttribute("pubList", pubList);
				
				RequestDispatcher view =
						request.getRequestDispatcher("index.jsp");
				
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
