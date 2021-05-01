package com.harang.naduri.jdbc.Thumbnail.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.harang.naduri.jdbc.Thumbnail.model.service.ProfileImg;
import com.harang.naduri.jdbc.Thumbnail.model.vo.Attach;
import com.harang.naduri.jdbc.common.MyRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ProfileImgInsert
 */
@WebServlet("/profileImgInsert.do")
public class ProfileImgInsert extends HttpServlet {
	private static final long serialVersionUID = 1030L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileImgInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String savePath = request.getServletContext().getRealPath("/assets/images/profile");
		
		int maxSize = 1024 * 1024 * 10;
		
		if(! ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("error-msg", "멀티파트 전송이 아닙니다.");
			request.getRequestDispatcher("views/common/errePage.jsp").forward(request, response);
		}
		
		MultipartRequest mr = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyRenamePolicy());
		
		ArrayList<String> changeNames = new ArrayList<>();
		
		// 파일태그 name속성 가져오기
		Enumeration<String> tagNames = mr.getFileNames();
		
		// 하나씩 추출하기
		while( tagNames.hasMoreElements()) {
			
			String tagName = tagNames.nextElement();
			changeNames.add(mr.getFilesystemName(tagName));
			
			
		}
		
		Attach a = new Attach();
		
		a.setAttach_name(mr.getParameter("attach_name"));
		a.setM_no(Integer.parseInt(mr.getParameter("m_no")));
		a.setAttach_no(Integer.parseInt(mr.getParameter("attach_no")));
		a.setA_status(mr.getParameter("a_status"));
		
		// 첨부파일 목록 생성
		ArrayList<Attach> list = new ArrayList<>();
		
		
		// 리스트에 파일 이름 저장하기
		for(int i = changeNames.size() -1 ; i >=0 ; i--) {
			
			a.setAttach_name(changeNames.get(i));
			
			list.add(a);
			
			
		}
		
		
		ProfileImg service = new ProfileImg();
		int result = service.insertProfileImg(a);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
