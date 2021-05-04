package com.harang.naduri.jdbc.Thumbnail.controller;

import java.io.File;
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
import com.harang.naduri.jdbc.attach.model.vo.Attach;
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
		String savePath = request.getServletContext().getRealPath("/resources/profileImg");
		
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
		
		a.setA_name(mr.getFilesystemName("profileImg"));
		a.setM_no(Integer.parseInt(mr.getParameter("m_no")));
		
		
		// 첨부파일 목록 생성
		ArrayList<Attach> list = new ArrayList<>();
		
		
		// 리스트에 파일 이름 저장하기
		for(int i = changeNames.size() -1 ; i >=0 ; i--) {
			
			a.setA_name(changeNames.get(i));
			
			list.add(a);
			
			
		}
		
		
		ProfileImg service = new ProfileImg();
		int result = service.insertProfileImg(a);
		
		if(result > 0) {
			request.setAttribute("list", list);			
			request.getRequestDispatcher("myPage.do").forward(request, response);
			
		} else {
			
			// 등록 실패시 저장된 파일 삭제
			for (int i = 0 ; i < changeNames.size(); i++) {
				new File(savePath + "/" + changeNames.get(i)).delete();
			}
			
			request.setAttribute("error-msg", "사진 게시글 등록 실패");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
