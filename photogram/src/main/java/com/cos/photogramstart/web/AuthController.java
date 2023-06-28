package com.cos.photogramstart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.web.dto.auth.SignupDto;

@Controller // 1. IoC에 등록 한다. 2.파일을 리턴하는 컨트롤러
public class AuthController {
	
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);


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
	public String signup(SignupDto signupDto) { // key=value (x-www-form-urlencoded)
		log.info(signupDto.toString());
		return"auth/signin";
	}
}
