package com.cos.photogramstart.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.photogramstart.config.auth.PrincipalDetails;

@Controller
public class UserController {

	@GetMapping("/user/{id}")
	public String profile(@PathVariable int id) {
		return "user/profile";
	}
	
	@GetMapping("/user/{id}/update")
	public String update(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		// @AuthenticationPrincipal : 세션에 접근하기 위해 사용한다. (유저정보를 얻기 위해)
		System.out.println("세션 정보: "+ principalDetails.getUser());
		
		// Model.addAttribute("principal", principalDetails.getUser()); // principal은 접근주체, 인증주체라는 의미이다. 인증된 사용자에 사용
		return "user/update";
	}
	
}
