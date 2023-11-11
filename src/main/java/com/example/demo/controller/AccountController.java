package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

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
		// 入力値チェック
		List<String> errorList = new ArrayList<String>();
		// 名前の必須入力チェック
		if (name == null || name.isEmpty()) {
			// 未入力の場合：nullまたは空文字列
			errorList.add("名前は必須です");
		}
		// 名前の文字数チェック
		if (name.length() > 20) {
			// 名前が20文字超えの場合
			errorList.add("名前は20文字以内です");
		}
		// メールアドレスの必須入力チェック
		if (email == null || email.isEmpty()) {
			// 未入力の場合：nullまたは空文字列
			errorList.add("メールアドレスは必須です");
		}
		// パスワードの必須入力チェック
		if (password == null || password.isEmpty()) {
			// 未入力の場合：nullまたは空文字列
			errorList.add("パスワードは必須です");
		}
		
		// エラーチェックの結果の評価
		if (errorList.size() > 0) {
			// エラーがある場合
			model.addAttribute("errorList", errorList);
			// 画面遷移
			return "accountForm";
		}
		
		// リクエストパラメータをスコープに登録
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		// 画面遷移
		return "accountConfirm";
	}
}
