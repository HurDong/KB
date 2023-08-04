package hospital.dao;

import java.sql.SQLException;
import java.util.List;

import hospital.dto.HospitalEmployeeDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;

public interface EmployeeDao {
	// 직원정보 등록
	public void add(HospitalEmployeeDto e) throws SQLException, DuplicatedIdException;

	// 직원정보 수정
	public void update(HospitalEmployeeDto e) throws SQLException, RecordNotFoundException;

	// 직원정보 삭제
	public void delete(int id) throws SQLException, RecordNotFoundException;

	// 직원정보 수정
	public int count() throws SQLException;

	// 직원 목록
	public List<HospitalEmployeeDto> list() throws SQLException;

	// 직원정보 검색
	public HospitalEmployeeDto findById(int id) throws SQLException;
}
