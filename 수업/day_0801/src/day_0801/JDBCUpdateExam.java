package day_0801;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*
 * JDBC 코딩순서
 * 0. 사용 하려는 DBMS의 jdbc드라이버 파일을 classpath에 등록
 * 1. import java.sql.*
 * 2. 드라이버로딩 Class.forName("드라이버 클래스 전체이름")
 * 3. DBMS 연결 : DriverManager.getConnection("jdbc프로토콜","ID","비번")
 * 4. Statement 생성 : SQL 전송 및 결과 수신
 * 	  Statement / PreparedStatement / CallableStatement
 * 5. SQL 전송, 결과, 수신
 *    DML 전송하면 적용된 행의 갯수 변환 : INSERT, UPDATE, DELETE
 *    SELECT 전송하면 ResultSet 반환(결과없음, 값1, 1개열, 1개행, 여러행 여러열)
 *    결과처리(값 추출)
 * 6. 자원닫기(사용의 역순)
 *    ResultSet.close(), Statement.close(), Connection.close()
*/

public class JDBCUpdateExam {
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
		String sql = "update members set status = ?";
		sql+= "where id = ?";
		// 4. Statement 생성
		PreparedStatement pstmt = con.prepareStatement(sql);

		// 5. 데이터 설정
		pstmt.setString(1, "Y");
		pstmt.setString(2, "user05");

		// 6. SQL 전송 및 결과 수신
		// DML전송 : executeUpdate() : int
		// SELECT전송 : executeQuery() : ResultSet
		int count = pstmt.executeUpdate();
		System.out.println(count + "행 수정완료");

		// 7. 자원 반환
		pstmt.close();
		con.close();
	}
}
