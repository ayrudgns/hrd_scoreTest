package jdbc.utll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleConnectionUill {
	public static Connection connect() {
		Connection con = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";  
		String driver = "oracle.jdbc.driver.OracleDriver";     
		String user = "C##IDEV";				
		String password = "1234";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("db 연결 오류 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		}
		return con;
	}
	
	public static void close(Connection con, PreparedStatement pstmt) {
		try {
			if(con != null) {
				con.close();
			}
			
			if(pstmt != null) {
				pstmt.close();			
			}
		} catch (SQLException e) {
			System.out.println("close 오류 : " + e.getMessage());
		}
	}
	
}
