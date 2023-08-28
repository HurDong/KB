package mulcam.kb04.mvc_0828;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import mybatis.dto.BoardDto;

@Controller
public class JdbcController {
	@Autowired
	private DataSource dataSource;

	@Autowired
	private SqlSession sqlSession;

	String ns = "config.BoardMapper.";

	@GetMapping("/sqlSession_test")
	public String sqlSession_test() {
		List<BoardDto> list = sqlSession.selectList(ns + "selectAll");
		System.out.println("list = " + list);

		return "jdbc_test";
	}

	@GetMapping("/sqlSession_insert")
	public String sqlSession_insert() {
		BoardDto dto = new BoardDto(0, "ss 등록테스트", "ss01", "ss통한 등록", null);
		sqlSession.insert(ns + "insert", dto);
		return "sqlSession_insert";
	}

	@GetMapping("/jdbc_test")
	public String jdbc_test() {
		System.out.println("dataSource = " + dataSource);
		return "jdbc_test";
	}
}