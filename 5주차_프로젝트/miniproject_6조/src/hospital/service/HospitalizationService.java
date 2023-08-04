package hospital.service;

import java.util.List;

import hospital.dto.HospitalizationDto;
import hospital.exception.HospitalizationException;
import hospital.exception.RecordNotFoundException;

public interface HospitalizationService {
	// 입원 등록
	public boolean add(HospitalizationDto dto) throws HospitalizationException;

	// 입원 목록
	public List<HospitalizationDto> list() throws HospitalizationException;

	// 입원정보 상세보기
	public HospitalizationDto read(int no) throws HospitalizationException, RecordNotFoundException;

	// 입원정보 수정
	public boolean update(HospitalizationDto dto) throws HospitalizationException, RecordNotFoundException;

	// 입원정보 삭제
	public boolean delete(int no) throws HospitalizationException, RecordNotFoundException;

	// 입원수
	public int count() throws HospitalizationException;
}
