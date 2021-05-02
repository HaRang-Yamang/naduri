package com.harang.naduri.jdbc.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.qna.model.service.QnaService;
import com.harang.naduri.jdbc.qna.model.vo.Qna;

/**
 * Servlet implementation class QnaInsert
 */
@WebServlet("/insert.qn")
public class QnaInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int m_no = Integer.parseInt(request.getParameter("m_no"));
		String q_title = request.getParameter("q_title");
		String q_content =request.getParameter("q_content");
		System.out.println(q_title+","+q_content);
		Qna qn = new Qna(m_no, q_title, q_content);
		
		QnaService qna = new QnaService();
		int qResult =qna.insertQna(qn);
		
		if(qResult>0) {
			response.sendRedirect("selectList.qn");
		}else {
			request.setAttribute("error-msg", "게시글 작성 실패.");
			request.getRequestDispatcher("views/common/errorPage.jsp")
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
