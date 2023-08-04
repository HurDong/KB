package day_0802.dao;

import java.sql.SQLException;
import java.util.List;

import day_0802.vo.BoardDto;

public interface BoardDao {
	// 등록
	public void add(BoardDto dto) throws SQLException, DuplicatedIdException;

	// 수정
	public void update(BoardDto dto) throws SQLException, RecordNotFoundException;

	// 삭제
	public void delete(BoardDto dto) throws SQLException, RecordNotFoundException;

	// 갯수
	public void count() throws SQLException;

	// 목록
	public List<BoardDto> list() throws SQLException;

	// ID 검색
	public BoardDto findById(int no) throws SQLException, RecordNotFoundException;
}
