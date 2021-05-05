package com.harang.naduri.jdbc.spot.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.harang.naduri.jdbc.heritage.model.service.HeritageService;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.spot.model.service.SpotService;
import com.harang.naduri.jdbc.spot.model.vo.Spot;

/**
 * Servlet implementation class SpotSelectList
 */
@WebServlet("/searchresult.sr")
public class SelectResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("UTF-8");
		
		// Spot 목록 처리하는 변수 
		ArrayList<Spot> slist = new ArrayList<>();		
		SpotService sservice = new SpotService();
				
		slist = sservice.selectList();
		
		System.out.println("slist : " + slist);
		
		request.setAttribute("slist", slist);
		
		request.getRequestDispatcher("views/search/search.jsp").forward(request, response);
		
		
		
		
		// Heritage 목록 처리하는 변수
		ArrayList<Heritage> hlist = new ArrayList<>();
		HeritageService hservice = new HeritageService();
		
		hlist = hservice.selectHerList();
		
		System.out.println("hlist : " + hlist);
		
		
		request.setAttribute("hlist", hlist);
		request.getRequestDispatcher("views/search/search.jsp").forward(request, response);

		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
