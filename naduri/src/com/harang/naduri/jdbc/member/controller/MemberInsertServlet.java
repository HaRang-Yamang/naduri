package com.harang.naduri.jdbc.member.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.member.model.service.MemberService;
import com.harang.naduri.jdbc.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/memberInsert.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		

		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");
		String m_name = request.getParameter("m_name");
		String m_gender = request.getParameter("m_gender");
		
		// 입력 칸이 여러 개이므로 배열로 정보값을 받아온다.
		String[] m_birth = request.getParameterValues("m_birth");
		// 배열 -> 문자열 변경
		String m_birthStr = String.join("-", m_birth);
		
		String[] m_phone = request.getParameterValues("m_phone");
		String m_phoneStr = String.join("-", m_phone);
		
		String[] m_email = request.getParameterValues("m_email");
		String m_emailStr = String.join("@", m_email);
		
		String[] m_address = request.getParameterValues("m_address");
		String m_addressStr = String.join(" ", m_address);
		
		String[] keyword_id = request.getParameterValues("keyword_id");
		String keyword_idStr = String.join(" ", keyword_id);

//		for(int i = 0 ; i < keyword_id.length ; i++) {
//			String keyArr = request.getParameter(keyword_id[i]);
//		}
		
		
		// 받아온 정보를 하나의 vo로 묶기
		// 가입 정보
		Member joinMember = new Member(m_id, m_pwd, m_name, m_birthStr, m_gender, 
				m_addressStr, m_emailStr, m_phoneStr);

		System.out.println("member : " + joinMember);
		System.out.println("keyword_id : " + Arrays.toString(keyword_id));
		
		// 회원 서비스 객체 생성
		MemberService service = new MemberService();
		int result = service.insertMember(joinMember, keyword_id);

		if(result > 0) {
			// 회원 가입 성공!
			System.out.println("회원 가입 성공!");
			
			response.sendRedirect("views/login.jsp");
		} else {
			// 회원 가입 실패
			System.out.println("회원 가입 실패!");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
		
			request.setAttribute("error-msg", "회원 가입에 실패하였습니다");
			
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
