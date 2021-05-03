package com.harang.naduri.jdbc.Thumbnail.model.dao;

import static com.harang.naduri.jdbc.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.harang.naduri.jdbc.Thumbnail.model.vo.Attach;
import com.harang.naduri.jdbc.Thumbnail.model.vo.Thumbnail;
import com.harang.naduri.jdbc.Thumbnail.model.vo.Thumbnail2;
import com.harang.naduri.jdbc.heritage.model.vo.Heritage;
import com.harang.naduri.jdbc.location.model.vo.Location;

public class ThumbnailDAO {
	private Properties prop;
	
	public ThumbnailDAO() {
		prop = new Properties();
		
		String filePath = ThumbnailDAO.class
				          .getResource("/config/thumbnail.properties")
				          .getPath();
		
		try {
			prop.load( new FileReader(filePath));
			
		} catch (IOException e) {
		
			e.printStackTrace();
		} 
	}
	

	

	// �α��� �ѷ����� ��� ��ȸ  // 0503 spot & heritage & location & keyword ���� �߰�
	public HashMap<String, Object> selectList(Connection con) {
		// �ؽø� �غ�
		HashMap<String, Object> map = new HashMap<>();
		
		// ������ ������ ���� ���� ��ü
		ArrayList<Thumbnail> list = new ArrayList<>();
		// ÷������ ���� ��ü
		ArrayList<Attach> list2 = new ArrayList<>();
		// ��ȭ�� ���� ���� ��ü
		ArrayList<Heritage> listHeri = new ArrayList<>();
		// ��ҿ� Ű���� ���� ���� ��ü
		ArrayList<Location> lo_key = new ArrayList<>();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Thumbnail t = new Thumbnail();
				Attach a = new Attach();
				
				t.setSpot_id(      rs.getInt("spot_id"));
				t.setL_no(      rs.getInt("l_no"));
				t.setSpot_name(   rs.getString("spot_name"));
				t.setSpot_tel(  rs.getString("spot_tel"));
				t.setSpot_time(  rs.getString("spot_time"));
				t.setSpot_location(  rs.getString("spot_location"));
				t.setSpot_lat(  rs.getInt("spot_lat"));
				t.setSpot_long(  rs.getInt("spot_long"));
				t.setS_status(  rs.getString("s_status"));
				t.setSpot_count(  rs.getInt("spot_count"));
				t.setSpot_file(rs.getString("spot_file"));
				
				
				a.setAttach_name(rs.getString("a_name"));
				a.setSpot_id(rs.getInt("spot_id"));
				
				list2.add(a);
				
				if(list.contains(t)) {
					list.add(t);
				}
				
			}
			
