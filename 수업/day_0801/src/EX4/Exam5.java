package EX4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam5 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. JDBC driver 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("JDBC Driver 로딩 성공");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/XE";
		String user = "HR";
		String password = "hr";

		// 2. DBMS 연결
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("DBMS 로그인 성공");

		// 3. SQL 작성
		String sql = "select l.member_id, l.login_date, l.login_time, l.logout_date, l.logout_time, m.name from login l join members m on l.member_id = m.id";

		// 4. Statement 생성
		PreparedStatement pstmt = con.prepareStatement(sql);

		// 5. 데이터 설정

		// 6. SQL 전송 및 결과 수신
		// DML전송 : executeUpdate() : int
		// SELECT전송 : executeQuery() : ResultSet
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			String member_id = rs.getString("member_id");
			String login_date = rs.getString("login_date");
			String login_time = rs.getString("login_time");
			String logout_date = rs.getString("logout_date");
			String logout_time = rs.getString("logout_time");
			String name = rs.getString("name");
			System.out.println(member_id + "," + login_date + "," + login_time + "," + logout_date + "," + logout_time
					+ "," + name);
		}

		// 7. 자원 반환
		pstmt.close();
		con.close();
	}
}
