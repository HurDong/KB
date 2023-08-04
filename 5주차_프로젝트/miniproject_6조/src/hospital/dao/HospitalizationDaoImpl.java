package hospital.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospital.dto.HospitalizationDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;
import hospital.util.JdbcUtil;

public class HospitalizationDaoImpl implements HospitalizationDao {

	@Override
	public void add(HospitalizationDto h) throws SQLException, DuplicatedIdException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 등록여부검사
			if (findById(h.gethId()) != null)
				throw new DuplicatedIdException(h.gethId() + "는 중복된 id입니다");

			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "INSERT INTO HOSPITALIZATION(h_id, p_id, doctor_id, room_number, admission_date, discharge_date) ";
			sql += "VALUES(HOSPITALIZATION_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setInt(1, h.getpId());
			pstmt.setInt(2, h.getDoctorId());
			pstmt.setString(3, h.getRoomNumber());
			pstmt.setDate(4, h.getAdmissionDate());
			pstmt.setDate(5, h.getDischargeDate());

			// 6. SQL 전송, 결과수신
			int count = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}

	}

	@Override
	public void update(HospitalizationDto h) throws SQLException, RecordNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 등록여부검사
			if (findById(h.gethId()) == null)
				throw new RecordNotFoundException(h.gethId() + "는 없는 입원정보입니다.");

			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "UPDATE HOSPITALIZATION SET doctor_id =?, room_number = ?, discharge_date = ? ";
			sql += "WHERE h_id = ?";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setInt(1, h.getDoctorId());
			pstmt.setString(2, h.getRoomNumber());
			pstmt.setDate(3, h.getDischargeDate());
			pstmt.setInt(4, h.gethId());

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
			String sql = "DELETE HOSPITALIZATION ";
			sql += "WHERE h_id = ?";
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
			String sql = "SELECT COUNT(*) FROM HOSPITALIZATION ";
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
	public List<HospitalizationDto> list() throws SQLException {
		List<HospitalizationDto> result = new ArrayList<HospitalizationDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM HOSPITALIZATION ORDER BY h_id DESC";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			// 6. SQL 전송, 결과수신
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { // 조회 결과가 있다.
				int h_id = rs.getInt("h_id");
				int p_id = rs.getInt("p_id");
				int doctor_id = rs.getInt("doctor_id");
				String room_number = rs.getString("room_number");
				Date admission_date = rs.getDate("admission_date");
				Date discharge_date = rs.getDate("discharge_date");

				HospitalizationDto dto = new HospitalizationDto(h_id, p_id, doctor_id, room_number, admission_date,
						discharge_date);
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
	public HospitalizationDto findById(int id) throws SQLException {
		HospitalizationDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM PAYMENT WHERE pay_id = ?"; // id가 PK이므로 0 or 1개 나온다
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setInt(1, id);
			// 6. SQL 전송, 결과수신
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) { // 조회 결과가 있다.
				int pay_id = rs.getInt("h_id");
				int p_id = rs.getInt("p_id");
				int doctor_id = rs.getInt("doctor_id");
				String room_number = rs.getString("room_number");
				Date admission_date = rs.getDate("admission_date");
				Date discharge_date = rs.getDate("discharge_date");
				dto = new HospitalizationDto(pay_id, p_id, doctor_id, room_number, admission_date, discharge_date);
			}

		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		return dto;
	}

}
