package com.harang.naduri.jdbc.member.model.dao;

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
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.member.model.vo.Keyword;
import com.harang.naduri.jdbc.review.model.dao.ReviewDAO;
import com.harang.naduri.jdbc.spot.model.vo.Spot;

public class ToGoListDAO {
	private Properties prop;
	
	public ToGoListDAO() {
		prop= new Properties();
		String filePath = ReviewDAO.class
		          .getResource("/config/togolist.properties")
		          .getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public HashMap<String, Object> togolist(Connection con, int m_no) {
		HashMap<String, Object> map = new HashMap<>();
		ArrayList<Keyword> listk = new ArrayList<>();
		ArrayList<Attach> lista = new ArrayList<>();
		ArrayList<Spot> lists = new ArrayList<>();
		ArrayList<Heritage> listh = new ArrayList<>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectTogolist");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, m_no);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Attach a = new Attach();
				
				a.setA_name(rs.getString("a_name"));
				a.setL_no(rs.getInt("l_no"));
				
				lista.add(a);
				
				Keyword k = new Keyword();
				
				listk.add(k);
				
				k.setKeyword(rs.getString("keyword"));
				
				listk.add(k);
				
				
				/*
				if(a.getL_no() != rs.getInt("l_no")) {
					
					Spot s = new Spot();
					s.setS_name(rs.getString("s_name"));
					s.setL_no(rs.getInt("l_no"));
					
					lists.add(s);
					
					Heritage h = new Heritage();
					h.setH_name(rs.getString("h_name"));
					h.setL_no(rs.getInt("l_no"));
					
					listh.add(h);
				
					
				}
				*/
			}
				
				map.put("lista", lista);
				map.put("listk", listk);
				map.put("lists", lists);
				map.put("listh", listh);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		
		
		return map;
	}

}
