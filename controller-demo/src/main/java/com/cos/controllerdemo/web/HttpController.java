package com.cos.controllerdemo.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller // File을 응답하는 컨트롤러(클라우드가 브라우저면 .html 파일을 응답)
@RestController // data를 응답하는 컨트롤러(클라우드가 핸드폰이면 data를 응답)
public class HttpController {

	@GetMapping("/get") // 요청
	public String get() {
		return "<h1>get요청됨</h1>"; // Controller를 사용하면 파일 이름이 된다.
	}
	@PostMapping("/post") // 전송
	public String post() {
		return "post요청됨";
	}
	@PutMapping("/put") // 갱신
	public String put() {
		return "put요청됨";
	}
	@DeleteMapping("delete") // 삭제
	public String delete() {
		return "delete요청됨";
	}
}
	
	
