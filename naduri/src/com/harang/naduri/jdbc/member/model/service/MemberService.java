package com.harang.naduri.jdbc.member.model.service;

import java.sql.Connection;

import com.harang.naduri.jdbc.member.model.dao.MemberDAO;
import com.harang.naduri.jdbc.member.model.vo.Member;
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

}
