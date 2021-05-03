package com.harang.naduri.jdbc.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.harang.naduri.jdbc.review.model.service.selectOneService;
import com.harang.naduri.jdbc.review.model.vo.Review;

/**
 * Servlet implementation class ReviewSelectOne
 */
@WebServlet("/reviewSelectOne.do")
public class ReviewSelectOne extends HttpServlet {
	private static final long serialVersionUID = 1039L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewSelectOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int r_no = Integer.parseInt(request.getParameter("r_no"));
		int m_no = Integer.parseInt(request.getParameter("m_no"));
		
		Review re = new selectOneService().selectOneMyReview(r_no, m_no);
	
		response.setContentType("application/json; charset=UTF-8");
			
		new Gson().toJson(re, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
