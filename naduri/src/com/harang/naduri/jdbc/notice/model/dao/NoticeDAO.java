package com.harang.naduri.jdbc.notice.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.harang.naduri.jdbc.notice.model.vo.Notice;
import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

public class NoticeDAO {

	private Properties prop;
	
	public NoticeDAO() {
		prop = new Properties();
		
		String filePath = NoticeDAO.class
						.getResource("/config/notice.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public ArrayList<Notice> selectList(Connection con) {
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Notice n = new Notice();
				
				n.setN_no(rs.getInt("n_no"));
				n.setN_title(rs.getString("n_title"));
				n.setN_content(rs.getString("n_content"));
				n.setN_date(rs.getDate("n_date"));
				
				list.add(n);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}

	public int insertNotice(Connection con, Notice n) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("noticeWrite");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, n.getN_title());
			ps.setString(2, n.getN_content());
			ps.setString(3, n.getN_file());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			close(ps);
		}
		
		
		return result;
	}

	public Notice selectOne(Connection con, int n_no) {
		
		Notice n = null;	// 게시물의 번호를 받아줘야하니까 공간 만들어주기
		PreparedStatement ps = null;	// properties에서 ?로 받아올거니까 ps선언해주고
		ResultSet rs = null;	// 데이터베이스에서 결과를 가져오니까 rs 공간 만들어즘
		
		String sql = prop.getProperty("selectOne");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, n_no);
			
			rs = ps.executeQuery();
			
			// 데이터를 가져올 때 머리글도 가져오기 때문에 .next로 가져옴!
			if(rs.next()) {
				n = new Notice();
				
				n.setN_no(n_no);
				n.setN_title(rs.getString("n_title"));
				n.setN_content(rs.getString("n_content"));
				n.setN_date(rs.getDate("n_date"));
				n.setM_no(rs.getInt("m_no"));
				n.setN_file(rs.getString("n_file"));
				
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return n;
	}

}
