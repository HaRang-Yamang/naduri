package com.harang.naduri.jdbc.reply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.comment.model.vo.ReviewComment;
import com.harang.naduri.jdbc.comment.model.service.ReviewCommentService;
import com.harang.naduri.jdbc.comment.model.service.ReviewCommentService;
import com.harang.naduri.jdbc.comment.model.vo.ReviewComment;

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
		

			private int replyno;
			private int mno;
			private int rno;
			private int qno;
			private String reply_content;
			private Date reply_date;
			private Date reply_update;
			private int ref_no;
			
			
		
				// 받아오는 변수들 1. 리뷰
				int mno = Integer.parseInt(request.getParameter("mno")); // 작성자
				String m_id = request.getParameter("m_id"); // 댓글 내용
				int rno = Integer.parseInt(request.getParameter("rno")); // 게시글 번호
				
				String reply_content = request.getParameter("reply_content"); // 댓글 내용
				Date reply_date = request.getParameter("reply_date"); // 댓글 내용
				Date reply_update = request.getParameter("reply_update"); // 댓글 내용
				int ref_no = Integer.parseInt(request.getParameter("ref_no")); // 참조하는 댓글 번호

				// 받아오는 변수들 2. qna
				int qno = Integer.parseInt(request.getParameter("qno")); // 작성자
				int rno = Integer.parseInt(request.getParameter("q_title")); // 게시글 번호
				String reply_content = request.getParameter("q_content"); // 댓글 내용
				String reply_content = request.getParameter("q_date"); // 댓글 내용
				String reply_content = request.getParameter("q_update"); // 댓글 내용
				
				String reply_content = request.getParameter("reply_content"); // 댓글 내용
				int ref_no = Integer.parseInt(request.getParameter("ref_no")); // 참조하는 댓글 번호
				
				
				
				ReviewComment comment = new ReviewComment(mno, rno, reply_content, ref_no);
				
				ReviewCommentService service = new ReviewCommentService();
				
				int result = service.insertComment(comment);
				
				if( result > 0 ) {
					response.sendRedirect("selectOne.bo?bno="+rno);
	
				} else {
					request.setAttribute("error-msg", "댓글 작성 중 에러 발생");
					
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
