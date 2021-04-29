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
 * Servlet implementation class MemberIoginServlet
 */
@WebServlet("/login.do")
public class MemberIoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberIoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		
		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");
		
		System.out.println("서블릿 : " + m_id + "/" + m_pwd);
		
		Member loginMember = new Member(m_id, m_pwd);
		
		// 로그인 서비스 수행 (업무 로직 : biz logic)
		MemberService service = new MemberService();
		
		loginMember = service.selectMember(loginMember);
		
		if(loginMember != null) {
			// 로그인 성공!
			
			HttpSession session = request.getSession();	
			session.setAttribute("member", loginMember);
			
			response.sendRedirect("index.jsp");
		} else {
			// 로그인 실패!
			request.setAttribute("error-msg", "로그인 실패!");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
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