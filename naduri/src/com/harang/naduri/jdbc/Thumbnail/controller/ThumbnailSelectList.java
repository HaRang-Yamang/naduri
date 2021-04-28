package com.harang.naduri.jdbc.Thumbnail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.Thumbnail.model.service.ThumbnailService;
import com.harang.naduri.jdbc.Thumbnail.model.vo.Thumbnail;

/**
 * Servlet implementation class boardSelect
 */
@WebServlet("/index.do")
public class ThumbnailSelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailSelectList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ҵ��� ������� �޾ƿ� ��ü �ʿ�
		ArrayList<Thumbnail> list = new ArrayList<>();
		
		// ���� �غ�
		ThumbnailService service = new ThumbnailService();
		
		// ����� list ��ü�� ����
		list = service.selectList();
		
//		System.out.println(list);
		
		// request�� list ��ü ��Ƽ� ����
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("index.jsp")
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
