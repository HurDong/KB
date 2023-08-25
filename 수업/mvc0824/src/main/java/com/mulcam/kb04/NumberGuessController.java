package com.mulcam.kb04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
/* 숫자 맞추기 게임용 컨트롤러 */
public class NumberGuessController {
	private int com_num = new java.util.Random().nextInt(100) + 1;

	@GetMapping("/number_form")
	public String number_form() {

		return "number_guess/number_form";
	}

	@GetMapping("/number_check")
	public String number_check(@RequestParam(value = "num") int num, Model model) {
		String result = num + " ";
		if (com_num == num)
			result += "추카추카, 정답입니다";
		else if (com_num > num)
			result += "숫자를 올려주세요";
		else
			result += "숫자를 내려주세요";
		model.addAttribute("result", result);
		return "number_guess/number_form";
	}
}
