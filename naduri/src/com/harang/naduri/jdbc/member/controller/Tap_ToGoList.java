package com.harang.naduri.jdbc.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.member.model.service.ToGoListService;

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
		List<Map<String, Object>> list = new ToGoListService().togolist(m_no);
		List<Map<String, Object>> list2 = new ToGoListService().togolist(m_no);
		
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		
//		request.setAttribute("lista", list.get("lista"));
//		request.setAttribute("listk", list.get("listk"));
//		request.setAttribute("lists", list.get("lists"));
//		request.setAttribute("listh", list.get("listh"));
		
//		response.sendRedirect("/tab_togolist.do");
		request.getRequestDispatcher("views/myPage/tab_togolist.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
