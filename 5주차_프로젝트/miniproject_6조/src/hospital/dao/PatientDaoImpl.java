package hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospital.dto.PatientDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;
import hospital.util.JdbcUtil;

public class PatientDaoImpl implements PatientDao {

	@Override
	public void add(PatientDto p) throws SQLException, DuplicatedIdException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 등록여부검사
			if (findById(p.getpId()) != null)
				throw new DuplicatedIdException(p.getpId() + "는 이미 존재하는 환자입니다.");

			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "INSERT INTO PATIENT(p_id, name, birth, gender, phone_number, address)";
			sql += "VALUES(PATIENT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getBirth());
			pstmt.setString(3, p.getGender());
			pstmt.setString(4, p.getPhoneNumber());
			pstmt.setString(5, p.getAddress());

			// 6. SQL 전송, 결과수신
			int count = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
	}

	@Override
	public void update(PatientDto dto) throws SQLException, RecordNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 등록여부검사
			if (findById(dto.getpId()) == null)
				throw new RecordNotFoundException(dto.getpId() + "는 없습니다");

			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "UPDATE PATIENT set name=?, birth=?, gender = ?, phone_number = ?, " + "address = ?";
			sql += "WHERE p_id = ?";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBirth());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getPhoneNumber());
			pstmt.setString(5, dto.getAddress());
			pstmt.setInt(6, dto.getpId());
			// 6. SQL 전송, 결과수신
			int count = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
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
				throw new RecordNotFoundException(id + "는 없습니다.");

			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "DELETE PATIENT ";
			sql += "WHERE p_id = ?";
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

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT COUNT(*) FROM PATIENT ";
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
	public List<PatientDto> list() throws SQLException {
		List<PatientDto> result = new ArrayList<PatientDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM PATIENT ORDER BY p_id";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			// 6. SQL 전송, 결과수신
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { // 조회 결과가 있다.
				int p_id = rs.getInt("p_id");
				String name = rs.getString("name");
				String birth = rs.getString("birth");
				String gender = rs.getString("gender");
				String phone_number = rs.getString("phone_number");
				String address = rs.getString("address");

				PatientDto dto = new PatientDto(p_id, name, birth, gender, phone_number, address);
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
	public PatientDto findById(int id) throws SQLException {
		PatientDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM PATIENT WHERE p_id = ?"; // id가 PK이므로 0 or 1개 나온다
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setInt(1, id);
			// 6. SQL 전송, 결과수신
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) { // 조회 결과가 있다.
				String name = rs.getString("name");
				String birth = rs.getString("birth");
				String gender = rs.getString("gender");
				String phone_number = rs.getString("phone_number");
				String address = rs.getString("address");

				dto = new PatientDto(id, name, birth, gender, phone_number, address);
			}

		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		return dto;
	}

}
