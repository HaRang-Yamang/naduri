package com.harang.naduri.jdbc.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.notice.model.service.NoticeService;
import com.harang.naduri.jdbc.notice.model.vo.Notice;
import com.harang.naduri.jdbc.notice.model.vo.PageNation;


/**
 * Servlet implementation class NoticeSelectList
 */
@WebServlet("/selectList.no")
public class NoticeSelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSelectList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 게시판 목록 처리하는 변수
		ArrayList<Notice> list = new ArrayList<>(); 
		NoticeService service = new NoticeService();
		
		// 10개 씩 자르기 위한 변수들
		int startPage;  // 시작 페이지  (1), 2, 3, 4, 5 . . . . 20
		
		int endPage;    // 끝 페이지    1, 2, 3, 4, (5) . . . . 20
		
		int maxPage;   // 실제 끝 페이지 1, 2, 3, 4, 5 . . . . (20)
		
		int currentPage;  // 현재 페이지
		
		int limit = 10;      // 한번에 보여줄 페이지 수
		
		currentPage = 1;
		
		// 만약 사용자 다른 페이지 번호에서 들어온다면
		if ( request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		// 총 게시글 확인
		int listCount = service.getListCount();
		
		// maxPage     206 / 10 => 21.8 --> 21
		//
		maxPage = (int)((double)listCount/10 + 0.9);
		
		// 시작 페이지
		startPage = (int)(((double)currentPage/10 + 0.9) - 1) * limit + 1;
		
		// 끝 페이지
		endPage = startPage + 9;
		
		// 만약 최종 페이지가 끝페이지보다 작다면
		if( maxPage < endPage) {
			endPage = maxPage;
		}
		
		// ---------------------- 페이지 처리 끝! --------------------- //
		
		
		list = service.selectList(currentPage);
		
		//System.out.println("list결과 : " + list);
		
		request.setAttribute("list", list);
		PageNation pn = new PageNation(startPage, endPage, maxPage, currentPage, limit, listCount);
		
		request.setAttribute("pn", pn);
		
		RequestDispatcher view = request.getRequestDispatcher("views/notice/noticeList.jsp");
		
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
