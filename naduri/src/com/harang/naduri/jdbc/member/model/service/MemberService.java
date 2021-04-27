package com.harang.naduri.jdbc.member.model.service;

import java.sql.Connection;
import static com.harang.naduri.jdbc.common.JDBCTemplate.close;

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
			int m_no = dao.getCurrentM_no(con);
			
			for(int i = 0 ; i < list.size(); i++) {
				list.get(i).setM_no(m_no);
			}
		}
		
		// 키워드 저장
		
		int result2 = 0;
		
		for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i) != null && list.get(i).getKeyword() != null) {
				
			}
		}

	}
	

}
