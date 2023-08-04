package hospital.dao;

import java.sql.SQLException;
import java.util.List;

import hospital.dto.PaymentDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;

public interface PaymentDao {
	// 수납정보 등록
	public void add(PaymentDto dto) throws SQLException, DuplicatedIdException;

	// 수납정보 수정
	public void update(PaymentDto dto) throws SQLException, RecordNotFoundException;

	// 수납정보 삭제
	public void delete(int id) throws SQLException, RecordNotFoundException;

	// 수납정보 수정
	public int count() throws SQLException;

	// 수납 목록
	public List<PaymentDto> list() throws SQLException;

	// 수납정보 검색
	public PaymentDto findById(int id) throws SQLException;
}
