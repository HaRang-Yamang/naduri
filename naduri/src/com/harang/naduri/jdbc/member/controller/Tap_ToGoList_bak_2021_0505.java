package com.harang.naduri.jdbc.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.member.model.service.ToGoListService;
import com.harang.naduri.jdbc.review.model.service.ReviewService;

/**
 * Servlet implementation class Tap_ToGoList
 */
@WebServlet("/tab_togolist.do")
public class Tap_ToGoList extends HttpServlet {
	private static final long serialVersionUID = 1031L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tap_ToGoList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int m_no = Integer.parseInt(request.getParameter("m_no"));
		HashMap<String, Object> map = new ToGoListService().togolist(m_no);
		
		request.setAttribute("lista", map.get("lista"));
		request.setAttribute("listk", map.get("listk"));
		request.setAttribute("lists", map.get("lists"));
		request.setAttribute("listh", map.get("listh"));
		
		response.sendRedirect("/tab_togolist.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
