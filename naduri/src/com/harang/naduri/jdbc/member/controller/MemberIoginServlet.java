package com.harang.naduri.jdbc.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harang.naduri.jdbc.member.model.service.MemberService;
import com.harang.naduri.jdbc.member.model.vo.*;

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
		
		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");
		// 로그인 상태 유지
		
		System.out.println("서블릿 : " + m_id + "/" + m_pwd);
		
		
		Member loginMember = new Member(m_id, m_pwd);
		ArrayList<Keyword> keywordArr = new ArrayList<>();
		
		// 로그인 서비스 수행 (업무 로직 : biz logic)
		MemberService service = new MemberService();
		
		// member 정보와 keyword_id 정보를 한꺼번에 가져오는 방법
		keywordArr = service.selectKeyword(loginMember);
		// 기존 작업
		loginMember = service.selectMember(loginMember);
		
		if(loginMember!=null) {
			// 로그인 성공!
			System.out.println("로그인 성공!");
			
			// 아이디 저장 여부 쿠키로 저장하기
			/*
			if(saveId != null) {
				Cookie c = new Cookie("saved", m_id);
				c.setMaxAge(60*60*24*7);
				response.addCookie(c);
			} else {
				Cookie c = new Cookie("savedId", m_id);
				c.setMaxAge(0);
				response.addCookie(c);
			}
			*/
			HttpSession session = request.getSession();
			
			session.setAttribute("listK", keywordArr);
			session.setAttribute("member", loginMember);
			
			//System.out.println(mapMember.get("listK"));
			
			response.sendRedirect("/naduri");
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
