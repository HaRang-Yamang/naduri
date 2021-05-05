package com.harang.naduri.jdbc.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.review.model.service.ReviewService;
import com.harang.naduri.jdbc.review.model.vo.Review;

/**
 * Servlet implementation class SelectReviewList
 */
@WebServlet("/selectList.re")
public class SelectReviewList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectReviewList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Review> reviewList =null;

		ReviewService service = new ReviewService();
		
		// 임시
//	    int lno = Integer.parseInt(request.getParameter("l_no"));
		int lno = 1;
		
	    reviewList =service.selectReviewList(lno);
		
		if(reviewList !=null) {
			request.setAttribute("reviewList",  reviewList);
			
			for(Review r : reviewList) {
				System.out.println(r);
				System.out.println(r.getAttList());
			}
			
			request.getRequestDispatcher("views/detail/tab_review.jsp").forward(request, response);
		} else {
			
			request.setAttribute("error-msg", "리뷰 게시 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
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
