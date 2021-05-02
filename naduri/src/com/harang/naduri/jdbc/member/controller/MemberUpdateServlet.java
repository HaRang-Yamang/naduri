package com.harang.naduri.jdbc.member.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harang.naduri.jdbc.member.model.service.MemberService;
import com.harang.naduri.jdbc.member.model.vo.Keyword;
import com.harang.naduri.jdbc.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		// 회원 정보 수정 데이터
		String m_pwd = request.getParameter("m_pwd");
		String m_gender = request.getParameter("m_gender");
		String[] m_phone = request.getParameterValues("m_phone");
		String m_phoneStr = String.join("-", m_phone);
		String[] m_email = request.getParameterValues("m_email");
		String m_emailStr = String.join("-", m_email);
		String[] m_address = request.getParameterValues("m_address");
		String m_addressStr = String.join("-", m_address);
		
		String keyword_id = String.join(", ", request.getParameterValues("keyword_id"));
		
		// 회원의 변경 전 정보 가져오기
		HttpSession session = request.getSession(false);
		
		Member updateMember = (Member)session.getAttribute("member");
		//Keyword updateKeyword = (Keyword)session.getAttribute("keyword_id");
		
		System.out.println("member 원본 정보 : " + updateMember);
		System.out.println("keyword_id 원본 정보 : " + keyword_id);

		
		// 변경할 회원 정보 처리
		
		updateMember.setM_pwd(m_pwd);
		updateMember.setM_gender(m_gender);
		updateMember.setM_phone(m_phoneStr);
		updateMember.setM_email(m_emailStr);
		updateMember.setM_address(m_addressStr);

		System.out.println("member 변경 정보 : " + updateMember);
		
		
		// 회원 서비스 연동
		MemberService service = new MemberService();
		
		int result = service.updateMember(updateMember);
		
		if(result > 0) {
			// 회원 정보 수정 성공!
			System.out.println("회원 정보 수정 성공!");
			session.invalidate();
			
			response.sendRedirect("views/login.jsp");
		} else {
			// 회원 정보 수정 실패!
			
			request.setAttribute("error-msg", "회원 정보 수정 실패!");
			
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
