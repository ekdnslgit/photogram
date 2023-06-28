package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 1. IoC에 등록 한다. 2.파일을 리턴하는 컨트롤러
public class AuthController {

	@GetMapping("/auth/signup")
	public String signupForm() {
		return"auth/signup";
	}
	
	@GetMapping("/auth/signin")
	public String signinForm() {
		return"auth/signin";
	}
	
	// 회원가입 버튼 -> /auth/signup -> return"auth/signin"
	@PostMapping("/auth/signup")
	public String signup() {
		System.out.println("signup 실행됨?");
		return"auth/signin";
	}
}
