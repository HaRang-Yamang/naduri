package com.harang.naduri.jdbc.member.model.dao;

import java.sql.*;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;
import com.harang.naduri.jdbc.member.model.vo.Keyword;

public class KeywordDAO {

	public int insertKeyword(Connection con, Keyword joinKeyword) {
		
		int result = 0;
		Statement st = null;
		
		try {
			st = con.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}

}
