package com.harang.naduri.jdbc.notice.controller;

import java.io.IOException;
import java.sql.Date;
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
import com.harang.naduri.jdbc.notice.model.service.*;
import com.harang.naduri.jdbc.notice.model.vo.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class NoticeWrite
 */
@WebServlet("/noticeWrite.no")
public class NoticeWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드용 Request
		// MultipartRequest
		
		//1. 파일 저장 경로(DB로 안하고 이클립스에서!용량때문)
		
		String savePath = request.getServletContext()
		          .getRealPath("/resources/noticeFiles");
		
		//2. 파일 크기
		int maxSize = 1024 * 1024 * 10;  // 10MB
		
		// 3. multipart 로 전송된 것인지 확인하기
		if(! ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("error-msg", "multipart 전송이 아닙니다.");
			
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);
		}
		
		// 4. MultipartRequest 작성
		MultipartRequest mr = new MultipartRequest(request, savePath, maxSize, 
										   "UTF-8", new MyRenamePolicy());
		
		// 추가된 파일 객체
		ArrayList<String> changeNames = new ArrayList<>();
		
		Enumeration<String> tagNames = mr.getFileNames();
		
		// 5. 전송값 처리
		String title = mr.getParameter("n_title");
		String content = mr.getParameter("n_content");
		int m_no = Integer.parseInt(mr.getParameter("m_no"));
		
		//System.out.println("확인 : " +title + ", " + content);
		
		// 6. 함게 저장된 파일의 이름 추출하기
			
		while( tagNames.hasMoreElements()) {
			
			String tagName = tagNames.nextElement();
			
			changeNames.add(mr.getFilesystemName(tagName));
			
			// System.out.println(tagName + ":" + changeNames);
		}
		// 7. VO 작성하기
		Notice n = new Notice();
		
		n.setN_title(title);
		n.setN_content(content);
		n.setM_no(m_no);
		
		// 여기서 이제 첨부파일 목록 생성
		ArrayList<Attach> list = new ArrayList<>();
		
		for( int i = changeNames.size() - 1; i >= 0 ; i--) {
			Attach a = new Attach();
			
			a.setA_name(changeNames.get(i));
			
			list.add(a);
		}
		
		n.setAttlist(list);
		
		// 8. 서비스 시작
		NoticeService service = new NoticeService();
		
		int result = service.insertNotice(n);
		
		if(result > 0 ) {
			response.sendRedirect("selectList.no");
		} else {
			
			request.setAttribute("error-msg", "공지글 작성 실패!");
			
			request.getRequestDispatcher("views/common/errorPage.jsp")
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
