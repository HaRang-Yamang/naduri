package com.harang.naduri.jdbc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.member.model.service.KeywordService;
import com.harang.naduri.jdbc.member.model.service.MemberService;
import com.harang.naduri.jdbc.member.model.vo.Keyword;
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
		
		String m_no = request.getParameter("m_no");
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
		
		// 취미는 여러 개 선택 가능
		String[] keyword_id = request.getParameterValues("keyword_id");
		
		
		// 받아온 정보를 하나의 vo로 묶기
				// 가입 정보
		Member joinMember = new Member(m_id, m_pwd, m_name, m_birthStr, m_gender, 
										m_addressStr, m_emailStr, m_phoneStr);
				// 키워드
		Keyword joinKeyword = new Keyword(keyword_id);
		
		System.out.println("member : " + joinMember);
		System.out.println("keyword : " + joinKeyword);
		
		
		// 회원 서비스 객체 생성
		MemberService mService = new MemberService();
		KeywordService kService = new KeywordService();
		
		int mResult = mService.insertMember(joinMember);
		int kResult = kService.insertKeyword(joinKeyword);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
