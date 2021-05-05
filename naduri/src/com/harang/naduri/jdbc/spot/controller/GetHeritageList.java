package com.harang.naduri.jdbc.spot.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harang.naduri.jdbc.heritage.model.service.HeritageService;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.spot.model.service.SpotService;
import com.harang.naduri.jdbc.spot.model.vo.Spot;

/**
 * Servlet implementation class GetHeritageList
 */
@WebServlet("/heritagelist.se")
public class GetHeritageList extends HttpServlet {
	private static final long serialVersionUID = 1818L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHeritageList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<Heritage> list = new ArrayList<>();		
		HeritageService service = new HeritageService();
	
		list = service.getHerCode();
		
//		System.out.println("list : " + list);
		
		String ccbaKdcd = ""; // 종목코드
		String ccbaAsno = ""; // 지정번호
		String ccbaCtcd = ""; // 시도코드
		
		
		
		
		
		
		
		
		

	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
