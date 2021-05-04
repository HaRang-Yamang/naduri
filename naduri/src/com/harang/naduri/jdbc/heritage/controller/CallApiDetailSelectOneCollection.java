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
    
    
    
    
    
	// tag���� ������ �������� �޼ҵ�
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
		
			// �Ķ���� ���� �� �ʱ�ȭ
			int pageIndex = 1;	// ������ �ʱⰪ 
			
			// (2�ܰ�) ��� �� ���� ������ �ʱ�ȭ
			String ccbaKdcd = ""; // �����ڵ�
			String ccbaAsno = ""; // ������ȣ
			String ccbaCtcd = ""; // �õ��ڵ�
			
			// SelectOne�� ���� ����� ���� �� 
			// int l_no = Integer.parseInt(request.getParameter("l_no"));
			// ��� ���� ��ü list
			ArrayList<Location> list = new ArrayList();
						

			
			// ����� �Է� �� ��������
			// 1�ܰ� - ����ڰ� �Է��� ��Ҹ��� ���� �����ͺ��̽����� ��ȸ & ����ڵ�(LS_CODE)�� 1(��ȭ��)�� ���������� ȣ��


			// ���� ���õ� �Խù��� l_no�� ������ ls_code�� ��ȸ�ϴ� ���� ����
			// ���⼭ ��ȯ�� ls_code�� ������ if���� ���� 1�� Ȥ�� 2�� ���� ����
			
			
			// 1-1�ܰ� - ��ȸ�� ���� �Է°� ����
			// String spotName = request.getParameter("spotName");
			String spotName = "��Ҹ�_1";
			
			// 1-2�ܰ� �Խñ� ���� ��ü ����
			ThumbnailService service = new ThumbnailService();

			// 1-3�ܰ� �Խñ� ��ȸ ���� ���� --> ���� Go!
			list = service.selectLocationCode(spotName);
			
			
			//Debug
			System.out.println("��� Ȯ�� : " + list);
			
			// ��� �� ls_code�� ���
			int l_no2 = 0;
			int ls_code = 0;
			
			
			for (Location l : list ) {
				l_no2 = l.getL_no();
				ls_code = l.getLs_code();
			}
			
			

			
			//--------------------------- ��� ���� �����ϸ� --------------------------- //
			
			
			
			// ls_code �� 2 ��� �ؽø����� �̹��� ��������!
			// ������̺� ��ȸ�Ϸ� ���
			if ( ls_code == 2 ) {
				ArrayList<Thumbnail> spot = new ArrayList();

				// ��ҵ��� ������� �޾ƿ� ��ü �ʿ�
				HashMap<String, Object> map = new HashMap<>();
				
				// ����� list ��ü�� ����
				map = service.selectThumnailOne(l_no2);
				
				// request�� list ��ü ��Ƽ� ����
				if ( map != null) {
					request.setAttribute("list", map.get("list")); // ����/������ ���� ( spot )
					request.setAttribute("list2", map.get("list2")); // ���� ( attach )
					request.setAttribute("listHeri", map.get("listHeri")); // ��ȭ�� ���� ( Heritage )
					request.setAttribute("lo_key", map.get("lo_key")); // ���andŰ���� ���� (location and keyword)
					
					
					System.out.println(map.get("list"));
					System.out.println(map.get("list2"));
					System.out.println(map.get("listHeri"));
					System.out.println(map.get("lo_key"));
				
				
				request.getRequestDispatcher("index.jsp")
				       .forward(request, response);
				}
			}
				

			
				
			//----------------------------- ��ȭ���� ��� API ȣ�� -----------------------------------//
			// ls_code�� 1(��ȭ��)�� ��쿡�� �Ʒ� ���� ����
			else if ( ls_code == 1 ) {
			
				// �������� ��ȭ�� ���� �˻��Ϸ� ���
				
				// ��ü �ٱ���
				HashMap<String, Object> apis = null;
				
				// heritage ��ü���� ������ list
				// HashMap<String, Object> list = new HashMap<>();	
				
				
				// heritage ��ü���� ������ list
				ArrayList<Heritage> listHeri = new ArrayList<>();	
				// service ����� ���� ��ü ���� (h_name, h_events, h_serial...)
				Heritage heriName = new Heritage();

				
				// 1-2�ܰ� �Խñ� ���� ��ü ����
				HeritageService serviceHeri = new HeritageService();

				// 1-3�ܰ� �Խñ� ��ȸ ���� ���� --> ���� Go!
				listHeri = serviceHeri.selectName(spotName);
				
				
			for(Heritage h : listHeri) {
				
				ccbaKdcd = h.getH_events(); // �����ڵ�
				ccbaAsno = h.getH_serial(); // ������ȣ
				ccbaCtcd = h.getH_zipcode(); // �õ��ڵ�
			}
			
			// 2�ܰ� ��� ���� ������ �̹����� ��ȭ��û �󼼰˻�
			
			// 2-1�ܰ� ������Ʈ������ ���� ������ list���� �̾ƿ� ��� �� �ֱ� (�ӽ� ���� ����ؾ� ��)


			// Debug
			System.out.println("��� ��ȸ : " + ccbaKdcd + ccbaAsno + ccbaCtcd);
			System.out.println(spotName);

			// API ȣ��
						try{
							
							while(true){
								// parsing�� url ����(API Ű �����ؼ�)
								// String callList = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do?pageIndex="+pageIndex;
								 String callDetail = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do?ccbaKdcd=" + ccbaKdcd + "&ccbaAsno=" + ccbaAsno + "&ccbaCtcd=" + ccbaCtcd + "&ccbaMnm1=" + spotName;
								 // + "&ccbaMnm1=" + spotName
								// String callImage = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do?ccbaKdcd=" + ccbaKdcd + "&ccbaAsno=" + ccbaAsno + "&ccbaCtcd=" + ccbaCtcd ;
								
								 //Debug
								 System.out.println( "��û URL : " + callDetail);
								
								DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
								DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
								Document doc = dBuilder.parse(callDetail);
								
								//Debug
								System.out.println("call Api ��� : " + doc);
								
								// root tag 
								doc.getDocumentElement().normalize();
								
								//Debug
								System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
								System.out.println("Tag element :" + doc.getDocumentElement().getTagName());
								
								// �Ľ��� tag
								NodeList nList = doc.getElementsByTagName("item");
								
								//Debug
								System.out.println("�Ľ��� ����Ʈ �� : "+ nList.getLength());
							
								
								
								for(int temp = 0; temp < nList.getLength(); temp++){
									Node nNode = nList.item(temp);
									
									
									//Debug
									System.out.println(nNode);
									
									if(nNode.getNodeType() == Node.ELEMENT_NODE){
										
										Element eElement = (Element) nNode;
										
										// heritage vo�� ������ ��ü 
										// ArrayList<Heritage> list3 = new ArrayList<>();
										 Heritage heri = new Heritage();

										// api�� ���� ���� ����
											heri.setH_events(getTagValue("ccbaKdcd", eElement)); // �����ڵ�
											heri.setH_serial(getTagValue("ccbaAsno", eElement)); // ������ȣ
											heri.setH_zipcode(getTagValue("ccbaCtcd", eElement)); // �õ��ڵ�
											heri.setH_name(getTagValue("ccbaMnm1", eElement)); // ��ȭ���
											// heri.setImageUrl(getTagValue("imageUrl", eElement)); // �̹���



									// ��ü �ٱ��Ͽ� ����
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
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}