package hospital.dao;

import java.sql.SQLException;
import java.util.List;

import hospital.dto.ReservationDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;

public interface ReservationDao { 
	// 예약정보 등록
	public void add(ReservationDto e) throws SQLException, DuplicatedIdException;

	// 예약정보 수정
	public void update(ReservationDto e) throws SQLException, RecordNotFoundException;

	// 예약정보 삭제
	public void delete(int id) throws SQLException, RecordNotFoundException;

	// 예약정보 수정
	public int count() throws SQLException;

	// 예약 목록
	public List<ReservationDto> list() throws SQLException;

	// 예약정보 검색
	public ReservationDto findById(int id) throws SQLException;
}
