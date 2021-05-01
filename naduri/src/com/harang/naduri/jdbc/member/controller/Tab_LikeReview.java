package com.harang.naduri.jdbc.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.review.model.service.ReviewService;

/**
 * Servlet implementation class Tab_LikeReview
 */
@WebServlet("/tab_p_like.do")
public class Tab_LikeReview extends HttpServlet {
	private static final long serialVersionUID = 1033L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tab_LikeReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int m_no = Integer.parseInt(request.getParameter("m_no"));
		
		HashMap<String, Object> map = new ReviewService().selectLikeReview(m_no);
		
		
		
		
		if ( map != null) {
			request.setAttribute("list", map.get("list")); // 리뷰들
			request.setAttribute("list2", map.get("list2")); // 사진
			System.out.println(map.get("list"));
			System.out.println(map.get("list2"));
			request.getRequestDispatcher("views/myPage/tab_p_like.jsp").forward(request, response);
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
