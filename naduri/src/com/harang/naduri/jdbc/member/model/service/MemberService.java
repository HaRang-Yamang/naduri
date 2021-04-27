package com.harang.naduri.jdbc.member.model.service;

import java.sql.Connection;

import com.harang.naduri.jdbc.member.model.dao.MemberDAO;
import com.harang.naduri.jdbc.member.model.vo.Member;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

public class MemberService {

	private Connection con;
	private MemberDAO dao = new MemberDAO();
	
	public int insertMember(Member joinMember) {
		
		con = getConnection();
		
		// 회원 가입 저장
		int result1 = dao.insertMember(con, joinMember);
		
		if( result1 > 0 ) {
			
		} else {
			commit(con);	
		}
		
		close(con);		
		
		return result1;
	}
	
	// 키워드 저장
}
