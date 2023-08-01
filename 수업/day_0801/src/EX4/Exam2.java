package EX4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exam2 {
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
		String sql = "update login set logout_date = '20230730', logout_time = '152000' where member_id = 'user03'";

		// 4. Statement 생성
		PreparedStatement pstmt = con.prepareStatement(sql);

		// 5. 데이터 설정

		// 6. SQL 전송 및 결과 수신
		// DML전송 : executeUpdate() : int
		// SELECT전송 : executeQuery() : ResultSet
		int count = pstmt.executeUpdate();
		System.out.println(count + "행 수정");

		// 7. 자원 반환
		pstmt.close();
		con.close();
	}
}
