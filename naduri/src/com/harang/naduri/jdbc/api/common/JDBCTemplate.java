package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			//  getConnection( 占쎌궎占쎌뵬占쎄깻占쎄퐣甕곌폔rl, 占쎄텢占쎌뒠占쎌쁽�④쑴�젟, �뜮袁⑨옙甕곕뜇�깈 );
			con = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe", 
							"NADURI", "NADURI");
			
			con.setAutoCommit(false); 
			// 占쎈퓠占쎌쑎 占쎈연�겫占쏙옙占� �꽴占썸�④쑴毓억옙�뵠 占쎌쁽占쎈짗 �뚣끇而좑옙釉�占쎈뮉 野껉퍔�뱽 獄쎻뫗占�
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		
		return con;
	}
	
	// 占쎌궎甕곌쑬以덌옙逾� 占쎌읅占쎌뒠占쎈릭疫뀐옙
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
		// 癰귨옙野껋럩沅쀯옙鍮� 占쏙옙占쎌삢 筌롫뗄�꺖占쎈굡
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		// 癰귨옙野껋럩沅쀯옙鍮� �뿆�뫁�꺖 筌롫뗄�꺖占쎈굡
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
