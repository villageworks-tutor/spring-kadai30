package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
	// 初期表示
	@GetMapping("/account")
	public String index() {
		return "accountForm";
	}
	
	@PostMapping("/account/confirm")
	public String confirm() {
		return "accountConfirm";
	}
}
