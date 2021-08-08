package com.harang.naduri.jdbc.member.model.service;

import java.sql.Connection;

import com.harang.naduri.jdbc.member.model.dao.MemberDAO;
import com.harang.naduri.jdbc.member.model.vo.Keyword;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

public class KeywordService {
	
	private Connection con;
	private MemberDAO dao = new MemberDAO();

	// DB의 mchoice 테이블에 result 값이 0 이상일 시 commit
	public int insertKeyword(String m_id, String[] keyword_id) {

		con = getConnection();
		
		// m_no 값은 MemberDAO.java 내의 selectMno 함수를 통해 찾아온다.
		int m_no = new MemberDAO().selectMno(con, m_id);
		
		int result = 0;
		if( m_no == 0 ||  keyword_id.length <= 0 ) {
			// 입력된 keyword 값이 없을 시에는 rollback 실행
			rollback(con);
		} else {
			for (int i = 0 ; i < keyword_id.length ; i++ ) {
				// 입력된 keyword_id 배열의 시작부터 끝까지 이하 문구가 반복됨
				// key = m_no와 keyword_id 배열을 차례대로
				// result = KeywordDAO 클래스의 insertKeyword 함수(sql 입력 함수)가 작동되는 횟수
				Keyword key = new Keyword(m_no, Integer.parseInt(keyword_id[i]));
				
				result = dao.insertKeyword(con, key);
				
				// result가 0일 시 입력된 정보값이 없으므로 rollback 실행
				if(result == 0) { 
					rollback(con);
					break;
				}
			}
			
			// result 값이 0이 아닐 시 insertKeyword 함수가 commit됨
			commit(con);
		}
		
		// DB와의 연결을 끊는다
		close(con);
		
		// insertKeyword 함수가 작동된 횟수가 return
		return result;
	}

}
