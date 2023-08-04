package hospital.dao;

import java.sql.SQLException;
import java.util.List;

import hospital.dto.HospitalizationDto;
import hospital.exception.DuplicatedIdException;
import hospital.exception.RecordNotFoundException;

public interface HospitalizationDao {
	// 입원정보 등록
	public void add(HospitalizationDto h) throws SQLException, DuplicatedIdException;

	// 입원정보 수정
	public void update(HospitalizationDto h) throws SQLException, RecordNotFoundException;

	// 입원정보 삭제
	public void delete(int id) throws SQLException, RecordNotFoundException;

	// 입원정보 수정
	public int count() throws SQLException;

	// 입원 목록
	public List<HospitalizationDto> list() throws SQLException;

	// 입원정보 검색
	public HospitalizationDto findById(int id) throws SQLException;
}
