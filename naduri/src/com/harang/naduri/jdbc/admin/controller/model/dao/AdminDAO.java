package com.harang.naduri.jdbc.admin.controller.model.dao;

import static com.harang.naduri.jdbc.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.harang.naduri.jdbc.member.model.vo.Member;


public class AdminDAO {
	
	private Properties prop;
	
	public AdminDAO() {
		prop = new Properties();
		
		String filePath = AdminDAO.class.getResource("/config/admin.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	// 관리자 페이지  회원관리 부분
	public ArrayList<Member> memberList(Connection con) {
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("adminMember");
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Member m = new Member();
				
				m.setM_no(rs.getInt("m_no"));
				m.setM_id(rs.getString("m_id"));
				m.setM_name(rs.getString("m_name"));
				m.setM_phone(rs.getString("m_phone"));
				m.setM_email(rs.getString("m_email"));
				m.setM_status(rs.getString("m_status"));
				
				list.add(m);
				
			}
			
			System.out.println("조회 결과 : " + list);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(rs);
			close(ps);
		}
		
		return list;
	}
}
