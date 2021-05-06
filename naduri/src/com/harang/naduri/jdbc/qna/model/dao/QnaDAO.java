package com.harang.naduri.jdbc.qna.model.dao;

import static com.harang.naduri.jdbc.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.harang.naduri.jdbc.member.model.vo.Member;
import com.harang.naduri.jdbc.qna.model.vo.Qna;
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
	public ArrayList<Qna> SelectQnaList(Connection con) {
		ArrayList<Qna>list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectQnaList");
		
		try {
			ps= con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Qna q = new Qna();
				q.setQ_title(rs.getString("q_title"));
				q.setQ_content(rs.getString("q_content"));
				q.setQ_date(rs.getDate("q_date"));
				q.setM_id(rs.getString("m_id"));
				list.add(q);
				System.out.println(list);
			}
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return list;
	}
	public ArrayList<Qna> SelectMyQnaList(Connection con, int m_no) {
		ArrayList<Qna>list = new ArrayList<>();
		Member m = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectMyQnaList");
		
		try {
			ps= con.prepareStatement(sql);
			
			ps.setInt(1, m.getM_no());
	
			rs = ps.executeQuery();
			while(rs.next()) {
				Qna q = new Qna();
				q.setQ_title(rs.getString("q_title"));
				q.setQ_content(rs.getString("q_content"));
				q.setQ_date(rs.getDate("q_date"));
				q.setM_id(rs.getString("m_id"));
				list.add(q);
				
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return list;
	}

}
