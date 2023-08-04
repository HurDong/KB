package hospital.dao;

import java.sql.SQLException;
import java.util.List;

import hospital.dto.HospitalDepartmentDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;

public interface DepartmentDao {
	// 부서정보 등록
	public void add(HospitalDepartmentDto d) throws SQLException, DuplicatedIdException;

	// 부서정보 수정
	public void update(HospitalDepartmentDto d) throws SQLException, RecordNotFoundException;

	// 부서정보 삭제
	public void delete(int id) throws SQLException, RecordNotFoundException;

	// 부서정보 수정
	public int count() throws SQLException;

	// 부서 목록
	public List<HospitalDepartmentDto> list() throws SQLException;

	// 부서정보 검색
	public HospitalDepartmentDto findById(int id) throws SQLException;
}
