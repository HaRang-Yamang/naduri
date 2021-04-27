package com.harang.naduri.jdbc.member.controller;

import java.io.IOException;

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
		
		String[] m_birth = request.getParameterValues("m_birth");
		String m_birthStr = String.join("-", m_birth);
		
		String[] m_phone = request.getParameterValues("m_phone");
		String m_phoneStr = String.join("-", m_phone);
		
		String m_email[] = request.getParameterValues("m_email");
		String m_emailStr = String.join("@" , m_email);

		String m_address[] = request.getParameterValues("m_address");
		String m_addressStr = String.join(" ", m_address);
		
		String[] keyword_id = request.getParameterValues("keyword_id");
		// 배열을 문자열로 변환
		String keyword_idStr = String.join(", ", keyword_id);
		
		
		Member joinMember = new Member(m_id, m_pwd, m_name, m_gender, m_birthStr,
										m_phoneStr, m_emailStr, m_addressStr, keyword_idStr);
		
		System.out.println("member : " + joinMember);
		
		MemberService service = new MemberService();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
