package com.mulcam.kb04;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mulcam.kb04.dto.BoardDto;

@Controller
public class JdbcController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/jt_insert_test")
	public String jt_insert_test() {

		String sql = "INSERT INTO BOARD(no, title, writer, content, regdate)";
		sql += "VALUES(BOARD_SEQ.NEXTVAL, ?,?,?, SYSDATE)";
		jdbcTemplate.update(sql, "jdbc test2", "jt1", "되는구나");
		System.out.println("jdbcTemplate.update OK");

		return "jt_insert_test";
	}

	@GetMapping("/jt_select_test")
	public String jt_select_test() {
		String sql = "select * from board order by no desc";
		List<BoardDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		System.out.println("list갯수 = " + list.size());
		return "jt_select_test";
	}

	@GetMapping("/ds_check")
	public String check() throws Exception {
		System.out.println("jdbcTemplate = " + jdbcTemplate);

		return "check";
	}

}
