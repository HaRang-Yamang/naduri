package com.harang.naduri.jdbc.bookmark.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.bookmark.model.service.BookmarkService;
import com.harang.naduri.jdbc.bookmark.model.vo.Bookmark;


/**
 * Servlet implementation class BookmarkInsert
 */
@WebServlet("/bookmarkInsert.do")
public class BookmarkInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookmarkInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int l_no = Integer.parseInt(request.getParameter("l_no"));
		int m_no = Integer.parseInt(request.getParameter("m_no"));
		
		Bookmark b = new Bookmark(l_no, m_no);
		
		BookmarkService service = new BookmarkService();
		
		int result = service.insertBookmark(b);
		
		if(result > 0) {
			response.sendRedirect("CallApiDetail.do?l_no="+l_no);
		} else {

			RequestDispatcher view = 
					request.getRequestDispatcher("views/common/errorPage.jsp");
			
			request.setAttribute("error-msg", "찜 실패");
			
			view.forward(request, response);
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
