package com.harang.naduri.jdbc.comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReviewCommentInsert
 */
@WebServlet("/insert.co")
public class ReviewCommentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCommentInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �ۼ���, �Խñ� ��ȣ, ��� ����, �����ϴ� ��� ��ȣ, ��۷���
		String writer = request.getParameter("writer");
		int bno = Integer.parseInt(request.getParameter("bno"));
		String content = request.getParameter("replyContent");
		int refcno = Integer.parseInt(request.getParameter("refcno"));
		int clevel = Integer.parseInt(  request.getParameter("clevel"));
		int btype = Integer.parseInt(request.getParameter("btype"));
		
		BoardComment comment = new BoardComment(bno, content, writer, refcno, clevel);
		
		BoardCommentService service = new BoardCommentService();
		
		int result = service.insertComment(comment);
		
		if( result > 0 ) {
			if(btype == 1) response.sendRedirect("selectOne.bo?bno="+bno);
			else response.sendRedirect("selectOne.tn?bno="+bno);
		} else {
			request.setAttribute("error-msg", "��� �ۼ� �� ���� �߻�");
			
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
