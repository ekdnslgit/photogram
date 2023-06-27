package com.cos.controllerdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HttpRedirectionController {

	@GetMapping("/home")
	public String home() {
		// 1만 줄이 있다고 가정
		return "home";
		
	}
	
	@GetMapping("/away")
	public String away() {
		// 다른코드    위쪽의 1만 줄의 코드를 재사용하는 예제이다.
		return "redirect:/home"; // 리다이렉션이 된다. (@Controller를 사용해야하고 @RestController는 작동 안한다.)
		
	}
	
}
