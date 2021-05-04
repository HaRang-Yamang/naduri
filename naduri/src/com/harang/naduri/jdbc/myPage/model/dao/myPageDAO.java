package com.harang.naduri.jdbc.myPage.model.dao;

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

import com.harang.naduri.jdbc.attach.model.vo.Attach;
import com.harang.naduri.jdbc.member.model.vo.Keyword;

public class myPageDAO {
	
	private Properties prop;
	public myPageDAO() {
		
		prop = new Properties();
		
		String filePath = myPageDAO.class
				          .getResource("/config/profileImg.properties")
				          .getPath();
		
		try {
			prop.load( new FileReader(filePath));
			
		} catch (IOException e) {
		
			e.printStackTrace();
		} 
	}

	public Attach myPageView(Connection con, int m_no) {
		Attach a = null;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("viewProfileImg");
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, m_no);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				a = new Attach();
				
				a.setA_name( rs.getString("a_name"));
				a.setM_no( rs.getInt("m_no") );
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return a;
	}

	public ArrayList<Keyword> myPageKeyword(Connection con, int m_no) {
		ArrayList<Keyword> listk = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("viewProfile");
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, m_no);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Keyword k = new Keyword();
				
				k.setKeyword_id(rs.getInt("keyword_id"));
				k.setKeyword(rs.getString("keyword"));
				listk.add(k);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return listk;
	}

}
