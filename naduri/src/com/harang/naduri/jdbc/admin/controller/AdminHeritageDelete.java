package com.harang.naduri.jdbc.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.heritage.model.service.HeritageService;

/**
 * Servlet implementation class AdminHeritageDelete
 */
@WebServlet("/deleteHeritage.ad")
public class AdminHeritageDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHeritageDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int h_id = Integer.parseInt(request.getParameter("h_id"));
		
		HeritageService service = new HeritageService();
		
		int result = service.deleteHeritage(h_id);
		
		String page = "";
		
		if( result > 0 ) {	// 조회한 정보가 0보다 크다면(있다면)
			request.setAttribute( "result", result );	// h_id의 정보를 가져와서
			
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
