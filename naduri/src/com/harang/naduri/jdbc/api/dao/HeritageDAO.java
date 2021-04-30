package dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import vo.Heritage;



public class HeritageDAO {

	private Properties prop;
	
	public HeritageDAO() {
		prop = new Properties();
		
		String filePath = HeritageDAO.class
						  .getResource("/config/board.properties")
						  .getPath();
		
		try {
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public ArrayList<Heritage> selectList(Connection con, int currentPage) {
		ArrayList<Heritage> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");
		
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, endRow);
			ps.setInt(2, startRow);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Board b = new Board();
				
				b.setBno( rs.getInt("bno") );
				b.setBtype( rs.getInt("btype"));
				b.setBtitle(rs.getString("btitle"));
				b.setBcontent(rs.getString("bcontent"));
				b.setBwriter( rs.getString("username"));
				b.setUserId( rs.getString("bwriter"));
				b.setBcount( rs.getInt("bcount"));
				b.setBdate( rs.getDate("bdate"));
				b.setBoardfile(rs.getString("boardfile"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}

	

}









