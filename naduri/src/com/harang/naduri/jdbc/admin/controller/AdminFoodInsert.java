package com.harang.naduri.jdbc.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.harang.naduri.jdbc.Thumbnail.model.service.ThumbnailService;
import com.harang.naduri.jdbc.admin.model.service.AdminService;
import com.harang.naduri.jdbc.attach.model.vo.Attach;
import com.harang.naduri.jdbc.common.MyRenamePolicy;
import com.harang.naduri.jdbc.notice.model.vo.Notice;
import com.harang.naduri.jdbc.review.model.service.ReviewService;
import com.harang.naduri.jdbc.spot.model.service.SpotService;
import com.harang.naduri.jdbc.spot.model.vo.Spot;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class AdminFoodList
 */
@WebServlet("/AdminFoodInsert.do")
public class AdminFoodInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFoodInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
				// 멀티파트 준비 부분입니다.
		
				// 1. 경로
				String savePath = request.getServletContext().getRealPath("/assets/images/review");
				
				// 2. 저장용량
				int maxSize = 1024*1024*10;
				
				// 3. 멀티파트 여부 확인
				if(! ServletFileUpload.isMultipartContent(request)) {
					request.setAttribute("error-msg", "멀티파트 전송이 아닙니다.");
					request.getRequestDispatcher("views/common/errorPage.jsp")
					.forward(request, response);
				}
				
				// 4. 멀티파트 객체 준비
				MultipartRequest mr = new MultipartRequest(request,savePath,maxSize, "UTF-8",
						new MyRenamePolicy());
				
				
				// 이제 진짜로 정보 받아올 준비를 합니다.
				ArrayList<String> changeNames = new ArrayList<>();
				
				// 사용자가 입력한 정보
				String s_name = mr.getParameter("s_name"); // 장소명
				String s_tel = mr.getParameter("s_tel"); // 전화번호
				String s_date = mr.getParameter("s_date"); // 운영시간
				String s_address = mr.getParameter("s_address"); // 위치
				String s_lat = mr.getParameter("s_lat"); // 위도
				String s_lng = mr.getParameter("s_lng"); // 경도
				String a_name = mr.getParameter("a_name"); // 첨부파일명
				
				Spot s = new Spot (s_name, s_tel, s_date, s_address, s_lat, s_lng, a_name);
				
				
				//첨부파일 목록
				Enumeration<String>tagNames= mr.getFileNames();
				while( tagNames.hasMoreElements()) {
					
					String tagName = tagNames.nextElement();
					
					changeNames.add(mr.getFilesystemName(tagName));
					
					System.out.println(tagName + " : " + changeNames);
				}
			
				int s_id = 0;
				
				//첨부파일 목록 생성
				ArrayList<Attach>list = new ArrayList<>();
				
					
				for(int i = changeNames.size()-1; i>=0; i--) {
					
					Attach a = new Attach();
					a.setA_name(changeNames.get(i));
					a.setS_id(s_id);
					if(i==changeNames.size()-1) {
						a.setFlevel('1');
					}else {
						a.setFlevel('2');
					}

					list.add(a); // 첨부파일 객체에 저장
				}
				s.setAttList(list); // spot 객체에 다시 통합 저장(?)
				
				

				
				//객체 생성
				AdminService service = new AdminService();
				
				// 장소정보 저장하러 서비스 가기
				int result2 = service.AdminFoodInsert(s);
				


		response.sendRedirect("foodList.ad");


}
				

	
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}