			map.put("list", list); // �� ����
			map.put("list2", list2); // ���� ����
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);			

		}
		
		return map;
	}
	
	
	
	//-------------------- �˻� HASH MAP���� ���� �� �޾ƿ��� ----------------//
	// �α��� �ѷ����� ��� ��ȸ  // 0503 spot & heritage & location & keyword ���� �߰�
		public HashMap<String, Object> selectListCollection(Connection con, String spotName) {
			// �ؽø� �غ�
			HashMap<String, Object> map = new HashMap<>();
			
			// ������ ������ ���� ���� ��ü
			ArrayList<Thumbnail> list = new ArrayList<>();
			// ÷������ ���� ��ü
			ArrayList<Attach> list2 = new ArrayList<>();
			// ��ȭ�� ���� ���� ��ü
			ArrayList<Heritage> listHeri = new ArrayList<>();
			// ��ҿ� Ű���� ���� ���� ��ü
			ArrayList<Location> lo_key = new ArrayList<>();
			
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = prop.getProperty("selectListCollection");
			
			try {
				ps = con.prepareStatement(sql);
				
				ps.setString(1, spotName);
				ps.setString(2, spotName);
				
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Thumbnail t = new Thumbnail();
					Attach a = new Attach();
					Heritage h = new Heritage();
					Location l = new Location();
					
					
					// ����, ������ ���� ����
					t.setSpot_id(      rs.getInt("spot_id"));
					t.setL_no(      rs.getInt("l_no"));
					t.setSpot_name(   rs.getString("spot_name"));
					t.setSpot_tel(  rs.getString("spot_tel"));
					t.setSpot_time(  rs.getString("spot_time"));
					t.setSpot_location(  rs.getString("spot_location"));
					t.setSpot_lat(  rs.getInt("spot_lat"));
					t.setSpot_long(  rs.getInt("spot_long"));
					t.setS_status(  rs.getString("s_status"));
					t.setSpot_count(  rs.getInt("spot_count"));
					t.setSpot_file(rs.getString("spot_file"));
					
					
					// ÷������ ���� ����
					a.setAttach_name(rs.getString("a_name"));
					a.setSpot_id(rs.getInt("spot_id"));
					
					list2.add(a);
					
					// ��ȭ�� ���� ����
					h.setH_events(      rs.getString("h_events"));
					h.setH_serial(      rs.getString("h_serial"));
					h.setH_zipcode(      rs.getString("h_zipcode"));
					h.setH_name(      rs.getString("h_name"));
					
					listHeri.add(h);
					
					// ��ҿ� Ű���� ���� ����
					l.setL_no(rs.getInt("l_no"));
					l.setLs_code(rs.getInt("ls_code"));
					l.setKeyword_id(rs.getInt("keyword_id"));
					l.setKeyword(rs.getString("keyword"));
					
					lo_key.add(l);
					
					
					if(list.contains(t)) {
						list.add(t);
					}
					
				}
				
				map.put("list", list); // ����, ������ ���� ����
				map.put("list2", list2); // ÷������ ���� ����
				map.put("listHeri", listHeri); // ����, ������ ���� ����
				map.put("lo_key", lo_key); // ÷������ ���� ����
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				close(rs);
				close(ps);			

			}
			
			return map;
		}
	
		
		
		
		// ------------------------------------------------------------------- //
		
		
		
		
		
		
		
		
		
		
		
		
	
	//----------------------- �˻��� ���� 3�ܰ� -------------------------//
	// 1. ��� �ڵ� ��ȸ (����� �Է� ���� ���� l_no, ls_code�� �޾ư���.)
		public ArrayList<Location> selectLocationCode(Connection con, String spotName) {
			// �Խñ� �ڵ� ������ �� ����Ʈ �غ� 
			ArrayList<Location> list = new ArrayList();
			// ��� ��ü �غ�
			Location location = new Location();

			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = prop.getProperty("selectLocationCode");
			
			try {
				
				ps = con.prepareStatement(sql);
				
				ps.setString(1, spotName);
				ps.setString(2, spotName);
				
				rs = ps.executeQuery();

				
				while(rs.next()) {
					Location l = new Location();
					
					l.setL_no( rs.getInt("l_no"));
					l.setLs_code( rs.getInt("ls_code"));
					l.setL_no( rs.getInt("l_no"));
					l.setLs_code( rs.getInt("ls_code"));
					
					list.add(l);
					
					System.out.println(list);
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				close(rs);
				close(ps);			

			}
			
			return list;
		}




	// 2. ��� �ڵ忡 ���� l_no ��ȸ 
		
	// ����� �Է� ���� �޾Ƽ� ls_code, l_no �޾ư���.
	public HashMap<String, Object> selectThumnail(Connection con, String spotName) {
		
			// �ؽø� �غ�
			HashMap<String, Object> map = new HashMap<>();
			// �Խñ� ���� ��ü
			ArrayList<Thumbnail> list = new ArrayList<>();
			// ÷������ ���� ��ü
			ArrayList<Attach> list2 = new ArrayList<>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = prop.getProperty("selectList");
			
			try {
				ps = con.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Thumbnail t = new Thumbnail();
					Attach a = new Attach();
					
					t.setSpot_id(      rs.getInt("spot_id"));
					t.setL_no(      rs.getInt("l_no"));
					t.setSpot_name(   rs.getString("spot_name"));
					t.setSpot_tel(  rs.getString("spot_tel"));
					t.setSpot_time(  rs.getString("spot_time"));
					t.setSpot_location(  rs.getString("spot_location"));
					t.setSpot_lat(  rs.getInt("spot_lat"));
					t.setSpot_long(  rs.getInt("spot_long"));
					t.setS_status(  rs.getString("s_status"));
					t.setSpot_count(  rs.getInt("spot_count"));
					t.setSpot_file(rs.getString("spot_file"));
					
					
					a.setAttach_name(rs.getString("a_name"));
					a.setSpot_id(rs.getInt("spot_id"));
					
					list2.add(a);
					
					if(list.contains(t)) {
						list.add(t);
					}
					
				}
				
				map.put("list", list); // �� ����
				map.put("list2", list2); // ���� ����
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				close(rs);
				close(ps);			

			}
			
			return map;
		}

	





	public HashMap<String, Object> selectThumnailOne(Connection con, int l_no2) {
		// �ؽø� �غ�
		HashMap<String, Object> map = new HashMap<>();
		
		// ������ ������ ���� ���� ��ü
		ArrayList<Thumbnail> list = new ArrayList<>();
		// ÷������ ���� ��ü
		ArrayList<Attach> list2 = new ArrayList<>();
		// ��ȭ�� ���� ���� ��ü
		ArrayList<Heritage> listHeri = new ArrayList<>();
		// ��ҿ� Ű���� ���� ���� ��ü
		ArrayList<Location> lo_key = new ArrayList<>();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectListCollection");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, l_no2);
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Thumbnail t = new Thumbnail();
				Attach a = new Attach();
				Heritage h = new Heritage();
				Location l = new Location();
				
				
				// ����, ������ ���� ����
				t.setSpot_id(      rs.getInt("spot_id"));
				t.setL_no(      rs.getInt("l_no"));
				t.setSpot_name(   rs.getString("spot_name"));
				t.setSpot_tel(  rs.getString("spot_tel"));
				t.setSpot_time(  rs.getString("spot_time"));
				t.setSpot_location(  rs.getString("spot_location"));
				t.setSpot_lat(  rs.getInt("spot_lat"));
				t.setSpot_long(  rs.getInt("spot_long"));
				t.setS_status(  rs.getString("s_status"));
				t.setSpot_count(  rs.getInt("spot_count"));
				t.setSpot_file(rs.getString("spot_file"));
				
				
				// ÷������ ���� ����
				a.setAttach_name(rs.getString("a_name"));
				a.setSpot_id(rs.getInt("spot_id"));
				
				list2.add(a);
				
				// ��ȭ�� ���� ����
				h.setH_events(      rs.getString("h_events"));
				h.setH_serial(      rs.getString("h_serial"));
				h.setH_zipcode(      rs.getString("h_zipcode"));
				h.setH_name(      rs.getString("h_name"));
				
				listHeri.add(h);
				
				// ��ҿ� Ű���� ���� ����
				l.setL_no(rs.getInt("l_no"));
				l.setLs_code(rs.getInt("ls_code"));
				l.setKeyword_id(rs.getInt("keyword_id"));
				l.setKeyword(rs.getString("keyword"));
				
				lo_key.add(l);
				
				
				if(list.contains(t)) {
					list.add(t);
				}
				
			}
			
			map.put("list", list); // ����, ������ ���� ����
			map.put("list2", list2); // ÷������ ���� ����
			map.put("listHeri", listHeri); // ����, ������ ���� ����
			map.put("lo_key", lo_key); // ÷������ ���� ����
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);			

		}
		
		return map;
	}



}
