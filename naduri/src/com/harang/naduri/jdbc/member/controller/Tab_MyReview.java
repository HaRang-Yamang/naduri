package com.harang.naduri.jdbc.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.review.model.service.ReviewService;
import com.harang.naduri.jdbc.review.model.vo.Review;

/**
 * Servlet implementation class Tab_MyReview
 */
@WebServlet("/tab_p_reviews.do")
public class Tab_MyReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tab_MyReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int m_no = Integer.parseInt(request.getParameter("m_no"));
		
		ArrayList<Review> list = new ReviewService().selectMyReview(m_no);
		
		if ( list != null) {
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/myPage/tab_p_reviews.jsp")
			.forward(request, response);
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
