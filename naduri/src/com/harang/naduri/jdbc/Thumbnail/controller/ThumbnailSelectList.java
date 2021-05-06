package com.harang.naduri.jdbc.Thumbnail.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.Thumbnail.model.service.ThumbnailService;
import com.harang.naduri.jdbc.attach.model.vo.Attach;
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
		// HashMap<String, Object> list = new HashMap<>();
		
		HashMap<String, Object> map = new HashMap<>();
		
		String spotName = request.getParameter("spotName");
		
		
		// 서비스 준비
		ThumbnailService service = new ThumbnailService();
		
		
		// 결과를 list 객체에 저장
		map = service.selectOneSpot(spotName);
		
//		System.out.println(list);
		
		// request에 list 객체 담아서 보냄
		if ( map != null) {
			request.setAttribute("list", map.get("list")); // 맛집/여행지 정보 ( spot )
			request.setAttribute("list2", map.get("list2")); // 사진 ( attach )
			request.setAttribute("listHeri", map.get("listHeri")); // 문화재 정보 ( Heritage )
			request.setAttribute("lo_key", map.get("lo_key")); // 장소and키워드 정보 (location and keyword)
			
			
			System.out.println(map.get("list"));
			System.out.println(map.get("list2"));
			System.out.println(map.get("listHeri"));
			System.out.println(map.get("lo_key"));
		
		request.getRequestDispatcher("index2.jsp")
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