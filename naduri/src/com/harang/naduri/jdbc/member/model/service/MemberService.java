package com.harang.naduri.jdbc.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.harang.naduri.jdbc.admin.controller.model.dao.AdminDAO;
import com.harang.naduri.jdbc.member.model.dao.MemberDAO;
import com.harang.naduri.jdbc.member.model.vo.Keyword;
import com.harang.naduri.jdbc.member.model.vo.Member;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

/*
 * controller에서 전달한 정보를 받아서 전달
 * */

public class MemberService {
	
	private Connection con;
	private MemberDAO dao = new MemberDAO();
	private AdminDAO aDao = new AdminDAO();
	
	// 회원 가입
	public int insertMember(Member joinMember, String[] keyword_id) {
	
		con = getConnection();
		
		// 1. 기본 정보 저장
		int result1 = dao.insertMember(con, joinMember);
		
		// MemberDAO의 insertMember sql 구문이 한 번 이상 작동 됐다면
		if( result1 > 0 ) {
			
			commit(con);
			
			// m_no의 값을 MemberDAO의 selectMno 함수를 통해 찾아온다.
			int m_no = dao.selectMno(con, joinMember.getM_id());
			
			// m_no의 값이 0이거나 keyword_id 배열의 길이가 0 이하라면 롤백.
			if(keyword_id.length <= 0) {
				rollback(con);
			}
			// 2. m_no 값이 0 이상이라면, MCHOICE 테이블에
			//		입력된 관심사(String[] keyword_id)를 저장하기 위한 sql 구문이 동작한다
			else if ( m_no > 0 ) {
				
				// result2의 초기값은 0
				int result2 = 0;
				// Keyword key = new Keyword();
				
				// 입력된 keyword_id 배열의 처음부터 끝까지 이하의 구문을 반복
				for( int i = 0 ; i < keyword_id.length ; i++ ) {
					
					// key = m_no와 keyword_id 배열을 차례대로 사용 하여
					// KeywordDAO 클래스의 insertKeyword 함수(sql 입력 함수)가 작동되는 횟수는 result2
					Keyword key = new Keyword(m_no, Integer.parseInt(keyword_id[i]));
//					key.setM_no(m_no);
//					key.setKeyword_id(i);
					
					result2 = dao.insertKeyword(con, key);
					
					commit(con);
			
					// result2의 결과값이 0이라면 rollback
					if(result2 == 0) {
						rollback(con);
						break;
					}
					commit(con);
				}
			}	// MCHOICE 테이블에 SQL 입력이 끝나고
	
		}	// MEMBER 테이블에 데이터 입력이 끝난 뒤에
		
		close(con);
		
		return result1;
	}
	
	
	
	// 중복 아이디 검색
	public int idCheck(String m_id) {
		con = getConnection();
		
		int result = dao.idCheck(con, m_id);
		
		close(con);
		return result;
	}
	
	
	// 로그인
	public Member selectMember(Member loginMember) {
		
		con = getConnection();
		
		Member result = dao.selectMember(con, loginMember);
		
		close(con);
		
		return result;
		
	}

	
	// 회원 수정
	public int updateMember(Member updateMember) {
		
		con = getConnection();

		int result1 = dao.updateMember(con, updateMember);

		// updateMember 정보를 가지고 MemberDAO의 updateMember가 한 번 이상 시행 됐다면 커밋
		if(result1 > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return result1;
	}

	
	// 회원 삭제
	public int deleteMember(String m_id) {
		
		con = getConnection();
		
		int result = dao.deleteMember(con, m_id);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return result;
	}


	public ArrayList<Member> memberList() {
		con = getConnection();
		
		ArrayList<Member> list = aDao.memberList(con);
		
		close(con);
		
		return list;
	}

	

}
