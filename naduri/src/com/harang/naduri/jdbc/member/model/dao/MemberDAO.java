package com.harang.naduri.jdbc.member.model.dao;

import java.sql.*;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;
import com.harang.naduri.jdbc.member.model.vo.Member;

public class MemberDAO {

	public int insertMember(Connection con, Member joinMember) {
		// 실행 결과 추가된 행의 개수
		int result = 0;
		Statement st = null;
		
		try {
			st = con.createStatement();
			
			String sql = "";
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return result;
	}

}
