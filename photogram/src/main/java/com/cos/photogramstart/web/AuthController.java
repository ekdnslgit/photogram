package com.cos.photogramstart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final이 써있는 모든 것들에 대한 생성자를 만들어준다, final 필드에 DI할 때 사용
@Controller // 1. IoC에 등록 한다. 2.파일을 리턴하는 컨트롤러
public class AuthController {
	
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private AuthService authService; // 전역변수에 final을 쓰면 객체가 만들어질 때 초기화를 무조건 해줘야한다?
	
	/*                                                                                       @RequiredArgsConstructor로 대신한다.
	 * public AuthController(AuthService authService) { this.authService =
	 * authService; }
	 */

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
		// log.info(signupDto.toString());
		// User <- SignupDto를 넣는다.
		User user = signupDto.toEntity();
		User userEntity = authService.회원가입(user);
		System.out.println(userEntity);
		// log.info(user.toString());
		return"auth/signin";
	}
}
