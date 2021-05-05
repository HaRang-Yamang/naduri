package com.harang.naduri.jdbc.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.member.model.service.MemberService;
import com.harang.naduri.jdbc.member.model.vo.Member;
import com.harang.naduri.jdbc.notice.model.vo.PageNation;

/**
 * Servlet implementation class AdminMemberList
 */
@WebServlet("/memberList.ad")
public class AdminMemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Member> list = new ArrayList<>();
		
		MemberService service = new MemberService();
		
		// 페이지네이션
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
		
		
		
		//-------------------------------------------------------------
		list = service.memberList(currentPage);
		
		//System.out.println("list" + list);
		
		request.setAttribute("list", list);
		PageNation pn = new PageNation(startPage, endPage, maxPage, currentPage, limit, listCount);
		
		request.setAttribute("pn", pn);
		
		RequestDispatcher view = request.getRequestDispatcher("views/admin/adminMember.jsp");
		
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
