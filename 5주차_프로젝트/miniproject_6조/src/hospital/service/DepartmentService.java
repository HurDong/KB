package hospital.service;

import java.util.List;

import hospital.dto.HospitalDepartmentDto;
import hospital.exception.DepartmentException;
import hospital.exception.RecordNotFoundException;

public interface DepartmentService {
	// 부서 등록
	public boolean add(HospitalDepartmentDto dto) throws DepartmentException;

	// 부서 목록
	public List<HospitalDepartmentDto> list() throws DepartmentException;

	// 부서정보 상세보기
	public HospitalDepartmentDto read(int no) throws DepartmentException, RecordNotFoundException;

	// 부서정보 수정
	public boolean update(HospitalDepartmentDto dto) throws DepartmentException, RecordNotFoundException;

	// 부서정보 삭제
	public boolean delete(int no) throws DepartmentException, RecordNotFoundException;

	// 부서수
	public int count() throws DepartmentException;
}