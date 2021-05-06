package com.harang.naduri.jdbc.admin.model.service;

import static com.harang.naduri.jdbc.common.JDBCTemplate.close;
import static com.harang.naduri.jdbc.common.JDBCTemplate.commit;
import static com.harang.naduri.jdbc.common.JDBCTemplate.getConnection;
import static com.harang.naduri.jdbc.common.JDBCTemplate.rollback;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;


import com.harang.naduri.jdbc.Thumbnail.model.vo.Thumbnail;
import com.harang.naduri.jdbc.Thumbnail.model.vo.lo_key;
import com.harang.naduri.jdbc.admin.model.dao.AdminDAO;
import com.harang.naduri.jdbc.attach.model.vo.Attach;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.location.model.vo.Location;
import com.harang.naduri.jdbc.review.model.vo.Review;
import com.harang.naduri.jdbc.spot.model.vo.Spot;
import com.harang.naduri.jdbc.Thumbnail.model.dao.ThumbnailDAO;


public class AdminService {

	// DB connection 변수 선언
	private Connection con;
	// DAO 생성
	private AdminDAO dao = new AdminDAO();
	
	

	// 맛집 등록 Service
	public int AdminFoodInsert(Spot s) {
			ArrayList<Attach>list = s.getAttList();
		
			// DB connection
			con = getConnection();
			
			
			
			int result2 = 0;
			int result3 = 0;
			int result4 = 0;
			
			// 1. LOCATION 테이블 데이터 생성
			int result1 = dao.insertLocation(con, s);

			// Debug
			System.out.println("location id 생성 성공 여부 : " + result1);
			
			
			// LOCATION 테이블이 잘 생성 되었다면
			if( result1 > 0 ) {
				commit(con);
				
				
				// 2. Locaiton ID 값 가져오기
				int l_no = dao.selectLno(con);
				
				// Debug
				System.out.println("location id 조회 성공 여부 : " + l_no);

				// l_no를 가져온 값이 있다면 commit
				if ( l_no < 0) {
					rollback(con);
				} else {
					commit(con);
					
					
					// Debug
					System.out.println("location id 결과값 확인 : " + l_no);
					
					// 3. 위에서 찾은 l_no와 Heritage 객체를 함께 insert Heritage
					result2 = dao.AdminFoodInsert(con, l_no, s);
					
					// 2. 최근 등록된 장소 정보 가져오기
					// result2의 결과값이 0이라면 rollback
					if( result2 > 0) {
					commit(con);
					int s_id =dao.getCurrentSid(con);
						
						for(int i=0; i< list.size(); i++) {
							list.get(i).setS_id(s_id);
						}

					// 3. 첨부 파일 저장

					for(int i = 0; i < list.size(); i++) {
						if(list.get(i) !=null && list.get(i).getA_name() !=null) {
							result3= dao.insertAttach(con,list.get(i));
							if(result3 ==0)break;
						}else {
							result3 =1;
						}
					}
					
					
					if(result2>0 && result3>0) {
						commit(con);
						result4 =1;
					}else {
						rollback(con);
					}
					return result4;
				}

					else rollback(con);
					} // 안쪽 if문 end
					commit(con);
				
			} // else end

			close(con);

			return result2;
			


		
	}

	// 여행지 서비스
	public int AdminSpotInsert(Spot s) {
		ArrayList<Attach>list = s.getAttList();
			
		// DB connection
		con = getConnection();
		
		
		
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;
		
		// 1. LOCATION 테이블 데이터 생성
		int result1 = dao.insertLocation(con, s);
	
		// Debug
		System.out.println("location id 생성 성공 여부 : " + result1);
		
		
		// LOCATION 테이블이 잘 생성 되었다면
		if( result1 > 0 ) {
			commit(con);
			
			
		// 2. Locaiton ID 값 가져오기
		int l_no = dao.selectLno(con);
		
		// Debug
		System.out.println("location id 조회 성공 여부 : " + l_no);
		
		// l_no를 가져온 값이 있다면 commit
		if ( l_no < 0) {
			rollback(con);
		} else {
			commit(con);
			
			
		// Debug
		System.out.println("location id 결과값 확인 : " + l_no);
		
		// 3. 위에서 찾은 l_no와 Heritage 객체를 함께 insert Heritage
		result2 = dao.AdminSpotInsert(con, l_no, s);
		
		// 2. 최근 등록된 장소 정보 가져오기
		// result2의 결과값이 0이라면 rollback
		if( result2 > 0) {
		commit(con);
		int s_id =dao.getCurrentSid(con);
			
			for(int i=0; i< list.size(); i++) {
				list.get(i).setS_id(s_id);
			}
			
		// 3. 첨부 파일 저장
			
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) !=null && list.get(i).getA_name() !=null) {
				result3= dao.insertAttach(con,list.get(i));
				if(result3 ==0)break;
			}else {
				result3 =1;
			}
		}
		
		
		if(result2>0 && result3>0) {
			commit(con);
			result4 =1;
		}else {
			rollback(con);
		}
		return result4;
		}
		
			else rollback(con);
			} // 안쪽 if문 end
			commit(con);
		
		} // else end
	
		close(con);
	
		return result2;
	}
}