package com.harang.naduri.jdbc.admin.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.harang.naduri.jdbc.heritage.model.service.HeritageService;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.notice.model.service.NoticeService;
import com.harang.naduri.jdbc.notice.model.vo.Notice;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class AdminHeritageUpdate
 */
@WebServlet("/updateHeritage.ad")
public class AdminHeritageUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHeritageUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		// m_no를 통해서 정보를 받아오고, getParameter는 문자열로 결과물을
		// 받아오니까 문자열을 숫자로 바꿔줌.
		
		int h_id = Integer.parseInt(request.getParameter("h_id"));
		String h_status = request.getParameter("h_status");
		
		// 서비스 호출하기
		HeritageService service = new HeritageService();
		
		// 서비스로부터 Result 결과를 가져옴!
		int result = service.HeritageUpdateList(h_id, h_status);
		
		
		
		String page = "";
		
		if( result > 0 ) {	// 조회한 정보가 0보다 크다면(있다면)
			request.setAttribute( "result", result );	// m_no의 정보를 가져와서
			
			page="heritageList.ad";	// adminMember.jsp 페이지로 보낸다
			
			
			// 만약 결과 값이 하나라도 있다면~ 어디페이지로 보내라
			
			
			// --------------------------------
			
		} else {	// 작성한 글이 없다면
			request.setAttribute("error-msg", "사용자 권한 수정 실패!");	//라는 메시지를들고
			
			page = "views/common/errorPage.jsp";	// errorPage.jsp로 보내라~
		} 
		
		// RequestDispatcher라는 택배기사를 통해서 배달 출발.
		request.getRequestDispatcher(page).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
