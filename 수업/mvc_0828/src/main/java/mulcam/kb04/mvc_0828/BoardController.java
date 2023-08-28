package mulcam.kb04.mvc_0828;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mybatis.dto.BoardDto;

@Controller
public class BoardController {
	@Autowired
	private SqlSession sqlSession;

	String ns = "config.BoardMapper.";

	@GetMapping("/board_list")
	public String board_list(Model model) {
		List<BoardDto> list = sqlSession.selectList(ns + "selectAll");
		model.addAttribute("board_list", list);
		return "board/list";
	}

	@GetMapping("/board_insert_form")
	public String board_insert_form() {
		return "board/board_insert_form";
	}

	@PostMapping("/board_insert_action")
	public String board_insert(@RequestParam("title") String title, @RequestParam("writer") String writer,
			@RequestParam("content") String content) {
		BoardDto dto = new BoardDto();
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);

		sqlSession.insert(ns + "insert", dto);

		return "redirect:/board_list";
	}

	@GetMapping("/board_detail")
	public String boardDetail(@RequestParam("no") int no, Model model) {
		BoardDto board = sqlSession.selectOne(ns + "select", no);

		model.addAttribute("board", board);

		return "board/board_detail";
	}

}
