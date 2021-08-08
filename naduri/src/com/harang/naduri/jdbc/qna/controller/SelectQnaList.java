package com.harang.naduri.jdbc.qna.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.qna.model.service.QnaService;
import com.harang.naduri.jdbc.qna.model.vo.Qna;

/**
 * Servlet implementation class SelectQnaList
 */
@WebServlet("/selectList.qn")
public class SelectQnaList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectQnaList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Qna>list = null;
		QnaService service = new QnaService();
		int lno = Integer.parseInt(request.getParameter("l_no"));
		
		list = service.selectQnaList(lno);
		if(list !=null) {
			request.setAttribute("list", list);
			System.out.println(list);
			
			request.getRequestDispatcher("views/detail/tab_qna.jsp").forward(request, response);
		}else {
			
			request.setAttribute("error-msg", "QNA게시 실패!");
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
