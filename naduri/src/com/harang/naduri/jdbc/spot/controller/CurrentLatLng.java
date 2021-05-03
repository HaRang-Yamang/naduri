package com.harang.naduri.jdbc.spot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.harang.naduri.jdbc.spot.model.vo.LatLng;
import com.harang.naduri.jdbc.spot.model.vo.Spot;

/**
 * Servlet implementation class CurrentLatLng
 */
@WebServlet("/currlatlng.lo")
public class CurrentLatLng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentLatLng() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");

	
		
		List<LatLng> curl = new ArrayList<>();
		
		Double swlat = Double.parseDouble(request.getParameter("swlat"));
		Double swlng = Double.parseDouble(request.getParameter("swlng"));
		Double nelat = Double.parseDouble(request.getParameter("nelat"));
		Double nelng = Double.parseDouble(request.getParameter("nelng"));

		LatLng ll = new LatLng(swlat, swlng, nelat, nelng);
		
		curl.add(ll);
		
		JSONObject obj = new JSONObject();
		
		obj.put("swlat", curl.get(0).getSwlat());
		obj.put("swlng", curl.get(0).getSwlng());
		obj.put("nelat", curl.get(0).getNelat());
		obj.put("nelng", curl.get(0).getNelng());
		
		
//		System.out.println(obj);
		
		response.setContentType("application/json");
		response.getWriter().print(obj.toJSONString());
		
		// LatLng ll = new LatLng(swlat, swlng, nelat, nelng);
		
		
		

		
//	
		
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
