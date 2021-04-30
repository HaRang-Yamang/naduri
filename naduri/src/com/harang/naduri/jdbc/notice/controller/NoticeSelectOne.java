package com.harang.naduri.jdbc.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.notice.model.service.NoticeService;
import com.harang.naduri.jdbc.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeSelectOne
 */
@WebServlet("/selectOne.no")
public class NoticeSelectOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSelectOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 조회를 위한 게시글 번호 가져왔고
		int n_no = Integer.parseInt(request.getParameter("n_no"));
		
		// 게시글 서비스 객체 생성했고
		NoticeService service = new NoticeService();
		
		// 게시글 조회 서비스 시작 --> 서비스로 고고
		Notice n = service.selectOne(n_no);
		// 위에서 n <-- 서비스로 조회한 결과
		
		
		String page ="";
		
		if ( n != null) {	// 조회결과 게시글이 있었다면 "notice"라는 이름으로 n을 등록함
			request.setAttribute("notice", n);
			
			page = "views/notice/noticeDetail.jsp";
			
		} else {
			
			request.setAttribute("error-msg", "게시글 조회 실패!");
			
			page = "views/common/errorPage.jsp";
		
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
