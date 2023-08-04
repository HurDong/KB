package hospital.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospital.dto.PaymentDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;
import hospital.util.JdbcUtil;

public class PaymentDaoImpl implements PaymentDao {

	@Override
	public void add(PaymentDto dto) throws SQLException, DuplicatedIdException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 등록여부검사
			if (findById(dto.getPayId()) != null)
				throw new DuplicatedIdException(dto.getPayId() + "는 중복된 id입니다");

			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "INSERT INTO PAYMENT(pay_id, p_id, payment_date, payment_amount) ";
			sql += "VALUES(PAYMENT_SEQ.NEXTVAL, ?, SYSDATE, ?)";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setInt(1, dto.getpId());
			pstmt.setInt(2, dto.getPaymentAmount());

			// 6. SQL 전송, 결과수신
			int count = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}

	}

	@Override
	public void update(PaymentDto dto) throws SQLException, RecordNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 등록여부검사
			if (findById(dto.getPayId()) == null)
				throw new RecordNotFoundException(dto.getPayId() + "는 없는 수납정보입니다.");

			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "UPDATE PAYMENT SET p_id = ?, payment_date = SYSDATE, payment_amount = ? ";
			sql += "WHERE pay_id = ?";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			pstmt.setInt(1, dto.getpId());
			pstmt.setInt(2, dto.getPaymentAmount());
			pstmt.setInt(3, dto.getPayId());

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
			String sql = "DELETE PAYMENT ";
			sql += "WHERE pay_id = ?";
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
			String sql = "SELECT COUNT(*) FROM PAYMENT ";
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
	public List<PaymentDto> list() throws SQLException {
		List<PaymentDto> result = new ArrayList<PaymentDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			// 3. SQL 작성
			String sql = "SELECT * FROM PAYMENT ORDER BY pay_id DESC";
			// 4. Statement 생성
			pstmt = con.prepareStatement(sql);
			// 5. 데이터 설정
			// 6. SQL 전송, 결과수신
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { // 조회 결과가 있다.
				int pay_id = rs.getInt("pay_id");
				int p_id = rs.getInt("p_id");
				Date payment_date = rs.getDate("payment_date");
				int payment_amount = rs.getInt("payment_amount");

				PaymentDto dto = new PaymentDto(pay_id, p_id, payment_date, payment_amount);
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
	public PaymentDto findById(int id) throws SQLException {
		PaymentDto dto = null;

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
				int pay_id = rs.getInt("pay_id");
				int p_id = rs.getInt("p_id");
				Date payment_date = rs.getDate("payment_date");
				int payment_amount = rs.getInt("payment_amount");
				dto = new PaymentDto(pay_id, p_id, payment_date, payment_amount);
			}

		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt, con);
		}
		return dto;
	}

}
