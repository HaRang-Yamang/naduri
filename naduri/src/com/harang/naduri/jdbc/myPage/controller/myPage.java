package com.harang.naduri.jdbc.myPage.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.attach.model.vo.*;
import com.harang.naduri.jdbc.member.model.vo.Member;
import com.harang.naduri.jdbc.myPage.model.service.myPageService;
import com.harang.naduri.jdbc.review.model.service.ReviewService;

/**
 * Servlet implementation class myPage
 */
@WebServlet("/myPage.do")
public class myPage extends HttpServlet {
	private static final long serialVersionUID = 10300L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int m_no = ((Member)request.getSession().getAttribute("member")).getM_no();
		
		HashMap<String, Object> map = new myPageService().myPage(m_no);
		
		if ( map != null) {
		
		request.setAttribute("a", map.get("a"));			
		request.setAttribute("listk", map.get("listk")); // 키워드
		request.getRequestDispatcher("views/myPage/myPage.jsp").forward(request, response);
		
		}
		
	}

}
