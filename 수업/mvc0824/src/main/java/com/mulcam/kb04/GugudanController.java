package com.mulcam.kb04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GugudanController {

	@GetMapping("/gugudan")
	public String number_form() {

		return "gugudan/gugudan";
	}

	@GetMapping("/gugudan_view")
	public String gugudan_view(@RequestParam(value = "num") int num, Model model) {
		String result = "";
		for (int i = 1; i <= 9; i++) {
			result += num + " * " + i + " = " + num * i + "<br>";
		}
		model.addAttribute("result", result);
		return "gugudan/gugudan";
	}
}
