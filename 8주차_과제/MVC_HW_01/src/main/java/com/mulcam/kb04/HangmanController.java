package com.mulcam.kb04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class HangmanController {
	private String[] animalWords = { "cat", "dog", "elephant", "tiger", "lion" };

	@GetMapping("/hangman_form")
	public String hangman_form(HttpSession session, Model model) {
		String selectedWord = animalWords[new Random().nextInt(animalWords.length)];
		StringBuilder displayWord = new StringBuilder("_".repeat(selectedWord.length()));
		session.setAttribute("selectedWord", selectedWord);
		session.setAttribute("displayWord", displayWord.toString());
		session.setAttribute("attempts", 7);
		return "hangman/hangman_form";
	}

	@GetMapping(value = "/hangman_check", produces = "text/plain;charset=UTF-8")
	public String hangman_check(@RequestParam(value = "letter") char letter, HttpSession session, Model model) {
		letter = Character.toLowerCase(letter);
		String selectedWord = (String) session.getAttribute("selectedWord");
		StringBuilder displayWord = new StringBuilder((String) session.getAttribute("displayWord"));
		int attempts = (int) session.getAttribute("attempts");

		boolean found = false;
		for (int i = 0; i < selectedWord.length(); i++) {
			if (selectedWord.charAt(i) == letter) {
				displayWord.setCharAt(i, letter);
				found = true;
			}
		}

		if (!found) {
			attempts--;
		}

		session.setAttribute("attempts", attempts);
		session.setAttribute("displayWord", displayWord.toString());

		if (attempts == 0 && !displayWord.toString().equals(selectedWord)) {
			model.addAttribute("popupMessage", "Fail : 당신은 바보입니까?");
			return "redirect:/hangman_form";
		} else if (displayWord.toString().equals(selectedWord)) {
			model.addAttribute("popupMessage", "Success : 추카추카~ 똑똑한 사람입니다");
			return "redirect:/hangman_form";
		} else {
			model.addAttribute("displayWord", displayWord.toString());
			model.addAttribute("attempts", attempts);
			return "hangman/hangman_form";
		}
	}

}
