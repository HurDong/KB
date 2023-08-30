package mulcam.kb04.mvc_0830;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@GetMapping("/api/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/api/greet/{name}")
	public Map<String, String> greet(@PathVariable("name") String name) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		return map;
	}

	// 등록, 목록, 검색, 수정, 삭제

//	@GetMapping("/api/boards")
//	public List<BoardDto> boards() {
//		List<BoardDto> result = boardMapper.list();
//		return result;
//	}

	private int com_num = new java.util.Random().nextInt(100) + 1;

	@GetMapping("/check_number.ng")
	public HashMap<String, Object> check_number(@RequestParam int no) {
		String msg = no + ":";
		int code = -999;
		if (com_num < no) {
			msg += "낮춰주세요";
			code = -1;
		} else if (com_num > no) {
			msg += "높여주세요";
			code = 1;
		} else {
			msg += "정답입니다";
			code = 0;
			// 새로운 난수로 지정
			com_num = new java.util.Random().nextInt(100) + 1;
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("msg", msg);
		map.put("code", code);
		return map;
	}

	@GetMapping("/today_lotto")
	public List<Integer> today_lotto() {
		List<Integer> result = new ArrayList<Integer>();
		while (result.size() < 6) {
			int r = new java.util.Random().nextInt(45) + 1;
			if (!result.contains(r)) {
				result.add(r);
			}
		}
		return result;
	}

}