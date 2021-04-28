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
		
		
		//XML �����͸� ȣ���� URL
		String url = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do?ccbaMnm1=�溹��";
		
		//URL�� �Ķ���ͷ� 'size' �׸��� �����ϴ��� üũ
		String size = request.getParameter("size");
		
		//size �Ķ���Ͱ� null�� �ƴϰ�, 0�� �ƴҰ�쿡�� URL�� �߰�, size�׸��� ������ �Խù��� ������ �ǹ���.
		if(size != null && !"0".equals(size)){
			url += "?size=" + size;
		}
		
		//�����������ϵ� XML�������� ������Ʈ �̸� �迭 
		String[] fieldNames ={"ccbaMnm1", "ccmaName"};
		
		//�� �Խù��ϳ��� �ش��ϴ� XML ��带 ���� ����Ʈ
		ArrayList<Map> pubList = new ArrayList<Map>();
		
		try {
			//XML�Ľ� �غ�
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			DocumentBuilder b = f.newDocumentBuilder();
			//������ ������ URL�� ���� XMl �Ľ� ����
			Document doc = b.parse(url);
			doc.getDocumentElement().normalize();
			
			//�������� ������ XML�����͸� publication(���๮�� 1�� �ش�)�±׷� ���� ����(�Ķ���ͷ� ��û�� size�׸��� ����ŭ)
			NodeList items = doc.getElementsByTagName("publication");
			
			//for ��������
			for (int i = 0; i < items.getLength(); i++) {
				//i��° publication �±׸� �����ͼ�
				Node n = items.item(i);
				//���Ÿ���� üũ��, ��� Ÿ���� ������Ʈ�� �ƴҰ�쿡�� ����
				if (n.getNodeType() != Node.ELEMENT_NODE)
					continue;
				
				Element e = (Element) n;
				HashMap pub = new HashMap();
				//for ���� ����
				for(String name : fieldNames){
					//"id", "title", "userName", "recommendId", "recommendName", "recommendDate", "url"�� �ش��ϴ� ���� XML ��忡�� ������
					NodeList titleList = e.getElementsByTagName(name);
					Element titleElem = (Element) titleList.item(0);
		
					Node titleNode = titleElem.getChildNodes().item(0);
					// ������ XML ���� �ʿ� ������Ʈ �̸� - �� ������ ����
					pub.put(name, titleNode.getNodeValue());
				}
				//�����Ͱ� ���� �� ���� ����Ʈ�� �ְ� ȭ�鿡 �Ѹ� �غ�.
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
