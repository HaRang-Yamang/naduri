package com.harang.naduri.jdbc.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.qna.model.service.QnaService;
import com.harang.naduri.jdbc.qna.model.vo.Qna;

/**
 * Servlet implementation class MyPageQnA
 */
@WebServlet("/tap_p_like.do")
public class MyPageQnA extends HttpServlet {
	private static final long serialVersionUID = 1034L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageQnA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Qna>list = new ArrayList<Qna>();
		QnaService service = new QnaService();
		int m_no= Integer.parseInt(request.getParameter("m_no"));
		
		list = service.selectMyQnaList(m_no);
		if(list !=null) {
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/myPage/tab_p_qna.jsp").forward(request, response);
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
