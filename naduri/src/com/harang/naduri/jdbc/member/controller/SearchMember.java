package com.harang.naduri.jdbc.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harang.naduri.jdbc.member.model.service.MemberService;
import com.harang.naduri.jdbc.member.model.vo.Member;

/**
 * Servlet implementation class SearchMember
 */
@WebServlet("/searchId.do")
public class SearchMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String m_name = request.getParameter("m_name");
		String m_email = request.getParameter("m_email");
		
		// m_id를 찾기 위한 정보
		Member searchId = new Member(0, null, null, m_name, null, null, null, m_email, null , 0, null);
		
		System.out.println("이름 / 이메일 : " + searchId);
		
		MemberService service = new MemberService();
		Member result = service.searchId(searchId);
		
		if(result != null) {
			// 아이디 찾기 성공!
			System.out.println("아이디 찾기 성공!");
			System.out.println("찾은 정보 : " + result);
			
			HttpSession session = request.getSession();
			session.setAttribute("member", result);
			
			
			response.sendRedirect("views/find/findResultId.jsp");
		} else {
			// 아이디 찾기 실패
			System.out.println("아이디 찾기 실패!");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("error-msg", "아이디 찾기에 실패하였습니다");
			view.forward(request, response);
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
