package hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospital.dto.HospitalEmployeeDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;
import hospital.util.JdbcUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void add(HospitalEmployeeDto e) throws SQLException, DuplicatedIdException {
		// DBMS 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 등록여부 검사
			if (findById(e.geteId()) != null)
				throw new DuplicatedIdException(e.geteId() + " 는 사용중입니다.");

			con = JdbcUtil.connect();
			// 3.SQL 작성
			String sql = "INSERT INTO Hospital_Employee(e_id, d_id, name, employee_code, phone_number) ";
			sql += "VALUES(HOSPITAL_EMPLOYEE_SEQ.NEXTVAL,?,?,?,?)"; // ''안붙이면 안됨. ''까지 포함한 것이 데이터 -> 문자열이므로

			// 4.Statement 생성 -> 쿼리전송 및 결과수신 > Connection을 통해 연결됨
			pstmt = con.prepareStatement(sql);

			// 5.데이터 설정
			pstmt.setInt(1, e.getdId());
			pstmt.setString(2, e.getName());
			pstmt.setInt(3, e.getEmpCode());
			pstmt.setString(4, e.getPhoneNumber());

			// 6.SQL 전송, 결과수신
			// -DML(insert/update/delet) 전송 : executeUpdate() : int 반환
			// -Select 전송 : executeQuery() : ResultSet 반환
			int count = pstmt.executeUpdate();
		} catch (ClassNotFoundException x) {
			throw new SQLException(x);
		} // 결과적으로 con 이 나옴
		finally {
			/*
			 * // 7. 자원반환 pstmt.close(); con.close();
			 */
			JdbcUtil.close(pstmt, con);
		}
	}

	@Override
	public void update(HospitalEmployeeDto e) throws SQLException, RecordNotFoundException {

		// DBMS 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			if (findById(e.geteId()) == null)
				throw new RecordNotFoundException(e.geteId() + "는 없습니다.");
			con = JdbcUtil.connect();

			// 3. SQL 작성
			String sql = "UPDATE Hospital_Employee SET name =?, phone_number=?";
			sql += " where e_id = ?";

			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);

			// 5. 데이터 설정
			pstmt.setString(1, e.getName());
			pstmt.setString(2, e.getPhoneNumber());
			pstmt.setInt(3, e.geteId());

			// 6. SQL 전송, 결과 수신
			int count = pstmt.executeUpdate();
		} catch (ClassNotFoundException x) {
			throw new SQLException(x);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
	}

	@Override
	public void delete(int id) throws SQLException, RecordNotFoundException {
		// DBMS연결
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 등록여부검사
			if (findById(id) == null)
				throw new RecordNotFoundException(id + "는 없습니다");

			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "DELETE Hospital_Employee ";
			sql += "WHERE e_id = ?";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setInt(1, id);
			// 6. SQL 전송, 결과수신
			int count = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}

	}

	@Override
	public int count() throws SQLException {
		int count = 0;
		// DBMS연결
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT count(*) FROM Hospital_Employee ";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			// 6. SQL 전송, 결과수신
			// DML전송: executeUpdate() : int
			// SELECT전송: executeQuery() : ResultSet
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		return count;
	}

	@Override
	public List<HospitalEmployeeDto> list() throws SQLException {
		List<HospitalEmployeeDto> result = new ArrayList<HospitalEmployeeDto>();
		// DBMS연결
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM Hospital_Employee order by e_id";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			// 6. SQL 전송, 결과수신
			// DML전송: executeUpdate() : int
			// SELECT전송: executeQuery() : ResultSet
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {// 조회결과가 있다
				int e_id = rs.getInt("e_id");
				String name = rs.getString("name");
				int employee_code = rs.getInt("employee_code");
				String phone_number = rs.getString("phone_number");
				int d_id = rs.getInt("d_id");
				HospitalEmployeeDto dto = new HospitalEmployeeDto(e_id, d_id, name, employee_code, phone_number);
				result.add(dto);
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		return result;
	}

	@Override
	public HospitalEmployeeDto findById(int id) throws SQLException {
		HospitalEmployeeDto dto = null;
		// DBMS연결
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM Hospital_Employee where e_id = ?";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setInt(1, id);
			// 6. SQL 전송, 결과수신
			// DML전송: executeUpdate() : int
			// SELECT전송: executeQuery() : ResultSet
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {// 조회결과가 있다
				int e_id = rs.getInt("e_id");
				String name = rs.getString("name");
				int employee_code = rs.getInt("employee_code");
				String phone_number = rs.getString("phone_number");
				int d_id = rs.getInt("d_id");
				dto = new HospitalEmployeeDto(e_id, d_id, name, employee_code, phone_number);
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		return dto;
	}

}
