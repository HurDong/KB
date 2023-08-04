package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {

	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "HR"; // hr이였지만 위 컴퓨터에서는 HR로 세팅되어있습니다.
	private static String pwd = "hr"; // HR이였지만 위 컴퓨터에서는 hr로 세팅되어있습니다.

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void releaseConnection(PreparedStatement pstmt, Connection con) {

		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void releaseConnection(ResultSet rs, PreparedStatement pstmt, Connection con) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ... 표현식 사용
	public void releaseConnection(AutoCloseable... params) {
		for (AutoCloseable c : params) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
