package hospital.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospital.dto.ReservationDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;
import hospital.util.JdbcUtil;

public class ReservationDaoImpl implements ReservationDao {
	@Override
	public void add(ReservationDto r) throws SQLException, DuplicatedIdException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 등록여부검사
			if (findById(r.getrId()) != null)
				throw new DuplicatedIdException(r.getrId() + "는 이미 존재하는 예약입니다.");

			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "INSERT INTO RESERVATION(r_id, doctor_id, p_id, reservation_date, reservation_time) ";
			sql += "VALUES(RESERVATION_SEQ.NEXTVAL, ?, ?, ?, ?)";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setInt(1, r.getDoctorId());
			pstmt.setInt(2, r.getpId());
			pstmt.setDate(3, r.getReservationDate());
			pstmt.setString(4, r.getReservationTime());

			// 6. SQL 전송, 결과수신
			int count = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
	}

	@Override
	public void update(ReservationDto dto) throws SQLException, RecordNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 등록여부검사
			if (findById(dto.getrId()) == null)
				throw new RecordNotFoundException(dto.getrId() + "는 없습니다");

			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "UPDATE reservation set doctor_id=?, p_id=?, reservation_date= ?, reservation_time= ? ";
			sql += "WHERE r_id = ?";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setInt(1, dto.getDoctorId());
			pstmt.setInt(2, dto.getpId());
			pstmt.setDate(3, dto.getReservationDate());
			pstmt.setString(4, dto.getReservationTime());
			pstmt.setInt(5, dto.getrId());
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
			String sql = "DELETE reservation ";
			sql += "WHERE r_id = ?";
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
			String sql = "SELECT COUNT(*) FROM reservation ";
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
	public List<ReservationDto> list() throws SQLException {
		List<ReservationDto> result = new ArrayList<ReservationDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM reservation ORDER BY r_id";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			// 6. SQL 전송, 결과수신
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { // 조회 결과가 있다.
				int r_id = rs.getInt("r_id");
				int doctor_id = rs.getInt("doctor_id");
				int p_id = rs.getInt("p_id");
				Date reservation_date = rs.getDate("reservation_date");
				String reservation_time = rs.getString("reservation_time");
				ReservationDto dto = new ReservationDto(r_id, doctor_id, p_id, reservation_date, reservation_time);
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
	public ReservationDto findById(int id) throws SQLException {
		ReservationDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM reservation WHERE r_id = ?"; // id가 PK이므로 0 or 1개 나온다
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setInt(1, id);
			// 6. SQL 전송, 결과수신
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) { // 조회 결과가 있다.
				int r_id = rs.getInt("r_id");
				int doctor_id = rs.getInt("doctor_id");
				int p_id = rs.getInt("p_id");
				Date reservation_date = rs.getDate("reservation_date");
				String reservation_time = rs.getString("reservation_time");
				dto = new ReservationDto(r_id, doctor_id, p_id, reservation_date, reservation_time);
			}

		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		return dto;
	}

}