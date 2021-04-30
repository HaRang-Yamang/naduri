package com.harang.naduri.jdbc.review.model.service;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import com.harang.naduri.jdbc.attach.model.vo.Attach;
import com.harang.naduri.jdbc.review.model.dao.ReviewDAO;
import com.harang.naduri.jdbc.review.model.vo.Review;

public class ReviewService {
	 private Connection con;
	 private ReviewDAO dao = new ReviewDAO();
	
	public int insertReview(Review r) {
		con = getConnection();
		ArrayList<Attach>list = r.getAttList();
		int result = 0;
		//리뷰 게시글 저장
		int result1 =dao.insertReview(con, r);
		if(result1>0) {
			int r_no =dao.getCurrentRno(con);
			for(int i=0; i<list.size(); i++) {
				list.get(i).setRno(r_no);
			}
		}
		//첨부 파일 저장
		int result2 = 0;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) !=null && list.get(i).getAttach_name() !=null) {
				result2= dao.insertAttach(con,list.get(i));
				if(result2 ==0)break;
			}else {
				result2 =1;
			}
		}
		if(result1>0 && result2>0) {
			commit(con);
			result =1;
		}else {
			rollback(con);
		}
		return result;
	}

	public ArrayList<Review> selectMyReview(int m_no) {
		con = getConnection();
		ArrayList<Review> list = dao.selectMyReview(con, m_no);
		
		close(con);
		
		return list;
	}

	
}
