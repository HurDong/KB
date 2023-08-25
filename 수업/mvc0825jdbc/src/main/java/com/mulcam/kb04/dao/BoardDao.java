package com.mulcam.kb04.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mulcam.kb04.dto.BoardDto;

@Component
public class BoardDao {
	@Autowired
	private JdbcTemplate jdbcTpl;

	public void insert(BoardDto dto) {
		String sql = "insert into board(no,title,writer,content,regdate)";
		sql += "values(board_seq.nextval,?,?,?,sysdate)";
		jdbcTpl.update(sql, dto.getTitle(), dto.getWriter(), dto.getContent());
	}

	public List<BoardDto> list() {
		String sql = "select * from board order by no desc";
		List<BoardDto> list = jdbcTpl.query(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		return list;
	}

	public BoardDto findByNo(int no) {
		String sql = "select * from board where no = ?";
		BoardDto dto = jdbcTpl.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class), no);
		return dto;
	}
}
