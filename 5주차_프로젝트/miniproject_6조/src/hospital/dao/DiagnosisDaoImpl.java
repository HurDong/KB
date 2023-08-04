package hospital.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospital.dto.DiagnosisDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;
import hospital.util.JdbcUtil;

public class DiagnosisDaoImpl implements DiagnosisDao {

	@Override
	public void add(DiagnosisDto dto) throws SQLException, DuplicatedIdException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			if (findById(dto.getDiaId()) != null)
				throw new DuplicatedIdException(dto.getDiaId() + "는 이미 존재하는 진료입니다");

			con = JdbcUtil.connect();

			String sql = "insert into Diagnosis(diagnosis_number, doctor_id, p_id, diagnosis_date, diagnosis_contents) ";
			sql += "values(Diagnosis_seq.nextval, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, dto.getDoctorId());
			pstmt.setInt(2, dto.getpId());
			pstmt.setDate(3, dto.getDiagnosisDate());
			pstmt.setString(4, dto.getDiagnosisContents());

			int count = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
	}

	@Override
	public void update(DiagnosisDto d) throws SQLException, RecordNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			if (findById(d.getDiaId()) == null)
				throw new RecordNotFoundException(d.getDiaId() + "는 없습니다");

			con = JdbcUtil.connect();

			String sql = "update Diagnosis set diagnosis_number =?,doctor_id =?,p_id=?,diagnosis_date=?,diagnosis_contents=? ";
			sql += "where diagnosis_number = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, d.getDoctorId());
			pstmt.setInt(2, d.getpId());
			pstmt.setDate(3, d.getDiagnosisDate());
			pstmt.setString(4, d.getDiagnosisContents());
			pstmt.setInt(5, d.getDiaId());

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
			if (findById(id) == null)
				throw new RecordNotFoundException(id + "는 없습니다");
			con = JdbcUtil.connect();

			String sql = "delete Diagnosis where diagnosis_number = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, id);

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

			String sql = "select count(*) from Diagnosis";

			pstmt = con.prepareStatement(sql);

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
	public List<DiagnosisDto> list() throws SQLException {
		List<DiagnosisDto> result = new ArrayList<DiagnosisDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM Diagnosis ORDER BY Diagnosis_number";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			// 6. SQL 전송, 결과수신
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { // 조회 결과가 있다.
				int diagnosis_number = rs.getInt("diagnosis_number");
				int doctor_id = rs.getInt("doctor_id");
				int p_id = rs.getInt("p_id");
				Date diagnosis_date = rs.getDate("diagnosis_date");
				String diagnosis_contents = rs.getString("diagnosis_contents");
				DiagnosisDto dto = new DiagnosisDto(diagnosis_number, doctor_id, p_id, diagnosis_date,
						diagnosis_contents);
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
	public DiagnosisDto findById(int id) throws SQLException {
		DiagnosisDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM Diagnosis WHERE diagnosis_number = ?"; // id가 PK이므로 0 or 1개 나온다
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setInt(1, id);
			// 6. SQL 전송, 결과수신
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) { // 조회 결과가 있다.
				int diagnosis_number = rs.getInt("diagnosis_number");
				int doctor_id = rs.getInt("doctor_id");
				int p_id = rs.getInt("p_id");
				Date diagnosis_date = rs.getDate("diagnosis_date");
				String diagnosis_contents = rs.getString("diagnosis_contents");
				dto = new DiagnosisDto(diagnosis_number, doctor_id, p_id, diagnosis_date, diagnosis_contents);
			}

		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		return dto;
	}

}
