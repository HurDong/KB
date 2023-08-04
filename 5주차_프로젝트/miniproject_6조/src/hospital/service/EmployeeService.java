package hospital.service;

import java.util.List;

import hospital.dto.HospitalEmployeeDto;
import hospital.exception.EmployeeException;
import hospital.exception.RecordNotFoundException;

public interface EmployeeService {
	// 직원 등록
	public boolean add(HospitalEmployeeDto dto) throws EmployeeException;

	// 직원 목록
	public List<HospitalEmployeeDto> list() throws EmployeeException;

	// 직원정보 상세보기
	public HospitalEmployeeDto read(int no) throws EmployeeException, RecordNotFoundException;

	// 직원정보 수정
	public boolean update(HospitalEmployeeDto dto) throws EmployeeException, RecordNotFoundException;

	// 직원정보 삭제
	public boolean delete(int no) throws EmployeeException, RecordNotFoundException;

	// 직원수
	public int count() throws EmployeeException;
}
