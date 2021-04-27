package com.harang.naduri.jdbc.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.harang.naduri.jdbc.member.model.vo.Keyword;

public class KeywordDAO {
	
	public int insertKeyword(Connection con, Keyword joinKeyword) {
		
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO MCHOICE VALUES "
						+ "(SEQ_M_NO.NEXTVAL, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			
			//ps.setString(1, joinKeyword.getKeyword_id());
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}

}
