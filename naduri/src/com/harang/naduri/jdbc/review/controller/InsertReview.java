package com.harang.naduri.jdbc.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.harang.naduri.jdbc.attach.model.vo.Attach;
import com.harang.naduri.jdbc.common.MyRenamePolicy;
import com.harang.naduri.jdbc.review.model.service.ReviewService;
import com.harang.naduri.jdbc.review.model.vo.Review;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertReview
 */
@WebServlet("/insert.vi")
public class InsertReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String savePath = request.getServletContext().getRealPath("/assets/images/review");
		int maxSize = 1024*1024*10;
		if(! ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("error-msg", "멀티파트 전송이 아닙니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp")
			.forward(request, response);
		}
		MultipartRequest mr = new MultipartRequest(request,savePath,maxSize, "UTF-8",
				new MyRenamePolicy());
		
		ArrayList<String>changeNames = new ArrayList<>();
	//정보 받아오기
		
		int r_rank = Integer.parseInt(mr.getParameter("r_rank"));
		String[]r_period =  mr.getParameterValues("r_period");
		String r_periodStr = String.join("-", r_period);
		int r_with = Integer.parseInt(mr.getParameter("r_with"));
		String r_title = mr.getParameter("r_title");
		String r_content =mr.getParameter("r_content"); 
		Review r = new Review(r_rank, r_title,r_content,r_periodStr, r_with);
		
		System.out.println(r_rank+r_title+r_content+r_periodStr+r_with);
		//첨부파일 목록
		Enumeration<String>tagNames= mr.getFileNames();
		while( tagNames.hasMoreElements()) {
			
			String tagName = tagNames.nextElement();
			
			changeNames.add(mr.getFilesystemName(tagName));
			
			System.out.println(tagName + " : " + changeNames);
			
		}
	
		
		//첨부파일 목록 생성
		ArrayList<Attach>list = new ArrayList<>();
		for(int i = changeNames.size()-1; i>0; i--) {
			Attach a = new Attach();
			a.setAttach_name(changeNames.get(i));
			if(i==changeNames.size()-1) {
				a.setA_type('1');
			}else {
				a.setA_type('2');
			}
			list.add(a);
		}
		r.setAttList(list);
		//객체 생성
		
		
		ReviewService rReview = new ReviewService();
		int rResult = rReview.insertReview(r);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
