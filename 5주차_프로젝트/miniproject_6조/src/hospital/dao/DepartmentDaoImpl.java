package hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospital.dto.HospitalDepartmentDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;
import hospital.util.JdbcUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public void add(HospitalDepartmentDto dto) throws SQLException, DuplicatedIdException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "INSERT INTO Hospital_Department(d_id, department_name, manager_id) VALUES(Hospital_Department_SEQ.NEXTVAL, ?, ?)";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setString(1, dto.getDepartmentName());
			pstmt.setInt(2, dto.getMangerId());
			// 6. SQL 전송, 결과수신
			int count = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}

	}

	@Override
	public void update(HospitalDepartmentDto d) throws SQLException, RecordNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			if (findById(d.getdId()) == null)
				throw new RecordNotFoundException(d.getdId() + "는 없습니다.");
			con = JdbcUtil.connect();

			// 3. SQL 작성
			String sql = "UPDATE Hospital_Department SET department_name =?, manager_id=? ";
			sql += " where d_id = ?";

			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);

			// 5. 데이터 설정
			pstmt.setString(1, d.getDepartmentName());
			pstmt.setInt(2, d.getMangerId());
			pstmt.setInt(3, d.getdId());

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
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 등록여부검사
			if (findById(id) == null)
				throw new RecordNotFoundException(id + "는 없습니다");

			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "DELETE FROM Hospital_Department WHERE d_id = ?";
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
			String sql = "SELECT count(*) FROM Hospital_Department ";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			// 6. SQL 전송, 결과수신

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
	public List<HospitalDepartmentDto> list() throws SQLException {
		List<HospitalDepartmentDto> result = new ArrayList<HospitalDepartmentDto>();
		// DBMS연결
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM Hospital_Department ";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 6. SQL 전송, 결과수신
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {// 조회결과가 있다
				int d_id = rs.getInt("d_id");
				String department_name = rs.getString("department_name");
				int manager_id = rs.getInt("manager_id");
				HospitalDepartmentDto dto = new HospitalDepartmentDto(d_id, department_name, manager_id);
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
	public HospitalDepartmentDto findById(int id) throws SQLException {
		HospitalDepartmentDto dto = null;
		// DBMS연결
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM Hospital_Department WHERE d_id = ?";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setInt(1, id);
			// 6. SQL 전송, 결과수신
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {// 조회결과가 있다
				int d_id = rs.getInt("d_id");
				String department_name = rs.getString("department_name");
				int manager_id = rs.getInt("manager_id");
				dto = new HospitalDepartmentDto(d_id, department_name, manager_id);
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		return dto;
	}

}
