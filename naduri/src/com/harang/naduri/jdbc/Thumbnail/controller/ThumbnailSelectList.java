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
		// 장소들의 썸네일을 받아올 객체 필요
		ArrayList<Thumbnail> list = new ArrayList<>();
		
		// 서비스 준비
		ThumbnailService service = new ThumbnailService();
		
		// 결과를 list 객체에 저장
		list = service.selectList();
		
//		System.out.println(list);
		
		// request에 list 객체 담아서 보냄
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
