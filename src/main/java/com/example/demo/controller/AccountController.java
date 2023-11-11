package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
	// 初期表示
	@GetMapping("/account")
	public String index() {
		return "accountForm";
	}
	
	@PostMapping("/account/confirm")
	public String confirm(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model) {
		// リクエストパラメータをスコープに登録
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		// 画面遷移
		return "accountConfirm";
	}
}
