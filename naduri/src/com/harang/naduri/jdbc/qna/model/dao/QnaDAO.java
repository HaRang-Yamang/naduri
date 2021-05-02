package com.harang.naduri.jdbc.qna.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.harang.naduri.jdbc.qna.model.vo.Qna;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;
public class QnaDAO {
private Properties prop;
public QnaDAO() {
	prop = new Properties();
	String filePath = QnaDAO.class
			.getResource("/config/qna.properties").getPath();
	try {
		prop.load(new FileReader(filePath));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public int insertQna(Connection con, Qna qn) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertQna");
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, qn.getM_no());
			ps.setString(2, qn.getQ_content());
			ps.setString(3, qn.getQ_title());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}

}
