package hospital.dao;

import java.sql.SQLException;
import java.util.List;

import hospital.dto.DiagnosisDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;

public interface DiagnosisDao {
	// 진료 정보 등록
	public void add(DiagnosisDto dto) throws SQLException, DuplicatedIdException;

	// 진료 정보 수정
	public void update(DiagnosisDto d) throws SQLException, RecordNotFoundException;

	// 진료 정보 삭제
	public void delete(int id) throws SQLException, RecordNotFoundException;

	// 진료 수
	public int count() throws SQLException;

	// 진료 목록
	public List<DiagnosisDto> list() throws SQLException;

	// 진료 정보 검색
	public DiagnosisDto findById(int id) throws SQLException;

}
