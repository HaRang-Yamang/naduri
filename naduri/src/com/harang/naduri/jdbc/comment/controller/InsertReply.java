package com.harang.naduri.jdbc.comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.comment.model.vo.Comment;
import com.harang.naduri.jdbc.comment.model.service.CommentService;
import com.harang.naduri.jdbc.comment.model.vo.Comment;

/**
 * Servlet implementation class InsertReply
 */
@WebServlet("/insert.Re")
public class InsertReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


		
				// 받아오는 변수들 1. 리뷰
				//int mno = Integer.parseInt(request.getParameter("mno")); // 작성자
				String m_id = request.getParameter("m_id"); // 댓글 내용
				//int rno = Integer.parseInt(request.getParameter("rno")); // 게시글 번호
				
				//String reply_content = request.getParameter("reply_content"); // 댓글 내용
				String reply_date = request.getParameter("reply_date"); // 댓글 내용
				String reply_update = request.getParameter("reply_update"); // 댓글 내용
				//int ref_no = Integer.parseInt(request.getParameter("ref_no")); // 참조하는 댓글 번호

				// 받아오는 변수들 2. qna
				int qno = Integer.parseInt(request.getParameter("qno")); // 작성자
				String q_title = request.getParameter("q_title"); // 게시글 번호
				String q_content = request.getParameter("q_content"); // 댓글 내용
				String q_date = request.getParameter("q_date"); // 댓글 내용
				String q_update = request.getParameter("q_update"); // 댓글 내용
				
				int mno = 5;
				int rno = 5;
				String reply_content = "안녕하세요";
				int ref_no = 0;
				int l_no = 4;
				
				
				
				// ArrayList대신에 객체 생성
				Comment Rcomment = new Comment(mno, rno, reply_content, ref_no); 
				
				Comment Qcomment = new Comment(mno, qno, q_title, q_content);
				

				
				
				// 리뷰 댓글을 작성한다면 아래의 서비스로 출발합니다.
				if ( rno > 0 ) {
				
				CommentService Rservice = new CommentService();
				
				int resultR = Rservice.insertRComment(Rcomment);
				
				if( resultR > 0 ) {
					response.sendRedirect("index.do");
	
				} else {
					request.setAttribute("error-msg", "댓글 작성 중 에러 발생");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
					       .forward(request, response);
				}	
				
				
				// 질문을 작성한다면 아래의 서비스로 출발합니다.
				} else {
				
				CommentService Qservice = new CommentService();
				
				int resultQ = Qservice.insertQComment(Qcomment);
				
				if( resultQ > 0 ) {
					response.sendRedirect("selectQcommentOne.do?rno="+rno);
	
				} else {
					request.setAttribute("error-msg", "댓글 작성 중 에러 발생");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
					       .forward(request, response);
				}		
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
