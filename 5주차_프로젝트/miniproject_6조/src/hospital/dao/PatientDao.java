package hospital.dao;

import java.sql.SQLException;
import java.util.List;

import hospital.dto.PatientDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;

public interface PatientDao {
	// 환자정보 등록
	public void add(PatientDto p) throws SQLException, DuplicatedIdException;

	// 환자정보 수정
	public void update(PatientDto p) throws SQLException, RecordNotFoundException;

	// 환자정보 삭제
	public void delete(int id) throws SQLException, RecordNotFoundException;

	// 환자정보 수정
	public int count() throws SQLException;

	// 환자 목록
	public List<PatientDto> list() throws SQLException;

	// 환자정보 검색
	public PatientDto findById(int id) throws SQLException;
}
