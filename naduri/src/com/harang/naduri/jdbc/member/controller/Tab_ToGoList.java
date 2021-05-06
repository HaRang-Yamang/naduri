package com.harang.naduri.jdbc.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.Thumbnail.model.vo.lo_key;
import com.harang.naduri.jdbc.member.model.service.ToGoListService;

/**
 * Servlet implementation class Tab_ToGoList
 */
@WebServlet("/tab_togolist.do")
public class Tab_ToGoList extends HttpServlet {
	private static final long serialVersionUID = 1031L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tab_ToGoList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int m_no = Integer.parseInt(request.getParameter("m_no"));
		ArrayList<lo_key> list = new ToGoListService().togoList(m_no);
		
		
		if ( list != null) {
			request.setAttribute("list", list);  // 나머지
			
			
			
			request.getRequestDispatcher("views/myPage/tab_togolist.jsp").forward(request, response);
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
