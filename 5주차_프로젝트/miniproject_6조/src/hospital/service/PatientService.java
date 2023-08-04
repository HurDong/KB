package hospital.service;

import java.util.List;

import hospital.dto.PatientDto;
import hospital.exception.PatientException;
import hospital.exception.RecordNotFoundException;

public interface PatientService {
	// 환자 등록
	public boolean add(PatientDto dto) throws PatientException;

	// 환자 목록
	public List<PatientDto> list() throws PatientException; // 서버오류

	// 환자정보 상세보기
	public PatientDto read(int no) throws PatientException, RecordNotFoundException;

	// 환자정보 수정
	public boolean update(PatientDto dto) throws PatientException, RecordNotFoundException;

	// 환자정보 삭제
	public boolean delete(int no) throws PatientException, RecordNotFoundException;

	// 환자수
	public int count() throws PatientException;
}
