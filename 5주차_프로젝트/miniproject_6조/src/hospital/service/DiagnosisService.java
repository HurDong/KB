package hospital.service;

import java.util.List;

import hospital.dto.DiagnosisDto;
import hospital.exception.DiagnosisException;
import hospital.exception.RecordNotFoundException;

public interface DiagnosisService {
	// 진료 정보 등록
	public boolean add(DiagnosisDto dto) throws DiagnosisException;

	// 진료 정보 목록
	public List<DiagnosisDto> list() throws DiagnosisException;

	// 진료 정보 상세보기
	public DiagnosisDto read(int no) throws DiagnosisException, RecordNotFoundException;

	// 진료 정보 수정
	public boolean update(DiagnosisDto dto) throws DiagnosisException, RecordNotFoundException;

	// 진료 정보 삭제
	public boolean delete(int no) throws DiagnosisException, RecordNotFoundException;

	// 진료 수
	public int count() throws DiagnosisException;
}
