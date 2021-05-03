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
@WebServlet("/index222.do")
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
		// �옣�냼�뱾�쓽 �뜽�꽕�씪�쓣 諛쏆븘�삱 媛앹껜 �븘�슂
		// HashMap<String, Object> list = new HashMap<>();
		
		HashMap<String, Object> map = new HashMap<>();
		
		// �꽌鍮꾩뒪 以�鍮�
		ThumbnailService service = new ThumbnailService();
		
		// 寃곌낵瑜� list 媛앹껜�뿉 ���옣
		map = service.selectList();
		
//		System.out.println(list);
		
		// request�뿉 list 媛앹껜 �떞�븘�꽌 蹂대깂
		if ( map != null) {
			request.setAttribute("list", map.get("list")); // 留쏆쭛/�뿬�뻾吏� �젙蹂� ( spot )
			request.setAttribute("list2", map.get("list2")); // �궗吏� ( attach )
			request.setAttribute("listHeri", map.get("listHeri")); // 臾명솕�옱 �젙蹂� ( Heritage )
			request.setAttribute("lo_key", map.get("lo_key")); // �옣�냼and�궎�썙�뱶 �젙蹂� (location and keyword)
			
			
			System.out.println(map.get("list"));
			System.out.println(map.get("list2"));
			System.out.println(map.get("listHeri"));
			System.out.println(map.get("lo_key"));
		
		request.getRequestDispatcher("index.jsp")
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
