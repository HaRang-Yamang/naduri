package com.harang.naduri.jdbc.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.notice.model.service.NoticeService;
import com.harang.naduri.jdbc.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdate
 */
@WebServlet("/noticeUpdate.no")
public class NoticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// n_no를 통해서 정보를 받아오고, getParameter는 문자열로 결과물을
		// 받아오니까 문자열을 숫자로 바꿔줌.
		int n_no = Integer.parseInt(request.getParameter("n_no"));
		
		// 서비스 호출하기
		NoticeService service = new NoticeService();
		
		// 서비스로부터 Notice 객체를 가져옴!
		Notice n = service.noticeUpdate(n_no);
		
		String page = "";
		
		if( n != null) {	// 작성한 글이 있다면
			request.setAttribute("notice", n);	// 작성된 글들을 가져와서
			
			page="views/notice/noticeUpdate.jsp";	// noticeUpdate.jsp페이지로 보내고,
			
		} else {	// 작성한 글이 없다면
			request.setAttribute("error-msg", "공지사항 수정화면 접근 불가!");	//라는 메시지를들고
			
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
