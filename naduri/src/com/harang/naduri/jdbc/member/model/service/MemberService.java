package com.harang.naduri.jdbc.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.harang.naduri.jdbc.member.model.dao.MemberDAO;
import com.harang.naduri.jdbc.member.model.vo.Member;
import com.harang.naduri.jdbc.notice.model.vo.Notice;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

/*
 * controller에서 전달한 정보를 받아서 전달
 * */

public class MemberService {
	
	private Connection con;
	private MemberDAO dao = new MemberDAO();
	
	// 회원 가입
	public int insertMember(Member joinMember) {
		
		con = getConnection();
		
		int result = dao.insertMember(con, joinMember);
		
		if( result <= 0 ) {
			rollback(con);
		} else {
			commit(con);
		}
		
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
	
	// 관리자 회원관리 리스트
	public ArrayList<Member> memberList() {
		con = getConnection();
		
		ArrayList<Member> list = dao.memberList(con);
		
		close(con);
		
		return list;
	}
	
	// 관리자페이지 회원정보 수정 리스트
	public int MemberUpdateList(int m_no, String m_status) {
		con = getConnection();
		
		int result = 0;
		
		//만약 m_status가 y이면 n으로 바꾸고
		// else if m_status가 n이라면 y로 바꿔라
		if(m_status.equals("Y")) {
			m_status = "N";
		} else {
			m_status = "Y";
		}
		result = dao.memberUpdateList(con, m_no, m_status);
		
		 if(result > 0) commit(con);
		 else rollback(con);
		
		close(con);
		
		return result;
	}



	

}
